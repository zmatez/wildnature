package net.matez.wildnature.common.objects.blocks.plant.flowering;

import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_BigBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_BigBushFlowering;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNBigBushBlock extends WNFloweringBushBlock{
    public WNBigBushBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNBigBushBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName() + "_stalk";
        String leaves = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName() + "_leaves";
        return new WNBlock.ModelList().with(
                new WNBlockModel_BigBush(this.getRegName())
                        .with("stalk",stalk)
                        .with("leaves",leaves),
                new WNBlockModel_BigBushFlowering(this.getRegName() + "_flowering")
                        .with("texture",this.getTextureName(getType().getVariant().getPath()))
                        .with("stalk",stalk)
                        .with("leaves",leaves)
        );
    }
}
