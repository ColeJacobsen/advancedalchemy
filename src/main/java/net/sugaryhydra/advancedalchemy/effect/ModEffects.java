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

    public static final Holder<MobEffect> TELEPORTATION = MOB_EFFECTS.register("teleportation",
            () -> new TeleportationEffect(MobEffectCategory.NEUTRAL, 0x79008f));

    public static final Holder<MobEffect> ENDWARP = MOB_EFFECTS.register("end_warp",
            () -> new EndWarpEffect(MobEffectCategory.NEUTRAL, 0x9840ad));

    public static final Holder<MobEffect> RECOVERY = MOB_EFFECTS.register("recovery",
            () -> new RecoveryEffect(MobEffectCategory.NEUTRAL, 0x43A39B));

    public static final Holder<MobEffect> STEALTH = MOB_EFFECTS.register("stealth",
            () -> new StealthEffect(MobEffectCategory.BENEFICIAL, 0x616363));

    public static final Holder<MobEffect> LIGHTNING = MOB_EFFECTS.register("lightning",
            () -> new LightningEffect(MobEffectCategory.HARMFUL, 0xf5ff6b));

    public static final Holder<MobEffect> PAINPOWER = MOB_EFFECTS.register("pain_power",
            () -> new PainPowerEffect(MobEffectCategory.BENEFICIAL, 0x661224));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
