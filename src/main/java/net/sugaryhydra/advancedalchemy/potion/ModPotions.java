package net.sugaryhydra.advancedalchemy.potion;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sugaryhydra.advancedalchemy.effect.ModEffects;

import java.util.function.Supplier;

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


    public static final Holder<Potion> POTIONOFNULL =
            POTIONS.register("advancedalchemy_potion_of_null", () ->
                    new Potion("advancedalchemy_potion_of_null", new MobEffectInstance(ModEffects.MILKY,0,0)));

    public static final Holder<Potion> POTIONOFBLINDFURY =
            POTIONS.register("advancedalchemy_potion_of_blind_fury", () ->
                    new Potion("advancedalchemy_potion_of_blind_fury",
                            new MobEffectInstance(MobEffects.STRENGTH,3600,4),
                            new MobEffectInstance(MobEffects.SPEED,3600,4),
                            new MobEffectInstance(MobEffects.BLINDNESS,3600,0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
