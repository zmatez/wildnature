/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.cave_plants.specific;

import net.matez.wildnature.common.block.cave_plants.CavePlantType;
import net.matez.wildnature.common.block.cave_plants.WNCaveBushBlock;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class WNSunShroomBlock extends WNCaveBushBlock {
    public static final BooleanProperty REFLECTS = WNBlockProperties.REFLECTS;

    public WNSunShroomBlock(Properties properties, CavePlantType type) {
        super(properties, type);
        this.registerDefaultState(defaultBlockState().setValue(REFLECTS,true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(REFLECTS);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return state.setValue(REFLECTS,getReflection(context.getLevel()));
        }
        return state;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        boolean reflects = getReflection(level);
        if(state.getValue(REFLECTS) != reflects){
            level.setBlock(pos,state.setValue(REFLECTS,reflects),2);
        }
    }

    public boolean getReflection(Level level){
        return level.getDayTime() < 12000 && level.getDayTime() >= 0;
    }
}
