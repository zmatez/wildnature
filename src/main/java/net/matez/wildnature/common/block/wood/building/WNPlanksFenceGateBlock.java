/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.building;

import net.matez.wildnature.common.block.basic.WNFenceGateBlock;
import net.matez.wildnature.common.block.wood.ILog;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_FenceGate;
import net.matez.wildnature.data.block_models.WNBlockModel_FenceGateOpen;
import net.matez.wildnature.data.block_models.WNBlockModel_FenceGateWall;
import net.matez.wildnature.data.block_models.WNBlockModel_FenceGateWallOpen;
import net.matez.wildnature.data.blockstates.WNBlockstate_FenceGate;
import net.matez.wildnature.data.recipes.WNICraftingShaped;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WNPlanksFenceGateBlock extends WNFenceGateBlock implements ILog {
    protected final LogType logType;

    public WNPlanksFenceGateBlock(ResourceLocation location, Properties properties, LogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNPlanksFenceGateBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public WNBlock getPlanks(){
        return WNBlocks.PLANKS.get(logType);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_FenceGate(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        WNBlock planks = getPlanks();
        String texture = planks.getTextureName("trees/" + logType.getBaseOrParent());
        return new ModelList().with(
                new WNBlockModel_FenceGate(this.getRegName()).with("texture",texture),
                new WNBlockModel_FenceGateOpen(this.getRegName() + "_open").with("texture",texture),
                new WNBlockModel_FenceGateWall(this.getRegName() + "_wall").with("texture",texture),
                new WNBlockModel_FenceGateWallOpen(this.getRegName() + "_wall_open").with("texture",texture)
        );
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        return new WNRecipeList(
                new WNICraftingShaped(this.getRegName(), "wooden_fence_gates", """
                        |#|
                        |#|
                        """,
                        new ItemStack(this.item),
                        new WNICraftingShaped.ShapedItems()
                                .with('#',this.getPlanks().getItem())
                                .with('|', Items.STICK)
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FENCE_GATES, WNTags.WOODEN_FENCE_GATES, WNTags.FORGE_FENCE_GATES, WNTags.FORGE_WOODEN_FENCE_GATES, WNTags.MINEABLE_AXE, WNTags.UNSTABLE_BOTTOM_CENTER
        );
    }


    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 20;
    }
}
