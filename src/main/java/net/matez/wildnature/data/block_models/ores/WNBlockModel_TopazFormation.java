/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.ores;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_TopazFormation extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_TopazFormation(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                        "textures": {
                          "1": "block/stone",
                          "2": "%texture%",
                          "particle": "%texture%"
                        },
                        "elements": [
                          {
                            "from": [
                              12,
                              0,
                              5
                            ],
                            "to": [
                              16,
                              2,
                              12
                            ],
                            "rotation": {
                              "angle": 0,
                              "axis": "y",
                              "origin": [
                                8.05,
                                1.21561,
                                7.98445
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  8,
                                  3,
                                  12,
                                  5
                                ],
                                "texture": "#1"
                              },
                              "east": {
                                "uv": [
                                  8,
                                  14,
                                  15,
                                  16
                                ],
                                "texture": "#1"
                              },
                              "south": {
                                "uv": [
                                  8,
                                  14,
                                  12,
                                  16
                                ],
                                "texture": "#1"
                              },
                              "west": {
                                "uv": [
                                  9,
                                  1,
                                  16,
                                  3
                                ],
                                "texture": "#1"
                              },
                              "up": {
                                "uv": [
                                  6,
                                  6,
                                  13,
                                  10
                                ],
                                "rotation": 90,
                                "texture": "#1"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  7,
                                  4
                                ],
                                "rotation": 270,
                                "texture": "#1"
                              }
                            }
                          },
                          {
                            "from": [
                              5,
                              0,
                              12
                            ],
                            "to": [
                              14,
                              3,
                              16
                            ],
                            "rotation": {
                              "angle": 0,
                              "axis": "x",
                              "origin": [
                                8.05,
                                1.21561,
                                7.98445
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  0,
                                  0,
                                  9,
                                  3
                                ],
                                "texture": "#1"
                              },
                              "east": {
                                "uv": [
                                  8,
                                  12,
                                  12,
                                  15
                                ],
                                "texture": "#1"
                              },
                              "south": {
                                "uv": [
                                  6,
                                  10,
                                  15,
                                  13
                                ],
                                "texture": "#1"
                              },
                              "west": {
                                "uv": [
                                  4,
                                  8,
                                  8,
                                  11
                                ],
                                "texture": "#1"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  10,
                                  9,
                                  6
                                ],
                                "texture": "#1"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  9,
                                  4
                                ],
                                "texture": "#1"
                              }
                            }
                          },
                          {
                            "from": [
                              1,
                              0,
                              2
                            ],
                            "to": [
                              5,
                              2,
                              13
                            ],
                            "rotation": {
                              "angle": 0,
                              "axis": "y",
                              "origin": [
                                8.05,
                                1.21561,
                                7.98445
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  0,
                                  0,
                                  4,
                                  2
                                ],
                                "texture": "#1"
                              },
                              "east": {
                                "uv": [
                                  5,
                                  8,
                                  16,
                                  10
                                ],
                                "texture": "#1"
                              },
                              "south": {
                                "uv": [
                                  1,
                                  4,
                                  5,
                                  6
                                ],
                                "texture": "#1"
                              },
                              "west": {
                                "uv": [
                                  5,
                                  13,
                                  16,
                                  15
                                ],
                                "texture": "#1"
                              },
                              "up": {
                                "uv": [
                                  3,
                                  1,
                                  7,
                                  12
                                ],
                                "texture": "#1"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  4,
                                  11
                                ],
                                "texture": "#1"
                              }
                            }
                          },
                          {
                            "from": [
                              5,
                              0,
                              5
                            ],
                            "to": [
                              12,
                              7,
                              12
                            ],
                            "rotation": {
                              "angle": 0,
                              "axis": "y",
                              "origin": [
                                8.05,
                                1.21561,
                                7.98445
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  3,
                                  8,
                                  10,
                                  15
                                ],
                                "rotation": 180,
                                "texture": "#1"
                              },
                              "east": {
                                "uv": [
                                  8,
                                  1,
                                  15,
                                  8
                                ],
                                "texture": "#1"
                              },
                              "south": {
                                "uv": [
                                  7,
                                  8,
                                  14,
                                  15
                                ],
                                "texture": "#1"
                              },
                              "west": {
                                "uv": [
                                  8,
                                  7,
                                  15,
                                  14
                                ],
                                "texture": "#1"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  7,
                                  7,
                                  14
                                ],
                                "rotation": 180,
                                "texture": "#1"
                              },
                              "down": {
                                "uv": [
                                  2,
                                  1,
                                  9,
                                  8
                                ],
                                "rotation": 180,
                                "texture": "#1"
                              }
                            }
                          },
                          {
                            "from": [
                              5,
                              0,
                              1
                            ],
                            "to": [
                              12,
                              3,
                              5
                            ],
                            "rotation": {
                              "angle": 0,
                              "axis": "y",
                              "origin": [
                                8.05,
                                1.21561,
                                7.98445
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  8,
                                  10,
                                  15,
                                  13
                                ],
                                "texture": "#1"
                              },
                              "east": {
                                "uv": [
                                  9,
                                  13,
                                  13,
                                  16
                                ],
                                "texture": "#1"
                              },
                              "south": {
                                "uv": [
                                  6,
                                  3,
                                  13,
                                  6
                                ],
                                "texture": "#1"
                              },
                              "west": {
                                "uv": [
                                  1,
                                  3,
                                  5,
                                  6
                                ],
                                "texture": "#1"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  5,
                                  7,
                                  9
                                ],
                                "texture": "#1"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  7,
                                  4
                                ],
                                "texture": "#1"
                              }
                            }
                          },
                          {
                            "from": [
                              3.5,
                              3,
                              6.5
                            ],
                            "to": [
                              5.5,
                              9,
                              8.5
                            ],
                            "rotation": {
                              "angle": 22.5,
                              "axis": "z",
                              "origin": [
                                8.05,
                                1.21561,
                                7.98445
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  3,
                                  3,
                                  5,
                                  9
                                ],
                                "texture": "#2"
                              },
                              "east": {
                                "uv": [
                                  0,
                                  5,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "south": {
                                "uv": [
                                  3,
                                  6,
                                  5,
                                  12
                                ],
                                "texture": "#2"
                              },
                              "west": {
                                "uv": [
                                  0,
                                  5,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  6
                                ],
                                "texture": "#2"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  2,
                                  2
                                ],
                                "texture": "#2"
                              }
                            }
                          },
                          {
                            "from": [
                              6.5,
                              3,
                              9.5
                            ],
                            "to": [
                              8.5,
                              10,
                              11.5
                            ],
                            "rotation": {
                              "angle": 22.5,
                              "axis": "z",
                              "origin": [
                                8.05,
                                1.21561,
                                7.98445
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "east": {
                                "uv": [
                                  0,
                                  3,
                                  2,
                                  10
                                ],
                                "texture": "#2"
                              },
                              "south": {
                                "uv": [
                                  0,
                                  3,
                                  2,
                                  10
                                ],
                                "texture": "#2"
                              },
                              "west": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  6
                                ],
                                "texture": "#2"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  2,
                                  2
                                ],
                                "texture": "#2"
                              }
                            }
                          },
                          {
                            "from": [
                              9.5,
                              3,
                              5.5
                            ],
                            "to": [
                              11.5,
                              10,
                              7.5
                            ],
                            "rotation": {
                              "angle": -22.5,
                              "axis": "z",
                              "origin": [
                                9.5,
                                6.5,
                                6.5
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "east": {
                                "uv": [
                                  0,
                                  3,
                                  2,
                                  10
                                ],
                                "texture": "#2"
                              },
                              "south": {
                                "uv": [
                                  0,
                                  3,
                                  2,
                                  10
                                ],
                                "texture": "#2"
                              },
                              "west": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  6
                                ],
                                "texture": "#2"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  2,
                                  2
                                ],
                                "texture": "#2"
                              }
                            }
                          },
                          {
                            "from": [
                              5.5,
                              2,
                              2.5
                            ],
                            "to": [
                              7.5,
                              5,
                              4.5
                            ],
                            "rotation": {
                              "angle": 22.5,
                              "axis": "z",
                              "origin": [
                                8.05,
                                1.21561,
                                7.98445
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  0,
                                  7,
                                  2,
                                  10
                                ],
                                "texture": "#2"
                              },
                              "east": {
                                "uv": [
                                  0,
                                  5,
                                  2,
                                  8
                                ],
                                "texture": "#2"
                              },
                              "south": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  7
                                ],
                                "texture": "#2"
                              },
                              "west": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  7
                                ],
                                "texture": "#2"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  6
                                ],
                                "texture": "#2"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  2,
                                  2
                                ],
                                "texture": "#2"
                              }
                            }
                          },
                          {
                            "from": [
                              7,
                              2,
                              5
                            ],
                            "to": [
                              9,
                              9,
                              7
                            ],
                            "rotation": {
                              "angle": -22.5,
                              "axis": "x",
                              "origin": [
                                8.05,
                                1.21561,
                                7.98445
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  0,
                                  5,
                                  2,
                                  12
                                ],
                                "texture": "#2"
                              },
                              "east": {
                                "uv": [
                                  0,
                                  3,
                                  2,
                                  10
                                ],
                                "texture": "#2"
                              },
                              "south": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "west": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  6
                                ],
                                "texture": "#2"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  3,
                                  3
                                ],
                                "texture": "#2"
                              }
                            }
                          },
                          {
                            "from": [
                              7,
                              3,
                              7
                            ],
                            "to": [
                              9,
                              11,
                              9
                            ],
                            "rotation": {
                              "angle": 0,
                              "axis": "x",
                              "origin": [
                                8.05,
                                1.21561,
                                7.98445
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  3,
                                  4,
                                  5,
                                  12
                                ],
                                "texture": "#2"
                              },
                              "east": {
                                "uv": [
                                  0,
                                  3,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "south": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  12
                                ],
                                "texture": "#2"
                              },
                              "west": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  12
                                ],
                                "texture": "#2"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  6
                                ],
                                "texture": "#2"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  2,
                                  2
                                ],
                                "texture": "#2"
                              }
                            }
                          },
                          {
                            "from": [
                              9,
                              3,
                              11
                            ],
                            "to": [
                              11,
                              11,
                              13
                            ],
                            "rotation": {
                              "angle": 22.5,
                              "axis": "x",
                              "origin": [
                                10,
                                7,
                                11
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  0,
                                  7,
                                  2,
                                  15
                                ],
                                "texture": "#2"
                              },
                              "east": {
                                "uv": [
                                  0,
                                  3,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "south": {
                                "uv": [
                                  0,
                                  3,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "west": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  12
                                ],
                                "texture": "#2"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  6
                                ],
                                "texture": "#2"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  2,
                                  2
                                ],
                                "texture": "#2"
                              }
                            }
                          },
                          {
                            "from": [
                              11,
                              1,
                              10
                            ],
                            "to": [
                              13,
                              6,
                              12
                            ],
                            "rotation": {
                              "angle": -22.5,
                              "axis": "z",
                              "origin": [
                                12,
                                1,
                                10
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  9
                                ],
                                "texture": "#2"
                              },
                              "east": {
                                "uv": [
                                  0,
                                  7,
                                  2,
                                  12
                                ],
                                "texture": "#2"
                              },
                              "south": {
                                "uv": [
                                  0,
                                  6,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "west": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  9
                                ],
                                "texture": "#2"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  6
                                ],
                                "texture": "#2"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  2,
                                  2
                                ],
                                "texture": "#2"
                              }
                            }
                          },
                          {
                            "from": [
                              11,
                              1,
                              5
                            ],
                            "to": [
                              13,
                              4,
                              7
                            ],
                            "rotation": {
                              "angle": -22.5,
                              "axis": "x",
                              "origin": [
                                8,
                                1,
                                6
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  0,
                                  8,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "east": {
                                "uv": [
                                  0,
                                  11,
                                  2,
                                  14
                                ],
                                "texture": "#2"
                              },
                              "south": {
                                "uv": [
                                  0,
                                  7,
                                  2,
                                  10
                                ],
                                "texture": "#2"
                              },
                              "west": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  7
                                ],
                                "texture": "#2"
                              },
                              "up": {
                                "uv": [
                                  0,
                                  6,
                                  2,
                                  8
                                ],
                                "rotation": 270,
                                "texture": "#2"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  2,
                                  2
                                ],
                                "rotation": 90,
                                "texture": "#2"
                              }
                            }
                          },
                          {
                            "from": [
                              6,
                              2.31846,
                              11.6246
                            ],
                            "to": [
                              8,
                              7.31846,
                              13.6246
                            ],
                            "rotation": {
                              "angle": 22.5,
                              "axis": "x",
                              "origin": [
                                8.05,
                                1.21561,
                                7.98445
                              ]
                            },
                            "faces": {
                              "north": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  9
                                ],
                                "texture": "#2"
                              },
                              "east": {
                                "uv": [
                                  0,
                                  6,
                                  2,
                                  11
                                ],
                                "texture": "#2"
                              },
                              "south": {
                                "uv": [
                                  3,
                                  10,
                                  5,
                                  15
                                ],
                                "texture": "#2"
                              },
                              "west": {
                                "uv": [
                                  0,
                                  4,
                                  2,
                                  9
                                ],
                                "texture": "#2"
                              },
                              "up": {
                                "uv": [
                                  3,
                                  3,
                                  5,
                                  5
                                ],
                                "texture": "#2"
                              },
                              "down": {
                                "uv": [
                                  0,
                                  0,
                                  2,
                                  2
                                ],
                                "texture": "#2"
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
                          "head": {
                            "translation": [
                              0,
                              13.75,
                              0
                            ]
                          },
                          "fixed": {
                            "scale": [
                              0.5,
                              0.5,
                              0.5
                            ]
                          }
                        },
                        "groups": [
                          {
                            "name": "Malachite",
                            "origin": [
                              8,
                              8,
                              8
                            ],
                            "color": 0,
                            "children": [
                              {
                                "name": "stone",
                                "origin": [
                                  8.05,
                                  1.21561,
                                  7.98445
                                ],
                                "color": 0,
                                "children": [
                                  0,
                                  1,
                                  2,
                                  3,
                                  4
                                ]
                              },
                              {
                                "name": "crystal",
                                "origin": [
                                  8.05,
                                  1.21561,
                                  7.98445
                                ],
                                "color": 0,
                                "children": [
                                  5,
                                  6,
                                  7,
                                  8,
                                  9,
                                  10,
                                  11,
                                  12,
                                  13,
                                  14
                                ]
                              }
                            ]
                          }
                        ]
                      }
                """;
    }
}
