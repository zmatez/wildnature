/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_SizedFormation extends WNBlockstate {
    public WNBlockstate_SizedFormation(String id) {
        super(id);
    }

    public WNBlockstate_SizedFormation(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "facing=north,size=small": {
                      "model": "%modid%:block/%name%_small",
                      "x": 90,
                      "uvlock": false
                    },
                    "facing=east,size=small": {
                      "model": "%modid%:block/%name%_small",
                      "x": 90,
                      "y": 90,
                      "uvlock": false
                    },
                    "facing=south,size=small": {
                      "model": "%modid%:block/%name%_small",
                      "x": 90,
                      "y": 180,
                      "uvlock": false
                    },
                    "facing=west,size=small": {
                      "model": "%modid%:block/%name%_small",
                      "x": 90,
                      "y": 270,
                      "uvlock": false
                    },
                    "facing=up,size=small": {
                      "model": "%modid%:block/%name%_small",
                      "uvlock": false
                    },
                    "facing=down,size=small": {
                      "model": "%modid%:block/%name%_small",
                      "x": 180,
                      "uvlock": false
                    },
                    "facing=north,size=big": {
                      "model": "%modid%:block/%name%_big",
                      "x": 90,
                      "uvlock": false
                    },
                    "facing=east,size=big": {
                      "model": "%modid%:block/%name%_big",
                      "x": 90,
                      "y": 90,
                      "uvlock": false
                    },
                    "facing=south,size=big": {
                      "model": "%modid%:block/%name%_big",
                      "x": 90,
                      "y": 180,
                      "uvlock": false
                    },
                    "facing=west,size=big": {
                      "model": "%modid%:block/%name%_big",
                      "x": 90,
                      "y": 270,
                      "uvlock": false
                    },
                    "facing=up,size=big": {
                      "model": "%modid%:block/%name%_big",
                      "uvlock": false
                    },
                    "facing=down,size=big": {
                      "model": "%modid%:block/%name%_big",
                      "x": 180,
                      "uvlock": false
                    }
                  }
                }
                """;
    }
}
