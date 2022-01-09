package net.matez.wildnature.common.objects.items.setup;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.world.item.BlockItem;

public class WNBlockItem extends BlockItem {
    private final WNBlock block;

    public WNBlockItem(WNBlock block, Properties properties){
        super(block,properties);
        this.block = block;
    }

    public WNResource getItemModel(){
        if(this.block.getItemModel() == null) {
            return new WNItemModel_BlockParent(getRegName()).with("parent", this.getRegName());
        }else{
            return this.block.getItemModel();
        }
    }

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
        return this.getRegistryName() == null ? "UNKNOWN" : (this.getRegistryName().getNamespace() + ":blocks/" + this.getRegistryName().getPath());
    }
    /**
     * @param folders e.g rocks/stones
     * @return e.g "minecraft:blocks/rocks/stones/stone"
     */
    public String getTextureName(String folders){
        return this.getRegistryName() == null ? "UNKNOWN" : (this.getRegistryName().getNamespace() + ":blocks/" + folders + "/" + this.getRegistryName().getPath());
    }
}
