/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.ores;

import net.matez.wildnature.common.objects.items.ores.OreItem;
import net.matez.wildnature.common.registry.items.WNItems;
import net.matez.wildnature.common.util.WNUtil;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

public class SimpleOreDropConfig implements OreDropConfig{
    private final OreItem item;
    private final int min, max;
    private int expMin = 3, expMax = 5;

    public SimpleOreDropConfig(OreItem item, int min, int max) {
        this.item = item;
        this.min = min;
        this.max = max;
    }

    @Override
    public ItemStack getDrops(BlockState state, ServerLevel level, float luck) {
        return new ItemStack(WNItems.ORE_ITEMS.get(item), WNUtil.rint(min,max));
    }

    public SimpleOreDropConfig withExp(int min, int max){
        this.expMin = min;
        this.expMax = max;
        return this;
    }

    @Override
    public int getExpDrops(BlockState state, LevelReader reader, int fortune, int silkTouch) {
        return WNUtil.rint(expMin, expMax);
    }
}
