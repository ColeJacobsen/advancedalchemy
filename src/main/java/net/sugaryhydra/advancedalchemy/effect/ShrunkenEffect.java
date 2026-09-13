package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ShrunkenEffect extends MobEffect {

    protected ShrunkenEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification)
    {
        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public void onEffectStarted(LivingEntity mob, int amplifier) {
        AttributeInstance scale = mob.getAttribute(Attributes.SCALE);
        scale.setBaseValue(1.0 / ((amplifier * 2) + 2)); //minimum increase is 1.5
        super.onEffectStarted(mob, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        return true;
    }
}
