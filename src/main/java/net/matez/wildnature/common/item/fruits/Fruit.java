/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.fruits;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

import javax.annotation.Nullable;

public enum Fruit {
    PARADISE_APPLE("paradise_apple", Foods.APPLE),
    CHERRY("cherry", Foods.APPLE),
    GREEN_APPLE("green_apple", Foods.APPLE),
    MIRABELLE_PLUM("mirabelle_plum", Foods.APPLE),
    PEAR("pear", Foods.APPLE),
    PLUM("plum", Foods.APPLE),

    BANANA("banana", Foods.APPLE),
    GRAPEFRUIT("grapefruit", Foods.APPLE),
    LEMON("lemon", Foods.APPLE),
    LIME("lime", Foods.APPLE),
    MANGO("mango", Foods.APPLE),
    OLIVES("olives", Foods.APPLE),
    ORANGE("orange", Foods.APPLE),
    PEACH("peach", Foods.APPLE),
    PINEAPPLE("pineapple", Foods.APPLE),
    POMEGRANATE("pomegranate", Foods.APPLE),

    PURPLE_GRAPES("purple_grapes", Foods.APPLE),
    YELLOW_GRAPES("yellow_grapes", Foods.APPLE),

    BILBERRIES("bilberries", Foods.SWEET_BERRIES),
    BLACK_CURRANT("black_currant", Foods.APPLE),
    BLACKBERRIES("blackberries", Foods.APPLE),
    BLUEBERRIES("blueberries", Foods.APPLE),
    CHOKEBERRIES("chokeberries", Foods.APPLE),
    CRANBERRIES("cranberries", Foods.APPLE),
    COFFEEBERRY("coffeeberry",null),
    ELDERBERRIES("elderberries", Foods.APPLE),
    GOOSEBERRIES("gooseberries", Foods.APPLE),
    HAWTHORN_BERRIES("hawthorn_berries", Foods.APPLE),
    KAMCHATKA_BERRIES("kamchatka_berries", Foods.APPLE),
    LINGONBERRIES("lingonberries", Foods.APPLE),
    QUINCE_FRUIT("quince_fruit", Foods.APPLE),
    RASPBERRY("raspberry", Foods.APPLE),
    RED_CURRANT("red_currant", Foods.APPLE),
    WHITE_CURRANT("white_currant", Foods.APPLE),
    STRAWBERRY("strawberry", Foods.APPLE),

    BELLADONNA("belladonna_fruit", (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.POISON, 400, 0), 0.5F).build()),
    WILD_ROSE("wild_rose_fruit", Foods.APPLE),
    ORANGE_ROWANBERRIES_CLUSTER("orange_rowanberries_cluster", null),
    RED_ROWANBERRIES_CLUSTER("red_rowanberries_cluster", null),
    ORANGE_ROWANBERRIES("orange_rowanberries", Foods.APPLE),
    RED_ROWANBERRIES("red_rowanberries", Foods.APPLE),
    ;

    private final String id;
    @Nullable
    private final FoodProperties food;

    Fruit(String id, @Nullable FoodProperties food) {
        this.id = id;
        this.food = food;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public FoodProperties getFood() {
        return food;
    }
}
