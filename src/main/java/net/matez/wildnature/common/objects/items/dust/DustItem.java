/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.items.dust;

public enum DustItem {
    GLOWSHROOM_DUST("glowshroom_dust"),
    ICESHROOM_DUST("iceshroom_dust")
    ;
    private String id;

    DustItem(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
