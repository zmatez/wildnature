/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.ores;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNGemBlock extends WNBlock {
    protected final GemBlock gem;

    public WNGemBlock(ResourceLocation location, Properties properties, GemBlock ore) {
        super(location, properties);
        this.gem = ore;
    }

    public WNGemBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, GemBlock ore) {
        super(location, properties, itemProperties);
        this.gem = ore;
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_CubeAll(this.getRegName()).with("texture",this.getTextureName("ores/" + this.gem.getFolder()))
        );
    }
}
