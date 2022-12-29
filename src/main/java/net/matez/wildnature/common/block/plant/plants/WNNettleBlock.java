package net.matez.wildnature.common.block.plant.plants;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNBushConfiguredBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class WNNettleBlock extends WNBushConfiguredBlock {
    public WNNettleBlock(Properties properties, BushType type) {
        super(properties, type);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        entity.makeStuckInBlock(state,new Vec3(0.8,0.8,0.8));
        if(entity instanceof LivingEntity living){
            if(ExtraMath.rint(0,3) == 0){
                living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, ExtraMath.rint(30,140),0));
            }
        }
    }
}
