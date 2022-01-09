package net.matez.wildnature.common.objects.blocks.setup;

import net.matez.wildnature.common.objects.items.setup.WNBlockItem;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.items.WNItems;
import net.matez.wildnature.common.registry.setup.WNRenderType;
import net.matez.wildnature.common.util.WeightedList;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.matez.wildnature.data.blockstates.WNBlockstate_Cube;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WNBlock extends Block {
    @Nullable
    protected final WNBlockItem item;

    public WNBlock(ResourceLocation location, Properties properties) {
        super(properties);

        this.setRegistryName(location);
        this.item = null;
    }

    public WNBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties){
        super(properties);

        this.setRegistryName(location);
        this.item = new WNBlockItem(this,itemProperties);
        this.item.setRegistryName(location);
        WNItems.BLOCK_ITEMS.put(location, this.item);
    }

    public WNBlock(ResourceLocation location, Properties properties, WNBlockItem item){
        super(properties);

        this.setRegistryName(location);
        this.item = item;
        this.item.setRegistryName(location);
        WNItems.BLOCK_ITEMS.put(location, this.item);
    }

    /**
     * called after constructor
     */
    public void construct(){

    }

    /**
     * called on SETUP stage
     */
    public void setup(){

    }

    @Nullable
    public WNBlockItem getItem() {
        return item;
    }

    //? ------------------------------------------------------------------------

    /**
     * @return e.g "stone"
     */
    public String getRegName(){
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
    public DropList getDrops(BlockState state, ServerLevel level, float luck){
        if(this.item == null){
            return null;
        }

        return new DropList()
                .with(this.item);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder context) {
        DropList list = getDrops(state, context.getLevel(), 0); //todo luck
        if(list == null || list.drops.isEmpty()) {
            return super.getDrops(state, context);
        }

        ArrayList<ItemStack> singleton = new ArrayList<>();
        singleton.add(list.drops.getWeightedEntry().item);
        return singleton;
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

    public static class DropList{
        private final WeightedList<Drop> drops = new WeightedList<>();

        public DropList(){}

        public DropList with(Item item){
            drops.add(new Drop(item,0),1);
            return this;
        }
        public DropList withExp(Item item, int exp){
            drops.add(new Drop(item,exp),1);
            return this;
        }
        public DropList with(Item item, int rarity){
            drops.add(new Drop(item,0),rarity);
            return this;
        }
        public DropList withExp(Item item, int exp, int rarity){
            drops.add(new Drop(item,exp),rarity);
            return this;
        }

        public DropList with(ItemStack item){
            drops.add(new Drop(item,0),1);
            return this;
        }
        public DropList withExp(ItemStack item, int exp){
            drops.add(new Drop(item,exp),1);
            return this;
        }
        public DropList with(ItemStack item, int rarity){
            drops.add(new Drop(item,0),rarity);
            return this;
        }
        public DropList withExp(ItemStack item, int exp, int rarity){
            drops.add(new Drop(item,exp),rarity);
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
