/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.fruit_bush.leaves;

import net.matez.wildnature.common.block.leaves.LeafConfig;
import net.matez.wildnature.common.item.fruits.Fruit;
import net.matez.wildnature.core.registry.WNItems;
import net.matez.wildnature.core.other.WNTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.material.MaterialColor;

public enum FruitBushType {
    BILBERRY("bilberry","bilberry", MaterialColor.PLANT, false, new LeafConfig(1,false)
            .with(1,() -> WNItems.FRUITS.get(Fruit.BILBERRIES),1,2)),
    BLUEBERRY("blueberry","blueberry", MaterialColor.PLANT, false, new LeafConfig(1,false)
            .with(1,() -> WNItems.FRUITS.get(Fruit.BLUEBERRIES),1,2)),
    CHOKEBERRY("chokeberry","chokeberry", MaterialColor.PLANT, false, new LeafConfig(1,false)
            .with(1,() -> WNItems.FRUITS.get(Fruit.CHOKEBERRIES),1,2)),
    GOOSEBERRY("gooseberry","gooseberry", MaterialColor.PLANT, false, new LeafConfig(1,false)
            .with(1,() -> WNItems.FRUITS.get(Fruit.GOOSEBERRIES),1,2)),
    HAWTHORN("hawthorn","hawthorn", MaterialColor.PLANT, false, new LeafConfig(2,false)
            .with(1,() -> WNItems.FRUITS.get(Fruit.HAWTHORN_BERRIES),1,2)
            .with(2,() -> WNItems.FRUITS.get(Fruit.HAWTHORN_BERRIES),1,3)),
    KAMCHATKA("kamchatka","kamchatka", MaterialColor.PLANT, false, new LeafConfig(1,false)
            .with(1,() -> WNItems.FRUITS.get(Fruit.KAMCHATKA_BERRIES),1,2)),
    LINGONBERRY("lingonberry","lingonberry", MaterialColor.PLANT, false, new LeafConfig(1,false)
            .with(1,() -> WNItems.FRUITS.get(Fruit.LINGONBERRIES),1,2)),
    RASPBERRY("raspberry","raspberry", MaterialColor.PLANT, false, new LeafConfig(1,false)
            .with(1,() -> WNItems.FRUITS.get(Fruit.RASPBERRY),1,2)),

    ;
    //?------------------------------

    private final String idBase;
    private final String folder;
    private final MaterialColor color;
    private final boolean tinted;
    private final LeafConfig config;

    FruitBushType(String idBase, String folder, MaterialColor color, boolean tinted, LeafConfig config){
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

    public LeafConfig getConfig() {
        return config;
    }

    public boolean isTinted() {
        return tinted;
    }

}
