package net.matez.wildnature.common.objects.blocks.plant;

import net.matez.wildnature.common.objects.blocks.plant.plants.TripleBlockHalf;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_TripleBush;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class WNTriplePlantBlock extends WNBushConfiguredBlock {
   private static final double OFFSET = 3D;
   protected static final VoxelShape SHAPE = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 16.0D, 16.0D - OFFSET);

   public static final EnumProperty<TripleBlockHalf> HALF = WNBlockProperties.TRIPLE_BLOCK_HALF;

   public WNTriplePlantBlock(ResourceLocation location, Properties properties, BushType type) {
      super(location, properties, type);
   }

   public WNTriplePlantBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
      super(location, properties, itemProperties, type);
   }

   @Override
   public void construct() {
      super.construct();
      this.registerDefaultState(this.stateDefinition.any().setValue(HALF, TripleBlockHalf.LOWER));
   }

   public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
      TripleBlockHalf tripleBlockHalf = state.getValue(HALF);
      if (direction.getAxis() != Direction.Axis.Y || tripleBlockHalf == TripleBlockHalf.LOWER != (direction == Direction.UP) || state2.is(this) && state2.getValue(HALF) != tripleBlockHalf) {
         return tripleBlockHalf == TripleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state2, level, pos, pos2);
      } else {
         return Blocks.AIR.defaultBlockState();
      }
   }

   @Nullable
   public BlockState getStateForPlacement(BlockPlaceContext context) {
      BlockPos blockpos = context.getClickedPos();
      Level level = context.getLevel();
      return blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(context) ? super.getStateForPlacement(context) : null;
   }

   public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
      level.setBlock(pos, copyWaterloggedFrom(level, pos, this.defaultBlockState().setValue(HALF, TripleBlockHalf.LOWER)), 3);
      level.setBlock(pos.above(), copyWaterloggedFrom(level, pos.above(), this.defaultBlockState().setValue(HALF, TripleBlockHalf.MIDDLE)), 3);
      level.setBlock(pos.above(2), copyWaterloggedFrom(level, pos.above(2), this.defaultBlockState().setValue(HALF, TripleBlockHalf.UPPER)), 3);
   }

   public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
      if (state.getValue(HALF) == TripleBlockHalf.LOWER) {
         return super.canSurvive(state, reader, pos);
      } else {
         BlockState blockstate = reader.getBlockState(pos.below());
         if (state.getBlock() != this) return super.canSurvive(state, reader, pos); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
         return blockstate.is(this) && (blockstate.getValue(HALF) == TripleBlockHalf.LOWER || blockstate.getValue(HALF) == TripleBlockHalf.MIDDLE);
      }
   }

   public static void placeAt(LevelAccessor level, BlockState state, BlockPos pos, int arg) {
      level.setBlock(pos, copyWaterloggedFrom(level, pos, state.setValue(HALF, TripleBlockHalf.LOWER)), arg);
      level.setBlock(pos.above(), copyWaterloggedFrom(level, pos.above(), state.setValue(HALF, TripleBlockHalf.MIDDLE)), arg);
      level.setBlock(pos.above(2), copyWaterloggedFrom(level, pos.above(2), state.setValue(HALF, TripleBlockHalf.UPPER)), arg);
   }

   public static BlockState copyWaterloggedFrom(LevelReader level, BlockPos pos, BlockState state) {
      return state.hasProperty(BlockStateProperties.WATERLOGGED) ? state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(level.isWaterAt(pos))) : state;
   }

   public void playerWillDestroy(Level level, BlockPos p_52879_, BlockState p_52880_, Player p_52881_) {
      if (!level.isClientSide) {
         if (p_52881_.isCreative()) {
            preventCreativeDropFromBottomPart(level, p_52879_, p_52880_, p_52881_);
         } else {
            dropResources(p_52880_, level, p_52879_, (BlockEntity)null, p_52881_, p_52881_.getMainHandItem());
         }
      }

      super.playerWillDestroy(level, p_52879_, p_52880_, p_52881_);
   }

   public void playerDestroy(Level p_52865_, Player p_52866_, BlockPos p_52867_, BlockState p_52868_, @Nullable BlockEntity p_52869_, ItemStack p_52870_) {
      super.playerDestroy(p_52865_, p_52866_, p_52867_, Blocks.AIR.defaultBlockState(), p_52869_, p_52870_);
   }

   public static void preventCreativeDropFromBottomPart(Level block, BlockPos p_52905_, BlockState state, Player p_52907_) {
      TripleBlockHalf half = state.getValue(HALF);
      if (half != TripleBlockHalf.LOWER) {
         BlockPos blockpos = p_52905_.below();
         BlockState blockstate = block.getBlockState(blockpos);
         if (blockstate.is(state.getBlock()) && blockstate.getValue(HALF) == TripleBlockHalf.LOWER || blockstate.getValue(HALF) == TripleBlockHalf.MIDDLE) {
            BlockState blockstate1 = blockstate.hasProperty(BlockStateProperties.WATERLOGGED) && blockstate.getValue(BlockStateProperties.WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
            block.setBlock(blockpos, blockstate1, 35);
            block.levelEvent(p_52907_, 2001, blockpos, Block.getId(blockstate));
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
      return Mth.getSeed(p_52892_.getX(), p_52892_.below(p_52891_.getValue(HALF) == TripleBlockHalf.LOWER ? 0 : 1).getY(), p_52892_.getZ());
   }

   public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
      Vec3 vec3 = state.getOffset(getter, pos);
      return SHAPE.move(vec3.x, vec3.y, vec3.z);
   }


   @Override
   public WNResource getBlockstate() {
      return new WNBlockstate_TripleBush(this.getRegistryName());
   }

   @Override
   public ModelList getBlockModels() {
      return new ModelList().with(
              new WNBlockModel_TintedCross(this.getRegName() + "_bottom").with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_bottom"),
              new WNBlockModel_TintedCross(this.getRegName() + "_middle").with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_middle"),
              new WNBlockModel_TintedCross(this.getRegName() + "_top").with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_top")
      );
   }

   @Nullable
   public WNResource getItemModel() {
      if(getType().hasConfig() && getType().getConfig().isItemAsSelf()){
         return new WNItemModel_Generated(getRegName()).with("texture", this.getTextureName(getType().getVariant().getPath()) + "_top");
      }
      return super.getItemModel();
   }
}
