/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_FruitVine extends WNBlockstate {

    public WNBlockstate_FruitVine(String id) {
        super(id);
    }

    public WNBlockstate_FruitVine(ResourceLocation location) {
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
                        "stage": "0"
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
                        "stage": "1"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_1",
                        "x": 270,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "up": "true",
                        "stage": "2"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_2",
                        "x": 270,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "up": "true",
                        "stage": "3"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_3",
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
                        "stage": "0"
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
                        "stage": "1"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_1",
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
                        "stage": "2"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_2",
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
                        "stage": "3"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_3",
                        "x": 270,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "north": "true",
                        "stage": "0"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%"
                      }
                    },
                    {
                      "when": {
                        "north": "true",
                        "stage": "1"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_1"
                      }
                    },
                    {
                      "when": {
                        "north": "true",
                        "stage": "2"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_2"
                      }
                    },
                    {
                      "when": {
                        "north": "true",
                        "stage": "3"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_3"
                      }
                    },
                    {
                      "when": {
                        "up": "false",
                        "north": "false",
                        "west": "false",
                        "south": "false",
                        "east": "false",
                        "stage": "0"
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
                        "stage": "1"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_1"
                      }
                    },
                    {
                      "when": {
                        "up": "false",
                        "north": "false",
                        "west": "false",
                        "south": "false",
                        "east": "false",
                        "stage": "2"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_2"
                      }
                    },
                    {
                      "when": {
                        "up": "false",
                        "north": "false",
                        "west": "false",
                        "south": "false",
                        "east": "false",
                        "stage": "3"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_3"
                      }
                    },
                    {
                      "when": {
                        "west": "true",
                        "stage": "0"
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
                        "stage": "1"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_1",
                        "y": 270,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "west": "true",
                        "stage": "2"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_2",
                        "y": 270,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "west": "true",
                        "stage": "3"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_3",
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
                        "stage": "0"
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
                        "stage": "1"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_1",
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
                        "stage": "2"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_2",
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
                        "stage": "3"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_3",
                        "y": 270,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "south": "true",
                        "stage": "0"
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
                        "stage": "1"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_1",
                        "y": 180,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "south": "true",
                        "stage": "2"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_2",
                        "y": 180,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "south": "true",
                        "stage": "3"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_3",
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
                        "stage": "0"
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
                        "stage": "1"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_1",
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
                        "stage": "2"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_2",
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
                        "stage": "3"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_3",
                        "y": 180,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "east": "true",
                        "stage": "0"
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
                        "stage": "1"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_1",
                        "y": 90,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "east": "true",
                        "stage": "2"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_2",
                        "y": 90,
                        "uvlock": true
                      }
                    },
                    {
                      "when": {
                        "east": "true",
                        "stage": "3"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_3",
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
                        "stage": "0"
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
                        "stage": "1"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_1",
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
                        "stage": "2"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_2",
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
                        "stage": "3"
                      },
                      "apply": {
                        "model": "%modid%:block/%name%_3",
                        "y": 90,
                        "uvlock": true
                      }
                    }
                  ]
                }
                """;
    }
}
