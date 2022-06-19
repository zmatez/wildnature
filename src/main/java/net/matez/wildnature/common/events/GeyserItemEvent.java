/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.events;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.registry.particles.WNParticles;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.LinkedHashMap;

@Mod.EventBusSubscriber(modid = WildNature.modid, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GeyserItemEvent {
    private static final WNLogger log = WildNature.getLogger();
    public static LinkedHashMap<GeyserItemEntry, Integer> GEYSER_TICKS = new LinkedHashMap<>();

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            if (event.side == LogicalSide.SERVER) {
                if (event.type == TickEvent.Type.SERVER) {
                    LinkedHashMap<GeyserItemEntry, Integer> GEYSER_TICKS_NEW = new LinkedHashMap<>();
                    GEYSER_TICKS.forEach((entry, time) -> {
                        int newTime = time - 1;
                        if (newTime > 0) {
                            GEYSER_TICKS_NEW.put(entry, newTime);
                        }

                        if (entry.getPlayer().getLevel() instanceof ServerLevel level) {
                            explode(entry.getClickPos(), level);
                        }
                    });

                    GEYSER_TICKS = GEYSER_TICKS_NEW;
                }
            }
        }
    }

    public static void explode(Player player) {
        GEYSER_TICKS.put(new GeyserItemEntry(player, new Vec3(player.getX(), player.getY(), player.getZ())), WNUtil.rint(20, 40));
    }

    private static void explode(Vec3 center, ServerLevel level) {
        double xzESize = 2.5;
        double yESize = 3;

        for (int i = 0; i < WNUtil.rint(1, 2); ++i) {
            level.sendParticles(WNParticles.STEAM, center.x + WNUtil.rdoub(-0.2, 0.2), center.y + 1, center.z + WNUtil.rdoub(-0.2, 0.2), 20, WNUtil.rdoub(-0.2, 0.2), WNUtil.rdoub(0, 0.1), WNUtil.rdoub(-0.2, 0.2), WNUtil.rdoub(0.015D, 0.035D));
        }
        if (WNUtil.rint(0, 3) == 0) {
            level.sendParticles(WNParticles.THERMAL_SMOKE, center.x + WNUtil.rdoub(-0.2, 0.2), center.y + 1, center.z + WNUtil.rdoub(-0.2, 0.2), WNUtil.rint(5, 10), 0.0D, WNUtil.rdoub(0, 0.1), 0.0D, 0.06D);
            level.sendParticles(ParticleTypes.CLOUD, center.x + WNUtil.rdoub(-0.2, 0.2), center.y + 1, center.z + WNUtil.rdoub(-0.2, 0.2), WNUtil.rint(5, 10), 0.0D, WNUtil.rdoub(0, 0.1), 0.0D, 0.1D);
        }

        for (Entity entity : level.getEntitiesOfClass(Entity.class, new AABB(center.x - xzESize, center.y - 1, center.z - xzESize, center.x + xzESize, center.y + yESize, center.z + xzESize))) {
            double yDistance = Math.max(1, entity.getY() - center.y);
            double xzDistance = WNUtil.xzDistance(new Vec3(entity.getX(), entity.getY(), entity.getZ()), center);

            double yMod = Math.min(1, 2 / yDistance);
            double xzMod = Math.min(1, 4 / xzDistance);

            Vec3 delta = entity.getDeltaMovement();
            double amount = Math.min(0.35D, delta.y + 0.15D) * yMod * xzMod;

            entity.hurtMarked = true;
            entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, amount, 0.0D));
        }
    }

    public static class GeyserItemEntry {
        private final Player player;
        private final Vec3 clickPos;

        public GeyserItemEntry(Player player, Vec3 clickPos) {
            this.player = player;
            this.clickPos = clickPos;
        }

        public Player getPlayer() {
            return player;
        }

        public Vec3 getClickPos() {
            return clickPos;
        }
    }
}
