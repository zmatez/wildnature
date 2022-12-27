/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.grass;

import net.matez.wildnature.common.block.basic.WNAbstractFarmBlock;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_FarmBlock;
import net.matez.wildnature.data.blockstates.WNBlockstate_FarmBlock;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNFarmBlock extends WNAbstractFarmBlock {
    private final GrassType grassType;

    public WNFarmBlock(ResourceLocation location, Properties properties, GrassType grassType) {
        super(location, properties);
        this.grassType = grassType;
    }

    public WNFarmBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, GrassType grassType) {
        super(location, properties, itemProperties);
        this.grassType = grassType;
    }

    public WNBlock getDirt(){
        return WNBlocks.DIRTS.get(grassType);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_FarmBlock(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList()
                .with(
                        new WNBlockModel_FarmBlock(this.getRegName())
                                .with("texture", this.getTextureName("grass/" + this.grassType.getIdBase()))
                                .with("dirt", getDirt().getTextureName("grass/" + this.grassType.getIdBase())),
                        new WNBlockModel_FarmBlock(this.getRegName() + "_moist")
                                .with("texture", this.getTextureName("grass/" + this.grassType.getIdBase()) + "_moist")
                                .with("dirt", getDirt().getTextureName("grass/" + this.grassType.getIdBase()))
                );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.MINEABLE_SHOVEL, WNTags.BIG_DRIPLEAF_REPLACEABLE
        );
    }
}
