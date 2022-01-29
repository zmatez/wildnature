/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.wood.base;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.data.blockstates.WNBlockstate_Bench;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public abstract class WNAbstractBenchBlock extends WNBlock {
    public static final EnumProperty<BenchPart> BENCH_PART = WNBlockProperties.BENCH_PART;
    public static DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE = Block.box(0,0,0,16,11,16);

    public WNAbstractBenchBlock(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    public WNAbstractBenchBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
        super(location, properties, itemProperties);
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
        return this.getBenchState(state,context.getLevel(),context.getClickedPos(),state.getValue(FACING));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
        return this.getBenchState(state,level,pos,state.getValue(FACING));
    }

    private BlockState getBenchState(BlockState state, LevelAccessor level, BlockPos pos, Direction dir) {
        boolean left = this.isBench(level, pos, dir.getClockWise(Direction.Axis.Y), dir);
        boolean right = this.isBench(level, pos, dir.getCounterClockWise(Direction.Axis.Y), dir);
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

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Bench(this.getRegistryName());
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_BlockParent(getRegName()).with("parent",this.getRegName() + "_single");
    }

    @Override
    public abstract ModelList getBlockModels();
}
