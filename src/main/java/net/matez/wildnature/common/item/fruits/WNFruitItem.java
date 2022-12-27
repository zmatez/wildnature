/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.fruits;

import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;

public class WNFruitItem extends WNItem {
    private final Fruit fruit;

    public WNFruitItem(ResourceLocation location, Properties properties, Fruit fruit) {
        super(location, properties);
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    @Override
    public WNResource getItemModel(){
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("fruits"));
    }


}
