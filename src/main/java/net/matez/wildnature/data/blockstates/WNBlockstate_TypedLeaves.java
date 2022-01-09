package net.matez.wildnature.data.blockstates;

import com.google.gson.JsonObject;
import net.matez.wildnature.common.objects.blocks.leaves.LeafConfig;
import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_TypedLeaves extends WNBlockstate {
    private final LeafConfig config;
    public WNBlockstate_TypedLeaves(String id, LeafConfig config) {
        super(id);
        this.config = config;
    }

    public WNBlockstate_TypedLeaves(ResourceLocation location, LeafConfig config) {
        super(location);
        this.config = config;
    }

    @Override
    public String getJSON() {
        JsonObject object = new JsonObject();
        JsonObject variants = new JsonObject();
        if(config.getStages() < 1){
            JsonObject model = new JsonObject();
            model.addProperty("model",this.getRegName());
            variants.add("",model);
        }else{
            JsonObject model = new JsonObject();
            model.addProperty("model",this.getRegName());
            variants.add("stage=0",model);

            if(config.isFlowering()){
                JsonObject modelFlowering = new JsonObject();
                modelFlowering.addProperty("model",this.getRegName() + "_flowering");
                variants.add("stage=1",modelFlowering);
            }

            int ordinal = 1;
            for(int i = config.isFlowering() ? 2 : 1; i <= config.getStages(); i++, ordinal++){
                JsonObject modelFruit = new JsonObject();
                modelFruit.addProperty("model",this.getRegName() + "_fruit_" + ordinal);
                variants.add("stage=" + i,modelFruit);
            }
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
