/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.structures.types;

import net.matez.wildnature.common.objects.structures.WNStructure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.Nullable;
import java.util.Random;

public class WNFallenTreeStructure extends WNStructure {
    public WNFallenTreeStructure(ResourceLocation location) {
        super(location);
    }

    @Override
    public BlockState processState(LevelAccessor level, BlockState state, BlockPos pos, Random random, @Nullable Rotation rotation) {
        if (state.hasProperty(BlockStateProperties.PERSISTENT)) {
            state = state.setValue(BlockStateProperties.PERSISTENT, true);
        }

        return state;
    }
}
