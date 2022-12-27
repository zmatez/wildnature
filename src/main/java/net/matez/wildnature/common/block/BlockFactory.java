package net.matez.wildnature.common.block;

import net.minecraft.world.level.block.Block;

@FunctionalInterface
public interface BlockFactory<T,U extends Block> {
    U register(T value);
}
