/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.water_plants;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;

public interface WaterPlantConstructor<T> {
    WNBlock get(T type, ResourceLocation location, BlockBehaviour.Properties blockProperties, Item.Properties itemProperties);
}
