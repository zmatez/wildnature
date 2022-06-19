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
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
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
        for (TreeEntry treeEntry : trees) {
            var tree = treeEntry.placement();

            var treeFeature = new WNTreeFeature(tree).configured(new NoneFeatureConfiguration()).placed(PlacementUtils.countExtra(5, 0.1F, 1));

            addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, treeFeature);
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

        public PlacedFeature getFeature() {
            if (grass) {
                return new WNFlowerFeature(grasses, flowerConfig.xzSpread, flowerConfig.ySpread, flowerConfig.tries)
                        .configured(new NoneFeatureConfiguration())
                        .placed(NoiseThresholdCountPlacement.of(-0.8D, 5, avgOnceEvery), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
            }
            return new WNFlowerFeature(flowers, flowerConfig.xzSpread, flowerConfig.ySpread, flowerConfig.tries)
                    .configured(new NoneFeatureConfiguration())
                    .placed(NoiseThresholdCountPlacement.of(-0.8D, 15, 4), RarityFilter.onAverageOnceEvery(flowerConfig.avgOnceEvery), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        }
    }
}
