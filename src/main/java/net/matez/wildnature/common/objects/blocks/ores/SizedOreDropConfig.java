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

public class SizedOreDropConfig implements OreDropConfig{
    private final OreItem itemSmall, itemBig;
    private final int minSmall, minBig, maxSmall, maxBig;
    private int minExpSmall = 2, minExpBig = 3, maxExpSmall = 5, maxExpBig = 9;

    public SizedOreDropConfig(OreItem itemSmall, OreItem itemBig, int minSmall, int minBig, int maxSmall, int maxBig) {
        this.itemSmall = itemSmall;
        this.itemBig = itemBig;
        this.minSmall = minSmall;
        this.minBig = minBig;
        this.maxSmall = maxSmall;
        this.maxBig = maxBig;
    }

    @Override
    public ItemStack getDrops(BlockState state, ServerLevel level, float luck) {
        if(state.getBlock() instanceof WNOreDoubleFormationBlock) {
            if(state.getValue(WNOreDoubleFormationBlock.SIZE) == BigSmallBlock.SMALL) {
                return new ItemStack(WNItems.ORE_ITEMS.get(itemSmall), WNUtil.rint(minSmall, maxSmall));
            }else{
                return new ItemStack(WNItems.ORE_ITEMS.get(itemBig), WNUtil.rint(minBig, maxBig));
            }
        }
        return ItemStack.EMPTY;
    }

    public SizedOreDropConfig withExp(int minSmall, int maxSmall, int minBig, int maxBig){
        this.minExpBig = minSmall;
        this.maxExpSmall = maxSmall;
        this.minExpBig = minBig;
        this.maxExpBig = maxBig;
        return this;
    }

    @Override
    public int getExpDrops(BlockState state, LevelReader reader, int fortune, int silkTouch) {
        if(state.getBlock() instanceof WNOreDoubleFormationBlock) {
            if(state.getValue(WNOreDoubleFormationBlock.SIZE) == BigSmallBlock.SMALL) {
                return WNUtil.rint(minExpSmall,maxExpSmall);
            }else{
                return WNUtil.rint(minExpBig,maxExpBig);
            }
        }
        return 0;
    }
}
