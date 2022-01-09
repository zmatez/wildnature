package net.matez.wildnature.common.objects.blocks.rocks;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNSaltBlock extends WNBlock {

    public WNSaltBlock(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    public WNSaltBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
        super(location, properties, itemProperties);
    }

    public ModelList getBlockModels(){
        return new ModelList()
                .with(new WNBlockModel_CubeAll(this.getRegName()).with("texture",this.getTextureName("rocks/salt")));
    }
}
