/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.ores;

import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.blockstates.WNBlockstate_SizedFormation;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;

public class WNOreDoubleFormationBlock extends WNOreFormationBlock{

    public static final EnumProperty<BigSmallBlock> SIZE = WNBlockProperties.SIZE;

    public WNOreDoubleFormationBlock(ResourceLocation location, Properties properties, Ore ore) {
        super(location, properties, ore);
    }

    public WNOreDoubleFormationBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, Ore ore) {
        super(location, properties, itemProperties, ore);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.defaultBlockState().setValue(SIZE,BigSmallBlock.SMALL));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(SIZE);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_SizedFormation(this.getRegistryName());
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state == null){
            return null;
        }

        return state.setValue(SIZE, WNUtil.rint(0,2) == 0 ? BigSmallBlock.BIG : BigSmallBlock.SMALL);
    }
}
