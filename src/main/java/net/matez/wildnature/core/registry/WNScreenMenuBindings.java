/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.core.registry;

import net.matez.wildnature.client.screen.backpack.WNBackpackBigScreen;
import net.matez.wildnature.client.screen.backpack.WNBackpackMediumScreen;
import net.matez.wildnature.client.screen.backpack.WNBackpackSmallScreen;
import net.matez.wildnature.common.containers.backpack.WNBackpackMenuBig;
import net.matez.wildnature.common.containers.backpack.WNBackpackMenuMedium;
import net.matez.wildnature.common.containers.backpack.WNBackpackMenuSmall;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.LinkedHashMap;

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
