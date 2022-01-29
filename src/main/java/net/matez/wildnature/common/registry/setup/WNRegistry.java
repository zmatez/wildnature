/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.registry.setup;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.items.setup.IWNItem;
import net.matez.wildnature.common.registry.blockentities.WNBlockEntities;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.common.registry.items.WNItems;
import net.matez.wildnature.common.registry.particles.WNParticles;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class WNRegistry {
    private static final WNLogger log = WildNature.getLogger();

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        log.progress("Registering blocks");
        event.getRegistry().registerAll(WNBlocks.BLOCKS.values().toArray(new Block[]{}));
        log.success("Registered " + WNBlocks.BLOCKS.size() + " blocks");
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        log.progress("Registering block items");
        event.getRegistry().registerAll(WNItems.BLOCK_ITEMS.values().toArray(new BlockItem[]{}));
        log.success("Registered " + WNItems.BLOCK_ITEMS.size() + " block items");

        log.progress("Registering items");
        for (IWNItem value : WNItems.ITEMS.values()) {
            event.getRegistry().register(value.asItem());
        }
        log.success("Registered " + WNItems.ITEMS.size() + " items");
    }

    @SubscribeEvent
    public static void registerParticles(final RegistryEvent.Register<ParticleType<?>> event) {
        log.progress("Registering particles");

        WNParticles.PARTICLE_TYPES.forEach((location, simpleParticleType) -> {
            event.getRegistry().register(simpleParticleType);
        });

        log.success("Registered " + WNParticles.PARTICLE_TYPES.size() + " particles");
    }

    @SubscribeEvent
    public static void registerBlockEntities(final RegistryEvent.Register<BlockEntityType<?>> event) {
        log.progress("Registering block entities");

        WNBlockEntities.BLOCK_ENTITY_TYPES.forEach((location, blockEntityType) -> {
            event.getRegistry().register(blockEntityType);
        });

        log.success("Registered " + WNBlockEntities.BLOCK_ENTITY_TYPES.size() + " block entities");
    }

}
