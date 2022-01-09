package net.matez.wildnature.common.objects.blocks.grass;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class WNSoilBlock extends WNDirtBlock{
    public WNSoilBlock(ResourceLocation location, Properties properties, GrassType grassType) {
        super(location, properties, grassType);
    }

    public WNSoilBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, GrassType grassType) {
        super(location, properties, itemProperties, grassType);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        BlockState up = level.getBlockState(pos.above());
        if(!up.isAir()){
            if(up.is(BlockTags.FLOWERS) || up.is(BlockTags.SAPLINGS) || up.is(BlockTags.BEE_GROWABLES)){
                if(up.getBlock().isRandomlyTicking(up)){
                    up.getBlock().randomTick(up,level,pos.above(),random);
                }
            }
        }
    }
}
