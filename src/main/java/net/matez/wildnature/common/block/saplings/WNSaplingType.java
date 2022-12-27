/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.saplings;

import net.matez.wildnature.common.block.leaves.LeafType;
import net.matez.wildnature.common.block.plant.BushPlacement;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.structures.WNStructureFolders;
import net.matez.wildnature.common.structures.WNStructurePlacement;
import net.matez.wildnature.common.structures.configs.WNTreeConfig;
import net.matez.wildnature.core.registry.WNBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public enum WNSaplingType {
    APPLE(LeafType.APPLE, () -> WNBlocks.LOGS.get(LogType.ROSACEAE),
            new WNStructurePlacement(WNStructureFolders.TREE_APPLE)
                    .with(1, "apple_1")
                    .with(1, "apple_2")
                    .with(1, "apple_3")
            ,
            null
    ),
    ASPEN(LeafType.ASPEN, () -> Blocks.BIRCH_LOG,
            new WNStructurePlacement(WNStructureFolders.TREE_ASPEN)
                    .with(1, "aspen_1")
                    .with(1, "aspen_2")
                    .with(1, "aspen_3")
                    .with(1, "aspen_4")
                    .with(1, "aspen_5")
            ,
            null
    ),
    BAOBAB(LeafType.BAOBAB, () -> WNBlocks.LOGS.get(LogType.BAOBAB),
            new WNStructurePlacement(WNStructureFolders.TREE_BAOBAB)
                    .with(1, "baobab_1")
                    .with(1, "baobab_2")
                    .with(1, "baobab_3")
                    .with(1, "baobab_4")
                    .with(1, "baobab_5")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_BAOBAB)
                    .with(1, "giant_baobab_1")
                    .with(1, "giant_baobab_2")
                    .with(1, "giant_baobab_3")
                    .with(1, "giant_baobab_4")
                    .with(1, "giant_extra_baobab_1")
                    .with(1, "giant_extra_baobab_2")
    ),
    BEECH(LeafType.BEECH, () -> WNBlocks.LOGS.get(LogType.BEECH),
            new WNStructurePlacement(WNStructureFolders.TREE_BEECH)
                    .with(1, "beech_1")
                    .with(1, "beech_2")
                    .with(1, "beech_3")
                    .with(1, "beech_4")
                    .with(1, "beech_5")
                    .with(1, "beech_6")
                    .with(1, "beech_7")
                    .with(1, "beech_8")
                    .with(1, "beech_9")
                    .with(1, "beech_10")
                    .with(1, "beech_11")
                    .with(1, "beech_12")
                    .with(1, "weeping_beech_1")
                    .with(1, "weeping_beech_2")
                    .with(1, "weeping_beech_3")
                    .with(1, "weeping_beech_4")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_BEECH)
                    .with(1, "thick_beech_1")
                    .with(1, "thick_beech_2")
                    .with(1, "thick_beech_3")
                    .with(1, "thick_beech_4")
                    .with(1, "leafy_beech_1")
                    .with(1, "leafy_beech_3")
                    .with(1, "leafy_beech_2")
    ),
    PURPLE_BEECH(LeafType.PURPLE_BEECH, () -> WNBlocks.LOGS.get(LogType.BEECH),
            new WNStructurePlacement(WNStructureFolders.TREE_BEECH)
                    .with(1, "beech_1", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "beech_2", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "beech_3", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "beech_4", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "beech_5", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "beech_6", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "beech_7", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "beech_8", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "beech_9", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "beech_10", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "beech_11", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "beech_12", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "weeping_beech_1", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "weeping_beech_2", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "weeping_beech_3", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "weeping_beech_4", WNTreeConfig.PURPLE_BEECH)
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_BEECH)
                    .with(1, "thick_beech_1", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "thick_beech_2", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "thick_beech_3", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "thick_beech_4", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "leafy_beech_1", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "leafy_beech_3", WNTreeConfig.PURPLE_BEECH)
                    .with(1, "leafy_beech_2", WNTreeConfig.PURPLE_BEECH)
    ),
    CEDAR(LeafType.CEDAR, () -> WNBlocks.LOGS.get(LogType.CEDAR),
            new WNStructurePlacement(WNStructureFolders.TREE_CEDAR)
                    .with(1, "weeping_cedar_1")
                    .with(1, "weeping_cedar_2")
                    .with(1, "weeping_cedar_3")
                    .with(1, "weeping_cedar_4")
                    .with(1, "weeping_cedar_5")
                    .with(1, "weeping_cedar_6")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_CEDAR)
                    .with(1, "cedar_1")
                    .with(1, "cedar_2")
                    .with(1, "cedar_3")
                    .with(1, "cedar_4")
                    .with(1, "cedar_5")
                    .with(1, "cedar_6")
                    .with(1, "cedar_7")
                    .with(1, "cedar_8")
    ),
    CHERRY(LeafType.CHERRY, () -> WNBlocks.LOGS.get(LogType.CHERRY),
            new WNStructurePlacement(WNStructureFolders.TREE_CHERRY)
                    .with(1, "cherry_1")
                    .with(1, "cherry_2")
                    .with(1, "cherry_3")
                    .with(1, "cherry_4")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_CHERRY)
                    .with(1, "wild_cherry_1", WNTreeConfig.CHERRY)
                    .with(1, "wild_cherry_2", WNTreeConfig.CHERRY)
                    .with(1, "wild_cherry_3", WNTreeConfig.CHERRY)
                    .with(1, "wild_cherry_4", WNTreeConfig.CHERRY)
    ),
    CHERRY_PINK(LeafType.CHERRY_PINK, () -> WNBlocks.LOGS.get(LogType.CHERRY),
            new WNStructurePlacement(WNStructureFolders.TREE_CHERRY)
                    .with(1, "cherry_1", WNTreeConfig.CHERRY_PINK)
                    .with(1, "cherry_2", WNTreeConfig.CHERRY_PINK)
                    .with(1, "cherry_3", WNTreeConfig.CHERRY_PINK)
                    .with(1, "cherry_4", WNTreeConfig.CHERRY_PINK)
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_CHERRY)
                    .with(1, "sakura_1")
                    .with(1, "sakura_2")
                    .with(1, "sakura_3")
                    .with(1, "sakura_4")
                    .with(1, "sakura_5")
                    .with(1, "sakura_6")
                    .with(1, "sakura_7")
    ),
    CHERRY_WHITE(LeafType.CHERRY_WHITE, () -> WNBlocks.LOGS.get(LogType.CHERRY),
            new WNStructurePlacement(WNStructureFolders.TREE_CHERRY)
                    .with(1, "cherry_1", WNTreeConfig.CHERRY_WHITE)
                    .with(1, "cherry_2", WNTreeConfig.CHERRY_WHITE)
                    .with(1, "cherry_3", WNTreeConfig.CHERRY_WHITE)
                    .with(1, "cherry_4", WNTreeConfig.CHERRY_WHITE)
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_CHERRY)
                    .with(1, "sakura_1", WNTreeConfig.CHERRY_WHITE)
                    .with(1, "sakura_2", WNTreeConfig.CHERRY_WHITE)
                    .with(1, "sakura_3", WNTreeConfig.CHERRY_WHITE)
                    .with(1, "sakura_4", WNTreeConfig.CHERRY_WHITE)
                    .with(1, "sakura_5", WNTreeConfig.CHERRY_WHITE)
                    .with(1, "sakura_6", WNTreeConfig.CHERRY_WHITE)
                    .with(1, "sakura_7", WNTreeConfig.CHERRY_WHITE)
    ),
    BANANA(LeafType.BANANA, () -> WNBlocks.LOGS.get(LogType.PALM),
            new WNStructurePlacement(WNStructureFolders.TREE_CITRUS)
                    .with(1, "banana_1")
                    .with(1, "banana_2")
                    .with(1, "banana_3")
                    .with(1, "banana_4")
            ,
            null
    ),
    LEMON(LeafType.LEMON, () -> WNBlocks.LOGS.get(LogType.CITRUS),
            new WNStructurePlacement(WNStructureFolders.TREE_CITRUS)
                    .with(1, "lemon_1")
                    .with(1, "lemon_2")
                    .with(1, "lemon_3")
            ,
            null
    ),
    LIME(LeafType.LIME, () -> WNBlocks.LOGS.get(LogType.CITRUS),
            new WNStructurePlacement(WNStructureFolders.TREE_CITRUS)
                    .with(1, "lime_1")
                    .with(1, "lime_2")
                    .with(1, "lime_3")
            ,
            null
    ),
    ORANGE(LeafType.ORANGE, () -> WNBlocks.LOGS.get(LogType.CITRUS),
            new WNStructurePlacement(WNStructureFolders.TREE_CITRUS)
                    .with(1, "orange_1")
                    .with(1, "orange_2")
                    .with(1, "orange_3")
            ,
            null
    ),
    GRAPEFRUIT(LeafType.GRAPEFRUIT, () -> WNBlocks.LOGS.get(LogType.CITRUS),
            new WNStructurePlacement(WNStructureFolders.TREE_CITRUS)
                    .with(1, "grapefruit_1")
                    .with(1, "grapefruit_2")
                    .with(1, "grapefruit_3")
            ,
            null
    ),
    POMEGRANATE(LeafType.POMEGRANATE, () -> WNBlocks.LOGS.get(LogType.CITRUS),
            new WNStructurePlacement(WNStructureFolders.TREE_CITRUS)
                    .with(1, "pomegranate_1")
                    .with(1, "pomegranate_2")
                    .with(1, "pomegranate_3")
            ,
            null
    ),
    PEACH(LeafType.PEACH, () -> WNBlocks.LOGS.get(LogType.CITRUS),
            new WNStructurePlacement(WNStructureFolders.TREE_CITRUS)
                    .with(1, "peach_1")
                    .with(1, "peach_2")
                    .with(1, "peach_3")
            ,
            null
    ),
    MANGO(LeafType.MANGO, () -> WNBlocks.LOGS.get(LogType.CITRUS),
            new WNStructurePlacement(WNStructureFolders.TREE_CITRUS)
                    .with(1, "mango_1")
                    .with(1, "mango_2")
                    .with(1, "mango_3")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_CITRUS)
                    .with(1, "mango_big_1")
                    .with(1, "mango_big_2")
                    .with(1, "mango_big_3")
    ),
    OLIVE(LeafType.OLIVE, () -> WNBlocks.LOGS.get(LogType.CITRUS),
            new WNStructurePlacement(WNStructureFolders.TREE_CITRUS)
                    .with(1, "olive_1")
                    .with(1, "olive_2")
                    .with(1, "olive_3")
                    .with(1, "olive_4")
            ,
            null
    ),
    EBONY(LeafType.EBONY, () -> WNBlocks.LOGS.get(LogType.EBONY),
            new WNStructurePlacement(WNStructureFolders.TREE_EBONY)
                    .with(1, "small_ebony_1")
                    .with(1, "small_ebony_2")
                    .with(1, "small_ebony_3")
                    .with(1, "small_ebony_4")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_EBONY)
                    .with(1, "ebony_1")
                    .with(1, "ebony_2")
                    .with(1, "ebony_3")
                    .with(1, "ebony_4")
    ),
    EUCALYPTUS(LeafType.EUCALYPTUS, () -> WNBlocks.LOGS.get(LogType.EUCALYPTUS),
            new WNStructurePlacement(WNStructureFolders.TREE_EUCALYPTUS)
                    .with(1, "eucalyptus_1")
                    .with(1, "eucalyptus_2")
                    .with(1, "eucalyptus_3")
                    .with(1, "eucalyptus_4")
                    .with(1, "eucalyptus_5")
                    .with(1, "eucalyptus_6")
                    .with(1, "eucalyptus_7")
                    .with(1, "eucalyptus_8")
                    .with(1, "eucalyptus_9")
                    .with(1, "eucalyptus_10")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_EUCALYPTUS)
                    .with(1, "big_eucalyptus_1")
                    .with(1, "big_eucalyptus_2")
                    .with(1, "big_eucalyptus_3")
                    .with(1, "big_eucalyptus_4")
    ),
    //    RAINBOW_EUCALYPTUS(LeafType.EUCALYPTUS, () -> WNBlocks.LOGS.get(LogType.RAINBOW_EUCALYPTUS),
