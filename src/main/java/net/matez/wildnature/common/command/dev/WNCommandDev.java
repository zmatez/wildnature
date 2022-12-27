/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.command.dev;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.matez.wildnature.common.command.dev.structure.WNCommandDevStructure;
import net.matez.wildnature.common.command.IWNCommand;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class WNCommandDev implements IWNCommand {
    @Override
    public void register(LiteralArgumentBuilder<CommandSourceStack> stack, CommandDispatcher<CommandSourceStack> dispatcher) {
        var dev = Commands.literal("dev");
        //#---
        // structure
        new WNCommandDevStructure().register(dev, dispatcher);

        stack.then(dev);
    }
}
