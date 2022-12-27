/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant.plants;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNBushConfiguredBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public abstract class WNVerticalBushBlock extends WNBushConfiguredBlock {
    public static Map<Direction,VoxelShape> SHAPE = createFacingShape(1,3);
    public static Map<Direction, VoxelShape> createFacingShape(float thickness, float offset){
        return Maps.newEnumMap(ImmutableMap.of(
                Direction.NORTH, Block.box(offset, offset, 16 - thickness, 16.0D - offset, 16 - offset, 16.0D),
                Direction.SOUTH, Block.box(offset, offset, 0, 16.0D - offset, 16 - offset, thickness),
                Direction.EAST, Block.box(0, offset, offset, thickness, 16 - offset, 16.0D - offset),
                Direction.WEST, Block.box(16 - thickness, offset, offset, 16.0D, 16 - offset, 16.0D - offset),
                Direction.DOWN, Block.box(offset, 16 - thickness, offset, 16.0D - offset, 16.0D, 16.0D - offset),
                Direction.UP, Block.box(offset, 0.0D, offset, 16.0D - offset, thickness, 16.0D - offset)
        ));
    }

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public WNVerticalBushBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNVerticalBushBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        def.add(FACING);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null) {
            return null;
        }
        Direction direction = context.getClickedFace();
        if (!isDirectionAllowed(context, direction)) {
            return null;
        }

        state = state.setValue(FACING, direction);

        return canSurvive(state, context.getLevel(), context.getClickedPos()) ? state : null;
    }

    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return mayPlaceOn(state, reader.getBlockState(pos.relative(state.getValue(FACING).getOpposite())), reader, pos);
    }

    public VoxelShape getShape(BlockState p_58092_, BlockGetter p_58093_, BlockPos p_58094_, CollisionContext p_58095_) {
        return SHAPE.get(p_58092_.getValue(FACING));
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.NONE;
    }

    public boolean isDirectionAllowed(BlockPlaceContext context, Direction direction){
        return true;
    }

    public BlockState rotate(BlockState p_154354_, Rotation p_154355_) {
        return p_154354_.setValue(FACING, p_154355_.rotate(p_154354_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_154351_, Mirror p_154352_) {
        return p_154351_.setValue(FACING, p_154352_.mirror(p_154351_.getValue(FACING)));
    }
}
