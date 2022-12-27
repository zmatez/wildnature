/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant;

import net.matez.wildnature.common.block.plant.config.BushConfig;
import org.jetbrains.annotations.Nullable;

public enum BushType {
    ANEMONE(FlowerColor.WHITE,0xFFFFFF,BushVariant.ANEMONE),
    ANTHURIUM_PINK(FlowerColor.PINK,0xEA5D84, BushVariant.ANTHURIUM),
    ANTHURIUM_RED(FlowerColor.RED,0xB51026, BushVariant.ANTHURIUM),
    ANTHURIUM_WHITE(FlowerColor.WHITE,0xECECEC, BushVariant.ANTHURIUM),
    AZALEA_ORANGE(FlowerColor.ORANGE,0xF25D58, BushVariant.AZALEA),
    AZALEA_PINK(FlowerColor.PINK,0xD85DA7, BushVariant.AZALEA),
    AZALEA_PURPLE(FlowerColor.PURPLE,0x973789, BushVariant.AZALEA),
    AZALEA_RED(FlowerColor.RED,0xCC3646, BushVariant.AZALEA),
    AZALEA_WHITE(FlowerColor.WHITE,0xF4D8D2, BushVariant.AZALEA),
    AZALEA_YELLOW(FlowerColor.YELLOW,0xE0D43C, BushVariant.AZALEA),
    BIRD_OF_PARADISE(FlowerColor.ORANGE,0xFFB14C, BushVariant.BIRD_OF_PARADISE),
    BOXWOOD("",0x0, BushVariant.BOXWOOD),
    BLUEBELL(FlowerColor.BLUE,0x7051EB, BushVariant.BLUEBELL),
    BUTTERCUP_ORANGE(FlowerColor.ORANGE,0xFFB877, BushVariant.BUTTERCUP),
    BUTTERCUP_YELLOW(FlowerColor.YELLOW,0xF8E36D, BushVariant.BUTTERCUP),
    CANNA_BULB_ORANGE(FlowerColor.ORANGE,0xF97E49, BushVariant.CANNA_BULB),
    CANNA_BULB_PINK(FlowerColor.PINK,0xF96EAD, BushVariant.CANNA_BULB),
    CANNA_BULB_RED(FlowerColor.RED,0xC41F43, BushVariant.CANNA_BULB),
    CANNA_BULB_YELLOW(FlowerColor.YELLOW,0xE5C14B, BushVariant.CANNA_BULB),
    CARNATION_PINK(FlowerColor.PINK,0xFF9EBD, BushVariant.CARNATION),
    CARNATION_RED(FlowerColor.RED,0xFF686E, BushVariant.CARNATION),
    CARNATION_WHITE(FlowerColor.WHITE,0xFFE1B8, BushVariant.CARNATION),
    CATNIP_PURPLE(FlowerColor.PURPLE,0x9C6BFF, BushVariant.CATNIP),
    CATTAIL("",0x0,BushVariant.CATTAIL),
    CHAMOMILE_WHITE(FlowerColor.WHITE,0xFFBD3D, BushVariant.CHAMOMILE),
    CHAMOMILE_LARGE_WHITE(FlowerColor.WHITE,0xFFBD3D, BushVariant.CHAMOMILE_LARGE),
    CHINESE_LANTERN_FLOWER(FlowerColor.ORANGE,0xCF682E, BushVariant.CHINESE_LANTERN),
    CHRYSANTHEMUM_PURPLE(FlowerColor.PURPLE,0xA0528A, BushVariant.CHRYSANTHEMUM),
    CHRYSANTHEMUM_RED(FlowerColor.RED,0xA5324A, BushVariant.CHRYSANTHEMUM),
    CHRYSANTHEMUM_WHITE(FlowerColor.WHITE,0xEEEEEE, BushVariant.CHRYSANTHEMUM),
    CHRYSANTHEMUM_LIGHT_YELLOW(FlowerColor.LIGHT_YELLOW,0xFFED8C, BushVariant.CHRYSANTHEMUM),
    CHRYSANTHEMUM_YELLOW(FlowerColor.YELLOW,0xF5D50F, BushVariant.CHRYSANTHEMUM),
    CLEMATIS_BLUE(FlowerColor.BLUE,0xC468BD,BushVariant.CLEMATIS),
    CLEMATIS_PURPLE(FlowerColor.PURPLE,0x4162C5,BushVariant.CLEMATIS),
    CLOVER(FlowerColor.GREEN,0xffffff,BushVariant.CLOVER),
    COLUMBINE_BLUE(FlowerColor.BLUE,0x296BF3,BushVariant.COLUMBINE),
    COLUMBINE_PURPLE(FlowerColor.PURPLE,0x7E40D5,BushVariant.COLUMBINE),
    COLUMBINE_RED(FlowerColor.RED,0xE51433,BushVariant.COLUMBINE),
    CORDYLINE_AUSTRALIS("",0x0,BushVariant.CORDYLINE_AUSTRALIS),
    COTTON("",0xffffff,BushVariant.COTTON),
    CROCUS_PURPLE(FlowerColor.PURPLE_BUT_MAGENTA,0xBD88F7,BushVariant.CROCUS),
    CROCUS_WHITE(FlowerColor.WHITE,0xFFFFFF,BushVariant.CROCUS),
    DAFFODIL_YELLOW(FlowerColor.YELLOW,0xFFF95B, BushVariant.DAFFODIL),
    DOGWOOD_SHRUB("",0xCE1433, BushVariant.DOGWOOD),
    DOGWOOD_LARGE_SHRUB("",0xCE1433, BushVariant.DOGWOOD_LARGE),
    FESTUCA("",0x3C8C77, BushVariant.FESTUCA_LARGE),
    FESTUCA_ELIJAHBLUE("",0x3C8C77, BushVariant.FESTUCA_ELIJAHBLUE),
    FIREWEED(FlowerColor.PINK_BUT_MAGENTA,0xE97FFF, BushVariant.FIREWEED),
    FLY_TRAP(FlowerColor.LIME,0x0, BushVariant.FLY_TRAP),
    FOREST_MOSS("",0x4E8746, BushVariant.FOREST_MOSS),
    REINDEER_MOSS("",0x4E8746, BushVariant.REINDEER_MOSS),
    FORGET_ME_NOT_BLUE(FlowerColor.BLUE_BUT_LIGHT,0x7C9DFF, BushVariant.FORGET_ME_NOT),
    FORGET_ME_NOT_PINK(FlowerColor.PINK,0xE082CA, BushVariant.FORGET_ME_NOT),
    FORGET_ME_NOT_WHITE(FlowerColor.WHITE,0xE1D0D0, BushVariant.FORGET_ME_NOT),
    GERANIUM_PINK(FlowerColor.PINK,0xFF8484, BushVariant.GERANIUM),
    GERANIUM_RED(FlowerColor.RED,0xFF1E22, BushVariant.GERANIUM),
    GERANIUM_WHITE(FlowerColor.WHITE,0xF7F0EC, BushVariant.GERANIUM),
    GIANT_HOGWEED(FlowerColor.WHITE,0xEEFFD6, BushVariant.GIANT_HOGWEED),
    GLADIOLUS_ORANGE(FlowerColor.ORANGE,0xFF592B, BushVariant.GLADIOLUS),
    GLADIOLUS_PURPLE(FlowerColor.PURPLE,0x5736B2, BushVariant.GLADIOLUS),
    GLADIOLUS_RED(FlowerColor.RED,0x9C061F, BushVariant.GLADIOLUS),
    GLADIOLUS_YELLOW(FlowerColor.YELLOW,0xFFC549, BushVariant.GLADIOLUS),
    GOLDENROD(FlowerColor.YELLOW,0xFFC23D, BushVariant.GOLDENROD),
    FERNSPROUT("",0x0, BushVariant.FERNSPROUT),
    GRASS_FLOWER(FlowerColor.GREEN,0xC2C66D, BushVariant.GRASS_FLOWER),
    GRASS_WHEAT(FlowerColor.GREEN,0xCEC48A, BushVariant.GRASS_WHEAT),
    DESERT_GRASS("",0x0, BushVariant.DESERT_GRASS),
    DEAD_SHORT_GRASS("",0x0, BushVariant.DEAD_SHORT_GRASS),
    MEDIUM_GRASS("",0x0, BushVariant.MEDIUM_GRASS),
    SEABEACH_SANDWORT("",0x0, BushVariant.SEABEACH_SANDWORT),
    SHRUB("",0x0, BushVariant.SHRUB),
    SMALL_GRASS("",0x0, BushVariant.SMALL_GRASS),
    SMALL_CACTI(FlowerColor.LIME,0x0, BushVariant.SMALL_CACTI),
    HEATH_PINK(FlowerColor.PINK,0xFFC4E9, BushVariant.HEATH),
    HEATH_PURPLE(FlowerColor.PURPLE,0xE056CB, BushVariant.HEATH),
    HEATH_WHITE(FlowerColor.WHITE,0xFCF3EF, BushVariant.HEATH),
    HEATHER_MIXED(FlowerColor.MIXED_WHITE, 0xFFFAA8, BushVariant.HEATHER),
    HEATHER_PINK(FlowerColor.PINK, 0xC87DAA, BushVariant.HEATHER),
    HEATHER_RED(FlowerColor.RED, 0xDA244A, BushVariant.HEATHER),
    HEATHER_WHITE(FlowerColor.WHITE, 0xFFFFFF, BushVariant.HEATHER),
    HEATHER_YELLOW(FlowerColor.YELLOW, 0xFFF549, BushVariant.HEATHER),
    HEPATICA_BLUE(FlowerColor.BLUE_BUT_LIGHT, 0x80BDFF, BushVariant.HEPATICA),
    HEPATICA_PINK(FlowerColor.PINK, 0xFFA3DE, BushVariant.HEPATICA),
    HEPATICA_PURPLE(FlowerColor.PURPLE, 0x452D82, BushVariant.HEPATICA),
    HEPATICA_VIOLET(FlowerColor.VIOLET, 0xBD68FF, BushVariant.HEPATICA),
    HEPATICA_WHITE(FlowerColor.WHITE, 0xDEFFDC, BushVariant.HEPATICA),
    HOLLYHOCK_PINK(FlowerColor.PINK, 0xFFBCD2, BushVariant.HOLLYHOCK),
    HOLLYHOCK_RED(FlowerColor.RED, 0xFF264D, BushVariant.HOLLYHOCK),
    HONEYSUCKLE(FlowerColor.YELLOW, 0xEDA81E, BushVariant.HONEYSUCKLE),
    HOTTENTOT(FlowerColor.PINK, 0xDE68FF, BushVariant.HOTTENTOT),
    HYACINTH_DARK_BLUE(FlowerColor.DARK_BLUE, 0x4751A6, BushVariant.HYACINTH),
    HYACINTH_LIGHT_BLUE(FlowerColor.LIGHT_BLUE, 0x87A5F8, BushVariant.HYACINTH),
    HYACINTH_PINK(FlowerColor.PINK, 0xEE98FF, BushVariant.HYACINTH),
    HYACINTH_PURPLE(FlowerColor.PURPLE, 0x9E5EFF, BushVariant.HYACINTH),
    HYACINTH_RED(FlowerColor.RED, 0xB34259, BushVariant.HYACINTH),
    HYACINTH_WHITE(FlowerColor.WHITE, 0xFFFFFF, BushVariant.HYACINTH),
    HYDRANGEA_BLUE(FlowerColor.BLUE_BUT_LIGHT, 0xB2E1FF, BushVariant.HYDRANGEA),
    HYDRANGEA_PINK(FlowerColor.PINK, 0xFFB2E2, BushVariant.HYDRANGEA),
    HYDRANGEA_PURPLE(FlowerColor.PURPLE_BUT_MAGENTA, 0xEAC4FF, BushVariant.HYDRANGEA),
    HYDRANGEA_WHITE(FlowerColor.WHITE, 0xF5F5F5, BushVariant.HYDRANGEA),
    IRIS_PINK(FlowerColor.PINK, 0xA93587, BushVariant.IRIS),
    IRIS_PURPLE(FlowerColor.PURPLE, 0x561946, BushVariant.IRIS),
    IRIS_VIOLET(FlowerColor.VIOLET, 0x5B398D, BushVariant.IRIS),
    IRIS_WHITE(FlowerColor.WHITE, 0xDBCECE, BushVariant.IRIS),
    LAMPGRASS(FlowerColor.YELLOW, 0xE5E695, BushVariant.LAMPGRASS),
    LAVENDER_VIOLET(FlowerColor.VIOLET, 0x8A59FF, BushVariant.LAVENDER),
    LICHEN(FlowerColor.LIME, 0x0, BushVariant.LICHEN),
    LUPINE_BLUE(FlowerColor.BLUE, 0x211FD6, BushVariant.LUPINE),
    LUPINE_PINK(FlowerColor.PINK, 0xF86996, BushVariant.LUPINE),
    LUPINE_RED(FlowerColor.RED, 0xD84955, BushVariant.LUPINE),
    LUPINE_VIOLET(FlowerColor.VIOLET, 0xBC58E7, BushVariant.LUPINE),
    LUPINE_YELLOW(FlowerColor.YELLOW, 0xFCCA45, BushVariant.LUPINE),
    MARIGOLD_ORANGE(FlowerColor.ORANGE, 0xFFA302, BushVariant.MARIGOLD),
    MARIGOLD_RED(FlowerColor.RED, 0xAB1221, BushVariant.MARIGOLD),
    MARIGOLD_WHITE(FlowerColor.WHITE, 0xEDEDED, BushVariant.MARIGOLD),
    MARIGOLD_YELLOW(FlowerColor.YELLOW, 0xFCB021, BushVariant.MARIGOLD),
    MATTHIOLA_PINK(FlowerColor.PINK, 0xEFB2FF, BushVariant.MATTHIOLA),
    MISCANTHUS(FlowerColor.WHITE, 0xFFF2C4, BushVariant.MISCANTHUS),
    MONKSHOOD_BLUE(FlowerColor.BLUE, 0x593EAF, BushVariant.MONKSHOOD),
    NETTLE("", 0x0, BushVariant.NETTLE),
    ORCHID_PURPLE(FlowerColor.PURPLE_BUT_MAGENTA, 0xEFE0EC, BushVariant.ORCHID),
    ORCHID_WHITE(FlowerColor.WHITE, 0xBD3EE0, BushVariant.ORCHID),
    PASQUE_PINK(FlowerColor.PINK, 0xFF38A5, BushVariant.PASQUE),
    PASQUE_PURPLE(FlowerColor.PURPLE, 0x7632DD, BushVariant.PASQUE),
    PASQUE_WHITE(FlowerColor.WHITE, 0xF5CAE2, BushVariant.PASQUE),
    PASQUE_YELLOW(FlowerColor.YELLOW, 0xFFD677, BushVariant.PASQUE),
    PEACE_LILY(FlowerColor.WHITE, 0xFCFCFC, BushVariant.PEACE_LILY),
    PERENNIAL_BLUE(FlowerColor.BLUE, 0x7978EC, BushVariant.PERENNIAL),
    PERENNIAL_PINK(FlowerColor.PINK, 0xCC7DA3, BushVariant.PERENNIAL),
    PERENNIAL_VIOLET(FlowerColor.VIOLET, 0x8B64B1, BushVariant.PERENNIAL),
    POISON_IVY("", 0x0, BushVariant.POISON_IVY),
    PRAIRIE_GRASS(FlowerColor.YELLOW, 0xD8A763, BushVariant.PRAIRIE_GRASS),
    PRICKLY_PEAR_CACTUS(FlowerColor.GREEN, 0xC42318, BushVariant.PRICKLY_PEAR_CACTUS),
    PRIMROSE_BLUE(FlowerColor.BLUE, 0x0056B3, BushVariant.PRIMROSE),
    PRIMROSE_PINK(FlowerColor.PINK, 0xFFAAFF, BushVariant.PRIMROSE),
    PRIMROSE_WHITE(FlowerColor.WHITE, 0xFFFFFF, BushVariant.PRIMROSE),
    RADISSIUM_BLUE(FlowerColor.BLUE, 0x416FBE, BushVariant.RADISSIUM),
    RADISSIUM_PURPLE(FlowerColor.PURPLE, 0xAF49D7, BushVariant.RADISSIUM),
    RADISSIUM_RED(FlowerColor.RED, 0xF25272, BushVariant.RADISSIUM),
    RAPESEED(FlowerColor.YELLOW, 0xE0D03C, BushVariant.RAPESEED),
    RED_SAND_VERBENA(FlowerColor.PINK_BUT_MAGENTA, 0xE751FF, BushVariant.RED_SAND_VERBENA),
    REED("",0x0, BushVariant.REED),
    RIVER_CANE("",0x0, BushVariant.RIVER_CANE),
    RHODODENDRON_PINK(FlowerColor.PINK_BUT_MAGENTA, 0xFF3A75, BushVariant.RHODODENDRON),
    RHODODENDRON_PURPLE(FlowerColor.PURPLE, 0x895FB4, BushVariant.RHODODENDRON),
    ROSEVINE_ORANGE(FlowerColor.ORANGE, 0xFF9260, BushVariant.ROSEVINE),
    ROSEVINE_PINK(FlowerColor.PINK, 0xFF9EAC, BushVariant.ROSEVINE),
    ROSEVINE_RED(FlowerColor.RED, 0xFF0026, BushVariant.ROSEVINE),
    ROSEVINE_WHITE(FlowerColor.WHITE, 0xFFFFFF, BushVariant.ROSEVINE),
    ROSEVINE_YELLOW(FlowerColor.YELLOW, 0xFFDD60, BushVariant.ROSEVINE),
    STRANGLING_VINE("",0x0, BushVariant.STRANGLING_VINE),
    SCOTCHBROOM_PURPLE(FlowerColor.PURPLE_BUT_MAGENTA, 0xEC47B3, BushVariant.SCOTCHBROOM),
    SCOTCHBROOM_YELLOW(FlowerColor.YELLOW, 0xF2C337, BushVariant.SCOTCHBROOM),
    SNOWDROP(FlowerColor.WHITE, 0xFFFFFF, BushVariant.SNOWDROP),
    SPIDERGRASS(FlowerColor.WHITE, 0xFFFFFF, BushVariant.SPIDERGRASS),
    SUCCULENT("", 0x0, BushVariant.SUCCULENT),
    TAMARISK(FlowerColor.PINK, 0xFFD1DB, BushVariant.TAMARISK),
    TANSY(FlowerColor.YELLOW, 0xF7B531, BushVariant.TANSY),
    THUJA("", 0x0, BushVariant.THUJA),
    THUJA_LARGE("", 0x0, BushVariant.THUJA_LARGE),
    THUJA_LIMEGREEN("", 0x0, BushVariant.THUJA_LIMEGREEN),
    THUJA_LIMEGREEN_LARGE("", 0x0, BushVariant.THUJA_LIMEGREEN_LARGE),
    THISTLE(FlowerColor.PINK_BUT_MAGENTA, 0xD559FF, BushVariant.THISTLE),
    VIBURNUM_PINK(FlowerColor.PINK, 0xFBD8E7, BushVariant.VIBURNUM),
    VIBURNUM_WHITE(FlowerColor.WHITE, 0xEFEFC4, BushVariant.VIBURNUM),
    VIOLET_PURPLE(FlowerColor.PURPLE, 0xEFEFC4, BushVariant.VIOLET),
    WILD_WHEAT(FlowerColor.YELLOW, 0xD8CA6E, BushVariant.WILD_WHEAT),
    WISTERIA_PINK(FlowerColor.PINK_BUT_MAGENTA, 0xF499F7, BushVariant.WISTERIA),
    YEW_BUSH("", 0x0, BushVariant.YEW_BUSH),
    YUCCA(FlowerColor.WHITE, 0xFFFFFF, BushVariant.YUCCA),
    ;

    @Nullable
    private final String variantName;
    @Nullable
    private final FlowerColor colorType;
    private final int color;
    private final BushVariant variant;
    private String item;

    private BushType(FlowerColor colorType, int color, BushVariant variant){
        this.colorType = colorType;
        this.color = color;
        this.variant = variant;
        this.variantName = null;
    }

    private BushType(String variantName, int color, BushVariant variant){
        this.colorType = null;
        this.color = color;
        this.variant = variant;
        this.variantName = variantName;
    }

    BushType(FlowerColor colorType, int color, BushVariant variant, String item) {
        this(colorType, color, variant);
        this.item = item;
    }

    public String getVariantName() {
        return variantName;
    }

    public BushVariant getVariant() {
        return variant;
    }

    public String getItem() {
        return item;
    }

    public int getColor() {
        return color;
    }

    public String getColorName() {
        if(colorType == null){
            return "";
        }
        return colorType.getName();
    }

    public FlowerColor getColorType() {
        return colorType;
    }

    public boolean hasConfig(){
        return getVariant().getConfig() != null;
    }

    public BushConfig getConfig() {
        return getVariant().getConfig();
    }
}
