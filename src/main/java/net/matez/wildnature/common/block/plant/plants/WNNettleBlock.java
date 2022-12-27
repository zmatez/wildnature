package net.matez.wildnature.common.block.plant.plants;

import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNBushConfiguredBlock;
import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBushRetinted;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class WNNettleBlock extends WNBushConfiguredBlock {
    public WNNettleBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNNettleBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName() + "_stalk";
        return new ModelList().with(
                new WNBlockModel_FloweringBushRetinted(this.getRegName())
                    .with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_leaves")
                    .with("stalk",stalk)
        );
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
