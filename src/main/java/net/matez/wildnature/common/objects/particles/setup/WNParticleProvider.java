/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.particles.setup;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.data.setup.base.WNIParticleTexture;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public interface WNParticleProvider<T extends ParticleOptions> extends ParticleProvider<T> {
    @Nullable
    Particle createParticle(@NotNull T particleType, @NotNull ClientLevel level, double x, double y, double z, double dX, double dY, double dZ);

    ResourceLocation getRegistryName();

    int getSheetAmount();

    default WNBlock.ModelList getTextures() {
        int amount = getSheetAmount();
        return new WNBlock.ModelList().with(new WNIParticleTexture(this.getRegistryName().getPath()) {
            @Override
            public String getJSON() {
                JsonObject object = new JsonObject();
                JsonArray array = new JsonArray();
                for (int i = 0; i < amount; i++) {
                    array.add(getRegistryName().getNamespace() + ":" + getRegistryName().getPath() + "/" + getRegistryName().getPath() + "_" + i);
                }
                object.add("textures", array);

                return object.toString();
            }
        });
    }
}