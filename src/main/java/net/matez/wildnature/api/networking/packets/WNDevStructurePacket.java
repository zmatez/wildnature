/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.api.networking.packets;

import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.structures.dev.client.WNDevClientStructureManager;
import net.matez.wildnature.common.structures.dev.client.WNDevClientStructureSelection;
import net.matez.wildnature.api.networking.WNPacket;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import javax.annotation.Nullable;
import java.util.UUID;
import java.util.function.Supplier;

public class WNDevStructurePacket extends WNPacket<WNDevStructurePacket> {
    private static final SimpleLogger log = WildNature.getLogger();
    @Nullable
    private final BlockPos pos1, pos2;
    private final UUID owner;
    private final ResourceLocation level;

    public WNDevStructurePacket(@Nullable BlockPos pos1, @Nullable BlockPos pos2, UUID owner, ResourceLocation level) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.owner = owner;
        this.level = level;
    }

    public static WNDevStructurePacket read(FriendlyByteBuf buf) {
        var nbt = buf.readNbt();
        if (nbt == null) {
            return null;
        }
        BlockPos pos1 = null;
        BlockPos pos2 = null;
        if (nbt.contains("pos1")) {
            pos1 = BlockPos.of(nbt.getLong("pos1"));
        }
        if (nbt.contains("pos2")) {
            pos2 = BlockPos.of(nbt.getLong("pos2"));
        }

        return new WNDevStructurePacket(pos1, pos2, nbt.getUUID("owner"), new ResourceLocation(nbt.getString("level")));
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        var nbt = new CompoundTag();
        if (pos1 != null) {
            nbt.putLong("pos1", pos1.asLong());
        }
        if (pos2 != null) {
            nbt.putLong("pos2", pos2.asLong());
        }
        nbt.putUUID("owner", owner);
        nbt.putString("level", level.toString());
        buf.writeNbt(nbt);
    }

    @Override
    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ClientLevel level = Minecraft.getInstance().level;
            if (level != null) {
                Player owner = null;
                if (Minecraft.getInstance().player != null && this.owner == Minecraft.getInstance().player.getUUID()) {
                    owner = Minecraft.getInstance().player;
                } else {
                    owner = level.getPlayerByUUID(this.owner);
                }

                if (owner != null) {
                    var sel = parse(owner);
                    if (sel == null) {
                        WNDevClientStructureManager.STRUCTURE_SELECTIONS.remove(owner);
                    } else {
                        WNDevClientStructureManager.STRUCTURE_SELECTIONS.put(owner, sel);
                    }
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }

    public WNDevClientStructureSelection parse(Player owner) {
        if (pos1 == null && pos2 == null) {
            return null;
        }
        WNDevClientStructureSelection selection = new WNDevClientStructureSelection(owner);
        selection.setPos1(pos1);
        selection.setPos2(pos2);

        return selection;
    }
}
