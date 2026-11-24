package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.cubemob.Slime;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;
import org.joml.Vector3f;

import java.util.List;
import java.util.Random;
import java.util.function.ToIntFunction;

public class SlimyEffect extends MobEffect {

    private final float chanceToSpawn;
    private final int spawnedCount;

    public SlimyEffect(MobEffectCategory category, int color, float chanceToSpawn, int amnt) {
        super(category, color, ParticleTypes.ITEM_SLIME);
        this.chanceToSpawn = chanceToSpawn;
        this.spawnedCount = amnt;
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public void onEffectAdded(LivingEntity mob, int amplifier) {
        Identifier id = Identifier.fromNamespaceAndPath(AdvancedAlchemy.MOD_ID, "advancedalchemyslimy");
        AttributeModifier bounce = new AttributeModifier(id, (amplifier/10) + 0.1, AttributeModifier.Operation.ADD_VALUE);
        AttributeMap attributes = mob.getAttributes();
        attributes.getInstance(Attributes.BOUNCINESS).addOrUpdateTransientModifier(bounce);
        super.onEffectAdded(mob, amplifier);
    }

    @Override
    public void onMobHurt(ServerLevel level, LivingEntity mob, int amplifier, DamageSource source, float damage) {
        if(mob.getRandom().nextFloat() <= chanceToSpawn){
            int count = mob.getRandom().nextInt(this.spawnedCount);

            for(int i = 0; i < count; ++i)
            {
                this.spawnSlime(level, mob, mob.getX(), mob.getY() + (double) mob.getBbHeight() / (double) 2.0F, mob.getZ());
            }
        }

        super.onMobHurt(level, mob, amplifier, source, damage);
    }

    private void spawnSlime(ServerLevel level, LivingEntity mob, double x, double y, double z)
    {
        Slime slime = (Slime) EntityTypes.SLIME.create(level, EntitySpawnReason.TRIGGERED);
        if (slime != null)
        {
            RandomSource random = mob.getRandom();
            float angle = ((float)Math.PI / 2F);
            float randomAngle = Mth.randomBetween(random, (-(float)Math.PI / 2F), ((float)Math.PI / 2F));
            Vector3f viewDirection = mob.getLookAngle().toVector3f().mul(0.3F).mul(1.0F, 1.5F, 1.0F).rotateY(randomAngle);
            slime.snapTo(x, y, z, level.getRandom().nextFloat() * 360.0F, 0.0F);
            slime.setDeltaMovement(new Vec3(viewDirection));
            level.addFreshEntity(slime);
            slime.playSound(SoundEvents.SLIME_SQUISH_SMALL);
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return true;
    }
}
