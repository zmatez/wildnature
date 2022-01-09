package net.matez.wildnature.common.registry.blocks;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.blocks.fruit_bush.leaves.FruitBushType;
import net.matez.wildnature.common.objects.blocks.fruit_bush.leaves.WNFruitBushTypedBlock;
import net.matez.wildnature.common.objects.blocks.fruit_bush.plants.FruitPlantType;
import net.matez.wildnature.common.objects.blocks.fruit_bush.plants.WNFruitBushPlantTypedBlock;
import net.matez.wildnature.common.objects.blocks.grass.*;
import net.matez.wildnature.common.objects.blocks.leaves.LeafBushType;
import net.matez.wildnature.common.objects.blocks.leaves.LeafType;
import net.matez.wildnature.common.objects.blocks.leaves.WNBushLeafBlock;
import net.matez.wildnature.common.objects.blocks.leaves.WNLeavesTypedBlock;
import net.matez.wildnature.common.objects.blocks.plant.BushSetup;
import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.plant.BushVariant;
import net.matez.wildnature.common.objects.blocks.plant.flowering.WNCloverBlock;
import net.matez.wildnature.common.objects.blocks.rocks.*;
import net.matez.wildnature.common.objects.blocks.sand.SandType;
import net.matez.wildnature.common.objects.blocks.sand.WNMudBlock;
import net.matez.wildnature.common.objects.blocks.sand.WNQuicksandBlock;
import net.matez.wildnature.common.objects.blocks.sand.WNSandBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.blocks.wood.*;
import net.matez.wildnature.common.objects.initializer.ExcludeInit;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.common.registry.tabs.WNTabs;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Initialize(InitStage.CONSTRUCT)
public class WNBlocks {
    @ExcludeInit
    private static final WNLogger log = WildNature.getLogger();

    //# --- ALL BLOCKS ---
    public static final LinkedHashMap<ResourceLocation, WNBlock> BLOCKS = new LinkedHashMap<>();
    //#-------------------
    //?---
    //# --- ENUM MAPS ---

