package net.sugaryhydra.advancedalchemy.event;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
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

        //Vanilla Items, Vanilla effects
        builder.addMix(Potions.LEAPING, Items.ENCHANTED_GOLDEN_APPLE, Potions.LUCK);

        //Modded Items, Vanilla effects
        builder.addMix(Potions.AWKWARD, ModItems.SHULKERGUTS.get(), ModPotions.POTIONOFLEVITATION);
        builder.addMix(Potions.AWKWARD, ModItems.WITHERBONE.get(), ModPotions.POTIONOFDECAY);
        builder.addMix(Potions.SWIFTNESS, Items.GOLD_INGOT, ModPotions.POTIONOFHASTE);
        builder.addMix(ModPotions.POTIONOFHASTE, Items.FERMENTED_SPIDER_EYE, ModPotions.POTIONOFFATIGUE);
    }
}
