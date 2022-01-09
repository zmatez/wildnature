package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_FarmBlock extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_FarmBlock(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/template_farmland",
                  "textures": {
                    "dirt": "%dirt%",
                    "top": "%texture%"
                  }
                }
                """;
    }
}