    //################# WOODEN STUFF
    public static final LinkedHashMap<LogType, WNBlock> LOGS = register(LogType.values(), (value) -> {
        //todo different strength for logs
        return new WNLogBlock(
                location(value.getIdBase() + "_log"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(value.getTab()),
                value, false, false
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> PLANKS = register(LogType.values(), (value) -> {
        if (value.getParent() != null) {
            return null;
        }
        //todo different strength for logs
        return new WNPlanksBlock(
                location(value.getIdBase() + "_planks"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> PARQUET = register(LogType.values(), (value) -> {
        //todo different strength for logs
        if (value.getParent() != null) {
            return null;
        }
        return new WNPlanksBlock(
                location(value.getIdBase() + "_parquet"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> STRIPPED_LOGS = register(LogType.values(), (value) -> {
        //todo different strength for logs
        if (value.getParent() != null) {
            return null;
        }
        return new WNLogBlock(
                location(value.getIdBase() + "_stripped_log"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value, true, false
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> WOODS = register(LogType.values(), (value) -> {
        //todo different strength for logs
        return new WNLogBlock(
                location(value.getIdBase() + "_wood"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value, false, true
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> STRIPPED_WOODS = register(LogType.values(), (value) -> {
        //todo different strength for logs
        if (value.getParent() != null) {
            return null;
        }
        return new WNLogBlock(
                location(value.getIdBase() + "_stripped_wood"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value, true, true
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> SLAB_PLANKS = register(LogType.values(), (value) -> {
        if (value.getParent() != null) {
            return null;
        }
        //todo different strength for logs
        return new WNPlanksSlabBlock(
                location(value.getIdBase() + "_slab"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F, 3.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value, false
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> SLAB_PARQUET = register(LogType.values(), (value) -> {
        //todo different strength for logs
        if (value.getParent() != null) {
            return null;
        }
        return new WNPlanksSlabBlock(
                location(value.getIdBase() + "_slab_parquet"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F, 3.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value, true
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> STAIRS_PLANKS = register(LogType.values(), (value) -> {
        if (value.getParent() != null) {
            return null;
        }
        return new WNPlanksStairBlock(
                location(value.getIdBase() + "_stairs"),
                () -> PLANKS.get(value).defaultBlockState(),
                BlockBehaviour.Properties.copy(PLANKS.get(value)),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value, false
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> STAIRS_PARQUET = register(LogType.values(), (value) -> {
        if (value.getParent() != null) {
            return null;
        }
        return new WNPlanksStairBlock(
                location(value.getIdBase() + "_stairs_parquet"),
                () -> PARQUET.get(value).defaultBlockState(),
                BlockBehaviour.Properties.copy(PLANKS.get(value)),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value, true
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> WOODEN_FENCES = register(LogType.values(), (value) -> {
        //todo different strength for logs
        if (value.getParent() != null) {
            return null;
        }
        return new WNPlanksFenceBlock(
                location(value.getIdBase() + "_fence"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F, 3.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> WOODEN_FENCE_GATES = register(LogType.values(), (value) -> {
        //todo different strength for logs
        if (value.getParent() != null) {
            return null;
        }
        return new WNPlanksFenceGateBlock(
                location(value.getIdBase() + "_fence_gate"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F, 3.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> WOODEN_BUTTONS = register(LogType.values(), (value) -> {
        //todo different strength for logs
        if (value.getParent() != null) {
            return null;
        }
        return new WNPlanksButton(
                location(value.getIdBase() + "_button"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .noCollission()
                        .strength(0.5F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> WOODEN_PRESSURE_PLATE = register(LogType.values(), (value) -> {
        //todo different strength for logs
        if (value.getParent() != null) {
            return null;
        }
        return new WNPlanksPressurePlate(
                location(value.getIdBase() + "_pressure_plate"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .noCollission()
                        .strength(0.5F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> WOODEN_DOORS = register(LogType.values(), (value) -> {
        //todo different strength for logs
        return new WNLogDoorBlock(
                location(value.getIdBase() + "_door"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .noOcclusion()
                        .strength(3F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> WOODEN_TRAPDOORS = register(LogType.values(), (value) -> {
        //todo different strength for logs
        return new WNLogTrapDoorBlock(
                location(value.getIdBase() + "_trapdoor"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .noOcclusion()
                        .strength(3F)
                        .sound(SoundType.WOOD)
                        .isValidSpawn((a, b, c, d) -> {
                            return false;
                        }),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<LogType, WNBlock> BRANCHES = register(LogType.values(), (value) -> {
        //todo different strength for logs
        return new WNBranchBlock(
                location(value.getIdBase() + "_branch"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(1.4F)
                        .sound(SoundType.WOOD)
                        .noOcclusion(),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
        );
    });

    //################# GRASS
    public static final LinkedHashMap<GrassType, WNBlock> GRASSES = register(GrassType.values(), (value) -> {
        return new WNGrassBlock(
                location(value.getIdBase() + "_grass_block"),
                BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS)
                        .strength(0.6F)
                        .sound(SoundType.GRASS)
                        .randomTicks(),
                new Item.Properties()
                        .tab(WNTabs.TAB_SURFACE),
                value
        );
    });
    public static final WNBlock ALGAE_BLOCK = register(new WNAlgaeBlock(
            location("algae_block"),
            BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS)
                    .strength(0.4F)
                    .sound(SoundType.WET_GRASS)
                    .randomTicks(),
            new Item.Properties()
                    .tab(WNTabs.TAB_UNDERWATER)
    ));
    public static final LinkedHashMap<GrassType, WNBlock> DIRTS = register(GrassType.values(), (value) -> {
        return new WNDirtBlock(
                location(value.getIdBase() + "_dirt"),
                BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT)
                        .strength(0.5F)
                        .sound(SoundType.GRAVEL),
                new Item.Properties()
                        .tab(WNTabs.TAB_SURFACE),
                value
        );
    });
    public static final WNBlock DRIED_SOIL = register(new WNDirtBlock(
            location("dried_soil"),
            BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT)
                    .strength(0.4F)
                    .sound(SoundType.GRAVEL),
            new Item.Properties()
                    .tab(WNTabs.TAB_SURFACE), null
    ));
    public static final LinkedHashMap<GrassType, WNBlock> PODZOLS = register(GrassType.values(), (value) -> {
        return new WNPodzolBlock(
                location(value.getIdBase() + "_podzol"),
                BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.PODZOL)
                        .strength(0.5F)
                        .sound(SoundType.GRAVEL),
                new Item.Properties()
                        .tab(WNTabs.TAB_SURFACE),
                value
        );
    });
    public static final LinkedHashMap<GrassType, WNBlock> COARSE_DIRTS = register(GrassType.values(), (value) -> {
        return new WNDirtBlock(
                location(value.getIdBase() + "_coarse_dirt"),
                BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT)
                        .strength(0.5F)
                        .sound(SoundType.GRAVEL),
                new Item.Properties()
                        .tab(WNTabs.TAB_SURFACE),
                value
        );
    });
    public static final LinkedHashMap<GrassType, WNBlock> DIRT_PATHS = register(GrassType.values(), (value) -> {
        return new WNDirtPathBlock(
                location(value.getIdBase() + "_dirt_path"),
                BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_PURPLE)
                        .strength(0.65F)
                        .sound(SoundType.GRASS)
                        .isViewBlocking(WNBlocks::always)
                        .isSuffocating(WNBlocks::always),
                new Item.Properties()
                        .tab(WNTabs.TAB_SURFACE),
                value
        );
    });
    public static final LinkedHashMap<GrassType, WNBlock> FARMS = register(GrassType.values(), (value) -> {
        return new WNFarmBlock(
                location(value.getIdBase() + "_farmland"),
                BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_PURPLE)
                        .strength(0.6F)
                        .randomTicks()
                        .sound(SoundType.GRASS)
                        .isViewBlocking(WNBlocks::always)
                        .isSuffocating(WNBlocks::always),
                new Item.Properties()
                        .tab(WNTabs.TAB_SURFACE),
                value
        );
    });
    public static final WNBlock SOIL = register(new WNSoilBlock(
            location("soil"),
            BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT)
                    .strength(0.6F)
                    .sound(SoundType.GRAVEL),
            new Item.Properties()
                    .tab(WNTabs.TAB_SURFACE), null
    ));
    //################# LEAVES
    public static final LinkedHashMap<LeafType, WNBlock> LEAVES = register(LeafType.values(), (value) -> {
        return WNLeavesTypedBlock.create(
                location(value.getIdBase() + "_leaves"),
                BlockBehaviour.Properties.of(Material.LEAVES, value.getColor())
                        .strength(0.2F)
                        .sound(SoundType.GRASS)
                        .randomTicks()
                        .noOcclusion()
                        .isValidSpawn(WNBlocks::ocelotOrParrot)
                        .isSuffocating(WNBlocks::never)
                        .isViewBlocking(WNBlocks::never),
                new Item.Properties()
                        .tab(value.getTab()),
                value
        );
    });
    public static final LinkedHashMap<LeafBushType, WNBlock> BUSH_LEAVES = register(LeafBushType.values(), (value) -> {
        return new WNBushLeafBlock(
                location(value.getIdBase() + "_bush"),
                BlockBehaviour.Properties.of(Material.LEAVES, value.getColor())
                        .strength(0.2F)
                        .sound(SoundType.GRASS)
                        .noOcclusion()
                        .isValidSpawn(WNBlocks::ocelotOrParrot)
                        .isSuffocating(WNBlocks::never)
                        .isViewBlocking(WNBlocks::never),
                new Item.Properties()
                        .tab(WNTabs.TAB_SURFACE_PLANTS),
                value
        );
    });
    //################# FLOWERS
    public static final LinkedHashMap<BushType, WNBlock> BUSHES = register(BushType.values(), (value) -> {
        BlockBehaviour.Properties blockProp = BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.PLANT)
                .sound(SoundType.GRASS)
                .instabreak()
                .noOcclusion()
                .noCollission()
                .dynamicShape()
                .randomTicks();
        Item.Properties itemProp = new Item.Properties()
                .tab(WNTabs.TAB_SURFACE_PLANTS);

        return value.getVariant().getSetup().getConstructor().get(value, blockProp, itemProp);
    });

    //################# FRUIT_BUSHES
    public static final LinkedHashMap<FruitBushType, WNBlock> FRUIT_BUSH_LEAVES = register(FruitBushType.values(), (value) -> {
        return WNFruitBushTypedBlock.create(
                location(value.getIdBase() + "_bush"),
                BlockBehaviour.Properties.of(Material.LEAVES, value.getColor())
                        .strength(0.2F)
                        .sound(SoundType.GRASS)
                        .randomTicks()
                        .noOcclusion()
                        .isSuffocating(WNBlocks::never)
                        .isViewBlocking(WNBlocks::never),
                new Item.Properties()
                        .tab(value.getTab()),
                value
        );
    });

    public static final LinkedHashMap<FruitPlantType, WNBlock> FRUIT_BUSH_PLANTS = register(FruitPlantType.values(), (value) -> {
        BlockBehaviour.Properties blockProp = BlockBehaviour.Properties.of(Material.PLANT, value.getColor())
                .strength(0.2F)
                .sound(SoundType.SWEET_BERRY_BUSH)
                .noOcclusion()
                .noCollission()
                .dynamicShape()
                .randomTicks();
        Item.Properties itemProp = new Item.Properties()
                        .tab(value.getTab());

        if(value.getConfig().getConstructor() != null){
            return value.getConfig().getConstructor().get(value,blockProp,itemProp);
        }

        return WNFruitBushPlantTypedBlock.create(
                location(value.getIdBase() + "_bush"),
                blockProp,
                itemProp,
                value
        );
    });



    //################# SANDS
    public static final LinkedHashMap<SandType, WNSandBlock> SANDS = register(SandType.values(), (value) -> {
        return new WNSandBlock(
                location(value.getIdBase() + "_sand"),
                BlockBehaviour.Properties.of(Material.SAND, value.getColor())
                        .strength(0.5F)
                        .sound(SoundType.SAND),
                new Item.Properties()
                        .tab(WNTabs.TAB_SURFACE),
                value
        );
    });
    public static final WNMudBlock MUD = register(new WNMudBlock(
            location("mud"),
            BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT)
                    .strength(0.7F)
                    .sound(SoundType.GRAVEL),
            new Item.Properties()
                    .tab(WNTabs.TAB_SURFACE)
    ));
    public static final WNQuicksandBlock QUICKSAND = register(new WNQuicksandBlock(
            location("quicksand"),
            BlockBehaviour.Properties.of(Material.SAND, MaterialColor.TERRACOTTA_YELLOW)
                    .strength(0.5F)
                    .sound(SoundType.SAND),
            new Item.Properties()
                    .tab(WNTabs.TAB_SURFACE)
    ));

    private static final float HARD_ROCK_HARDNESS = 2.7F;
    //################# ROCKS
    public static final LinkedHashMap<RockType, WNBlock> ROCKS = register(RockType.values(), (value) -> {
        return new WNRockBlock(
                location(value.getIdBase()),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_CAVES),
                value
        );
    });
    public static final WNBlock IGNEOUS_BASANITE = register(new WNRockMagmaBlock(
            location("igneous_basanite"),
            BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                    .strength(HARD_ROCK_HARDNESS, 4F)
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops(),
            new Item.Properties()
                    .tab(WNTabs.TAB_CAVES),
            RockType.BASANITE
    ));
    public static final WNBlock SALT = register(new WNSaltBlock(
            location("salt"),
            BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)
                    .strength(1.8F, 4F)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops(),
            new Item.Properties()
                    .tab(WNTabs.TAB_CAVES)
    ));
    public static final LinkedHashMap<RockType, WNBlock> ROCK_SLABS = register(RockType.values(), (value) -> {
        return new WNRockSlabBlock(
                location(value.getIdBase() + "_slabs"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value, () -> ROCKS.get(value)
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCK_STAIRS = register(RockType.values(), (value) -> {
        return new WNRockStairBlock(
                location(value.getIdBase() + "_stairs"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value, () -> ROCKS.get(value)
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCKS_POLISHED = register(RockType.values(), (value) -> {
        return new WNRockBlock(
                location(value.getIdBase() + "_polished"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCK_POLISHED_SLABS = register(RockType.values(), (value) -> {
        return new WNRockSlabBlock(
                location(value.getIdBase() + "_polished_slabs"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value, () -> ROCKS_POLISHED.get(value)
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCK_POLISHED_STAIRS = register(RockType.values(), (value) -> {
        return new WNRockStairBlock(
                location(value.getIdBase() + "_polished_stairs"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value, () -> ROCKS_POLISHED.get(value)
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCK_POLISHED_WALLS = register(RockType.values(), (value) -> {
        return new WNRockWallBlock(
                location(value.getIdBase() + "_polished_wall"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value, () -> ROCKS_POLISHED.get(value)
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCKS_BRICKS = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockBlock(
                location(value.getIdBase() + "_bricks"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCK_BRICK_SLABS = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockSlabBlock(
                location(value.getIdBase() + "_brick_slabs"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value, () -> ROCKS_BRICKS.get(value)
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCK_BRICK_STAIRS = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockStairBlock(
                location(value.getIdBase() + "_brick_stairs"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value, () -> ROCKS_BRICKS.get(value)
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCK_BRICK_WALL = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockWallBlock(
                location(value.getIdBase() + "_brick_wall"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value, () -> ROCKS_BRICKS.get(value)
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCKS_BRICKS_ANCIENT = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockBlock(
                location(value.getIdBase() + "_bricks_ancient"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCKS_BRICKS_CHISELED = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockBlock(
                location(value.getIdBase() + "_bricks_chiseled"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCKS_BRICKS_CRACKED = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockBlock(
                location(value.getIdBase() + "_bricks_cracked"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCKS_BRICKS_MOSSY = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockBlock(
                location(value.getIdBase() + "_bricks_mossy"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCK_BRICK_MOSSY_SLABS = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockSlabBlock(
                location(value.getIdBase() + "_brick_mossy_slabs"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value, () -> ROCKS_BRICKS_MOSSY.get(value)
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCK_BRICK_MOSSY_STAIRS = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockStairBlock(
                location(value.getIdBase() + "_brick_mossy_stairs"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value, () -> ROCKS_BRICKS_MOSSY.get(value)
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCK_BRICK_MOSSY_WALL = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockWallBlock(
                location(value.getIdBase() + "_brick_mossy_wall"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value, () -> ROCKS_BRICKS_MOSSY.get(value)
        );
    });
    public static final LinkedHashMap<RockType, WNBlock> ROCKS_BRICKS_SMALL = register(RockType.values(), (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockBlock(
                location(value.getIdBase() + "_bricks_small"),
                BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(),
                new Item.Properties()
                        .tab(WNTabs.TAB_ROCK_BUILDING),
                value
        );
    });


    //#------------------
    //?---


    //!------------------
    public static ResourceLocation location(String name) {
        return new ResourceLocation(WildNature.modid, name);
    }

    private static <T extends WNBlock> T register(T block) {
        block.construct();
        BLOCKS.put(block.getRegistryName(), block);
        return block;
    }

    private static <T, U extends WNBlock> LinkedHashMap<T, U> register(T[] list, BlockRegisterCallback<T, U> register) {
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

    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

    private static Boolean ocelotOrParrot(BlockState p_50822_, BlockGetter p_50823_, BlockPos p_50824_, EntityType<?> p_50825_) {
        return p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT;
    }
}
