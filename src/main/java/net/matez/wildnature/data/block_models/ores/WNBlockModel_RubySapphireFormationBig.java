/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.ores;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_RubySapphireFormationBig extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_RubySapphireFormationBig(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                          "textures": {
                            "1": "%texture%",
                            "2": "block/stone",
                            "particle": "block/stone"
                          },
                          "elements": [
                            {
                              "from": [
                                4.55884,
                                -0.02289,
                                10.94929
                              ],
                              "to": [
                                9.55884,
                                2.97711,
                                14.94929
                              ],
                              "rotation": {
                                "angle": 0,
                                "axis": "y",
                                "origin": [
                                  8.12321,
                                  1.73932,
                                  8.37439
                                ]
                              },
                              "faces": {
                                "north": {
                                  "uv": [
                                    5,
                                    8,
                                    8,
                                    13
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "east": {
                                  "uv": [
                                    2,
                                    7,
                                    5,
                                    11
                                  ],
                                  "rotation": 90,
                                  "texture": "#2"
                                },
                                "south": {
                                  "uv": [
                                    1,
                                    9,
                                    4,
                                    14
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "west": {
                                  "uv": [
                                    6,
                                    7,
                                    9,
                                    11
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "up": {
                                  "uv": [
                                    4,
                                    7,
                                    9,
                                    11
                                  ],
                                  "texture": "#2"
                                }
                              }
                            },
                            {
                              "from": [
                                5.55884,
                                -0.02289,
                                0.94929
                              ],
                              "to": [
                                10.55884,
                                2.97711,
                                4.94929
                              ],
                              "rotation": {
                                "angle": 0,
                                "axis": "y",
                                "origin": [
                                  8.12321,
                                  1.73932,
                                  8.37439
                                ]
                              },
                              "faces": {
                                "north": {
                                  "uv": [
                                    5,
                                    8,
                                    8,
                                    13
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "east": {
                                  "uv": [
                                    2,
                                    7,
                                    5,
                                    11
                                  ],
                                  "rotation": 90,
                                  "texture": "#2"
                                },
                                "south": {
                                  "uv": [
                                    1,
                                    9,
                                    4,
                                    14
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "west": {
                                  "uv": [
                                    6,
                                    7,
                                    9,
                                    11
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "up": {
                                  "uv": [
                                    4,
                                    7,
                                    9,
                                    11
                                  ],
                                  "texture": "#2"
                                }
                              }
                            },
                            {
                              "from": [
                                1.0625,
                                0,
                                2.375
                              ],
                              "to": [
                                9.3125,
                                1,
                                6.375
                              ],
                              "rotation": {
                                "angle": 0,
                                "axis": "y",
                                "origin": [
                                  8.12321,
                                  1.73932,
                                  8.37439
                                ]
                              },
                              "faces": {
                                "north": {
                                  "uv": [
                                    3,
                                    7,
                                    4,
                                    15.25
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "east": {
                                  "uv": [
                                    4,
                                    7,
                                    5,
                                    11
                                  ],
                                  "rotation": 90,
                                  "texture": "#2"
                                },
                                "south": {
                                  "uv": [
                                    6,
                                    7,
                                    7,
                                    15.25
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "west": {
                                  "uv": [
                                    6,
                                    9,
                                    7,
                                    13
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "up": {
                                  "uv": [
                                    1,
                                    12,
                                    9.25,
                                    16
                                  ],
                                  "texture": "#2"
                                }
                              }
                            },
                            {
                              "from": [
                                1.80884,
                                0,
                                4.9493
                              ],
                              "to": [
                                8.80884,
                                5,
                                10.9493
                              ],
                              "rotation": {
                                "angle": 0,
                                "axis": "y",
                                "origin": [
                                  8.12321,
                                  1.73932,
                                  8.37439
                                ]
                              },
                              "faces": {
                                "north": {
                                  "uv": [
                                    4,
                                    4,
                                    9,
                                    11
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "east": {
                                  "uv": [
                                    3,
                                    4,
                                    8,
                                    10
                                  ],
                                  "rotation": 90,
                                  "texture": "#2"
                                },
                                "south": {
                                  "uv": [
                                    5,
                                    6,
                                    10,
                                    13
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "west": {
                                  "uv": [
                                    10,
                                    6,
                                    16,
                                    11
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "up": {
                                  "uv": [
                                    1,
                                    4,
                                    8,
                                    10
                                  ],
                                  "texture": "#2"
                                }
                              }
                            },
                            {
                              "from": [
                                9.55884,
                                -0.02289,
                                8.94929
                              ],
                              "to": [
                                14.55884,
                                1.97711,
                                11.94929
                              ],
                              "rotation": {
                                "angle": 0,
                                "axis": "y",
                                "origin": [
                                  8.12321,
                                  1.73932,
                                  8.37439
                                ]
                              },
                              "faces": {
                                "north": {
                                  "uv": [
                                    5,
                                    8,
                                    7,
                                    13
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "east": {
                                  "uv": [
                                    6,
                                    12,
                                    8,
                                    15
                                  ],
                                  "rotation": 90,
                                  "texture": "#2"
                                },
                                "south": {
                                  "uv": [
                                    0,
                                    8,
                                    2,
                                    13
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "west": {
                                  "uv": [
                                    5,
                                    9,
                                    7,
                                    12
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "up": {
                                  "uv": [
                                    0,
                                    8,
                                    5,
                                    11
                                  ],
                                  "texture": "#2"
                                }
                              }
                            },
                            {
                              "from": [
                                8.55884,
                                -0.02289,
                                3.94929
                              ],
                              "to": [
                                15.55884,
                                3.97711,
                                8.94929
                              ],
                              "rotation": {
                                "angle": 0,
                                "axis": "y",
                                "origin": [
                                  8.12321,
                                  1.73932,
                                  8.37439
                                ]
                              },
                              "faces": {
                                "north": {
                                  "uv": [
                                    5,
                                    8,
                                    9,
                                    15
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "east": {
                                  "uv": [
                                    1,
                                    6,
                                    5,
                                    11
                                  ],
                                  "rotation": 90,
                                  "texture": "#2"
                                },
                                "south": {
                                  "uv": [
                                    2,
                                    7,
                                    6,
                                    14
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "west": {
                                  "uv": [
                                    1,
                                    11,
                                    5,
                                    16
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "up": {
                                  "uv": [
                                    9,
                                    9,
                                    16,
                                    14
                                  ],
                                  "texture": "#2"
                                }
                              }
                            },
                            {
                              "from": [
                                10.5,
                                3,
                                3.125
                              ],
                              "to": [
                                13.5,
                                6,
                                6.125
                              ],
                              "rotation": {
                                "angle": -22.5,
                                "axis": "x",
                                "origin": [
                                  11.5,
                                  5.5,
                                  5.875
                                ]
                              },
                              "faces": {
                                "north": {
                                  "uv": [
                                    4,
                                    3,
                                    7,
                                    6
                                  ],
                                  "rotation": 270,
                                  "texture": "#1"
                                },
                                "east": {
                                  "uv": [
                                    1,
                                    3,
                                    4,
                                    6
                                  ],
                                  "texture": "#1"
                                },
                                "south": {
                                  "uv": [
                                    13,
                                    13,
                                    16,
                                    16
                                  ],
                                  "texture": "#1"
                                },
                                "west": {
                                  "uv": [
                                    10,
                                    13,
                                    13,
                                    16
                                  ],
                                  "texture": "#1"
                                },
                                "up": {
                                  "uv": [
                                    5,
                                    13,
                                    8,
                                    16
                                  ],
                                  "texture": "#1"
                                },
                                "down": {
                                  "uv": [
                                    2,
                                    7,
                                    5,
                                    10
                                  ],
                                  "rotation": 180,
                                  "texture": "#1"
                                }
                              }
                            },
                            {
                              "from": [
                                3.80884,
                                3.48702,
                                6.66157
                              ],
                              "to": [
                                7.80884,
                                7.48702,
                                10.66157
                              ],
                              "rotation": {
                                "angle": 22.5,
                                "axis": "z",
                                "origin": [
                                  5.74634,
                                  2.48702,
                                  8.66157
                                ]
                              },
                              "faces": {
                                "north": {
                                  "uv": [
                                    16,
                                    12,
                                    12,
                                    16
                                  ],
                                  "texture": "#1"
                                },
                                "east": {
                                  "uv": [
                                    4,
                                    12,
                                    0,
                                    16
                                  ],
                                  "texture": "#1"
                                },
                                "south": {
                                  "uv": [
                                    4,
                                    16,
                                    8,
                                    12
                                  ],
                                  "rotation": 270,
                                  "texture": "#1"
                                },
                                "west": {
                                  "uv": [
                                    8,
                                    12,
                                    12,
                                    16
                                  ],
                                  "texture": "#1"
                                },
                                "up": {
                                  "uv": [
                                    16,
                                    12,
                                    12,
                                    16
                                  ],
                                  "texture": "#1"
                                },
                                "down": {
                                  "uv": [
                                    0,
                                    5,
                                    4,
                                    9
                                  ],
                                  "rotation": 180,
                                  "texture": "#1"
                                }
                              }
                            },
                            {
                              "from": [
                                3.0625,
                                0,
                                0.875
                              ],
                              "to": [
                                5.0625,
                                3,
                                2.875
                              ],
                              "rotation": {
                                "angle": -22.5,
                                "axis": "x",
                                "origin": [
                                  3.24634,
                                  2.70737,
                                  3.87895
                                ]
                              },
                              "faces": {
                                "north": {
                                  "uv": [
                                    12,
                                    2,
                                    15,
                                    4
                                  ],
                                  "rotation": 270,
                                  "texture": "#1"
                                },
                                "east": {
                                  "uv": [
                                    2,
                                    1,
                                    5,
                                    3
                                  ],
                                  "rotation": 90,
                                  "texture": "#1"
                                },
                                "south": {
                                  "uv": [
                                    3,
                                    3,
                                    6,
                                    5
                                  ],
                                  "rotation": 270,
                                  "texture": "#1"
                                },
                                "west": {
                                  "uv": [
                                    14,
                                    15,
                                    11,
                                    13
                                  ],
                                  "rotation": 90,
                                  "texture": "#1"
                                },
                                "up": {
                                  "uv": [
                                    14,
                                    13,
                                    16,
                                    15
                                  ],
                                  "texture": "#1"
                                }
                              }
                            },
                            {
                              "from": [
                                1.32936,
                                -1.12447,
                                11.92394
                              ],
                              "to": [
                                3.32936,
                                2.87553,
                                13.92394
                              ],
                              "rotation": {
                                "angle": 22.5,
                                "axis": "z",
                                "origin": [
                                  2.26686,
                                  0.37553,
                                  12.92394
                                ]
                              },
                              "faces": {
                                "north": {
                                  "uv": [
                                    4,
                                    4,
                                    8,
                                    6
                                  ],
                                  "rotation": 270,
                                  "texture": "#1"
                                },
                                "east": {
                                  "uv": [
                                    6,
                                    7,
                                    8,
                                    3
                                  ],
                                  "texture": "#1"
                                },
                                "south": {
                                  "uv": [
                                    1,
                                    13,
                                    5,
                                    15
                                  ],
                                  "rotation": 270,
                                  "texture": "#1"
                                },
                                "west": {
                                  "uv": [
                                    12,
                                    15,
                                    16,
                                    13
                                  ],
                                  "rotation": 270,
                                  "texture": "#1"
                                },
                                "up": {
                                  "uv": [
                                    6,
                                    12,
                                    8,
                                    14
                                  ],
                                  "texture": "#1"
                                },
                                "down": {
                                  "uv": [
                                    5,
                                    8,
                                    7,
                                    10
                                  ],
                                  "rotation": 180,
                                  "texture": "#1"
                                }
                              }
                            },
                            {
                              "from": [
                                10.55884,
                                -0.02289,
                                10.94929
                              ],
                              "to": [
                                13.55884,
                                2.97711,
                                14.94929
                              ],
                              "rotation": {
                                "angle": -45,
                                "axis": "x",
                                "origin": [
                                  11.99634,
                                  1.47711,
                                  12.94929
                                ]
                              },
                              "faces": {
                                "north": {
                                  "uv": [
                                    1,
                                    3,
                                    4,
                                    6
                                  ],
                                  "rotation": 270,
                                  "texture": "#2"
                                },
                                "east": {
                                  "uv": [
                                    8,
                                    12,
                                    4,
                                    15
                                  ],
                                  "texture": "#1"
                                },
                                "south": {
                                  "uv": [
                                    16,
                                    12,
                                    13,
                                    15
                                  ],
                                  "texture": "#1"
                                },
                                "west": {
                                  "uv": [
                                    4,
                                    4,
                                    8,
                                    7
                                  ],
                                  "texture": "#1"
                                },
                                "up": {
                                  "uv": [
                                    8,
                                    12,
                                    5,
                                    16
                                  ],
                                  "texture": "#1"
                                },
                                "down": {
                                  "uv": [
                                    10,
                                    12,
                                    13,
                                    16
                                  ],
                                  "rotation": 180,
                                  "texture": "#1"
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
                              "rotation": [
                                1,
                                141,
                                0
                              ],
                              "translation": [
                                -9,
                                2,
                                -8.75
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
                              "name": "group",
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
                                    8,
                                    8,
                                    8
                                  ],
                                  "color": 0,
                                  "children": [
                                    0,
                                    1,
                                    2,
                                    3,
                                    4,
                                    5
                                  ]
                                },
                                {
                                  "name": "gem",
                                  "origin": [
                                    7,
                                    3.25,
                                    15
                                  ],
                                  "color": 0,
                                  "children": [
                                    6,
                                    7,
                                    8,
                                    9,
                                    10
                                  ]
                                }
                              ]
                            }
                          ]
                        }
                """;
    }
}
