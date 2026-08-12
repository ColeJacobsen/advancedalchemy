package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


public class DrySkinEffect extends MobEffect {
    public DrySkinEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification)
    {
        BlockPos center = mob.blockPosition();
        Level world = mob.level();

        world.setBlock(center, Blocks.OAK_LOG.defaultBlockState(), 3);

        for (BlockPos p: BlockPos.betweenClosed(
                center.offset(0 - amplification, 0 - amplification, 0 - amplification),
                center.offset(0 + amplification, 0 + amplification, 0 + amplification)))
        {
            BlockState pos = world.getBlockState(p);
            if (pos.is(Blocks.WATER))
            {
                world.setBlock(p, Blocks.AIR.defaultBlockState(), 3);
            }
        }

        return super.applyEffectTick(serverLevel, mob, amplification);

    }
}
