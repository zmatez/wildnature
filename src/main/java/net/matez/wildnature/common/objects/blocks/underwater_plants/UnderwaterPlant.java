/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.underwater_plants;

import net.minecraft.world.level.material.MaterialColor;

public enum UnderwaterPlant {
    WATER_WEED("water_weed",UnderwaterPlantVariant.NORMAL,MaterialColor.PLANT),
    ALGAE("algae",UnderwaterPlantVariant.NORMAL,MaterialColor.PLANT),
    RED_ALGAE("red_algae",UnderwaterPlantVariant.NORMAL,MaterialColor.COLOR_RED),
    OAR_WEED("oar_weed",UnderwaterPlantVariant.NORMAL,MaterialColor.PLANT),
    RED_SEA_WHIP("red_sea_whip",UnderwaterPlantVariant.NORMAL,MaterialColor.COLOR_RED),
    SEA_ANEMONE("sea_anemone",UnderwaterPlantVariant.NORMAL,MaterialColor.COLOR_PINK),
    SHRIMP_TUBE("shrimp_tube",UnderwaterPlantVariant.NORMAL,MaterialColor.COLOR_YELLOW),
    SHRIMP_TUBE_WEED("shrimp_tube_weed",UnderwaterPlantVariant.NORMAL,MaterialColor.COLOR_LIGHT_BLUE),
    SHALLOW_WATER_GRASS("shallow_water_grass",UnderwaterPlantVariant.NORMAL,MaterialColor.PLANT),
    ROCK_WEED("rock_weed",UnderwaterPlantVariant.NORMAL,MaterialColor.COLOR_YELLOW),
    LILY_TONGUE("lily_tongue",UnderwaterPlantVariant.NORMAL,MaterialColor.PLANT),
    GLOWING_SEA_BANANA("glowing_sea_banana",UnderwaterPlantVariant.NORMAL,MaterialColor.COLOR_LIGHT_BLUE),
    GLOW_RIBBON("glow_ribbon",UnderwaterPlantVariant.DOUBLE,MaterialColor.COLOR_BLUE),
    DEEP_SEA_VINE("deep_sea_vine",UnderwaterPlantVariant.VINE,MaterialColor.PLANT),
    DEEP_SEA_NIGHT_SHADE("deep_sea_night_shade",UnderwaterPlantVariant.NORMAL,MaterialColor.COLOR_BLUE),
    BULB_VINE("bulb_vine",UnderwaterPlantVariant.DOUBLE,MaterialColor.PLANT),
    BAMBOO_CORAL("bamboo_coral",UnderwaterPlantVariant.NORMAL,MaterialColor.TERRACOTTA_WHITE),
    CRAB_CORAL("crab_coral",UnderwaterPlantVariant.NORMAL,MaterialColor.COLOR_RED),


    ;
    private final String id;
    private final String folder;
    private final UnderwaterPlantVariant variant;
    private final MaterialColor color;

    UnderwaterPlant(String id, String folder, UnderwaterPlantVariant variant, MaterialColor color) {
        this.id = id;
        this.folder = folder;
        this.variant = variant;
        this.color = color;
    }

    UnderwaterPlant(String id, UnderwaterPlantVariant variant, MaterialColor color){
        this(id,id,variant,color);
    }

    public String getId() {
        return id;
    }

    public String getFolder() {
        return folder;
    }

    public MaterialColor getColor() {
        return color;
    }

    public UnderwaterPlantVariant getVariant() {
        return variant;
    }
}
