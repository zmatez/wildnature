package net.matez.wildnature.common.objects.blocks.crops;

import net.matez.wildnature.common.objects.blocks.plant.BushConstructor;
import net.matez.wildnature.common.objects.blocks.plant.BushPlacement;
import net.matez.wildnature.common.objects.blocks.plant.config.BushConfig;
import net.matez.wildnature.common.objects.items.vegetables.Veggie;

import javax.annotation.Nullable;

public enum CropType {
    CABBAGE(Veggie.CABBAGE, 4),
    CAULIFLOWER(Veggie.CAULIFLOWER, 4),
    CORN(Veggie.CORN, 3, 0, new BushConfig().withPlacement(BushPlacement.DIRT), null, null, CropHelper.GIANT_CONSTRUCTOR),
    CUCUMBER(Veggie.CUCUMBER, 4),
    //EGGPLANT("eggplant"),
    GARLIC(Veggie.GARLIC, 4),
    GINGER(Veggie.GINGER, 4),
    GREEN_BEAN(Veggie.GREEN_BEANS, 3, 0, new BushConfig().withPlacement(BushPlacement.DIRT), "green_bean", null, CropHelper.GIANT_CONSTRUCTOR),
    ONION(Veggie.ONION, 6),
    PEANUT(Veggie.PEANUT, 3),
    RED_PEPPER(Veggie.RED_PEPPER, 6),
    RHUBARB(Veggie.RHUBARB, 4),
    RICE(Veggie.RICE, 5),
    TOMATO(Veggie.TOMATO, 8),
    TURNIP(Veggie.TURNIP, 4),

    HORSERADISH(Veggie.HORSERADISH, 1, 0, new BushConfig().withPlacement(BushPlacement.DIRT), null, null, CropHelper.SPREADING_CONSTRUCTOR),
    MINT(Veggie.MINT, 1, 0, new BushConfig().withPlacement(BushPlacement.DIRT), null, null, CropHelper.SPREADING_CONSTRUCTOR),

    BLACK_TEA_LEAVES(Veggie.BLACK_TEA_LEAVES, 2, 0, new BushConfig().withPlacement(BushPlacement.DIRT), "black_tea_plant", "tea", CropHelper.TEA_CONSTRUCTOR),
    GREEN_TEA_LEAVES(Veggie.GREEN_TEA_LEAVES, 2, 0, new BushConfig().withPlacement(BushPlacement.DIRT), "green_tea_plant", "tea", CropHelper.TEA_CONSTRUCTOR),
    MELISSA_TEA_LEAF(Veggie.MELISSA_TEA_LEAF, 2, 0, new BushConfig().withPlacement(BushPlacement.DIRT), "melissa_tea_plant", "tea", CropHelper.TEA_CONSTRUCTOR),

    ;
    private final Veggie veggie;
    private BushConfig config = new BushConfig().withPlacement(BushPlacement.FARMLAND);
    private int stages;
    private int maxDrop = 3;
    @Nullable
    private BushConstructor<CropType> blockConstructor;
    @Nullable
    private String id;
    @Nullable
    private String folder;

    CropType(Veggie veggie, int stages) {
        this.veggie = veggie;
        this.stages = stages;
    }

    CropType(Veggie veggie, int stages, int maxDrop, @Nullable BushConfig config, @Nullable String id, @Nullable String folder, @Nullable BushConstructor<CropType> blockConstructor) {
        this(veggie, stages);
        this.maxDrop = (maxDrop <= 0 ? this.maxDrop : maxDrop);

        if (config != null) {
            this.config = config;
        }
        if (id != null) {
            this.id = id;
        }
        if (folder != null) {
            this.folder = folder;
        }
        if (blockConstructor != null) {
            this.blockConstructor = blockConstructor;
        }
    }

    public Veggie getVeggie() {
        return veggie;
    }

    public String getId() {
        return this.id == null ? veggie.getId() : this.id;
    }

    public BushConfig getConfig() {
        return config;
    }

    public int getStages() {
        return stages;
    }

    public String getFolder() {
        return this.folder == null ? this.getId() : this.folder;
    }

    public int getMaxDrop() {
        return maxDrop;
    }

    @Nullable
    public BushConstructor<CropType> getBlockConstructor() {
        return blockConstructor;
    }
}
