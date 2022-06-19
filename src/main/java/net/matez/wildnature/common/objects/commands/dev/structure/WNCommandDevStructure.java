/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.commands.dev.structure;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.matez.wildnature.common.registry.commands.IWNCommand;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class WNCommandDevStructure implements IWNCommand {
    @Override
    public void register(LiteralArgumentBuilder<CommandSourceStack> stack, CommandDispatcher<CommandSourceStack> dispatcher) {
        var structure = Commands.literal("struct");
        //#---
        // selection
        new WNCommandDevStructureSel().register(structure, dispatcher);
        // save
        new WNCommandDevStructureSave().register(structure, dispatcher);
        // load
        new WNCommandDevStructureLoad().register(structure, dispatcher);
        // loadAll
        new WNCommandDevStructureLoadAll().register(structure, dispatcher);
        // analyze
        new WNCommandDevStructureAnalyze().register(structure, dispatcher);

        stack.then(structure);
    }
}
