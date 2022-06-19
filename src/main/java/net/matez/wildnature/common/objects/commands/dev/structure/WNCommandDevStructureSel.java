/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.commands.dev.structure;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.matez.wildnature.common.managers.structure.server.WNDevServerStructureManager;
import net.matez.wildnature.common.registry.commands.IWNCommand;
import net.matez.wildnature.common.registry.items.WNItems;
import net.matez.wildnature.common.util.WNChatUtil;
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
            WNChatUtil.respond(context, true, "You got the selection wand. Use &vPPM&r and &vLPM&r to select points, then save your structure with &v/wn dev struct save");
            return 1;
        }));
        sel.then(Commands.literal("clear").executes(context -> {
            if (WNDevServerStructureManager.delete(context.getSource().getPlayerOrException())) {
                WNChatUtil.respond(context, true, "Selection cleared");
                return 1;
            }
            WNChatUtil.respond(context, false, "No selection found");
            return 0;
        }));
        sel.then(Commands.literal("analyze").executes(context -> {
            var struct = WNDevServerStructureManager.get(context.getSource().getPlayerOrException());
            if (struct != null) {
                MutableComponent header = WNChatUtil.getHeader("Selection Analysis");
                String headerStr = header.getString();
                MutableComponent body = header
                        .append(WNChatUtil.lineStarter().append(new TextComponent("pos1: ").withStyle(WNChatUtil.format(WNChatUtil.BRIGHT_ACCENT_COLOR)))
                                .append(new TextComponent(struct.getPos1() == null ? "not set" : (struct.getPos1().getX() + " " + struct.getPos1().getY() + " " + struct.getPos1().getZ())).withStyle(WNChatUtil.format(struct.getPos1() == null ? WNChatUtil.FAIL_COLOR : WNChatUtil.ACCENT_COLOR)))).append(new TextComponent("\n"))
                        .append(WNChatUtil.lineStarter().append(new TextComponent("pos2: ").withStyle(WNChatUtil.format(WNChatUtil.BRIGHT_ACCENT_COLOR)))
                                .append(new TextComponent(struct.getPos2() == null ? "not set" : (struct.getPos2().getX() + " " + struct.getPos2().getY() + " " + struct.getPos2().getZ())).withStyle(WNChatUtil.format(struct.getPos2() == null ? WNChatUtil.FAIL_COLOR : WNChatUtil.ACCENT_COLOR)))).append(new TextComponent("\n"));
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
                    body.append(WNChatUtil.lineStarter().append(new TextComponent("size: ").withStyle(WNChatUtil.format(WNChatUtil.BRIGHT_ACCENT_COLOR)))
                            .append(new TextComponent(totalSize + " blocks" + total).withStyle(WNChatUtil.format(WNChatUtil.ACCENT_COLOR)))).append(new TextComponent("\n"));


                }
                body.append(WNChatUtil.getFooter(headerStr));
                WNChatUtil.respond(context, true, body);

                return 1;
            }
            WNChatUtil.respond(context, false, "No selection found");
            return 0;
        }));

        stack.then(sel);
    }
}
