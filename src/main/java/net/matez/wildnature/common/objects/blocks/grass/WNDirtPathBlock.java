/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.grass;

import net.matez.wildnature.common.objects.blocks.basic.WNAbstractDirtPathBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_DirtPath;
import net.matez.wildnature.data.blockstates.WNBlockstate_RandomlyRotatedCube;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNDirtPathBlock extends WNAbstractDirtPathBlock {
    private final GrassType grassType;

    public WNDirtPathBlock(ResourceLocation location, Properties properties, GrassType grassType) {
        super(location, properties);
        this.grassType = grassType;
    }

    public WNDirtPathBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, GrassType grassType) {
        super(location, properties, itemProperties);
        this.grassType = grassType;
    }

    public WNBlock getDirt(){
        return WNBlocks.DIRTS.get(grassType);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_RandomlyRotatedCube(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList()
                .with(
                        new WNBlockModel_DirtPath(this.getRegName())
                                .with("texture_top", this.getTextureName("grass/" + this.grassType.getIdBase()) + "_top")
                                .with("texture_bottom", getDirt().getTextureName("grass/" + this.grassType.getIdBase()))
                                .with("texture_side", this.getTextureName("grass/" + this.grassType.getIdBase()) + "_side"),
                        new WNBlockModel_DirtPath(this.getRegName() + "_snow")
                                .with("texture_top", this.getTextureName("grass/" + this.grassType.getIdBase()) + "_top")
                                .with("texture_bottom", getDirt().getTextureName("grass/" + this.grassType.getIdBase()))
                                .with("texture_side", this.getTextureName("grass/" + this.grassType.getIdBase()) + "_side")
                );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.MINEABLE_SHOVEL
        );
    }
}
