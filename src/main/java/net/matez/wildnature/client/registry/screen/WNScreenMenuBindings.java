/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.client.registry.screen;

import net.matez.wildnature.client.objects.screen.backpack.WNBackpackBigScreen;
import net.matez.wildnature.client.objects.screen.backpack.WNBackpackMediumScreen;
import net.matez.wildnature.client.objects.screen.backpack.WNBackpackSmallScreen;
import net.matez.wildnature.common.objects.containers.backpack.WNBackpackMenuBig;
import net.matez.wildnature.common.objects.containers.backpack.WNBackpackMenuMedium;
import net.matez.wildnature.common.objects.containers.backpack.WNBackpackMenuSmall;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.common.registry.containers.WNContainers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.LinkedHashMap;

@Initialize(InitStage.CLIENT)
public class WNScreenMenuBindings {
    //# --- ALL SCREENS ---
    public static final LinkedHashMap<MenuType, MenuScreens.ScreenConstructor<?, ?>> SCREEN_CONSTRUCTORS = new LinkedHashMap<>();
    //#------------------

    public static final MenuScreens.ScreenConstructor<WNBackpackMenuSmall, WNBackpackSmallScreen> BACKPACK_SMALL = register(WNContainers.BACKPACK_SMALL, WNBackpackSmallScreen::new);
    public static final MenuScreens.ScreenConstructor<WNBackpackMenuMedium, WNBackpackMediumScreen> BACKPACK_MEDIUM = register(WNContainers.BACKPACK_MEDIUM, WNBackpackMediumScreen::new);
    public static final MenuScreens.ScreenConstructor<WNBackpackMenuBig, WNBackpackBigScreen> BACKPACK_BIG = register(WNContainers.BACKPACK_BIG, WNBackpackBigScreen::new);

    private static <M extends AbstractContainerMenu, U extends Screen & MenuAccess<M>> MenuScreens.ScreenConstructor<M, U> register(MenuType<? extends M> menu, MenuScreens.ScreenConstructor<M, U> constructor) {
        SCREEN_CONSTRUCTORS.put(menu, constructor);
        return constructor;
    }

    public static void register() {
        SCREEN_CONSTRUCTORS.forEach(MenuScreens::register);
    }
}
