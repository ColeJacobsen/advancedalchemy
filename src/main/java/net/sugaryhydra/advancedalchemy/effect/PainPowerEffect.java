package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import java.math.*;

//Effect give the mob an amount of strength that is inversely proportional
//to the amount of health and armor they have
public class PainPowerEffect extends MobEffect {

    public PainPowerEffect(MobEffectCategory category, int color)
    {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification)
    {
        float hp = mob.getHealth(); //gets mob health
        float ac = mob.getArmorValue(); //gets mob armor
        int booster = Math.round((40 - (hp + ac)) / 4); //maximum health and armor would give strength 0, minimum give strength 10

        MobEffectInstance tempStr = new MobEffectInstance(MobEffects.STRENGTH, 50, booster); //creates a strength effect that is replaced when changed
        mob.addEffect(tempStr);

        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        return true;
    }
}
