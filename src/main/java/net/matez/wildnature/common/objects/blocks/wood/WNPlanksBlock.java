package net.matez.wildnature.common.objects.blocks.wood;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.matez.wildnature.data.recipes.WNCraftingShaped;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WNPlanksBlock extends WNBlock implements ILog {
    protected final LogType logType;

    public WNPlanksBlock(ResourceLocation location, Properties properties, LogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNPlanksBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public ModelList getBlockModels() {
        return new ModelList()
                .with(new WNBlockModel_CubeAll(this.getRegName()).with("texture", this.getTextureName("trees/" + logType.getBaseOrParent())));
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        return new WNRecipeList(
                new WNCraftingShaped(this.getRegName(), "planks", """
                        ##
                        ##
                        """,
                        new ItemStack(this.item),
                        new WNCraftingShaped.ShapedItems()
                                .with('#',this.item)
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.PLANKS, WNTags.MINEABLE_AXE
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
