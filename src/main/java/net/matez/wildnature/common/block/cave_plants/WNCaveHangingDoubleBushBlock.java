/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.cave_plants;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class WNCaveHangingDoubleBushBlock extends WNCaveBushBlock {
   private static final double OFFSET = 3D;
   protected static final VoxelShape SHAPE = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 16.0D, 16.0D - OFFSET);

   public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

   public WNCaveHangingDoubleBushBlock(Properties properties, CavePlantType type) {
      super(properties, type);
      this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.UPPER));

   }

   @Override
   public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
      DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
      System.out.println(direction + "/ " + doubleblockhalf);
      if (direction.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.UPPER != (direction == Direction.UP) || state2.is(this) && state2.getValue(HALF) != doubleblockhalf) {
         return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state2, level, pos, pos2);
      } else {
         return Blocks.AIR.defaultBlockState();
      }
   }

   @Nullable
   public BlockState getStateForPlacement(BlockPlaceContext context) {
      BlockPos blockpos = context.getClickedPos();
      Level level = context.getLevel();
      return blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.below()).canBeReplaced(context) ? super.getStateForPlacement(context) : null;
   }

   @Override
   public void setPlacedBy(Level p_52872_, BlockPos p_52873_, BlockState p_52874_, LivingEntity p_52875_, ItemStack p_52876_) {
      BlockPos blockpos = p_52873_.below();
      p_52872_.setBlock(blockpos, copyWaterloggedFrom(p_52872_, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER)), 3);
   }

   @Override
   public boolean canSurvive(BlockState blockState, LevelReader reader, BlockPos pos) {
       if (blockState.getValue(HALF) == DoubleBlockHalf.UPPER) {
           BlockPos blockpos = pos.above();
           if (blockState.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
               return (reader.getBlockState(blockpos).canSustainPlant(reader, blockpos, Direction.DOWN, this) && this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos))
                       || this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos);
           return this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos);
       } else {
           BlockState blockstate = reader.getBlockState(pos.above());
           if (blockState.getBlock() != this)
               return super.canSurvive(blockState, reader, pos); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
           return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.UPPER;
       }
   }

   protected boolean mayPlaceOn(BlockState stateOn, BlockGetter getter, BlockPos pos) {
      return super.mayPlaceOn(stateOn,getter,pos) || stateOn.is(this);
   }

   public static void placeAt(LevelAccessor level, BlockState state, BlockPos pos, int arg) {
      BlockPos blockpos = pos.below();
      level.setBlock(pos, copyWaterloggedFrom(level, pos, state.setValue(HALF, DoubleBlockHalf.UPPER)), arg);
      level.setBlock(blockpos, copyWaterloggedFrom(level, blockpos, state.setValue(HALF, DoubleBlockHalf.LOWER)), arg);
   }

   public static BlockState copyWaterloggedFrom(LevelReader p_182454_, BlockPos p_182455_, BlockState p_182456_) {
      return p_182456_.hasProperty(BlockStateProperties.WATERLOGGED) ? p_182456_.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(p_182454_.isWaterAt(p_182455_))) : p_182456_;
   }

   public void playerWillDestroy(Level p_52878_, BlockPos p_52879_, BlockState p_52880_, Player p_52881_) {
      if (!p_52878_.isClientSide) {
         if (p_52881_.isCreative()) {
            preventCreativeDropFromBottomPart(p_52878_, p_52879_, p_52880_, p_52881_);
         } else {
            dropResources(p_52880_, p_52878_, p_52879_, (BlockEntity)null, p_52881_, p_52881_.getMainHandItem());
         }
      }

      super.playerWillDestroy(p_52878_, p_52879_, p_52880_, p_52881_);
   }

   public void playerDestroy(Level p_52865_, Player p_52866_, BlockPos p_52867_, BlockState p_52868_, @Nullable BlockEntity p_52869_, ItemStack p_52870_) {
      super.playerDestroy(p_52865_, p_52866_, p_52867_, Blocks.AIR.defaultBlockState(), p_52869_, p_52870_);
   }

   public static void preventCreativeDropFromBottomPart(Level p_52904_, BlockPos p_52905_, BlockState p_52906_, Player p_52907_) {
      DoubleBlockHalf doubleblockhalf = p_52906_.getValue(HALF);
      if (doubleblockhalf == DoubleBlockHalf.UPPER) {
         BlockPos blockpos = p_52905_.above();
         BlockState blockstate = p_52904_.getBlockState(blockpos);
         if (blockstate.is(p_52906_.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
            BlockState blockstate1 = blockstate.hasProperty(BlockStateProperties.WATERLOGGED) && blockstate.getValue(BlockStateProperties.WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
            p_52904_.setBlock(blockpos, blockstate1, 35);
            p_52904_.levelEvent(p_52907_, 2001, blockpos, Block.getId(blockstate));
         }
      }

   }

   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
      state.add(HALF);
   }

   public OffsetType getOffsetType() {
      return OffsetType.XZ;
   }

   public long getSeed(BlockState p_52891_, BlockPos p_52892_) {
      return Mth.getSeed(p_52892_.getX(), p_52892_.below(p_52891_.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), p_52892_.getZ());
   }

   public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
      Vec3 vec3 = state.getOffset(getter, pos);
      return SHAPE.move(vec3.x, vec3.y, vec3.z);
   }
}
