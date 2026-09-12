package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantaneousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

//an effect that creates an explosion centered on the mob
public class ExplosiveEffect extends InstantaneousMobEffect {
    public ExplosiveEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        BlockPos pos = mob.blockPosition(); //gets the mob position
        level.explode(mob, pos.getX(), pos.getY(), pos.getZ(), (amplification + 3), Level.ExplosionInteraction.MOB); //creates an explosion on the mob's position with minimum radius of 3
        return true;
    }
}
