package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_PressurePlateDown extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_PressurePlateDown(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "parent": "minecraft:block/pressure_plate_down",
                   "textures": {
                     "texture": "%texture%"
                   }
                 }
                """;
    }
}
