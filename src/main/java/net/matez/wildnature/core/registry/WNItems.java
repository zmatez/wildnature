/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.core.registry;

import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.block.crops.CropType;
import net.matez.wildnature.common.item.ItemRegisterCallback;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.common.item.backpacks.Backpack;
import net.matez.wildnature.common.item.backpacks.WNBackpackItem;
import net.matez.wildnature.common.item.cotton.WNCottonItem;
import net.matez.wildnature.common.item.dev.WNDevStickItem;
import net.matez.wildnature.common.item.dust.DustItem;
import net.matez.wildnature.common.item.dust.WNDustItem;
import net.matez.wildnature.common.item.fertilizer.WNFertilizerItem;
import net.matez.wildnature.common.item.fruits.Fruit;
import net.matez.wildnature.common.item.fruits.WNFruitItem;
import net.matez.wildnature.common.item.geyser.WNGeyserEssenceItem;
import net.matez.wildnature.common.item.handles.Handle;
import net.matez.wildnature.common.item.handles.WNHandleItem;
import net.matez.wildnature.common.item.ores.OreFamily;
import net.matez.wildnature.common.item.ores.OreItem;
import net.matez.wildnature.common.item.ores.WNOreItem;
import net.matez.wildnature.common.item.tools.*;
import net.matez.wildnature.common.item.vegetables.Veggie;
import net.matez.wildnature.common.item.vegetables.WNVeggieItem;
import net.matez.wildnature.core.other.WNTabs;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.LinkedHashMap;

@Initialize(InitStage.REG_ITEMS)
public class WNItems {
    private static final SimpleLogger log = WildNature.getLogger();

    //# --- ALL ITEMS ---
    public static final LinkedHashMap<ResourceLocation, IWNItem> ITEMS = new LinkedHashMap<>();
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
        return new WNHandleItem(location(value.getId()), new Item.Properties().tab(WNTabs.TAB_EQUIPMENT), value);
    });
    public static final LinkedHashMap<Backpack, IWNItem> BACKPACKS = register(Backpack.values(), (value) -> {
        return new WNBackpackItem(location(value.getId()), new Item.Properties().tab(WNTabs.TAB_EQUIPMENT).stacksTo(1), value);
    });
    public static final LinkedHashMap<DustItem, IWNItem> DUSTS = register(DustItem.values(), (value) -> {
        return new WNDustItem(location(value.getId()), new Item.Properties().tab(WNTabs.TAB_CAVES), value);
    });

    public static final WNItem GEYSER_ESSENCE = register(new WNGeyserEssenceItem(location("geyser_essence"), new Item.Properties().tab(WNTabs.TAB_SURFACE).stacksTo(1).rarity(Rarity.RARE)));
    public static final WNItem FERTILIZER = register(new WNFertilizerItem(location("fertilizer"), new Item.Properties().tab(WNTabs.TAB_SURFACE)));


    public static final WNItem DEVSTICK = register(new WNDevStickItem(location("devstick"), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));


    //########################################################

    public static ResourceLocation location(String name) {
        return new ResourceLocation(WildNature.modid, name);
    }

    private static <T extends IWNItem> T register(T item) {
        if (!WildNature.instance.initializer.isInitialized(InitStage.REG_BLOCKS)) {
            log.error("Can't register items");
            return null;
        }
        item.construct();
        if (item instanceof WNBlockItem i) {
            WNBlocks.BLOCK_ITEMS.put(item.getRegistryName(), i);
        } else {
            ITEMS.put(item.getRegistryName(), item);
        }
        return item;
    }

    private static <T, U extends IWNItem> LinkedHashMap<T, U> register(T[] list, ItemRegisterCallback<T, U> register) {
        if (!WildNature.instance.initializer.isInitialized(InitStage.REG_BLOCKS)) {
            log.error("Can't register items");
            return null;
        }
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
