/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.vanilla.furniture;

import net.matez.wildnature.common.block.wood.ILog;
import net.matez.wildnature.common.block.wood.base.WNAbstractTableBlock;
import net.matez.wildnature.common.block.wood.vanilla.VanillaLogType;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class WNVanillaTableBlock extends WNAbstractTableBlock implements ILog {
    private final VanillaLogType logType;

    public WNVanillaTableBlock(Properties properties, VanillaLogType logType) {
        super(properties);
        this.logType = logType;
    }

    public Supplier<Block> getLog() {
        return this.logType.getStrippedLogBlock();
    }
}
