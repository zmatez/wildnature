/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class WNBushConfiguredBlock extends WNBushBlock implements net.minecraftforge.common.IPlantable {
    private BushType type;
    private static final double OFFSET = 3D;
    protected static final VoxelShape SHAPE = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 10.0D, 16.0D - OFFSET);

    public WNBushConfiguredBlock(Properties properties, BushType type) {
        super(properties,type.getConfig());
        this.type = type;
    }

    @Override
    protected boolean mayPlaceOn(BlockState stateOn, BlockGetter getter, BlockPos pos) {
        return getType().hasConfig() ? getType().getConfig().getPlacement().getSupplier().canPlace(stateOn, getter, pos) : BushPlacement.DIRT.canPlace(stateOn, getter, pos);
    }

    public BlockState updateShape(BlockState p_51032_, Direction p_51033_, BlockState p_51034_, LevelAccessor p_51035_, BlockPos p_51036_, BlockPos p_51037_) {
        return !p_51032_.canSurvive(p_51035_, p_51036_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_51032_, p_51033_, p_51034_, p_51035_, p_51036_, p_51037_);
    }

    public BushType getType() {
        return type;
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        if (this.getType().hasConfig() && !this.getType().getConfig().isTinted()) {
            return null;
        }
        return (state, getter, pos, num) -> {
            if(this.getType().hasConfig() && this.getType().getConfig().isGrassTint()){
                return getter != null && pos != null ? BiomeColors.getAverageGrassColor(getter, pos) : GrassColor.get(0.5D, 1.0D);
            }
            return getter != null && pos != null ? BiomeColors.getAverageFoliageColor(getter, pos) : FoliageColor.get(0.5D, 1.0D);
        };
    }

    @Nullable
    @Override
    public ItemColor getItemColor(BlockColors colors) {
        if (!this.getType().hasConfig() || (this.getType().hasConfig() && !this.getType().getConfig().isItemTinted())) {
            return null;
        }
        return (stack, num) -> {
            BlockState blockstate = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(blockstate, null, null, num);
        };
    }
}
