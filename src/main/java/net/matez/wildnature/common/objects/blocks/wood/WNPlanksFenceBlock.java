package net.matez.wildnature.common.objects.blocks.wood;

import net.matez.wildnature.common.objects.blocks.basic.WNFenceBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_FenceInventory;
import net.matez.wildnature.data.block_models.WNBlockModel_FencePost;
import net.matez.wildnature.data.block_models.WNBlockModel_FenceSide;
import net.matez.wildnature.data.blockstates.WNBlockstate_Fence;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.recipes.WNCraftingShaped;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WNPlanksFenceBlock extends WNFenceBlock implements ILog {
    protected final LogType logType;

    public WNPlanksFenceBlock(ResourceLocation location, Properties properties, LogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNPlanksFenceBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public WNBlock getPlanks(){
        return WNBlocks.PLANKS.get(logType);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Fence(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        WNBlock planks = getPlanks();
        String texture = planks.getTextureName("trees/" + logType.getBaseOrParent());
        return new ModelList().with(
                new WNBlockModel_FencePost(this.getRegName() + "_post").with("texture",texture),
                new WNBlockModel_FenceSide(this.getRegName() + "_side").with("texture",texture),
                new WNBlockModel_FenceInventory(this.getRegName() + "_inventory").with("texture",texture)
        );
    }

    @Nullable
    @Override
    public WNResource getItemModel(){
        return new WNItemModel_BlockParent(getRegName()).with("parent",this.getRegName() + "_inventory");
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        return new WNRecipeList(
                new WNCraftingShaped(this.getRegName(), "wooden_fences", """
                        #|#
                        #|#
                        """,
                        new ItemStack(this.item,4),
                        new WNCraftingShaped.ShapedItems()
                                .with('#',this.getPlanks().getItem())
                                .with('|', Items.STICK)
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FENCES, WNTags.WOODEN_FENCES, WNTags.FORGE_FENCES, WNTags.FORGE_WOODEN_FENCES, WNTags.MINEABLE_AXE
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
