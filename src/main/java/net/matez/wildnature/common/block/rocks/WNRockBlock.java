/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.rocks;

import net.matez.wildnature.common.WNBlock;
import net.minecraft.world.level.block.Block;

public class WNRockBlock extends Block implements WNBlock {
    private final RockType rockType;

    public WNRockBlock(Properties properties, RockType rockType) {
        super(properties);
        this.rockType = rockType;
    }

    public RockType getRockType() {
        return rockType;
    }
}
