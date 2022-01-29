/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.plant;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

public enum BushPlacement {
    DIRT((state, stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.DIRT) || stateOn.is(Blocks.FARMLAND);
    }),
    DIRT_OR_SAND((state, stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.DIRT) || stateOn.is(BlockTags.SAND);
    }),
    FARMLAND((state, stateOn, getter, pos) -> {
        return stateOn.is(Blocks.FARMLAND);
    }),
    SAND((state, stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.SAND);
    }),
    LEAVES((state, stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.LEAVES);
    }),
    ALL_NATURAL((state, stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.DIRT) || stateOn.is(Blocks.FARMLAND) || stateOn.is(BlockTags.SAND) || stateOn.is(BlockTags.LOGS) || stateOn.is(BlockTags.LEAVES);
    }),
    LOGS((state, stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.LOGS);
    }),
    STONE((state, stateOn, getter, pos) -> {
        return stateOn.is(BlockTags.BASE_STONE_OVERWORLD);
    })
    ;

    private BushPlacementSupplier supplier;
    BushPlacement(BushPlacementSupplier supplier){
        this.supplier = supplier;
    }

    public BushPlacementSupplier getSupplier() {
        return supplier;
    }
}
