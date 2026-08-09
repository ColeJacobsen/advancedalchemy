package net.sugaryhydra.advancedalchemy.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, AdvancedAlchemy.MOD_ID);

    public static final Holder<MobEffect> MILKY = MOB_EFFECTS.register("milky",
            () -> new MilkyEffect(MobEffectCategory.NEUTRAL, 0xffffff));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
