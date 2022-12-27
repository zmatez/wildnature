/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.ores;

import net.matez.wildnature.common.WNBlock;
import net.minecraft.world.level.block.Block;

public class WNGemBlock extends Block implements WNBlock {
    protected final GemBlock gem;

    public WNGemBlock(Properties properties, GemBlock ore) {
        super(properties);
        this.gem = ore;
    }
}
