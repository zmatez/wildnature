/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.api.networking;

import net.minecraft.network.FriendlyByteBuf;

public interface WNPacketReader<T extends WNPacket<T>> {
    T read(FriendlyByteBuf buf);
}
