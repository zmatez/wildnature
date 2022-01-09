package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Wall extends WNBlockstate {
    public WNBlockstate_Wall(String id) {
        super(id);
    }

    public WNBlockstate_Wall(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "multipart": [
                     {
                       "when": {
                         "up": "true"
                       },
                       "apply": {
                         "model": "%modid%:block/%name%_post"
                       }
                     },
                     {
                       "when": {
                         "north": "low"
                       },
                       "apply": {
                         "model": "%modid%:block/%name%_side",
                         "uvlock": true
                       }
                     },
                     {
                       "when": {
                         "east": "low"
                       },
                       "apply": {
                         "model": "%modid%:block/%name%_side",
                         "y": 90,
                         "uvlock": true
                       }
                     },
                     {
                       "when": {
                         "south": "low"
                       },
                       "apply": {
                         "model": "%modid%:block/%name%_side",
                         "y": 180,
                         "uvlock": true
                       }
                     },
                     {
                       "when": {
                         "west": "low"
                       },
                       "apply": {
                         "model": "%modid%:block/%name%_side",
                         "y": 270,
                         "uvlock": true
                       }
                     },
                     {
                       "when": {
                         "north": "tall"
                       },
                       "apply": {
                         "model": "%modid%:block/%name%_side_tall",
                         "uvlock": true
                       }
                     },
                     {
                       "when": {
                         "east": "tall"
                       },
                       "apply": {
                         "model": "%modid%:block/%name%_side_tall",
                         "y": 90,
                         "uvlock": true
                       }
                     },
                     {
                       "when": {
                         "south": "tall"
                       },
                       "apply": {
                         "model": "%modid%:block/%name%_side_tall",
                         "y": 180,
                         "uvlock": true
                       }
                     },
                     {
                       "when": {
                         "west": "tall"
                       },
                       "apply": {
                         "model": "%modid%:block/%name%_side_tall",
                         "y": 270,
                         "uvlock": true
                       }
                     }
                   ]
                 }
                """;
    }
}
