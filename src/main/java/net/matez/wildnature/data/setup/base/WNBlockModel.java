package net.matez.wildnature.data.setup.base;

public abstract class WNBlockModel extends WNResource{
    public WNBlockModel(String name) {
        super(name);
    }

    public String getPath(){
        return "/assets/" + modid + "/models/block";
    }
}
