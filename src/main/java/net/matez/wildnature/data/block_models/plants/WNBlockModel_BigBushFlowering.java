package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_BigBushFlowering extends WNBlockModel {
    /**
     * Required: @texture, @stalk, @leaves
     */
    public WNBlockModel_BigBushFlowering(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/big_bush_flowering",
                    "textures": {
                        "stemBL": "%stalk%_left_bottom",
                		"stemTL": "%stalk%_left_top",
                		"stemBR": "%stalk%_right_bottom",
                		"stemTR": "%stalk%_right_top",
                		"greyscaledBL": "%leaves%_left_bottom",
                		"greyscaledTL": "%leaves%_left_top",
                		"greyscaledBR": "%leaves%_right_bottom",
                		"greyscaledTR": "%leaves%_right_top",
                		"flowerBL": "%texture%_left_bottom",
                		"flowerTL": "%texture%_left_top",
                		"flowerBR": "%texture%_right_bottom",
                		"flowerTR": "%texture%_right_top",
                		"particle":"%texture%_right_top"
                	}
                }           
                """;
    }
}
