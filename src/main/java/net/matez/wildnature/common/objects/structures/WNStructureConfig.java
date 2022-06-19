/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.structures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Random;

public interface WNStructureConfig {
    static BlockState changeState(BlockState state, Block block) {
        BlockState newState = block.defaultBlockState();
        for (Map.Entry<Property<?>, Comparable<?>> entry : state.getValues().entrySet()) {
            Property key = entry.getKey();
            Comparable v = entry.getValue();

            if (newState.hasProperty(key)) {
                newState = newState.setValue(key, v);
            }
        }

        return newState;
    }

    BlockState processState(LevelAccessor level, BlockState state, BlockPos pos, Random random, @Nullable Rotation rotation);
}
