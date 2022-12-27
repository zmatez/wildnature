/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.grass;

import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeBottomTop;
import net.matez.wildnature.data.blockstates.WNBlockstate_GrassBlock;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import org.jetbrains.annotations.Nullable;

public class WNAlgaeBlock extends WNAbstractGrassBlock implements BonemealableBlock {
    public WNAlgaeBlock(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    public WNAlgaeBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
        super(location, properties, itemProperties);
    }


    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.ENDERMAN_HOLDABLE, WNTags.MOSS_REPLACEABLE, WNTags.RABBITS_SPAWNABLE_ON, WNTags.AZALEA_GROWS_ON, WNTags.FORGE_DIRT,
                WNTags.BAMBOO_PLANTABLE_ON, WNTags.PARROTS_SPAWNABLE_ON, WNTags.LUSH_GROUND_REPLACEABLE, WNTags.AZALEA_ROOT_REPLACEABLE,
                WNTags.BIG_DRIPLEAF_REPLACEABLE, WNTags.VALID_SPAWN, WNTags.ANIMALS_SPAWNABLE_ON, WNTags.MINEABLE_SHOVEL, WNTags.DIRT,
                WNTags.WOLVES_SPAWNABLE_ON, WNTags.FOXES_SPAWNABLE_ON
        );
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_GrassBlock(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String dirt = Blocks.DIRT.getRegistryName().getNamespace() + ":block/" + Blocks.DIRT.getRegistryName().getPath();
        return new ModelList()
                .with(
                        new WNBlockModel_CubeBottomTop(this.getRegName())
                                .with("texture_top", this.getTextureName("grass/algae") + "_top")
                                .with("texture_bottom", dirt)
                                .with("texture_side", this.getTextureName("grass/algae") + "_side"),
                        new WNBlockModel_CubeBottomTop(this.getRegName() + "_snow")
                                .with("texture_top", this.getTextureName("grass/algae") + "_top")
                                .with("texture_bottom", dirt)
                                .with("texture_side", this.getTextureName("grass/algae") + "_side")
                );
    }
}