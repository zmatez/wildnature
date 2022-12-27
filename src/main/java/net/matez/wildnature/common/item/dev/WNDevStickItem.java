/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.dev;

import net.matez.wildnature.common.structures.dev.server.WNDevServerStructureManager;
import net.matez.wildnature.core.registry.WNParticles;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class WNDevStickItem extends WNItem {
    public WNDevStickItem(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    @Override
    public WNResource getItemModel() {
        return new WNItemModel_Generated(this.getRegName()).with("texture", this.getTextureName("misc"));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return createPos(context.getClickedPos(), context.getLevel(), context.getPlayer(), true) ? InteractionResult.SUCCESS : InteractionResult.FAIL;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level instanceof ServerLevel serverLevel) {
            if (player.isShiftKeyDown()) {
                player.getCooldowns().addCooldown(this, 20 * 2);
                for (double i = 1; i < 10; i += 0.3) {
                    Vec3 vec = player.getLookAngle().multiply(i, i, i);
                    serverLevel.sendParticles(WNParticles.PUFFBALL_EXPLOSION, player.getX() + vec.x, player.getEyeY() + vec.y, player.getZ() + vec.z, 10, 0, 0, 0, 0.02);
                }
            } else {
                player.getCooldowns().addCooldown(this, 20);
                for (double i = 1; i < 4; i += 0.25) {
                    Vec3 vec = player.getLookAngle().multiply(i, i, i);
                    serverLevel.sendParticles(WNParticles.CRYSTAL, player.getX() + vec.x, player.getEyeY() + vec.y, player.getZ() + vec.z, 15, 0, 0, 0, 0.01);
                }
            }
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }
        return super.use(level, player, hand);
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        createPos(pos, level, player, false);
        return false;
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }

    private boolean createPos(BlockPos pos, Level level, Player player, boolean use) {
        if (level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            if (!level.getBlockState(pos).isAir()) {
                WNDevServerStructureManager.getOrCreate(serverPlayer, pos, use);
                return true;
            }
        }
        return false;
    }
}
