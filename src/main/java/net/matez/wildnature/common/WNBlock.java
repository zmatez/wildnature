package net.matez.wildnature.common;

import net.matez.wildnature.common.structures.WNStructure;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public interface WNBlock {


    default RenderType getRenderType() {
        return RenderType.solid();
    };

    @Nullable
    default BlockColor getBlockColor() {
        return null;
    }

    @Nullable
    default ItemColor getItemColor(BlockColors blockColors) {
        return null;
    }

    default BlockState processStateOnPlace(LevelAccessor accessor, BlockState state, BlockPos pos, WNStructure structure, RandomSource random, @Nullable Rotation rotation) {
        return state;
    }
}
