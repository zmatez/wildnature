/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.registry.setup;

import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.items.setup.IWNItem;
import net.matez.wildnature.common.registry.biomes.WNBiomes;
import net.matez.wildnature.common.registry.blockentities.WNBlockEntities;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.common.registry.containers.WNContainers;
import net.matez.wildnature.common.registry.entities.WNEntities;
import net.matez.wildnature.common.registry.items.WNItems;
import net.matez.wildnature.common.registry.particles.WNParticles;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class WNRegistry {
    private static final SimpleLogger log = WildNature.getLogger();

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        WildNature.instance.initializer.init(InitStage.REG_BLOCKS);

        log.progress("Registering blocks");
        event.getRegistry().registerAll(WNBlocks.BLOCKS.values().toArray(new Block[]{}));
        log.success("Registered " + WNBlocks.BLOCKS.size() + " blocks");
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        WildNature.instance.initializer.init(InitStage.REG_ITEMS);

        // construct items added with blocks (like crops)
        WNBlocks.BLOCKS.forEach((key, block) -> {
            block.onItemConstruct();
        });

        log.progress("Registering block items");
        event.getRegistry().registerAll(WNBlocks.BLOCK_ITEMS.values().toArray(new BlockItem[]{}));
        log.success("Registered " + WNBlocks.BLOCK_ITEMS.size() + " block items");

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
        WildNature.instance.initializer.init(InitStage.REG_BLOCK_ENTITIES);

        log.progress("Registering block entities");

        WNBlockEntities.BLOCK_ENTITY_TYPES.forEach((location, blockEntityType) -> {
            event.getRegistry().register(blockEntityType);
        });

        log.success("Registered " + WNBlockEntities.BLOCK_ENTITY_TYPES.size() + " block entities");
    }

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        WildNature.instance.initializer.init(InitStage.REG_ENTITIES);

        log.progress("Registering entities");

        WNEntities.ENTITY_TYPES.forEach((location, entityType) -> {
            event.getRegistry().register(entityType);
        });

        log.success("Registered " + WNEntities.ENTITY_TYPES.size() + " entities");
    }

    @SubscribeEvent
    public static void registerMenus(final RegistryEvent.Register<MenuType<?>> event) {
        WildNature.instance.initializer.init(InitStage.REG_MENUS);

        log.progress("Registering menus");

        WNContainers.MENU_TYPES.forEach((location, menuType) -> {
            event.getRegistry().register(menuType);
        });

        log.success("Registered " + WNContainers.MENU_TYPES.size() + " menus");
    }

    @SubscribeEvent
    public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
//        WildNature.instance.initializer.init(InitStage.REG_BIOMES);
//
//        log.progress("Registering biomes");
//
//        WNBiomes.BIOMES.forEach((location, biome) -> {
//            event.getRegistry().register(biome.getVanilla());
//            var optional = event.getRegistry().getResourceKey(biome.getVanilla());
//            optional.ifPresentOrElse(biome::postRegister, () -> {
//                log.error("Unable to register biome: " + biome.getRegistryName());
//            });
//        });
//
//        log.success("Registered " + WNBiomes.BIOMES.size() + " biomes");
    }

    @SubscribeEvent
    public static void registerFeatures(final RegistryEvent.Register<Feature<?>> event) {
        WildNature.instance.initializer.init(InitStage.REG_BIOMES);

        log.progress("Registering features");

        //todo features
//        WNBiomes.FEATURES.forEach((location, feature) -> {
//            event.getRegistry().register(feature);
//        });
//
//        WNBiomes.CONFIGURED_FEATURES.forEach((location, configuredFeature) -> {
//            FeatureUtils.register(location.toString(), configuredFeature);
//        });
//        WNBiomes.PLACED_FEATURES.forEach((location, placedFeature) -> {
//            PlacementUtils.register(location.toString(), placedFeature);
//        });

        log.success("Registered " + WNBiomes.FEATURES.size() + " features");
    }
}
