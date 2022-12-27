package net.matez.wildnature.common.block.plant.flowering;

import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_LeafedFloweringBush;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNDoubleFloweringLeafedBushBlock extends WNDoubleFloweringBushBlock{
    public WNDoubleFloweringLeafedBushBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNDoubleFloweringLeafedBushBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName() + "_stalk";
        String leaves = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName() + "_leaves";
        return new ModelList().with(
                new WNBlockModel_FloweringBush(this.getRegName() + "_bottom").with("texture",stalk + "_bottom").with("stalk",leaves + "_bottom"),
                new WNBlockModel_FloweringBush(this.getRegName() + "_top").with("texture",stalk + "_top").with("stalk",leaves + "_top"),
                new WNBlockModel_LeafedFloweringBush(this.getRegName() + "_bottom_flowering")
                        .with("texture",this.getTextureName(getType().getVariant().getPath()) + "_bottom")
                        .with("stalk",stalk + "_bottom")
                        .with("leaves",leaves + "_bottom"),
                new WNBlockModel_LeafedFloweringBush(this.getRegName() + "_top_flowering")
                        .with("texture",this.getTextureName(getType().getVariant().getPath()) + "_top")
                        .with("stalk",stalk + "_top")
                        .with("leaves",leaves + "_top")
        );
    }

}