/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.command.dev.structure;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.matez.wildnature.common.structures.dev.server.WNDevServerStructureManager;
import net.matez.wildnature.common.command.IWNCommand;
import net.matez.wildnature.core.registry.WNItems;
import net.matez.wildnature.api.client.chat.ChatHelper;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class WNCommandDevStructureSel implements IWNCommand {
    @Override
    public void register(LiteralArgumentBuilder<CommandSourceStack> stack, CommandDispatcher<CommandSourceStack> dispatcher) {
        var sel = Commands.literal("sel");
        sel.then(Commands.literal("wand").executes(context -> {
            context.getSource().getPlayerOrException().addItem(new ItemStack(WNItems.DEVSTICK, 1));
            ChatHelper.respond(context, true, "You got the selection wand. Use &vPPM&r and &vLPM&r to select points, then save your structure with &v/wn dev struct save");
            return 1;
        }));
        sel.then(Commands.literal("clear").executes(context -> {
            if (WNDevServerStructureManager.delete(context.getSource().getPlayerOrException())) {
                ChatHelper.respond(context, true, "Selection cleared");
                return 1;
            }
            ChatHelper.respond(context, false, "No selection found");
            return 0;
        }));
        sel.then(Commands.literal("analyze").executes(context -> {
            var struct = WNDevServerStructureManager.get(context.getSource().getPlayerOrException());
            if (struct != null) {
                MutableComponent header = ChatHelper.getHeader("Selection Analysis");
                String headerStr = header.getString();
                MutableComponent body = header
                        .append(ChatHelper.lineStarter().append(new TextComponent("pos1: ").withStyle(ChatHelper.format(ChatHelper.BRIGHT_ACCENT_COLOR)))
                                .append(new TextComponent(struct.getPos1() == null ? "not set" : (struct.getPos1().getX() + " " + struct.getPos1().getY() + " " + struct.getPos1().getZ())).withStyle(ChatHelper.format(struct.getPos1() == null ? ChatHelper.FAIL_COLOR : ChatHelper.ACCENT_COLOR)))).append(new TextComponent("\n"))
                        .append(ChatHelper.lineStarter().append(new TextComponent("pos2: ").withStyle(ChatHelper.format(ChatHelper.BRIGHT_ACCENT_COLOR)))
                                .append(new TextComponent(struct.getPos2() == null ? "not set" : (struct.getPos2().getX() + " " + struct.getPos2().getY() + " " + struct.getPos2().getZ())).withStyle(ChatHelper.format(struct.getPos2() == null ? ChatHelper.FAIL_COLOR : ChatHelper.ACCENT_COLOR)))).append(new TextComponent("\n"));
                if (struct.isComplete()) {
                    int totalSize = struct.getSize();
                    String total = "";
                    if (totalSize <= 32 * 32 * 32) {
                        int totalWithoutAir = 0;
                        for (BlockPos blockPos : struct.stream()) {
                            BlockState state = context.getSource().getLevel().getBlockState(blockPos);
                            if (!state.isAir()) {
                                totalWithoutAir++;
                            }
                        }

                        total = " (" + totalWithoutAir + " without air)";
                    }
                    body.append(ChatHelper.lineStarter().append(new TextComponent("size: ").withStyle(ChatHelper.format(ChatHelper.BRIGHT_ACCENT_COLOR)))
                            .append(new TextComponent(totalSize + " blocks" + total).withStyle(ChatHelper.format(ChatHelper.ACCENT_COLOR)))).append(new TextComponent("\n"));


                }
                body.append(ChatHelper.getFooter(headerStr));
                ChatHelper.respond(context, true, body);

                return 1;
            }
            ChatHelper.respond(context, false, "No selection found");
            return 0;
        }));

        stack.then(sel);
    }
}
