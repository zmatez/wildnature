/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.furniture;

import net.matez.wildnature.common.block.wood.ILog;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.block.wood.base.WNAbstractTableBlock;
import net.matez.wildnature.core.registry.WNBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class WNTableBlock extends WNAbstractTableBlock implements ILog{
    private final LogType logType;

    public WNTableBlock(Properties properties, LogType logType) {
        super(properties);
        this.logType = logType;
    }

    public Supplier<Block> getLog() {
        return WNBlocks.STRIPPED_LOGS.get(this.logType);
    }
}
