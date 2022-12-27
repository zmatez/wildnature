/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.fruit_bush.plants;

import net.matez.wildnature.common.block.leaves.LeafConfig;
import net.matez.wildnature.common.item.fruits.Fruit;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.core.registry.WNItems;
import net.matez.wildnature.core.other.WNTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.material.MaterialColor;

public enum FruitPlantType {
    BELLADONNA("belladonna","belladonna", MaterialColor.PLANT, true, new FruitBushConfig(4)
            .with(0, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(1, new FruitBushConfig.StageConfig())
            .with(2, new FruitBushConfig.StageConfig())
            .with(3, new FruitBushConfig.StageConfig(new LeafConfig.ItemConfig(1,3,() -> WNItems.FRUITS.get(Fruit.BELLADONNA))))
            .withConstructor((type,blockProp,itemProp) -> new WNBelladonnaFruitPlantBlock(WNBlocks.location("belladonna"),blockProp,itemProp,type))
    ),
    BLACK_LILAC("black_lilac","black_lilac", MaterialColor.PLANT, true, new FruitBushConfig(5)
        .with(0, new FruitBushConfig.StageConfig())
        .with(1, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
        .with(2, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
        .with(3, new FruitBushConfig.StageConfig(null,"_stage_3","_stage_3_overlay"))
        .with(4, new FruitBushConfig.StageConfig(new LeafConfig.ItemConfig(1,2,() -> WNItems.FRUITS.get(Fruit.ELDERBERRIES)),"_stage_3","_stage_4_overlay"))
    ),
    BLACKBERRY("blackberry","blackberry", MaterialColor.PLANT, true, new FruitBushConfig(5)
            .with(0, new FruitBushConfig.StageConfig())
            .with(1, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(2, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(3, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(4, new FruitBushConfig.StageConfig(new LeafConfig.ItemConfig(1,2,() -> WNItems.FRUITS.get(Fruit.BLACKBERRIES)),"_stage_4","_stage_4_overlay"))
    ),
    RED_CURRANT("currant_red","currant", MaterialColor.PLANT, true, new FruitBushConfig(5)
            .with(0, new FruitBushConfig.StageConfig(null,"currant_bush_stage_1","currant_bush_stalk_stage_1").makePathIndependent())
            .with(1, new FruitBushConfig.StageConfig(null,"currant_bush_stage_2","currant_bush_stalk_stage_2").makePathIndependent().makeAfterFruitCollect())
            .with(2, new FruitBushConfig.StageConfig(null,"currant_bush_stage_3","currant_bush_stalk_stage_3").makePathIndependent().makeAfterFruitCollect())
            .with(3, new FruitBushConfig.StageConfig(null,"currant_bush_stage_4","currant_bush_stalk_stage_4").makePathIndependent().makeAfterFruitCollect())
            .with(4, new FruitBushConfig.StageConfig(new LeafConfig.ItemConfig(1,2,() -> WNItems.FRUITS.get(Fruit.RED_CURRANT)),"currant_bush_stage_4","currant_bush_stalk_stage_5_red").makePathIndependent().makeAfterFruitCollect())
    ),
    BLACK_CURRANT("currant_black","currant", MaterialColor.PLANT, true, new FruitBushConfig(5)
            .with(0, new FruitBushConfig.StageConfig(null,"currant_bush_stage_1","currant_bush_stalk_stage_1").makePathIndependent())
            .with(1, new FruitBushConfig.StageConfig(null,"currant_bush_stage_2","currant_bush_stalk_stage_2").makePathIndependent().makeAfterFruitCollect())
            .with(2, new FruitBushConfig.StageConfig(null,"currant_bush_stage_3","currant_bush_stalk_stage_3").makePathIndependent().makeAfterFruitCollect())
            .with(3, new FruitBushConfig.StageConfig(null,"currant_bush_stage_4","currant_bush_stalk_stage_4").makePathIndependent().makeAfterFruitCollect())
            .with(4, new FruitBushConfig.StageConfig((new LeafConfig.ItemConfig(1,2,() -> WNItems.FRUITS.get(Fruit.BLACK_CURRANT))),"currant_bush_stage_4","currant_bush_stalk_stage_5_black").makePathIndependent().makeAfterFruitCollect())
    ),
    WHITE_CURRANT("currant_white","currant", MaterialColor.PLANT, true, new FruitBushConfig(5)
            .with(0, new FruitBushConfig.StageConfig(null,"currant_bush_stage_1","currant_bush_stalk_stage_1").makePathIndependent())
            .with(1, new FruitBushConfig.StageConfig(null,"currant_bush_stage_2","currant_bush_stalk_stage_2").makePathIndependent().makeAfterFruitCollect())
            .with(2, new FruitBushConfig.StageConfig(null,"currant_bush_stage_3","currant_bush_stalk_stage_3").makePathIndependent().makeAfterFruitCollect())
            .with(3, new FruitBushConfig.StageConfig(null,"currant_bush_stage_4","currant_bush_stalk_stage_4").makePathIndependent().makeAfterFruitCollect())
            .with(4, new FruitBushConfig.StageConfig((new LeafConfig.ItemConfig(1,2,() -> WNItems.FRUITS.get(Fruit.WHITE_CURRANT))),"currant_bush_stage_4","currant_bush_stalk_stage_5_white").makePathIndependent().makeAfterFruitCollect())
    ),
    COFFEE("coffee","coffee", MaterialColor.PLANT, true, (FruitBushConfig) new FruitBushConfig(4)
            .with(0, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(1, new FruitBushConfig.StageConfig())
            .with(2, new FruitBushConfig.StageConfig())
            .with(3, new FruitBushConfig.StageConfig((new LeafConfig.ItemConfig(1,3,() -> WNItems.FRUITS.get(Fruit.COFFEEBERRY)))))
            .withConstructor((type,blockProp,itemProp) -> new WNCoffeeBushBlock(WNBlocks.location("coffee"),blockProp,itemProp,type))
            .notTinted()
    ),
    CRANBERRY("cranberry","cranberry", MaterialColor.PLANT, true, new FruitBushConfig(5)
            .with(0, new FruitBushConfig.StageConfig())
            .with(1, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(2, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(3, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(4, new FruitBushConfig.StageConfig((new LeafConfig.ItemConfig(1,2,() -> WNItems.FRUITS.get(Fruit.CRANBERRIES))),"_stage_4","_stage_4_overlay"))
    ),
    QUINCE("quince","quince", MaterialColor.PLANT, true, new FruitBushConfig(6)
            .with(0, new FruitBushConfig.StageConfig())
            .with(1, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(2, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(3, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(4, new FruitBushConfig.StageConfig(null,"_stage_4","_stage_5_overlay"))
            .with(5, new FruitBushConfig.StageConfig((new LeafConfig.ItemConfig(1,2,() -> WNItems.FRUITS.get(Fruit.QUINCE_FRUIT))),"_stage_4","_stage_6_overlay"))
    ),
    WILD_BLUEBERRY("wild_blueberry","wild_blueberry", MaterialColor.PLANT, false, new FruitBushConfig(6)
            .with(0, new FruitBushConfig.StageConfig())
            .with(1, new FruitBushConfig.StageConfig())
            .with(2, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(3, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(4, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(5, new FruitBushConfig.StageConfig((new LeafConfig.ItemConfig(1,2,() -> WNItems.FRUITS.get(Fruit.BILBERRIES))),"_stage_5","_stage_6_overlay"))
    ),
    WILD_STRAWBERRY("wild_strawberry","wild_strawberry", MaterialColor.PLANT, true, new FruitBushConfig(6)
            .with(0, new FruitBushConfig.StageConfig())
            .with(1, new FruitBushConfig.StageConfig())
            .with(2, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(3, new FruitBushConfig.StageConfig().makeAfterFruitCollect())
            .with(4, new FruitBushConfig.StageConfig(null,"_stage_4","_stage_5_overlay"))
            .with(5, new FruitBushConfig.StageConfig((new LeafConfig.ItemConfig(1,2,() -> WNItems.FRUITS.get(Fruit.STRAWBERRY))),"_stage_4","_stage_6_overlay"))
    ),
    WILD_ROSE("wild_rose","wild_rose", MaterialColor.PLANT, true, new FruitBushConfig(4)
            .with(0, new FruitBushConfig.StageConfig(null,"_stalk").makeAfterFruitCollect())
            .with(1, new FruitBushConfig.StageConfig(null, "_stalk", "_stage_1"))
            .with(2, new FruitBushConfig.StageConfig(null, "_stalk", "_stage_2"))
            .with(3, new FruitBushConfig.StageConfig(new LeafConfig.ItemConfig(1,2,() -> WNItems.FRUITS.get(Fruit.WILD_ROSE)), "_stalk", "_stage_3"))
            .withConstructor((type, blockProp, itemProp) -> new WNWildRoseFruitPlantBlock(WNBlocks.location("wild_rose"),blockProp,itemProp,type))
    ),

    ;
    //?------------------------------

    private final String idBase;
    private final String folder;
    private final MaterialColor color;
    private final boolean tinted;
    private final FruitBushConfig config;
    private CreativeModeTab tab = WNTabs.TAB_SURFACE_PLANTS;

    FruitPlantType(String idBase, String folder, MaterialColor color, boolean tinted, FruitBushConfig config){
        this.idBase = idBase;
        this.folder = folder;
        this.color = color;
        this.tinted = tinted;
        this.config = config;
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

    public FruitBushConfig getConfig() {
        return config;
    }

    public boolean isTinted() {
        return tinted;
    }

    public CreativeModeTab getTab() {
        return tab;
    }
}
