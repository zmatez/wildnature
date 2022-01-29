/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Puffball extends WNBlockstate {
    /**
     * Required: @texture
     */
    public WNBlockstate_Puffball(String id) {
        super(id);
    }

    /**
     * Required: @texture
     */
    public WNBlockstate_Puffball(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "broken=false": {
                      "model": "%modid%:block/%name%"
                    },
                    "broken=true": {
                      "model": "%modid%:block/%name%_broken"
                    }
                  }
                }
                """;
    }
}
