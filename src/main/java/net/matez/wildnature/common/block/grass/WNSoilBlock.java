/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.grass;

import net.matez.wildnature.common.WNBlock;
import net.matez.wildnature.common.block.entity.soil.WNSoilBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNSoilBlock extends BaseEntityBlock implements WNBlock {

    public WNSoilBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState up = level.getBlockState(pos.above());
        if (!up.isAir()) {
            if (up.is(BlockTags.FLOWERS) || up.is(BlockTags.SAPLINGS) || up.is(BlockTags.BEE_GROWABLES)) {
                if (up.getBlock().isRandomlyTicking(up)) {
                    up.getBlock().randomTick(up, level, pos.above(), random);
                }
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WNSoilBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState state2, boolean p_60519_) {
        if (!state.is(state2.getBlock()) && level instanceof ServerLevel) {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof WNSoilBlockEntity soil) {
                soil.destroy();
            }
        }
        super.onRemove(state, level, pos, state2, p_60519_);
    }
}
