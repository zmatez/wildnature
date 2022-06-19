/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.grass;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNDirtBlock extends WNBlock {
    @Nullable
    private final GrassType grassType;

    private final String folder;

    public WNDirtBlock(ResourceLocation location, Properties properties, @Nullable GrassType grassType, String folder) {
        super(location, properties);
        this.grassType = grassType;
        this.folder = folder;
    }

    public WNDirtBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, @Nullable GrassType grassType, String folder) {
        super(location, properties, itemProperties);
        this.grassType = grassType;
        this.folder = folder;
    }

    public ModelList getBlockModels(){
        return new ModelList()
                .with(new WNBlockModel_CubeAll(this.getRegName()).with("texture", this.getTextureName("grass/" + this.folder)));
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.ENDERMAN_HOLDABLE, WNTags.MOSS_REPLACEABLE, WNTags.AZALEA_GROWS_ON, WNTags.FORGE_DIRT,
                WNTags.BAMBOO_PLANTABLE_ON, WNTags.AZALEA_ROOT_REPLACEABLE,
                WNTags.BIG_DRIPLEAF_REPLACEABLE, WNTags.DRIPSTONE_REPLACEABLE_BLOCKS, WNTags.LUSH_GROUND_REPLACEABLE, WNTags.MINEABLE_SHOVEL, WNTags.DIRT
        );
    }
}
