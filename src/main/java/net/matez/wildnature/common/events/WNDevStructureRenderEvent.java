/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.events;

import net.matez.wildnature.common.managers.structure.client.WNDevClientStructureManager;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WildNature.modid, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WNDevStructureRenderEvent {
    @SubscribeEvent
    public static void onClientRender(RenderLevelLastEvent event) {
        GameRenderer gameRenderer = Minecraft.getInstance().gameRenderer;
        Camera camera = gameRenderer.getMainCamera();

        WNDevClientStructureManager.STRUCTURE_SELECTIONS.forEach((player, selection) -> {
            if (selection != null) {
                selection.render(camera.getPosition(), event.getPartialTick(), event.getPoseStack());
            }
        });
    }
}
