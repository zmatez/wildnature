package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_FenceSide extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_FenceSide(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/fence_side",
                  "textures": {
                    "texture": "%texture%"
                  }
                }
                """;
    }
}
