/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.command.dev.structure;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.matez.wildnature.common.block.rocks.RockType;
import net.matez.wildnature.common.command.arguments.WNStructurePathArgument;
import net.matez.wildnature.common.structures.WNStructure;
import net.matez.wildnature.common.structures.WNStructures;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.common.command.IWNCommand;
import net.matez.wildnature.api.client.chat.ChatHelper;
import net.matez.wildnature.api.util.ExtraMath;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PoweredRailBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.chunk.LevelChunk;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class WNCommandDevStructureLoadAll implements IWNCommand {
    private static final String PASS = "dupa.8";
    private boolean working = false;

    @Override
    public void register(LiteralArgumentBuilder<CommandSourceStack> stack, CommandDispatcher<CommandSourceStack> dispatcher) {
        var loadAll = Commands.literal("loadAll");
        loadAll.then(Commands.argument("security_password", StringArgumentType.string()).executes(context -> {
            String pass = StringArgumentType.getString(context, "security_password");
            if (!pass.equals(PASS)) {
                ChatHelper.respond(context, false, "Security password is incorrect.");
                return 0;
            }

            return load(context, context.getSource().getPlayerOrException(), null, null) ? 1 : 0;
        }).then(Commands.literal("type").then(Commands.argument("type", StringArgumentType.string()).executes(context -> {
            String pass = StringArgumentType.getString(context, "security_password");
            String type = StringArgumentType.getString(context, "type");
            if (!pass.equals(PASS)) {
                ChatHelper.respond(context, false, "Security password is incorrect.");
                return 0;
            }

            return load(context, context.getSource().getPlayerOrException(), type, null) ? 1 : 0;
        }))).then(Commands.literal("path").then(Commands.argument("path", WNStructurePathArgument.path()).executes(context -> {
            String pass = StringArgumentType.getString(context, "security_password");
            var path = WNStructurePathArgument.getValidator(context, "path");

            if (!pass.equals(PASS)) {
                ChatHelper.respond(context, false, "Security password is incorrect.");
                return 0;
            }

            return load(context, context.getSource().getPlayerOrException(), null, path) ? 1 : 0;
        }))));

        stack.then(loadAll);
    }

    private boolean load(CommandContext<CommandSourceStack> context, ServerPlayer player, @Nullable String type, @Nullable WNStructurePathArgument.PathValidator path) {
        if (!player.getLevel().isFlat()) {
            ChatHelper.respond(context, false, "You can load all structures only on flat worlds.");
            return false;
        }
        if (working) {
            ChatHelper.respond(context, false, "Placing structures is already in progress.");
            return false;
        }
        working = true;
        var direction = player.getDirection();
        BlockPos startPos = player.getOnPos().above();

        var thread = new Thread(() -> {
            BlockPos nextPos = startPos.relative(direction.getClockWise(), 3);
            AtomicInteger blocks = new AtomicInteger();
            AtomicInteger structures = new AtomicInteger();

            int started = 0;
            int roadTotal = 0;

            for (WNStructure structure : WNStructures.STRUCTURES.values()) {
                String sType = structure.getType();
                if (type != null && !Objects.equals(sType, type)) {
                    continue;
                }
                if (path != null && !path.isIn(structure)) {
                    continue;
                }

                started++;
                BlockState cornerBlock = getCornerBlock(structure.getLocation().getNamespace() + ":" + (structure.getType() == null ? "null" : structure.getType()));

                int length = 0;
                BlockPos platformMin = null, platformMax = null;

                Rotation sRot = Rotation.NONE;
                BlockPos min = structure.getMin();
                BlockPos max = structure.getMax();

                if (min == null || max == null) {
                    ChatHelper.respond(context, false, "Unable to spawn structure &v" + structure.getLocation() + "&r.");
                    continue;
                }

                min = min.offset(-2, -2, -2);
                max = max.offset(2, 2, 2);

                BlockPos centerOffset = BlockPos.ZERO;

                for (Rotation rotation : Rotation.values()) {
                    platformMin = nextPos;
                    platformMax = new BlockPos(Math.abs(min.getX()) + max.getX(), platformMin.getY(), Math.abs(min.getZ()) + max.getZ()).rotate(rotation).offset(new BlockPos(platformMin.getX(), 0, platformMin.getZ()));

                    centerOffset = new BlockPos(-(max.getX() + min.getX()) / 2, 0, -(max.getZ() + min.getZ()) / 2).rotate(rotation);


                    int xDiff = platformMax.getX() - platformMin.getX();
                    int zDiff = platformMax.getZ() - platformMin.getZ();

                    boolean valid = switch (direction) {
                        case NORTH -> xDiff >= 1 && zDiff <= -1;
                        case EAST -> xDiff >= 1 && zDiff >= 1;
                        case SOUTH -> xDiff <= -1 && zDiff >= 1;
                        case WEST -> xDiff <= -1 && zDiff <= -1;
                        default -> false;
                    };

                    if (valid) {
                        sRot = rotation;
                        break;
                    }
                }

                assert platformMin != null;
                BlockPos fixedPlatformMin = new BlockPos(Math.min(platformMin.getX(), platformMax.getX()), platformMin.getY(), Math.min(platformMin.getZ(), platformMax.getZ()));
                BlockPos fixedPlatformMax = new BlockPos(Math.max(platformMin.getX(), platformMax.getX()), platformMin.getY(), Math.max(platformMin.getZ(), platformMax.getZ()));

                //find the structure length at given direction to find next structure position
                if (direction.getAxis() == Direction.Axis.X) {
                    length = (fixedPlatformMax.getX() + 1) - (fixedPlatformMin.getX() - 1);
                } else {
                    length = (fixedPlatformMax.getZ() + 1) - (fixedPlatformMin.getZ() - 1);
                }

                BlockPos centerPos = new BlockPos(fixedPlatformMin.getX() + (fixedPlatformMax.getX() - fixedPlatformMin.getX()) / 2, nextPos.getY(), fixedPlatformMin.getZ() + (fixedPlatformMax.getZ() - fixedPlatformMin.getZ()) / 2).offset(centerOffset);

                //next is away of 3 blocks from before
                BlockPos signPos = nextPos.relative(direction, -1);

                nextPos = nextPos.relative(direction, length + 3);

                {
                    //fill road
                    for (int i = 0; i < length + 3; i++) {
                        BlockPos pos = platformMin.relative(direction.getCounterClockWise(), 4).relative(direction, i).below();
                        for (int j = 0; j < 4; j++) {
                            BlockState state = WNBlocks.ROCKS_POLISHED.get(RockType.GNEISS).defaultBlockState();
                            if (j == 0) {
                                state = WNBlocks.ROCKS_POLISHED.get(RockType.BASANITE).defaultBlockState();
                                if (roadTotal % 8 == 0) {
                                    state = Blocks.REDSTONE_BLOCK.defaultBlockState();
                                }
                            }
                            if (j == 2 && roadTotal % 4 == 0) {
                                state = Blocks.GLOWSTONE.defaultBlockState();
                            }
                            player.getLevel().setBlock(pos.relative(direction.getClockWise(), j), state, 2);
                            if (j == 0) {
                                player.getLevel().setBlock(pos.relative(direction.getClockWise(), j).above(), Blocks.POWERED_RAIL.defaultBlockState().setValue(PoweredRailBlock.POWERED, true).setValue(PoweredRailBlock.SHAPE, direction == Direction.SOUTH || direction == Direction.NORTH ? RailShape.NORTH_SOUTH : RailShape.EAST_WEST), 2);
                            }
                        }
                        roadTotal++;
                    }

                    //fill platform
                    for (int x = fixedPlatformMin.getX(); x <= fixedPlatformMax.getX(); x++) {
                        for (int y = fixedPlatformMin.getY(); y <= fixedPlatformMax.getY(); y++) {
                            for (int z = fixedPlatformMin.getZ(); z <= fixedPlatformMax.getZ(); z++) {
                                BlockPos pos = new BlockPos(x, y, z);
                                BlockState state = Blocks.GRASS_BLOCK.defaultBlockState();

                                if (pos.equals(centerPos)) {
                                    state = WNBlocks.DEV_STRUCTURE_CENTER.defaultBlockState();
                                } else {
                                    if (pos.getX() == fixedPlatformMin.getX() || pos.getZ() == fixedPlatformMin.getZ() || pos.getX() == fixedPlatformMax.getX() || pos.getZ() == fixedPlatformMax.getZ()) {
                                        state = cornerBlock;

                                        if (
                                                (pos.getX() == fixedPlatformMin.getX() && pos.getZ() == fixedPlatformMin.getZ()) ||
                                                        (pos.getX() == fixedPlatformMax.getX() && pos.getZ() == fixedPlatformMax.getZ()) ||
                                                        (pos.getX() == fixedPlatformMax.getX() && pos.getZ() == fixedPlatformMin.getZ()) ||
                                                        (pos.getX() == fixedPlatformMin.getX() && pos.getZ() == fixedPlatformMax.getZ())
                                        ) {
                                            state = Blocks.SHROOMLIGHT.defaultBlockState();
                                        }
                                    }
                                }

                                player.getLevel().setBlock(pos, state, 2);
                                blocks.getAndIncrement();
                            }
                        }
                    }
                    //place sign
                    player.getLevel().setBlockAndUpdate(signPos, Blocks.BIRCH_WALL_SIGN.defaultBlockState().setValue(WallSignBlock.FACING, direction.getOpposite()));
                    var entity = ((LevelChunk) player.getLevel().getChunk(signPos)).getBlockEntity(signPos, LevelChunk.EntityCreationType.IMMEDIATE);
                    if (entity instanceof SignBlockEntity signEntity) {
                        signEntity.setMessage(0, new TextComponent("-- #" + structures.get() + " --").withStyle(ChatHelper.format(ChatHelper.GRAY_COLOR)));

                        String msg = structure.getName();
                        if (msg.length() > 14) {
                            if (msg.length() > 28) {
                                signEntity.setMessage(1, new TextComponent(msg.substring(0, 14)).withStyle(ChatHelper.format(ChatHelper.SIGN_ACCENT)));
                                signEntity.setMessage(2, new TextComponent(msg.substring(14, 28)).withStyle(ChatHelper.format(ChatHelper.SIGN_ACCENT)));
                                signEntity.setMessage(3, new TextComponent(msg.substring(28)).withStyle(ChatHelper.format(ChatHelper.SIGN_ACCENT)));
                            } else {
                                signEntity.setMessage(1, new TextComponent(msg.substring(0, 14)).withStyle(ChatHelper.format(ChatHelper.SIGN_ACCENT)));
                                signEntity.setMessage(2, new TextComponent(msg.substring(14)).withStyle(ChatHelper.format(ChatHelper.SIGN_ACCENT)));
                            }
                        } else {
                            signEntity.setMessage(1, new TextComponent(msg).withStyle(ChatHelper.format(ChatHelper.SIGN_ACCENT)));
                        }
                    }

                    //place structure
                    structure.place(player.getLevel(), centerPos, sRot, player.getLevel().getRandom(), 2);
                    blocks.getAndAdd(structure.getBlockAmount() + 1);
                }

                structures.getAndIncrement();
            }

            ChatHelper.respond(context, true, "Placed &v" + structures.get() + "&r/&v" + started + "&r structures filling &v" + blocks.get() + "&r blocks.");

            working = false;
        });
        thread.setName("StructureLoaderThread");
        thread.start();


        return true;
    }

    private BlockState getCornerBlock(String type) {
        int seed = 0;
        for (int i = 0; i < type.length(); i++) {
            char c = type.charAt(i);
            seed += (int) c;
        }

        Random random = new Random(seed);
        return (switch (ExtraMath.rint(0, 16, random)) {
            default -> Blocks.TERRACOTTA;
            case 1 -> Blocks.WHITE_TERRACOTTA;
            case 2 -> Blocks.ORANGE_TERRACOTTA;
            case 3 -> Blocks.MAGENTA_TERRACOTTA;
            case 4 -> Blocks.LIGHT_BLUE_TERRACOTTA;
            case 5 -> Blocks.YELLOW_TERRACOTTA;
            case 6 -> Blocks.LIME_TERRACOTTA;
            case 7 -> Blocks.PINK_TERRACOTTA;
            case 8 -> Blocks.GRAY_TERRACOTTA;
            case 9 -> Blocks.LIGHT_GRAY_TERRACOTTA;
            case 10 -> Blocks.CYAN_TERRACOTTA;
            case 11 -> Blocks.PURPLE_TERRACOTTA;
            case 12 -> Blocks.BLUE_TERRACOTTA;
            case 13 -> Blocks.BROWN_TERRACOTTA;
            case 14 -> Blocks.GREEN_TERRACOTTA;
            case 15 -> Blocks.RED_TERRACOTTA;
            case 16 -> Blocks.BLACK_TERRACOTTA;
        }).defaultBlockState();
    }
}
