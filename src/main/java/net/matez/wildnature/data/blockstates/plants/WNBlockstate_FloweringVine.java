package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_FloweringVine extends WNBlockstate {

    public WNBlockstate_FloweringVine(String id) {
        super(id);
    }

    public WNBlockstate_FloweringVine(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "multipart": [
                      {
                        "when": {
                          "up": "true",
                          "flowering": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "x": 270,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "up": "true",
                          "flowering": "true"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%_flowering",
                          "x": 270,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "up": "false",
                          "north": "false",
                          "west": "false",
                          "south": "false",
                          "east": "false",
                          "flowering": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "x": 270,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "up": "false",
                          "north": "false",
                          "west": "false",
                          "south": "false",
                          "east": "false",
                          "flowering": "true"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%_flowering",
                          "x": 270,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "north": "true",
                          "flowering": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%"
                        }
                      },
                      {
                        "when": {
                          "north": "true",
                          "flowering": "true"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%_flowering"
                        }
                      },
                      {
                        "when": {
                          "up": "false",
                          "north": "false",
                          "west": "false",
                          "south": "false",
                          "east": "false",
                          "flowering": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%"
                        }
                      },
                      {
                        "when": {
                          "up": "false",
                          "north": "false",
                          "west": "false",
                          "south": "false",
                          "east": "false",
                          "flowering": "true"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%_flowering"
                        }
                      },
                      {
                        "when": {
                          "west": "true",
                          "flowering": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "y": 270,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "west": "true",
                          "flowering": "true"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%_flowering",
                          "y": 270,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "up": "false",
                          "north": "false",
                          "west": "false",
                          "south": "false",
                          "east": "false",
                          "flowering": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "y": 270,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "up": "false",
                          "north": "false",
                          "west": "false",
                          "south": "false",
                          "east": "false",
                          "flowering": "true"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%_flowering",
                          "y": 270,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "south": "true",
                          "flowering": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "y": 180,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "south": "true",
                          "flowering": "true"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%_flowering",
                          "y": 180,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "up": "false",
                          "north": "false",
                          "west": "false",
                          "south": "false",
                          "east": "false",
                          "flowering": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "y": 180,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "up": "false",
                          "north": "false",
                          "west": "false",
                          "south": "false",
                          "east": "false",
                          "flowering": "true"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%_flowering",
                          "y": 180,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "east": "true",
                          "flowering": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "y": 90,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "east": "true",
                          "flowering": "true"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%_flowering",
                          "y": 90,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "up": "false",
                          "north": "false",
                          "west": "false",
                          "south": "false",
                          "east": "false",
                          "flowering": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "y": 90,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "up": "false",
                          "north": "false",
                          "west": "false",
                          "south": "false",
                          "east": "false",
                          "flowering": "true"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%_flowering",
                          "y": 90,
                          "uvlock": true
                        }
                      }
                    ]
                  }
                """;
    }
}
