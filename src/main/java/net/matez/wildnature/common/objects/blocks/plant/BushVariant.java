package net.matez.wildnature.common.objects.blocks.plant;

import net.matez.wildnature.common.objects.blocks.plant.config.BushConfig;
import net.matez.wildnature.common.objects.blocks.plant.config.FloweringBushConfig;
import net.minecraft.world.level.block.BushBlock;

public enum BushVariant {
    ANEMONE("anemone",BushSetup.ANEMONE, FloweringBushConfig.NO_COLORS.get()),
    ANTHURIUM("anthurium",BushSetup.FLOWERING_BUSH),
    AZALEA("azalea",BushSetup.FLOWERING_BUSH),
    BIRD_OF_PARADISE("bird_of_paradise",BushSetup.DOUBLE_FLOWERING_BUSH, FloweringBushConfig.NO_COLORS.get()),
    BLUEBELL("bluebell",BushSetup.FLOWERING_BUSH, FloweringBushConfig.NO_COLORS.get()),
    BOXWOOD("boxwood",BushSetup.BUSH,"plants/surface/shrub", FloweringBushConfig.NO_COLORS.get().makeTintAsFoliage()),
    BUTTERCUP("buttercup",BushSetup.FLOWERING_BUSH),
    CANNA_BULB("canna_bulb",BushSetup.FLOWERING_BUSH),
    CARNATION("carnation",BushSetup.FLOWERING_BUSH),
    CATNIP("catnip",BushSetup.FLOWERING_BUSH),
    CATTAIL("cattail",BushSetup.DOUBLE_BUSH,BushConfig.NOT_TINTED.get()),
    CHAMOMILE("chamomile",BushSetup.FLOWERING_BUSH),
    CHAMOMILE_LARGE("chamomile_large",BushSetup.DOUBLE_FLOWERING_BUSH,"plants/surface/chamomile"),
    CHINESE_LANTERN("chinese_lantern_flower",BushSetup.CHINESE_LANTERN_FLOWER, FloweringBushConfig.NO_COLORS.get().makeTintAsFoliage()),
    CHRYSANTHEMUM("chrysanthemum",BushSetup.FLOWERING_BUSH),
    CLEMATIS("clematis",BushSetup.DOUBLE_FLOWERING_LEAFED_BUSH),
    CLOVER("clover",BushSetup.CLOVER),
    COLUMBINE("columbine",BushSetup.DOUBLE_FLOWERING_BUSH),
    CORDYLINE_AUSTRALIS("cordyline_australis",BushSetup.BUSH,BushConfig.NOT_TINTED.get()),
    CROCUS("crocus",BushSetup.FLOWERING_LEAFED_BUSH),
    DAFFODIL("daffodil",BushSetup.FLOWERING_BUSH),
    FESTUCA_ELIJAHBLUE("festuca_elijahblue",BushSetup.BUSH,"plants/surface/festuca", BushConfig.NOT_TINTED.get().withPlacement(BushPlacement.DIRT_OR_SAND)),
    FESTUCA_LARGE("festuca",BushSetup.DOUBLE_BUSH,"plants/surface/festuca", BushConfig.NOT_TINTED.get().withPlacement(BushPlacement.DIRT_OR_SAND)),
    FIREWEED("fireweed",BushSetup.DOUBLE_FLOWERING_BUSH,FloweringBushConfig.NO_COLORS.get()),
    FLY_TRAP("fly_trap",BushSetup.FLY_TRAP,BushConfig.NOT_TINTED.get()),
    FOREST_MOSS("forest_moss",BushSetup.MOSS,BushConfig.NOT_TINTED.get().withPlacement(BushPlacement.ALL_NATURAL)),
    FORGET_ME_NOT("forget_me_not",BushSetup.FLOWERING_BUSH),
    GERANIUM("geranium",BushSetup.FLOWERING_BUSH),
    GIANT_HOGWEED("giant_hogweed",BushSetup.DOUBLE_FLOWERING_BUSH,FloweringBushConfig.NO_COLORS.get()),
    GLADIOLUS("gladiolus",BushSetup.DOUBLE_FLOWERING_BUSH),
    GOLDENROD("goldenrod",BushSetup.DOUBLE_FLOWERING_LEAFED_BUSH,FloweringBushConfig.NO_COLORS.get()),
    FERNSPROUT("fernsprout",BushSetup.BUSH,"plants/surface/grass",new BushConfig().makeTintAsFoliage()),
    GRASS_FLOWER("grass_flower",BushSetup.FLOWERING_BUSH,"plants/surface/grass",FloweringBushConfig.NO_COLORS.get()),
    GRASS_WHEAT("grass_wheat",BushSetup.FLOWERING_BUSH,"plants/surface/grass",FloweringBushConfig.NO_COLORS.get()),
    DESERT_GRASS("desert_grass",BushSetup.BUSH,"plants/surface/grass",BushConfig.NOT_TINTED.get().makeSelfItem().withPlacement(BushPlacement.SAND)),
    DEAD_SHORT_GRASS("dead_short_grass",BushSetup.BUSH,"plants/surface/grass",BushConfig.NOT_TINTED.get().makeSelfItem().withPlacement(BushPlacement.SAND)),
    MEDIUM_GRASS("medium_grass",BushSetup.BUSH,"plants/surface/grass"),
    SEABEACH_SANDWORT("seabeach_sandwort",BushSetup.BUSH,BushConfig.NOT_TINTED.get().makeSelfItem().withPlacement(BushPlacement.SAND)),
    SHRUB("shrub",BushSetup.SHRUB,new BushConfig().makeTintAsFoliage().withPlacement(BushPlacement.DIRT_OR_SAND)),
    SMALL_CACTI("small_cacti",BushSetup.SMALL_CACTI,BushConfig.NOT_TINTED.get().makeSelfItem().withPlacement(BushPlacement.SAND)),
    SMALL_GRASS("small_grass",BushSetup.BUSH,"plants/surface/grass"),
    HEATH("heath",BushSetup.FLOWERING_BUSH),
    HEATHER("heather",BushSetup.FLOWERING_BUSH),
    HEPATICA("hepatica",BushSetup.FLOWERING_BUSH),
    HOLLYHOCK("hollyhock",BushSetup.DOUBLE_FLOWERING_BUSH),
    HONEYSUCKLE("honeysuckle",BushSetup.DOUBLE_FLOWERING_LEAFED_BUSH),
    HOTTENTOT("hottentot",BushSetup.FLOWERING_BUSH,FloweringBushConfig.NO_COLORS.get()),
    HYACINTH("hyacinth",BushSetup.FLOWERING_BUSH),
    HYDRANGEA("hydrangea",BushSetup.FLOWERING_BUSH),
    IRIS("iris",BushSetup.FLOWERING_BUSH),
    LAMPGRASS("lampgrass",BushSetup.FLOWERING_BUSH,FloweringBushConfig.NO_COLORS.get()),
    LAVENDER("lavender",BushSetup.FLOWERING_BUSH),
    LICHEN("lichen",BushSetup.LICHEN,BushConfig.NOT_TINTED.get().withPlacement(BushPlacement.ALL_NATURAL)),
    LUPINE("lupine",BushSetup.FLOWERING_BUSH),
    MARIGOLD("marigold",BushSetup.FLOWERING_BUSH),
    MATTHIOLA("matthiola",BushSetup.FLOWERING_BUSH),
    MISCANTHUS("miscanthus",BushSetup.DOUBLE_FLOWERING_BUSH,FloweringBushConfig.NO_COLORS.get()),
    MONKSHOOD("monkshood",BushSetup.DOUBLE_FLOWERING_LEAFED_BUSH),
    NETTLE("nettle",BushSetup.NETTLE),
    ORCHID("orchid",BushSetup.FLOWERING_BUSH),
    PASQUE("pasque",BushSetup.FLOWERING_BUSH),
    PEACE_LILY("peace_lily",BushSetup.FLOWERING_BUSH,FloweringBushConfig.NO_COLORS.get()),
    PERENNIAL("perennial",BushSetup.FLOWERING_BUSH),
    POISON_IVY("poison_ivy",BushSetup.POISON_IVY),
    PRAIRIE_GRASS("prairie_grass",BushSetup.FLOWERING_BUSH,FloweringBushConfig.NO_COLORS.get()),
    PRICKLY_PEAR_CACTUS("prickly_pear_cactus",BushSetup.PRICKLY_PEAR, FloweringBushConfig.NO_COLORS.get().notTinted().withPlacement(BushPlacement.SAND)),
    PRIMROSE("primrose",BushSetup.FLOWERING_BUSH),
    RADISSIUM("radissium",BushSetup.FLOWERING_BUSH),
    RAPESEED("rapeseed",BushSetup.DOUBLE_FLOWERING_BUSH,FloweringBushConfig.NO_COLORS.get()),
    RED_SAND_VERBENA("red_sand_verbena",BushSetup.FLOWERING_BUSH,FloweringBushConfig.NO_COLORS.get().withPlacement(BushPlacement.SAND)),
    REED("reed",BushSetup.REEDS,BushConfig.NOT_TINTED.get().withPlacement(BushPlacement.DIRT_OR_SAND).makeSelfItem()),
    RIVER_CANE("river_cane",BushSetup.RIVER_CANE,BushConfig.NOT_TINTED.get().withPlacement(BushPlacement.DIRT_OR_SAND)),
    RHODODENDRON("rhododendron",BushSetup.BIG_BUSH),
    ROSEVINE("rosevine",BushSetup.FLOWERING_VINE,BushConfig.NOT_TINTED.get().makeSelfItem()),
    STRANGLING_VINE("strangling_vine",BushSetup.STRANGLING_VINE),
    SCOTCHBROOM("scotchbroom",BushSetup.DOUBLE_FLOWERING_BUSH),
    SNOWDROP("snowdrop",BushSetup.FLOWERING_BUSH,FloweringBushConfig.NO_COLORS.get().notTinted()),
    SPIDERGRASS("spidergrass",BushSetup.SPIDERGRASS,FloweringBushConfig.NO_COLORS.get()),
    SUCCULENT("succulent",BushSetup.SUCCULENT,BushConfig.NOT_TINTED.get().withPlacement(BushPlacement.DIRT_OR_SAND)),
    TAMARISK("tamarisk",BushSetup.BIG_BUSH,FloweringBushConfig.NO_COLORS.get()),
    TANSY("tansy", BushSetup.FLOWERING_LEAFED_BUSH),
    THISTLE("thistle", BushSetup.THISTLE,FloweringBushConfig.NO_COLORS.get()),
    THUJA("thuja", BushSetup.BUSH,"plants/surface/thuja",new BushConfig().makeSelfItem().itemTinted().makeTintAsFoliage()),
    THUJA_LARGE("thuja_large", BushSetup.DOUBLE_BUSH,"plants/surface/thuja",new BushConfig().makeSelfItem().itemTinted().makeTintAsFoliage()),
    THUJA_LIMEGREEN("thuja_limegreen", BushSetup.BUSH,"plants/surface/thuja",BushConfig.NOT_TINTED.get().makeSelfItem()),
    THUJA_LIMEGREEN_LARGE("thuja_limegreen_large", BushSetup.DOUBLE_BUSH,"plants/surface/thuja",BushConfig.NOT_TINTED.get().makeSelfItem()),
    VIBURNUM("viburnum",BushSetup.FLOWERING_BUSH),
    VIOLET("violet",BushSetup.FLOWERING_BUSH),
    WILD_WHEAT("wild_wheat",BushSetup.FLOWERING_BUSH,FloweringBushConfig.NO_COLORS.get()),
    WISTERIA("wisteria",BushSetup.WISTERIA,BushConfig.NOT_TINTED.get().withPlacement(BushPlacement.LEAVES)),
    YUCCA("yucca",BushSetup.YUCCA,FloweringBushConfig.NO_COLORS.get().notTinted()),
    YEW_BUSH("yew_bush",BushSetup.BUSH,"plants/surface/shrub",FloweringBushConfig.NO_COLORS.get().makeTintAsFoliage()),
    ;

    private final BushSetup setup;
    private final String baseName;
    private String path = "plants/surface/";
    private boolean customPath = false;
    private final BushConfig config;

    private BushVariant(String baseName, BushSetup setup){
        this.baseName = baseName;
        this.setup = setup;
        this.config = null;
    }

    private BushVariant(String baseName, BushSetup setup, BushConfig config){
        this.baseName = baseName;
        this.setup = setup;
        this.config = config;
    }

    BushVariant(String baseName, BushSetup setup, String path) {
        this.setup = setup;
        this.baseName = baseName;
        this.path = path;
        this.customPath = true;
        this.config = null;
    }

    BushVariant(String baseName, BushSetup setup, String path, BushConfig config) {
        this.setup = setup;
        this.baseName = baseName;
        this.path = path;
        this.customPath = true;
        this.config = config;
    }

    public BushSetup getSetup() {
        return setup;
    }

    public String getBaseName() {
        return baseName;
    }

    public String getPath(){
        return customPath ? path : (path + getBaseName());
    }

    public BushConfig getConfig() {
        return config;
    }
}
