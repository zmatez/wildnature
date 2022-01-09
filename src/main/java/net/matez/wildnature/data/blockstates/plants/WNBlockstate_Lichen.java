package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Lichen extends WNBlockstate {
    public WNBlockstate_Lichen(String id) {
        super(id);
    }

    public WNBlockstate_Lichen(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "facing=south": [
                      {
                        "model": "%modid%:block/%name%_1"
                      },
                      {
                        "model": "%modid%:block/%name%_2"
                      },
                      {
                        "model": "%modid%:block/%name%_3"
                      },
                      {
                        "model": "%modid%:block/%name%_4"
                      }
                    ],
                    "facing=west": [
                      {
                        "model": "%modid%:block/%name%_1",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_2",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_3",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%_4",
                        "y": 90
                      }
                    ],
                    "facing=north": [
                      {
                        "model": "%modid%:block/%name%_1",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_2",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_3",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%_4",
                        "y": 180
                      }
                    ],
                    "facing=east": [
                      {
                        "model": "%modid%:block/%name%_1",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_2",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_3",
                        "y": 270
                      },
                      {
                        "model": "%modid%:block/%name%_4",
                        "y": 270
                      }
                    ],
                    "facing=up": [
                      {
                        "model": "%modid%:block/%name%_1",
                        "x": 90
                      },
                      {
                        "model": "%modid%:block/%name%_2",
                        "x": 90
                      },
                      {
                        "model": "%modid%:block/%name%_3",
                        "x": 90
                      },
                      {
                        "model": "%modid%:block/%name%_4",
                        "x": 90
                      }
                    ],
                    "facing=down": [
                      {
                        "model": "%modid%:block/%name%_1",
                        "x": 270
                      },
                      {
                        "model": "%modid%:block/%name%_2",
                        "x": 270
                      },
                      {
                        "model": "%modid%:block/%name%_3",
                        "x": 270
                      },
                      {
                        "model": "%modid%:block/%name%_4",
                        "x": 270
                      }
                    ]
                  }
                }
                """;
    }
}
