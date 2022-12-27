package net.matez.wildnature.common;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.RenderType;
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
}
