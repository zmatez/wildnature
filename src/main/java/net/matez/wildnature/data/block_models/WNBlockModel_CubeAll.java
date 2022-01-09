package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_CubeAll extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_CubeAll(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "block/cube_all",
                    "textures": {
                        "all": "%texture%"
                    }
                }
                """;
    }
}
