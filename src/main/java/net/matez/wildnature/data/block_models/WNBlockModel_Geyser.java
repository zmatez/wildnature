/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Geyser extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_Geyser(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                     "textures": {
                       "1": "%texture%_top",
                       "2": "%texture%_side",
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
                               16,
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
                               16,
                               16
                             ],
                             "texture": "#2"
                           },
                           "up": {
                             "uv": [
                               0,
                               0,
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
                               16
                             ],
                             "texture": "#5"
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
