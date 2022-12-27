/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.tags;

import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

@Initialize(InitStage.CONSTRUCT)
public class WNTags {
    public static final LinkedHashMap<ResourceLocation, Tag> TAGS = new LinkedHashMap<>();
    //# ---------------

    //? MINECRAFT
    public static final Tag MINEABLE_AXE = register("minecraft","mineable/axe",TagCategory.BLOCKS);
    public static final Tag MINEABLE_PICKAXE = register("minecraft","mineable/pickaxe",TagCategory.BLOCKS);
    public static final Tag MINEABLE_SHOVEL = register("minecraft","mineable/shovel",TagCategory.BLOCKS);
    public static final Tag MINEABLE_HOE = register("minecraft","mineable/hoe",TagCategory.BLOCKS);

    public static final Tag LOGS = register("minecraft","logs",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag PLANKS = register("minecraft","planks",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag SLABS = register("minecraft","slabs",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WOODEN_SLABS = register("minecraft","wooden_slabs",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag STAIRS = register("minecraft","stairs",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WOODEN_STAIRS = register("minecraft","wooden_stairs",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag FENCES = register("minecraft","fences",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WOODEN_FENCES = register("minecraft","wooden_fences",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag FENCE_GATES = register("minecraft","fence_gates",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WOODEN_FENCE_GATES = register("minecraft","wooden_fence_gates",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag UNSTABLE_BOTTOM_CENTER = register("minecraft","unstable_bottom_center", TagCategory.BLOCKS);
    public static final Tag DOORS = register("minecraft","doors",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WOODEN_DOORS = register("minecraft","wooden_doors",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag TRAPDOORS = register("minecraft","trapdoors",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WOODEN_TRAPDOORS = register("minecraft","wooden_trapdoors",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag BUTTONS = register("minecraft","buttons",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WOODEN_BUTTONS = register("minecraft","wooden_buttons",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag PRESSURE_PLATES = register("minecraft", "pressure_plates", TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WOODEN_PRESSURE_PLATES = register("minecraft", "wooden_pressure_plates", TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WALL_POST_OVERRIDE = register("minecraft", "wall_post_override", TagCategory.BLOCKS);
    public static final Tag WALLS = register("minecraft","walls",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag BASE_STONE_OVERWORLD = register("minecraft","base_stone_overworld",TagCategory.BLOCKS_AND_ITEMS);

    public static final Tag SAND = register("minecraft", "sand", TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag LEAVES = register("minecraft", "leaves", TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag DIRT = register("minecraft", "dirt", TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag FLOWERS = register("minecraft", "flowers", TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag SMALL_FLOWERS = register("minecraft", "small_flowers", TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag TALL_FLOWERS = register("minecraft", "tall_flowers", TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag CROPS = register("minecraft", "crops", TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag CROPS_BLOCKS = register("minecraft", "crops", TagCategory.BLOCKS);

    public static final Tag LUSH_GROUND_REPLACEABLE = register("minecraft", "lush_ground_replaceable", TagCategory.BLOCKS);
    public static final Tag ENDERMAN_HOLDABLE = register("minecraft", "enderman_holdable", TagCategory.BLOCKS);
    public static final Tag RABBITS_SPAWNABLE_ON = register("minecraft", "rabbits_spawnable_on", TagCategory.BLOCKS);
    public static final Tag PARROTS_SPAWNABLE_ON = register("minecraft", "parrots_spawnable_on", TagCategory.BLOCKS);
    public static final Tag WOLVES_SPAWNABLE_ON = register("minecraft", "wolves_spawnable_on", TagCategory.BLOCKS);
    public static final Tag FOXES_SPAWNABLE_ON = register("minecraft", "foxes_spawnable_on", TagCategory.BLOCKS);
    public static final Tag AZALEA_GROWS_ON = register("minecraft", "azalea_grows_on", TagCategory.BLOCKS);
    public static final Tag AZALEA_ROOT_REPLACEABLE = register("minecraft", "azalea_root_replaceable", TagCategory.BLOCKS);
    public static final Tag BAMBOO_PLANTABLE_ON = register("minecraft", "bamboo_plantable_on", TagCategory.BLOCKS);
    public static final Tag MOSS_REPLACEABLE = register("minecraft", "moss_replaceable", TagCategory.BLOCKS);
    public static final Tag BIG_DRIPLEAF_REPLACEABLE = register("minecraft", "big_dripleaf_replaceable", TagCategory.BLOCKS);
    public static final Tag DRIPSTONE_REPLACEABLE_BLOCKS = register("minecraft", "dripstone_replaceable_blocks", TagCategory.BLOCKS);
    public static final Tag VALID_SPAWN = register("minecraft", "valid_spawn", TagCategory.BLOCKS);
    public static final Tag ANIMALS_SPAWNABLE_ON = register("minecraft", "animals_spawnable_on", TagCategory.BLOCKS);
    public static final Tag MUSHROOM_GROW_BLOCK = register("minecraft", "mushroom_grow_block", TagCategory.BLOCKS);
    public static final Tag MUSHROOMS_SPAWNABLE_ON = register("minecraft", "mushrooms_spawnable_on", TagCategory.BLOCKS);
    public static final Tag LAVA_POOL_STONE_CANNOT_REPLACE = register("minecraft", "lava_pool_stone_cannot_replace", TagCategory.BLOCKS);
    public static final Tag REPLACEABLE_PLANTS = register("minecraft", "replaceable_plants", TagCategory.BLOCKS);
    public static final Tag CLIMBABLE = register("minecraft", "climbable", TagCategory.BLOCKS);
    public static final Tag NEEDS_IRON_TOOL = register("minecraft", "needs_iron_tool", TagCategory.BLOCKS);
    public static final Tag NEEDS_DIAMOND_TOOL = register("minecraft", "needs_diamond_tool", TagCategory.BLOCKS);
    public static final Tag RED_MUSHROOM = register("minecraft", "red_mushroom", TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag BROWN_MUSHROOM = register("minecraft", "brown_mushroom", TagCategory.BLOCKS_AND_ITEMS);

    //? FORGE
    public static final Tag FORGE_FENCES = register("forge","fences",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag FORGE_WOODEN_FENCES = register("forge","fences/wooden",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag FORGE_FENCE_GATES = register("forge","fence_gates",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag FORGE_WOODEN_FENCE_GATES = register("forge","fence_gates/wooden",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag FORGE_SAND = register("forge","sand",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag FORGE_STONE = register("forge","stone",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag FORGE_SAND_COLORLESS = register("forge","sand/colorless",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag FORGE_DIRT = register("forge","dirt",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag FORGE_ORES = register("forge","ores",TagCategory.BLOCKS_AND_ITEMS);

    //? WILDNATURE
    public static final Tag WN_BRANCHES = register("wildnature","branches",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WN_TABLES = register("wildnature","tables",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WN_FLOWERING_PLANTS = register("wildnature","flowering_plants",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WN_SHELLS = register("wildnature","shells",TagCategory.BLOCKS_AND_ITEMS);
    public static final Tag WN_ORES = register("wildnature","ores",TagCategory.BLOCKS_AND_ITEMS);

    //# ---------------

    private static Tag register(String name, TagCategory category){
        Tag tag = new Tag(name,category);
        TAGS.put(tag.name,tag);
        return tag;
    }

    private static Tag register(String namespace, String name, TagCategory category){
        Tag tag = new Tag(namespace, name,category);
        TAGS.put(tag.name,tag);
        return tag;
    }

    public static class Tag{
        private final ArrayList<ResourceLocation> entries = new ArrayList<>();
        private final ResourceLocation name;
        private final TagCategory category;

        public Tag(String name, TagCategory category){
            this.name = new ResourceLocation(WildNature.modid,name);
            this.category = category;
        }

        public Tag(String namespace, String name, TagCategory category){
            this.name = new ResourceLocation(namespace,name);
            this.category = category;
        }

        public Tag with(ResourceLocation ...locations){
            entries.addAll(Arrays.asList(locations));
            return this;
        }

        public ArrayList<ResourceLocation> getEntries() {
            return entries;
        }

        public ResourceLocation getName() {
            return name;
        }

        public TagCategory getCategory() {
            return category;
        }
    }

    public static class TagList{
        private final ArrayList<Tag> tagList = new ArrayList<>();

        public TagList(Tag ...tags){
            with(tags);
        }

        public TagList with(Tag ...tags){
            tagList.addAll(Arrays.asList(tags));
            return this;
        }

        public ArrayList<Tag> getTagList() {
            return tagList;
        }
    }
}
