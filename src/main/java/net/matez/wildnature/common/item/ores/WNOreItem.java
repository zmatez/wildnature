/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.ores;

import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;

public class WNOreItem extends WNItem {
    private final OreItem oreItem;

    public WNOreItem(ResourceLocation location, Properties properties, OreItem oreItem) {
        super(location, properties);
        this.oreItem = oreItem;
    }

    public OreItem getOreItem() {
        return oreItem;
    }

    @Override
    public WNResource getItemModel(){
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("ores/" + oreItem.getFolder()));
    }
}
