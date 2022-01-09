package net.matez.wildnature.common.objects.blocks.basic;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public abstract class WNWoodButtonBlock extends ButtonBlock {
   public WNWoodButtonBlock(BlockBehaviour.Properties p_58284_) {
      super(true, p_58284_);
   }

   protected SoundEvent getSound(boolean p_58286_) {
      return p_58286_ ? SoundEvents.WOODEN_BUTTON_CLICK_ON : SoundEvents.WOODEN_BUTTON_CLICK_OFF;
   }
}