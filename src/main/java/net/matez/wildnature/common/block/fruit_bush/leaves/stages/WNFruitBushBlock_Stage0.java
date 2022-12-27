/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.fruit_bush.leaves.stages;

import net.matez.wildnature.common.block.fruit_bush.leaves.FruitBushType;
import net.matez.wildnature.common.block.fruit_bush.leaves.WNFruitBushTypedBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class WNFruitBushBlock_Stage0 extends WNFruitBushTypedBlock {
    public static IntegerProperty STAGE = null;

    public WNFruitBushBlock_Stage0(ResourceLocation location, Properties properties, FruitBushType leafType) {
        super(location, properties, leafType);
        this.LEAF_STAGE = STAGE;
    }

    public WNFruitBushBlock_Stage0(ResourceLocation location, Properties properties, Item.Properties itemProperties, FruitBushType leafType) {
        super(location, properties, itemProperties, leafType);
        this.LEAF_STAGE = STAGE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        super.createBlockStateDefinition(state);
        if(STAGE != null){
            state.add(STAGE);
        }
    }
}
