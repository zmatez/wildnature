/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant;

import net.matez.wildnature.common.block.plant.config.BushConfig;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.common.registry.setup.WNRenderType;
import net.matez.wildnature.data.blockstates.WNBlockstate_Cube;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public abstract class WNBushBlock extends WNBlock implements net.minecraftforge.common.IPlantable {
    private static final double OFFSET = 3D;
    protected static final VoxelShape SHAPE = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 10.0D, 16.0D - OFFSET);

    @Nullable
    private BushConfig config;

    public WNBushBlock(ResourceLocation location, Properties properties, @Nullable BushConfig config) {
        super(location, properties);
        this.config = config;
    }

    public WNBushBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, @Nullable BushConfig config) {
        super(location, properties, itemProperties);
        this.config = config;
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return defaultBlockState();
        return state;
    }

    protected boolean mayPlaceOn(BlockState state, BlockState stateOn, BlockGetter getter, BlockPos pos) {
        return getConfig() != null ? getConfig().getPlacement().getSupplier().canPlace(state, stateOn, getter, pos) : BushPlacement.DIRT.getSupplier().canPlace(state, stateOn, getter, pos);
    }

    public BlockState updateShape(BlockState p_51032_, Direction p_51033_, BlockState p_51034_, LevelAccessor p_51035_, BlockPos p_51036_, BlockPos p_51037_) {
        return !p_51032_.canSurvive(p_51035_, p_51036_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_51032_, p_51033_, p_51034_, p_51035_, p_51036_, p_51037_);
    }

    public boolean canSurvive(BlockState blockState, LevelReader reader, BlockPos pos) {
        BlockPos blockpos = pos.below();
        if (blockState.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return (reader.getBlockState(blockpos).canSustainPlant(reader, blockpos, Direction.UP, this) && this.mayPlaceOn(blockState, reader.getBlockState(blockpos), reader, blockpos))
                    || this.mayPlaceOn(blockState, reader.getBlockState(blockpos), reader, blockpos);
        return this.mayPlaceOn(blockState, reader.getBlockState(blockpos), reader, blockpos);
    }

    public void place(BlockState state, LevelAccessor reader, BlockPos pos, int data) {
        reader.setBlock(pos, state, data);
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    public boolean isPathfindable(BlockState p_51023_, BlockGetter p_51024_, BlockPos p_51025_, PathComputationType p_51026_) {
        return p_51026_ == PathComputationType.AIR && !this.hasCollision ? true : super.isPathfindable(p_51023_, p_51024_, p_51025_, p_51026_);
    }

    @Override
    public WNRenderType getRenderType() {
        return WNRenderType.CUTOUT;
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

    @javax.annotation.Nullable
    public abstract WNResource getItemModel();

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Cube(this.getRegistryName());
    }

    @Override
    public abstract ModelList getBlockModels();

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FLOWERS, WNTags.SMALL_FLOWERS, WNTags.ENDERMAN_HOLDABLE, WNTags.WN_FLOWERING_PLANTS
        );
    }
}
