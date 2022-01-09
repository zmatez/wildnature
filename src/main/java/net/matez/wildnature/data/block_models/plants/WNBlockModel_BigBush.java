package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_BigBush extends WNBlockModel {
    /**
     * Required: @stalk, @leaves
     */
    public WNBlockModel_BigBush(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/big_bush",
                    "textures": {
                        "stemBL": "%stalk%_left_bottom",
                		"stemTL": "%stalk%_left_top",
                		"stemBR": "%stalk%_right_bottom",
                		"stemTR": "%stalk%_right_top",
                		"greyscaledBL": "%leaves%_left_bottom",
                		"greyscaledTL": "%leaves%_left_top",
                		"greyscaledBR": "%leaves%_right_bottom",
                		"greyscaledTR": "%leaves%_right_top",
                		"particle":"%leaves%_right_top"
                	}
                }
                """;
    }
}
