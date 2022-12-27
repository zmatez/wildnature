/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.underwater_plants;

import net.matez.wildnature.common.block.plant.vines.WNAbstractVineBlock;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.common.registry.setup.WNRenderType;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_Vine;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_Vine;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;

public class WNUnderwaterVineBlock extends WNAbstractVineBlock implements LiquidBlockContainer {
    protected final UnderwaterPlant underwaterPlant;

    public WNUnderwaterVineBlock(ResourceLocation location, Properties properties, UnderwaterPlant underwaterPlant) {
        super(location, properties);
        this.underwaterPlant = underwaterPlant;
    }

    public WNUnderwaterVineBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, UnderwaterPlant underwaterPlant) {
        super(location, properties, itemProperties);
        this.underwaterPlant = underwaterPlant;
    }

    @Override
    public WNRenderType getRenderType() {
        return WNRenderType.CUTOUT;
    }

    public FluidState getFluidState(BlockState p_154537_) {
        return Fluids.WATER.getSource(false);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8 ? super.getStateForPlacement(context) : null;
    }

    public BlockState updateShape(BlockState p_154530_, Direction p_154531_, BlockState p_154532_, LevelAccessor state, BlockPos pos, BlockPos p_154535_) {
        BlockState blockstate = super.updateShape(p_154530_, p_154531_, p_154532_, state, pos, p_154535_);
        if (!blockstate.isAir()) {
            state.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(state));
        }

        return blockstate;
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter p_54766_, BlockPos p_54767_, BlockState p_54768_, Fluid p_54769_) {
        return false;
    }

    @Override
    public boolean placeLiquid(LevelAccessor p_54770_, BlockPos p_54771_, BlockState p_54772_, FluidState p_54773_) {
        return false;
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Vine(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new WNBlock.ModelList().with(
                new WNBlockModel_Vine(this.getRegName()).with("texture",this.getTextureName("plants/water/" + this.underwaterPlant.getFolder()))
        );
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("plants/water/" + underwaterPlant.getFolder()) + "_item");
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.CLIMBABLE
        );
    }
}
