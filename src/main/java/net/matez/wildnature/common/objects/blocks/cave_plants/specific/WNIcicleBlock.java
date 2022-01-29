/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.cave_plants.specific;

import net.matez.wildnature.common.objects.blocks.cave_plants.CavePlantType;
import net.matez.wildnature.common.objects.blocks.cave_plants.WNCaveHangingBushBlock;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNIcicleBlock extends WNCaveHangingBushBlock {
    public WNIcicleBlock(ResourceLocation location, Properties properties, CavePlantType type) {
        super(location, properties, type);
    }

    public WNIcicleBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CavePlantType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate(this.getRegistryName()) {
            @Override
            public String getJSON() {
                return """
                        {
                          "variants": {
                            "":[
                              { "model": "%modid%:block/%name%_1" },
                              { "model": "%modid%:block/%name%_2" }
                            ]
                          }
                        }
                        """;
            }
        };
    }

    @Override
    public ModelList getBlockModels() {
        ModelList list = new ModelList();
        for(int i = 1; i <= 2; i++){
            list.with(new WNBlockModel_TintedCross(this.getRegName() + "_" + i).with("texture",getTextureName("plants/cave/" + this.cavePlantType.getFolder()) + "_" + i));
        }
        return list;
    }
}
