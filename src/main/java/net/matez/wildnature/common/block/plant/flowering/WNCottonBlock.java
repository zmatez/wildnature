/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant.flowering;

import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.core.registry.WNItems;
import net.matez.wildnature.api.util.ExtraMath;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class WNCottonBlock extends WNFloweringBushBlock{
    public WNCottonBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNCottonBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(state.getValue(FLOWERING)){
            popResourceFromFace(level,pos,result.getDirection(),new ItemStack(WNItems.COTTON, ExtraMath.rint(1,2)));
            level.setBlockAndUpdate(pos,state.setValue(FLOWERING,false));
            return InteractionResult.SUCCESS;
        }
        return super.use(state, level, pos, player, hand, result);
    }
}
