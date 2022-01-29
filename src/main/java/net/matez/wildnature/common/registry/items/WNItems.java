/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.registry.items;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.blocks.crops.CropType;
import net.matez.wildnature.common.objects.initializer.ExcludeInit;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.common.objects.items.backpacks.Backpack;
import net.matez.wildnature.common.objects.items.backpacks.WNBackpackItem;
import net.matez.wildnature.common.objects.items.cotton.WNCottonItem;
import net.matez.wildnature.common.objects.items.dust.DustItem;
import net.matez.wildnature.common.objects.items.dust.WNDustItem;
import net.matez.wildnature.common.objects.items.fruits.Fruit;
import net.matez.wildnature.common.objects.items.fruits.WNFruitItem;
import net.matez.wildnature.common.objects.items.geyser.WNGeyserEssenceItem;
import net.matez.wildnature.common.objects.items.handles.Handle;
import net.matez.wildnature.common.objects.items.handles.WNHandleItem;
import net.matez.wildnature.common.objects.items.ores.OreFamily;
import net.matez.wildnature.common.objects.items.ores.OreItem;
import net.matez.wildnature.common.objects.items.ores.WNOreItem;
import net.matez.wildnature.common.objects.items.setup.IWNItem;
import net.matez.wildnature.common.objects.items.setup.WNBlockItem;
import net.matez.wildnature.common.objects.items.setup.WNItem;
import net.matez.wildnature.common.objects.items.tools.*;
import net.matez.wildnature.common.objects.items.vegetables.Veggie;
import net.matez.wildnature.common.objects.items.vegetables.WNVeggieItem;
import net.matez.wildnature.common.registry.tabs.WNTabs;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.LinkedHashMap;

@Initialize(InitStage.CONSTRUCT)
public class WNItems {
    @ExcludeInit
    private static final WNLogger log = WildNature.getLogger();

    //# --- ALL ITEMS ---
    public static final LinkedHashMap<ResourceLocation, IWNItem> ITEMS = new LinkedHashMap<>();
    public static final LinkedHashMap<ResourceLocation, WNBlockItem> BLOCK_ITEMS = new LinkedHashMap<>();
    //#------------------

