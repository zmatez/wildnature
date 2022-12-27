/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.ores;

import net.matez.wildnature.common.WNBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class WNOreBlock extends Block implements WNBlock {
    protected final Ore ore;

    public WNOreBlock(Properties properties, Ore ore) {
        super(properties);
        this.ore = ore;
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader world, RandomSource randomSource, BlockPos pos, int fortune, int silktouch) {
        return silktouch != 0 ? 0 : this.ore.getDropConfig().getExpDrops(state,world,fortune,silktouch);
    }
}
