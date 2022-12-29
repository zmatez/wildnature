/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant.vines;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.block.plant.BushType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class WNFloweringVineBlock extends WNAbstractVineBlock{
    private BushType type;
    public static final BooleanProperty FLOWERING = WNBlockProperties.FLOWERING;

    public WNFloweringVineBlock(Properties properties, BushType type) {
        super(properties);
        this.type = type;
        registerDefaultState(this.defaultBlockState().setValue(FLOWERING,false));
    }

    @Override
    public RenderType getRenderType() {
        return RenderType.cutout();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return super.getStateForPlacement(context).setValue(FLOWERING,true);
        }
        return state;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state,level,pos,random);
        if(ExtraMath.rint(0,5) == 0){
            level.setBlock(pos,state.setValue(FLOWERING,true),2);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> definition) {
        super.createBlockStateDefinition(definition);
        definition.add(FLOWERING);
    }

    public BushType getType() {
        return type;
    }
}
