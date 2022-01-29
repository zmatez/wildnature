/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.cave_plants;

import net.matez.wildnature.common.objects.blocks.plant.WNBushBlock;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNCaveBushBlock extends WNBushBlock {
    protected final CavePlantType cavePlantType;
    public WNCaveBushBlock(ResourceLocation location, Properties properties, CavePlantType type) {
        super(location, properties, type.getConfig());
        this.cavePlantType = type;
    }

    public WNCaveBushBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CavePlantType type) {
        super(location, properties, itemProperties, type.getConfig());
        this.cavePlantType = type;
    }

    public CavePlantType getCavePlantType() {
        return cavePlantType;
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        if(this.getConfig() != null && this.getConfig().isItemAsSelf()){
            return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()));
        }
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()) + "_item");
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName()).with("texture",this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()))
        );
    }
}
