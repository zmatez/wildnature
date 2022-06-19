/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.setup.base;

public abstract class WNBlockModel extends WNResource {
    public WNBlockModel(String name) {
        super(name);
    }

    public String getPath() {
        return "/assets/" + modid + "/models/block";
    }

    @Override
    public boolean containsTextures() {
        return true;
    }
}
