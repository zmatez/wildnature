package net.matez.wildnature.common.objects.items.setup;

import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public abstract class WNItem extends Item implements IWNItem{
    public WNItem(ResourceLocation location, Item.Properties properties){
        super(properties);
        setRegistryName(location);
    }

    @Override
    public void construct() {

    }

    public abstract WNResource getItemModel();

    /**
     * @return e.g "stone"
     */
    public String getRegName(){
        return this.getRegistryName() == null ? "UNKNOWN" : (this.getRegistryName().getPath());
    }
    /**
     * @return e.g "minecraft:blocks/stone"
     */
    public String getTextureName(){
        return this.getRegistryName() == null ? "UNKNOWN" : (this.getRegistryName().getNamespace() + ":items/" + this.getRegistryName().getPath());
    }
    /**
     * @param folders e.g rocks/stones
     * @return e.g "minecraft:blocks/rocks/stones/stone"
     */
    public String getTextureName(String folders){
        return this.getRegistryName() == null ? "UNKNOWN" : (this.getRegistryName().getNamespace() + ":items/" + folders + "/" + this.getRegistryName().getPath());
    }
}
