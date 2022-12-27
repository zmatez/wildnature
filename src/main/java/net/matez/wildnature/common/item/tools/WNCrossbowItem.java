/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.tools;

import net.matez.wildnature.data.item_models.crossbow.WNItemModel_Crossbow;
import net.matez.wildnature.data.item_models.crossbow.WNItemModel_CrossbowPredicate;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class WNCrossbowItem extends CrossbowItem implements IWNItem {
    private final ToolItem toolItem;

    public WNCrossbowItem(Properties properties, ToolItem toolItem) {
        super(properties);
        this.toolItem = toolItem;
        WildNature.doOnClient(() -> {
            WNItemProperties.makeCrossbow(this);
        });
    }

    public ToolItem getToolItem() {
        return toolItem;
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return null;
    }

    @Nullable
    @Override
    public ItemModelList getItemModels() {
        return new ItemModelList().with(
                new WNItemModel_Crossbow(this.getRegName())
                        .with("texture",this.getTextureName("tools/" + toolItem.getFolder()))
                        .with("model",(this.getRegistryName().getNamespace() + ":item/" + this.getRegistryName().getPath())),
                new WNItemModel_CrossbowPredicate(this.getRegName() + "_arrow").with("texture",this.getTextureName("tools/" + toolItem.getFolder()) + "_arrow"),
                new WNItemModel_CrossbowPredicate(this.getRegName() + "_firework").with("texture",this.getTextureName("tools/" + toolItem.getFolder()) + "_firework"),
                new WNItemModel_CrossbowPredicate(this.getRegName() + "_pulling_0").with("texture",this.getTextureName("tools/" + toolItem.getFolder()) + "_pulling_0"),
                new WNItemModel_CrossbowPredicate(this.getRegName() + "_pulling_1").with("texture",this.getTextureName("tools/" + toolItem.getFolder()) + "_pulling_1"),
                new WNItemModel_CrossbowPredicate(this.getRegName() + "_pulling_2").with("texture",this.getTextureName("tools/" + toolItem.getFolder()) + "_pulling_2")
        );
    }

    @Override
    public String getRegName() {
        return WNItemUtil.getRegName(this);
    }

    @Override
    public String getTextureName() {
        return WNItemUtil.getTextureName(this);
    }

    @Override
    public String getTextureName(String folders) {
        return WNItemUtil.getTextureName(folders, this);
    }

    public int getChargeDurationWN(ItemStack stack) {
        return getChargeDuration(stack);
    }
}
