/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.events;

import net.matez.wildnature.common.util.WNChatUtil;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.HoverEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WildNature.modid, bus = Mod.EventBusSubscriber.Bus.FORGE)
@OnlyIn(Dist.CLIENT)
public class PlayerJoinEvent {
    @SubscribeEvent
    public static void onPlayerJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        WNChatUtil.send(event.getEntity(), "This is an alpha &v" + WildNature.getVersion() + "&r version of WildNature.", true);
        //WNChatUtil.send(event.getPlayer(), "To complete this mod we need &vcoders&r and &vdatapackers&r to help us with development. More on ", true);
        WNChatUtil.send(event.getEntity(),
                WNChatUtil.getLogo()
                        .append(WNChatUtil.parseMessage("To complete this mod we need &vcoders&r and &vdatapackers&r to help us with development. More on ", WNChatUtil.BRIGHT_ACCENT_COLOR))
                        .append(new TextComponent("Discord")
                                .withStyle(WNChatUtil.format(WNChatUtil.ACCENT_COLOR).withBold(false).withUnderlined(true)
                                        .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/dazHZJE"))
                                        .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                                new TextComponent("Check the Announcements channel in that Discord server.").withStyle(WNChatUtil.format(WNChatUtil.ACCENT_COLOR)
                                                ))
                                        ))
                        )
        );
    }
}
