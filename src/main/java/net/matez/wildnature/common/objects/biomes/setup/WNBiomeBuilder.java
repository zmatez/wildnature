/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.biomes.setup;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;
import java.util.Arrays;

public class WNBiomeBuilder {
    private float temperature;
    private float downfall;
    private ColorModifier grassColor;
    private int foliageColor = -1;
    private int waterColor = 0x3F76E4;
    private int waterFogColor = 0x050533;
    private int skyColor = -1;
    private int fogColor = 0xC0D8FF;
    private TemperatureModifier temperatureModifier = (pos, temp) -> temp;
    private WNPrecipitation precipitation;
    private WNBiomeCategory category;
    private ArrayList<BiomeDictionary.Type> additionalTypes;

    protected static int calculateSkyColor(float temperature) {
        float $$1 = temperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    public WNBiomeBuilder temperature(float temperature) {
        this.temperature = temperature;
        if (this.skyColor == -1) {
            this.skyColor(calculateSkyColor(temperature));
        }
        return this;
    }

    public WNBiomeBuilder downfall(float downfall) {
        this.downfall = downfall;
        return this;
    }

    public WNBiomeBuilder grassColor(ColorModifier grassColor) {
        this.grassColor = grassColor;
        return this;
    }

    public WNBiomeBuilder foliageColor(int foliageColor) {
        this.foliageColor = foliageColor;
        return this;
    }

    public WNBiomeBuilder waterColor(int waterColor) {
        this.waterColor = waterColor;
        return this;
    }

    public WNBiomeBuilder waterFogColor(int waterFogColor) {
        this.waterFogColor = waterFogColor;
        return this;
    }

    public WNBiomeBuilder skyColor(int skyColor) {
        this.skyColor = skyColor;
        return this;
    }

    public WNBiomeBuilder fogColor(int fogColor) {
        this.fogColor = fogColor;
        return this;
    }

    public WNBiomeBuilder temperatureModifier(TemperatureModifier temperatureModifier) {
        this.temperatureModifier = temperatureModifier;
        return this;
    }

    public WNBiomeBuilder precipitation(WNPrecipitation precipitation) {
        this.precipitation = precipitation;
        return this;
    }

    public WNBiomeBuilder category(WNBiomeCategory category) {
        this.category = category;
        return this;
    }

    // # --------------------------------------------------------------------

    public WNBiomeBuilder additionalTypes(BiomeDictionary.Type... types) {
        additionalTypes = new ArrayList<>(Arrays.asList(types));
        return this;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getDownfall() {
        return downfall;
    }

    public ColorModifier getGrassColor() {
        return grassColor;
    }

    public int getFoliageColor() {
        return foliageColor;
    }

    public int getWaterColor() {
        return waterColor;
    }

    public int getWaterFogColor() {
        return waterFogColor;
    }

    public int getSkyColor() {
        return skyColor;
    }

    public int getFogColor() {
        return fogColor;
    }

    public TemperatureModifier getTemperatureModifier() {
        return temperatureModifier;
    }

    public WNPrecipitation getPrecipitation() {
        return precipitation;
    }

    public WNBiomeCategory getCategory() {
        return category;
    }

    // # --------------------------------------------------------------------

    public ArrayList<BiomeDictionary.Type> getAdditionalTypes() {
        return additionalTypes;
    }

    public interface ColorModifier {
        int modify(double noise, double x, double z, int defaultColor);
    }

    public interface TemperatureModifier {
        float modify(BlockPos pos, float baseTemperature);
    }
}