//            new WNStructurePlacement(WNStructureFolders.TREE_EUCALYPTUS)
//                    .with(1, "eucalyptus_1",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "eucalyptus_2",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "eucalyptus_3",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "eucalyptus_4",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "eucalyptus_5",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "eucalyptus_6",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "eucalyptus_7",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "eucalyptus_8",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "eucalyptus_9",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "eucalyptus_10",WNTreeConfig.RAINBOW_EUCALYPTUS)
//            ,
//            new WNStructurePlacement(WNStructureFolders.TREE_EUCALYPTUS)
//                    .with(1, "big_eucalyptus_1",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "big_eucalyptus_2",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "big_eucalyptus_3",WNTreeConfig.RAINBOW_EUCALYPTUS)
//                    .with(1, "big_eucalyptus_4",WNTreeConfig.RAINBOW_EUCALYPTUS),
//            BushPlacement.DIRT,
//            "rainbow_eucalyptus"
//    ),
    FIR(LeafType.FIR, () -> Blocks.SPRUCE_LOG,
            new WNStructurePlacement(WNStructureFolders.TREE_FIR)
                    .with(1, "")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_FIR)
                    .with(1, "")
    ),
    SILVER_FIR(LeafType.SILVER_FIR, () -> Blocks.SPRUCE_LOG,
            new WNStructurePlacement(WNStructureFolders.TREE_FIR)
                    .with(1, "")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_FIR)
                    .with(1, "")
    ),
    FORSYTHIA(LeafType.FORSYTHIA, () -> WNBlocks.LOGS.get(LogType.ROSACEAE),
            new WNStructurePlacement(WNStructureFolders.TREE_FORSYTHIA)
                    .with(1, "forsythia_1")
                    .with(1, "forsythia_2")
                    .with(1, "forsythia_3")
                    .with(1, "forsythia_4")
                    .with(1, "forsythia_5")
            ,
            null
    ),
    GINKGO(LeafType.GINKGO, () -> WNBlocks.LOGS.get(LogType.MAPLE),
            new WNStructurePlacement(WNStructureFolders.TREE_GINKGO)
                    .with(1, "ginkgo_1")
                    .with(1, "ginkgo_2")
                    .with(1, "ginkgo_3")
                    .with(1, "ginkgo_4")
            ,
            null
    ),
    HORNBEAM(LeafType.HORNBEAM, () -> Blocks.OAK_LOG,
            new WNStructurePlacement(WNStructureFolders.TREE_HORNBEAM)
                    .with(1, "tree_hornbeam_1")
                    .with(1, "tree_hornbeam_2")
                    .with(1, "tree_hornbeam_3")
                    .with(1, "tree_hornbeam_4")
                    .with(1, "tree_hornbeam_5")
                    .with(1, "tree_hornbeam_6")
                    .with(1, "tree_hornbeam_7")
            ,
            null
    ),
    HAZEL(LeafType.HAZEL, () -> Blocks.OAK_LOG,
            new WNStructurePlacement(WNStructureFolders.TREE_HAZEL)
                    .with(1, "hazel_1")
                    .with(1, "hazel_2")
                    .with(1, "hazel_3")
                    .with(1, "hazel_4")
            ,
            null
    ),
    JACARANDA(LeafType.JACARANDA, () -> WNBlocks.LOGS.get(LogType.JACARANDA),
            new WNStructurePlacement(WNStructureFolders.TREE_JACARANDA)
                    .with(1, "jacaranda_1")
                    .with(1, "jacaranda_2")
                    .with(1, "jacaranda_3")
                    .with(1, "jacaranda_4")
            ,
            null
    ),
    RED_JACARANDA(LeafType.RED_JACARANDA, () -> WNBlocks.LOGS.get(LogType.JACARANDA),
            new WNStructurePlacement(WNStructureFolders.TREE_JACARANDA)
                    .with(1, "red_jacaranda_1")
                    .with(1, "red_jacaranda_2")
                    .with(1, "red_jacaranda_3")
                    .with(1, "red_jacaranda_4")
            ,
            null
    ),
    LARCH(LeafType.LARCH, () -> WNBlocks.LOGS.get(LogType.PINE),
            new WNStructurePlacement(WNStructureFolders.TREE_LARCH)
                    .with(1, "tree_larch_1")
                    .with(1, "tree_larch_2")
                    .with(1, "tree_larch_3")
                    .with(1, "tree_larch_4")
                    .with(1, "tree_larch_5")
                    .with(1, "tree_larch_6")
                    .with(1, "tree_larch_7")
                    .with(1, "tree_larch_8")
                    .with(1, "tree_larch_9")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_LARCH)
                    .with(1, "high_larch_1")
                    .with(1, "high_larch_2")
                    .with(1, "high_larch_3")
    ),
    MAHOGANY(LeafType.MAHOGANY, () -> WNBlocks.LOGS.get(LogType.MAHOGANY),
            new WNStructurePlacement(WNStructureFolders.TREE_MAHOGANY)
                    .with(1, "mahogany_1")
                    .with(1, "mahogany_2")
                    .with(1, "mahogany_3")
                    .with(1, "mahogany_4")
            ,
            null
    ),
    MANGROVE(LeafType.MANGROVE, () -> WNBlocks.LOGS.get(LogType.MANGROVE),
            new WNStructurePlacement(WNStructureFolders.TREE_MANGROVE)
                    .with(1, "mangrove_1")
                    .with(1, "mangrove_2")
                    .with(1, "mangrove_3")
                    .with(1, "mangrove_4")
                    .with(1, "mangrove_5")
            ,
            null
    ),
    //todo small maples
    MAPLE(LeafType.MAPLE, () -> WNBlocks.LOGS.get(LogType.MAPLE),
            new WNStructurePlacement(WNStructureFolders.TREE_MAPLE)
                    .with(1, "maple_1")
                    .with(1, "maple_2")
                    .with(1, "maple_3")
                    .with(1, "maple_4")
            ,
            null
    ),
    MAPLE_RED(LeafType.MAPLE_RED, () -> WNBlocks.LOGS.get(LogType.MAPLE),
            new WNStructurePlacement(WNStructureFolders.TREE_MAPLE)
                    .with(1, "maple_1", WNTreeConfig.MAPLE_RED)
                    .with(1, "maple_2", WNTreeConfig.MAPLE_RED)
                    .with(1, "maple_3", WNTreeConfig.MAPLE_RED)
                    .with(1, "maple_4", WNTreeConfig.MAPLE_RED)
            ,
            null
    ),
    MAPLE_ORANGE(LeafType.MAPLE_ORANGE, () -> WNBlocks.LOGS.get(LogType.MAPLE),
            new WNStructurePlacement(WNStructureFolders.TREE_MAPLE)
                    .with(1, "maple_1", WNTreeConfig.MAPLE_ORANGE)
                    .with(1, "maple_2", WNTreeConfig.MAPLE_ORANGE)
                    .with(1, "maple_3", WNTreeConfig.MAPLE_ORANGE)
                    .with(1, "maple_4", WNTreeConfig.MAPLE_ORANGE)
            ,
            null
    ),
    MAPLE_YELLOW(LeafType.MAPLE_YELLOW, () -> WNBlocks.LOGS.get(LogType.MAPLE),
            new WNStructurePlacement(WNStructureFolders.TREE_MAPLE)
                    .with(1, "maple_1", WNTreeConfig.MAPLE_YELLOW)
                    .with(1, "maple_2", WNTreeConfig.MAPLE_YELLOW)
                    .with(1, "maple_3", WNTreeConfig.MAPLE_YELLOW)
                    .with(1, "maple_4", WNTreeConfig.MAPLE_YELLOW)
            ,
            null
    ),
    MAPLE_BROWN(LeafType.MAPLE_BROWN, () -> WNBlocks.LOGS.get(LogType.MAPLE),
            new WNStructurePlacement(WNStructureFolders.TREE_MAPLE)
                    .with(1, "maple_1", WNTreeConfig.MAPLE_BROWN)
                    .with(1, "maple_2", WNTreeConfig.MAPLE_BROWN)
                    .with(1, "maple_3", WNTreeConfig.MAPLE_BROWN)
                    .with(1, "maple_4", WNTreeConfig.MAPLE_BROWN)
            ,
            null
    ),
    MAGNOLIA(LeafType.MAGNOLIA, () -> WNBlocks.LOGS.get(LogType.ROSACEAE),
            new WNStructurePlacement(WNStructureFolders.TREE_MAGNOLIA)
                    .with(1, "magnolia_1")
                    .with(1, "magnolia_2")
                    .with(1, "magnolia_3")
                    .with(1, "magnolia_4")
                    .with(1, "magnolia_5")
            ,
            null
    ),
    METASEQUOIA_GREEN(LeafType.METASEQUOIA_GREEN, () -> WNBlocks.LOGS.get(LogType.REDWOOD),
            new WNStructurePlacement(WNStructureFolders.TREE_SEQUOIA)
                    .with(1, "sequoia_1", WNTreeConfig.METASEQUOIA_GREEN)
                    .with(1, "sequoia_2", WNTreeConfig.METASEQUOIA_GREEN)
                    .with(1, "sequoia_3", WNTreeConfig.METASEQUOIA_GREEN)
                    .with(1, "sequoia_4", WNTreeConfig.METASEQUOIA_GREEN)
                    .with(1, "sequoia_5", WNTreeConfig.METASEQUOIA_GREEN)
                    .with(1, "sequoia_6", WNTreeConfig.METASEQUOIA_GREEN)
            ,
            null
    ),
    METASEQUOIA_RED(LeafType.METASEQUOIA_RED, () -> WNBlocks.LOGS.get(LogType.REDWOOD),
            new WNStructurePlacement(WNStructureFolders.TREE_SEQUOIA)
                    .with(1, "sequoia_1", WNTreeConfig.METASEQUOIA_RED)
                    .with(1, "sequoia_2", WNTreeConfig.METASEQUOIA_RED)
                    .with(1, "sequoia_3", WNTreeConfig.METASEQUOIA_RED)
                    .with(1, "sequoia_4", WNTreeConfig.METASEQUOIA_RED)
                    .with(1, "sequoia_5", WNTreeConfig.METASEQUOIA_RED)
                    .with(1, "sequoia_6", WNTreeConfig.METASEQUOIA_RED)
            ,
            null
    ),
    METASEQUOIA_ORANGE(LeafType.METASEQUOIA_ORANGE, () -> WNBlocks.LOGS.get(LogType.REDWOOD),
            new WNStructurePlacement(WNStructureFolders.TREE_SEQUOIA)
                    .with(1, "sequoia_1", WNTreeConfig.METASEQUOIA_ORANGE)
                    .with(1, "sequoia_2", WNTreeConfig.METASEQUOIA_ORANGE)
                    .with(1, "sequoia_3", WNTreeConfig.METASEQUOIA_ORANGE)
                    .with(1, "sequoia_4", WNTreeConfig.METASEQUOIA_ORANGE)
                    .with(1, "sequoia_5", WNTreeConfig.METASEQUOIA_ORANGE)
                    .with(1, "sequoia_6", WNTreeConfig.METASEQUOIA_ORANGE)
            ,
            null
    ),
    METASEQUOIA_YELLOW(LeafType.METASEQUOIA_YELLOW, () -> WNBlocks.LOGS.get(LogType.REDWOOD),
            new WNStructurePlacement(WNStructureFolders.TREE_SEQUOIA)
                    .with(1, "sequoia_1", WNTreeConfig.METASEQUOIA_YELLOW)
                    .with(1, "sequoia_2", WNTreeConfig.METASEQUOIA_YELLOW)
                    .with(1, "sequoia_3", WNTreeConfig.METASEQUOIA_YELLOW)
                    .with(1, "sequoia_4", WNTreeConfig.METASEQUOIA_YELLOW)
                    .with(1, "sequoia_5", WNTreeConfig.METASEQUOIA_YELLOW)
                    .with(1, "sequoia_6", WNTreeConfig.METASEQUOIA_YELLOW)
            ,
            null
    ),
    METASEQUOIA_BROWN(LeafType.METASEQUOIA_BROWN, () -> WNBlocks.LOGS.get(LogType.REDWOOD),
            new WNStructurePlacement(WNStructureFolders.TREE_SEQUOIA)
                    .with(1, "sequoia_1", WNTreeConfig.METASEQUOIA_BROWN)
                    .with(1, "sequoia_2", WNTreeConfig.METASEQUOIA_BROWN)
                    .with(1, "sequoia_3", WNTreeConfig.METASEQUOIA_BROWN)
                    .with(1, "sequoia_4", WNTreeConfig.METASEQUOIA_BROWN)
                    .with(1, "sequoia_5", WNTreeConfig.METASEQUOIA_BROWN)
                    .with(1, "sequoia_6", WNTreeConfig.METASEQUOIA_BROWN)
            ,
            null
    ),
    NUYTSIA(LeafType.NUYTSIA, () -> WNBlocks.LOGS.get(LogType.ROSACEAE),
            new WNStructurePlacement(WNStructureFolders.TREE_NUYTSIA)
                    .with(1, "nuytsia_1")
                    .with(1, "nuytsia_2")
                    .with(1, "nuytsia_3")
                    .with(1, "nuytsia_4")
                    .with(1, "nuytsia_5")
                    .with(1, "nuytsia_6")
            ,
            null,
            BushPlacement.DIRT_OR_SAND
    ),
    PALM(LeafType.PALM, () -> WNBlocks.LOGS.get(LogType.PALM),
            new WNStructurePlacement(WNStructureFolders.TREE_PALM)
                    .with(1, "tree_palm_1")
                    .with(1, "tree_palm_2")
                    .with(1, "tree_palm_3")
                    .with(1, "tree_palm_4")
                    .with(1, "tree_palm_5")
                    .with(1, "tree_palm_6")
                    .with(1, "tree_palm_7")
                    .with(1, "tree_palm_8")
                    .with(1, "tree_palm_9")
                    .with(1, "tree_palm_10")
                    .with(1, "tree_palm_11")
                    .with(1, "tree_palm_12")
                    .with(1, "tree_palm_13")
                    .with(1, "tree_palm_14")
                    .with(1, "tree_palm_15")
                    .with(1, "tree_palm_16")
                    .with(1, "tree_palm_17")
            ,
            null,
            BushPlacement.DIRT_OR_SAND
    ),
    PEAR(LeafType.PEAR, () -> WNBlocks.LOGS.get(LogType.ROSACEAE),
            new WNStructurePlacement(WNStructureFolders.TREE_PEAR)
                    .with(1, "pear1")
                    .with(1, "pear2")
                    .with(1, "pear3")
            ,
            null
    ),
    PINE(LeafType.PINE, () -> WNBlocks.LOGS.get(LogType.PINE),
            new WNStructurePlacement(WNStructureFolders.TREE)
                    .with(1, "pine/thin_pine_1")
                    .with(1, "pine/thin_pine_2")
                    .with(1, "pine/thin_pine_3")
                    .with(1, "pine/thin_pine_4")
                    .with(1, "pine/tree_pine_1")
                    .with(1, "pine/tree_pine_2")
                    .with(1, "pine/tree_pine_3")
                    .with(1, "pine/tree_pine_4")
                    .with(1, "pine/tree_pine_5")
                    .with(1, "pine/tree_pine_6")
                    .with(1, "boreal/boreal_pine_1")
                    .with(1, "boreal/boreal_pine_2")
                    .with(1, "boreal/boreal_pine_3")
                    .with(1, "boreal/boreal_pine_4")
                    .with(1, "boreal/boreal_pine_5")
                    .with(1, "boreal/boreal_pine_6")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_PINE)
                    .with(1, "tall_pine_1")
                    .with(1, "tall_pine_2")
                    .with(1, "tall_pine_3")
                    .with(1, "tall_pine_4")
    ),
    PLUM(LeafType.PLUM, () -> WNBlocks.LOGS.get(LogType.PLUM),
            new WNStructurePlacement(WNStructureFolders.TREE_PLUM)
                    .with(1, "")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_PLUM)
                    .with(1, "")
    ),
    MIRABELLE_PLUM(LeafType.MIRABELLE_PLUM, () -> WNBlocks.LOGS.get(LogType.PLUM),
            new WNStructurePlacement(WNStructureFolders.TREE_PLUM)
                    .with(1, "")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_PLUM)
                    .with(1, "")
    ),
    POPLAR(LeafType.POPLAR, () -> Blocks.OAK_LOG,
            new WNStructurePlacement(WNStructureFolders.TREE_POPLAR)
                    .with(1, "")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_POPLAR)
                    .with(1, "")
    ),
    REDWOOD(LeafType.REDWOOD, () -> WNBlocks.LOGS.get(LogType.REDWOOD),
            new WNStructurePlacement(WNStructureFolders.TREE_REDWOOD)
                    .with(1, "small_redwood_1")
                    .with(1, "small_redwood_2")
                    .with(1, "small_redwood_3")
                    .with(1, "small_redwood_4")
                    .with(1, "small_redwood_5")
                    .with(1, "small_redwood_6")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_REDWOOD)
                    .with(1, "tree_redwood_1")
                    .with(1, "tree_redwood_2")
                    .with(1, "tree_redwood_3")
                    .with(1, "tree_redwood_4")
    ),
    ROWAN(LeafType.ROWAN, () -> Blocks.OAK_LOG,
            new WNStructurePlacement(WNStructureFolders.TREE_ROWAN)
                    .with(1, "rowan_1")
                    .with(1, "rowan_2")
                    .with(1, "rowan_3")
                    .with(1, "rowan_4")
            ,
            null
    ),
    WILLOW(LeafType.WILLOW, () -> WNBlocks.LOGS.get(LogType.WILLOW),
            new WNStructurePlacement(WNStructureFolders.TREE_WILLOW)
                    .with(1, "pointy_willow_1")
                    .with(1, "pointy_willow_2")
                    .with(1, "pointy_willow_3")
                    .with(1, "pointy_willow_4")
                    .with(1, "small_willow_1")
                    .with(1, "small_willow_2")
                    .with(1, "small_willow_3")
                    .with(1, "small_willow_4")
            ,
            new WNStructurePlacement(WNStructureFolders.TREE_WILLOW)
                    .with(1, "tree_willow_1")
                    .with(1, "tree_willow_2")
                    .with(1, "tree_willow_3")
                    .with(1, "tree_willow_4")
                    .with(1, "tree_willow_5")
                    .with(1, "tree_willow_6")
                    .with(1, "tree_willow_7")
                    .with(1, "tree_willow_8")
                    .with(1, "tree_willow_9")
                    .with(1, "tree_willow_10")
                    .with(1, "tree_willow_11")
                    .with(1, "tree_willow_12")
                    .with(1, "tree_willow_13")
                    .with(1, "tree_willow_14")
                    .with(1, "tree_willow_15")
                    .with(1, "tree_willow_16")
                    .with(1, "tree_willow_17")
                    .with(1, "tree_willow_18")
                    .with(1, "tree_willow_19")
                    .with(1, "tree_willow_20")
                    .with(1, "tree_willow_21")
    );
    private final LeafType leafType;
    private final Supplier<Block> logType;
    private final WNStructurePlacement placement;
    private final WNStructurePlacement bigPlacement;
    private BushPlacement bushPlacement = BushPlacement.DIRT;
    private String id;

    WNSaplingType(LeafType leafType, Supplier<Block> logType, WNStructurePlacement placement, WNStructurePlacement bigPlacement) {
        this.leafType = leafType;
        this.logType = logType;
        this.placement = placement;
        this.bigPlacement = bigPlacement;
    }

    WNSaplingType(LeafType leafType, Supplier<Block> logType, WNStructurePlacement placement, WNStructurePlacement bigPlacement, BushPlacement bushPlacement) {
        this(leafType, logType, placement, bigPlacement);
        this.bushPlacement = bushPlacement;
    }

    WNSaplingType(LeafType leafType, Supplier<Block> logType, WNStructurePlacement placement, WNStructurePlacement bigPlacement, BushPlacement bushPlacement, String id) {
        this(leafType, logType, placement, bigPlacement, bushPlacement);
        this.id = id;
    }

    public LeafType getLeafType() {
        return leafType;
    }

    public WNStructurePlacement getPlacement() {
        return placement;
    }

    public WNStructurePlacement getBigPlacement() {
        return bigPlacement;
    }

    public String getIdBase() {
        if (id != null) {
            return id;
        }
        return leafType.getIdBase();
    }

    public String getFolder() {
        return leafType.getFolder();
    }

    public BushPlacement getBushPlacement() {
        return bushPlacement;
    }

    public Supplier<Block> getLogType() {
        return logType;
    }
}
