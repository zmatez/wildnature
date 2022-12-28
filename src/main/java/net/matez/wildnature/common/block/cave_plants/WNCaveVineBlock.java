/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.cave_plants;

import net.matez.wildnature.common.block.plant.vines.WNAbstractVineBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNCaveVineBlock extends WNAbstractVineBlock {
    protected final CavePlantType cavePlantType;

    public WNCaveVineBlock(Properties properties, CavePlantType cavePlantType) {
        super(properties);
        this.cavePlantType = cavePlantType;
    }

    @Override
    public RenderType getRenderType() {
        return RenderType.cutout();
    }
}
