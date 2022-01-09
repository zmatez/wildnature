package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_LeafedFloweringBush extends WNBlockModel {
    /**
     * Required: @texture, @stalk, @leaves
     */
    public WNBlockModel_LeafedFloweringBush(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/flowering_cross_leaf",
                    "textures": {
                        "colored": "%texture%",
                        "stalk": "%stalk%",
                        "particle": "%stalk%",
                        "leaves": "%leaves%"
                    }
                }
                """;
    }
}
