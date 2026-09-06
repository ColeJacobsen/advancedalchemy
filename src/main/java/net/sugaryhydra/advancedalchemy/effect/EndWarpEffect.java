package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

//EndWarpEffect makes the mob act similarly to an enderman
//in the sense that they teleport upon taking damage
public class EndWarpEffect extends MobEffect {

    //instance of TeleportationEffect to call
    private TeleportationEffect teleportEffect = new TeleportationEffect(MobEffectCategory.NEUTRAL, 0x79008f);

    public EndWarpEffect(MobEffectCategory category, int color)
    {
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
        teleportEffect.teleport(level, mob, amplifier); //calls the teleport method on hurt
        super.onMobHurt(level, mob, amplifier, source, damage);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        return true;
    }

}
