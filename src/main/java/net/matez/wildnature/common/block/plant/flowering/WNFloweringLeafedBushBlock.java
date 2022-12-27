package net.matez.wildnature.common.block.plant.flowering;

import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_LeafedFloweringBush;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNFloweringLeafedBushBlock extends WNFloweringBushBlock{
    public WNFloweringLeafedBushBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNFloweringLeafedBushBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName() + "_stalk";
        String leaves = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName() + "_leaves";
        return new ModelList().with(
                new WNBlockModel_FloweringBush(this.getRegName()).with("texture",stalk).with("stalk",leaves),
                new WNBlockModel_LeafedFloweringBush(this.getRegName() + "_flowering")
                        .with("texture",this.getTextureName(getType().getVariant().getPath()))
                        .with("stalk",stalk)
                        .with("leaves",leaves)
        );
    }
}
