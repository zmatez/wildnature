package net.matez.wildnature.common.objects.blocks.fruit_bush.plants;

import net.matez.wildnature.common.objects.blocks.fruit_bush.leaves.FruitBushType;
import net.matez.wildnature.common.objects.blocks.leaves.LeafConfig;
import net.matez.wildnature.common.objects.blocks.plant.BushConstructor;
import net.matez.wildnature.common.objects.blocks.plant.config.BushConfig;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.function.Supplier;

public class FruitBushConfig extends BushConfig {
    private final int stages;
    private BushConstructor<FruitPlantType> constructor;
    private final LinkedHashMap<Integer, StageConfig> stageConfigs = new LinkedHashMap<>();

    public FruitBushConfig(int stages) {
        this.stages = stages;
    }

    public int getStages() {
        return stages;
    }

    public BushConstructor<FruitPlantType> getConstructor() {
        return constructor;
    }

    public FruitBushConfig withConstructor(BushConstructor<FruitPlantType> constructor){
        this.constructor = constructor;
        return this;
    }

    public FruitBushConfig with(int stage, StageConfig config){
        stageConfigs.put(stage,config);
        return this;
    }

    public LinkedHashMap<Integer, StageConfig> getStageConfigs() {
        return stageConfigs;
    }

    public static class StageConfig{
        @Nullable
        private final LeafConfig.ItemConfig itemConfig;
        @Nullable
        private final String cross;
        @Nullable
        private final String overlay;
        @Nullable
        private final String stalk; //not tinted stalk

        private boolean afterFruitCollect = false;
        private boolean pathRelativeToBlock = true;

        public StageConfig(@Nullable LeafConfig.ItemConfig itemConfig, String cross, String overlay, String stalk) {
            this.itemConfig = itemConfig;
            this.cross = cross;
            this.overlay = overlay;
            this.stalk = stalk;
        }
        public StageConfig(@Nullable LeafConfig.ItemConfig itemConfig, String cross, String overlay) {
            this.itemConfig = itemConfig;
            this.cross = cross;
            this.overlay = overlay;
            this.stalk = null;
        }
        public StageConfig(@Nullable LeafConfig.ItemConfig itemConfig, String cross) {
            this.itemConfig = itemConfig;
            this.cross = cross;
            this.overlay = null;
            this.stalk = null;
        }
        public StageConfig(@Nullable LeafConfig.ItemConfig itemConfig) {
            this.itemConfig = itemConfig;
            this.cross = null;
            this.overlay = null;
            this.stalk = null;
        }
        public StageConfig() {
            this.itemConfig = null;
            this.cross = null;
            this.overlay = null;
            this.stalk = null;
        }

        @Nullable
        public LeafConfig.ItemConfig getItemConfig() {
            return itemConfig;
        }

        @Nullable
        public String getCross() {
            return cross;
        }

        @Nullable
        public String getOverlay() {
            return overlay;
        }

        @Nullable
        public String getStalk() {
            return stalk;
        }

        public boolean isAfterFruitCollect() {
            return afterFruitCollect;
        }

        public boolean isPathRelativeToBlock() {
            return pathRelativeToBlock;
        }

        public StageConfig makeAfterFruitCollect(){
            this.afterFruitCollect = true;
            return this;
        }
        public StageConfig makePathIndependent(){
            this.pathRelativeToBlock = false;
            return this;
        }
    }
}
