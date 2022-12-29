/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant.flowering;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNBushConfiguredBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WNCloverBlock extends WNBushConfiguredBlock {
    public static final IntegerProperty CLOVER_STAGE = WNBlockProperties.CLOVER_STAGE;
    private static final double OFFSET = 1.5D;
    protected static final VoxelShape SHAPE_STAGE_0 = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 3.0D, 16.0D - OFFSET);
    protected static final VoxelShape SHAPE_STAGE_1 = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 6.0D, 16.0D - OFFSET);
    protected static final VoxelShape SHAPE_STAGE_2 = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 9.0D, 16.0D - OFFSET);

    public WNCloverBlock(Properties properties, BushType type) {
        super(properties, type);
    }

    public void place(BlockState state, LevelAccessor reader, BlockPos pos, int data) {
        reader.setBlock(pos, state.setValue(CLOVER_STAGE, ExtraMath.rint(0, 2, reader.getRandom())), data);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(CLOVER_STAGE) < 2;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);

        int stage = state.getValue(CLOVER_STAGE);
        if (stage < 2) {
            level.setBlock(pos, state.setValue(CLOVER_STAGE, stage + 1), 3);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        def.add(CLOVER_STAGE);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);

        int stage = state.getValue(CLOVER_STAGE);
        switch (stage){
            case 0 -> {
                return SHAPE_STAGE_0.move(vec3.x, vec3.y, vec3.z);
            }
            case 1 -> {
                return SHAPE_STAGE_1.move(vec3.x, vec3.y, vec3.z);
            }
            case 2 -> {
                return SHAPE_STAGE_2.move(vec3.x, vec3.y, vec3.z);
            }
        }

        return SHAPE_STAGE_0.move(vec3.x, vec3.y, vec3.z);
    }
}
