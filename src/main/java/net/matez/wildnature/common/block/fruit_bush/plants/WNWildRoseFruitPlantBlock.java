/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.fruit_bush.plants;

import net.matez.wildnature.common.block.fruit_bush.plants.stages.WNFruitBushPlantBlock_Stage3;
import net.matez.wildnature.api.util.ExtraMath;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class WNWildRoseFruitPlantBlock extends WNFruitBushPlantBlock_Stage3 {
    public WNWildRoseFruitPlantBlock(ResourceLocation location, Properties properties, FruitPlantType fruitType) {
        super(location, properties, fruitType);
    }

    public WNWildRoseFruitPlantBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, FruitPlantType fruitType) {
        super(location, properties, itemProperties, fruitType);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        super.randomTick(state, level, pos, random);
        if (this.LEAF_STAGE != null && state.getValue(this.LEAF_STAGE) != this.fruitType.getConfig().getStages()-1) {
            int val = state.getValue(this.LEAF_STAGE);
            int newVal = 0;
            if(val == 0) {
                newVal = ExtraMath.rint(1,2,random);
            }else if(val == 1 || val == 2){
                newVal = 3;
            }

            level.setBlock(pos, state.setValue(this.LEAF_STAGE, newVal), 2);
        }
    }
}
