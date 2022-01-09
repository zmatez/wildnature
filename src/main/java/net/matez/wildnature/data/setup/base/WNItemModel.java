package net.matez.wildnature.data.setup.base;

public abstract class WNItemModel extends WNResource{
    public WNItemModel(String name) {
        super(name);
    }

    public String getPath(){
        return "/assets/" + modid + "/models/item";
    }
}
