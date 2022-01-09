package net.matez.wildnature.common.objects.blocks.plant.plants;

import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.plant.WNBushConfiguredBlock;
import net.matez.wildnature.data.block_models.plants.moss.*;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_Moss;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNMossBlock extends WNBushConfiguredBlock {
    public WNMossBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNMossBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Moss(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_Moss1(this.getRegName() + "_1").with("texture",this.getTextureName(this.getType().getVariant().getPath())),
                new WNBlockModel_Moss2(this.getRegName() + "_2").with("texture",this.getTextureName(this.getType().getVariant().getPath())),
                new WNBlockModel_Moss3(this.getRegName() + "_3").with("texture",this.getTextureName(this.getType().getVariant().getPath())),
                new WNBlockModel_Moss4(this.getRegName() + "_4").with("texture",this.getTextureName(this.getType().getVariant().getPath())),
                new WNBlockModel_Moss5(this.getRegName() + "_5").with("texture",this.getTextureName(this.getType().getVariant().getPath()))
        );
    }
}
