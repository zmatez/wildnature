/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.backpacks;

import net.matez.wildnature.common.containers.backpack.WNBackpackMenuBig;
import net.matez.wildnature.common.containers.backpack.WNBackpackMenuMedium;
import net.matez.wildnature.common.containers.backpack.WNBackpackMenuSmall;
import net.matez.wildnature.api.client.chat.ChatHelper;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WNBackpackItem extends WNItem {
    private final Backpack backpackItem;

    public WNBackpackItem(ResourceLocation location, Properties properties, Backpack backpackItem) {
        super(location, properties);
        this.backpackItem = backpackItem;
    }

    public Backpack getBackpackItem() {
        return backpackItem;
    }

    @Override
    public WNResource getItemModel() {
        return new WNItemModel_Generated(this.getRegName()).with("texture", this.getTextureName("backpacks"));
    }

    @Override
    public boolean canFitInsideContainerItems() {
        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.openMenu(getMenu(stack));
        return InteractionResultHolder.success(stack);
    }

    public MenuProvider getMenu(ItemStack stack) {
        return new SimpleMenuProvider((id, inventory, player) -> switch (this.backpackItem) {
            case BACKPACK_SMALL -> new WNBackpackMenuSmall(id, inventory, stack, player);
            case BACKPACK_MEDIUM -> new WNBackpackMenuMedium(id, inventory, stack, player);
            case BACKPACK_BIG -> new WNBackpackMenuBig(id, inventory, stack, player);
        }, this.getName(stack));
    }

    public int getSize() {
        return switch (this.backpackItem) {
            case BACKPACK_SMALL -> 18;
            case BACKPACK_MEDIUM -> 27;
            case BACKPACK_BIG -> 44;
        };
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, level, components, flag);
        var tag = stack.getOrCreateTag();

        if (tag.contains("owner")) {
            if (level != null) {
                Player player = level.getPlayerByUUID(tag.getUUID("owner"));
                if (player != null) {
                    components.add(new TextComponent("Owned by ").withStyle(ChatFormatting.GRAY).append(new TextComponent(player.getDisplayName().getString()).withStyle(ChatHelper.format(ChatHelper.ACCENT_COLOR))));
                }
            }
        }

        if (tag.contains("count")) {
            int count = tag.getInt("count");
            components.add(new TextComponent("Filled in ").withStyle(ChatFormatting.GRAY)
                    .append(new TextComponent((int) Math.ceil((double) count / (double) getSize() * 100) + "%").withStyle(ChatHelper.format(ChatHelper.ACCENT_COLOR))));

        }
    }
}
