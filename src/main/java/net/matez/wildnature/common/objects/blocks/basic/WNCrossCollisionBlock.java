package net.matez.wildnature.common.objects.blocks.basic;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.items.setup.WNBlockItem;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public abstract class WNCrossCollisionBlock extends WNBlock implements SimpleWaterloggedBlock {
   public static final BooleanProperty NORTH = PipeBlock.NORTH;
   public static final BooleanProperty EAST = PipeBlock.EAST;
   public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
   public static final BooleanProperty WEST = PipeBlock.WEST;
   public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
   protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter((p_52346_) -> {
      return p_52346_.getKey().getAxis().isHorizontal();
   }).collect(Util.toMap());
   protected final VoxelShape[] collisionShapeByIndex;
   protected final VoxelShape[] shapeByIndex;
   private final Object2IntMap<BlockState> stateToIndex = new Object2IntOpenHashMap<>();

   public WNCrossCollisionBlock(ResourceLocation location, float p_52320_, float p_52321_, float p_52322_, float p_52323_, float p_52324_, Properties properties) {
      super(location, properties);
      this.collisionShapeByIndex = this.makeShapes(p_52320_, p_52321_, p_52324_, 0.0F, p_52324_);
      this.shapeByIndex = this.makeShapes(p_52320_, p_52321_, p_52322_, 0.0F, p_52323_);
   }

   public WNCrossCollisionBlock(ResourceLocation location, float p_52320_, float p_52321_, float p_52322_, float p_52323_, float p_52324_, Properties properties, Item.Properties itemProperties) {
      super(location, properties, itemProperties);
      this.collisionShapeByIndex = this.makeShapes(p_52320_, p_52321_, p_52324_, 0.0F, p_52324_);
      this.shapeByIndex = this.makeShapes(p_52320_, p_52321_, p_52322_, 0.0F, p_52323_);
   }

   public WNCrossCollisionBlock(ResourceLocation location, float p_52320_, float p_52321_, float p_52322_, float p_52323_, float p_52324_, Properties properties, WNBlockItem item) {
      super(location, properties, item);
      this.collisionShapeByIndex = this.makeShapes(p_52320_, p_52321_, p_52324_, 0.0F, p_52324_);
      this.shapeByIndex = this.makeShapes(p_52320_, p_52321_, p_52322_, 0.0F, p_52323_);
   }

   @Override
   public void construct() {
      super.construct();
   }

   protected VoxelShape[] makeShapes(float p_52327_, float p_52328_, float p_52329_, float p_52330_, float p_52331_) {
      float f = 8.0F - p_52327_;
      float f1 = 8.0F + p_52327_;
      float f2 = 8.0F - p_52328_;
      float f3 = 8.0F + p_52328_;
      VoxelShape voxelshape = Block.box(f, 0.0D, f, f1, p_52329_, f1);
      VoxelShape voxelshape1 = Block.box(f2, p_52330_, 0.0D, f3, p_52331_, f3);
      VoxelShape voxelshape2 = Block.box(f2, p_52330_, f2, f3, p_52331_, 16.0D);
      VoxelShape voxelshape3 = Block.box(0.0D, p_52330_, f2, f3, p_52331_, f3);
      VoxelShape voxelshape4 = Block.box(f2, p_52330_, f2, 16.0D, p_52331_, f3);
      VoxelShape voxelshape5 = Shapes.or(voxelshape1, voxelshape4);
      VoxelShape voxelshape6 = Shapes.or(voxelshape2, voxelshape3);
      VoxelShape[] avoxelshape = new VoxelShape[]{Shapes.empty(), voxelshape2, voxelshape3, voxelshape6, voxelshape1, Shapes.or(voxelshape2, voxelshape1), Shapes.or(voxelshape3, voxelshape1), Shapes.or(voxelshape6, voxelshape1), voxelshape4, Shapes.or(voxelshape2, voxelshape4), Shapes.or(voxelshape3, voxelshape4), Shapes.or(voxelshape6, voxelshape4), voxelshape5, Shapes.or(voxelshape2, voxelshape5), Shapes.or(voxelshape3, voxelshape5), Shapes.or(voxelshape6, voxelshape5)};

      for(int i = 0; i < 16; ++i) {
         avoxelshape[i] = Shapes.or(voxelshape, avoxelshape[i]);
      }

      return avoxelshape;
   }

   public boolean propagatesSkylightDown(BlockState p_52348_, BlockGetter p_52349_, BlockPos p_52350_) {
      return !p_52348_.getValue(WATERLOGGED);
   }

   public VoxelShape getShape(BlockState p_52352_, BlockGetter p_52353_, BlockPos p_52354_, CollisionContext p_52355_) {
      return this.shapeByIndex[this.getAABBIndex(p_52352_)];
   }

   public VoxelShape getCollisionShape(BlockState p_52357_, BlockGetter p_52358_, BlockPos p_52359_, CollisionContext p_52360_) {
      return this.collisionShapeByIndex[this.getAABBIndex(p_52357_)];
   }

   private static int indexFor(Direction p_52344_) {
      return 1 << p_52344_.get2DDataValue();
   }

   protected int getAABBIndex(BlockState p_52364_) {
      return this.stateToIndex.computeIntIfAbsent(p_52364_, (p_52366_) -> {
         int i = 0;
         if (p_52366_.getValue(NORTH)) {
            i |= indexFor(Direction.NORTH);
         }

         if (p_52366_.getValue(EAST)) {
            i |= indexFor(Direction.EAST);
         }

         if (p_52366_.getValue(SOUTH)) {
            i |= indexFor(Direction.SOUTH);
         }

         if (p_52366_.getValue(WEST)) {
            i |= indexFor(Direction.WEST);
         }

         return i;
      });
   }

   public FluidState getFluidState(BlockState p_52362_) {
      return p_52362_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_52362_);
   }

   public boolean isPathfindable(BlockState p_52333_, BlockGetter p_52334_, BlockPos p_52335_, PathComputationType p_52336_) {
      return false;
   }

   public BlockState rotate(BlockState p_52341_, Rotation p_52342_) {
      switch(p_52342_) {
      case CLOCKWISE_180:
         return p_52341_.setValue(NORTH, p_52341_.getValue(SOUTH)).setValue(EAST, p_52341_.getValue(WEST)).setValue(SOUTH, p_52341_.getValue(NORTH)).setValue(WEST, p_52341_.getValue(EAST));
      case COUNTERCLOCKWISE_90:
         return p_52341_.setValue(NORTH, p_52341_.getValue(EAST)).setValue(EAST, p_52341_.getValue(SOUTH)).setValue(SOUTH, p_52341_.getValue(WEST)).setValue(WEST, p_52341_.getValue(NORTH));
      case CLOCKWISE_90:
         return p_52341_.setValue(NORTH, p_52341_.getValue(WEST)).setValue(EAST, p_52341_.getValue(NORTH)).setValue(SOUTH, p_52341_.getValue(EAST)).setValue(WEST, p_52341_.getValue(SOUTH));
      default:
         return p_52341_;
      }
   }

   public BlockState mirror(BlockState p_52338_, Mirror p_52339_) {
      switch(p_52339_) {
      case LEFT_RIGHT:
         return p_52338_.setValue(NORTH, p_52338_.getValue(SOUTH)).setValue(SOUTH, p_52338_.getValue(NORTH));
      case FRONT_BACK:
         return p_52338_.setValue(EAST, p_52338_.getValue(WEST)).setValue(WEST, p_52338_.getValue(EAST));
      default:
         return super.mirror(p_52338_, p_52339_);
      }
   }
}