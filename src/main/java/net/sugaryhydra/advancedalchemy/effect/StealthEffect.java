package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.warden.WardenSpawnTracker;

import java.util.Optional;

public class StealthEffect extends MobEffect {

    public StealthEffect(MobEffectCategory category, int color)
    {
        super(category, color);
    }
    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
        if (mob instanceof ServerPlayer player)
        {
            if (player.getWardenSpawnTracker().isPresent())
            {
                player.getWardenSpawnTracker().get().reset();
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        return true;
    }
}
