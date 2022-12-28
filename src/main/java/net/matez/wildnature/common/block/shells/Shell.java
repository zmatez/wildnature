/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.shells;

import net.minecraft.world.level.material.MaterialColor;

public enum Shell {
    COCKLESHELL("cockleshell", MaterialColor.TERRACOTTA_WHITE),
    HORN_SHELL("horn_shell", MaterialColor.COLOR_LIGHT_GRAY),
    LIONS_PAW_SHELL("lions_paw_shell", MaterialColor.TERRACOTTA_BROWN),
    SAND_DOLLAR("sand_dollar", MaterialColor.TERRACOTTA_WHITE),
    STARFISH("starfish", MaterialColor.COLOR_ORANGE),

    ;


    private final String id;
    private final MaterialColor color;

    Shell(String id, MaterialColor color) {
        this.id = id;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public MaterialColor getColor() {
        return color;
    }
}
