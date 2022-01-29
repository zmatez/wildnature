/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.wood.vanilla.building;

import net.matez.wildnature.common.objects.blocks.basic.WNSlabBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.blocks.wood.vanilla.VanillaLogType;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_Slab;
import net.matez.wildnature.data.block_models.WNBlockModel_SlabTop;
import net.matez.wildnature.data.blockstates.WNBlockstate_Slab;
import net.matez.wildnature.data.recipes.WNICraftingShaped;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WNVanillaPlanksSlabBlock extends WNSlabBlock {
    protected final VanillaLogType logType;

    public WNVanillaPlanksSlabBlock(ResourceLocation location, Properties properties, VanillaLogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNVanillaPlanksSlabBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, VanillaLogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public WNBlock getPlanks(){
        return WNBlocks.VANILLA_PARQUET.get(this.logType);
    }

    /*
    public WNBlock getPlanks(){
        return switch (logType){
            case OAK -> Blocks.OAK_PLANKS;
            case SPRUCE -> Blocks.SPRUCE_PLANKS;
            case BIRCH -> Blocks.BIRCH_PLANKS;
            case JUNGLE -> Blocks.JUNGLE_PLANKS;
            case ACACIA -> Blocks.ACACIA_PLANKS;
            case DARK_DARK_OAK -> Blocks.DARK_OAK_PLANKS;
        };
    }
     */

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Slab(this.getRegistryName())
                .with("solid", getPlanks().getRegName())
                ;
    }

    @Override
    public ModelList getBlockModels() {
        WNBlock planks = getPlanks();
        return new ModelList().with(
                new WNBlockModel_Slab(this.getRegName()).with("texture",planks.getTextureName("trees/" + logType.getName())),
                new WNBlockModel_SlabTop(this.getRegName() + "_top").with("texture",planks.getTextureName("trees/" + logType.getName()))
        );
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        return new WNRecipeList(
                new WNICraftingShaped(this.getRegName(), "wooden_slabs", """
                        ###
                        """,
                        new ItemStack(this.item),
                        new WNICraftingShaped.ShapedItems()
                                .with('#',this.getPlanks().getItem())
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.SLABS, WNTags.WOODEN_SLABS, WNTags.MINEABLE_AXE
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
