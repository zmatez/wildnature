/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.mixin;

import net.matez.wildnature.common.registry.biomes.WNBiomes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public class BiomeMixin {

    @Inject(method = "getGrassColor", at = @At("HEAD"), cancellable = true)
    public void getGrassColor(double x, double z, CallbackInfoReturnable<Integer> info) {
        var instance = (Biome) (Object) this;
        if (WNBiomes.BIOMES.containsKey(instance.getRegistryName())) {
            var biome = WNBiomes.BIOMES.get(instance.getRegistryName());
            info.setReturnValue(biome.getGrassColor(x, z));
        }
    }

    @Inject(method = "getHeightAdjustedTemperature", at = @At("HEAD"), cancellable = true)
    public void getHeightAdjustedTemperature(BlockPos pos, CallbackInfoReturnable<Float> info) {
        var instance = (Biome) (Object) this;
        if (WNBiomes.BIOMES.containsKey(instance.getRegistryName())) {
            var biome = WNBiomes.BIOMES.get(instance.getRegistryName());
            info.setReturnValue(biome.getHeightAdjustedTemperature(pos));
        }
    }
}
