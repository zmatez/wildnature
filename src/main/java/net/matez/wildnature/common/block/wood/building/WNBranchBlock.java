/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.building;

import net.matez.wildnature.common.block.wood.ILog;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.block.wood.base.WNAbstractBranchBlock;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_Branch;
import net.matez.wildnature.data.blockstates.WNBlockstate_Branch;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNBranchBlock extends WNAbstractBranchBlock implements ILog{
    private final LogType logType;

    public WNBranchBlock(ResourceLocation location, Properties properties, LogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNBranchBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public WNBlock getLog() {
        return WNBlocks.LOGS.get(this.logType);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Branch(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String path = getLog().getTextureName("trees/" + this.logType.getBaseOrParent());
        return new ModelList()
                .with(
                        new WNBlockModel_Branch(this.getRegName() + "_up")
                                .with("texture", path)
                                .with("side", "up"),
                        new WNBlockModel_Branch(this.getRegName() + "_down")
                                .with("texture", path)
                                .with("side", "down"),
                        new WNBlockModel_Branch(this.getRegName() + "_side")
                                .with("texture", path)
                                .with("side", "side"),
                        new WNBlockModel_Branch(this.getRegName() + "_inventory")
                                .with("texture", path)
                                .with("side", "inventory"),
                        new WNBlockModel_Branch(this.getRegName() + "_none")
                                .with("texture", path)
                                .with("side", "none")
                );
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_BlockParent(getRegName()).with("parent", this.getRegName() + "_inventory");
    }
}
