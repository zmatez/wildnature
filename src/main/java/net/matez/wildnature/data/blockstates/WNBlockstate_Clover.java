package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Clover extends WNBlockstate {
    /**
     * Required: @solid (e.g planks)
     */
    public WNBlockstate_Clover(String id) {
        super(id);
    }

    /**
     * Required: @solid (e.g planks)
     */
    public WNBlockstate_Clover(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "stage=0": [
                      {
                        "model": "%modid%:block/%name%_short_purple"
                      },
                      {
                        "model": "%modid%:block/%name%_short_purple",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_short_purple",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_short_purple",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_short_pink"
                      },
                      {
                        "model": "%modid%:block/%name%_short_pink",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_short_pink",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_short_pink",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_short_white"
                      },
                      {
                        "model": "%modid%:block/%name%_short_white",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_short_white",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_short_white",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_short_empty"
                      },
                      {
                        "model": "%modid%:block/%name%_short_empty",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_short_empty",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_short_empty",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_short_empty"
                      },
                      {
                        "model": "%modid%:block/%name%_short_empty",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_short_empty",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_short_empty",
                        "y": 270
                      }
                    ],
                    "stage=1": [
                      {
                        "model": "%modid%:block/%name%_medium_purple"
                      },
                      {
                        "model": "%modid%:block/%name%_medium_purple",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_medium_purple",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_medium_purple",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_medium_pink"
                      },
                      {
                        "model": "%modid%:block/%name%_medium_pink",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_medium_pink",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_medium_pink",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_medium_white"
                      },
                      {
                        "model": "%modid%:block/%name%_medium_white",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_medium_white",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_medium_white",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_medium_empty"
                      },
                      {
                        "model": "%modid%:block/%name%_medium_empty",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_medium_empty",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_medium_empty",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_medium_empty"
                      },
                      {
                        "model": "%modid%:block/%name%_medium_empty",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_medium_empty",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_medium_empty",
                        "y": 270
                      }
                    ],
                    "stage=2": [
                      {
                        "model": "%modid%:block/%name%_tall_purple"
                      },
                      {
                        "model": "%modid%:block/%name%_tall_purple",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_tall_purple",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_tall_purple",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_tall_pink"
                      },
                      {
                        "model": "%modid%:block/%name%_tall_pink",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_tall_pink",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_tall_pink",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_tall_white"
                      },
                      {
                        "model": "%modid%:block/%name%_tall_white",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_tall_white",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_tall_white",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_tall_empty"
                      },
                      {
                        "model": "%modid%:block/%name%_tall_empty",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_tall_empty",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_tall_empty",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_tall_empty"
                      },
                      {
                        "model": "%modid%:block/%name%_tall_empty",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_tall_empty",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_tall_empty",
                        "y": 270
                      }
                    ]
                  }
                }
                """;
    }
}
