/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.core.registry;

import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.objects.biomes.setup.WNBiome;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.LinkedHashMap;

@Initialize(InitStage.REG_BIOMES)
public class WNBiomes {
    //# --- ALL BIOMES  ---
    public static final LinkedHashMap<ResourceLocation, WNBiome> BIOMES = new LinkedHashMap<>();
    public static final LinkedHashMap<ResourceLocation, Feature<?>> FEATURES = new LinkedHashMap<>();
    //#------------------
    //public static final WNBiome TEST = register(new WNTestBiome(location("test")));
    private static final SimpleLogger log = WildNature.getLogger();

    //#------------------
    public static ResourceLocation location(String name) {
        return new ResourceLocation(WildNature.modid, name);
    }

    private static WNBiome register(WNBiome biome) {
        if (!WildNature.instance.initializer.isInitialized(InitStage.REG_BIOMES)) {
            return null;
        }
        biome.build();
        biome.loadVanilla();
        BIOMES.put(biome.getRegistryName(), biome);

        return biome;
    }
}
