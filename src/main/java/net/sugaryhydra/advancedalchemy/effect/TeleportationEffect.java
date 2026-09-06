package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.InstantaneousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

//The effect teleports the mob to a random location inside a specified radius
//Functions similarly to a chorus fruit or enderman
public class TeleportationEffect extends InstantaneousMobEffect {
    protected TeleportationEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        this.teleport(level, mob, amplification);
        return true;
    }

    public boolean teleport(ServerLevel level, LivingEntity mob, int amplification){
        float WarpRange = (amplification + 2) * 8;

        //Does not function is the mob is in water
        if (!level.isClientSide() && mob.isAlive() && !mob.isInLiquid())
        {
            boolean breaker = false;
            //Loops so that if the first attempted location does not work, one can eventually be found
            while (!breaker)
            {
                double xx = mob.getX() + (mob.getRandom().nextDouble() - (double)0.5F) * (double)WarpRange;
                double yy = mob.getY() + (double) (mob.getRandom().nextInt(64) -32);
                double zz = mob.getZ() + (mob.getRandom().nextDouble() - (double)0.5F) * (double)WarpRange;

                breaker = teleport(level, mob, xx, yy, zz); //returns true or false, breaking the loop on true
            }
            return breaker;
        }

        else
        {
            return false;
        }
    }

    //Custom teleport method based on the one found in endermen
    public boolean teleport(ServerLevel level, LivingEntity mob, double x, double y, double z)
    {

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, y, z);

        //Move the teleport position down if there is something in the way
        while (pos.getY() > level.getMinY() && !level.getBlockState(pos).blocksMotion())
        {
            pos.move(Direction.DOWN);
        }

        BlockState state = level.getBlockState(pos);
        boolean standable = state.blocksMotion();
        boolean isWet = state.getFluidState().is(FluidTags.WATER);
        //If the block is either solid or standable , the mob will be teleported
        if(!isWet || !standable)
        {
            Vec3 oldPos = mob.position();
            boolean result = mob.randomTeleport(x, y, z, true); //checks if the teleport can be successful
            if (result)
            {
                level.gameEvent(GameEvent.TELEPORT, oldPos, GameEvent.Context.of(mob)); //teleports the mob
                //plays sound so long as mob is not silent
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
