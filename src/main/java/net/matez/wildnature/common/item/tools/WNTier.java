/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.tools;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public record WNTier(int level, int uses, float speed, float attackDamageBonus, float axeAttackSpeed,
                     int enchantmentValue, @Nonnull TagKey<Block> tag,
                     @Nonnull Supplier<Ingredient> repairIngredient) implements Tier {

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
    }

    public float getAxeAttackSpeed() {
        return axeAttackSpeed;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Nonnull
    public TagKey<Block> getTag() {
        return this.tag;
    }

    @Nonnull
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String toString() {
        return "WNTier[" +
                "level=" + level + ", " +
                "uses=" + uses + ", " +
                "speed=" + speed + ", " +
                "axeAttackSpeed=" + axeAttackSpeed + ", " +
                "attackDamageBonus=" + attackDamageBonus + ", " +
                "enchantmentValue=" + enchantmentValue + ", " +
                "tag=" + tag + ", " +
                "repairIngredient=" + repairIngredient + ']';
    }
}
