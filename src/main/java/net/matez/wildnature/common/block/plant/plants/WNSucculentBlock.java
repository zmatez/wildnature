package net.matez.wildnature.common.block.plant.plants;

import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNBushConfiguredBlock;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_Succulent;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_Succulent;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNSucculentBlock extends WNBushConfiguredBlock {
    public WNSucculentBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNSucculentBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Succulent(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String texture = this.getTextureName(this.getType().getVariant().getPath());
        return new ModelList().with(
                new WNBlockModel_Succulent(this.getRegName() + "_tall_dark_green")
                        .with("texture",texture + "_dark_green")
                        .with("type","tall"),
                new WNBlockModel_Succulent(this.getRegName() + "_tall_dark_red")
                        .with("texture",texture + "_dark_red")
                        .with("type","tall"),
                new WNBlockModel_Succulent(this.getRegName() + "_tall_green")
                        .with("texture",texture + "_green")
                        .with("type","tall"),
                new WNBlockModel_Succulent(this.getRegName() + "_tall_light_green")
                        .with("texture",texture + "_light_green")
                        .with("type","tall"),
                new WNBlockModel_Succulent(this.getRegName() + "_tall_mix")
                        .with("texture",texture + "_mix")
                        .with("type","tall"),
                new WNBlockModel_Succulent(this.getRegName() + "_tall_red")
                        .with("texture",texture + "_red")
                        .with("type","tall"),
                new WNBlockModel_Succulent(this.getRegName() + "_tall_white_spots")
                        .with("texture",texture + "_white_spots")
                        .with("type","tall"),
                
                new WNBlockModel_Succulent(this.getRegName() + "_big_dark_green")
                        .with("texture",texture + "_dark_green")
                        .with("type","big"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_dark_red")
                        .with("texture",texture + "_dark_red")
                        .with("type","big"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_green")
                        .with("texture",texture + "_green")
                        .with("type","big"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_light_green")
                        .with("texture",texture + "_light_green")
                        .with("type","big"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_mix")
                        .with("texture",texture + "_mix")
                        .with("type","big"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_red")
                        .with("texture",texture + "_red")
                        .with("type","big"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_white_spots")
                        .with("texture",texture + "_white_spots")
                        .with("type","big"),
                
                new WNBlockModel_Succulent(this.getRegName() + "_small_dark_green")
                        .with("texture",texture + "_dark_green")
                        .with("type","small"),
                new WNBlockModel_Succulent(this.getRegName() + "_small_dark_red")
                        .with("texture",texture + "_dark_red")
                        .with("type","small"),
                new WNBlockModel_Succulent(this.getRegName() + "_small_green")
                        .with("texture",texture + "_green")
                        .with("type","small"),
                new WNBlockModel_Succulent(this.getRegName() + "_small_light_green")
                        .with("texture",texture + "_light_green")
                        .with("type","small"),
                new WNBlockModel_Succulent(this.getRegName() + "_small_mix")
                        .with("texture",texture + "_mix")
                        .with("type","small"),
                new WNBlockModel_Succulent(this.getRegName() + "_small_red")
                        .with("texture",texture + "_red")
                        .with("type","small"),
                new WNBlockModel_Succulent(this.getRegName() + "_small_white_spots")
                        .with("texture",texture + "_white_spots")
                        .with("type","small"),
                
                new WNBlockModel_Succulent(this.getRegName() + "_big_and_small_dark_green")
                        .with("texture",texture + "_dark_green")
                        .with("type","big_and_small"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_and_small_dark_red")
                        .with("texture",texture + "_dark_red")
                        .with("type","big_and_small"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_and_small_green")
                        .with("texture",texture + "_green")
                        .with("type","big_and_small"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_and_small_light_green")
                        .with("texture",texture + "_light_green")
                        .with("type","big_and_small"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_and_small_mix")
                        .with("texture",texture + "_mix")
                        .with("type","big_and_small"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_and_small_red")
                        .with("texture",texture + "_red")
                        .with("type","big_and_small"),
                new WNBlockModel_Succulent(this.getRegName() + "_big_and_small_white_spots")
                        .with("texture",texture + "_white_spots")
                        .with("type","big_and_small")
        );
    }
}
