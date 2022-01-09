package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_ButtonPressed extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_ButtonPressed(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "parent": "minecraft:block/button_pressed",
                   "textures": {
                     "texture": "%texture%"
                   }
                 }
                """;
    }
}
