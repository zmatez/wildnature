/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.shells;

import net.matez.wildnature.data.block_models.shells.*;
import net.minecraft.world.level.material.MaterialColor;

public enum Shell {
    COCKLESHELL("cockleshell", MaterialColor.TERRACOTTA_WHITE, (block) -> new WNBlockModel_Cockleshell(block.getRegName())),
    HORN_SHELL("horn_shell", MaterialColor.COLOR_LIGHT_GRAY, (block) -> new WNBlockModel_HornShell(block.getRegName())),
    LIONS_PAW_SHELL("lions_paw_shell", MaterialColor.TERRACOTTA_BROWN, (block) -> new WNBlockModel_LionsPawShell(block.getRegName())),
    SAND_DOLLAR("sand_dollar", MaterialColor.TERRACOTTA_WHITE, (block) -> new WNBlockModel_SandDollar(block.getRegName())),
    STARFISH("starfish", MaterialColor.COLOR_ORANGE, (block) -> new WNBlockModel_Starfish(block.getRegName())),

    ;


    private final String id;
    private final MaterialColor color;
    private final ModelSupplier modelSupplier;

    Shell(String id, MaterialColor color, ModelSupplier modelSupplier) {
        this.id = id;
        this.color = color;
        this.modelSupplier = modelSupplier;
    }

    public String getId() {
        return id;
    }

    public MaterialColor getColor() {
        return color;
    }

    public ModelSupplier getModelSupplier() {
        return modelSupplier;
    }
}
