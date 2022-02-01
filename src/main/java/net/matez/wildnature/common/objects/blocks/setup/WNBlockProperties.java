/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.setup;

import net.matez.wildnature.common.objects.blocks.ores.BigSmallBlock;
import net.matez.wildnature.common.objects.blocks.plant.plants.TripleBlockHalf;
import net.matez.wildnature.common.objects.blocks.wood.base.BenchPart;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class WNBlockProperties {
    public static final BooleanProperty LEAVES_HYDRATED = BooleanProperty.create("hydrated");
    public static final BooleanProperty FLOWERING = BooleanProperty.create("flowering");
    public static final BooleanProperty GROWING = BooleanProperty.create("growing");
    public static final IntegerProperty CLOVER_STAGE = IntegerProperty.create("stage",0,2);
    public static final IntegerProperty ANEMONE_STAGE = IntegerProperty.create("stage",0,3);
    public static final IntegerProperty PRICKLY_PEAR_STAGE = IntegerProperty.create("stage",0,2);
    public static final IntegerProperty CHINESE_LANTERN_STAGE = IntegerProperty.create("stage",0,3);
    public static final IntegerProperty COFFEE_BUSH_STAGE = IntegerProperty.create("stage",0,2);
    public static final EnumProperty<TripleBlockHalf> TRIPLE_BLOCK_HALF = EnumProperty.create("half", TripleBlockHalf.class);
    public static final EnumProperty<BigSmallBlock> SIZE = EnumProperty.create("size", BigSmallBlock.class);
    public static final BooleanProperty BROKEN = BooleanProperty.create("broken");
    public static final IntegerProperty GRAPE_STAGE = IntegerProperty.create("stage",0,3);
    public static final BooleanProperty REFLECTS = BooleanProperty.create("reflects");
    public static final BooleanProperty CRACK = BooleanProperty.create("crack");
    public static final EnumProperty<BenchPart> BENCH_PART = EnumProperty.create("part", BenchPart.class);
    public static final BooleanProperty SINGLE = BooleanProperty.create("single");
    public static final BooleanProperty HYDROTHERMAL = BooleanProperty.create("hydrothermal");

}
