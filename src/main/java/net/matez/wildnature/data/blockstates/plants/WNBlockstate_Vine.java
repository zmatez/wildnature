package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Vine extends WNBlockstate {

    public WNBlockstate_Vine(String id) {
        super(id);
    }

    public WNBlockstate_Vine(ResourceLocation location) {
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
                          "east": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "x": 270,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "north": "true"
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
                          "east": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%"
                        }
                      },
                      {
                        "when": {
                          "west": "true"
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
                          "east": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "y": 270,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "south": "true"
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
                          "east": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "y": 180,
                          "uvlock": true
                        }
                      },
                      {
                        "when": {
                          "east": "true"
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
                          "east": "false"
                        },
                        "apply": {
                          "model": "%modid%:block/%name%",
                          "y": 90,
                          "uvlock": true
                        }
                      }
                    ]
                  }
                """;
    }
}
