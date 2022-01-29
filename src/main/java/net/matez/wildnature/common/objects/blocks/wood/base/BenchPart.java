/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.wood.base;

import net.minecraft.util.StringRepresentable;

public enum BenchPart implements StringRepresentable {
    SINGLE,
    MIDDLE,
    RIGHT,
    LEFT;

    public String toString() {
        return this.getSerializedName();
    }

    public String getSerializedName() {
        return this == SINGLE ? "single" : (this == RIGHT ? "right" : (this == LEFT ? "left" : "middle"));
    }
}