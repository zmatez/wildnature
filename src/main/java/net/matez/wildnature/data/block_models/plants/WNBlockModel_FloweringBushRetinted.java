package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_FloweringBushRetinted extends WNBlockModel {
    /**
     * Required: @texture, stalk
     */
    public WNBlockModel_FloweringBushRetinted(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/flowering_cross_retinted",
                    "textures": {
                        "colored": "%stalk%",
                        "grayscale": "%texture%",
                        "particle": "%texture%"
                    }
                }
                """;
    }
}
