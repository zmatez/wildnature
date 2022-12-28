/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.mushrooms;

import net.matez.wildnature.common.block.plant.WNBushBlock;
import net.matez.wildnature.common.block.plant.config.BushConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

public class WNMushroomBlock extends WNBushBlock {
    public static final BushConfig CONFIG = new BushConfig();
    protected final Mushroom mushroom;

    public WNMushroomBlock(Properties properties, Mushroom mushroom) {
        super(properties, CONFIG);
        this.mushroom = mushroom;
    }

    @Override
    public boolean canSurvive(BlockState p_54880_, LevelReader reader, BlockPos p_54882_) {
        BlockPos blockpos = p_54882_.below();
        BlockState blockstate = reader.getBlockState(blockpos);
        if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        } else {
            return reader.getRawBrightness(p_54882_, 0) < 13 && blockstate.canSustainPlant(reader, blockpos, net.minecraft.core.Direction.UP, this);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextInt(25) == 0) {
            int i = 5;
            int j = 4;

            for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, -1, -4), pos.offset(4, 1, 4))) {
                if (level.getBlockState(blockpos).is(this)) {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);

            for(int k = 0; k < 4; ++k) {
                if (level.isEmptyBlock(blockpos1) && state.canSurvive(level, blockpos1)) {
                    pos = blockpos1;
                }

                blockpos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
            }

            if (level.isEmptyBlock(blockpos1) && state.canSurvive(level, blockpos1)) {
                level.setBlock(blockpos1, state, 2);
            }
        }

    }

    @Override
    protected boolean mayPlaceOn(BlockState stateOn, BlockGetter getter, BlockPos pos) {
        return stateOn.isSolidRender(getter, pos);
    }
}
