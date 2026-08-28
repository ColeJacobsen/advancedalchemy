package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantaneousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.*;

public class LightningEffect extends InstantaneousMobEffect {
    protected LightningEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        BlockPos pos = mob.blockPosition();
        LightningBolt thunder = EntityTypes.LIGHTNING_BOLT.spawn(level, pos, EntitySpawnReason.SPAWN_ITEM_USE);
        level.addFreshEntity(thunder);
        return true;
    }
}
