/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_FacedCube extends WNBlockstate {
    public WNBlockstate_FacedCube(String id) {
        super(id);
    }

    public WNBlockstate_FacedCube(ResourceLocation location) {
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
                      "uvlock": false
                    },
                    "facing=east": {
                      "model": "%modid%:block/%name%",
                      "x": 90,
                      "y": 90,
                      "uvlock": false
                    },
                    "facing=south": {
                      "model": "%modid%:block/%name%",
                      "x": 90,
                      "y": 180,
                      "uvlock": false
                    },
                    "facing=west": {
                      "model": "%modid%:block/%name%",
                      "x": 90,
                      "y": 270,
                      "uvlock": false
                    },
                    "facing=up": {
                      "model": "%modid%:block/%name%",
                      "uvlock": false
                    },
                    "facing=down": {
                      "model": "%modid%:block/%name%",
                      "x": 180,
                      "uvlock": false
                    }
                  }
                }
                """;
    }
}
