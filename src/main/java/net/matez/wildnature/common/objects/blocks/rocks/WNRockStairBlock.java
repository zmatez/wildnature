package net.matez.wildnature.common.objects.blocks.rocks;

import net.matez.wildnature.common.objects.blocks.basic.WNSlabBlock;
import net.matez.wildnature.common.objects.blocks.basic.WNStairBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.data.block_models.*;
import net.matez.wildnature.data.blockstates.WNBlockstate_Slab;
import net.matez.wildnature.data.blockstates.WNBlockstate_Stairs;
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

public class WNRockStairBlock extends WNStairBlock {
    protected final RockType rockType;
    private final Supplier<WNBlock> fullBlock;

    public WNRockStairBlock(ResourceLocation location, Properties properties, RockType rockType, Supplier<WNBlock> fullBlock) {
        super(location, () -> {
            return fullBlock.get().defaultBlockState();
        },properties);
        this.rockType = rockType;
        this.fullBlock = fullBlock;
    }

    public WNRockStairBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, RockType rockType, Supplier<WNBlock> fullBlock) {
        super(location, () -> {
            return fullBlock.get().defaultBlockState();
        }, properties, itemProperties);
        this.rockType = rockType;
        this.fullBlock = fullBlock;
    }

    public WNBlock getFullBlock(){
        return this.fullBlock.get();
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Stairs(this.getRegistryName())
                .with("solid", getFullBlock().getRegName())
                ;
    }

    @Override
    public ModelList getBlockModels() {
        WNBlock full = getFullBlock();
        String texture = full.getTextureName("rocks/" + rockType.getIdBase());
        return new ModelList().with(
                new WNBlockModel_Stairs(this.getRegName()).with("texture",texture),
                new WNBlockModel_StairsInner(this.getRegName() + "_inner").with("texture",texture),
                new WNBlockModel_StairsOuter(this.getRegName() + "_outer").with("texture",texture)
        );
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        return new WNRecipeList(
                new WNCraftingShaped(this.getRegName(), "stairs", """
                        #
                        ##
                        ###
                        """,
                        new ItemStack(this.item,4),
                        new WNCraftingShaped.ShapedItems()
                                .with('#',this.getFullBlock().getItem())
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.STAIRS, WNTags.MINEABLE_PICKAXE
        );
    }
}
