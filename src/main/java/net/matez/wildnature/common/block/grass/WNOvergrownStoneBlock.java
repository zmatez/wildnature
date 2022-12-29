/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.grass;

import net.matez.wildnature.common.WNBlock;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WNOvergrownStoneBlock extends GrassBlock implements BonemealableBlock, WNBlock {
    private final OvergrownGrassType overgrownType;

    public WNOvergrownStoneBlock(Properties properties, OvergrownGrassType overgrownType) {
        super(properties);
        this.overgrownType = overgrownType;
    }

    public Block getDirt() {
        return overgrownType.getBaseBlock().get();
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        if (!this.overgrownType.isTinted()) {
            return null;
        }
        return (state, getter, pos, num) -> {
            return getter != null && pos != null ? BiomeColors.getAverageGrassColor(getter, pos) : GrassColor.get(0.5D, 1.0D);
        };
    }

    @Nullable
    @Override
    public ItemColor getItemColor(BlockColors colors) {
        if (!this.overgrownType.isTinted()) {
            return null;
        }
        return (stack, num) -> {
            BlockState blockstate = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(blockstate, null, null, num);
        };
    }
}