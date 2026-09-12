package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantaneousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

//creates an explosion with fire on a mobs location
public class FieryExplosionEffect extends InstantaneousMobEffect {
    public FieryExplosionEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        BlockPos pos = mob.blockPosition(); //gets the mob position
        level.explode(mob, pos.getX(), pos.getY(), pos.getZ(), (amplification + 3), true, Level.ExplosionInteraction.MOB);
        return true;
    }
}
