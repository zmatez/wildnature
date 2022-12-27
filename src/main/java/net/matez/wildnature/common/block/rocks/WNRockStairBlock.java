/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.rocks;

import net.matez.wildnature.common.block.basic.WNStairBlock;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_Stairs;
import net.matez.wildnature.data.block_models.WNBlockModel_StairsInner;
import net.matez.wildnature.data.block_models.WNBlockModel_StairsOuter;
import net.matez.wildnature.data.blockstates.WNBlockstate_Stairs;
import net.matez.wildnature.data.recipes.WNICraftingShaped;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class WNRockStairBlock extends WNStairBlock {
    protected final RockType rockType;
    private final Supplier<WNBlock> fullBlock;

    public WNRockStairBlock(ResourceLocation location, Properties properties, RockType rockType, Supplier<WNBlock> fullBlock) {
        super(location, () -> {
            return fullBlock.get().defaultBlockState();
        },properties);
        this.rockType = rockType;
        this.fullBlock = fullBlock;
    }

    public WNRockStairBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, RockType rockType, Supplier<WNBlock> fullBlock) {
        super(location, () -> {
            return fullBlock.get().defaultBlockState();
        }, properties, itemProperties);
        this.rockType = rockType;
        this.fullBlock = fullBlock;
    }

    public WNBlock getFullBlock(){
        return this.fullBlock.get();
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Stairs(this.getRegistryName())
                .with("solid", getFullBlock().getRegName())
                ;
    }

    @Override
    public ModelList getBlockModels() {
        WNBlock full = getFullBlock();
        String texture = full.getTextureName("rocks/" + rockType.getIdBase());
        return new ModelList().with(
                new WNBlockModel_Stairs(this.getRegName()).with("texture",texture),
                new WNBlockModel_StairsInner(this.getRegName() + "_inner").with("texture",texture),
                new WNBlockModel_StairsOuter(this.getRegName() + "_outer").with("texture",texture)
        );
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        return new WNRecipeList(
                new WNICraftingShaped(this.getRegName(), "stairs", """
                        #
                        ##
                        ###
                        """,
                        new ItemStack(this.item,4),
                        new WNICraftingShaped.ShapedItems()
                                .with('#',this.getFullBlock().getItem())
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.STAIRS, WNTags.MINEABLE_PICKAXE
        );
    }
}
