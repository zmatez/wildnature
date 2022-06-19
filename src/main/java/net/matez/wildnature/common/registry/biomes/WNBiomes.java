/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.registry.biomes;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.biomes.WNTestBiome;
import net.matez.wildnature.common.objects.biomes.setup.WNBiome;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.LinkedHashMap;

@Initialize(InitStage.CONSTRUCT)
public class WNBiomes {
    //# --- ALL BIOMES  ---
    public static final LinkedHashMap<ResourceLocation, WNBiome> BIOMES = new LinkedHashMap<>();
    public static final LinkedHashMap<ResourceLocation, Feature<?>> FEATURES = new LinkedHashMap<>();
    public static final LinkedHashMap<ResourceLocation, ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = new LinkedHashMap<>();
    public static final LinkedHashMap<ResourceLocation, PlacedFeature> PLACED_FEATURES = new LinkedHashMap<>();
    //#------------------
    public static final WNBiome TEST = register(new WNTestBiome(location("test")));
    private static final WNLogger log = WildNature.getLogger();

    //#------------------
    public static ResourceLocation location(String name) {
        return new ResourceLocation(WildNature.modid, name);
    }

    private static WNBiome register(WNBiome biome) {
        biome.build();
        biome.loadVanilla();
        BIOMES.put(biome.getRegistryName(), biome);

        return biome;
    }
}
