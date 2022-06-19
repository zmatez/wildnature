/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.dev;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNDevBlock extends WNBlock {
    public WNDevBlock(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    public WNDevBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
        super(location, properties, itemProperties);
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList()
                .with(new WNBlockModel_CubeAll(this.getRegName()).with("texture", this.getTextureName("misc/dev")));
    }
}
