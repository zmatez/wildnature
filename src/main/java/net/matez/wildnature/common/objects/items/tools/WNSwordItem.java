/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.items.tools;

import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.objects.items.ores.OreFamily;
import net.matez.wildnature.common.objects.items.setup.IWNItem;
import net.matez.wildnature.common.objects.items.setup.WNItemUtil;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.item_models.WNItemModel_Handheld;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.Nullable;

public class WNSwordItem extends SwordItem implements IWNItem {
    private final ToolItem toolItem;
    private static final SimpleLogger log = WildNature.getLogger();

    public WNSwordItem(Tier tier, Properties properties, ToolItem toolItem) {
        super(tier, 3, -2.4F, properties);
        this.toolItem = toolItem;
    }

    public ToolItem getToolItem() {
        return toolItem;
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_Handheld(this.getRegName()).with("texture",this.getTextureName("tools/" + toolItem.getFolder()));
    }

    @Override
    public String getRegName() {
        return WNItemUtil.getRegName(this);
    }

    @Override
    public String getTextureName() {
        return WNItemUtil.getTextureName(this);
    }

    @Override
    public String getTextureName(String folders) {
        return WNItemUtil.getTextureName(folders, this);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target,LivingEntity attacker) {
        if (super.hurtEnemy(stack, target, attacker)) {
            if (this.toolItem.getFamily() == OreFamily.SILVER) {
                if (target instanceof Zombie || target instanceof Skeleton || target instanceof Piglin || target instanceof SkeletonHorse || target instanceof ZombieHorse) {
                    target.getLevel().playLocalSound(target.getX(), target.getY(), target.getZ(), SoundEvents.LAVA_EXTINGUISH, SoundSource.HOSTILE, 1F, 1F, false);
                    int ticks = WNUtil.rint(30, 50);

                    //SilverBurnEvent.makeBurn(target,ticks);

                    if (target.getLevel() instanceof ServerLevel level) {
                        target.addEffect(new MobEffectInstance(MobEffects.WITHER, ticks, 1, false, false));
                        level.sendParticles(ParticleTypes.SMOKE, target.getX(), target.getY(), target.getZ(), 50, 0, 0, 0, 0.04f);
                        level.sendParticles(ParticleTypes.LAVA, target.getX(), target.getY(), target.getZ(), WNUtil.rint(3, 7), 0, 0, 0, 1f);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
