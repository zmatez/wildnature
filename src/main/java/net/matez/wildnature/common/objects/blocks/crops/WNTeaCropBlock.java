package net.matez.wildnature.common.objects.blocks.crops;

import net.matez.wildnature.common.objects.blocks.crops.stages.WNCropBlock_Stage0;
import net.matez.wildnature.common.objects.blocks.crops.stages.WNCropBlock_Stage1;
import net.matez.wildnature.common.objects.blocks.plant.WNBushBlock;
import net.matez.wildnature.common.objects.items.vegetables.WNVeggieBlockItem;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.items.WNItems;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.WNBlockstate_Cube;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class WNTeaCropBlock extends WNCropBlock_Stage1 {
    public WNTeaCropBlock(ResourceLocation location, Properties properties, CropType cropType) {
        super(location, properties, cropType);
    }

    public WNTeaCropBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CropType cropType) {
        super(location, properties, cropType);

        this.item = new WNVeggieBlockItem(this,itemProperties,cropType.getVeggie());
        this.item.setRegistryName(WNItems.location(cropType.getVeggie().getId()));
        WNItems.BLOCK_ITEMS.put(location, this.item);
        WNItems.VEGGIES.put(cropType.getVeggie(),this.item);
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getRegistryName().getNamespace() + ":blocks/crops/" + cropType.getFolder() + "/" + (this.cropType == CropType.MELISSA_TEA_LEAF ? "melissa_tea" : "tea") + "_stalk";
        return new ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName() + "_stage_1")
                        .with("texture", stalk),
                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_2")
                        .with("texture", this.getTextureName("crops/" + cropType.getFolder()))
                        .with("stalk", stalk)
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.CROPS_BLOCKS
        );
    }


    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }
}
