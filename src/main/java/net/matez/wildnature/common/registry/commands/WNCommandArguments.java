/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.registry.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import net.matez.wildnature.common.objects.commands.arguments.WNStructureArgument;
import net.matez.wildnature.common.objects.commands.arguments.WNStructurePathArgument;
import net.minecraft.commands.synchronization.ArgumentSerializer;
import net.minecraft.commands.synchronization.ArgumentTypes;
import net.minecraft.commands.synchronization.EmptyArgumentSerializer;

public class WNCommandArguments {
    private static boolean registered = false;

    public static void register() {
        if (registered) {
            return;
        }
        register("wildnature:structure", WNStructureArgument.class, new EmptyArgumentSerializer<>(WNStructureArgument::structure));
        register("wildnature:structure_path", WNStructurePathArgument.class, new EmptyArgumentSerializer<>(WNStructurePathArgument::path));

        registered = true;
    }

    private static <T extends ArgumentType<?>> void register(String name, Class<T> clazz, ArgumentSerializer<T> serializer) {
        ArgumentTypes.register(name, clazz, serializer);
    }
}
