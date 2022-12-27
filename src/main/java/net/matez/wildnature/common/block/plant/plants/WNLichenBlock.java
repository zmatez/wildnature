package net.matez.wildnature.common.block.plant.plants;

import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_VerticalBush;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_Lichen;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNLichenBlock extends WNVerticalBushBlock{
    public WNLichenBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNLichenBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Lichen(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_VerticalBush(this.getRegName() + "_1").with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_1"),
                new WNBlockModel_VerticalBush(this.getRegName() + "_2").with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_2"),
                new WNBlockModel_VerticalBush(this.getRegName() + "_3").with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_3"),
                new WNBlockModel_VerticalBush(this.getRegName() + "_4").with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_4")
        );
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.NONE;
    }
}
