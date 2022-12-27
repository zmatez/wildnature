/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.ores;

import net.minecraft.util.StringRepresentable;

public enum BigSmallBlock implements StringRepresentable {
    SMALL,
    BIG;

    public String toString() {
        return this.getSerializedName();
    }

    public String getSerializedName() {
        return this == BIG ? "big" : "small";
    }
}