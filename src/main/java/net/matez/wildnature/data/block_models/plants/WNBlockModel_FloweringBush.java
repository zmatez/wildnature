package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_FloweringBush extends WNBlockModel {
    /**
     * Required: @texture, stalk
     */
    public WNBlockModel_FloweringBush(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/flowering_cross",
                    "textures": {
                        "colored": "%texture%",
                        "greyscale": "%stalk%",
                        "particle": "%stalk%"
                    }
                }
                """;
    }
}
