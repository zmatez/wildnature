/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.registry.containers;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.containers.backpack.WNBackpackMenuBig;
import net.matez.wildnature.common.objects.containers.backpack.WNBackpackMenuMedium;
import net.matez.wildnature.common.objects.containers.backpack.WNBackpackMenuSmall;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.LinkedHashMap;

@Initialize(InitStage.REG_MENUS)
public class WNContainers {
    private static final WNLogger log = WildNature.getLogger();

    //# --- ALL BLOCK ENTITIES  ---
    public static final LinkedHashMap<ResourceLocation, MenuType<?>> MENU_TYPES = new LinkedHashMap<>();
    //#------------------

    public static final MenuType<WNBackpackMenuSmall> BACKPACK_SMALL = register(location("backpack_small"), WNBackpackMenuSmall::new);
    public static final MenuType<WNBackpackMenuMedium> BACKPACK_MEDIUM = register(location("backpack_medium"), WNBackpackMenuMedium::new);
    public static final MenuType<WNBackpackMenuBig> BACKPACK_BIG = register(location("backpack_big"), WNBackpackMenuBig::new);

    //#------------------
    public static ResourceLocation location(String name) {
        return new ResourceLocation(WildNature.modid, name);
    }

    private static <T extends AbstractContainerMenu> MenuType<T> register(ResourceLocation registryName, MenuType.MenuSupplier<T> supplier) {
        if (!WildNature.instance.initializer.isInitialized(InitStage.REG_MENUS)) {
            return null;
        }
        MenuType<T> type = new MenuType<>(supplier);
        type.setRegistryName(registryName);
        MENU_TYPES.put(registryName, type);

        return type;
    }
}
