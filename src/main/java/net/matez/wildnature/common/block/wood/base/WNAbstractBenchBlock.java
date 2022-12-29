/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.base;

import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.block.entity.seat.WNSeatBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public abstract class WNAbstractBenchBlock extends BaseEntityBlock {
    public static final EnumProperty<BenchPart> BENCH_PART = WNBlockProperties.BENCH_PART;
    public static DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 11, 16);

    public WNAbstractBenchBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(BENCH_PART,FACING);
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state == null){
            return null;
        }
        return this.getBenchState(state, context.getLevel(), context.getClickedPos(), context.getHorizontalDirection());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
        return this.getBenchState(state,level,pos,state.getValue(FACING));
    }

    private BlockState getBenchState(BlockState state, LevelAccessor level, BlockPos pos, Direction dir) {
        boolean left = this.isBench(level, pos, dir.getClockWise(Direction.Axis.Y), dir);
        boolean right = this.isBench(level, pos, dir.getCounterClockWise(Direction.Axis.Y), dir);
        state = state.setValue(FACING, dir);
        if (left && right) {
            return state.setValue(BENCH_PART, BenchPart.MIDDLE);
        } else if (left) {
            return state.setValue(BENCH_PART, BenchPart.LEFT);
        } else {
            return right ? state.setValue(BENCH_PART, BenchPart.RIGHT) : state.setValue(BENCH_PART, BenchPart.SINGLE);
        }
    }

    private boolean isBench(LevelAccessor level, BlockPos source, Direction direction, Direction targetDirection) {
        BlockState state = level.getBlockState(source.relative(direction));
        if(state.getBlock() == this) {
            Direction sofaDirection = state.getValue(FACING);
            return sofaDirection.equals(targetDirection);
        }
        return false;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WNSeatBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_54296_) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        BlockEntity entity = level.getBlockEntity(pos);
        if (entity instanceof WNSeatBlockEntity seat && !level.isClientSide()) {
            if (!seat.isOccupied()) {
                seat.seat(player, 11f / 16F - 0.4F);
                return InteractionResult.SUCCESS;
            }
        }

        return super.use(state, level, pos, player, hand, result);
    }

    @Override
    public void destroy(LevelAccessor accessor, BlockPos pos, BlockState state) {
        BlockEntity entity = accessor.getBlockEntity(pos);
        if (entity instanceof WNSeatBlockEntity seat && !accessor.isClientSide()) {
            seat.destroy();
        }
        super.destroy(accessor, pos, state);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level world, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        BlockEntity entity = world.getBlockEntity(pos);
        if (entity instanceof WNSeatBlockEntity seat && !world.isClientSide()) {
            seat.destroy();
        }
        return super.onDestroyedByPlayer(state, world, pos, player, willHarvest, fluid);
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor world, BlockPos pos, Rotation direction) {
        return super.rotate(state, world, pos, direction).setValue(FACING, WNBlockProperties.rotate(state.getValue(FACING), direction));
    }
}
