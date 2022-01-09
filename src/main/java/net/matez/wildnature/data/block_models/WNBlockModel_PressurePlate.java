package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_PressurePlate extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_PressurePlate(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "parent": "minecraft:block/pressure_plate_up",
                   "textures": {
                     "texture": "%texture%"
                   }
                 }
                """;
    }
}
