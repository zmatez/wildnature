/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.items.tools;

import net.matez.wildnature.common.objects.items.setup.IWNItem;
import net.matez.wildnature.common.objects.items.setup.WNItemUtil;
import net.matez.wildnature.data.item_models.WNItemModel_Handheld;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.Nullable;

public class WNHoeItem extends HoeItem implements IWNItem {
    private final ToolItem toolItem;

    public WNHoeItem(Tier tier, Properties properties, ToolItem toolItem) {
        super(tier, toolItem.getFamily().getTier().getLevel(),Math.max(0,4F - toolItem.getFamily().getTier().getLevel()), properties);
        this.toolItem = toolItem;
    }

    public ToolItem getToolItem() {
        return toolItem;
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_Handheld(this.getRegName()).with("texture",this.getTextureName("tools/" + toolItem.getFolder()));
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
}
