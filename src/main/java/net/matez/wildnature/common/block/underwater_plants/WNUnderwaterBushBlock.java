/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.underwater_plants;

import net.matez.wildnature.common.block.plant.BushPlacement;
import net.matez.wildnature.common.block.plant.WNBushBlock;
import net.matez.wildnature.common.block.plant.config.BushConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class WNUnderwaterBushBlock extends WNBushBlock implements LiquidBlockContainer, net.minecraftforge.common.IForgeShearable {
   protected final UnderwaterPlant underwaterPlant;

   private static final BushConfig config = new BushConfig().notTinted().withPlacement(BushPlacement.DIRT_OR_SAND);

   public WNUnderwaterBushBlock(Properties properties, UnderwaterPlant underwaterPlant) {
      super(properties, config);
      this.underwaterPlant = underwaterPlant;
   }

   public VoxelShape getShape(BlockState p_154525_, BlockGetter p_154526_, BlockPos p_154527_, CollisionContext p_154528_) {
      return SHAPE;
   }

   @Nullable
   public BlockState getStateForPlacement(BlockPlaceContext p_154503_) {
      FluidState fluidstate = p_154503_.getLevel().getFluidState(p_154503_.getClickedPos());
      return fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8 ? super.getStateForPlacement(p_154503_) : null;
   }

   @Override
   public BlockState updateShape(BlockState p_154530_, Direction p_154531_, BlockState p_154532_, LevelAccessor p_154533_, BlockPos p_154534_, BlockPos p_154535_) {
      BlockState blockstate = super.updateShape(p_154530_, p_154531_, p_154532_, p_154533_, p_154534_, p_154535_);
      if (!blockstate.isAir()) {
         p_154533_.scheduleTick(p_154534_, Fluids.WATER, Fluids.WATER.getTickDelay(p_154533_));
      }

      return blockstate;
   }

   @Override
   public FluidState getFluidState(BlockState p_154537_) {
      return Fluids.WATER.getSource(false);
   }

   @Override
   public boolean canPlaceLiquid(BlockGetter p_154505_, BlockPos p_154506_, BlockState p_154507_, Fluid p_154508_) {
      return false;
   }

   @Override
   public boolean placeLiquid(LevelAccessor p_154520_, BlockPos p_154521_, BlockState p_154522_, FluidState p_154523_) {
      return false;
   }
}