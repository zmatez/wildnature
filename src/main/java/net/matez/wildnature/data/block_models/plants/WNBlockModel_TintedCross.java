package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_TintedCross extends WNBlockModel {
    /**
     * Required: texture
     */
    public WNBlockModel_TintedCross(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "block/tinted_cross",
                    "textures": {
                        "cross": "%texture%"
                    }
                }
                """;
    }
}
