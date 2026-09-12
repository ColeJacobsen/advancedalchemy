package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class ExplosiveWardEffect extends MobEffect {

    protected ExplosiveWardEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification)
    {
        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    //effect only kicks in on hurt
    @Override
    public void onMobHurt(ServerLevel level, LivingEntity mob, int amplifier, DamageSource source, float damage) {
        //Damage types that are the result of attacks and not environmental
        if (source.is(DamageTypes.MOB_ATTACK) ||
                source.is(DamageTypes.MOB_ATTACK_NO_AGGRO) ||
                source.is(DamageTypes.PLAYER_ATTACK) ||
                source.is(DamageTypes.PLAYER_EXPLOSION) ||
                source.is(DamageTypes.EXPLOSION) ||
                source.is(DamageTypes.ARROW) ||
                source.is(DamageTypes.FIREWORKS) ||
                source.is(DamageTypes.MOB_PROJECTILE) ||
                source.is(DamageTypes.MACE_SMASH) ||
                source.is(DamageTypes.SPEAR) ||
                source.is(DamageTypes.TRIDENT) ||
                source.is(DamageTypes.SONIC_BOOM) ||
                source.is(DamageTypes.STING) ||
                source.is(DamageTypes.THORNS) ||
                source.is(DamageTypes.DRAGON_BREATH) ||
                source.is(DamageTypes.WITHER_SKULL))
        {
            BlockPos pos = mob.blockPosition(); //gets the mob position
            level.explode(mob, pos.getX(), pos.getY(), pos.getZ(), (amplifier + 3), Level.ExplosionInteraction.MOB);
        }
        super.onMobHurt(level, mob, amplifier, source, damage);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        return true;
    }
}
