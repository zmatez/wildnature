/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;

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

    public static int rint(int min, int max, RandomSource rand) {
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

    public static double blockDistance(BlockPos pos1, BlockPos pos2) {
        return Math.sqrt(Math.pow(pos2.getX() - pos1.getX(), 2) + Math.pow(pos2.getY() - pos1.getY(), 2) + Math.pow(pos2.getZ() - pos1.getZ(), 2));
    }

    public static double xzDistance(Vec3 pos1, Vec3 pos2) {
        return Math.sqrt(Math.pow(pos1.x() - pos2.x(), 2) + Math.pow(pos1.z() - pos2.z(), 2));
    }
}
