package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Fence extends WNBlockstate {
    /**
     * Required: @solid (e.g planks)
     */
    public WNBlockstate_Fence(String id) {
        super(id);
    }

    /**
     * Required: @solid (e.g planks)
     */
    public WNBlockstate_Fence(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "multipart": [
                    {
                      "apply": {
                        "model": "%modid%:block/%name%_post"
                      }
                    },
                    {
                      "when": {
                        "north": "true"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_side",
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "east": "true"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_side",
                        "y": 90,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "south": "true"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_side",
                        "y": 180,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "west": "true"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_side",
                        "y": 270,
                        "uvlock": true
                      }
                    }
                  ]
                }
                """;
    }
}
