package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

//Effect lets the player trigger shriekers and other Deep Dark related phenomena
//without triggering a warden spawn.
public class StealthEffect extends MobEffect {

    public StealthEffect(MobEffectCategory category, int color)
    {
        super(category, color);
    }
    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
        //Only works on players as other mobs do not have the 'getWardenSpwanTracker' method
        if (mob instanceof ServerPlayer player)
        {
            if (player.getWardenSpawnTracker().isPresent())
            {
                player.getWardenSpawnTracker().get().reset(); //resets the warning level to 0 if the player ever increases it
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
