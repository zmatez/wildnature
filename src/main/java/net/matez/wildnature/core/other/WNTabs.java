/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.core.other;

import net.matez.wildnature.common.block.grass.GrassType;
import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.rocks.RockType;
import net.matez.wildnature.common.block.underwater_plants.UnderwaterPlant;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.item.fruits.Fruit;
import net.matez.wildnature.common.item.ores.OreItem;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.core.registry.WNItems;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.LinkedHashMap;

public class WNTabs {
    public static final LinkedHashMap<String, CreativeModeTab> TABS = new LinkedHashMap<>();
    public static final CreativeModeTab TAB_SURFACE = register("surface", new CreativeModeTab(WildNature.modid + ".surface") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.GRASSES.get(GrassType.TROPICAL).getItem());
        }
    });
    public static final CreativeModeTab TAB_SURFACE_PLANTS = register("surface_plants", new CreativeModeTab(WildNature.modid + ".surface_plants") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.BUSHES.get(BushType.MATTHIOLA_PINK));
        }
    });
    public static final CreativeModeTab TAB_CAVES = register("caves", new CreativeModeTab(WildNature.modid + ".caves") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.IGNEOUS_BASANITE.getItem());
        }
    });
    public static final CreativeModeTab TAB_UNDERWATER = register("underwater", new CreativeModeTab(WildNature.modid + ".underwater") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.UNDERWATER_BUSHES.get(UnderwaterPlant.OAR_WEED).getItem());
        }
    });
    public static final CreativeModeTab TAB_FOOD = register("food", new CreativeModeTab(WildNature.modid + ".food") {
        public ItemStack makeIcon() {
            return new ItemStack(WNItems.FRUITS.get(Fruit.MANGO));
        }
    });
    public static final CreativeModeTab TAB_EQUIPMENT = register("equipment", new CreativeModeTab(WildNature.modid + ".equipment") {
        public ItemStack makeIcon() {
            return new ItemStack(WNItems.ORE_ITEMS.get(OreItem.AMBER));
        }
    });
    public static final CreativeModeTab TAB_WOOD_BUILDING = register("wood_building", new CreativeModeTab(WildNature.modid + ".wood_building") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.STAIRS_PARQUET.get(LogType.REDWOOD).getItem());
        }
    });
    public static final CreativeModeTab TAB_FURNITURE = register("furniture", new CreativeModeTab(WildNature.modid + ".furniture") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.WOODEN_DOORS.get(LogType.MAHOGANY));
        }
    });
    public static final CreativeModeTab TAB_ROCK_BUILDING = register("rock_building", new CreativeModeTab(WildNature.modid + ".rock_building") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.ROCKS_POLISHED.get(RockType.LIMESTONE).getItem());
        }
    });

    private static CreativeModeTab register(String id, CreativeModeTab tab) {
        TABS.put(id, tab);
        return tab;
    }
}
