/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_TableLeg extends WNBlockModel {
    public WNTBlockModel_TableLeg() {
        super("table_leg");
    }

    @Override
    public String getJSON() {
        return """
                {
                       "textures": {
                           "particle": "#texture"
                       },
                       "elements": [
                           {
                               "from": [
                                   0,
                                   0,
                                   0
                               ],
                               "to": [
                                   2,
                                   13,
                                   2
                               ],
                               "rotation": {
                                   "angle": 0,
                                   "axis": "y",
                                   "origin": [
                                       1,
                                       6.5,
                                       1
                                   ]
                               },
                               "faces": {
                                   "north": {
                                       "uv": [
                                           14,
                                           3,
                                           16,
                                           16
                                       ],
                                       "texture": "#texture"
                                   },
                                   "east": {
                                       "uv": [
                                           0,
                                           3,
                                           2,
                                           16
                                       ],
                                       "texture": "#texture"
                                   },
                                   "south": {
                                       "uv": [
                                           0,
                                           3,
                                           2,
                                           16
                                       ],
                                       "texture": "#texture"
                                   },
                                   "west": {
                                       "uv": [
                                           14,
                                           3,
                                           16,
                                           16
                                       ],
                                       "texture": "#texture"
                                   },
                                   "up": {
                                       "uv": [
                                           0,
                                           0,
                                           2,
                                           2
                                       ],
                                       "texture": "#texture"
                                   },
                                   "down": {
                                       "uv": [
                                           0,
                                           0,
                                           2,
                                           2
                                       ],
                                       "texture": "#texture"
                                   }
                               }
                           }
                       ]
                   }
                """;
    }
}
