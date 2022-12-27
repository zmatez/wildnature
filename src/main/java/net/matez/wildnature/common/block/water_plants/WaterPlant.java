/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.water_plants;

import net.minecraft.world.level.material.MaterialColor;

public enum WaterPlant {
    DUCKWEED("duckweed", MaterialColor.PLANT,(type, location, blockProperties, itemProperties) -> {
        return new WNDuckweedBlock(location,blockProperties,itemProperties,type);
    }),
    GREEN_LILY_PAD("green_lily_pad", MaterialColor.PLANT,(type, location, blockProperties, itemProperties) -> {
        return new WNLilyPadBlock(location,blockProperties,itemProperties,type);
    }),
    RED_LILY_PAD("red_lily_pad", MaterialColor.COLOR_RED,(type, location, blockProperties, itemProperties) -> {
        return new WNLilyPadBlock(location,blockProperties,itemProperties,type);
    }),
    PARROTS_FEATHER_PLANT("parrots_feather_plant", MaterialColor.PLANT,(type, location, blockProperties, itemProperties) -> {
        return new WNParrotsFeatherPlantBlock(location,blockProperties,itemProperties,type);
    }),
    POND_WEED("pond_weed", MaterialColor.PLANT,(type, location, blockProperties, itemProperties) -> {
        return new WNPondWeedBlock(location,blockProperties,itemProperties,type);
    }),
    LOTUS_LIGHT_PINK("lotus_light_pink", "lotus", MaterialColor.PLANT,(type, location, blockProperties, itemProperties) -> {
        return new WNFloweringWaterlilyBlock(location,blockProperties,itemProperties,type);
    }),
    LOTUS_PINK("lotus_pink", "lotus", MaterialColor.PLANT,(type, location, blockProperties, itemProperties) -> {
        return new WNFloweringWaterlilyBlock(location,blockProperties,itemProperties,type);
    }),
    LOTUS_WHITE("lotus_white", "lotus",MaterialColor.PLANT,(type, location, blockProperties, itemProperties) -> {
        return new WNFloweringWaterlilyBlock(location,blockProperties,itemProperties,type);
    }),
    WATER_HYACINTH("water_hyacinth",MaterialColor.PLANT,(type, location, blockProperties, itemProperties) -> {
        return new WNFloweringWaterlilyBlock(location,blockProperties,itemProperties,type);
    }),
    WATER_POPPY("water_poppy",MaterialColor.PLANT,(type, location, blockProperties, itemProperties) -> {
        return new WNWaterPoppyPlantBlock(location,blockProperties,itemProperties,type);
    }),
    WATERLILY_YELLOW("waterlily_yellow", "waterlily",MaterialColor.PLANT,(type, location, blockProperties, itemProperties) -> {
        return new WNFloweringWaterlilyBlock(location,blockProperties,itemProperties,type);
    }),
    WATERLILY_WHITE("waterlily_white", "waterlily",MaterialColor.PLANT,(type, location, blockProperties, itemProperties) -> {
        return new WNFloweringWaterlilyBlock(location,blockProperties,itemProperties,type);
    }),


    ;
    private final String id;
    private final String folder;
    private final MaterialColor color;
    private final WaterPlantConstructor<WaterPlant> constructor;

    WaterPlant(String id, String folder, MaterialColor color, WaterPlantConstructor<WaterPlant> constructor) {
        this.id = id;
        this.folder = folder;
        this.color = color;
        this.constructor = constructor;
    }

    WaterPlant(String id, MaterialColor color, WaterPlantConstructor<WaterPlant> constructor) {
        this(id,id,color,constructor);
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

    public WaterPlantConstructor<WaterPlant> getConstructor() {
        return constructor;
    }
}
