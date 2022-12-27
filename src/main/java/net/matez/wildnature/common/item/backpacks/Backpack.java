/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.backpacks;

public enum Backpack {
    BACKPACK_SMALL("backpack_small"),
    BACKPACK_MEDIUM("backpack_medium"),
    BACKPACK_BIG("backpack_big"),
    ;
    private final String id;

    Backpack(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
