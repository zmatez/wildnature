/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.biomes.setup;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.objects.features.flower.WNFlowerFeature;
import net.matez.wildnature.common.objects.features.tree.WNTreeFeature;
import net.matez.wildnature.common.objects.structures.WNStructurePlacement;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.common.util.WeightedList;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.ArrayList;

public class WNBiome extends WNVanillaBiomeExtension {
    private static final WNLogger log = WildNature.getLogger();
    private final ArrayList<TreeEntry> trees = new ArrayList<>();
    private final WeightedList<BlockState> flowers = new WeightedList<>();
    private final FlowerConfig flowerConfig = new FlowerConfig(6, 2, 42, 8, false);
    private final WeightedList<BlockState> grasses = new WeightedList<>();
    private final FlowerConfig grassConfig = new FlowerConfig(7, 3, 32, 18, true);

    public WNBiome(ResourceLocation registryName, WNBiomeBuilder builder) {
        super(registryName, builder);
    }

    public void addTree(WNStructurePlacement structure, int count) {
        trees.add(new TreeEntry(structure, count));
    }

    public void addFlower(BlockState state, int weight) {
        flowers.put(state, weight);
    }

    public void addFlower(BushType type, int weight) {
        this.addFlower(WNBlocks.BUSHES.get(type), weight);
    }

    public void addFlower(Block block, int weight) {
        var state = block.defaultBlockState();

        if (state.hasProperty(WNBlockProperties.FLOWERING)) {
            state = state.setValue(WNBlockProperties.FLOWERING, true);
        }

        flowers.put(state, weight);
    }

    public void addGrass(BlockState state, int weight) {
        grasses.put(state, weight);
    }

    public void addGrass(BushType type, int weight) {
        this.addFlower(WNBlocks.BUSHES.get(type), weight);
    }

    public void addGrass(Block block, int weight) {
        var state = block.defaultBlockState();

        if (state.hasProperty(WNBlockProperties.FLOWERING)) {
            state = state.setValue(WNBlockProperties.FLOWERING, true);
        }

        grasses.put(state, weight);
    }

    public void setGrassDensity(int density, int spread) {
        grassConfig.avgOnceEvery = density;
        grassConfig.tries = spread;
    }

    public void build() {
        buildTrees();
        buildVegetation();
        super.build();
    }

    private void buildTrees() {
        int index = 0;
        for (TreeEntry treeEntry : trees) {
            var tree = treeEntry.placement();

            var configuredTree = FeatureUtils.register(this.getRegistryName() + "_trees_" + index, new WNTreeFeature(tree));
            var placementTree = PlacementUtils.register(this.getRegistryName() + "_trees_" + index, configuredTree, PlacementUtils.countExtra(5, 0.1F, 1));

            addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placementTree);
            index++;
        }
    }

    private void buildVegetation() {
        if (!flowerConfig.disabled) {
            addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, flowerConfig.getFeature());
        }
        if (!grassConfig.disabled) {
            addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, grassConfig.getFeature());
        }
    }

    public record TreeEntry(WNStructurePlacement placement, int count) {
    }

    public class FlowerConfig {
        private final boolean grass;
        private int xzSpread;
        private int ySpread;
        private int tries;
        private int avgOnceEvery;
        private boolean disabled = false;

        private static int plantIndex = 0;

        public FlowerConfig(int xzSpread, int ySpread, int tries, int avgOnceEvery, boolean grass) {
            this.xzSpread = xzSpread;
            this.ySpread = ySpread;
            this.tries = tries;
            this.avgOnceEvery = avgOnceEvery;
            this.grass = grass;
        }

        public FlowerConfig copy() {
            return new FlowerConfig(xzSpread, ySpread, tries, avgOnceEvery, grass);
        }

        public int getXZSpread() {
            return xzSpread;
        }

        public int getYSpread() {
            return ySpread;
        }

        public int getTries() {
            return tries;
        }

        public int getAvgOnceEvery() {
            return avgOnceEvery;
        }

        public void asFeature() {
            addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, getFeature());
        }

        public void asFeature(boolean register) {
            addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, getFeature(), register);
        }

        public Holder<PlacedFeature> getFeature() {
            if (grass) {
                var configuredGrass = FeatureUtils.register(getRegistryName() + "_plants_" + plantIndex, new WNFlowerFeature(grasses, flowerConfig.xzSpread, flowerConfig.ySpread, flowerConfig.tries));
                var placedGrass = PlacementUtils.register(
                        getRegistryName() + "_plants_" + plantIndex,
                        configuredGrass,
                        NoiseThresholdCountPlacement.of(-0.8D, 5, avgOnceEvery), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()
                );

                plantIndex++;

                return placedGrass;
            }

            var configuredFlower = FeatureUtils.register(getRegistryName() + "_plants_" + plantIndex, new WNFlowerFeature(flowers, flowerConfig.xzSpread, flowerConfig.ySpread, flowerConfig.tries));
            var placedFlower = PlacementUtils.register(
                    getRegistryName() + "_plants_" + plantIndex,
                    configuredFlower,
                    NoiseThresholdCountPlacement.of(-0.8D, 15, 4), RarityFilter.onAverageOnceEvery(flowerConfig.avgOnceEvery), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
            );

            plantIndex++;

            return placedFlower;
        }
    }
}
