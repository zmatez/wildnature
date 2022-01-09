package net.matez.wildnature.common.objects.blocks.fruit_bush.leaves;

import net.matez.wildnature.common.objects.blocks.leaves.LeafConfig;
import net.matez.wildnature.common.registry.tabs.WNTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.material.MaterialColor;

public enum FruitBushType {
    BILBERRY("bilberry","bilberry", MaterialColor.PLANT, false, new LeafConfig(1,false)),
    BLUEBERRY("blueberry","blueberry", MaterialColor.PLANT, false, new LeafConfig(1,false)),
    CHOKEBERRY("chokeberry","chokeberry", MaterialColor.PLANT, false, new LeafConfig(1,false)),
    GOOSEBERRY("gooseberry","gooseberry", MaterialColor.PLANT, false, new LeafConfig(1,false)),
    HAWTHORN("hawthorn","hawthorn", MaterialColor.PLANT, false, new LeafConfig(2,false)),
    KAMCHATKA("kamchatka","kamchatka", MaterialColor.PLANT, false, new LeafConfig(1,false)),
    LINGONBERRY("lingonberry","lingonberry", MaterialColor.PLANT, false, new LeafConfig(1,false)),
    RASPBERRY("raspberry","raspberry", MaterialColor.PLANT, false, new LeafConfig(1,false)),

    ;
    //?------------------------------

    private final String idBase;
    private final String folder;
    private final MaterialColor color;
    private final boolean tinted;
    private final LeafConfig config;
    private CreativeModeTab tab = WNTabs.TAB_SURFACE_PLANTS;

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

    public CreativeModeTab getTab() {
        return tab;
    }
}
