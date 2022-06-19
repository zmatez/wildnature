/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.biomes.setup;

import net.minecraft.world.level.biome.Biome;

public enum WNPrecipitation {
    NONE(Biome.Precipitation.NONE),
    RAIN(Biome.Precipitation.RAIN),
    SNOW(Biome.Precipitation.SNOW);

    private Biome.Precipitation alt;

    WNPrecipitation(Biome.Precipitation alt) {
        this.alt = alt;
    }

    public Biome.Precipitation getAlt() {
        return alt;
    }
}
