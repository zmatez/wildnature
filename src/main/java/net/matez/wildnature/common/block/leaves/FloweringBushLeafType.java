package net.matez.wildnature.common.block.leaves;

import net.minecraft.world.level.material.MaterialColor;

public enum FloweringBushLeafType {
    FORSYTHIA("forsythia",MaterialColor.COLOR_YELLOW),
    MAGNOLIA("magnolia",MaterialColor.COLOR_PINK);

    private final String idBase;
    private MaterialColor color = MaterialColor.PLANT;

    FloweringBushLeafType(String idBase){
        this.idBase = idBase;
    }
    FloweringBushLeafType(String idBase, MaterialColor color){
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
