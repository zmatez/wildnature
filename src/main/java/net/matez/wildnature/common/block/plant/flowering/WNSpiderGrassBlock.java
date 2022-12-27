package net.matez.wildnature.common.block.plant.flowering;

import net.matez.wildnature.common.block.plant.BushType;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class WNSpiderGrassBlock extends WNFloweringBushBlock {
    public WNSpiderGrassBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNSpiderGrassBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        entity.makeStuckInBlock(state,new Vec3(0.3,0.3,0.3));
    }
}
