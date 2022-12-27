/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.client.particle.setup;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class WNParticle extends TextureSheetParticle {
    protected WNParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z);
    }

    protected WNParticle(ClientLevel level, double x, double y, double z, double dX, double dY, double dZ) {
        super(level, x, y, z, dX, dY, dZ);
    }
}