    public static final WNItem COTTON = register(new WNCottonItem(location("cotton"),new Item.Properties().tab(WNTabs.TAB_SURFACE_PLANTS)));

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
    //# ORE ITEMS
    public static final LinkedHashMap<OreItem, IWNItem> ORE_ITEMS = register(OreItem.values(), (value) -> {
        return new WNOreItem(
                location(value.getId()),
                new Item.Properties()
                        .tab(WNTabs.TAB_EQUIPMENT),
                value
        );
    });
    //# TOOLS
    public static final LinkedHashMap<OreFamily, IWNItem> SWORDS = register(OreFamily.values(), (value) -> {
        if(value.getTier() != null) {
            for (ToolItem toolItem : ToolItem.values()) {
                if (toolItem.getType() == ToolType.SWORD) {
                    if (toolItem.getFamily() == value) {
                        WNSwordItem item = new WNSwordItem(value.getTier(), new Item.Properties().tab(WNTabs.TAB_EQUIPMENT), toolItem);
                        item.setRegistryName(location(toolItem.getId()));
                        return item;
                    }
                }
            }
        }
        return null;
    });
    public static final LinkedHashMap<OreFamily, IWNItem> PICKAXES = register(OreFamily.values(), (value) -> {
        if(value.getTier() != null) {
            for (ToolItem toolItem : ToolItem.values()) {
                if (toolItem.getType() == ToolType.PICKAXE) {
                    if (toolItem.getFamily() == value) {
                        WNPickaxeItem item = new WNPickaxeItem(value.getTier(), new Item.Properties().tab(WNTabs.TAB_EQUIPMENT), toolItem);
                        item.setRegistryName(location(toolItem.getId()));
                        return item;
                    }
                }
            }
        }
        return null;
    });
    public static final LinkedHashMap<OreFamily, IWNItem> AXES = register(OreFamily.values(), (value) -> {
        if(value.getTier() != null) {
            for (ToolItem toolItem : ToolItem.values()) {
                if (toolItem.getType() == ToolType.AXE) {
                    if (toolItem.getFamily() == value) {
                        WNAxeItem item = new WNAxeItem(value.getTier(), new Item.Properties().tab(WNTabs.TAB_EQUIPMENT), toolItem);
                        item.setRegistryName(location(toolItem.getId()));
                        return item;
                    }
                }
            }
        }
        return null;
    });
    public static final LinkedHashMap<OreFamily, IWNItem> SHOVELS = register(OreFamily.values(), (value) -> {
        if(value.getTier() != null) {
            for (ToolItem toolItem : ToolItem.values()) {
                if (toolItem.getType() == ToolType.SHOVEL) {
                    if (toolItem.getFamily() == value) {
                        WNShovelItem item = new WNShovelItem(value.getTier(), new Item.Properties().tab(WNTabs.TAB_EQUIPMENT), toolItem);
                        item.setRegistryName(location(toolItem.getId()));
                        return item;
                    }
                }
            }
        }
        return null;
    });
    public static final LinkedHashMap<OreFamily, IWNItem> HOES = register(OreFamily.values(), (value) -> {
        if(value.getTier() != null) {
            for (ToolItem toolItem : ToolItem.values()) {
                if (toolItem.getType() == ToolType.HOE) {
                    if (toolItem.getFamily() == value) {
                        WNHoeItem item = new WNHoeItem(value.getTier(), new Item.Properties().tab(WNTabs.TAB_EQUIPMENT), toolItem);
                        item.setRegistryName(location(toolItem.getId()));
                        return item;
                    }
                }
            }
        }
        return null;
    });
    public static final LinkedHashMap<OreFamily, IWNItem> CROSSBOWS = register(OreFamily.values(), (value) -> {
        if(value.getTier() != null) {
            for (ToolItem toolItem : ToolItem.values()) {
                if (toolItem.getType() == ToolType.CROSSBOW) {
                    if (toolItem.getFamily() == value) {
                        WNCrossbowItem item = null;
                        if(value == OreFamily.SILVER){
                            item = new WNSilverCrossbowItem(new Item.Properties().tab(WNTabs.TAB_EQUIPMENT).stacksTo(1).durability(500), toolItem);
                        }else{
                            item = new WNCrossbowItem(new Item.Properties().tab(WNTabs.TAB_EQUIPMENT).stacksTo(1).durability(500), toolItem);
                        }
                        item.setRegistryName(location(toolItem.getId()));
                        return item;
                    }
                }
            }
        }
        return null;
    });
    public static final LinkedHashMap<Handle, IWNItem> HANDLES = register(Handle.values(), (value) -> {
        return new WNHandleItem(location(value.getId()),new Item.Properties().tab(WNTabs.TAB_EQUIPMENT), value);
    });
    public static final LinkedHashMap<Backpack, IWNItem> BACKPACKS = register(Backpack.values(), (value) -> {
        return new WNBackpackItem(location(value.getId()),new Item.Properties().tab(WNTabs.TAB_EQUIPMENT), value);
    });
    public static final LinkedHashMap<DustItem, IWNItem> DUSTS = register(DustItem.values(), (value) -> {
        return new WNDustItem(location(value.getId()),new Item.Properties().tab(WNTabs.TAB_CAVES), value);
    });

    public static final WNItem GEYSER_ESSENCE = register(new WNGeyserEssenceItem(location("geyser_essence"),new Item.Properties().tab(WNTabs.TAB_SURFACE).stacksTo(1)));


    //########################################################

    public static ResourceLocation location(String name) {
        return new ResourceLocation(WildNature.modid, name);
    }

    private static <T extends IWNItem> T register(T item) {
        item.construct();
        if(item instanceof WNBlockItem i){
            BLOCK_ITEMS.put(item.getRegistryName(),i);
        }else{
            ITEMS.put(item.getRegistryName(),item);
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
