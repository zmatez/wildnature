/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.registry.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.objects.commands.dev.WNCommandDev;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class WNCommands {
    private static final SimpleLogger log = WildNature.getLogger();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        var main = Commands.literal("wn");
        //---
        //dev
        if (WildNature.devMode) {
            new WNCommandDev().register(main, dispatcher);
        }

        //---
        dispatcher.register(main);
        log.success("Registered WildNature command.");
    }

}
