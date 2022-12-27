/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.rocks;

import net.matez.wildnature.common.block.basic.WNSlabBlock;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_Slab;
import net.matez.wildnature.data.block_models.WNBlockModel_SlabTop;
import net.matez.wildnature.data.blockstates.WNBlockstate_Slab;
import net.matez.wildnature.data.recipes.WNICraftingShaped;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class WNRockSlabBlock extends WNSlabBlock {
    protected final RockType rockType;
    private final Supplier<WNBlock> fullBlock;

    public WNRockSlabBlock(ResourceLocation location, Properties properties, RockType rockType, Supplier<WNBlock> fullBlock) {
        super(location, properties);
        this.rockType = rockType;
        this.fullBlock = fullBlock;
    }

    public WNRockSlabBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, RockType rockType, Supplier<WNBlock> fullBlock) {
        super(location, properties, itemProperties);
        this.rockType = rockType;
        this.fullBlock = fullBlock;
    }

    public WNBlock getFullBlock(){
        return this.fullBlock.get();
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Slab(this.getRegistryName())
                .with("solid", getFullBlock().getRegName())
                ;
    }

    @Override
    public ModelList getBlockModels() {
        WNBlock planks = getFullBlock();
        return new ModelList().with(
                new WNBlockModel_Slab(this.getRegName()).with("texture",planks.getTextureName("rocks/" + rockType.getIdBase())),
                new WNBlockModel_SlabTop(this.getRegName() + "_top").with("texture",planks.getTextureName("rocks/" + rockType.getIdBase()))
        );
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        return new WNRecipeList(
                new WNICraftingShaped(this.getRegName(), "slabs", """
                        ###
                        """,
                        new ItemStack(this.item),
                        new WNICraftingShaped.ShapedItems()
                                .with('#',this.getFullBlock().getItem())
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.SLABS, WNTags.MINEABLE_PICKAXE
        );
    }
}
