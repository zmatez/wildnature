/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block;

import net.minecraft.world.level.block.state.BlockBehaviour;

@FunctionalInterface
public interface BlockBehaviourConsumer {
    BlockBehaviour.Properties getProperties(BlockBehaviour.Properties properties);
}
