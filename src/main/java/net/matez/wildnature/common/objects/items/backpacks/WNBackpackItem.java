/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.items.backpacks;

import net.matez.wildnature.common.objects.items.setup.WNItem;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;

public class WNBackpackItem extends WNItem {
    private final Backpack backpackItem;

    public WNBackpackItem(ResourceLocation location, Properties properties, Backpack backpackItem) {
        super(location, properties);
        this.backpackItem = backpackItem;
    }

    public Backpack getBackpackItem() {
        return backpackItem;
    }

    @Override
    public WNResource getItemModel(){
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("backpacks"));
    }
}
