/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.leaves;

import net.matez.wildnature.common.block.ModelSupplier;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.function.Supplier;

public class LeafConfig {
    public static Supplier<LeafConfig> SIMPLE = () -> new LeafConfig(0,false);
    private final int stages;
    private final boolean flowering;
    private boolean isBush = false;
    private final ArrayList<ModelSupplier> customModels = new ArrayList<>();
    @Nullable
    private ModelSupplier itemModel = null;
    private boolean itemTinted = true;

    private final LinkedHashMap<Integer, ItemConfig> stageDrops = new LinkedHashMap<>();

    public LeafConfig(int stages, boolean flowering) {
        this.stages = stages;
        this.flowering = flowering;
    }

    public LeafConfig with(int stage, Supplier<Item> item, int min, int max){
        stageDrops.put(stage,new ItemConfig(min,max,item));
        return this;
    }

    public int getStages() {
        return stages;
    }

    public boolean isFlowering() {
        return flowering;
    }

    public LinkedHashMap<Integer, ItemConfig> getStageDrops() {
        return stageDrops;
    }

    public boolean isBush() {
        return isBush;
    }

    public LeafConfig model(ModelSupplier supplier){
        customModels.add(supplier);
        return this;
    }

    public LeafConfig itemModel(ModelSupplier supplier){
        this.itemModel = supplier;
        return this;
    }

    @Nullable
    public ModelSupplier getItemModel() {
        return itemModel;
    }

    public ArrayList<ModelSupplier> getCustomModels() {
        return customModels;
    }

    public LeafConfig makeItemNotTinted(){
        this.itemTinted = false;
        return this;
    }

    public boolean isItemTinted() {
        return itemTinted;
    }

    public static class ItemConfig{
        private final int min;
        private final int max;
        private final Supplier<Item> item;

        public ItemConfig(int min, int max, Supplier<Item> item) {
            this.min = min;
            this.max = max;
            this.item = item;
        }

        public int getMax() {
            return max;
        }

        public int getMin() {
            return min;
        }

        public Supplier<Item> getItem() {
            return item;
        }
    }
}
