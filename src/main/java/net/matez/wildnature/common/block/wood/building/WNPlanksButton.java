/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.building;

import net.matez.wildnature.common.block.wood.ILog;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_Button;
import net.matez.wildnature.data.block_models.WNBlockModel_ButtonInventory;
import net.matez.wildnature.data.block_models.WNBlockModel_ButtonPressed;
import net.matez.wildnature.data.blockstates.WNBlockstate_Button;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.recipes.WNICraftingShapeless;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class WNPlanksButton extends WNButtonBlock implements ILog {
    protected final LogType logType;

    public WNPlanksButton(ResourceLocation location, Properties properties, LogType logType) {
        super(location, true, properties);
        this.logType = logType;
    }

    public WNPlanksButton(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
        super(location, true, properties, itemProperties);
        this.logType = logType;
    }

    protected SoundEvent getSound(boolean click) {
        return click ? SoundEvents.WOODEN_BUTTON_CLICK_ON : SoundEvents.WOODEN_BUTTON_CLICK_OFF;
    }

    public WNBlock getPlanks(){
        return WNBlocks.PLANKS.get(logType);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Button(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        WNBlock planks = getPlanks();
        String texture = planks.getTextureName("trees/" + logType.getBaseOrParent());
        return new ModelList().with(
                new WNBlockModel_Button(this.getRegName()).with("texture",texture),
                new WNBlockModel_ButtonPressed(this.getRegName() + "_pressed").with("texture",texture),
                new WNBlockModel_ButtonInventory(this.getRegName() + "_inventory").with("texture",texture)
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
                new WNICraftingShapeless(this.getRegName(), "wooden_buttons",
                        new ItemStack(this.item,1),
                        new WNICraftingShapeless.ShapelessItems()
                                .with(this.getPlanks().getItem())
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.BUTTONS, WNTags.WOODEN_BUTTONS, WNTags.MINEABLE_AXE
        );
    }
}
