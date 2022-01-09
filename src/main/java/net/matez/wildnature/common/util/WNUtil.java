package net.matez.wildnature.common.util;

import java.util.Random;

public class WNUtil {
    public static int rint(int min, int max) {
        if (min == max) {
            return min;
        }

        if (min >= max) {
            return max;
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static int rint(int min, int max, Random rand) {
        if (min == max) {
            return min;
        }

        if (min >= max) {
            return max;
        }

        return rand.nextInt((max - min) + 1) + min;
    }

    public static double rdoub(double min, double max) {
        if (min == max) {
            return min;
        }

        if (min >= max) {
            return max;
        }

        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

    public static double rdoub(double min, double max, Random rand) {
        if (min == max) {
            return min;
        }

        if (min >= max) {
            return max;
        }

        return min + (max - min) * rand.nextDouble();
    }

    public static boolean iBetween(int rangeMin, int rangeMax, int number) {
        return number > rangeMin && number < rangeMax;
    }

    public static boolean dBetween(double rangeMin, double rangeMax, double number) {
        return number > rangeMin && number < rangeMax;
    }

    public static boolean chance(double percentChance) {
        double x = rdoub(0, 100);
        return percentChance >= x;
    }

    public static boolean chance(double percentChance, Random rand) {
        double x = rdoub(0, 100, rand);
        return percentChance <= x;
    }
}
