package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Yucca extends WNBlockstate {

    public WNBlockstate_Yucca(String id) {
        super(id);
    }

    public WNBlockstate_Yucca(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                     "variants": {
                       "flowering=false,half=lower": [
                         {
                           "model": "%modid%:block/%name%_bush_bottom"
                         },
                         {
                           "model": "%modid%:block/%name%_bush_bottom",
                           "y": 90
                         },
                         {
                           "model": "%modid%:block/%name%_bush_bottom",
                           "y": 180
                         },
                         {
                           "model": "%modid%:block/%name%_bush_bottom",
                           "y": 270
                         }
                       ],
                       "flowering=false,half=upper": [
                         {
                           "model": "%modid%:block/%name%_bush_bottom"
                         },
                         {
                           "model": "%modid%:block/%name%_bush_bottom",
                           "y": 90
                         },
                         {
                           "model": "%modid%:block/%name%_bush_bottom",
                           "y": 180
                         },
                         {
                           "model": "%modid%:block/%name%_bush_bottom",
                           "y": 270
                         }
                       ],
                       "flowering=true,half=lower": [
                         {
                           "model": "%modid%:block/%name%_bottom"
                         },
                         {
                           "model": "%modid%:block/%name%_bottom",
                           "y": 90
                         },
                         {
                           "model": "%modid%:block/%name%_bottom",
                           "y": 180
                         },
                         {
                           "model": "%modid%:block/%name%_bottom",
                           "y": 270
                         }
                       ],
                       "flowering=true,half=upper": [
                         {
                           "model": "%modid%:block/%name%_top"
                         },
                         {
                           "model": "%modid%:block/%name%_top",
                           "y": 90
                         },
                         {
                           "model": "%modid%:block/%name%_top",
                           "y": 180
                         },
                         {
                           "model": "%modid%:block/%name%_top",
                           "y": 270
                         }
                       ]
                   }
                 }
                """;
    }
}
