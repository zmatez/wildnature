/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.dust;

import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;

public class WNDustItem extends WNItem {
    private final DustItem dustItem;

    public WNDustItem(ResourceLocation location, Properties properties, DustItem dustItem) {
        super(location, properties);
        this.dustItem = dustItem;
    }

    public DustItem getDustItem() {
        return dustItem;
    }

    @Override
    public WNResource getItemModel(){
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("misc"));
    }
}
