/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.mushrooms;

public enum Mushroom {
    BIRCH_BOLETE("birch_bolete_mushroom",MushroomType.NORMAL),
    BOLETUS("boletus_mushroom",MushroomType.NORMAL),
    CHAMPIGNON("champignon_mushroom",MushroomType.NORMAL),
    CHANTERELLE("chanterelle_mushroom",MushroomType.NORMAL),
    DEATH_CAP("death_cap_mushroom",MushroomType.NORMAL),
    PINE_BOLETUS_MUSHROOM("pine_boletus_mushroom",MushroomType.NORMAL),
    PSILOCYBIN_MUSHROOM("psilocybin_mushroom",MushroomType.NORMAL,true),
    PUFFBALL_MUSHROOM("puffball_mushroom",MushroomType.PUFFBALL),
    SAFFRON_MILK_CAP("saffron_milk_cap_mushroom",MushroomType.NORMAL),
    SLIPPERY_JACK("slippery_jack_mushroom",MushroomType.NORMAL),
    TOADSTOOL_MUSHROOM("toadstool_mushroom",MushroomType.NORMAL,true),
    TREE_FUNGUS("tree_fungus",MushroomType.TREE),
    ;
    private final String id;
    private final MushroomType type;
    private final boolean isPoisonous;

    Mushroom(String id, MushroomType type, boolean isPoisonous) {
        this.id = id;
        this.type = type;
        this.isPoisonous = isPoisonous;
    }

    Mushroom(String id, MushroomType type){
        this(id,type,false);
    }

    public String getId() {
        return id;
    }

    public MushroomType getType() {
        return type;
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }
}
