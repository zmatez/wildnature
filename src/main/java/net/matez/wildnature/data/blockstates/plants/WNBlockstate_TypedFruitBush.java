package net.matez.wildnature.data.blockstates.plants;

import com.google.gson.JsonObject;
import net.matez.wildnature.common.objects.blocks.fruit_bush.plants.FruitBushConfig;
import net.matez.wildnature.common.objects.blocks.leaves.LeafConfig;
import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_TypedFruitBush extends WNBlockstate {
    private final FruitBushConfig config;
    public WNBlockstate_TypedFruitBush(String id, FruitBushConfig config) {
        super(id);
        this.config = config;
    }

    public WNBlockstate_TypedFruitBush(ResourceLocation location, FruitBushConfig config) {
        super(location);
        this.config = config;
    }

    @Override
    public String getJSON() {
        JsonObject object = new JsonObject();
        JsonObject variants = new JsonObject();
        for(int i = 1; i <= config.getStages(); i++){
            JsonObject modelFruit = new JsonObject();
            modelFruit.addProperty("model",this.getRegName() + "_stage_" + i);
            variants.add("stage=" + (i-1),modelFruit);
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
