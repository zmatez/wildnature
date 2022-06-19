/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.biomes;

import net.matez.wildnature.common.objects.biomes.setup.WNBiome;
import net.matez.wildnature.common.objects.biomes.setup.WNBiomeBuilder;
import net.matez.wildnature.common.objects.biomes.setup.WNBiomeCategory;
import net.matez.wildnature.common.objects.biomes.setup.WNPrecipitation;
import net.matez.wildnature.common.objects.blocks.leaves.LeafType;
import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.structures.WNStructureFolders;
import net.matez.wildnature.common.objects.structures.WNStructurePlacement;
import net.matez.wildnature.common.objects.structures.configs.WNTreeConfig;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.BiomeDictionary;

public class WNTestBiome extends WNBiome {
    public WNTestBiome(ResourceLocation registryName) {
        super(registryName,
                new WNBiomeBuilder()
                        .temperature(0.5f)
                        .downfall(0.3f)
                        .precipitation(WNPrecipitation.RAIN)
                        .category(WNBiomeCategory.PLAINS)
                        .foliageColor(0xA3F320)
                        .grassColor((noise, x, z, color) -> {
                            return noise > 0.1f ? 0xB5F324 : 0x3BF329;
                        })
                        .additionalTypes(
                                BiomeDictionary.Type.HOT,
                                BiomeDictionary.Type.SPARSE,
                                BiomeDictionary.Type.PLAINS,
                                BiomeDictionary.Type.OVERWORLD
                        )

        );

        addGrass(Blocks.GRASS, 4);
        addGrass(BushType.MEDIUM_GRASS, 2);
        addGrass(BushType.SMALL_GRASS, 1);

        addFlower(BushType.GERANIUM_PINK, 3);
        addFlower(BushType.GERANIUM_RED, 1);
        addFlower(BushType.GERANIUM_WHITE, 1);
        addFlower(BushType.CLOVER, 1);

        addTree(WNStructurePlacement.make(
                                WNStructureFolders.TREE_CHERRY
                        )
                        .with(1, "cherry_1")
                        .with(1, "cherry_2")
                        .with(1, "cherry_3")
                , 2);

        var configPink = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.CHERRY_PINK));
        addTree(WNStructurePlacement.make(
                                WNStructureFolders.TREE_CHERRY
                        )
                        .with(1, "cherry_1", configPink)
                        .with(1, "cherry_2", configPink)
                        .with(1, "cherry_3", configPink)
                , 2);
        var configWhite = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.CHERRY_WHITE));
        addTree(WNStructurePlacement.make(
                                WNStructureFolders.TREE_CHERRY
                        )
                        .with(1, "cherry_1", configWhite)
                        .with(1, "cherry_2", configWhite)
                        .with(1, "cherry_3", configWhite)
                , 2);

    }
}
