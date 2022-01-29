/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Lantern extends WNBlockstate {
    public WNBlockstate_Lantern(String id) {
        super(id);
    }

    public WNBlockstate_Lantern(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "variants": {
                        "hanging=true": { "model": "%modid%:block/%name%_hanging"},
                        "hanging=false": { "model": "%modid%:block/%name%"}
                  }
                }
                """;
    }
}
