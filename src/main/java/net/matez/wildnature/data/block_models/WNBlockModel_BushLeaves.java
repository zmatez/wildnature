package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_BushLeaves extends WNBlockModel {
    /**
     * Required: @texture, @branch
     */
    public WNBlockModel_BushLeaves(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/branch_leaves",
                    "textures": {
                        "branch": "%branch%",
                        "leaves": "%texture%"
                    }
                }
                """;
    }
}
