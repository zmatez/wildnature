/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.plant.config;

import net.matez.wildnature.common.objects.blocks.plant.BushPlacement;

import java.util.function.Supplier;

public class BushConfig {
    public static final Supplier<BushConfig> NOT_TINTED = () -> new BushConfig().notTinted();
    public static final Supplier<BushConfig> CAVE_BUSH_TINTED = () -> new BushConfig().withPlacement(BushPlacement.STONE);
    public static final Supplier<BushConfig> CAVE_BUSH = () -> new BushConfig().withPlacement(BushPlacement.STONE).notTinted();

    protected int bushShapeWidth;
    protected int bushShapeOffset;
    protected boolean tinted = true;
    protected boolean itemTinted = false;
    protected boolean itemAsSelf = false;
    protected boolean grassTint = true;
    protected BushPlacement placement = BushPlacement.DIRT;

    public BushConfig withShapeWidth(int newWidth){
        this.bushShapeWidth = newWidth;
        return this;
    }
    public BushConfig withShapeOffset(int newOffset){
        this.bushShapeOffset = newOffset;
        return this;
    }
    public BushConfig notTinted(){
        this.tinted = false;
        this.itemTinted = false;
        return this;
    }
    public BushConfig itemTinted(){
        this.itemTinted = true;
        return this;
    }
    public BushConfig makeSelfItem(){
        this.itemAsSelf = true;
        return this;
    }
    public BushConfig makeTintAsFoliage(){
        this.grassTint = false;
        return this;
    }
    public BushConfig withPlacement(BushPlacement placement){
        this.placement = placement;
        return this;
    }


    //-----

    public int getBushShapeOffset() {
        return bushShapeOffset;
    }

    public int getBushShapeWidth() {
        return bushShapeWidth;
    }

    public boolean isTinted(){
        return tinted;
    }

    public boolean isItemTinted() {
        return itemTinted;
    }

    public boolean isItemAsSelf() {
        return itemAsSelf;
    }

    public boolean isGrassTint() {
        return grassTint;
    }

    public BushPlacement getPlacement() {
        return placement;
    }
}
