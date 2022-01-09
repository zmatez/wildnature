package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Button extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_Button(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "parent": "minecraft:block/button",
                   "textures": {
                     "texture": "%texture%"
                   }
                 }
                """;
    }
}
