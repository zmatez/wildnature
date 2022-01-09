package net.matez.wildnature.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.matez.wildnature.data.setup.base.WNRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.LinkedHashMap;

public class WNCraftingShaped extends WNRecipe {
    private String group = null;
    private final String pattern;
    private final ItemStack result;
    private final ShapedItems shapedItems;

    public WNCraftingShaped(String name, String pattern, ItemStack result, ShapedItems shapedItems) {
        super(name);

        this.pattern = pattern;
        this.result = result;
        this.shapedItems = shapedItems;
    }

    public WNCraftingShaped(String name, String group, String pattern, ItemStack result, ShapedItems shapedItems){
        this(name,pattern,result,shapedItems);
        this.group = group;
    }

    @Override
    public String getJSON() {
        JsonObject object = new JsonObject();
        object.addProperty("type","minecraft:crafting_shaped");
        if(this.group != null){
            object.addProperty("group",this.group);
        }

        JsonArray array = new JsonArray();
        for (String s : pattern.split("\n")) {
            array.add(s);
        }
        object.add("pattern",array);

        JsonObject key = new JsonObject();
        shapedItems.items.forEach((c,item) -> {
            JsonObject entry = new JsonObject();
            entry.addProperty("item",item.getItem().getRegistryName().toString());
            key.add(c + "",entry);
        });
        object.add("key",key);

        JsonObject result = new JsonObject();
        result.addProperty("item",this.result.getItem().getRegistryName().toString());
        if(this.result.getCount() > 1){
            result.addProperty("count",this.result.getCount());
        }
        object.add("result",result);

        return object.toString();
    }

    @Override
    public String parseJSON() {
        return getJSON();
    }

    public static class ShapedItems{
        private final LinkedHashMap<Character,ItemStack> items = new LinkedHashMap<>();

        public ShapedItems with(char key, Item item){
            items.put(key,new ItemStack(item));
            return this;
        }
    }
}
