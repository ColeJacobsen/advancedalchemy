package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.InstantaneousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

import java.awt.*;
import java.util.Optional;

public class RecoveryEffect extends InstantaneousMobEffect {
    private EndWarpEffect tele = new EndWarpEffect(MobEffectCategory.NEUTRAL, 0x9840ad);

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

            this.tele.teleport(target, mob , x, y, z);
        }
        return true;
    }
}
