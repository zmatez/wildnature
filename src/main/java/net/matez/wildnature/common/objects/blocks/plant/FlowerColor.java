package net.matez.wildnature.common.objects.blocks.plant;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public enum FlowerColor {
    PINK("pink", Items.PINK_DYE),
    PINK_BUT_MAGENTA("pink", Items.MAGENTA_DYE),
    RED("red", Items.RED_DYE),
    WHITE("white", Items.WHITE_DYE),
    YELLOW("yellow", Items.YELLOW_DYE),
    GREEN("green", Items.GREEN_DYE),
    LIGHT_YELLOW("light_yellow", Items.YELLOW_DYE),
    BLUE_BUT_LIGHT("blue", Items.LIGHT_BLUE_DYE),
    LIGHT_BLUE("light_blue", Items.LIGHT_BLUE_DYE),
    ORANGE("orange", Items.ORANGE_DYE),
    PURPLE("purple", Items.PURPLE_DYE),
    PURPLE_BUT_MAGENTA("purple", Items.MAGENTA_DYE),
    VIOLET("violet", Items.PURPLE_DYE),
    BLUE("blue", Items.BLUE_DYE),
    DARK_BLUE("dark_blue", Items.BLUE_DYE),
    LIME("lime", Items.LIME_DYE),
    ;


    private final String name;
    private final Item dye;

    private FlowerColor(String name, Item dye){
        this.name = name;
        this.dye = dye;
    }

    public String getName() {
        return name;
    }

    public Item getDye() {
        return dye;
    }
}
