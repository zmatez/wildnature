/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.event;

import net.matez.wildnature.common.structures.dev.client.WNDevClientStructureManager;
import net.matez.wildnature.common.structures.dev.server.WNDevServerStructureManager;
import net.matez.wildnature.setup.WildNature;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WildNature.modid, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WNDevStructureTickEvent {
    @SubscribeEvent
    public static void onTick(TickEvent.WorldTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (event.side == LogicalSide.SERVER) {
                WNDevServerStructureManager.STRUCTURE_SELECTIONS.forEach((player, selection) -> {
                    if (selection != null) {
                        selection.tick();
                    }
                });
            }
        }
    }

    @SubscribeEvent
    public static void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            WNDevClientStructureManager.STRUCTURE_SELECTIONS.forEach((player, selection) -> {
                if (selection != null) {
                    selection.tick();
                }
            });
        }
    }
}
