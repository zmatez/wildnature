package net.matez.wildnature.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.matez.wildnature.data.setup.base.WNRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;

public class WNCraftingShapeless extends WNRecipe {
    private String group = null;
    private final ItemStack result;
    private final ShapelessItems shapelessItems;

    public WNCraftingShapeless(String name, ItemStack result, ShapelessItems shapelessItems) {
        super(name);

        this.result = result;
        this.shapelessItems = shapelessItems;
    }

    public WNCraftingShapeless(String name, String group, ItemStack result, ShapelessItems shapelessItems){
        this(name,result, shapelessItems);
        this.group = group;
    }

    @Override
    public String getJSON() {
        JsonObject object = new JsonObject();
        object.addProperty("type","minecraft:crafting_shapeless");
        if(this.group != null){
            object.addProperty("group",this.group);
        }

        JsonArray array = new JsonArray();
        for (ItemStack item : shapelessItems.items) {
            for(int i = 0; i < item.getCount(); i++){
                JsonObject o = new JsonObject();
                o.addProperty("item",item.getItem().getRegistryName().toString());
                array.add(o);
            }
        }
        object.add("ingredients",array);

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

    public static class ShapelessItems {
        private final ArrayList<ItemStack> items = new ArrayList<>();

        public ShapelessItems with(Item item){
            items.add(new ItemStack(item));
            return this;
        }
        public ShapelessItems with(Item item, int count){
            items.add(new ItemStack(item,count));
            return this;
        }
        public ShapelessItems with(ItemStack item){
            items.add(item);
            return this;
        }
    }
}
