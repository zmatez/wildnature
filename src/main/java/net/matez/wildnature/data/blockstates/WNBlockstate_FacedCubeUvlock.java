/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_FacedCubeUvlock extends WNBlockstate {
    public WNBlockstate_FacedCubeUvlock(String id) {
        super(id);
    }

    public WNBlockstate_FacedCubeUvlock(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "facing=north": {
                      "model": "%modid%:block/%name%",
                      "x": 90,
                      "uvlock": true
                    },
                    "facing=east": {
                      "model": "%modid%:block/%name%",
                      "x": 90,
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=south": {
                      "model": "%modid%:block/%name%",
                      "x": 90,
                      "y": 180,
                      "uvlock": true
                    },
                    "facing=west": {
                      "model": "%modid%:block/%name%",
                      "x": 90,
                      "y": 270,
                      "uvlock": true
                    },
                    "facing=up": {
                      "model": "%modid%:block/%name%",
                      "uvlock": true
                    },
                    "facing=down": {
                      "model": "%modid%:block/%name%",
                      "x": 180,
                      "uvlock": true
                    }
                  }
                }
                """;
    }
}
