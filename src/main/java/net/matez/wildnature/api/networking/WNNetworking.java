/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.api.networking;

import net.matez.wildnature.api.networking.packets.WNDevStructurePacket;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Optional;

public class WNNetworking {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel MAIN = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(WildNature.modid, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private static int id = 0;

    public static void register() {
        register(WNDevStructurePacket.class, WNDevStructurePacket::read, NetworkDirection.PLAY_TO_CLIENT);
    }

    private static <T extends WNPacket<T>> void register(Class<T> packet, WNPacketReader<T> reader, NetworkDirection direction) {
        MAIN.registerMessage(id++, packet, WNPacket::write, reader::read, WNPacket::handle, Optional.of(direction));
    }
}
