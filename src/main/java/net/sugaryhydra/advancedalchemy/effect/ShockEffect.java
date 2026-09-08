package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;

import java.util.List;

//A damage dealing version of MedicEffect
public class ShockEffect extends MobEffect {

    public ShockEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
        AABB box = mob.getBoundingBox().inflate(1 + amplification);
        List<Entity> entities = serverLevel.getEntities(mob, box);

        for (Entity entity : entities)
        {
            if (entity instanceof LivingEntity target)
            {
                target.hurtServer(serverLevel, mob.damageSources().lightningBolt(), 0.5f * (1 + amplification));
            }
        }

        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return true;
    }
}
