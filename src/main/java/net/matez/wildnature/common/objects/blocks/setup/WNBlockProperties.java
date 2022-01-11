package net.matez.wildnature.common.objects.blocks.setup;

import net.matez.wildnature.common.objects.blocks.plant.plants.TripleBlockHalf;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
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
    public static final EnumProperty<TripleBlockHalf> TRIPLE_BLOCK_HALF = EnumProperty.create("half", TripleBlockHalf.class);

}
