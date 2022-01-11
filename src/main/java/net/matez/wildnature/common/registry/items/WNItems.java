package net.matez.wildnature.common.registry.items;

import net.matez.wildnature.common.objects.blocks.crops.CropType;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.common.objects.items.fruits.Fruit;
import net.matez.wildnature.common.objects.items.fruits.WNFruitItem;
import net.matez.wildnature.common.objects.items.setup.IWNItem;
import net.matez.wildnature.common.objects.items.setup.WNBlockItem;
import net.matez.wildnature.common.objects.items.setup.WNItem;
import net.matez.wildnature.common.objects.items.vegetables.Veggie;
import net.matez.wildnature.common.objects.items.vegetables.WNVeggieBlockItem;
import net.matez.wildnature.common.objects.items.vegetables.WNVeggieItem;
import net.matez.wildnature.common.registry.tabs.WNTabs;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.LinkedHashMap;

@Initialize(InitStage.CONSTRUCT)
public class WNItems {
    //# --- ALL ITEMS ---
    public static final LinkedHashMap<ResourceLocation, WNItem> ITEMS = new LinkedHashMap<>();
    public static final LinkedHashMap<ResourceLocation, WNBlockItem> BLOCK_ITEMS = new LinkedHashMap<>();
    //#------------------

    //# FRUITS
    public static final LinkedHashMap<Fruit, WNItem> FRUITS = register(Fruit.values(), (value) -> {
        var prop = new Item.Properties()
                        .tab(WNTabs.TAB_FOOD);
        if(value.getFood() != null){
            prop.food(value.getFood());
        }
        return new WNFruitItem(
                location(value.getId()),
                prop,
                value
        );
    });
    //# VEGGIES
    public static final LinkedHashMap<Veggie, IWNItem> VEGGIES = register(Veggie.values(), (value) -> {
        var prop = new Item.Properties()
                .tab(WNTabs.TAB_FOOD);
        if(value.getFood() != null){
            prop.food(value.getFood());
        }

        for (CropType cropType : CropType.values()) {
            if(cropType.getVeggie() == value){
                return null;
            }
        }

        return new WNVeggieItem(
                location(value.getId()),
                prop,
                value
        );
    });


    public static ResourceLocation location(String name) {
        return new ResourceLocation(WildNature.modid, name);
    }

    private static <T extends IWNItem> T register(T item) {
        item.construct();
        if(item instanceof WNItem i) {
            ITEMS.put(item.getRegistryName(), i);
        }else if(item instanceof WNBlockItem i){
            BLOCK_ITEMS.put(item.getRegistryName(),i);
        }
        return item;
    }

    private static <T, U extends IWNItem> LinkedHashMap<T, U> register(T[] list, ItemRegisterCallback<T, U> register) {
        LinkedHashMap<T, U> map = new LinkedHashMap<>();
        for (T element : list) {
            U result = register.register(element);
            if (result != null) {
                register(result);
                map.put(element, result);
            }
        }

        return map;
    }
}
