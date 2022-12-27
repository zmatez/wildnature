package net.matez.wildnature.common.block.rocks;

import net.minecraft.world.level.material.MaterialColor;

public enum RockType {
    MARBLE("marble",MaterialColor.SNOW,true),
    GNEISS("gneiss",MaterialColor.COLOR_LIGHT_GRAY,false),
    LIMESTONE("limestone",MaterialColor.TERRACOTTA_YELLOW,false),
    SLATE_BLUE("slate_blue",MaterialColor.TERRACOTTA_BLUE,true,true),
    SLATE_PURPLE("slate_purple",MaterialColor.TERRACOTTA_PURPLE,true,true),
    QUARTZITE("quartzite",MaterialColor.TERRACOTTA_GREEN,true),
    BASANITE("basanite",MaterialColor.COLOR_BLACK,true),
    ;
    private final String idBase;
    private final boolean poor;
    private final boolean hard;
    private final MaterialColor color;

    RockType(String idBase, MaterialColor color, boolean hard){
        this(idBase,color,hard,false);
    }

    RockType(String idBase, MaterialColor color, boolean hard, boolean poor){
        this.idBase = idBase;
        this.color = color;
        this.hard = hard;
        this.poor = poor;
    }

    public String getIdBase() {
        return idBase;
    }

    public MaterialColor getColor() {
        return color;
    }

    public boolean isPoor() {
        return poor;
    }

    public boolean isHard() {
        return hard;
    }
}
