/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.core.registry;

import com.mojang.datafixers.util.Either;
import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.block.BlockFactory;
import net.matez.wildnature.common.block.cave_plants.CavePlantType;
import net.matez.wildnature.common.block.crops.CropType;
import net.matez.wildnature.common.block.crops.WNCropTypedBlock;
import net.matez.wildnature.common.block.dev.WNDevBlock;
import net.matez.wildnature.common.block.fruit_bush.leaves.FruitBushType;
import net.matez.wildnature.common.block.fruit_bush.leaves.WNFruitBushTypedBlock;
import net.matez.wildnature.common.block.fruit_bush.plants.FruitPlantType;
import net.matez.wildnature.common.block.fruit_bush.plants.WNFruitBushPlantTypedBlock;
import net.matez.wildnature.common.block.fruit_bush.vines.FruitVineType;
import net.matez.wildnature.common.block.fruit_bush.vines.WNFruitVineBlock;
import net.matez.wildnature.common.block.geyser.WNGeyserBlock;
import net.matez.wildnature.common.block.grass.GrassType;
import net.matez.wildnature.common.block.grass.OvergrownGrassType;
import net.matez.wildnature.common.block.grass.WNOvergrownStoneBlock;
import net.matez.wildnature.common.block.grass.WNSoilBlock;
import net.matez.wildnature.common.block.lanterns.Lantern;
import net.matez.wildnature.common.block.lanterns.WNLanternBlock;
import net.matez.wildnature.common.block.leaves.LeafBushType;
import net.matez.wildnature.common.block.leaves.LeafType;
import net.matez.wildnature.common.block.leaves.WNBushLeafBlock;
import net.matez.wildnature.common.block.leaves.WNLeavesTypedBlock;
import net.matez.wildnature.common.block.mushrooms.*;
import net.matez.wildnature.common.block.ores.*;
import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.rocks.*;
import net.matez.wildnature.common.block.sand.SandType;
import net.matez.wildnature.common.block.sand.WNQuicksandBlock;
import net.matez.wildnature.common.block.sand.WNSandBlock;
import net.matez.wildnature.common.block.saplings.WNSaplingBlock;
import net.matez.wildnature.common.block.saplings.WNSaplingType;
import net.matez.wildnature.common.block.shells.Shell;
import net.matez.wildnature.common.block.shells.WNShellBlock;
import net.matez.wildnature.common.block.underwater_plants.*;
import net.matez.wildnature.common.block.water_plants.WaterPlant;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.block.wood.building.*;
import net.matez.wildnature.common.block.wood.furniture.*;
import net.matez.wildnature.common.block.wood.vanilla.VanillaLogType;
import net.matez.wildnature.common.block.wood.vanilla.building.WNVanillaBranchBlock;
import net.matez.wildnature.common.block.wood.vanilla.building.WNVanillaPlanksBlock;
import net.matez.wildnature.common.block.wood.vanilla.building.WNVanillaPlanksSlabBlock;
import net.matez.wildnature.common.block.wood.vanilla.building.WNVanillaPlanksStairBlock;
import net.matez.wildnature.common.block.wood.vanilla.furniture.WNVanillaChairBlock;
import net.matez.wildnature.common.block.wood.vanilla.furniture.WNVanillaTableBlock;
import net.matez.wildnature.core.other.WNTabs;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class WNBlocks {
    private static final SimpleLogger log = WildNature.getLogger();
    public static final Supplier<Item.Properties> DEFAULT_PROPERTIES = Item.Properties::new;

    //# BLOCK REGISTRY #\\
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, WildNature.modid);


    //#-------------- #\\
    //# - ENUM MAPS - #\\
    //#-------------- #\\
    //# WOODEN STUFF #\\
    public static final Map<LogType, Block> LOGS = register(LogType.values(), (value) -> {
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
    public static final LinkedHashMap<VanillaLogType, WNBlock> VANILLA_PARQUET = register(VanillaLogType.values(), (value) -> {
        return new WNVanillaPlanksBlock(
                location(value.getName() + "_parquet"),
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
                        .strength(2.0F,3.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value, true
        );
    });
    public static final LinkedHashMap<VanillaLogType, WNBlock> SLAB_VANILLA_PARQUET = register(VanillaLogType.values(), (value) -> {
        return new WNVanillaPlanksSlabBlock(
                location(value.getName() + "_slab_parquet"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F)
                        .sound(SoundType.WOOD),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
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
                BlockBehaviour.Properties.copy(PARQUET.get(value)),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value, true
        );
    });
    public static final LinkedHashMap<VanillaLogType, WNBlock> STAIRS_VANILLA_PARQUET = register(VanillaLogType.values(), (value) -> {
        return new WNVanillaPlanksStairBlock(
                location(value.getName() + "_stairs_parquet"),
                () -> VANILLA_PARQUET.get(value).defaultBlockState(),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(2.0F)
                        .sound(SoundType.WOOD),
        new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
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
                        .tab(WNTabs.TAB_FURNITURE),
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
                        .tab(WNTabs.TAB_FURNITURE),
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
    public static final LinkedHashMap<VanillaLogType, WNBlock> VANILLA_BRANCHES = register(VanillaLogType.values(), (value) -> {
        return new WNVanillaBranchBlock(
                location(value.getName() + "_branch"),
                BlockBehaviour.Properties.of(Material.WOOD, value.getColor())
                        .strength(1.4F)
                        .sound(SoundType.WOOD)
                        .noOcclusion(),
                new Item.Properties()
                        .tab(WNTabs.TAB_WOOD_BUILDING),
                value
        );
    });
    public static final Map<LogType, RegistryObject<Block>> TABLES = linkEnumAndRegister(Arrays.stream(LogType.values()).filter(t -> t.getParent() == null).toArray(LogType[]::new), t -> t.getIdBase() + "_table", (value) -> new WNTableBlock(BlockBehaviour.Properties.of(Material.WOOD, value.getColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion(), value));
    public static final Map<VanillaLogType, RegistryObject<Block>> VANILLA_TABLES = linkEnumAndRegister(VanillaLogType.values(), t -> t.getName() + "_table", (value) -> new WNVanillaTableBlock(BlockBehaviour.Properties.of(Material.WOOD, value.getColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion(), value), DEFAULT_PROPERTIES);
    public static final Map<LogType, RegistryObject<Block>> CHAIRS = linkEnumAndRegister(Arrays.stream(LogType.values()).filter(l -> l.getParent() == null).toArray(LogType[]::new), logType -> logType.getIdBase() + "_chair", (value) -> new WNChairBlock(BlockBehaviour.Properties.of(Material.WOOD, value.getColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion(), value), DEFAULT_PROPERTIES);
    public static final Map<VanillaLogType, RegistryObject<Block>> VANILLA_CHAIRS = linkEnumAndRegister(VanillaLogType.values(), t -> t.getName() + "_chair", (value) -> new WNVanillaChairBlock(BlockBehaviour.Properties.of(Material.WOOD, value.getColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion(), value), DEFAULT_PROPERTIES);
    public static final Map<LogType, RegistryObject<Block>> BENCHES = linkEnumAndRegister(Arrays.stream(LogType.values()).filter(logType -> logType.getParent() == null).toArray(LogType[]::new), type -> type.getIdBase() + "_bench", (value) -> new WNBenchBlock(BlockBehaviour.Properties.of(Material.WOOD, value.getColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion(), Either.left(value)), DEFAULT_PROPERTIES);
    public static final Map<VanillaLogType, RegistryObject<Block>> VANILLA_BENCHES = linkEnumAndRegister(VanillaLogType.values(), type -> type.getName() + "_bench", (value) -> new WNBenchBlock(BlockBehaviour.Properties.of(Material.WOOD, value.getColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion(), Either.right(value)), DEFAULT_PROPERTIES);

    //# GRASS #\\
    public static final Map<GrassType, RegistryObject<Block>> GRASSES = linkEnumAndRegister(GrassType.values(), type -> type.getIdBase() + "_grass_block", (value) -> new GrassBlock(
            BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS)
                    .strength(0.6F)
                    .sound(SoundType.GRASS)
                    .randomTicks()
    ), DEFAULT_PROPERTIES);
    public static final RegistryObject<Block> ALGAE_BLOCK = registerStandaloneWithItem("algae_block", () -> new GrassBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(0.4F).sound(SoundType.WET_GRASS).randomTicks()), DEFAULT_PROPERTIES.get());
    public static final Map<GrassType, RegistryObject<Block>> DIRTS = linkEnumAndRegister(GrassType.values(), type -> type.getIdBase() + "_dirt", (value) -> new Block(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)), DEFAULT_PROPERTIES);
    public static final RegistryObject<Block> DRIED_SOIL = registerStandaloneWithItem("dried_soil", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.4F).sound(SoundType.GRAVEL)), DEFAULT_PROPERTIES.get());
    public static final Map<GrassType, RegistryObject<Block>> PODZOLS = linkEnumAndRegister(GrassType.values(), type -> type.getIdBase() + "_podzol", (value) -> new SnowyDirtBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.PODZOL).strength(0.5F).sound(SoundType.GRAVEL)), DEFAULT_PROPERTIES);
    public static final RegistryObject<Block> BARREN_MYCELIUM = registerStandaloneWithItem("barren_mycelium", () -> new MyceliumBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.PODZOL).strength(0.5F).sound(SoundType.GRAVEL)), DEFAULT_PROPERTIES.get());
    public static final Map<GrassType, RegistryObject<Block>> COARSE_DIRTS = linkEnumAndRegister(GrassType.values(), grassType -> grassType.getIdBase() + "_coarse_dirt", (value) -> new Block(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)), DEFAULT_PROPERTIES);
    public static final Map<GrassType, RegistryObject<Block>> DIRT_PATHS = linkEnumAndRegister(GrassType.values(), type -> type.getIdBase() + "_dirt_path", (value) -> new DirtPathBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_PURPLE).strength(0.65F).sound(SoundType.GRASS).isViewBlocking(WNBlocks::always).isSuffocating(WNBlocks::always)), DEFAULT_PROPERTIES);
    public static final Map<GrassType, RegistryObject<Block>> FARMS = linkEnumAndRegister(GrassType.values(), grassType -> grassType.getIdBase() + "_farmland", (value) -> new FarmBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_PURPLE).strength(0.6F).randomTicks().sound(SoundType.GRASS).isViewBlocking(WNBlocks::always).isSuffocating(WNBlocks::always)), DEFAULT_PROPERTIES);
    public static final Map<OvergrownGrassType, RegistryObject<Block>> OVERGROWN_STONES = linkEnumAndRegister(OvergrownGrassType.values(), OvergrownGrassType::getIdBase, (value) -> new WNOvergrownStoneBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(1.5F, 3F).randomTicks().sound(SoundType.STONE).isViewBlocking(WNBlocks::always).isSuffocating(WNBlocks::always), value), DEFAULT_PROPERTIES);
    public static final RegistryObject<Block> MOSSY_STONE = registerStandaloneWithItem("mossy_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 3F).sound(SoundType.STONE)), DEFAULT_PROPERTIES.get());
    public static final RegistryObject<Block> SOIL = registerStandaloneWithItem("soil", () -> new WNSoilBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.6F).sound(SoundType.ROOTED_DIRT)), DEFAULT_PROPERTIES.get());
    public static final RegistryObject<Block> GEYSER = registerStandaloneWithItem("geyser", () -> new WNGeyserBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(5F).sound(SoundType.DRIPSTONE_BLOCK).randomTicks()), DEFAULT_PROPERTIES.get());

    //# LEAVES #\\
    public static final Map<LeafType, RegistryObject<Block>> LEAVES = linkEnumAndRegister(LeafType.values(), leafType -> leafType.getIdBase() + "_leaves", (value) -> WNLeavesTypedBlock.create(BlockBehaviour.Properties.of(Material.LEAVES, value.getColor()).strength(0.2F).sound(SoundType.GRASS).randomTicks().noOcclusion().isValidSpawn(WNBlocks::ocelotOrParrot).isSuffocating(WNBlocks::never).isViewBlocking(WNBlocks::never), value));
    public static final Map<LeafBushType, RegistryObject<Block>> BUSH_LEAVES = linkEnumAndRegister(LeafBushType.values(), leafBushType -> leafBushType.getIdBase() + "_bush", (value) -> new WNBushLeafBlock(BlockBehaviour.Properties.of(Material.LEAVES, value.getColor()).strength(0.2F).sound(SoundType.GRASS).noOcclusion().isValidSpawn(WNBlocks::ocelotOrParrot).isSuffocating(WNBlocks::never).isViewBlocking(WNBlocks::never), value));

    //# FLOWERS #\\
    public static final Map<BushType, RegistryObject<Block>> BUSHES = linkEnumAndRegister(BushType.values(), bushType -> bushType.getVariant().getSetup().createId(bushType),  (value) -> {
        BlockBehaviour.Properties blockProp = BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.PLANT).sound(SoundType.GRASS).instabreak().noOcclusion().noCollission().dynamicShape().randomTicks();
        return value.getVariant().getSetup().getConstructor().get(value, blockProp);
    }, DEFAULT_PROPERTIES);

    //# FRUIT BUSHES #\\
    public static final Map<FruitBushType, RegistryObject<Block>> FRUIT_BUSH_LEAVES = linkEnumAndRegister(FruitBushType.values(), fruitBushType -> fruitBushType.getIdBase() + "_bush", (value) -> WNFruitBushTypedBlock.create(BlockBehaviour.Properties.of(Material.LEAVES, value.getColor()).strength(0.2F).sound(SoundType.GRASS).randomTicks().noOcclusion().isSuffocating(WNBlocks::never).isViewBlocking(WNBlocks::never), value), DEFAULT_PROPERTIES);
    public static final Map<FruitPlantType, RegistryObject<Block>> FRUIT_BUSH_PLANTS = linkEnumAndRegister(FruitPlantType.values(), fruitPlantType -> fruitPlantType.getIdBase() + "_bush", (value) -> {
        BlockBehaviour.Properties blockProp = BlockBehaviour.Properties.of(Material.PLANT, value.getColor()).strength(0.2F).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion().noCollission().dynamicShape().randomTicks();
        if(value.getConfig().getConstructor() != null){
            return value.getConfig().getConstructor().get(value,blockProp);
        }
        return WNFruitBushPlantTypedBlock.create(blockProp, value);
    }, DEFAULT_PROPERTIES);
    public static final Map<FruitVineType, RegistryObject<Block>> FRUIT_VINES = linkEnumAndRegister(FruitVineType.values(), FruitVineType::getIdBase, (value) -> new WNFruitVineBlock(BlockBehaviour.Properties.of(Material.EGG, value.getColor()).noOcclusion().strength(0.2f).randomTicks(), value), DEFAULT_PROPERTIES);
    public static final Map<CropType, RegistryObject<Block>> CROPS = linkEnumAndRegister(CropType.values(), CropType::getId, (value) -> {
        BlockBehaviour.Properties blockProp = BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.PLANT).instabreak().sound(SoundType.CROP).noOcclusion().noCollission().dynamicShape().randomTicks();
        if(value.getBlockConstructor() != null)
            return value.getBlockConstructor().get(value, blockProp);
        return WNCropTypedBlock.create(blockProp, value);
    }, (type, block) -> {
        Item.Properties itemProp = DEFAULT_PROPERTIES.get();
        if (type.getVeggie() != null)
            itemProp.food(type.getVeggie().getFood());
        return new BlockItem(block, itemProp);
    });
    public static final Map<WNSaplingType, RegistryObject<Block>> SAPLINGS = linkEnumAndRegister(WNSaplingType.values(), saplingType -> saplingType.getIdBase() + "_sapling", (value) -> {
        BlockBehaviour.Properties blockProp = BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.PLANT).sound(SoundType.GRASS).instabreak().noOcclusion().noCollission().dynamicShape().randomTicks();
        return new WNSaplingBlock(blockProp,value);
    });
    public static final Map<Mushroom, RegistryObject<Block>> MUSHROOMS = linkEnumAndRegister(Mushroom.values(), Mushroom::getId, (value) -> {
        BlockBehaviour.Properties prop = BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).sound(SoundType.GRASS).noCollission().randomTicks().instabreak().lightLevel((state) -> 1);
        if (value.getType() == MushroomType.NORMAL) {
            return new WNMushroomBlock(prop.dynamicShape(), value);
        }else if(value.getType() == MushroomType.PUFFBALL){
            return new WNPuffballBlock(prop, value);
        }else if(value.getType() == MushroomType.TREE){
            return new WNTreeFungusBlock(prop, value);
        }
        return null;
    }, DEFAULT_PROPERTIES);
    public static final Map<UnderwaterPlant, RegistryObject<Block>> UNDERWATER_BUSHES = linkEnumAndRegister(UnderwaterPlant.values(), UnderwaterPlant::getId, (value) -> {
        if(value.getVariant() == UnderwaterPlantVariant.NORMAL){
            return new WNUnderwaterBushBlock(BlockBehaviour.Properties.of(Material.WATER_PLANT, value.getColor()).sound(SoundType.WET_GRASS).noOcclusion().instabreak().dynamicShape().noCollission(), value);
        } else if (value.getVariant() == UnderwaterPlantVariant.DOUBLE) {
            return new WNUnderwaterDoublePlantBlock(BlockBehaviour.Properties.of(Material.WATER_PLANT, value.getColor()).sound(SoundType.WET_GRASS).noOcclusion().instabreak().dynamicShape().noCollission(), value);
        } else if (value.getVariant() == UnderwaterPlantVariant.VINE) {
            return new WNUnderwaterVineBlock(BlockBehaviour.Properties.of(Material.WATER_PLANT, value.getColor()).sound(SoundType.WET_GRASS).noOcclusion().strength(0.2f).randomTicks(), value);
        }
        return null;
    }, DEFAULT_PROPERTIES);
    public static final Map<WaterPlant, RegistryObject<Block>> WATER_PLANTS = linkEnumAndRegister(WaterPlant.values(), WaterPlant::getId, (value) -> {
        var prop = BlockBehaviour.Properties.of(Material.WATER_PLANT, value.getColor()).sound(SoundType.LILY_PAD).noOcclusion().instabreak().dynamicShape();
        return value.getConstructor().get(value, prop);
    }, DEFAULT_PROPERTIES);
    public static final Map<Shell, RegistryObject<Block>> SHELLS = linkEnumAndRegister(Shell.values(), Shell::getId, (value) -> new WNShellBlock(BlockBehaviour.Properties.of(Material.EGG, value.getColor()).strength(0.3F).sound(SoundType.CORAL_BLOCK).noOcclusion().dynamicShape(), value), DEFAULT_PROPERTIES);
    public static final Map<CavePlantType, RegistryObject<Block>> CAVE_PLANTS = linkEnumAndRegister(CavePlantType.values(), CavePlantType::getId, (value) -> {
        BlockBehaviour.Properties prop = BlockBehaviour.Properties.of(Material.PLANT, value.getColor()).instabreak().sound(SoundType.CAVE_VINES).noOcclusion().dynamicShape();
        if(value != CavePlantType.MAGMA_PAD){
            prop.noCollission();
        }
        return value.getConstructor().get(value, prop);
    }, DEFAULT_PROPERTIES);

    //# SANDS #\\
    public static final Map<SandType, RegistryObject<Block>> SANDS = linkEnumAndRegister(SandType.values(), sandType -> sandType.getIdBase() + "_sands", (value) -> new WNSandBlock(BlockBehaviour.Properties.of(Material.SAND, value.getColor()).strength(0.5F).sound(SoundType.SAND), value));
    public static final RegistryObject<Block> QUICKSAND = registerStandaloneWithItem("quicksand", () -> new WNQuicksandBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.TERRACOTTA_YELLOW).strength(0.5F).sound(SoundType.SAND)), DEFAULT_PROPERTIES.get());
    private static final float HARD_ROCK_HARDNESS = 2.7F;

    //# ROCKS #\\
    public static final Map<RockType, RegistryObject<Block>> ROCKS = linkEnumAndRegister(RockType.values(), RockType::getIdBase, (value) -> new WNRockBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value), DEFAULT_PROPERTIES);
    public static final RegistryObject<Block> IGNEOUS_BASANITE = registerStandaloneWithItem("igneous_basanite", () -> new WNRockMagmaBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(HARD_ROCK_HARDNESS, 4F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops(), RockType.BASANITE), DEFAULT_PROPERTIES.get());
    public static final RegistryObject<Block> SALT = registerStandaloneWithItem("salt", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE).strength(1.8F, 4F).sound(SoundType.STONE).requiresCorrectToolForDrops()), DEFAULT_PROPERTIES.get());
    public static final Map<RockType, RegistryObject<Block>> ROCK_SLABS = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_slabs", (value) -> new WNRockSlabBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value, ROCKS.get(value)));
    public static final Map<RockType, RegistryObject<Block>> ROCK_STAIRS = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_stairs", (value) -> new WNRockStairBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value, ROCKS.get(value)));
    public static final Map<RockType, RegistryObject<Block>> ROCKS_POLISHED = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_polished", (value) -> new WNRockBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value));
    public static final Map<RockType, RegistryObject<Block>> ROCK_POLISHED_SLABS = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_polished_slabs", (value) -> new WNRockSlabBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value, ROCKS_POLISHED.get(value)));
    public static final Map<RockType, RegistryObject<Block>> ROCK_POLISHED_STAIRS = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_polished_stairs", (value) -> new WNRockStairBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value, ROCKS_POLISHED.get(value)));
    public static final Map<RockType, RegistryObject<Block>> ROCK_POLISHED_WALLS = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_polished_wall", (value) -> new WNRockWallBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value, ROCKS_POLISHED.get(value)));
    public static final Map<RockType, RegistryObject<Block>> ROCKS_BRICKS = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_bricks", (value) -> new WNRockBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value), DEFAULT_PROPERTIES);
    public static final Map<RockType, RegistryObject<Block>> ROCK_BRICK_SLABS = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_brick_slabs", (value) -> new WNRockSlabBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value, ROCKS_BRICKS.get(value)), DEFAULT_PROPERTIES);
    public static final Map<RockType, RegistryObject<Block>> ROCK_BRICK_STAIRS = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_brick_stairs", (value) -> new WNRockStairBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value, ROCKS_BRICKS.get(value)), DEFAULT_PROPERTIES);
    public static final Map<RockType, RegistryObject<Block>> ROCK_BRICK_WALL = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_brick_wall", (value) -> new WNRockWallBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value, ROCKS_BRICKS.get(value)), DEFAULT_PROPERTIES);
    public static final Map<RockType, RegistryObject<Block>> ROCKS_BRICKS_ANCIENT = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_bricks_ancient", (value) -> new WNRockBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value), DEFAULT_PROPERTIES);
    public static final Map<RockType, RegistryObject<Block>> ROCKS_BRICKS_CHISELED = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_bricks_chiseled", (value) -> new WNRockBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value), DEFAULT_PROPERTIES);
    public static final Map<RockType, RegistryObject<Block>> ROCKS_BRICKS_CRACKED = linkEnumAndRegister(RockType.values(), rockType ->  rockType.getIdBase() + "bricks_cracked", (value) -> new WNRockBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value), DEFAULT_PROPERTIES);
    public static final Map<RockType, RegistryObject<Block>> ROCKS_BRICKS_MOSSY = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_bricks_mossy", (value) -> new WNRockBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value), DEFAULT_PROPERTIES);
    public static final Map<RockType, RegistryObject<Block>> ROCK_BRICK_MOSSY_SLABS = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "_brick_mossy_slabs", (value) -> new WNRockSlabBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value, ROCKS_BRICKS_MOSSY.get(value)), DEFAULT_PROPERTIES);
    public static final Map<RockType, RegistryObject<Block>> ROCK_BRICK_MOSSY_STAIRS = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "brick_mossy_stairs", (value) -> new WNRockStairBlock( BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value, ROCK_BRICK_MOSSY_SLABS.get(value)), DEFAULT_PROPERTIES);
    public static final Map<RockType, RegistryObject<Block>> ROCK_BRICK_MOSSY_WALL = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "brick_mossy_wall", (value) -> new WNRockWallBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor()).strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F).sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE).requiresCorrectToolForDrops(), value, ROCKS_BRICKS_MOSSY.get(value)), DEFAULT_PROPERTIES);
    public static final Map<RockType, RegistryObject<Block>> ROCKS_BRICKS_SMALL = linkEnumAndRegister(RockType.values(), rockType -> rockType.getIdBase() + "bricks_small", (value) -> {
        if (value.isPoor()) {
            return null;
        }
        return new WNRockBlock(BlockBehaviour.Properties.of(Material.STONE, value.getColor())
                        .strength(value.isHard() ? HARD_ROCK_HARDNESS : 2F, 6F)
                        .sound(value.isHard() ? SoundType.DEEPSLATE : SoundType.STONE)
                        .requiresCorrectToolForDrops(), value);
    }, DEFAULT_PROPERTIES);

    //# ORES #\\
    public static final Map<Ore, RegistryObject<Block>> ORES = linkEnumAndRegister(Ore.values(), Ore::getId, (value) -> {
        if (value.getType() == OreType.BLOCK || value.getType() == OreType.BLOCK_DEEPSLATE) {
            BlockBehaviour.Properties prop = BlockBehaviour.Properties.of(Material.STONE, value.getType() == OreType.BLOCK ? MaterialColor.STONE : MaterialColor.DEEPSLATE).sound(value.getType() == OreType.BLOCK ? SoundType.STONE : SoundType.DEEPSLATE).requiresCorrectToolForDrops();
            prop = value.getPropertiesSupplier().getProperties(prop);
            return new WNOreBlock(prop, value);
        } else{
            BlockBehaviour.Properties prop = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().noOcclusion();
            prop = value.getPropertiesSupplier().getProperties(prop);
            if (value.getType() == OreType.FORMATION){
                return new WNOreFormationBlock(prop, value);
            } else {
                return new WNOreDoubleFormationBlock(prop, value);
            }
        }
    }, DEFAULT_PROPERTIES);
    public static final Map<GemBlock, RegistryObject<Block>> GEM_BLOCKS = linkEnumAndRegister(GemBlock.values(), GemBlock::getId, (value) -> {
        BlockBehaviour.Properties prop = BlockBehaviour.Properties.of(Material.METAL)
                .sound(SoundType.METAL);
        prop = value.getPropertiesSupplier().getProperties(prop);
        return new WNGemBlock(prop, value);
        }, DEFAULT_PROPERTIES);
    public static final Map<Lantern, RegistryObject<Block>> LANTERNS = linkEnumAndRegister(Lantern.values(), Lantern::getId, (value) -> new WNLanternBlock(BlockBehaviour.Properties.of(Material.METAL).strength(3.5F).sound(SoundType.LANTERN).noOcclusion().requiresCorrectToolForDrops().lightLevel((a) -> value.getLight()), value), DEFAULT_PROPERTIES);

    //# DEV BLOCKS #\\
    public static final RegistryObject<Block> DEV_STRUCTURE_CENTER = registerStandaloneWithItem("dev_structure_center", () -> new WNDevBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.DIAMOND).strength(999F).sound(SoundType.AMETHYST)), new Item.Properties().rarity(Rarity.EPIC));

    //# UTILITY METHODS #\\
    private static <T extends Block> RegistryObject<T> registerStandaloneWithItem(String name, Supplier<T> block, Item.Properties properties) {
        RegistryObject<T> registered = REGISTRY.register(name, block);
        WNItems.REGISTRY.register(name, () -> new BlockItem(registered.get(), properties));
        return registered;
    }

    private static <T, U extends Block> Map<T, RegistryObject<U>> linkEnumAndRegister(T[] enumList, Function<T, String> nameGetter, BlockFactory<T, U> factory) {
        Map<T, RegistryObject<U>> map = new LinkedHashMap<>();
        for (T element : enumList) {
            String name = nameGetter.apply(element);
            RegistryObject<U> registered = REGISTRY.register(name, () -> factory.register(element));
            map.put(element, registered);
        }
        return map;
    }

    private static <T, U extends Block> Map<T, RegistryObject<U>> linkEnumAndRegister(T[] enumList, Function<T, String> nameGetter, BlockFactory<T, U> factory, Supplier<Item.Properties> propertyGetter) {
        Map<T, RegistryObject<U>> map = new LinkedHashMap<>();
        for (T element : enumList) {
            if (factory.register(element) == null) {
                String name = nameGetter.apply(element);
                RegistryObject<U> registered = REGISTRY.register(name, () -> factory.register(element));
                map.put(element, registered);
                WNItems.REGISTRY.register(name, () -> new BlockItem(registered.get(), propertyGetter.get()));
            }

        }
        return map;
    }

    private static <T, U extends Block> Map<T, RegistryObject<U>> linkEnumAndRegister(T[] enumList, Function<T, String> nameGetter, BlockFactory<T, U> factory, BiFunction<T, U, BlockItem> customItemFactory) {
        Map<T, RegistryObject<U>> map = new LinkedHashMap<>();
        for (T element : enumList) {
            String name = nameGetter.apply(element);
            RegistryObject<U> registered = REGISTRY.register(name, () -> factory.register(element));
            map.put(element, registered);
            WNItems.REGISTRY.register(name, () -> customItemFactory.apply(element, registered.get()));
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
