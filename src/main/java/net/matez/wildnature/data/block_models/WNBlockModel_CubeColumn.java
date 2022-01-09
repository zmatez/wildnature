package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_CubeColumn extends WNBlockModel {
    /**
     * Required: @texture, @texture_top
     */
    public WNBlockModel_CubeColumn(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "block/cube_column",
                    "textures": {
                        "end": "%texture_top%",
                        "side": "%texture%"
                    }
                }
                """;
    }
}
