package net.matez.wildnature.common.objects.blocks.plant.plants;

import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.plant.WNBushConfiguredBlock;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FlyTrap;
import net.matez.wildnature.data.blockstates.WNBlockstate_RandomlyRotatedCube;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNFlytrapBlock extends WNBushConfiguredBlock {
    public WNFlytrapBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNFlytrapBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_RandomlyRotatedCube(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_FlyTrap(this.getRegName()).with("texture", getTextureName(getType().getVariant().getPath()))
        );
    }
}
