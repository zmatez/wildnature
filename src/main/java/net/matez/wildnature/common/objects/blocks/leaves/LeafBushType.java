package net.matez.wildnature.common.objects.blocks.leaves;

import net.minecraft.world.level.material.MaterialColor;

public enum LeafBushType {
    LARGE_BUSH("large"),
    DENSE_BUSH("dense"),
    SMALL_BUSH("small");

    private final String idBase;
    private MaterialColor color = MaterialColor.PLANT;

    LeafBushType(String idBase){
        this.idBase = idBase;
    }
    LeafBushType(String idBase, MaterialColor color){
        this.idBase = idBase;
        this.color = color;
    }

    public String getIdBase() {
        return idBase;
    }

    public MaterialColor getColor() {
        return color;
    }
}
