/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.handles;

import net.matez.wildnature.data.item_models.WNItemModel_Handheld;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;

public class WNHandleItem extends WNItem {
    private final Handle handleItem;

    public WNHandleItem(ResourceLocation location, Properties properties, Handle handleItem) {
        super(location, properties);
        this.handleItem = handleItem;
    }

    public Handle getHandleItem() {
        return handleItem;
    }

    @Override
    public WNResource getItemModel(){
        return new WNItemModel_Handheld(this.getRegName()).with("texture",this.getTextureName("tools/misc"));
    }
}
