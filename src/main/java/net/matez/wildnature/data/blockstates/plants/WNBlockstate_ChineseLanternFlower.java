package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_ChineseLanternFlower extends WNBlockstate {
    public WNBlockstate_ChineseLanternFlower(String id) {
        super(id);
    }

    public WNBlockstate_ChineseLanternFlower(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "variants": {
                      "stage=0,half=lower": {
                          "model": "%modid%:block/%name%_stage_0_bottom"
                      },
                      "stage=0,half=upper": {
                          "model": "%modid%:block/%name%_stage_0_top"
                      },
                      "stage=1,half=lower": {
                          "model": "%modid%:block/%name%_stage_1_bottom"
                      },
                      "stage=1,half=upper": {
                          "model": "%modid%:block/%name%_stage_1_top"
                      },
                      "stage=2,half=lower": {
                          "model": "%modid%:block/%name%_stage_2_bottom"
                      },
                      "stage=2,half=upper": {
                          "model": "%modid%:block/%name%_stage_2_top"
                      },
                      "stage=3,half=lower": {
                          "model": "%modid%:block/%name%_stage_3_bottom"
                      },
                      "stage=3,half=upper": {
                          "model": "%modid%:block/%name%_stage_3_top"
                      }
                  }
                }
                """;
    }
}
