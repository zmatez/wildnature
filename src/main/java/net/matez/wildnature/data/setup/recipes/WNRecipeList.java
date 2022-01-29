/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.setup.recipes;

import net.matez.wildnature.data.setup.base.WNIRecipe;

import java.util.ArrayList;
import java.util.Arrays;

public class WNRecipeList {
    private final ArrayList<WNIRecipe> recipes = new ArrayList<>();

    public WNRecipeList(WNIRecipe...recipes){
        with(recipes);
    }

    public WNRecipeList with(WNIRecipe...recipes){
        this.recipes.addAll(Arrays.asList(recipes));
        return this;
    }
}
