/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public enum BushPlacement implements BushPlacementSupplier {
    DIRT((stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.DIRT) || stateOn.is(Blocks.FARMLAND);
    }),
    DIRT_OR_SAND((stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.DIRT) || stateOn.is(BlockTags.SAND);
    }),
    FARMLAND((stateOn, getter, pos) -> {
        return stateOn.is(Blocks.FARMLAND);
    }),
    SAND((stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.SAND);
    }),
    LEAVES((stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.LEAVES);
    }),
    ALL_NATURAL((stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.DIRT) || stateOn.is(Blocks.FARMLAND) || stateOn.is(BlockTags.SAND) || stateOn.is(BlockTags.LOGS) || stateOn.is(BlockTags.LEAVES);
    }),
    LOGS((stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.LOGS);
    }),
    STONE((stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.BASE_STONE_OVERWORLD);
    });

    private BushPlacementSupplier supplier;
    BushPlacement(BushPlacementSupplier supplier){
        this.supplier = supplier;
    }

    public BushPlacementSupplier getSupplier() {
        return supplier;
    }

    @Override
    public boolean canPlace(BlockState stateOn, BlockGetter getter, BlockPos pos) {
        return this.supplier.canPlace(stateOn, getter, pos);
    }
}
