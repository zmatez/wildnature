package net.matez.wildnature.common.util;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

public class WeightedList<T> {
    private final ArrayList<T> objects;
    private final ArrayList<Integer> rarity;

    public WeightedList() {
        objects = new ArrayList<>();
        rarity = new ArrayList<>();
    }

    public WeightedList<T> add(T obj, int rarity) {
        this.objects.add(obj);
        this.rarity.add(rarity);
        return this;
    }

    public void clear() {
        this.objects.clear();
        this.rarity.clear();
    }

    public int getRarityFor(T obj) {
        return checkIfEquals() ? rarity.get(objects.indexOf(obj)) : -1;
    }

    public boolean isEmpty() {
        return checkIfEquals() && objects.isEmpty();
    }

    public Integer size() {
        if (checkIfEquals()) {
            return objects.size();
        } else {
            throw new NullPointerException("Array sizes doesn't match! " + objects.size() + "/" + rarity.size());
        }
    }

    public boolean checkIfEquals() {
        return objects.size() == rarity.size();
    }

    public ArrayList<Integer> getRarity() {
        return rarity;
    }

    public ArrayList<T> getObjects() {
        return objects;
    }

    public ArrayList<T> getSimplifiedArray() {
        ArrayList<T> simplified = new ArrayList<>();
        int x = 0;
        while (x < this.size()) {
            int a = this.getRarity().get(x);
            int z = 0;
            while (z < a) {
                simplified.add(this.getObjects().get(x));
                z++;
            }
            x++;
        }


        return simplified;
    }

    public void forEach(Consumer<? super T> action) {
        objects.forEach(action);
    }

    public T getWeightedEntry() {
        if (!(size() == 0)) {
            ArrayList<T> objects = getSimplifiedArray();
            int x = WNUtil.rint(0, objects.size() - 1);

            return objects.get(x);
        }
        return null;
    }

    public T getWeightedEntry(Random rand) {
        if (!(size() == 0)) {
            ArrayList<T> objects = getSimplifiedArray();
            int x = WNUtil.rint(0, objects.size() - 1, rand);

            return objects.get(x);
        }
        return null;
    }
}
