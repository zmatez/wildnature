/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Geyser extends WNBlockstate {
    public WNBlockstate_Geyser(String id) {
        super(id);
    }

    public WNBlockstate_Geyser(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "single=true": [
                      {
                        "model": "%modid%:block/%name%_single"
                      },
                      {
                        "model": "%modid%:block/%name%_single",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_single",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_single",
                        "y": 270
                      }
                    ],
                    "single=false": [
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
                    ]
                  }
                }
                """;
    }
}
