/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.biomes.setup;

import net.minecraft.world.level.biome.Biome;

public enum WNBiomeCategory {
    NONE(Biome.BiomeCategory.NONE),
    TAIGA(Biome.BiomeCategory.TAIGA),
    EXTREME_HILLS(Biome.BiomeCategory.EXTREME_HILLS),
    JUNGLE(Biome.BiomeCategory.JUNGLE),
    MESA(Biome.BiomeCategory.MESA),
    PLAINS(Biome.BiomeCategory.PLAINS),
    SAVANNA(Biome.BiomeCategory.SAVANNA),
    ICY(Biome.BiomeCategory.ICY),
    THE_END(Biome.BiomeCategory.THEEND),
    BEACH(Biome.BiomeCategory.BEACH),
    FOREST(Biome.BiomeCategory.FOREST),
    OCEAN(Biome.BiomeCategory.OCEAN),
    DESERT(Biome.BiomeCategory.DESERT),
    RIVER(Biome.BiomeCategory.RIVER),
    SWAMP(Biome.BiomeCategory.SWAMP),
    MUSHROOM(Biome.BiomeCategory.MUSHROOM),
    NETHER(Biome.BiomeCategory.NETHER),
    UNDERGROUND(Biome.BiomeCategory.UNDERGROUND),
    MOUNTAIN(Biome.BiomeCategory.MOUNTAIN);;

    private Biome.BiomeCategory alt;

    WNBiomeCategory(Biome.BiomeCategory alt) {
        this.alt = alt;
    }

    public Biome.BiomeCategory getAlt() {
        return alt;
    }
}
