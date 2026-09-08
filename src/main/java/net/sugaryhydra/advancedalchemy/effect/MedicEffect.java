package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;

import java.util.List;

//An effect that heals all mobs around the entity
public class MedicEffect extends MobEffect {

    public MedicEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
        AABB box = mob.getBoundingBox().inflate(1 + amplification); //creates a box around the entity
        List<Entity> entities = serverLevel.getEntities(mob, box); //gets all entities (except the original) within the box

        //Iterates through all the entities
        for (Entity entity : entities)
        {
            //Heals all living creatures
            if (entity instanceof LivingEntity target)
            {
                target.heal(0.25f * (1 + amplification));
            }
        }

        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return true;
    }
}
