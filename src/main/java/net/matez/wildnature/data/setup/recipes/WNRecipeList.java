package net.matez.wildnature.data.setup.recipes;

import net.matez.wildnature.data.setup.base.WNRecipe;

import java.util.ArrayList;
import java.util.Arrays;

public class WNRecipeList {
    private final ArrayList<WNRecipe> recipes = new ArrayList<>();

    public WNRecipeList(WNRecipe ...recipes){
        with(recipes);
    }

    public WNRecipeList with(WNRecipe ...recipes){
        this.recipes.addAll(Arrays.asList(recipes));
        return this;
    }
}
