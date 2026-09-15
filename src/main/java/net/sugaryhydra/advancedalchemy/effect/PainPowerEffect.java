package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;

import java.math.*;

//Effect give the mob an amount of strength that is inversely proportional
//to the amount of health and armor they have
public class PainPowerEffect extends MobEffect {

    public PainPowerEffect(MobEffectCategory category, int color)
    {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification)
    {
        float hp = mob.getHealth(); //gets mob health
        float ac = mob.getArmorValue(); //gets mob armor
        int booster = Math.round(40 - (hp + ac)); //maximum health and armor would give strength 0, minimum give strength 10

        Identifier id = Identifier.fromNamespaceAndPath(AdvancedAlchemy.MOD_ID, "advancedalchemypainpower");
        AttributeModifier power = new AttributeModifier(id, booster, AttributeModifier.Operation.ADD_VALUE);
        AttributeMap attributes = mob.getAttributes();
        attributes.getInstance(Attributes.ATTACK_DAMAGE).addOrUpdateTransientModifier(power);

        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        return true;
    }
}
