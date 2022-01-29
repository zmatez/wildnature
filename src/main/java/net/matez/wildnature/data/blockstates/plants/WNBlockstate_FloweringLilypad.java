/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_FloweringLilypad extends WNBlockstate {
    public WNBlockstate_FloweringLilypad(String id) {
        super(id);
    }

    public WNBlockstate_FloweringLilypad(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "flowering=false": [
                      {
                        "model": "%modid%:block/%name%"
                      },
                      {
                        "model": "%modid%:block/%name%",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%",
                        "y": 270
                      }
                    ],
                    "flowering=true": [
                      {
                        "model": "%modid%:block/%name%_flowering"
                      },
                      {
                        "model": "%modid%:block/%name%_flowering",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_flowering",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_flowering",
                        "y": 270
                      }
                    ]
                  }
                }
                """;
    }
}
