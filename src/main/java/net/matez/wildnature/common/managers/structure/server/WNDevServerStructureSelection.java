/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.managers.structure.server;

import net.matez.wildnature.common.managers.structure.WNDevStructureSelection;
import net.matez.wildnature.common.networking.packets.WNDevStructurePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class WNDevServerStructureSelection extends WNDevStructureSelection {
    public WNDevServerStructureSelection(ServerPlayer owner) {
        super(owner);
    }

    @Override
    public ServerPlayer getOwner() {
        return (ServerPlayer) super.getOwner();
    }

    @Override
    public ServerLevel getLevel() {
        return (ServerLevel) super.getLevel();
    }

    public void send() {
        var packet = new WNDevStructurePacket(this.getPos1(), this.getPos2(), this.getOwner().getUUID(), this.getLevel().dimension().getRegistryName());
        packet.sendToClient(this.getOwner());
    }

    public void remove() {
        this.setPos1(null);
        this.setPos2(null);
    }
}
