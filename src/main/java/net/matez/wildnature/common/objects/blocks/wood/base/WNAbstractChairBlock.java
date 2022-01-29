/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.wood.base;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.data.blockstates.WNBlockstate_FacedHorizCubeUvLock;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public abstract class WNAbstractChairBlock extends WNBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final VoxelShape SHAPE_BASE = Block.box(2D, 8D, 2D, 14D, 10D, 14.0D);
    public static final VoxelShape SHAPE_LEGS_NS = Shapes.or(
            Block.box(2D, 0D, 2D, 2D, 8D, 3.0D),
            Block.box(2D, 0D, 16 - 3D, 2D, 8D, 16 - 2.0D),

            Block.box(16 - 2D, 0D, 2D, 16 - 2D, 8D, 3.0D),
            Block.box(16 - 2D, 0D, 3, 16 - 2D, 8D, 16 - 2D)
            );

    public static final VoxelShape SHAPE_NORTH = Shapes.or(SHAPE_BASE,SHAPE_LEGS_NS);
    public static final VoxelShape SHAPE_SOUTH = Shapes.or(SHAPE_BASE,SHAPE_LEGS_NS);
    public static final VoxelShape SHAPE_EAST = Shapes.or(SHAPE_BASE,SHAPE_LEGS_NS);
    public static final VoxelShape SHAPE_WEST = Shapes.or(SHAPE_BASE,SHAPE_LEGS_NS);

    public WNAbstractChairBlock(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    public WNAbstractChairBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
        super(location, properties, itemProperties);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED,false).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    public BlockState rotate(BlockState p_54540_, Rotation p_54541_) {
        return p_54540_.setValue(FACING, p_54541_.rotate(p_54540_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_54537_, Mirror p_54538_) {
        return p_54537_.rotate(p_54538_.getRotation(p_54537_.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(blockpos);
        BlockState blockstate = super.getStateForPlacement(context);
        if (blockstate == null) {
            return null;
        }
        blockstate = blockstate.setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);

        return blockstate.setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        if(!super.canSurvive(state, reader, pos)){
            return false;
        }

        return reader.getBlockState(pos.below()).isCollisionShapeFullBlock(reader,pos.below());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighbour, LevelAccessor levelAccessor, BlockPos pos, BlockPos neighbourPos) {
        if(!canSurvive(state,levelAccessor,pos)){
            return Blocks.AIR.defaultBlockState();
        }
        return state;
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
            default -> null;
        };
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_FacedHorizCubeUvLock(this.getRegistryName());
    }

    public abstract Block getLog();
    public abstract Block getPlanks();

    @Override
    public abstract ModelList getBlockModels();
}
