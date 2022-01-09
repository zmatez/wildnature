package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_SlabTop extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_SlabTop(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/slab_top",
                  "textures": {
                    "bottom": "%texture%",
                    "top": "%texture%",
                    "side": "%texture%"
                  }
                }
                """;
    }
}
