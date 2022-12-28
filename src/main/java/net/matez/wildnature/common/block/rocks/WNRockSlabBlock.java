/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.rocks;

import net.matez.wildnature.common.WNBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;

import java.util.function.Supplier;

public class WNRockSlabBlock extends SlabBlock implements WNBlock {
    protected final RockType rockType;
    private final Supplier<Block> fullBlock;

    public WNRockSlabBlock(Properties properties, RockType rockType, Supplier<Block> fullBlock) {
        super(properties);
        this.rockType = rockType;
        this.fullBlock = fullBlock;
    }

    public Block getFullBlock(){
        return this.fullBlock.get();
    }
}
