package net.matez.wildnature.common.objects.blocks.wood;

import net.matez.wildnature.common.objects.blocks.basic.WNStairBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_Stairs;
import net.matez.wildnature.data.block_models.WNBlockModel_StairsInner;
import net.matez.wildnature.data.block_models.WNBlockModel_StairsOuter;
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

public class WNPlanksStairBlock extends WNStairBlock implements ILog {
    protected final LogType logType;
    private final boolean isParquet;

    public WNPlanksStairBlock(ResourceLocation location, Supplier<BlockState> state, Properties properties, LogType logType, boolean isParquet) {
        super(location, state, properties);
        this.logType = logType;
        this.isParquet = isParquet;
    }

    public WNPlanksStairBlock(ResourceLocation location, Supplier<BlockState> state, Properties properties, Item.Properties itemProperties, LogType logType, boolean isParquet) {
        super(location, state, properties, itemProperties);
        this.logType = logType;
        this.isParquet = isParquet;
    }

    public WNBlock getPlanks(){
        if(!isParquet){
            return WNBlocks.PLANKS.get(logType);
        }else{
            return WNBlocks.PARQUET.get(logType);
        }
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Stairs(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        WNBlock planks = getPlanks();
        String texture = planks.getTextureName("trees/" + logType.getBaseOrParent());
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
                new WNCraftingShaped(this.getRegName(), "wooden_slabs", """
                        #
                        ##
                        ###
                        """,
                        new ItemStack(this.item,4),
                        new WNCraftingShaped.ShapedItems()
                                .with('#',this.getPlanks().getItem())
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.STAIRS, WNTags.WOODEN_STAIRS, WNTags.MINEABLE_AXE
        );
    }


    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 20;
    }
}
