package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Branch extends WNBlockModel {
    /**
     * Required: @texture, @side (up, down, side, inventory)
     */
    public WNBlockModel_Branch(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/branch_%side%",
                    "textures": {
                        "log": "%texture%",
                        "inside": "%texture%_top"
                    }
                }
                """;
    }
}
