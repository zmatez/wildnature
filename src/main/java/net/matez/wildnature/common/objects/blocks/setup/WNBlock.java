/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.setup;

import net.matez.wildnature.common.objects.items.setup.WNBlockItem;
import net.matez.wildnature.common.objects.structures.WNStructure;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.common.registry.setup.WNRenderType;
import net.matez.wildnature.api.util.WeightedList;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.matez.wildnature.data.blockstates.WNBlockstate_Cube;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WNBlock extends Block {
    @Nullable
    protected WNBlockItem item;

    public WNBlock(ResourceLocation location, Properties properties) {
        super(properties);

        this.setRegistryName(location);
        this.item = null;
    }

    public WNBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties){
        super(properties);

        this.setRegistryName(location);
        createBlockItem(itemProperties);
    }

    public WNBlock(ResourceLocation location, Properties properties, WNBlockItem item){
        super(properties);

        this.setRegistryName(location);
        this.item = item;
        this.item.setRegistryName(location);
        WNBlocks.BLOCK_ITEMS.put(location, this.item);
    }

    /**
     * called after constructor
     */
    public void construct() {

    }

    public void onItemConstruct() {

    }

    public void createBlockItem(Item.Properties itemProperties) {
        this.item = new WNBlockItem(this, itemProperties);
        this.item.setRegistryName(this.getRegistryName());
        WNBlocks.BLOCK_ITEMS.put(this.getRegistryName(), this.item);
    }

    /**
     * called on SETUP stage
     */
    public void setup() {

    }

    @Nullable
    public WNBlockItem getItem() {
        return item;
    }

    //? ------------------------------------------------------------------------

    public BlockState processStateOnPlace(LevelAccessor accessor, BlockState state, BlockPos pos, WNStructure structure, Random random, @Nullable Rotation rotation) {
        return state;
    }

    //? ------------------------------------------------------------------------

    /**
     * @return e.g "stone"
     */
    public String getRegName() {
        return this.getRegistryName() == null ? "UNKNOWN" : (this.getRegistryName().getPath());
    }

    /**
     * @return e.g "stone"
     */
    public String getModelName(){
        return this.getRegistryName() == null ? "UNKNOWN" : (this.getRegistryName().getNamespace() + ":block/" + this.getRegistryName().getPath());
    }
    /**
     * @return e.g "minecraft:blocks/stone"
     */
    public String getTextureName(){
        return this.getRegistryName() == null ? "UNKNOWN" : (this.getRegistryName().getNamespace() + ":blocks/" + this.getRegistryName().getPath());
    }
    /**
     * @param folders e.g rocks/stones
     * @return e.g "minecraft:blocks/rocks/stones/stone"
     */
    public String getTextureName(String folders){
        return this.getRegistryName() == null ? "UNKNOWN" : (this.getRegistryName().getNamespace() + ":blocks/" + folders + "/" + this.getRegistryName().getPath());
    }

    public WNResource getBlockstate(){
        return new WNBlockstate_Cube(this.getRegistryName());
    }

    public ModelList getBlockModels(){
        return new ModelList()
                .with(new WNBlockModel_CubeAll(this.getRegName()).with("texture",this.getTextureName()));
    }

    @Nullable
    public WNResource getItemModel(){
        return new WNItemModel_BlockParent(getRegName()).with("parent",this.getRegName());
    }

    //? ------------------------------------------------------------------------

    //ClientSide RenderType, needed a handle
    public WNRenderType getRenderType(){
        return WNRenderType.SOLID;
    }

    @Nullable
    public BlockColor getBlockColor(){
        return null;
    }
    @Nullable
    public ItemColor getItemColor(BlockColors colors){
        return null;
    }

    //? ------------------------------------------------------------------------

    @Nullable
    @Deprecated(forRemoval = true)
    public DropList getDrops(BlockState state, ServerLevel level, float luck) {
        if (this.item == null) {
            return null;
        }

        return new DropList()
                .with(this.item);
    }

    @Nullable
    public DropList getDrops(BlockState state, ServerLevel level, float luck, int fortune, boolean silkTouch, @Nullable LivingEntity entity, ItemStack brokenBy) {
        if (this.item == null) {
            return null;
        }

        return new DropList()
                .with(this.item);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder context) {
        int luck = 0;
        int fortune = 0;
        boolean silkTouch = false;
        LivingEntity livingEntity = null;
        if (context.getOptionalParameter(LootContextParams.THIS_ENTITY) instanceof LivingEntity entity) {
            livingEntity = entity;
            var effect = livingEntity.getEffect(MobEffects.LUCK);
            if (effect != null) {
                luck = effect.getAmplifier() + 1;
            }
        }
        var stack = context.getOptionalParameter(LootContextParams.TOOL);
        if (stack != null && !stack.isEmpty()) {
            fortune = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, stack);
            silkTouch = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0;
        }

        DropList list = getDrops(state, context.getLevel(), luck, fortune, silkTouch, livingEntity, stack);
        if (list == null || list.drops.isEmpty()) {
            return super.getDrops(state, context);
        }

        ArrayList<ItemStack> array = new ArrayList<>();
        array.add(list.drops.getWeightedEntry().item);
        for (Drop drop : list.drops.getAllWithWeight(0)) {
            array.add(drop.item);
        }
        return array;
    }

    //? ------------------------------------------------------------------------

    @Nullable
    public WNTags.TagList getWNTags(){
        return null;
    }

    //? ------------------------------------------------------------------------

    @Nullable
    public WNRecipeList getRecipes(){
        return null;
    }

    //? ------------------------------------------------------------------------

    public static class ModelList{
        public final ArrayList<WNResource> models = new ArrayList<>();

        public ModelList with(WNResource ...model){
            models.addAll(Arrays.asList(model));
            return this;
        }
    }

    public static class DropList {
        //rarity 0 means it will drop always with other item

        public static DropList EMPTY = new DropList();

        private final WeightedList<Drop> drops = new WeightedList<>();

        public DropList() {
        }

        public static DropList single(Item item) {
            return new DropList().with(item);
        }

        public static DropList single(ItemStack item) {
            return new DropList().with(item);
        }

        public DropList with(Item item) {
            drops.put(new Drop(item, 0), 1);
            return this;
        }

        public DropList withExp(Item item, int exp) {
            drops.put(new Drop(item, exp), 1);
            return this;
        }

        public DropList with(Item item, int rarity) {
            drops.put(new Drop(item, 0), rarity);
            return this;
        }
        public DropList withExp(Item item, int exp, int rarity){
            drops.put(new Drop(item, exp), rarity);
            return this;
        }

        public DropList with(ItemStack item){
            drops.put(new Drop(item, 0), 1);
            return this;
        }
        public DropList withExp(ItemStack item, int exp){
            drops.put(new Drop(item, exp), 1);
            return this;
        }
        public DropList with(ItemStack item, int rarity){
            drops.put(new Drop(item, 0), rarity);
            return this;
        }
        public DropList withExp(ItemStack item, int exp, int rarity){
            drops.put(new Drop(item, exp), rarity);
            return this;
        }
    }

    public static class Drop{
        private final ItemStack item;
        private final int exp;

        public Drop(Item item, int exp) {
            this.item = new ItemStack(item);
            this.exp = exp;
        }
        public Drop(ItemStack item, int exp) {
            this.item = item;
            this.exp = exp;
        }
    }
}
