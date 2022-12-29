/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.furniture;

import com.mojang.datafixers.util.Either;
import net.matez.wildnature.common.block.wood.ILog;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.block.wood.base.WNAbstractBenchBlock;
import net.matez.wildnature.common.block.wood.vanilla.VanillaLogType;
import net.matez.wildnature.core.registry.WNBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class WNBenchBlock extends WNAbstractBenchBlock implements ILog{
    private final Either<LogType, VanillaLogType> logType;

    public WNBenchBlock(Properties properties, Either<LogType, VanillaLogType> logType) {
        super(properties);
        this.logType = logType;
    }

    public Supplier<Block> getLog() {
        if (logType.left().isPresent())
            return WNBlocks.STRIPPED_LOGS.get(this.logType.left().get());
        else
            return this.logType.right().get().getStrippedLogBlock();
    }
    public Supplier<Block> getPlanks() {
        return WNBlocks.PLANKS.get(this.logType);
    }
}
