package net.matez.wildnature.common.registry.tabs;

import net.matez.wildnature.common.objects.blocks.grass.GrassType;
import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.rocks.RockType;
import net.matez.wildnature.common.objects.blocks.wood.LogType;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.common.objects.items.fruits.Fruit;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.common.registry.items.WNItems;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.LinkedHashMap;

@Initialize(InitStage.CONSTRUCT)
public class WNTabs {
    public static final LinkedHashMap<String, CreativeModeTab> TABS = new LinkedHashMap<>();
    public static final CreativeModeTab TAB_SURFACE = new CreativeModeTab(WildNature.modid + ".surface") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.GRASSES.get(GrassType.TROPICAL).getItem());
        }
    };
    public static final CreativeModeTab TAB_SURFACE_PLANTS = new CreativeModeTab( WildNature.modid + ".surface_plants") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.BUSHES.get(BushType.MATTHIOLA_PINK));
        }
    };
    public static final CreativeModeTab TAB_CAVES = new CreativeModeTab( WildNature.modid + ".caves") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.IGNEOUS_BASANITE.getItem());
        }
    };
    public static final CreativeModeTab TAB_UNDERWATER = new CreativeModeTab( WildNature.modid + ".underwater") {
        public ItemStack makeIcon() {
            return new ItemStack(Items.APPLE);
        }
    };
    public static final CreativeModeTab TAB_FOOD = new CreativeModeTab( WildNature.modid + ".food") {
        public ItemStack makeIcon() {
            return new ItemStack(WNItems.FRUITS.get(Fruit.MANGO));
        }
    };
    public static final CreativeModeTab TAB_EQUIPMENT = new CreativeModeTab( WildNature.modid + ".equipment") {
        public ItemStack makeIcon() {
            return new ItemStack(Items.APPLE);
        }
    };
    public static final CreativeModeTab TAB_WOOD_BUILDING = new CreativeModeTab( WildNature.modid + ".wood_building") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.STAIRS_PARQUET.get(LogType.REDWOOD).getItem());
        }
    };
    public static final CreativeModeTab TAB_FURNITURE = new CreativeModeTab( WildNature.modid + ".furniture") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.WOODEN_DOORS.get(LogType.MAHOGANY));
        }
    };
    public static final CreativeModeTab TAB_ROCK_BUILDING = new CreativeModeTab( WildNature.modid + ".rock_building") {
        public ItemStack makeIcon() {
            return new ItemStack(WNBlocks.ROCKS_POLISHED.get(RockType.LIMESTONE).getItem());
        }
    };

    private static CreativeModeTab register(CreativeModeTab tab){
        TABS.put(tab.getDisplayName().toString(),tab);
        return tab;
    }
}
