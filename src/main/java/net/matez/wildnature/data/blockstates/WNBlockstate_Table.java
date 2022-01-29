/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Table extends WNBlockstate {
    public WNBlockstate_Table(String id) {
        super(id);
    }

    public WNBlockstate_Table(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "multipart": [
                        {   "when": { "north": "true" },
                            "apply": { "model": "%modid%:block/%name%_leg", "uvlock": true }
                        },
                        {   "when": { "east": "true" },
                            "apply": { "model": "%modid%:block/%name%_leg", "y": 90, "uvlock": true }
                        },
                        {   "when": { "south": "true" },
                            "apply": { "model": "%modid%:block/%name%_leg", "y": 180, "uvlock": true }
                        },
                        {   "when": { "west": "true" },
                            "apply": { "model": "%modid%:block/%name%_leg", "y": 270, "uvlock": true }
                        },
                        {   "when": { "waterlogged": "true"},
                            "apply": { "model": "%modid%:block/%name%_top"}
                        },
                        {   "when": { "waterlogged": "false"},
                            "apply": { "model": "%modid%:block/%name%_top"}
                        }
                    ]
                }
                """;
    }
}
