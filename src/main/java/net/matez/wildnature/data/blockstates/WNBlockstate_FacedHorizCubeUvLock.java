/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_FacedHorizCubeUvLock extends WNBlockstate {
    public WNBlockstate_FacedHorizCubeUvLock(String id) {
        super(id);
    }

    public WNBlockstate_FacedHorizCubeUvLock(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "facing=north": {
                      "model": "%modid%:block/%name%"
                    },
                    "facing=east": {
                      "model": "%modid%:block/%name%",
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=south": {
                      "model": "%modid%:block/%name%",
                      "y": 180,
                      "uvlock": true
                    },
                    "facing=west": {
                      "model": "%modid%:block/%name%",
                      "y": 270,
                      "uvlock": true
                    }
                  }
                }
                """;
    }
}
