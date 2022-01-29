/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.items.vegetables;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.items.setup.WNItem;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class WNVeggieItem extends WNItem {
    private final Veggie veggie;
    private static final WNLogger log = WildNature.getLogger();

    public WNVeggieItem(ResourceLocation location, Properties properties, Veggie veggie) {
        super(location, properties);
        this.veggie = veggie;
    }

    public Veggie getVeggie() {
        return veggie;
    }

    @Override
    public WNResource getItemModel(){
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("vegetables"));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        log.log("EAT - " + veggie.getId() + " - " + this.isEdible());

        ItemStack output = super.finishUsingItem(stack,level,entity);
        if(veggie == Veggie.HORSERADISH && this.isEdible()){
            level.playLocalSound(entity.getX(),entity.getY(), entity.getZ(), SoundEvents.DONKEY_AMBIENT, SoundSource.PLAYERS,1,0.4F,false);
            level.playLocalSound(entity.getX(),entity.getY(), entity.getZ(), SoundEvents.HORSE_GALLOP, SoundSource.PLAYERS,0.5f,0.8f,false);
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,30,1));
        }

        return output;
    }
}
