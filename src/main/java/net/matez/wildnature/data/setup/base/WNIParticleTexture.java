/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.setup.base;

public abstract class WNIParticleTexture extends WNResource {
    public WNIParticleTexture(String name) {
        super(name);
    }

    public String getPath() {
        return "/assets/" + modid + "/particles";
    }

    @Override
    public boolean containsTextures() {
        return true;
    }
}
