package net.matez.wildnature.common.objects.blocks.wood;

import net.matez.wildnature.common.objects.blocks.basic.WNPressurePlateBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_PressurePlate;
import net.matez.wildnature.data.block_models.WNBlockModel_PressurePlateDown;
import net.matez.wildnature.data.blockstates.WNBlockstate_PressurePlate;
import net.matez.wildnature.data.recipes.WNCraftingShaped;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.data.setup.recipes.WNRecipeList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class WNPlanksPressurePlate extends WNPressurePlateBlock implements ILog {
    protected final LogType logType;

    public WNPlanksPressurePlate(ResourceLocation location, Properties properties, LogType logType) {
        super(location, WNPressurePlateBlock.Sensitivity.EVERYTHING, properties);
        this.logType = logType;
    }

    public WNPlanksPressurePlate(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
        super(location, WNPressurePlateBlock.Sensitivity.EVERYTHING, properties, itemProperties);
        this.logType = logType;
    }

    public WNBlock getPlanks(){
        return WNBlocks.PLANKS.get(logType);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_PressurePlate(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        WNBlock planks = getPlanks();
        String texture = planks.getTextureName("trees/" + logType.getBaseOrParent());
        return new ModelList().with(
                new WNBlockModel_PressurePlate(this.getRegName()).with("texture",texture),
                new WNBlockModel_PressurePlateDown(this.getRegName() + "_down").with("texture",texture)
        );
    }


    @Nullable
    @Override
    public WNRecipeList getRecipes() {
        return new WNRecipeList(
                new WNCraftingShaped(this.getRegName(), "wooden_pressure_plates", """
                        ##
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
                WNTags.PRESSURE_PLATES, WNTags.WOODEN_PRESSURE_PLATES, WNTags.WALL_POST_OVERRIDE, WNTags.MINEABLE_AXE
        );
    }
}
