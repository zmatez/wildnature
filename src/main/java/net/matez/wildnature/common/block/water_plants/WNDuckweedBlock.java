/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.water_plants;

import net.matez.wildnature.data.block_models.plants.WNBlockModel_Lilypad;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_Duckweed;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNDuckweedBlock extends WNWaterlilyBlock {
    public WNDuckweedBlock(ResourceLocation location, Properties properties, WaterPlant waterPlant) {
        super(location, properties, waterPlant);
    }

    public WNDuckweedBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, WaterPlant waterPlant) {
        super(location, properties, itemProperties, waterPlant);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Duckweed(this.getRegistryName());
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("plants/water/duckweed") + "_1");
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_Lilypad(this.getRegName() + "_1").with("texture",this.getTextureName("plants/water/duckweed") + "_1"),
                new WNBlockModel_Lilypad(this.getRegName() + "_2").with("texture",this.getTextureName("plants/water/duckweed") + "_2"),
                new WNBlockModel_Lilypad(this.getRegName() + "_3").with("texture",this.getTextureName("plants/water/duckweed") + "_3")
        );
    }
}
