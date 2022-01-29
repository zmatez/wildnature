/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Bench extends WNBlockstate {
    public WNBlockstate_Bench(String id) {
        super(id);
    }

    public WNBlockstate_Bench(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "variants": {
                     "facing=north,part=single": { "model": "%modid%:block/%name%_single" },
                     "facing=east,part=single": { "model": "%modid%:block/%name%_single", "y": 90, "uvlock": true},
                     "facing=south,part=single": { "model": "%modid%:block/%name%_single", "y": 180, "uvlock": true},
                     "facing=west,part=single": { "model": "%modid%:block/%name%_single", "y": 270, "uvlock": true},
                 
                     "facing=north,part=right": { "model": "%modid%:block/%name%_side" },
                     "facing=east,part=right": { "model": "%modid%:block/%name%_side", "y": 90, "uvlock": true},
                     "facing=south,part=right": { "model": "%modid%:block/%name%_side", "y": 180, "uvlock": true},
                     "facing=west,part=right": { "model": "%modid%:block/%name%_side", "y": 270, "uvlock": true},
                     
                     "facing=north,part=middle": { "model": "%modid%:block/%name%_middle" },
                     "facing=east,part=middle": { "model": "%modid%:block/%name%_middle", "y": 90, "uvlock": true},
                     "facing=south,part=middle": { "model": "%modid%:block/%name%_middle", "y": 180, "uvlock": true},
                     "facing=west,part=middle": { "model": "%modid%:block/%name%_middle", "y": 270, "uvlock": true},
                 
                     "facing=north,part=left": { "model": "%modid%:block/%name%_side", "y": 180, "uvlock": true},
                     "facing=east,part=left": { "model": "%modid%:block/%name%_side", "y": 270, "uvlock": true},
                     "facing=south,part=left": { "model": "%modid%:block/%name%_side"},
                     "facing=west,part=left": { "model": "%modid%:block/%name%_side", "y": 90, "uvlock": true}
                   }
                 }
                """;
    }
}
