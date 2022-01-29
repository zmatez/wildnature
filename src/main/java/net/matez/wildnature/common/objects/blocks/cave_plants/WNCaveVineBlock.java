/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.cave_plants;

import net.matez.wildnature.common.objects.blocks.plant.vines.WNAbstractVineBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.setup.WNRenderType;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_Vine;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_Vine;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNCaveVineBlock extends WNAbstractVineBlock {
    protected final CavePlantType cavePlantType;

    public WNCaveVineBlock(ResourceLocation location, Properties properties, CavePlantType cavePlantType) {
        super(location, properties);
        this.cavePlantType = cavePlantType;
    }

    public WNCaveVineBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CavePlantType cavePlantType) {
        super(location, properties, itemProperties);
        this.cavePlantType = cavePlantType;
    }

    @Override
    public WNRenderType getRenderType() {
        return WNRenderType.CUTOUT;
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Vine(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_Vine(this.getRegName()).with("texture",this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()))
        );
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        if(this.cavePlantType.getConfig().isItemAsSelf()){
            return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()));
        }
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()) + "_item");
    }


    @org.jetbrains.annotations.Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.CLIMBABLE
        );
    }
}
