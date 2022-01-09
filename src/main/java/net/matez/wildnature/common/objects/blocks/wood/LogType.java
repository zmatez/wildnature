package net.matez.wildnature.common.objects.blocks.wood;

import net.matez.wildnature.common.registry.tabs.WNTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nullable;

public enum LogType {
    ROSACEAE("rosaceae",MaterialColor.COLOR_ORANGE),
    BAOBAB("baobab",MaterialColor.TERRACOTTA_PURPLE),
    BEECH("beech",MaterialColor.COLOR_YELLOW),
    CEDAR("cedar",MaterialColor.COLOR_ORANGE),
    CHERRY("cherry",MaterialColor.COLOR_RED),
    CITRUS("citrus",MaterialColor.COLOR_YELLOW),
    EBONY("ebony",MaterialColor.COLOR_BLACK),
    EUCALYPTUS("eucalyptus",MaterialColor.TERRACOTTA_ORANGE),
    RAINBOW_EUCALYPTUS("rainbow_eucalyptus",MaterialColor.TERRACOTTA_ORANGE, EUCALYPTUS),
    JACARANDA("jacaranda",MaterialColor.TERRACOTTA_BROWN),
    MAHOGANY("mahogany",MaterialColor.TERRACOTTA_BROWN),
    MANGROVE("mangrove",MaterialColor.TERRACOTTA_WHITE),
    MAPLE("maple",MaterialColor.TERRACOTTA_WHITE),
    PALM("palm",MaterialColor.TERRACOTTA_BROWN),
    PINE("pine",MaterialColor.COLOR_ORANGE),
    PLUM("plum",MaterialColor.COLOR_PURPLE),
    REDWOOD("redwood",MaterialColor.TERRACOTTA_RED),
    WILLOW("willow",MaterialColor.TERRACOTTA_GREEN),
    GLOWING_CAVE_OAK("glowing_cave_oak",MaterialColor.WARPED_WART_BLOCK, WNTabs.TAB_CAVES)
    ;
    //?------------------------------

    private final String idBase;
    @Nullable
    private LogType parent = null;
    private final MaterialColor color;
    private CreativeModeTab tab = WNTabs.TAB_SURFACE;

    LogType(String idBase, MaterialColor color){
        this.idBase = idBase;
        this.color = color;
    }

    LogType(String idBase, MaterialColor color, CreativeModeTab tab){
        this.idBase = idBase;
        this.color = color;
        this.tab = tab;
    }

    LogType(String idBase, MaterialColor color, LogType parent){
        this(idBase,color);
        this.parent = parent;
    }

    public String getIdBase() {
        return idBase;
    }

    public String getBaseOrParent(){
        if(this.parent == null){
            return this.getIdBase();
        }
        return this.parent.getIdBase();
    }

    @Nullable
    public LogType getParent() {
        return parent;
    }

    public MaterialColor getColor() {
        return color;
    }

    public CreativeModeTab getTab() {
        return tab;
    }
}
