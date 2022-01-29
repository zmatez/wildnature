/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_TableTop extends WNBlockModel {
    public WNTBlockModel_TableTop() {
        super("table_top");
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
                                   13,
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
                                           12,
                                           0,
                                           15,
                                           16
                                       ],
                                       "rotation": 90,
                                       "texture": "#texture"
                                   },
                                   "east": {
                                       "uv": [
                                           13,
                                           0,
                                           16,
                                           16
                                       ],
                                       "rotation": 90,
                                       "texture": "#texture"
                                   },
                                   "south": {
                                       "uv": [
                                           13,
                                           0,
                                           16,
                                           16
                                       ],
                                       "rotation": 90,
                                       "texture": "#texture"
                                   },
                                   "west": {
                                       "uv": [
                                           3,
                                           0,
                                           0,
                                           16
                                       ],
                                       "rotation": 90,
                                       "texture": "#texture"
                                   },
                                   "up": {
                                       "uv": [
                                           0,
                                           0,
                                           16,
                                           16
                                       ],
                                       "texture": "#texture"
                                   },
                                   "down": {
                                       "uv": [
                                           0,
                                           0,
                                           16,
                                           16
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
