package net.matez.wildnature.common.objects.blocks.wood;

import net.matez.wildnature.common.objects.blocks.basic.WNTrapDoorBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_TrapdoorBottom;
import net.matez.wildnature.data.block_models.WNBlockModel_TrapdoorOpen;
import net.matez.wildnature.data.block_models.WNBlockModel_TrapdoorTop;
import net.matez.wildnature.data.blockstates.WNBlockstate_Trapdoor;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.recipes.WNCraftingShaped;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class WNLogTrapDoorBlock extends WNTrapDoorBlock implements ILog {
    protected final LogType logType;

    public WNLogTrapDoorBlock(ResourceLocation location, Properties properties, LogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNLogTrapDoorBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public WNBlock getPlanks(){
        return WNBlocks.PLANKS.get(logType);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Trapdoor(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String texture = this.getTextureName("trees/" + logType.getBaseOrParent());
        return new ModelList().with(
                new WNBlockModel_TrapdoorBottom(this.getRegName() + "_bottom").with("texture",texture),
                new WNBlockModel_TrapdoorOpen(this.getRegName() + "_open").with("texture",texture),
                new WNBlockModel_TrapdoorTop(this.getRegName() + "_top").with("texture",texture)
        );
    }

    @Nullable
    @Override
    public WNResource getItemModel(){
        return new WNItemModel_BlockParent(getRegName()).with("parent",this.getRegName() + "_bottom");
    }

    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        if(this.logType.getParent() != null){
            return new WNRecipeList(
                    new WNCraftingShaped(this.getRegName(), "wooden_trapdoors", """
                        ###
                        @#@
                        """,
                            new ItemStack(this.item,2),
                            new WNCraftingShaped.ShapedItems()
                                    .with('#',this.getPlanks().getItem())
                                    .with('@',WNBlocks.LOGS.get(logType).getItem())
                    ),
                    new WNCraftingShaped(this.getRegName(), "wooden_trapdoors", """
                        ###
                        @#@
                        """,
                            new ItemStack(this.item,2),
                            new WNCraftingShaped.ShapedItems()
                                    .with('#',this.getPlanks().getItem())
                                    .with('@',WNBlocks.WOODS.get(logType).getItem())
                    )
            );
        }
        return new WNRecipeList(
                new WNCraftingShaped(this.getRegName(), "wooden_trapdoors", """
                        ###
                        ###
                        """,
                        new ItemStack(this.item,2),
                        new WNCraftingShaped.ShapedItems()
                                .with('#',this.getPlanks().getItem())
                )
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.TRAPDOORS, WNTags.WOODEN_TRAPDOORS, WNTags.MINEABLE_AXE
        );
    }
}
