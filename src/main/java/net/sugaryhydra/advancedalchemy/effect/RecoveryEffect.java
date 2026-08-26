package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.InstantaneousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import java.awt.*;
import java.util.Optional;
import java.util.Set;

public class RecoveryEffect extends InstantaneousMobEffect {

    protected RecoveryEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        if (mob instanceof ServerPlayer player)
        {
            Optional<GlobalPos> deathPos = player.getLastDeathLocation();
            BlockPos pos = deathPos.get().pos();
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            ServerLevel target = level.getServer().getLevel(deathPos.get().dimension());
            teleport(level, target, mob, x, y, z);
        }
        return true;
    }

    public boolean teleport(ServerLevel level, ServerLevel targetLevel, LivingEntity mob, int x, int y, int z)
    {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, y, z);

        while (pos.getY() < targetLevel.getMaxY() && targetLevel.getBlockState(pos).blocksMotion())
        {
            pos.move(Direction.UP);
        }
        Vec3 oldPos = mob.position();
        mob.canTeleport(level, targetLevel);
        mob.teleportTo(targetLevel, pos.getX(), pos.getY(), pos.getZ(), Set.of(), mob.getXRot(), mob.getYRot(), false);
        targetLevel.gameEvent(GameEvent.TELEPORT, oldPos, GameEvent.Context.of(mob));
        mob.makePoofParticles();
        if (!mob.isSilent()) {
            targetLevel.playSound((Entity)null, mob.xo, mob.yo, mob.zo, SoundEvents.PLAYER_TELEPORT, mob.getSoundSource(), 1.0F, 1.0F);
            mob.playSound(SoundEvents.PLAYER_TELEPORT, 1.0F, 1.0F);
        }
        return true;
    }
}
