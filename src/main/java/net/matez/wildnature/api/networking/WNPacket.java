/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.api.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.function.Supplier;

public abstract class WNPacket<T> {
    public abstract void write(FriendlyByteBuf buf);

    public abstract void handle(final Supplier<NetworkEvent.Context> ctx);

    public void sendToClient(ServerPlayer entity) {
        WNNetworking.MAIN.send(PacketDistributor.PLAYER.with(() -> {
            return entity;
        }), this);
    }
}
