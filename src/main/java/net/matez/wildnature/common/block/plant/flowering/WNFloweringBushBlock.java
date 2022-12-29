/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant.flowering;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNBushConfiguredBlock;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class WNFloweringBushBlock extends WNBushConfiguredBlock {
    public static final BooleanProperty FLOWERING = WNBlockProperties.FLOWERING;

    public WNFloweringBushBlock(Properties properties, BushType type) {
        super(properties, type);
        registerDefaultState(this.stateDefinition.any().setValue(FLOWERING,false));

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
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(FLOWERING);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(ExtraMath.rint(0,5, random) == 0){
            level.setBlock(pos,state.setValue(FLOWERING,true),2);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> definition) {
        definition.add(FLOWERING);
    }

    @Override
    public @Nullable BlockColor getBlockColor() {
        if(this.getType() == BushType.HEATHER_MIXED || this.getType() == BushType.HEATHER_YELLOW){
            return (state, getter, pos, num) -> {
                return 0xB8F10C;
            };
        }
        return super.getBlockColor();
    }
}
