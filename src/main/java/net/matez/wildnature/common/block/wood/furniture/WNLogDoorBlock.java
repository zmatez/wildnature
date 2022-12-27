/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.furniture;

import net.matez.wildnature.common.block.basic.WNDoorBlock;
import net.matez.wildnature.common.block.wood.ILog;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_DoorBottom;
import net.matez.wildnature.data.block_models.WNBlockModel_DoorBottomHinge;
import net.matez.wildnature.data.block_models.WNBlockModel_DoorTop;
import net.matez.wildnature.data.block_models.WNBlockModel_DoorTopHinge;
import net.matez.wildnature.data.blockstates.WNBlockstate_Door;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.recipes.WNICraftingShaped;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class WNLogDoorBlock extends WNDoorBlock implements ILog {
    protected final LogType logType;

    public WNLogDoorBlock(ResourceLocation location, Properties properties, LogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNLogDoorBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public WNBlock getPlanks(){
        if(this.logType.getParent() != null){
            return WNBlocks.PLANKS.get(logType.getParent());
        }
        return WNBlocks.PLANKS.get(logType);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Door(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String texture = this.getTextureName("trees/" + logType.getBaseOrParent());
        return new ModelList().with(
                new WNBlockModel_DoorBottom(this.getRegName() + "_bottom").with("texture",texture),
                new WNBlockModel_DoorBottomHinge(this.getRegName() + "_bottom_hinge").with("texture",texture),
                new WNBlockModel_DoorTop(this.getRegName() + "_top").with("texture",texture),
                new WNBlockModel_DoorTopHinge(this.getRegName() + "_top_hinge").with("texture",texture)
        );
    }

    @Nullable
    @Override
    public WNResource getItemModel(){
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("trees/" + logType.getBaseOrParent()) + "_item");
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        if(this.logType.getParent() != null){
            return new WNRecipeList(
                    new WNICraftingShaped(this.getRegName(), "wooden_doors", """
                        ##
                        @@
                        ##
                        """,
                            new ItemStack(this.item,3),
                            new WNICraftingShaped.ShapedItems()
                                    .with('#',this.getPlanks().getItem())
                                    .with('@',WNBlocks.LOGS.get(logType).getItem())
                    ),
                    new WNICraftingShaped(this.getRegName(), "wooden_doors", """
                        ##
                        @@
                        ##
                        """,
                            new ItemStack(this.item,3),
                            new WNICraftingShaped.ShapedItems()
                                    .with('#',this.getPlanks().getItem())
                                    .with('@',WNBlocks.WOODS.get(logType).getItem())
                    )
            );
        }
        return new WNRecipeList(
                new WNICraftingShaped(this.getRegName(), "wooden_doors", """
                        ##
                        ##
                        ##
                        """,
                        new ItemStack(this.item,3),
                        new WNICraftingShaped.ShapedItems()
                                .with('#',this.getPlanks().getItem())
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.DOORS, WNTags.WOODEN_DOORS, WNTags.MINEABLE_AXE
        );
    }
}
