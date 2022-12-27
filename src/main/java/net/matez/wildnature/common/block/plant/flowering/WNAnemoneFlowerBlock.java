package net.matez.wildnature.common.block.plant.flowering;

import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNBushConfiguredBlock;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_Anemone;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNAnemoneFlowerBlock extends WNBushConfiguredBlock {
    public static final IntegerProperty STAGE = WNBlockProperties.ANEMONE_STAGE;

    public WNAnemoneFlowerBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNAnemoneFlowerBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        def.add(STAGE);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return state.setValue(STAGE,getStage(context.getLevel()));
        }
        return state;
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(stateDefinition.any().setValue(STAGE,0));
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Anemone(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName() + "_stalk";
        return new WNBlock.ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName()).with("texture",stalk),
                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_1")
                        .with("texture",this.getTextureName(getType().getVariant().getPath()) + "_bloom_1")
                        .with("stalk",stalk),
                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_2")
                        .with("texture",this.getTextureName(getType().getVariant().getPath()) + "_bloom_2")
                        .with("stalk",stalk),
                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_3")
                        .with("texture",this.getTextureName(getType().getVariant().getPath()) + "_bloom_3")
                        .with("stalk",stalk)
        );
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if(state.getValue(STAGE) == 0){
            if(ExtraMath.rint(0,5) == 0){
                level.setBlock(pos,state.setValue(STAGE,getStage(level)),2);
            }
        }else{
            int stage = getStage(level);
            if(state.getValue(STAGE) != stage){
                level.setBlock(pos,state.setValue(STAGE,stage),2);
            }
        }
    }

    public int getStage(Level level){
        long time = level.getDayTime();
        if(time >= 0 && time < 2000){
            return 2;
        }else if(time >= 2000 && time < 9000){
            return 3;
        }else if(time >= 10000 && time < 13000){
            return 2;
        }else{
            return 1;
        }
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FLOWERS, WNTags.SMALL_FLOWERS, WNTags.ENDERMAN_HOLDABLE, WNTags.WN_FLOWERING_PLANTS
        );
    }
}
