package net.matez.wildnature.common.item.vegetables;

import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;

public class WNVeggieBlockItem extends WNBlockItem {
    private final Veggie veggie;

    public WNVeggieBlockItem(WNBlock block, Properties properties, Veggie veggie) {
        super(block, properties);
        this.veggie = veggie;
    }

    public Veggie getVeggie() {
        return veggie;
    }

    @Override
    public WNResource getItemModel(){
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("vegetables"));
    }
}
