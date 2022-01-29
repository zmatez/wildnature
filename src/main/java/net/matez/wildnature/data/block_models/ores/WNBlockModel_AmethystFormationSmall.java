/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.ores;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_AmethystFormationSmall extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_AmethystFormationSmall(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                     "textures": {
                       "3": "%texture%_stone",
                       "4": "%texture%_crystals_small",
                       "particle":"%texture%_crystals_small"
                     },
                     "elements": [
                       {
                         "from": [
                           5.5,
                           3.5,
                           5.5
                         ],
                         "to": [
                           7.5,
                           9.5,
                           7.5
                         ],
                         "rotation": {
                           "angle": 22.5,
                           "axis": "z",
                           "origin": [
                             7.51168,
                             3.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               0,
                               9,
                               2,
                               15
                             ],
                             "texture": "#4"
                           },
                           "east": {
                             "uv": [
                               9,
                               8,
                               10.938,
                               14
                             ],
                             "texture": "#4"
                           },
                           "south": {
                             "uv": [
                               0,
                               8,
                               1.938,
                               14
                             ],
                             "texture": "#4"
                           },
                           "west": {
                             "uv": [
                               9,
                               8,
                               11,
                               14
                             ],
                             "texture": "#4"
                           },
                           "up": {
                             "uv": [
                               3,
                               1,
                               5,
                               3
                             ],
                             "texture": "#4"
                           },
                           "down": {
                             "uv": [
                               0,
                               0,
                               1.625,
                               1.6875
                             ],
                             "texture": "#4"
                           }
                         }
                       },
                       {
                         "from": [
                           3.15368,
                           1.2194,
                           8
                         ],
                         "to": [
                           5.15368,
                           11.2194,
                           10
                         ],
                         "rotation": {
                           "angle": 22.5,
                           "axis": "z",
                           "origin": [
                             4.15368,
                             6.2194,
                             9
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               14,
                               5,
                               16,
                               15
                             ],
                             "texture": "#4"
                           },
                           "east": {
                             "uv": [
                               14,
                               5,
                               16,
                               15
                             ],
                             "texture": "#4"
                           },
                           "south": {
                             "uv": [
                               12,
                               5,
                               14,
                               15
                             ],
                             "texture": "#4"
                           },
                           "west": {
                             "uv": [
                               12,
                               5,
                               14,
                               15
                             ],
                             "texture": "#4"
                           },
                           "up": {
                             "uv": [
                               3,
                               1,
                               5,
                               3
                             ],
                             "texture": "#4"
                           },
                           "down": {
                             "uv": [
                               3,
                               6,
                               5,
                               8
                             ],
                             "texture": "#4"
                           }
                         }
                       },
                       {
                         "from": [
                           7.5,
                           2.5,
                           8
                         ],
                         "to": [
                           9.5,
                           12.5,
                           10
                         ],
                         "rotation": {
                           "angle": 22.5,
                           "axis": "x",
                           "origin": [
                             7.51168,
                             3.50966,
                             8.56115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               14,
                               5,
                               15.938,
                               15
                             ],
                             "texture": "#4"
                           },
                           "east": {
                             "uv": [
                               14,
                               5,
                               16,
                               15
                             ],
                             "texture": "#4"
                           },
                           "south": {
                             "uv": [
                               12,
                               5,
                               14,
                               15
                             ],
                             "texture": "#4"
                           },
                           "west": {
                             "uv": [
                               12,
                               5,
                               14,
                               15
                             ],
                             "texture": "#4"
                           },
                           "up": {
                             "uv": [
                               3,
                               1,
                               5,
                               3
                             ],
                             "rotation": 90,
                             "texture": "#4"
                           },
                           "down": {
                             "uv": [
                               0,
                               0,
                               1.6875,
                               1.4375
                             ],
                             "rotation": 270,
                             "texture": "#4"
                           }
                         }
                       },
                       {
                         "from": [
                           7,
                           1,
                           6.5
                         ],
                         "to": [
                           9,
                           15,
                           8.5
                         ],
                         "rotation": {
                           "angle": 0,
                           "axis": "y",
                           "origin": [
                             7.51168,
                             3.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               3,
                               1,
                               5,
                               15
                             ],
                             "texture": "#4"
                           },
                           "east": {
                             "uv": [
                               3,
                               1,
                               5,
                               15
                             ],
                             "texture": "#4"
                           },
                           "south": {
                             "uv": [
                               6,
                               1,
                               8,
                               15
                             ],
                             "texture": "#4"
                           },
                           "west": {
                             "uv": [
                               3,
                               1,
                               5,
                               15
                             ],
                             "texture": "#4"
                           },
                           "up": {
                             "uv": [
                               3,
                               1,
                               5,
                               3
                             ],
                             "rotation": 90,
                             "texture": "#4"
                           },
                           "down": {
                             "uv": [
                               0,
                               0,
                               1.5,
                               1.5
                             ],
                             "rotation": 270,
                             "texture": "#4"
                           }
                         }
                       },
                       {
                         "from": [
                           11,
                           1,
                           6.5
                         ],
                         "to": [
                           13,
                           11,
                           8.5
                         ],
                         "rotation": {
                           "angle": -22.5,
                           "axis": "z",
                           "origin": [
                             9.01168,
                             2.00966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               14,
                               5,
                               16,
                               15
                             ],
                             "texture": "#4"
                           },
                           "east": {
                             "uv": [
                               12,
                               5,
                               14,
                               15
                             ],
                             "texture": "#4"
                           },
                           "south": {
                             "uv": [
                               12,
                               5,
                               14,
                               15
                             ],
                             "texture": "#4"
                           },
                           "west": {
                             "uv": [
                               14,
                               5,
                               16,
                               15
                             ],
                             "texture": "#4"
                           },
                           "up": {
                             "uv": [
                               3,
                               1,
                               5,
                               3
                             ],
                             "texture": "#4"
                           },
                           "down": {
                             "uv": [
                               0,
                               0,
                               1.5,
                               1.5
                             ],
                             "texture": "#4"
                           }
                         }
                       },
                       {
                         "from": [
                           10,
                           2,
                           4.5
                         ],
                         "to": [
                           12,
                           7,
                           6.5
                         ],
                         "rotation": {
                           "angle": -22.5,
                           "axis": "x",
                           "origin": [
                             7.51168,
                             0.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               0,
                               9,
                               2,
                               14
                             ],
                             "texture": "#4"
                           },
                           "east": {
                             "uv": [
                               9,
                               9,
                               11,
                               14
                             ],
                             "texture": "#4"
                           },
                           "south": {
                             "uv": [
                               9,
                               9,
                               10.938,
                               14
                             ],
                             "texture": "#4"
                           },
                           "west": {
                             "uv": [
                               9,
                               9,
                               11,
                               14
                             ],
                             "texture": "#4"
                           },
                           "up": {
                             "uv": [
                               3,
                               1,
                               5,
                               3
                             ],
                             "texture": "#4"
                           },
                           "down": {
                             "uv": [
                               0,
                               0,
                               1.5,
                               1.5625
                             ],
                             "texture": "#4"
                           }
                         }
                       },
                       {
                         "from": [
                           7.5,
                           2.5,
                           5
                         ],
                         "to": [
                           9.5,
                           10.5,
                           7
                         ],
                         "rotation": {
                           "angle": -22.5,
                           "axis": "x",
                           "origin": [
                             7.51168,
                             3.50966,
                             8.06115
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
                             "texture": "#4"
                           },
                           "east": {
                             "uv": [
                               9,
                               7,
                               11,
                               15
                             ],
                             "texture": "#4"
                           },
                           "south": {
                             "uv": [
                               3,
                               6,
                               5,
                               14
                             ],
                             "texture": "#4"
                           },
                           "west": {
                             "uv": [
                               9,
                               7,
                               11,
                               15
                             ],
                             "texture": "#4"
                           },
                           "up": {
                             "uv": [
                               3,
                               1,
                               5,
                               3
                             ],
                             "rotation": 90,
                             "texture": "#4"
                           },
                           "down": {
                             "uv": [
                               0,
                               0,
                               1.3125,
                               1.4375
                             ],
                             "rotation": 270,
                             "texture": "#4"
                           }
                         }
                       },
                       {
                         "from": [
                           7.5,
                           2,
                           10.5
                         ],
                         "to": [
                           9.5,
                           10,
                           12.5
                         ],
                         "rotation": {
                           "angle": 45,
                           "axis": "x",
                           "origin": [
                             7.51168,
                             3.50966,
                             8.06115
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
                             "texture": "#4"
                           },
                           "east": {
                             "uv": [
                               9,
                               7,
                               11,
                               15
                             ],
                             "texture": "#4"
                           },
                           "south": {
                             "uv": [
                               0,
                               7,
                               1.938,
                               15
                             ],
                             "texture": "#4"
                           },
                           "west": {
                             "uv": [
                               0,
                               7,
                               2,
                               15
                             ],
                             "texture": "#4"
                           },
                           "up": {
                             "uv": [
                               3,
                               1,
                               5,
                               3
                             ],
                             "rotation": 180,
                             "texture": "#4"
                           },
                           "down": {
                             "uv": [
                               12,
                               12,
                               14,
                               14
                             ],
                             "rotation": 180,
                             "texture": "#4"
                           }
                         }
                       },
                       {
                         "from": [
                           4.75,
                           2.92363,
                           10.13364
                         ],
                         "to": [
                           6.75,
                           5.92363,
                           12.13364
                         ],
                         "rotation": {
                           "angle": 22.5,
                           "axis": "x",
                           "origin": [
                             7.51168,
                             2.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               0,
                               10,
                               2,
                               13
                             ],
                             "texture": "#4"
                           },
                           "east": {
                             "uv": [
                               9,
                               10,
                               11,
                               13
                             ],
                             "texture": "#4"
                           },
                           "south": {
                             "uv": [
                               3,
                               11,
                               5,
                               14
                             ],
                             "texture": "#4"
                           },
                           "west": {
                             "uv": [
                               0,
                               9,
                               2,
                               12
                             ],
                             "texture": "#4"
                           },
                           "up": {
                             "uv": [
                               3,
                               1,
                               5,
                               3
                             ],
                             "rotation": 180,
                             "texture": "#4"
                           },
                           "down": {
                             "uv": [
                               0,
                               0,
                               1.5625,
                               1.6875
                             ],
                             "rotation": 180,
                             "texture": "#4"
                           }
                         }
                       },
                       {
                         "from": [
                           10,
                           2,
                           8.5
                         ],
                         "to": [
                           12,
                           6,
                           10.5
                         ],
                         "rotation": {
                           "angle": 22.5,
                           "axis": "x",
                           "origin": [
                             7.51168,
                             2.50966,
                             7.56115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               3,
                               10,
                               5,
                               14
                             ],
                             "texture": "#4"
                           },
                           "east": {
                             "uv": [
                               9,
                               10,
                               11,
                               14
                             ],
                             "texture": "#4"
                           },
                           "south": {
                             "uv": [
                               3,
                               9,
                               5,
                               13
                             ],
                             "texture": "#4"
                           },
                           "west": {
                             "uv": [
                               9,
                               9,
                               11,
                               13
                             ],
                             "texture": "#4"
                           },
                           "up": {
                             "uv": [
                               3,
                               1,
                               5,
                               3
                             ],
                             "texture": "#4"
                           },
                           "down": {
                             "uv": [
                               0,
                               0,
                               1,
                               1.25
                             ],
                             "texture": "#4"
                           }
                         }
                       },
                       {
                         "from": [
                           5.21548,
                           -0.56396,
                           2
                         ],
                         "to": [
                           7.21548,
                           3.43604,
                           4
                         ],
                         "rotation": {
                           "angle": -45,
                           "axis": "x",
                           "origin": [
                             7.71548,
                             2.18604,
                             3.5
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               9,
                               9,
                               11,
                               13
                             ],
                             "texture": "#4"
                           },
                           "east": {
                             "uv": [
                               9,
                               10,
                               11,
                               14
                             ],
                             "texture": "#4"
                           },
                           "south": {
                             "uv": [
                               3,
                               5,
                               5,
                               9
                             ],
                             "texture": "#4"
                           },
                           "west": {
                             "uv": [
                               9,
                               9,
                               11,
                               13
                             ],
                             "texture": "#4"
                           },
                           "up": {
                             "uv": [
                               3,
                               1,
                               5,
                               3
                             ],
                             "texture": "#4"
                           },
                           "down": {
                             "uv": [
                               12,
                               13,
                               14,
                               15
                             ],
                             "texture": "#4"
                           }
                         }
                       },
                       {
                         "from": [
                           4.5,
                           1.5,
                           9.5
                         ],
                         "to": [
                           6.5,
                           3.5,
                           12.5
                         ],
                         "rotation": {
                           "angle": 22.5,
                           "axis": "x",
                           "origin": [
                             7.51168,
                             2.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               6,
                               5,
                               8,
                               7
                             ],
                             "texture": "#3"
                           },
                           "east": {
                             "uv": [
                               7,
                               5,
                               10,
                               7
                             ],
                             "texture": "#3"
                           },
                           "south": {
                             "uv": [
                               10,
                               4,
                               12,
                               6
                             ],
                             "texture": "#3"
                           },
                           "west": {
                             "uv": [
                               6,
                               8,
                               9,
                               10
                             ],
                             "rotation": 180,
                             "texture": "#3"
                           },
                           "up": {
                             "uv": [
                               6,
                               3,
                               9,
                               5
                             ],
                             "rotation": 90,
                             "texture": "#3"
                           },
                           "down": {
                             "uv": [
                               7,
                               6,
                               9,
                               9
                             ],
                             "rotation": 180,
                             "texture": "#3"
                           }
                         }
                       },
                       {
                         "from": [
                           5,
                           1,
                           5
                         ],
                         "to": [
                           7,
                           3,
                           8
                         ],
                         "rotation": {
                           "angle": 0,
                           "axis": "y",
                           "origin": [
                             7.51168,
                             2.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               10,
                               5,
                               12,
                               7
                             ],
                             "texture": "#3"
                           },
                           "east": {
                             "uv": [
                               9,
                               5,
                               12,
                               7
                             ],
                             "texture": "#3"
                           },
                           "south": {
                             "uv": [
                               8,
                               8,
                               10,
                               10
                             ],
                             "texture": "#3"
                           },
                           "west": {
                             "uv": [
                               6,
                               5,
                               9,
                               7
                             ],
                             "texture": "#3"
                           },
                           "up": {
                             "uv": [
                               9,
                               3,
                               11,
                               5.5
                             ],
                             "texture": "#3"
                           },
                           "down": {
                             "uv": [
                               8,
                               6,
                               10,
                               9
                             ],
                             "texture": "#3"
                           }
                         }
                       },
                       {
                         "from": [
                           5.5,
                           0,
                           8
                         ],
                         "to": [
                           10.5,
                           2,
                           13
                         ],
                         "rotation": {
                           "angle": 0,
                           "axis": "y",
                           "origin": [
                             7.51168,
                             2.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               7,
                               7,
                               12,
                               9
                             ],
                             "texture": "#3"
                           },
                           "east": {
                             "uv": [
                               12,
                               5,
                               7,
                               7
                             ],
                             "texture": "#3"
                           },
                           "south": {
                             "uv": [
                               6,
                               5,
                               11,
                               7
                             ],
                             "texture": "#3"
                           },
                           "west": {
                             "uv": [
                               6,
                               7,
                               11,
                               9
                             ],
                             "texture": "#3"
                           },
                           "up": {
                             "uv": [
                               6,
                               3,
                               11,
                               8
                             ],
                             "texture": "#3"
                           },
                           "down": {
                             "uv": [
                               7,
                               5,
                               12,
                               10
                             ],
                             "texture": "#3"
                           }
                         }
                       },
                       {
                         "from": [
                           6.5,
                           0,
                           8
                         ],
                         "to": [
                           9.5,
                           2,
                           10
                         ],
                         "rotation": {
                           "angle": 0,
                           "axis": "y",
                           "origin": [
                             7.51168,
                             2.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               8,
                               6,
                               11,
                               8
                             ],
                             "texture": "#3"
                           },
                           "east": {
                             "uv": [
                               6,
                               8,
                               8,
                               10
                             ],
                             "texture": "#3"
                           },
                           "south": {
                             "uv": [
                               6,
                               5,
                               9,
                               7
                             ],
                             "texture": "#3"
                           },
                           "west": {
                             "uv": [
                               10,
                               4,
                               12,
                               6
                             ],
                             "texture": "#3"
                           },
                           "up": {
                             "uv": [
                               9,
                               3,
                               12,
                               5
                             ],
                             "texture": "#3"
                           },
                           "down": {
                             "uv": [
                               6,
                               6,
                               9,
                               8
                             ],
                             "texture": "#3"
                           }
                         }
                       },
                       {
                         "from": [
                           8,
                           0,
                           5
                         ],
                         "to": [
                           11,
                           1.8125,
                           9
                         ],
                         "rotation": {
                           "angle": 0,
                           "axis": "y",
                           "origin": [
                             8.51168,
                             2.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               9,
                               6,
                               12,
                               8
                             ],
                             "texture": "#3"
                           },
                           "east": {
                             "uv": [
                               6,
                               4,
                               10,
                               6
                             ],
                             "texture": "#3"
                           },
                           "south": {
                             "uv": [
                               7,
                               5,
                               10,
                               7
                             ],
                             "texture": "#3"
                           },
                           "west": {
                             "uv": [
                               6,
                               5,
                               10,
                               7
                             ],
                             "texture": "#3"
                           },
                           "up": {
                             "uv": [
                               8,
                               3,
                               12,
                               6
                             ],
                             "rotation": 90,
                             "texture": "#3"
                           },
                           "down": {
                             "uv": [
                               6,
                               6,
                               9,
                               10
                             ],
                             "texture": "#3"
                           }
                         }
                       },
                       {
                         "from": [
                           9.5,
                           0,
                           3.5
                         ],
                         "to": [
                           12.5,
                           2,
                           6.5
                         ],
                         "rotation": {
                           "angle": 0,
                           "axis": "y",
                           "origin": [
                             7.51168,
                             2.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               8,
                               6,
                               11,
                               8
                             ],
                             "texture": "#3"
                           },
                           "east": {
                             "uv": [
                               6,
                               6,
                               9,
                               8
                             ],
                             "texture": "#3"
                           },
                           "south": {
                             "uv": [
                               9,
                               5,
                               12,
                               7
                             ],
                             "texture": "#3"
                           },
                           "west": {
                             "uv": [
                               8,
                               8,
                               11,
                               10
                             ],
                             "texture": "#3"
                           },
                           "up": {
                             "uv": [
                               7,
                               6,
                               10,
                               9
                             ],
                             "texture": "#3"
                           },
                           "down": {
                             "uv": [
                               7,
                               6,
                               10,
                               9
                             ],
                             "texture": "#3"
                           }
                         }
                       },
                       {
                         "from": [
                           2.5,
                           0,
                           8
                         ],
                         "to": [
                           5.5,
                           2,
                           11
                         ],
                         "rotation": {
                           "angle": 0,
                           "axis": "y",
                           "origin": [
                             7.51168,
                             2.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               8,
                               5,
                               11,
                               7
                             ],
                             "texture": "#3"
                           },
                           "east": {
                             "uv": [
                               6,
                               4,
                               9,
                               6
                             ],
                             "texture": "#3"
                           },
                           "south": {
                             "uv": [
                               8,
                               6,
                               11,
                               8
                             ],
                             "texture": "#3"
                           },
                           "west": {
                             "uv": [
                               6,
                               5,
                               9,
                               7
                             ],
                             "texture": "#3"
                           },
                           "up": {
                             "uv": [
                               6,
                               3,
                               9,
                               6
                             ],
                             "texture": "#3"
                           },
                           "down": {
                             "uv": [
                               7,
                               6,
                               10,
                               9
                             ],
                             "texture": "#3"
                           }
                         }
                       },
                       {
                         "from": [
                           10.5,
                           0,
                           8
                         ],
                         "to": [
                           12.5,
                           2,
                           10
                         ],
                         "rotation": {
                           "angle": 0,
                           "axis": "y",
                           "origin": [
                             8.51168,
                             2.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               10,
                               8,
                               12,
                               10
                             ],
                             "texture": "#3"
                           },
                           "east": {
                             "uv": [
                               9,
                               5,
                               11,
                               7
                             ],
                             "texture": "#3"
                           },
                           "south": {
                             "uv": [
                               8,
                               6,
                               10,
                               8
                             ],
                             "texture": "#3"
                           },
                           "west": {
                             "uv": [
                               7,
                               8,
                               9,
                               10
                             ],
                             "texture": "#3"
                           },
                           "up": {
                             "uv": [
                               6,
                               5,
                               8,
                               7
                             ],
                             "texture": "#3"
                           },
                           "down": {
                             "uv": [
                               8,
                               6,
                               10,
                               8
                             ],
                             "texture": "#3"
                           }
                         }
                       },
                       {
                         "from": [
                           4.5,
                           0,
                           4.5
                         ],
                         "to": [
                           7.5,
                           2,
                           8.5
                         ],
                         "rotation": {
                           "angle": 0,
                           "axis": "y",
                           "origin": [
                             7.51168,
                             2.50966,
                             8.06115
                           ]
                         },
                         "faces": {
                           "north": {
                             "uv": [
                               9,
                               6,
                               12,
                               8
                             ],
                             "texture": "#3"
                           },
                           "east": {
                             "uv": [
                               7,
                               8,
                               11,
                               10
                             ],
                             "texture": "#3"
                           },
                           "south": {
                             "uv": [
                               7,
                               5,
                               10,
                               7
                             ],
                             "texture": "#3"
                           },
                           "west": {
                             "uv": [
                               7,
                               4,
                               11,
                               6
                             ],
                             "texture": "#3"
                           },
                           "up": {
                             "uv": [
                               6,
                               2,
                               10,
                               5
                             ],
                             "rotation": 90,
                             "texture": "#3"
                           },
                           "down": {
                             "uv": [
                               6,
                               6,
                               9,
                               10
                             ],
                             "texture": "#3"
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
                           2.25
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
                           2.5
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
                         "translation": [
                           0,
                           2.75,
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
                         "translation": [
                           0,
                           2.75,
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
                           2.5,
                           0
                         ],
                         "scale": [
                           0.5,
                           0.5,
                           0.5
                         ]
                       },
                       "gui": {
                         "rotation": [
                           21,
                           25,
                           0
                         ],
                         "translation": [
                           0,
                           1.25,
                           0
                         ],
                         "scale": [
                           0.8,
                           0.8,
                           0.8
                         ]
                       },
                       "head": {
                         "translation": [
                           0,
                           13.25,
                           0
                         ]
                       },
                       "fixed": {
                         "rotation": [
                           -90,
                           0,
                           0
                         ],
                         "translation": [
                           0,
                           0,
                           -8.25
                         ]
                       }
                     },
                     "groups": [
                       {
                         "name": "Amethyst biggus dickus",
                         "origin": [
                           8,
                           8,
                           8
                         ],
                         "color": 0,
                         "children": [
                           {
                             "name": "Crystals",
                             "origin": [
                               6.75,
                               3,
                               5.4375
                             ],
                             "color": 0,
                             "children": [
                               0,
                               1,
                               2,
                               3,
                               4,
                               5,
                               6,
                               7,
                               8,
                               9,
                               10
                             ]
                           },
                           {
                             "name": "Stone",
                             "origin": [
                               8,
                               8,
                               8
                             ],
                             "color": 0,
                             "children": [
                               11,
                               12,
                               13,
                               14,
                               15,
                               16,
                               17,
                               18,
                               19
                             ]
                           }
                         ]
                       }
                     ]
                   }
                """;
    }
}
