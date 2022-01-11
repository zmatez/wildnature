package net.matez.wildnature.data.blockstates.plants;

import com.google.gson.JsonObject;
import net.matez.wildnature.common.objects.blocks.crops.CropType;
import net.matez.wildnature.common.objects.blocks.fruit_bush.plants.FruitBushConfig;
import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_TypedCropBush extends WNBlockstate {
    private final int maxStages;
    public WNBlockstate_TypedCropBush(String id, int maxStages) {
        super(id);
        this.maxStages = maxStages;
    }

    public WNBlockstate_TypedCropBush(ResourceLocation location, int maxStages) {
        super(location);
        this.maxStages = maxStages;
    }

    @Override
    public String getJSON() {
        JsonObject object = new JsonObject();
        JsonObject variants = new JsonObject();
        if(this.maxStages > 1) {
            for (int i = 1; i <= this.maxStages; i++) {
                JsonObject modelFruit = new JsonObject();
                modelFruit.addProperty("model", this.getRegName() + "_stage_" + i);
                variants.add("stage=" + (i - 1), modelFruit);
            }
        }else{
            JsonObject modelFruit = new JsonObject();
            modelFruit.addProperty("model", this.getRegName());
            variants.add("", modelFruit);
        }

        object.add("variants",variants);

        return WildNature.gson.toJson(object);
    }

    @Override
    public String parseJSON() {
        return getJSON();
    }

    private String getRegName(){
        return modid + ":block/" + this.getName();
    }
}
