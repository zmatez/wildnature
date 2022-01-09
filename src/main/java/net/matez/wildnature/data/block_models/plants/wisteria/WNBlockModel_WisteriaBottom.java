package net.matez.wildnature.data.block_models.plants.wisteria;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_WisteriaBottom extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_WisteriaBottom(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                     "parent": "wildnature:block/wisteria_bottom",
                     "textures": {
                         "0": "%texture%_attached_centre_top",
                         "1": "%texture%_left_bottom",
                         "2": "%texture%_side_bottom",
                         "3": "%texture%_side_top",
                         "particle": "%texture%_attached_centre_top"
                     }
                 }
                 
                """;
    }
}
