package net.matez.wildnature.common.objects.blocks.plant.flowering;

import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.plant.WNDoublePlantBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_DoubleFloweringBush;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNDoubleFloweringBushBlock extends WNDoublePlantBlock implements BonemealableBlock {
    public static final BooleanProperty FLOWERING = WNBlockProperties.FLOWERING;

    public WNDoubleFloweringBushBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties,type);
    }

    public WNDoubleFloweringBushBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties,type);
    }

    @Override
    public void construct() {
        super.construct();
        registerDefaultState(this.stateDefinition.any().setValue(FLOWERING,false).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return super.getStateForPlacement(context).setValue(FLOWERING,true);
        }
        return state;
    }


    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(FLOWERING) && state.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if(WNUtil.rint(0,5) == 0 && state.getValue(HALF) == DoubleBlockHalf.LOWER){
            placeAt(level,state.setValue(FLOWERING,true),pos,2);
        }
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        BlockPos blockpos = pos.above();
        level.setBlock(blockpos, copyWaterloggedFrom(level, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(FLOWERING, state.getValue(FLOWERING))), 3);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> definition) {
        definition.add(FLOWERING);
        super.createBlockStateDefinition(definition);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_DoubleFloweringBush(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName() + "_stalk";
        return new ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName() + "_bottom").with("texture",stalk + "_bottom"),
                new WNBlockModel_TintedCross(this.getRegName() + "_top").with("texture",stalk + "_top"),
                new WNBlockModel_FloweringBush(this.getRegName() + "_bottom_flowering")
                        .with("texture",this.getTextureName(getType().getVariant().getPath()) + "_bottom")
                        .with("stalk",stalk + "_bottom"),
                new WNBlockModel_FloweringBush(this.getRegName() + "_top_flowering")
                        .with("texture",this.getTextureName(getType().getVariant().getPath()) + "_top")
                        .with("stalk",stalk + "_top")
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FLOWERS, WNTags.TALL_FLOWERS, WNTags.ENDERMAN_HOLDABLE, WNTags.WN_FLOWERING_PLANTS
        );
    }

    public boolean canBeReplaced(BlockState p_57313_, BlockPlaceContext p_57314_) {
        return false;
    }

    public boolean isValidBonemealTarget(BlockGetter p_57303_, BlockPos p_57304_, BlockState p_57305_, boolean p_57306_) {
        return true;
    }

    public boolean isBonemealSuccess(Level p_57308_, Random p_57309_, BlockPos p_57310_, BlockState p_57311_) {
        return true;
    }

    public void performBonemeal(ServerLevel p_57298_, Random p_57299_, BlockPos p_57300_, BlockState p_57301_) {
        if(WNUtil.rint(0,2) == 0){
            popResource(p_57298_, p_57300_, new ItemStack(this));
        }
    }
}
