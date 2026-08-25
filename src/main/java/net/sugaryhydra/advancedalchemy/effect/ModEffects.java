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

    public static final Holder<MobEffect> DRYSKIN = MOB_EFFECTS.register("dry_skin",
            () -> new DrySkinEffect(MobEffectCategory.BENEFICIAL, 0xf7ec5c));

    public static final Holder<MobEffect> FROSTRESISTANCE = MOB_EFFECTS.register("frost_resistance",
            () -> new FrostResistanceEffect(MobEffectCategory.BENEFICIAL, 0x78edff));

    public static final Holder<MobEffect> ENDWARPEFFECT = MOB_EFFECTS.register("end_warp",
            () -> new EndWarpEffect(MobEffectCategory.NEUTRAL, 0x9840ad));

    public static final Holder<MobEffect> RECOVERYEFFECT = MOB_EFFECTS.register("recovery",
            () -> new RecoveryEffect(MobEffectCategory.NEUTRAL, 0x43A39B));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
