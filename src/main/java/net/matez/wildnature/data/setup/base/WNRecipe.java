package net.matez.wildnature.data.setup.base;

import net.minecraft.resources.ResourceLocation;

public abstract class WNRecipe extends WNResource {
    public WNRecipe(String name) {
        super(name);
    }

    public WNRecipe(ResourceLocation location){
        this(location.getPath());
    }

    public String getPath(){
        return "/data/" + modid + "/recipes";
    }
}
