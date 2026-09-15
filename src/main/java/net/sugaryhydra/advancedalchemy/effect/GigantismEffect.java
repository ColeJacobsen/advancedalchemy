package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;

public class GigantismEffect extends MobEffect {

    protected GigantismEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification)
    {
        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public void onEffectStarted(LivingEntity mob, int amplifier) {
        //AttributeInstance scale = mob.getAttribute(Attributes.SCALE);
        Identifier id = Identifier.fromNamespaceAndPath(AdvancedAlchemy.MOD_ID, "advancedalchemygigantism");
        double booster = 0.5 * (amplifier + 1);
        AttributeModifier upper = new AttributeModifier(id, booster, AttributeModifier.Operation.ADD_VALUE);
        AttributeMap attributes = mob.getAttributes();
        attributes.getInstance(Attributes.SCALE).addOrUpdateTransientModifier(upper);
        super.onEffectStarted(mob, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification)
    {
        return true;
    }
}
