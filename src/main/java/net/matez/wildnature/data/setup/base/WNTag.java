package net.matez.wildnature.data.setup.base;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.minecraft.resources.ResourceLocation;

public class WNTag extends WNResource{
    public final WNTags.Tag tag;
    public String folder = "blocks";

    public WNTag(WNTags.Tag tag) {
        super(tag.getName().getPath());
        this.tag = tag;
    }
    public WNTag(WNTags.Tag tag, String folder) {
        super(tag.getName().getPath());
        this.tag = tag;
        this.folder = folder;
    }

    @Override
    public String getJSON() {
        JsonObject object = new JsonObject();
        object.addProperty("replace",false);
        JsonArray array = new JsonArray();
        for (ResourceLocation entry : this.tag.getEntries()) {
            array.add(entry.toString());
        }
        object.add("values",array);
        return object.toString();
    }

    @Override
    public String parseJSON() {
        return getJSON();
    }

    @Override
    public String getPath(){
        return "/data/" + tag.getName().getNamespace() + "/tags/" + folder;
    }

}
