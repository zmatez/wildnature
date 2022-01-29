/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_LilyPad extends WNBlockstate {
    public WNBlockstate_LilyPad(String id) {
        super(id);
    }

    public WNBlockstate_LilyPad(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "":[
                      { "model": "%modid%:block/%name%_1" },
                      { "model": "%modid%:block/%name%_1","y": 90},
                      { "model": "%modid%:block/%name%_1","y": 180 },
                      { "model": "%modid%:block/%name%_1","y": 270 },
                      { "model": "%modid%:block/%name%_2" },
                      { "model": "%modid%:block/%name%_2","y": 90},
                      { "model": "%modid%:block/%name%_2","y": 180 },
                      { "model": "%modid%:block/%name%_2","y": 270 },
                      { "model": "%modid%:block/%name%_3" },
                      { "model": "%modid%:block/%name%_3","y": 90},
                      { "model": "%modid%:block/%name%_3","y": 180 },
                      { "model": "%modid%:block/%name%_3","y": 270 },
                      { "model": "%modid%:block/%name%_4" },
                      { "model": "%modid%:block/%name%_4","y": 90},
                      { "model": "%modid%:block/%name%_4","y": 180 },
                      { "model": "%modid%:block/%name%_4","y": 270 }
                    ]
                  }
                }
                """;
    }
}
