/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.leaves;

import net.matez.wildnature.common.objects.items.fruits.Fruit;
import net.matez.wildnature.common.registry.items.WNItems;
import net.matez.wildnature.common.registry.tabs.WNTabs;
import net.matez.wildnature.data.block_models.WNBlockModel_BushLeaves;
import net.matez.wildnature.data.block_models.WNBlockModel_BushLeavesFlower;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
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
                .with(5,() -> WNItems.FRUITS.get(Fruit.GREEN_APPLE),1,1)
                .with(6,() -> WNItems.FRUITS.get(Fruit.GREEN_APPLE),1,1)
                .with(7,() -> WNItems.FRUITS.get(Fruit.GREEN_APPLE),1,1)
    ),
    PARADISE_APPLE("paradise_apple","apple",MaterialColor.COLOR_RED, false,
            new LeafConfig(7,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.PARADISE_APPLE),3,3)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.PARADISE_APPLE),2,2)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.PARADISE_APPLE),1,1)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.PARADISE_APPLE),1,1)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.PARADISE_APPLE),2,2)
                    .with(7,() -> WNItems.FRUITS.get(Fruit.PARADISE_APPLE),2,2)
    , false),
    ASPEN("aspen","aspen",MaterialColor.COLOR_RED, true, LeafConfig.SIMPLE.get()),
    BAOBAB("baobab","baobab",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    BEECH("beech","beech",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    PURPLE_BEECH("purple_beech","beech",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    CEDAR("cedar","cedar",MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    CHERRY("cherry","cherry", MaterialColor.PLANT, false,
            new LeafConfig(6,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.CHERRY),2,2)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.CHERRY),1,1)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.CHERRY),2,2)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.CHERRY),2,2)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.CHERRY),1,1)
    ),
    WILD_CHERRY("wild_cherry","cherry",MaterialColor.PLANT, false,
            new LeafConfig(6,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.CHERRY),1,1)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.CHERRY),3,3)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.CHERRY),2,2)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.CHERRY),1,1)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.CHERRY),2,2)
    , false),
    CHERRY_PINK("cherry_pink","cherry",MaterialColor.TERRACOTTA_WHITE, false,
            new LeafConfig(6,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.CHERRY),3,3)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.CHERRY),2,2)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.CHERRY),1,1)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.CHERRY),1,1)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.CHERRY),2,2)
    ),
    CHERRY_WHITE("cherry_white","cherry",MaterialColor.COLOR_PINK, false,
            new LeafConfig(6,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.CHERRY),3,3)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.CHERRY),2,2)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.CHERRY),1,1)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.CHERRY),1,1)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.CHERRY),2,2)
    ),
    BANANA("banana","citrus",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    LEMON("lemon","citrus",MaterialColor.PLANT, false,
            new LeafConfig(7,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.LEMON),3,3)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.LEMON),2,2)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.LEMON),3,3)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.LEMON),2,2)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.LEMON),1,1)
                    .with(7,() -> WNItems.FRUITS.get(Fruit.LEMON),1,1)
    ),
    LIME("lime","citrus",MaterialColor.PLANT, false,
            new LeafConfig(8,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.LIME),3,3)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.LIME),2,2)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.LIME),2,2)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.LIME),1,1)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.LIME),1,1)
                    .with(7,() -> WNItems.FRUITS.get(Fruit.LIME),3,3)
                    .with(8,() -> WNItems.FRUITS.get(Fruit.LIME),2,2)
    ),
    ORANGE("orange","citrus",MaterialColor.PLANT, false,
            new LeafConfig(7,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.ORANGE),3,3)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.ORANGE),2,2)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.ORANGE),1,1)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.ORANGE),1,1)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.ORANGE),2,2)
                    .with(7,() -> WNItems.FRUITS.get(Fruit.ORANGE),2,2)
    ),
    GRAPEFRUIT("grapefruit","citrus",MaterialColor.PLANT, false,
            new LeafConfig(7,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.GRAPEFRUIT),3,3)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.GRAPEFRUIT),2,2)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.GRAPEFRUIT),1,1)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.GRAPEFRUIT),1,1)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.GRAPEFRUIT),3,3)
                    .with(7,() -> WNItems.FRUITS.get(Fruit.GRAPEFRUIT),2,2)
    ),
    POMEGRANATE("pomegranate","citrus",MaterialColor.PLANT, false,
            new LeafConfig(8,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.POMEGRANATE),2,2)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.POMEGRANATE),2,2)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.POMEGRANATE),1,1)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.POMEGRANATE),1,1)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.POMEGRANATE),2,2)
                    .with(7,() -> WNItems.FRUITS.get(Fruit.POMEGRANATE),1,1)
                    .with(8,() -> WNItems.FRUITS.get(Fruit.POMEGRANATE),3,3)
    ),
    PEACH("peach","citrus",MaterialColor.PLANT, false,
            new LeafConfig(8,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.PEACH),2,2)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.PEACH),2,2)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.PEACH),1,1)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.PEACH),3,3)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.PEACH),2,2)
                    .with(7,() -> WNItems.FRUITS.get(Fruit.PEACH),3,3)
                    .with(8,() -> WNItems.FRUITS.get(Fruit.PEACH),2,2)
    ),
    MANGO("mango","citrus",MaterialColor.PLANT, false,
            new LeafConfig(8,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.MANGO),3,3)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.MANGO),2,2)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.MANGO),1,1)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.MANGO),3,3)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.MANGO),2,2)
                    .with(7,() -> WNItems.FRUITS.get(Fruit.MANGO),2,2)
                    .with(8,() -> WNItems.FRUITS.get(Fruit.MANGO),1,1)
    ),
    OLIVE("olive","citrus",MaterialColor.PLANT, false,
            new LeafConfig(8,true)
                    .with(2,() -> WNItems.FRUITS.get(Fruit.OLIVES),3,3)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.OLIVES),3,3)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.OLIVES),2,2)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.OLIVES),3,3)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.OLIVES),2,2)
                    .with(7,() -> WNItems.FRUITS.get(Fruit.OLIVES),1,1)
                    .with(8,() -> WNItems.FRUITS.get(Fruit.OLIVES),1,1)
    ),
    EBONY("ebony","ebony",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    EUCALYPTUS("eucalyptus","eucalyptus",MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    FIR("fir","fir",MaterialColor.PLANT, false,
            new LeafConfig(6,false)
    ),
    SILVER_FIR("silver_fir","fir",MaterialColor.PLANT, false,
            new LeafConfig(5, false)
    ),
    FORSYTHIA("forsythia", "forsythia", MaterialColor.COLOR_YELLOW, false, LeafConfig.SIMPLE.get().model((block) -> {
        if (block instanceof WNLeavesTypedBlock leaf) {
            return new WNBlockModel_BushLeaves(block.getRegName())
                    .with("texture", block.getTextureName("trees/" + leaf.getLeafType().getFolder()) + "_flower")
                    .with("branch", block.getTextureName("trees/" + leaf.getLeafType().getFolder()) + "_branch");
        }
        return null;
    })),
    GINKGO("ginkgo", "ginkgo", MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    HORNBEAM("hornbeam", "hornbeam", MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    HAZEL("hazel", "hazel", MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    JACARANDA("jacaranda", "jacaranda", MaterialColor.COLOR_PURPLE, false,
            new LeafConfig(3, false)
    ),
    RED_JACARANDA("red_jacaranda", "jacaranda", MaterialColor.COLOR_RED, false, LeafConfig.SIMPLE.get()),
    LARCH("larch", "larch", MaterialColor.PLANT, false,
            new LeafConfig(6, false)
    ),
    MAHOGANY("mahogany", "mahogany", MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    MANGROVE("mangrove", "mangrove", MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    MAPLE("maple", "maple", MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    MAPLE_RED("maple_red","maple",MaterialColor.COLOR_RED, false, LeafConfig.SIMPLE.get()),
    MAPLE_ORANGE("maple_orange","maple",MaterialColor.COLOR_ORANGE, false, LeafConfig.SIMPLE.get()),
    MAPLE_YELLOW("maple_yellow","maple",MaterialColor.COLOR_YELLOW, false, LeafConfig.SIMPLE.get()),
    MAPLE_BROWN("maple_brown","maple",MaterialColor.COLOR_BROWN, false, LeafConfig.SIMPLE.get()),
    MAGNOLIA("magnolia","magnolia",MaterialColor.COLOR_PINK,true,LeafConfig.SIMPLE.get().model((block) -> {
        if(block instanceof WNLeavesTypedBlock leaf) {
            return new WNBlockModel_BushLeavesFlower(block.getRegName())
                    .with("texture", block.getTextureName("trees/" + leaf.getLeafType().getFolder()))
                    .with("branch", block.getTextureName("trees/" + leaf.getLeafType().getFolder()) + "_branch")
                    .with("flower", block.getTextureName("trees/" + leaf.getLeafType().getFolder()) + "_flower");
        }
        return null;
    }).model((block) -> {
        if(block instanceof WNLeavesTypedBlock leaf) {
            return new WNBlockModel_BushLeavesFlower(block.getRegName() + "_inventory")
                    .with("texture", block.getTextureName("trees/" + leaf.getLeafType().getFolder()) + "_tinted")
                    .with("branch", block.getTextureName("trees/" + leaf.getLeafType().getFolder()) + "_branch")
                    .with("flower", block.getTextureName("trees/" + leaf.getLeafType().getFolder()) + "_flower");
        }
        return null;
    }).itemModel((block) -> new WNItemModel_BlockParent(block.getRegName()).with("parent",block.getRegName() + "_inventory"))),
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
                    .with(2,() -> WNItems.FRUITS.get(Fruit.PLUM),3,3)
                    .with(3,() -> WNItems.FRUITS.get(Fruit.PLUM),3,3)
                    .with(4,() -> WNItems.FRUITS.get(Fruit.PLUM),2,2)
                    .with(5,() -> WNItems.FRUITS.get(Fruit.PLUM),1,1)
                    .with(6,() -> WNItems.FRUITS.get(Fruit.PLUM),2,2)
    ),
    MIRABELLE_PLUM("mirabelle_plum","plum",MaterialColor.PLANT, false,
            new LeafConfig(7, true)
                    .with(2, () -> WNItems.FRUITS.get(Fruit.MIRABELLE_PLUM), 2, 2)
                    .with(3, () -> WNItems.FRUITS.get(Fruit.MIRABELLE_PLUM), 3, 3)
                    .with(4, () -> WNItems.FRUITS.get(Fruit.MIRABELLE_PLUM), 3, 3)
                    .with(5, () -> WNItems.FRUITS.get(Fruit.MIRABELLE_PLUM), 2, 2)
                    .with(6, () -> WNItems.FRUITS.get(Fruit.MIRABELLE_PLUM), 1, 1)
                    .with(7, () -> WNItems.FRUITS.get(Fruit.MIRABELLE_PLUM), 1, 1)
    ),
    POPLAR("poplar", "poplar", MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    REDWOOD("redwood", "redwood", MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
    ROWAN("rowan", "rowan", MaterialColor.PLANT, false,
            new LeafConfig(6, false)
                    .with(1, () -> WNItems.FRUITS.get(Fruit.ORANGE_ROWANBERRIES_CLUSTER), 2, 2)
                    .with(2, () -> WNItems.FRUITS.get(Fruit.RED_ROWANBERRIES_CLUSTER), 2, 2)
                    .with(3, () -> WNItems.FRUITS.get(Fruit.ORANGE_ROWANBERRIES_CLUSTER), 3, 3)
                    .with(4, () -> WNItems.FRUITS.get(Fruit.RED_ROWANBERRIES_CLUSTER), 3, 3)
                    .with(5, () -> WNItems.FRUITS.get(Fruit.ORANGE_ROWANBERRIES_CLUSTER), 1, 1)
                    .with(6, () -> WNItems.FRUITS.get(Fruit.RED_ROWANBERRIES_CLUSTER), 1, 1)
    ),
    WILLOW("willow", "willow", MaterialColor.PLANT, true, LeafConfig.SIMPLE.get()),
    GLOWING_CAVE_OAK("glowing_cave_oak", "glowing_cave_oak", MaterialColor.PLANT, false, LeafConfig.SIMPLE.get()),
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
