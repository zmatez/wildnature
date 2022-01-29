/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.items.setup;

import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;

public interface IWNItem extends ItemLike {
    public default void construct(){

    }

    @Nullable
    public WNResource getItemModel();

    @Nullable
    public default ItemModelList getItemModels() {
        return null;
    }

    /**
     * @return e.g "stone"
     */
    public String getRegName();
    /**
     * @return e.g "minecraft:blocks/stone"
     */
    public String getTextureName();
    /**
     * @param folders e.g rocks/stones
     * @return e.g "minecraft:blocks/rocks/stones/stone"
     */
    public String getTextureName(String folders);

    @Nullable
    public ResourceLocation getRegistryName();
}
