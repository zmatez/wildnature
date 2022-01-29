/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.items.setup;

import net.matez.wildnature.data.setup.base.WNResource;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemModelList {
    public final ArrayList<WNResource> models = new ArrayList<>();

    public ItemModelList with(WNResource... model) {
        models.addAll(Arrays.asList(model));
        return this;
    }
}