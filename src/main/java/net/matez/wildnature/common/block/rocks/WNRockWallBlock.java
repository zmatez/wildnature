/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.rocks;

import net.matez.wildnature.common.block.basic.WNAbstractWallBlock;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_WallInventory;
import net.matez.wildnature.data.block_models.WNBlockModel_WallPost;
import net.matez.wildnature.data.block_models.WNBlockModel_WallSide;
import net.matez.wildnature.data.block_models.WNBlockModel_WallSideTall;
import net.matez.wildnature.data.blockstates.WNBlockstate_Wall;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.recipes.WNICraftingShaped;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class WNRockWallBlock extends WNAbstractWallBlock {
    protected final RockType rockType;
    private final Supplier<WNBlock> fullBlock;

    public WNRockWallBlock(ResourceLocation location, Properties properties, RockType rockType, Supplier<WNBlock> fullBlock) {
        super(location, properties);
        this.rockType = rockType;
        this.fullBlock = fullBlock;
    }

    public WNRockWallBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, RockType rockType, Supplier<WNBlock> fullBlock) {
        super(location, properties, itemProperties);
        this.rockType = rockType;
        this.fullBlock = fullBlock;
    }

    public WNBlock getFullBlock(){
        return this.fullBlock.get();
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Wall(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        WNBlock full = getFullBlock();
        return new ModelList().with(
                new WNBlockModel_WallSide(this.getRegName() + "_side").with("texture",full.getTextureName("rocks/" + rockType.getIdBase())),
                new WNBlockModel_WallPost(this.getRegName() + "_post").with("texture",full.getTextureName("rocks/" + rockType.getIdBase())),
                new WNBlockModel_WallSideTall(this.getRegName() + "_side_tall").with("texture",full.getTextureName("rocks/" + rockType.getIdBase())),
                new WNBlockModel_WallInventory(this.getRegName() + "_inventory").with("texture",full.getTextureName("rocks/" + rockType.getIdBase()))
        );
    }

    @Nullable
    @Override
    public WNResource getItemModel(){
        return new WNItemModel_BlockParent(getRegName()).with("parent",this.getRegName() + "_inventory");
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        return new WNRecipeList(
                new WNICraftingShaped(this.getRegName(), "walls", """
                        ###
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
                WNTags.WALLS, WNTags.MINEABLE_PICKAXE
        );
    }
}
