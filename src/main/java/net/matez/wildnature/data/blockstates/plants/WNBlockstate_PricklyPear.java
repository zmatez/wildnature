package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_PricklyPear extends WNBlockstate {
    public WNBlockstate_PricklyPear(String id) {
        super(id);
    }

    public WNBlockstate_PricklyPear(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "variants": {
                      "stage=0": [
                          { "model": "%modid%:block/%name%_stage_1" },
                          { "model": "%modid%:block/%name%_stage_1","y": 90},
                          { "model": "%modid%:block/%name%_stage_1","y": 180 },
                          { "model": "%modid%:block/%name%_stage_1","y": 270 }
                      ],
                      "stage=1": [
                          { "model": "%modid%:block/%name%_stage_2" },
                          { "model": "%modid%:block/%name%_stage_2","y": 90},
                          { "model": "%modid%:block/%name%_stage_2","y": 180 },
                          { "model": "%modid%:block/%name%_stage_2","y": 270 }
                      ],
                      "stage=2": [
                          { "model": "%modid%:block/%name%_stage_3" },
                          { "model": "%modid%:block/%name%_stage_3","y": 90},
                          { "model": "%modid%:block/%name%_stage_3","y": 180 },
                          { "model": "%modid%:block/%name%_stage_3","y": 270 }
                      ]
                  }
                }
                """;
    }
}
