package net.matez.wildnature.common.block.plant.flowering;

import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.api.util.ExtraMath;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class WNPoisonIvyBlock extends WNFloweringBushBlock {
    public WNPoisonIvyBlock(Properties properties, BushType type) {
        super(properties, type);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        entity.makeStuckInBlock(state,new Vec3(0.99,0.99,0.99));

        if(ExtraMath.rint(0,5) == 0){
            entity.hurt(DamageSource.CACTUS, (float) ExtraMath.rdoub(0.5D,1D)); //todo different damagesource for poisonivy
        }
        if(entity instanceof LivingEntity living){
            if(ExtraMath.rint(0,35) == 0){
                living.addEffect(new MobEffectInstance(MobEffects.POISON, ExtraMath.rint(20,40)));
            }
        }

    }
}
