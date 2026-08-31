package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.InstantaneousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

class MilkyEffect extends InstantaneousMobEffect {
    protected MilkyEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        mob.removeAllEffects();
        return true;
    }

}
