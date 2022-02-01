/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.items.geyser;

import net.matez.wildnature.common.objects.items.setup.WNItem;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WNGeyserEssenceItem extends WNItem {
    public WNGeyserEssenceItem(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    @Override
    public WNResource getItemModel(){
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("misc"));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        return InteractionResultHolder.success(ItemStack.EMPTY);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, level, components, flag);
        var tag = stack.getOrCreateTag();

        ///todo hex colors
        components.add(new TextComponent("Unstable").withStyle(ChatFormatting.DARK_PURPLE));
    }
}
