package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import java.math.*;

public class PainPowerEffect extends MobEffect {
    private int tickCount;

    public PainPowerEffect(MobEffectCategory category, int color)
    {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification)
    {
        float hp = mob.getHealth();
        int ac = mob.getArmorValue();
        int booster = Math.round(40 - (hp + ac));
        /*
        if (mob instanceof ServerPlayer player)
        {
            Identifier id = Identifier.fromNamespaceAndPath("advancedalchemy", "my_modifier");
            AttributeModifier mod = new AttributeModifier(id, booster, AttributeModifier.Operation.ADD_VALUE);
            if (this.tickCount > 1)
            {
                player.getAttribute(Attributes.ATTACK_DAMAGE).addOrUpdateTransientModifier(mod);
            }
            else
            {
                player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(mod);
            }

        }
         */
        MobEffectInstance str = new MobEffectInstance(MobEffects.STRENGTH, 30, booster);
        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        this.tickCount = tickCount;
        return true;
    }
}
