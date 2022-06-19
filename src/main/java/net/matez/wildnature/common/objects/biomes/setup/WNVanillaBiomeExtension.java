/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.biomes.setup;

import com.google.common.collect.ImmutableList;
import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.registry.biomes.WNBiomes;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;

public abstract class WNVanillaBiomeExtension {
    protected static final PerlinSimplexNoise BIOME_NOISE = new PerlinSimplexNoise(new WorldgenRandom(new LegacyRandomSource(2345L)), ImmutableList.of(0));
    protected static final PerlinSimplexNoise TEMPERATURE_NOISE = new PerlinSimplexNoise(new WorldgenRandom(new LegacyRandomSource(1234L)), ImmutableList.of(0));
    private static final WNLogger log = WildNature.getLogger();
    private final ResourceLocation registryName;
    private final WNBiomeBuilder builder;
    private final ArrayList<FeatureEntry> features = new ArrayList<>();
    private Biome vanilla;


    public WNVanillaBiomeExtension(ResourceLocation registryName, WNBiomeBuilder builder) {
        this.registryName = registryName;
        this.builder = builder;
    }

    public int getGrassColor(double x, double z) {
        double d0 = Mth.clamp(this.builder.getTemperature(), 0.0F, 1.0F);
        double d1 = Mth.clamp(this.builder.getDownfall(), 0.0F, 1.0F);
        int color = GrassColor.get(d0, d1);
        if (builder.getGrassColor() != null) {
            double noise = BIOME_NOISE.getValue(x * 0.0225D, z * 0.0225D, false);
            return builder.getGrassColor().modify(noise, x, z, color);
        }
        return color;
    }

    public float getHeightAdjustedTemperature(BlockPos pos) {
        float f = this.builder.getTemperatureModifier().modify(pos, this.builder.getTemperature());
        if (pos.getY() > 80) {
            float f1 = (float) (TEMPERATURE_NOISE.getValue((double) ((float) pos.getX() / 8.0F), (double) ((float) pos.getZ() / 8.0F), false) * 8.0D);
            return f - (f1 + (float) pos.getY() - 80.0F) * 0.05F / 40.0F;
        } else {
            return f;
        }
    }

    public void addFeature(GenerationStep.Decoration stage, PlacedFeature feature) {
        features.add(new FeatureEntry(stage, feature, true));
    }

    public void addFeature(GenerationStep.Decoration stage, PlacedFeature feature, boolean shouldRegister) {
        features.add(new FeatureEntry(stage, feature, shouldRegister));
    }

    public ArrayList<FeatureEntry> getFeatures() {
        return features;
    }

    public void loadVanilla() {
        var effects = new BiomeSpecialEffects.Builder();
        if (this.builder.getFogColor() != -1) {
            effects.fogColor(this.builder.getFogColor());
        }
        if (this.builder.getWaterColor() != -1) {
            effects.waterColor(this.builder.getWaterColor());
        }
        if (this.builder.getWaterFogColor() != -1) {
            effects.waterFogColor(this.builder.getWaterFogColor());
        }
        if (this.builder.getSkyColor() != -1) {
            effects.skyColor(this.builder.getSkyColor());
        }
        if (this.builder.getFoliageColor() != -1) {
            effects.foliageColorOverride(this.builder.getFoliageColor());
        }

        var genSettings = new BiomeGenerationSettings.Builder();
        for (var feature : getFeatures()) {
            genSettings.addFeature(feature.stage(), feature.feature());
        }

        vanilla = new Biome.BiomeBuilder()
                .temperature(builder.getTemperature())
                .downfall(builder.getDownfall())
                .biomeCategory(builder.getCategory().getAlt())
                .precipitation(builder.getPrecipitation().getAlt())
                .specialEffects(effects.build())
                .mobSpawnSettings(new MobSpawnSettings.Builder().build())
                .generationSettings(genSettings.build())
                .build();
        vanilla.setRegistryName(this.getRegistryName());
    }

    public void postRegister(ResourceKey<Biome> key) {
        BiomeDictionary.addTypes(key, this.builder.getAdditionalTypes().toArray(new BiomeDictionary.Type[0]));
        BiomeManager.BiomeType type = BiomeManager.BiomeType.WARM;

        if (builder.getAdditionalTypes().contains(BiomeDictionary.Type.SANDY) || builder.getAdditionalTypes().contains(BiomeDictionary.Type.SAVANNA)) {
            type = BiomeManager.BiomeType.DESERT;
        } else if (builder.getAdditionalTypes().contains(BiomeDictionary.Type.COLD)) {
            if (builder.getAdditionalTypes().contains(BiomeDictionary.Type.SNOWY)) {
                type = BiomeManager.BiomeType.ICY;
            } else {
                type = BiomeManager.BiomeType.COOL;
            }
        }
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, 10));
    }

    public Biome getVanilla() {
        return vanilla;
    }

    public ResourceLocation getRegistryName() {
        return registryName;
    }

    public void build() {
        registerFeatures();
    }

    private void registerFeatures() {
        for (var feature : getFeatures()) {
            if (!feature.register()) {
                continue;
            }

            var placed = feature.feature();
            placed.getFeatures().forEach((configuredFeature) -> {
                if (configuredFeature.feature().getRegistryName() == null) {
                    var loc = new ResourceLocation(WildNature.modid, "feature_" + (WNBiomes.FEATURES.size() + 1));
                    configuredFeature.feature().setRegistryName(loc);
                    WNBiomes.FEATURES.put(loc, configuredFeature.feature());
                }
                var cfLoc = new ResourceLocation(WildNature.modid, "configured_feature_" + (WNBiomes.FEATURES.size() + 1));
                WNBiomes.CONFIGURED_FEATURES.put(cfLoc, configuredFeature);
            });

            var pLoc = new ResourceLocation(WildNature.modid, "placed_feature_" + (WNBiomes.FEATURES.size() + 1));
            WNBiomes.PLACED_FEATURES.put(pLoc, placed);
        }
    }

    public record FeatureEntry(GenerationStep.Decoration stage, PlacedFeature feature, boolean register) {
    }
}
