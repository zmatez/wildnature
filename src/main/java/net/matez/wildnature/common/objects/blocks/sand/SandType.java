package net.matez.wildnature.common.objects.blocks.sand;

import net.minecraft.world.level.material.MaterialColor;

public enum SandType {
    DESERT_SAND("desert",MaterialColor.TERRACOTTA_ORANGE,0xD6A36B),
    CRIMSON_SAND("crimson",MaterialColor.TERRACOTTA_RED,0x8E3219),
    TROPICAL_SAND("tropical",MaterialColor.SAND,0xE9E2C8,true),
    IRON_SAND("iron",MaterialColor.TERRACOTTA_YELLOW,0xA2785D),
    ;
    private final String idBase;
    private final int dustColor;
    private final MaterialColor color;
    private final boolean hasSandstone;

    SandType(String idBase, MaterialColor color, int dustColor){
        this.idBase = idBase;
        this.color = color;
        this.dustColor = dustColor;
        this.hasSandstone = false;
    }
    SandType(String idBase, MaterialColor color, int dustColor, boolean hasSandstone){
        this.idBase = idBase;
        this.color = color;
        this.dustColor = dustColor;
        this.hasSandstone = hasSandstone;
    }



    public String getIdBase() {
        return idBase;
    }

    public MaterialColor getColor() {
        return color;
    }

    public int getDustColor() {
        return dustColor;
    }
}
