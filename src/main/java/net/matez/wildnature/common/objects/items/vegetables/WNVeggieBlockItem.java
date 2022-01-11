package net.matez.wildnature.common.objects.items.vegetables;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.items.fruits.Fruit;
import net.matez.wildnature.common.objects.items.setup.WNBlockItem;
import net.matez.wildnature.common.objects.items.setup.WNItem;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;

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
