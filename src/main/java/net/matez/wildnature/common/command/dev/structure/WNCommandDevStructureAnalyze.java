/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.command.dev.structure;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.matez.wildnature.common.command.arguments.WNStructureArgument;
import net.matez.wildnature.common.structures.WNStructure;
import net.matez.wildnature.common.command.IWNCommand;
import net.matez.wildnature.api.client.chat.ChatHelper;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.block.Block;

import java.util.LinkedHashMap;

public class WNCommandDevStructureAnalyze implements IWNCommand {
    @Override
    public void register(LiteralArgumentBuilder<CommandSourceStack> stack, CommandDispatcher<CommandSourceStack> dispatcher) {
        var analyze = Commands.literal("analyze").then(Commands.argument("name", WNStructureArgument.structure()).executes(context -> {
                    WNStructure struct = WNStructureArgument.getStructure(context, "name");

                    MutableComponent header = ChatHelper.getHeader("Structure Analysis");
                    String headerStr = header.getString();

                    MutableComponent blocks = new TextComponent("");
                    LinkedHashMap<Block, Integer> occurrences = new LinkedHashMap<>();
                    struct.getBlockOccurrences((state) -> true).forEach((block, count) -> {
                        if (occurrences.containsKey(block.getBlock())) {
                            occurrences.put(block.getBlock(), occurrences.get(block.getBlock()) + count);
                        } else {
                            occurrences.put(block.getBlock(), count);
                        }
                    });

                    occurrences.forEach((block, count) -> {
                        blocks.append(ChatHelper.lineStarter(2).append(new TextComponent(block.getRegistryName().toString()).withStyle(ChatHelper.format(ChatHelper.ACCENT_COLOR)))
                                .append(new TextComponent(" x" + count).withStyle(ChatHelper.format(ChatHelper.DARK_ACCENT_COLOR))).append(new TextComponent("\n")));
                    });

                    MutableComponent body = header
                            .append(ChatHelper.lineStarter().append(new TextComponent("min: ").withStyle(ChatHelper.format(ChatHelper.BRIGHT_ACCENT_COLOR)))
                                    .append(new TextComponent(struct.getMin().getX() + " " + struct.getMin().getY() + " " + struct.getMin().getZ()).withStyle(ChatHelper.format(ChatHelper.ACCENT_COLOR)))).append(new TextComponent("\n"))
                            .append(ChatHelper.lineStarter().append(new TextComponent("min: ").withStyle(ChatHelper.format(ChatHelper.BRIGHT_ACCENT_COLOR)))
                                    .append(new TextComponent(struct.getMax().getX() + " " + struct.getMax().getY() + " " + struct.getMax().getZ()).withStyle(ChatHelper.format(ChatHelper.ACCENT_COLOR)))).append(new TextComponent("\n"))
                            .append(ChatHelper.lineStarter().append(new TextComponent("count: ").withStyle(ChatHelper.format(ChatHelper.BRIGHT_ACCENT_COLOR)))
                                    .append(new TextComponent(struct.getBlockAmount() + " blocks").withStyle(ChatHelper.format(ChatHelper.ACCENT_COLOR)))).append(new TextComponent("\n"))
                            .append(ChatHelper.lineStarter().append(new TextComponent("count: ").withStyle(ChatHelper.format(ChatHelper.BRIGHT_ACCENT_COLOR)))
                                    .append(new TextComponent(struct.getBlockAmount() + " blocks").withStyle(ChatHelper.format(ChatHelper.ACCENT_COLOR)))).append(new TextComponent("\n"))
                            .append(ChatHelper.lineStarter().append(new TextComponent("blocks: ").withStyle(ChatHelper.format(ChatHelper.BRIGHT_ACCENT_COLOR)))
                                    .append(blocks).append(new TextComponent("\n")));

                    body.append(ChatHelper.getFooter(headerStr));
                    ChatHelper.respond(context, true, body);

                    return 1;
                }
        ));

        stack.then(analyze);
    }
}
