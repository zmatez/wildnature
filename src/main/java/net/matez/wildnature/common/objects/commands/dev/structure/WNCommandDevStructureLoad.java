/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.commands.dev.structure;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.matez.wildnature.common.objects.commands.arguments.WNStructureArgument;
import net.matez.wildnature.common.objects.structures.WNStructure;
import net.matez.wildnature.common.registry.commands.IWNCommand;
import net.matez.wildnature.common.util.WNChatUtil;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Rotation;
import net.minecraftforge.server.command.EnumArgument;

import javax.annotation.Nullable;

public class WNCommandDevStructureLoad implements IWNCommand {
    @Override
    public void register(LiteralArgumentBuilder<CommandSourceStack> stack, CommandDispatcher<CommandSourceStack> dispatcher) {
        var load = Commands.literal("load");
        load.then(Commands.argument("name", WNStructureArgument.structure()).executes(context -> {
            WNStructure structure = WNStructureArgument.getStructure(context, "name");

            return load(context, context.getSource().getPlayerOrException(), structure, new BlockPos(context.getSource().getPosition()), null) ? 1 : 0;
        }).then(Commands.argument("position", BlockPosArgument.blockPos()).executes((context -> {
            WNStructure structure = WNStructureArgument.getStructure(context, "name");
            BlockPos pos = BlockPosArgument.getLoadedBlockPos(context, "position");

            return load(context, context.getSource().getPlayerOrException(), structure, pos, null) ? 1 : 0;
        })).then(Commands.argument("rotation", EnumArgument.enumArgument(Rotation.class)).executes((context -> {
            WNStructure structure = WNStructureArgument.getStructure(context, "name");
            BlockPos pos = BlockPosArgument.getLoadedBlockPos(context, "position");
            Rotation rotation = context.getArgument("rotation", Rotation.class);

            return load(context, context.getSource().getPlayerOrException(), structure, pos, rotation) ? 1 : 0;
        })))));

        stack.then(load);
    }


    private boolean load(CommandContext<CommandSourceStack> context, ServerPlayer player, WNStructure structure, BlockPos pos, @Nullable Rotation rotation) {
        structure.place(context.getSource().getLevel(), pos, rotation, player.getLevel().getRandom(), 2);
        WNChatUtil.respond(context, true, "Placed structure &v" + structure.getLocation().toString() + "&r at &x" + pos.getX() + " " + pos.getY() + " " + pos.getZ() + "&r filling &v" + structure.getBlockAmount() + "&r blocks.");

        return true;
    }
}
