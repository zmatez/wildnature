/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.cave_plants;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WNCaveHangingBushBlock extends WNCaveBushBlock{
    private static final double OFFSET = 3D;
    protected static final VoxelShape SHAPE = Block.box(OFFSET, OFFSET, OFFSET, 16.0D - OFFSET, 16.0D, 16.0D - OFFSET);

    public WNCaveHangingBushBlock(Properties properties, CavePlantType type) {
        super(properties, type);
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader reader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        if (blockState.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return (reader.getBlockState(blockpos).canSustainPlant(reader, blockpos, Direction.DOWN, this) && this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos))
                    || this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos);
        return this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

}
