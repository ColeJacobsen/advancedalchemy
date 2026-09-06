package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

//This effect destroys the water surrounding the entity in a given radius
//The radius is tied to the amplification
public class DrySkinEffect extends MobEffect {
    public DrySkinEffect(MobEffectCategory category, int color)
    {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification)
    {
        //Water is only destroyed when it touches the entity, like how a sponge works
        if (mob.isInWater()) {

            BlockPos center = mob.blockPosition(); //centers on radius on the entity's current location
            Level world = mob.level();

            //Minimum 3x3 area for effect
            for (BlockPos p : BlockPos.betweenClosed(
                    center.offset(-3 - amplification, -3 - amplification, -3 - amplification),
                    center.offset(3 + amplification, 3 + amplification, 3 + amplification))) {
                BlockState pos = world.getBlockState(p);
                //sets all water in area to air
                if (pos.is(Blocks.WATER)) {
                    world.setBlock(p, Blocks.AIR.defaultBlockState(), 3);
                }
            }
        }

        return super.applyEffectTick(serverLevel, mob, amplification);

    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        return true;
    }
}
