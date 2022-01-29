/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.events;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.LinkedHashMap;

@Mod.EventBusSubscriber(modid = WildNature.modid, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SilverBurnEvent {
    public static LinkedHashMap<LivingEntity, Integer> SILVER_BURNS = new LinkedHashMap<>();
    private static int tick = 0;
    private static final WNLogger log = WildNature.getLogger();

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event){
        if(event.phase == TickEvent.Phase.START){
            if(event.side == LogicalSide.SERVER){
                if(event.type == TickEvent.Type.SERVER){
                    tick++;
                    if(tick >= 4) {
                        tick = 0;
                        LinkedHashMap<LivingEntity, Integer> SILVER_BURNS_NEW = new LinkedHashMap<>();
                        SILVER_BURNS.forEach((entity, time) -> {
                            int newTime = time - 1;
                            if (newTime > 0 && entity.isAlive()) {
                                SILVER_BURNS_NEW.put(entity, newTime);
                            }

                            if(entity.getLevel() instanceof ServerLevel level) {
                                level.sendParticles(ParticleTypes.ASH, entity.getX(), entity.getY() + 1.8, entity.getZ(), 70, 0.2f, 0.2f, 0.2f, 0);
                            }
                        });

                        SILVER_BURNS = SILVER_BURNS_NEW;
                    }
                }
            }
        }
    }

    public static void makeBurn(LivingEntity entity, int ticks){
        SILVER_BURNS.put(entity,ticks/4);
    }

}
