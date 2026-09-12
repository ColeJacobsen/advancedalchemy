package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;

public class GigantismEffect extends MobEffect {

    private double baseSize;

    protected GigantismEffect(MobEffectCategory category, int color) {
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
        baseSize = mob.getAttributeBaseValue(Attributes.SCALE);
        AttributeModifier mod = new AttributeModifier(Identifier.fromNamespaceAndPath(AdvancedAlchemy.MOD_ID, "scale_modifier"), amplifier * 10, AttributeModifier.Operation.ADD_VALUE);
        scale.addTransientModifier(mod);
        super.onEffectStarted(mob, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        return true;
    }
}
