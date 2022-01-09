package net.matez.wildnature.common.objects.blocks.plant.plants;

import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.plant.WNBushConfiguredBlock;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBushRetinted;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_Shrub;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNShrubBlock extends WNBushConfiguredBlock {
    public WNShrubBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNShrubBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Shrub(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName() + "_stalk";
        String stalkTall = stalk + "_tall";
        return new ModelList().with(
                new WNBlockModel_FloweringBushRetinted(this.getRegName() + "_0")
                    .with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_0")
                    .with("stalk",stalk),
                new WNBlockModel_FloweringBushRetinted(this.getRegName() + "_1")
                    .with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_1")
                    .with("stalk",stalk),
                new WNBlockModel_FloweringBushRetinted(this.getRegName() + "_tall_0")
                    .with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_0")
                    .with("stalk",stalkTall),
                new WNBlockModel_FloweringBushRetinted(this.getRegName() + "_tall_1")
                    .with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_1")
                    .with("stalk",stalkTall)
        );
    }
}
