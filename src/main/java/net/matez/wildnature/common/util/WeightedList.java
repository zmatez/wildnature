/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class WeightedList<T> extends LinkedHashMap<T, Integer> {
    public T getWeightedEntry() {
        if (!(size() == 0)) {
            var objects = new ArrayList<>(this.keySet());
            int x = WNUtil.rint(0, objects.size() - 1);

            return objects.get(x);
        }
        return null;
    }

    public T getWeightedEntry(Random rand) {
        if (!(size() == 0)) {
            var objects = new ArrayList<>(this.keySet());
            int x = WNUtil.rint(0, objects.size() - 1, rand);

            return objects.get(x);
        }
        return null;
    }

    public ArrayList<T> getAllWithWeight(int weight) {
        ArrayList<T> list = new ArrayList<>();
        forEach((entry, rarity) -> {
            if (rarity == weight) {
                list.add(entry);
            }
        });
        return list;
    }
}
