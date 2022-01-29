/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_CoffeeBush extends WNBlockstate {
    public WNBlockstate_CoffeeBush(String id) {
        super(id);
    }

    public WNBlockstate_CoffeeBush(ResourceLocation location) {
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
                      }
                  }
                }
                """;
    }
}
