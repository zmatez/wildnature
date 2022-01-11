package net.matez.wildnature.common.objects.items.vegetables;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

import javax.annotation.Nullable;

public enum Veggie {
    CABBAGE("cabbage",Foods.CARROT),
    CAULIFLOWER("cauliflower",Foods.CARROT),
    CORN("corn",Foods.CARROT),
    CUCUMBER("cucumber",Foods.CARROT),
    EGGPLANT("eggplant",Foods.CARROT),
    GARLIC("garlic",Foods.CARROT),
    GINGER("ginger",Foods.CARROT),
    GREEN_BEANS("green_beans",Foods.CARROT),
    ONION("onion",Foods.CARROT),
    PEANUT("peanut",Foods.CARROT),
    RED_PEPPER("red_pepper",Foods.CARROT),
    RHUBARB("rhubarb",Foods.CARROT),
    RICE("rice",Foods.CARROT),
    TOMATO("tomato",Foods.CARROT),
    TURNIP("turnip",Foods.CARROT),

    HORSERADISH("horseradish",Foods.CARROT),
    MINT("mint",null),

    BLACK_TEA_LEAVES("black_tea_leaves",null),
    GREEN_TEA_LEAVES("green_tea_leaves",null),
    MELISSA_TEA_LEAF("melissa_tea_leaf",null),

    ;

    private final String id;
    @Nullable
    private final FoodProperties food;

    Veggie(String id, @Nullable FoodProperties food) {
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
