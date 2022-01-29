/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.items.setup;

import net.minecraft.world.item.Item;

public class WNItemUtil {
    public static String getRegName(Item item){
        return item.getRegistryName() == null ? "UNKNOWN" : (item.getRegistryName().getPath());
    }
    public static String getTextureName(Item item){
        return item.getRegistryName() == null ? "UNKNOWN" : (item.getRegistryName().getNamespace() + ":items/" + item.getRegistryName().getPath());
    }
    public static String getTextureName(String folders, Item item){
        return item.getRegistryName() == null ? "UNKNOWN" : (item.getRegistryName().getNamespace() + ":items/" + folders + "/" + item.getRegistryName().getPath());
    }
}
