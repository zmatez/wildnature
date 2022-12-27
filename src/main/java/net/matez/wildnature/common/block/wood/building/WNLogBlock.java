/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.building;

import net.matez.wildnature.common.block.wood.ILog;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeColumn;
import net.matez.wildnature.data.recipes.WNICraftingShapeless;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WNLogBlock extends WNRotatedPillarBlock implements ILog {
    private final LogType logType;
    private final boolean stripped;
    private final boolean wood;

    public WNLogBlock(ResourceLocation location, Properties properties, LogType logType, boolean stripped, boolean wood) {
        super(location, properties);
        this.logType = logType;
        this.stripped = stripped;
        this.wood = wood;
    }

    public WNLogBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType, boolean stripped, boolean wood) {
        super(location, properties, itemProperties);
        this.logType = logType;
        this.stripped = stripped;
        this.wood = wood;
    }

    @Override
    public ModelList getBlockModels() {
        String path = this.getRegistryName().getNamespace() + ":blocks/trees/" + logType.getBaseOrParent() + "/" + logType.getIdBase() + "_" + (this.stripped ? "stripped_" : "") + "log";
        return new ModelList()
                .with(
                        new WNBlockModel_CubeColumn(this.getRegName())
                                .with("texture", path)
                                .with("texture_top",path + (this.wood ? "" : "_top"))
                );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.LOGS, WNTags.MINEABLE_AXE
        );
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        return new WNRecipeList(
                new WNICraftingShapeless(this.getRegName(),new ItemStack(this.item),new WNICraftingShapeless.ShapelessItems())
        );
    }


    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }
}
