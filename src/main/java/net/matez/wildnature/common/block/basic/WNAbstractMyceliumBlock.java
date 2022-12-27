package net.matez.wildnature.common.block.basic;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public abstract class WNAbstractMyceliumBlock extends WNSpreadingSnowyDirtBlock {

   public WNAbstractMyceliumBlock(ResourceLocation location, Properties properties) {
      super(location, properties);
   }

   public WNAbstractMyceliumBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
      super(location, properties, itemProperties);
   }

   public WNAbstractMyceliumBlock(ResourceLocation location, Properties properties, WNBlockItem item) {
      super(location, properties, item);
   }

   public void animateTick(BlockState p_54900_, Level p_54901_, BlockPos p_54902_, Random p_54903_) {
      super.animateTick(p_54900_, p_54901_, p_54902_, p_54903_);
      if (p_54903_.nextInt(10) == 0) {
         p_54901_.addParticle(ParticleTypes.MYCELIUM, (double)p_54902_.getX() + p_54903_.nextDouble(), (double)p_54902_.getY() + 1.1D, (double)p_54902_.getZ() + p_54903_.nextDouble(), 0.0D, 0.0D, 0.0D);
      }

   }
}