/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.water_plants;

import net.matez.wildnature.data.block_models.plants.WNBlockModel_Lilypad;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_LilyPad;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNLilyPadBlock extends WNWaterlilyBlock {
    public WNLilyPadBlock(ResourceLocation location, Properties properties, WaterPlant waterPlant) {
        super(location, properties, waterPlant);
    }

    public WNLilyPadBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, WaterPlant waterPlant) {
        super(location, properties, itemProperties, waterPlant);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_LilyPad(this.getRegistryName());
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("plants/water/" + getRegName()) + (waterPlant == WaterPlant.GREEN_LILY_PAD ? "_1" : "_3"));
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_Lilypad(this.getRegName() + "_1").with("texture",this.getTextureName("plants/water/" + getRegName()) + "_1"),
                new WNBlockModel_Lilypad(this.getRegName() + "_2").with("texture",this.getTextureName("plants/water/" + getRegName()) + "_2"),
                new WNBlockModel_Lilypad(this.getRegName() + "_3").with("texture",this.getTextureName("plants/water/" + getRegName()) + "_3"),
                new WNBlockModel_Lilypad(this.getRegName() + "_4").with("texture",this.getTextureName("plants/water/" + getRegName()) + "_4")
        );
    }

}
