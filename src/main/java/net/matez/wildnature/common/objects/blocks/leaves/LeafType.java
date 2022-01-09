package net.matez.wildnature.common.objects.blocks.leaves;

import net.matez.wildnature.common.registry.tabs.WNTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public enum LeafType {
    APPLE("apple","apple",MaterialColor.PLANT, false,
            new LeafConfig(7,true)
                .with(2,() -> Items.APPLE,1,1)
                .with(3,() -> Items.APPLE,1,1)
                .with(4,() -> Items.APPLE,1,1)
                .with(5,() -> Items.APPLE,1,1)
                .with(6,() -> Items.APPLE,1,1)
                .with(7,() -> Items.APPLE,1,1)
    ),
    PARADISE_APPLE("paradise_apple","apple",MaterialColor.COLOR_RED, false,
            new LeafConfig(7,true)
    , false),
    ASPEN("aspen","aspen",MaterialColor.COLOR_RED, true, LeafConfig.SIMPLE.get()),
    BAOBAB("baobab","baobab",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    BEECH("beech","beech",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    PURPLE_BEECH("purple_beech","beech",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    CEDAR("cedar","cedar",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    CHERRY("cherry","cherry", MaterialColor.PLANT, false,
            new LeafConfig(6,true)
    ),
    WILD_CHERRY("wild_cherry","cherry",MaterialColor.PLANT, false,
            new LeafConfig(6,true)
    , false),
    CHERRY_PINK("cherry_pink","cherry",MaterialColor.TERRACOTTA_WHITE, false,
            new LeafConfig(6,true)
    ),
    CHERRY_WHITE("cherry_white","cherry",MaterialColor.COLOR_PINK, false,
            new LeafConfig(6,true)
    ),
    BANANA("banana","citrus",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    LEMON("lemon","citrus",MaterialColor.PLANT, false,
            new LeafConfig(7,true)
    ),
    LIME("lime","citrus",MaterialColor.PLANT, false,
            new LeafConfig(8,true)
    ),
    ORANGE("orange","citrus",MaterialColor.PLANT, false,
            new LeafConfig(7,true)
    ),
    GRAPEFRUIT("grapefruit","citrus",MaterialColor.PLANT, false,
            new LeafConfig(7,true)
    ),
    POMEGRANATE("pomegranate","citrus",MaterialColor.PLANT, false,
            new LeafConfig(8,true)
    ),
    PEACH("peach","citrus",MaterialColor.PLANT, false,
            new LeafConfig(8,true)
    ),
    MANGO("mango","citrus",MaterialColor.PLANT, false,
            new LeafConfig(8,true)
    ),
    OLIVE("olive","citrus",MaterialColor.PLANT, false,
            new LeafConfig(8,true)
    ),
    EBONY("ebony","ebony",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    EUCALYPTUS("eucalyptus","eucalyptus",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    FIR("fir","fir",MaterialColor.PLANT, false,
            new LeafConfig(6,false)
    ),
    SILVER_FIR("silver_fir","fir",MaterialColor.PLANT, false,
            new LeafConfig(5,false)
    ),
    GINGKO("gingko","gingko",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    HORNBEAM("hornbeam","hornbeam",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    JACARANDA("jacaranda","jacaranda",MaterialColor.COLOR_PURPLE, false,
            new LeafConfig(3,false)
    ),
    RED_JACARANDA("red_jacaranda","jacaranda",MaterialColor.COLOR_RED, false, LeafConfig.SIMPLE.get()),
    LARCH("larch","larch",MaterialColor.PLANT, false,
            new LeafConfig(6,false)
    ),
    MAHOGANY("mahogany","mahogany",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    MANGROVE("mangrove","mangrove",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    MAPLE("maple","maple",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    MAPLE_RED("maple_red","maple",MaterialColor.COLOR_RED, false, LeafConfig.SIMPLE.get()),
    MAPLE_ORANGE("maple_orange","maple",MaterialColor.COLOR_ORANGE, false, LeafConfig.SIMPLE.get()),
    MAPLE_YELLOW("maple_yellow","maple",MaterialColor.COLOR_YELLOW, false, LeafConfig.SIMPLE.get()),
    MAPLE_BROWN("maple_brown","maple",MaterialColor.COLOR_BROWN, false, LeafConfig.SIMPLE.get()),
    METASEQUOIA_GREEN("metasequoia_green","metasequoia",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    METASEQUOIA_RED("metasequoia_red","metasequoia",MaterialColor.COLOR_RED, false, LeafConfig.SIMPLE.get()),
    METASEQUOIA_ORANGE("metasequoia_orange","metasequoia",MaterialColor.COLOR_ORANGE, false, LeafConfig.SIMPLE.get()),
    METASEQUOIA_YELLOW("metasequoia_yellow","metasequoia",MaterialColor.COLOR_YELLOW, false, LeafConfig.SIMPLE.get()),
    METASEQUOIA_BROWN("metasequoia_brown","metasequoia",MaterialColor.COLOR_BROWN, false, LeafConfig.SIMPLE.get()),
    NUYTSIA("nuytsia","nuytsia",MaterialColor.COLOR_ORANGE, false, LeafConfig.SIMPLE.get()),
    PALM("palm","palm",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    PEAR("pear","pear",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    PINE("pine","pine",MaterialColor.PLANT, false,
            new LeafConfig(3,false)
    ),
    PLUM("plum","plum",MaterialColor.PLANT, false,
            new LeafConfig(6,true)
    ),
    MIRABELLE_PLUM("mirabelle_plum","plum",MaterialColor.PLANT, false,
            new LeafConfig(7,true)
    ),
    POPLAR("poplar","poplar",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    REDWOOD("redwood","redwood",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    WILLOW("willow","willow",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    GLOWING_CAVE_OAK("glowing_cave_oak","glowing_cave_oak",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    ;
    //?------------------------------

    private final String idBase;
    private final String folder;
    private final MaterialColor color;
    private final boolean tinted;
    private final LeafConfig config;
    @Nullable
    private final Supplier<Item> sapling; //if null, get from the WNBlocks.SAPLINGS list
    private final boolean hasSapling;
    private CreativeModeTab tab = WNTabs.TAB_SURFACE_PLANTS;

    LeafType(String idBase, String folder, MaterialColor color, boolean tinted, LeafConfig config){
        this.idBase = idBase;
        this.folder = folder;
        this.color = color;
        this.tinted = tinted;
        this.sapling = null;
        this.config = config;
        this.hasSapling = true;
    }
    LeafType(String idBase, String folder, MaterialColor color, boolean tinted, LeafConfig config, boolean hasSapling){
        this.idBase = idBase;
        this.folder = folder;
        this.color = color;
        this.tinted = tinted;
        this.sapling = null;
        this.config = config;
        this.hasSapling = hasSapling;
    }
    LeafType(String idBase, String folder, MaterialColor color, CreativeModeTab tab, boolean tinted, LeafConfig config, boolean hasSapling){
        this.idBase = idBase;
        this.folder = folder;
        this.color = color;
        this.tab = tab;
        this.tinted = tinted;
        this.sapling = null;
        this.config = config;
        this.hasSapling = hasSapling;
    }
    LeafType(String idBase, String folder, MaterialColor color, Supplier<Item> sapling, boolean tinted, LeafConfig config){
        this.idBase = idBase;
        this.folder = folder;
        this.color = color;
        this.tinted = tinted;
        this.sapling = sapling;
        this.config = config;
        this.hasSapling = true;
    }

    public String getIdBase() {
        return idBase;
    }

    public String getFolder() {
        return folder;
    }

    public MaterialColor getColor() {
        return color;
    }

    public LeafConfig getConfig() {
        return config;
    }

    @Nullable
    public Supplier<Item> getSapling() {
        return sapling;
    }

    public boolean isHasSapling() {
        return hasSapling;
    }

    public boolean isTinted() {
        return tinted;
    }

    public CreativeModeTab getTab() {
        return tab;
    }
}
