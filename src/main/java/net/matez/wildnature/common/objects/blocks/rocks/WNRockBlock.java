/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.rocks;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNRockBlock extends WNBlock {
    private final RockType rockType;

    public WNRockBlock(ResourceLocation location, Properties properties, RockType rockType) {
        super(location, properties);
        this.rockType = rockType;
    }

    public WNRockBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, RockType rockType) {
        super(location, properties, itemProperties);
        this.rockType = rockType;
    }

    public ModelList getBlockModels(){
        return new ModelList()
                .with(new WNBlockModel_CubeAll(this.getRegName()).with("texture",this.getTextureName("rocks/" + this.rockType.getIdBase())));
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
            WNTags.BASE_STONE_OVERWORLD, WNTags.FORGE_STONE, WNTags.MOSS_REPLACEABLE, WNTags.LUSH_GROUND_REPLACEABLE, WNTags.MINEABLE_PICKAXE
        );
    }
}
