package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.math.*;

//Effect give the mob an amount of strength that is inversely proportional
//to the amount of health and armor they have
public class PainPowerEffect extends MobEffect {

    public PainPowerEffect(MobEffectCategory category, int color)
    {
        super(category, color);
    }

    public double originalAttack;

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification)
    {
        float hp = mob.getHealth(); //gets mob health
        float ac = mob.getArmorValue(); //gets mob armor
        int booster = Math.round(40 - (hp + ac)); //maximum health and armor would give strength 0, minimum give strength 10

        AttributeInstance attack = mob.getAttribute(Attributes.ATTACK_DAMAGE);
        attack.setBaseValue(booster);

        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public void onEffectAdded(LivingEntity mob, int amplifier) {
        AttributeInstance attack = mob.getAttribute(Attributes.ATTACK_DAMAGE);
        originalAttack = attack.getBaseValue();
        super.onEffectAdded(mob, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        return true;
    }
}
