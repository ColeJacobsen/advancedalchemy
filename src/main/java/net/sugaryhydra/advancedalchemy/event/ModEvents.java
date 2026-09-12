package net.sugaryhydra.advancedalchemy.event;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;
import net.sugaryhydra.advancedalchemy.item.ModItems;
import net.sugaryhydra.advancedalchemy.potion.ModPotions;

@EventBusSubscriber(modid = AdvancedAlchemy.MOD_ID)
public class ModEvents {

    //registers custom brewing recipes so that can be used in game
    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder(); //The register

        //Vanilla Items, Vanilla Effects
        builder.addMix(Potions.AWKWARD, Items.POTENT_SULFUR, ModPotions.POTIONOFNAUSEA);
        builder.addMix(Potions.LEAPING, Items.ENCHANTED_GOLDEN_APPLE, Potions.LUCK);
        builder.addMix(Potions.LUCK, Items.FERMENTED_SPIDER_EYE, ModPotions.POTIONOFUNLUCK);
        builder.addMix(Potions.SWIFTNESS, ModItems.ELDERSPIKE.get(), ModPotions.POTIONOFHASTE);
        builder.addMix(Potions.AWKWARD, ModItems.ELDERSPIKE.get(), ModPotions.POTIONOFFATIGUE);
        builder.addMix(Potions.AWKWARD, Items.MILK_BUCKET, ModPotions.POTIONOFNULL);
        builder.addMix(Potions.AWKWARD, Items.SCULK_CATALYST, ModPotions.POTIONOFBLINDFURY);
        builder.addMix(ModPotions.POTIONOFHASTE, Items.HEART_OF_THE_SEA, ModPotions.POTIONOFTHECONDUIT);
        builder.addMix(Potions.AWKWARD, Items.ROTTEN_FLESH, ModPotions.POTIONOFHUNGER);
        builder.addMix(ModPotions.POTIONOFHUNGER, Items.GHAST_TEAR, ModPotions.POTIONOFSATURATION);

        builder.addMix(Potions.STRONG_SWIFTNESS, Items.RABBIT_FOOT, ModPotions.POTIONOFMOTION);
        builder.addMix(Potions.STRONG_LEAPING, Items.SUGAR, ModPotions.POTIONOFMOTION);
        builder.addMix(Potions.AWKWARD, Items.TNT, ModPotions.POTIONOFEXPLOSION);
        builder.addMix(ModPotions.POTIONOFEXPLOSION, Items.BLAZE_POWDER, ModPotions.POTIONOFFIERYEXPLOSION);
        builder.addMix(Potions.AWKWARD, Items.FIRE_CHARGE, ModPotions.POTIONOFFIERYEXPLOSION);

        builder.addMix(Potions.NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, ModPotions.POTIONOFBLINDNESS);
        builder.addMix(Potions.AWKWARD, Items.GLOW_INK_SAC, ModPotions.POTIONOFGLOWING);
        builder.addMix(ModPotions.POTIONOFGLOWING, Items.FERMENTED_SPIDER_EYE, ModPotions.POTIONOFDARKNESS);
        builder.addMix(Potions.TURTLE_MASTER, ModItems.SHULKERGUTS.get(), ModPotions.POTIONOFSHULKERMASTER);

        //Modded Items, Vanilla Effects
        builder.addMix(Potions.AWKWARD, ModItems.SHULKERGUTS.get(), ModPotions.POTIONOFLEVITATION);
        builder.addMix(Potions.AWKWARD, ModItems.WITHERBONE.get(), ModPotions.POTIONOFDECAY);
        builder.addMix(Potions.AWKWARD, ModItems.ANCIENTCELL.get(), ModPotions.POTIONOFTHEEXTREMOPHILE);

        //Vanilla Items, Modded Effects
        builder.addMix(Potions.AWKWARD, Items.SPONGE, ModPotions.POTIONOFDRYSKIN);
        builder.addMix(Potions.AWKWARD, Items.BLUE_ICE, ModPotions.POTIONOFFROSTRESISTANCE);
        builder.addMix(Potions.AWKWARD, Items.CHORUS_FRUIT, ModPotions.POTIONOFTELEPORTATION);
        builder.addMix(ModPotions.POTIONOFTELEPORTATION, ModItems.SHULKERGUTS.get(), ModPotions.POTIONOFENDWARP);
        builder.addMix(ModPotions.POTIONOFTELEPORTATION, Items.ECHO_SHARD, ModPotions.POTIONOFRECOVERY);
        builder.addMix(Potions.AWKWARD, Items.WOOL.white(), ModPotions.POTIONOFSTEALTH);
        builder.addMix(Potions.AWKWARD, Items.GOLD_BLOCK, ModPotions.POTIONOFLIGHTNING);
        builder.addMix(Potions.STRONG_STRENGTH, Items.ARMOR_STAND, ModPotions.POTIONOFPAINPOWER);
        builder.addMix(ModPotions.POTIONOFLIGHTNING, Items.COPPER_INGOT, ModPotions.POTIONOFSHOCK);
        builder.addMix(Potions.REGENERATION, Items.COPPER_INGOT, ModPotions.POTIONOMEDIC);
    }

}


