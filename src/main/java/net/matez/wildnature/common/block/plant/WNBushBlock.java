/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant;

import net.matez.wildnature.common.WNBlock;
import net.matez.wildnature.common.block.plant.config.BushConfig;
import net.matez.wildnature.common.tags.WNTags;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public abstract class WNBushBlock extends BushBlock implements WNBlock {
    private static final double OFFSET = 3D;
    protected static final VoxelShape SHAPE = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 10.0D, 16.0D - OFFSET);

    @Nullable
    private BushConfig config;

    public WNBushBlock(Properties properties, @Nullable BushConfig config) {
        super(properties);
        this.config = config;
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return defaultBlockState();
        return state;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return getConfig() != null ? getConfig().getPlacement().getSupplier().canPlace(state, getter, pos) : BushPlacement.DIRT.getSupplier().canPlace(state, getter, pos);
    }

    @Override
    public BlockState updateShape(BlockState p_51032_, Direction p_51033_, BlockState p_51034_, LevelAccessor p_51035_, BlockPos p_51036_, BlockPos p_51037_) {
        return !p_51032_.canSurvive(p_51035_, p_51036_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_51032_, p_51033_, p_51034_, p_51035_, p_51036_, p_51037_);
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader reader, BlockPos pos) {
        BlockPos blockpos = pos.below();
        if (blockState.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return (reader.getBlockState(blockpos).canSustainPlant(reader, blockpos, Direction.UP, this) && this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos))
                    || this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos);
        return this.mayPlaceOn(reader.getBlockState(blockpos), reader, blockpos);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    @Override
    public boolean isPathfindable(BlockState p_51023_, BlockGetter p_51024_, BlockPos p_51025_, PathComputationType p_51026_) {
        return p_51026_ == PathComputationType.AIR && !this.hasCollision || super.isPathfindable(p_51023_, p_51024_, p_51025_, p_51026_);
    }

    @Override
    public RenderType getRenderType() {
        return RenderType.cutout();
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    @Nullable
    public BushConfig getConfig() {
        return config;
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        if (this.getConfig() != null && !this.getConfig().isTinted()) {
            return null;
        }
        return (state, getter, pos, num) -> {
            if(this.getConfig() != null && this.getConfig().isGrassTint()){
                return getter != null && pos != null ? BiomeColors.getAverageGrassColor(getter, pos) : GrassColor.get(0.5D, 1.0D);
            }
            return getter != null && pos != null ? BiomeColors.getAverageFoliageColor(getter, pos) : FoliageColor.get(0.5D, 1.0D);
        };
    }

    @Nullable
    @Override
    public ItemColor getItemColor(BlockColors colors) {
        if (this.getConfig() == null || (this.getConfig() != null && !this.getConfig().isItemTinted())) {
            return null;
        }
        return (stack, num) -> {
            BlockState blockstate = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(blockstate, null, null, num);
        };
    }
}