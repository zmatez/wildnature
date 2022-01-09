package net.matez.wildnature.data.block_models.plants.wisteria;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_WisteriaSide extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_WisteriaSide(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/wisteria_side",
                    "textures": {
                        "0": "%texture%_attached_left_top",
                        "1": "%texture%_attached_right_top",
                        "2": "%texture%_left_bottom",
                        "3": "%texture%_right_bottom",
                        "4": "%texture%_side_bottom",
                        "5": "%texture%_side_top",
                        "particle": "%texture%_attached_left_top"
                    }
                }
                """;
    }
}
