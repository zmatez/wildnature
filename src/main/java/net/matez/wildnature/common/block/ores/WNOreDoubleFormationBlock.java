/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.ores;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;

public class WNOreDoubleFormationBlock extends WNOreFormationBlock{

    public static final EnumProperty<BigSmallBlock> SIZE = WNBlockProperties.SIZE;

    public WNOreDoubleFormationBlock(Properties properties, Ore ore) {
        super(properties, ore);
        this.registerDefaultState(this.defaultBlockState().setValue(SIZE,BigSmallBlock.SMALL));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(SIZE);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state == null){
            return null;
        }

        return state.setValue(SIZE, ExtraMath.rint(0,2) == 0 ? BigSmallBlock.BIG : BigSmallBlock.SMALL);
    }
}
