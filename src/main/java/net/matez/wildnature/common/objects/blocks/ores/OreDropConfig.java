/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.ores;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

public interface OreDropConfig {
    ItemStack getDrops(BlockState state, ServerLevel level, float luck);

    int getExpDrops(BlockState state, LevelReader reader, int fortune, int silkTouch);
}
