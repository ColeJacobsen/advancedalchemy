package net.sugaryhydra.advancedalchemy.event;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.Consumables;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;
import net.sugaryhydra.advancedalchemy.item.ModItems;
import net.sugaryhydra.advancedalchemy.potion.ModPotions;

@EventBusSubscriber(modid = AdvancedAlchemy.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        //Vanilla Items, Vanilla Effects
        builder.addMix(Potions.AWKWARD, Items.POTENT_SULFUR, ModPotions.POTIONOFNAUSEA);
        builder.addMix(Potions.LEAPING, Items.ENCHANTED_GOLDEN_APPLE, Potions.LUCK);
        builder.addMix(Potions.SWIFTNESS, Items.GOLD_INGOT, ModPotions.POTIONOFHASTE);
        builder.addMix(ModPotions.POTIONOFHASTE, Items.FERMENTED_SPIDER_EYE, ModPotions.POTIONOFFATIGUE);
        builder.addMix(Potions.AWKWARD, Items.MILK_BUCKET, ModPotions.POTIONOFNULL);
        builder.addMix(Potions.AWKWARD, Items.SCULK_CATALYST, ModPotions.POTIONOFBLINDFURY);

        //Modded Items, Vanilla Effects
        builder.addMix(Potions.AWKWARD, ModItems.SHULKERGUTS.get(), ModPotions.POTIONOFLEVITATION);
        builder.addMix(Potions.AWKWARD, ModItems.WITHERBONE.get(), ModPotions.POTIONOFDECAY);

        //Vanilla Items, Modded Effects
        builder.addMix(Potions.AWKWARD, Items.SPONGE, ModPotions.POTIONOFDRYSKIN);

    }

}


