/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.setup.base;

import net.minecraft.resources.ResourceLocation;

public abstract class WNIRecipe extends WNResource {
    public WNIRecipe(String name) {
        super(name);
    }

    public WNIRecipe(ResourceLocation location){
        this(location.getPath());
    }

    public String getPath(){
        return "/data/" + modid + "/recipes";
    }
}
