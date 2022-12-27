/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.grass;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNMossyStone extends WNDirtBlock {
    public WNMossyStone(ResourceLocation location, Properties properties, GrassType grassType) {
        super(location, properties, grassType, "overgrown");
    }

    public WNMossyStone(ResourceLocation location, Properties properties, Item.Properties itemProperties, GrassType grassType) {
        super(location, properties, itemProperties, grassType, "overgrown");
    }
}
