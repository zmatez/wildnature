package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Moss extends WNBlockstate {
    public WNBlockstate_Moss(String id) {
        super(id);
    }

    public WNBlockstate_Moss(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "":[
                      { "model": "%modid%:block/%name%_1" },
                      { "model": "%modid%:block/%name%_1","y": 90},
                      { "model": "%modid%:block/%name%_1","y": 180 },
                      { "model": "%modid%:block/%name%_1","y": 270 },
                      { "model": "%modid%:block/%name%_2" },
                      { "model": "%modid%:block/%name%_2","y": 90},
                      { "model": "%modid%:block/%name%_2","y": 180 },
                      { "model": "%modid%:block/%name%_2","y": 270 },
                      { "model": "%modid%:block/%name%_3" },
                      { "model": "%modid%:block/%name%_3","y": 90},
                      { "model": "%modid%:block/%name%_3","y": 180 },
                      { "model": "%modid%:block/%name%_3","y": 270 },
                      { "model": "%modid%:block/%name%_4" },
                      { "model": "%modid%:block/%name%_4","y": 90},
                      { "model": "%modid%:block/%name%_4","y": 180 },
                      { "model": "%modid%:block/%name%_4","y": 270 },
                      { "model": "%modid%:block/%name%_5" },
                      { "model": "%modid%:block/%name%_5","y": 90},
                      { "model": "%modid%:block/%name%_5","y": 180 },
                      { "model": "%modid%:block/%name%_5","y": 270 }
                    ]
                  }
                }
                """;
    }
}
