/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.water_plants;

import net.matez.wildnature.data.block_models.plants.WNBlockModel_WaterPoppy;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_WaterPoppyFlowering;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNWaterPoppyPlantBlock extends WNFloweringWaterlilyBlock{
    public WNWaterPoppyPlantBlock(ResourceLocation location, Properties properties, WaterPlant waterPlant) {
        super(location, properties, waterPlant);
    }

    public WNWaterPoppyPlantBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, WaterPlant waterPlant) {
        super(location, properties, itemProperties, waterPlant);
    }

    @Override
    public ModelList getBlockModels(){
        return new ModelList().with(
                new WNBlockModel_WaterPoppy(this.getRegName()).with("texture",this.getTextureName("plants/water/" + this.waterPlant.getFolder())),
                new WNBlockModel_WaterPoppyFlowering(this.getRegName() + "_flowering").with("texture",this.getTextureName("plants/water/" + this.waterPlant.getFolder()))
        );
    }
}
