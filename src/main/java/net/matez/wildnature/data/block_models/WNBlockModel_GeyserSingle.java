/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_GeyserSingle extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_GeyserSingle(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "textures": {
                     "1": "%texture%_top",
                     "2": "%texture%_side",
                     "4": "minecraft:block/water_still",
                     "5": "minecraft:block/magma",
                     "particle": "minecraft:block/stone"
                   },
                   "elements": [
                     {
                       "from": [
                         0,
                         0,
                         0
                       ],
                       "to": [
                         16,
                         16,
                         4
                       ],
                       "faces": {
                         "north": {
                           "uv": [
                             0,
                             0,
                             16,
                             16
                           ],
                           "texture": "#2"
                         },
                         "east": {
                           "uv": [
                             0,
                             0,
                             4,
                             16
                           ],
                           "texture": "#2"
                         },
                         "south": {
                           "uv": [
                             0,
                             0,
                             16,
                             16
                           ],
                           "texture": "#2"
                         },
                         "west": {
                           "uv": [
                             0,
                             0,
                             4,
                             16
                           ],
                           "texture": "#2"
                         },
                         "up": {
                           "uv": [
                             0,
                             0,
                             16,
                             4
                           ],
                           "texture": "#1"
                         },
                         "down": {
                           "uv": [
                             0,
                             0,
                             16,
                             4
                           ],
                           "texture": "#5"
                         }
                       }
                     },
                     {
                       "from": [
                         0,
                         0,
                         12
                       ],
                       "to": [
                         16,
                         16,
                         16
                       ],
                       "faces": {
                         "north": {
                           "uv": [
                             0,
                             0,
                             16,
                             16
                           ],
                           "texture": "#2"
                         },
                         "east": {
                           "uv": [
                             0,
                             0,
                             4,
                             16
                           ],
                           "texture": "#2"
                         },
                         "south": {
                           "uv": [
                             0,
                             0,
                             16,
                             16
                           ],
                           "texture": "#2"
                         },
                         "west": {
                           "uv": [
                             0,
                             0,
                             4,
                             16
                           ],
                           "texture": "#2"
                         },
                         "up": {
                           "uv": [
                             0,
                             12,
                             16,
                             16
                           ],
                           "texture": "#1"
                         },
                         "down": {
                           "uv": [
                             0,
                             0,
                             16,
                             4
                           ],
                           "texture": "#5"
                         }
                       }
                     },
                     {
                       "from": [
                         0,
                         0,
                         4
                       ],
                       "to": [
                         4,
                         16,
                         12
                       ],
                       "faces": {
                         "north": {
                           "uv": [
                             0,
                             0,
                             3,
                             16
                           ],
                           "texture": "#2"
                         },
                         "east": {
                           "uv": [
                             0,
                             0,
                             8,
                             16
                           ],
                           "texture": "#2"
                         },
                         "south": {
                           "uv": [
                             0,
                             0,
                             3,
                             16
                           ],
                           "texture": "#2"
                         },
                         "west": {
                           "uv": [
                             0,
                             0,
                             8,
                             16
                           ],
                           "texture": "#2"
                         },
                         "up": {
                           "uv": [
                             0,
                             4,
                             4,
                             12
                           ],
                           "texture": "#1"
                         },
                         "down": {
                           "uv": [
                             0,
                             0,
                             3,
                             8
                           ],
                           "texture": "#5"
                         }
                       }
                     },
                     {
                       "from": [
                         12,
                         0,
                         4
                       ],
                       "to": [
                         16,
                         16,
                         12
                       ],
                       "faces": {
                         "north": {
                           "uv": [
                             0,
                             0,
                             4,
                             16
                           ],
                           "texture": "#2"
                         },
                         "east": {
                           "uv": [
                             0,
                             0,
                             8,
                             16
                           ],
                           "texture": "#2"
                         },
                         "south": {
                           "uv": [
                             0,
                             0,
                             4,
                             16
                           ],
                           "texture": "#2"
                         },
                         "west": {
                           "uv": [
                             0,
                             0,
                             8,
                             16
                           ],
                           "texture": "#2"
                         },
                         "up": {
                           "uv": [
                             12,
                             4,
                             16,
                             12
                           ],
                           "texture": "#1"
                         },
                         "down": {
                           "uv": [
                             0,
                             0,
                             4,
                             8
                           ],
                           "texture": "#5"
                         }
                       }
                     },
                     {
                       "from": [
                         4,
                         0,
                         4
                       ],
                       "to": [
                         12,
                         12,
                         12
                       ],
                       "faces": {
                         "north": {
                           "uv": [
                             0,
                             0,
                             8,
                             12
                           ],
                           "texture": "#2"
                         },
                         "east": {
                           "uv": [
                             0,
                             0,
                             8,
                             12
                           ],
                           "texture": "#2"
                         },
                         "south": {
                           "uv": [
                             0,
                             0,
                             8,
                             12
                           ],
                           "texture": "#2"
                         },
                         "west": {
                           "uv": [
                             0,
                             0,
                             8,
                             12
                           ],
                           "texture": "#2"
                         },
                         "up": {
                           "uv": [
                             0,
                             0,
                             8,
                             8
                           ],
                           "texture": "#1"
                         },
                         "down": {
                           "uv": [
                             0,
                             0,
                             8,
                             8
                           ],
                           "texture": "#5"
                         }
                       }
                     },
                     {
                       "from": [
                         4,
                         12,
                         4
                       ],
                       "to": [
                         12,
                         16,
                         12
                       ],
                       "faces": {
                         "north": {
                           "uv": [
                             0,
                             0,
                             8,
                             4
                           ],
                           "texture": "#4",
                           "tintindex": 0
                         },
                         "east": {
                           "uv": [
                             0,
                             0,
                             8,
                             4
                           ],
                           "texture": "#4",
                           "tintindex": 0
                         },
                         "south": {
                           "uv": [
                             0,
                             0,
                             8,
                             4
                           ],
                           "texture": "#4",
                           "tintindex": 0
                         },
                         "west": {
                           "uv": [
                             0,
                             0,
                             8,
                             4
                           ],
                           "texture": "#4",
                           "tintindex": 0
                         },
                         "up": {
                           "uv": [
                             0,
                             0,
                             8,
                             8
                           ],
                           "texture": "#4",
                           "tintindex": 0
                         },
                         "down": {
                           "uv": [
                             0,
                             0,
                             8,
                             8
                           ],
                           "texture": "#4",
                           "tintindex": 0
                         }
                       }
                     }
                   ],
                      "display": {
                        "thirdperson_righthand": {
                          "rotation": [
                            75,
                            45,
                            0
                          ],
                          "translation": [
                            0,
                            2.5,
                            0
                          ],
                          "scale": [
                            0.375,
                            0.375,
                            0.375
                          ]
                        },
                        "thirdperson_lefthand": {
                          "rotation": [
                            75,
                            45,
                            0
                          ],
                          "translation": [
                            0,
                            2.5,
                            0
                          ],
                          "scale": [
                            0.375,
                            0.375,
                            0.375
                          ]
                        },
                        "firstperson_righthand": {
                          "rotation": [
                            0,
                            45,
                            0
                          ],
                          "scale": [
                            0.4,
                            0.4,
                            0.4
                          ]
                        },
                        "firstperson_lefthand": {
                          "rotation": [
                            0,
                            225,
                            0
                          ],
                          "scale": [
                            0.4,
                            0.4,
                            0.4
                          ]
                        },
                        "ground": {
                          "translation": [
                            0,
                            3,
                            0
                          ],
                          "scale": [
                            0.25,
                            0.25,
                            0.25
                          ]
                        },
                        "gui": {
                          "rotation": [
                            30,
                            225,
                            0
                          ],
                          "scale": [
                            0.625,
                            0.625,
                            0.625
                          ]
                        },
                        "fixed": {
                          "scale": [
                            0.5,
                            0.5,
                            0.5
                          ]
                        }
                      }
                 }
                """;
    }
}
