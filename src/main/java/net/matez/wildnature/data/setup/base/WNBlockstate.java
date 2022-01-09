package net.matez.wildnature.data.setup.base;

import net.minecraft.resources.ResourceLocation;

public abstract class WNBlockstate extends WNResource {
    public WNBlockstate(String name) {
        super(name);
    }

    public WNBlockstate(ResourceLocation location){
        this(location.getPath());
    }

    public String getPath(){
        return "/assets/" + modid + "/blockstates";
    }
}
