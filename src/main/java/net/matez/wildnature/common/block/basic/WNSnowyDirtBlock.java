package net.matez.wildnature.common.block.basic;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public abstract class WNSnowyDirtBlock extends WNBlock {
   public static final BooleanProperty SNOWY = BlockStateProperties.SNOWY;

   public WNSnowyDirtBlock(ResourceLocation location, Properties properties) {
      super(location, properties);
   }

   public WNSnowyDirtBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
      super(location, properties, itemProperties);
   }

   public WNSnowyDirtBlock(ResourceLocation location, Properties properties, WNBlockItem item) {
      super(location, properties, item);
   }

   @Override
   public void construct() {
      super.construct();
      this.registerDefaultState(this.stateDefinition.any().setValue(SNOWY, Boolean.valueOf(false)));
   }

   public BlockState updateShape(BlockState p_56644_, Direction p_56645_, BlockState p_56646_, LevelAccessor p_56647_, BlockPos p_56648_, BlockPos p_56649_) {
      return p_56645_ == Direction.UP ? p_56644_.setValue(SNOWY, Boolean.valueOf(isSnowySetting(p_56646_))) : super.updateShape(p_56644_, p_56645_, p_56646_, p_56647_, p_56648_, p_56649_);
   }

   public BlockState getStateForPlacement(BlockPlaceContext p_56642_) {
      BlockState blockstate = p_56642_.getLevel().getBlockState(p_56642_.getClickedPos().above());
      return this.defaultBlockState().setValue(SNOWY, Boolean.valueOf(isSnowySetting(blockstate)));
   }

   private static boolean isSnowySetting(BlockState p_154649_) {
      return p_154649_.is(BlockTags.SNOW);
   }

   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_56651_) {
      p_56651_.add(SNOWY);
   }
}