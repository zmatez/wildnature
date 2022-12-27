package net.matez.wildnature.common.block.plant.flowering;

import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNDoublePlantBlock;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_ChineseLanternFlower;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNChineseLanternFlowerBlock extends WNDoublePlantBlock {
    public static final IntegerProperty STAGE = WNBlockProperties.CHINESE_LANTERN_STAGE;

    public WNChineseLanternFlowerBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNChineseLanternFlowerBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(STAGE);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return state.setValue(STAGE,3);
        }
        return state;
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(STAGE,0));
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_ChineseLanternFlower(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName() + "_stalk";
        return new ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName() + "_stage_0_bottom").with("texture",stalk + "_bottom"),
                new WNBlockModel_TintedCross(this.getRegName() + "_stage_0_top").with("texture",stalk + "_top"),

                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_1_bottom")
                        .with("texture",getTextureName(getType().getVariant().getPath()) + "_stage_1_bottom")
                        .with("stalk",stalk + "_bottom"),
                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_1_top")
                        .with("texture",getTextureName(getType().getVariant().getPath()) + "_stage_1_top")
                        .with("stalk",stalk + "_top"),

                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_2_bottom")
                        .with("texture",getTextureName(getType().getVariant().getPath()) + "_stage_2_bottom")
                        .with("stalk",stalk + "_bottom"),
                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_2_top")
                        .with("texture",getTextureName(getType().getVariant().getPath()) + "_stage_2_top")
                        .with("stalk",stalk + "_top"),

                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_3_bottom")
                        .with("texture",getTextureName(getType().getVariant().getPath()) + "_stage_3_bottom")
                        .with("stalk",stalk + "_bottom"),
                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_3_top")
                        .with("texture",getTextureName(getType().getVariant().getPath()) + "_stage_3_top")
                        .with("stalk",stalk + "_top")
        );
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(STAGE) != 3 && state.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        BlockPos blockpos = pos.above();
        level.setBlock(blockpos, copyWaterloggedFrom(level, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(STAGE, state.getValue(STAGE))), 3);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if(state.getValue(STAGE) != 3){
            if(ExtraMath.rint(0,5) == 0){
                placeAt(level,state.setValue(STAGE,state.getValue(STAGE) + 1),pos,2);
            }
        }
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FLOWERS, WNTags.TALL_FLOWERS, WNTags.ENDERMAN_HOLDABLE, WNTags.WN_FLOWERING_PLANTS
        );
    }
}
