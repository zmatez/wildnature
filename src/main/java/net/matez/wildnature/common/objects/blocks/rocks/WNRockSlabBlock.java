package net.matez.wildnature.common.objects.blocks.rocks;

import net.matez.wildnature.common.objects.blocks.basic.WNSlabBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_Slab;
import net.matez.wildnature.data.block_models.WNBlockModel_SlabTop;
import net.matez.wildnature.data.blockstates.WNBlockstate_Slab;
import net.matez.wildnature.data.recipes.WNCraftingShaped;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class WNRockSlabBlock extends WNSlabBlock {
    protected final RockType rockType;
    private final Supplier<WNBlock> fullBlock;

    public WNRockSlabBlock(ResourceLocation location, Properties properties, RockType rockType, Supplier<WNBlock> fullBlock) {
        super(location, properties);
        this.rockType = rockType;
        this.fullBlock = fullBlock;
    }

    public WNRockSlabBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, RockType rockType, Supplier<WNBlock> fullBlock) {
        super(location, properties, itemProperties);
        this.rockType = rockType;
        this.fullBlock = fullBlock;
    }

    public WNBlock getFullBlock(){
        return this.fullBlock.get();
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Slab(this.getRegistryName())
                .with("solid", getFullBlock().getRegName())
                ;
    }

    @Override
    public ModelList getBlockModels() {
        WNBlock planks = getFullBlock();
        return new ModelList().with(
                new WNBlockModel_Slab(this.getRegName()).with("texture",planks.getTextureName("rocks/" + rockType.getIdBase())),
                new WNBlockModel_SlabTop(this.getRegName() + "_top").with("texture",planks.getTextureName("rocks/" + rockType.getIdBase()))
        );
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        return new WNRecipeList(
                new WNCraftingShaped(this.getRegName(), "slabs", """
                        ###
                        """,
                        new ItemStack(this.item),
                        new WNCraftingShaped.ShapedItems()
                                .with('#',this.getFullBlock().getItem())
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.SLABS, WNTags.MINEABLE_PICKAXE
        );
    }
}
