/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.item_models.crossbow;

import net.matez.wildnature.data.setup.base.WNItemModel;

public class WNItemModel_Crossbow extends WNItemModel {
    /**
     * Required: @texture (+ _standby),@model
     */
    public WNItemModel_Crossbow(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                     "parent": "item/generated",
                     "textures": {
                         "layer0": "%texture%_standby"
                     },
                     "display": {
                         "thirdperson_righthand": {
                             "rotation": [ -90, 0, -60 ],
                             "translation": [ 2, 0.1, -3 ],
                             "scale": [ 0.9, 0.9, 0.9 ]
                         },
                         "thirdperson_lefthand": {
                             "rotation": [ -90, 0, 30 ],
                             "translation": [ 2, 0.1, -3 ],
                             "scale": [ 0.9, 0.9, 0.9 ]
                         },
                         "firstperson_righthand": {
                             "rotation": [ -90, 0, -55 ],
                             "translation": [ 1.13, 3.2, 1.13],
                             "scale": [ 0.68, 0.68, 0.68 ]
                         },
                         "firstperson_lefthand": {
                             "rotation": [ -90, 0, 35 ],
                             "translation": [ 1.13, 3.2, 1.13],
                             "scale": [ 0.68, 0.68, 0.68 ]
                         }
                     },
                     "overrides": [
                         {
                             "predicate": {
                                 "pulling": 1
                             },
                             "model": "%model%_pulling_0"
                         },
                         {
                             "predicate": {
                                 "pulling": 1,
                                 "pull": 0.58
                             },
                             "model": "%model%_pulling_1"
                         },
                         {
                             "predicate": {
                                 "pulling": 1,
                                 "pull": 1.0
                             },
                             "model": "%model%_pulling_2"
                         },
                         {
                             "predicate": {
                                 "charged": 1
                             },
                             "model": "%model%_arrow"
                         },
                         {
                             "predicate": {
                                 "charged": 1,
                                 "firework": 1
                             },
                             "model": "%model%_firework"
                         }
                     ]
                 }
                 
                """;
    }
}
