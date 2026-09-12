package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantaneousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class ExplosiveEffect extends InstantaneousMobEffect {
    public ExplosiveEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        BlockPos pos = mob.blockPosition(); //gets the mob position
        //LightningBolt thunder = EntityTypes.LIGHTNING_BOLT.spawn(level, pos, EntitySpawnReason.SPAWN_ITEM_USE); //spawns a lightning bolt entity centered on the entity's position
        level.explode(mob, pos.getX(), pos.getY(), pos.getZ(), (amplification + 1), Level.ExplosionInteraction.MOB);
        return true;
    }
}
