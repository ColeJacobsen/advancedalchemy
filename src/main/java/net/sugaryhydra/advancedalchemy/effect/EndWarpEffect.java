package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EndWarpEffect extends MobEffect {
    public EndWarpEffect(MobEffectCategory category, int color)
    {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification)
    {
        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public void onMobHurt(ServerLevel level, LivingEntity mob, int amplifier, DamageSource source, float damage) {
        this.teleport(level, mob, amplifier);
        super.onMobHurt(level, mob, amplifier, source, damage);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        return true;
    }

    public boolean teleport(ServerLevel level, LivingEntity mob, int amplification){
        float WarpRange = (amplification + 2) * 8;

        if (!level.isClientSide() && mob.isAlive())
        {
            double xx = mob.getX() + (mob.getRandom().nextDouble() - (double)0.5F) * (double)WarpRange;
            double yy = mob.getY() + (double) (mob.getRandom().nextInt(64) -32);
            double zz = mob.getZ() + (mob.getRandom().nextDouble() - (double)0.5F) * (double)WarpRange;

            return teleport(level, mob, xx, yy, zz);
        }

        else
        {
            return false;
        }
    }

    public boolean teleport(ServerLevel level, LivingEntity mob, double x, double y, double z)
    {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, y, z);

        while (pos.getY() > level.getMinY() && !level.getBlockState(pos).blocksMotion())
        {
            pos.move(Direction.DOWN);
        }

        BlockState state = level.getBlockState(pos);
        boolean standable = state.blocksMotion();
        boolean isWet = state.getFluidState().is(FluidTags.WATER);
        if(standable && !isWet)
        {
            Vec3 oldPos = mob.position();
            boolean result = mob.randomTeleport(x, y, z, true);
            if (result)
            {
                level.gameEvent(GameEvent.TELEPORT, oldPos, GameEvent.Context.of(mob));
                if (!mob.isSilent()) {
                    level.playSound(null, mob.xo, mob.yo, mob.zo, SoundEvents.PLAYER_TELEPORT, mob.getSoundSource(), 1.0F, 1.0F);
                    mob.playSound(SoundEvents.PLAYER_TELEPORT, 1.0F, 1.0F);
                }
            }

            return result;
        }

        else
        {
            return false;
        }
    }
}
