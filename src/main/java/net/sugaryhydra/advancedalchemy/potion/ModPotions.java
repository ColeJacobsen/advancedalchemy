package net.sugaryhydra.advancedalchemy.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sugaryhydra.advancedalchemy.effect.ModEffects;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, AdvancedAlchemy.MOD_ID);

    public static final Holder<Potion> POTIONOFLEVITATION =
            POTIONS.register("advancedalchemy_potion_of_levitation", () ->
                            new Potion("advancedalchemy_potion_of_levitation", new MobEffectInstance(MobEffects.LEVITATION, 1200, 0)));

    public static final Holder<Potion> POTIONOFDECAY =
            POTIONS.register("advancedalchemy_potion_of_decay", () ->
                    new Potion("advancedalchemy_potion_of_decay", new MobEffectInstance(MobEffects.WITHER, 1200, 0)));

    public static final Holder<Potion> POTIONOFHASTE =
            POTIONS.register("advancedalchemy_potion_of_haste", () ->
                    new Potion("advancedalchemy_potion_of_haste", new MobEffectInstance(MobEffects.HASTE, 3600, 0)));

    public static final Holder<Potion> POTIONOFFATIGUE =
            POTIONS.register("advancedalchemy_potion_of_fatigue", () ->
                    new Potion("advancedalchemy_potion_of_fatigue", new MobEffectInstance(MobEffects.MINING_FATIGUE, 3600, 0)));

    public static final Holder<Potion> POTIONOFNAUSEA =
            POTIONS.register("advancedalchemy_potion_of_nausea", () ->
                    new Potion("advancedalchemy_potion_of_nausea", new MobEffectInstance(MobEffects.NAUSEA, 3600, 0)));

    public static final Holder<Potion> POTIONOFTHECONDUIT=
            POTIONS.register("advancedalchemy_potion_of_the_conduit", () ->
                    new Potion("advancedalchemy_potion_of_the_conduit", new MobEffectInstance(MobEffects.CONDUIT_POWER, 3600, 0)));

    public static final Holder<Potion> POTIONOFUNLUCK=
            POTIONS.register("advancedalchemy_potion_of_unluck", () ->
                    new Potion("advancedalchemy_potion_of_unluck", new MobEffectInstance(MobEffects.UNLUCK, 3600, 0)));

    public static final Holder<Potion> POTIONOFNULL =
            POTIONS.register("advancedalchemy_potion_of_null", () ->
                    new Potion("advancedalchemy_potion_of_null", new MobEffectInstance(ModEffects.MILKY,0,0)));

    public static final Holder<Potion> POTIONOFDRYSKIN =
            POTIONS.register("advancedalchemy_potion_of_dry_skin", () ->
                    new Potion("advancedalchemy_potion_of_dry_skin", new MobEffectInstance(ModEffects.DRYSKIN,3600,0)));

    public static final Holder<Potion> POTIONOFFROSTRESISTANCE =
            POTIONS.register("advancedalchemy_potion_of_frost_resistance", () ->
                    new Potion("advancedalchemy_potion_of_frost_resistance", new MobEffectInstance(ModEffects.FROSTRESISTANCE,3600,0)));

    public static final Holder<Potion> POTIONOFENDWARP =
            POTIONS.register("advancedalchemy_potion_of_end_warp", () ->
                    new Potion("advancedalchemy_potion_of_end_warp", new MobEffectInstance(ModEffects.ENDWARPEFFECT,3600,0)));

    public static final Holder<Potion> POTIONOFRECOVERY=
            POTIONS.register("advancedalchemy_potion_of_recovery", () ->
                    new Potion("advancedalchemy_potion_of_recovery", new MobEffectInstance(ModEffects.RECOVERYEFFECT,0,0)));

    public static final Holder<Potion> POTIONOFBLINDFURY =
            POTIONS.register("advancedalchemy_potion_of_blind_fury", () ->
                    new Potion("advancedalchemy_potion_of_blind_fury",
                            new MobEffectInstance(MobEffects.STRENGTH,3600,4),
                            new MobEffectInstance(MobEffects.SPEED,3600,4),
                            new MobEffectInstance(MobEffects.BLINDNESS,3600,0)));

    public static final Holder<Potion> POTIONOFTHEEXTREMOPHILE =
            POTIONS.register("advancedalchemy_potion_of_the_extremophile", () ->
                    new Potion("advancedalchemy_potion_of_the_extremophile",
                            new MobEffectInstance(ModEffects.FROSTRESISTANCE,3600,0),
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE,3600,0),
                            new MobEffectInstance(MobEffects.WATER_BREATHING,3600,0),
                            new MobEffectInstance(MobEffects.SLOW_FALLING, 3600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
