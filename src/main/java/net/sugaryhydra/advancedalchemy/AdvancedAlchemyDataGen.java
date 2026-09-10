package net.sugaryhydra.advancedalchemy;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.sugaryhydra.advancedalchemy.DataGen.ModExtraLootProvider;
import net.sugaryhydra.advancedalchemy.DataGen.ModGlobalLootModifierProvider;
import net.sugaryhydra.advancedalchemy.DataGen.ModModelProvider;
import net.sugaryhydra.advancedalchemy.DataGen.ModRecipeProvider;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = AdvancedAlchemy.MOD_ID)
public class AdvancedAlchemyDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new ModModelProvider(packOutput));
        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));
        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(
                        new LootTableProvider.SubProviderEntry(ModExtraLootProvider::new, LootContextParamSets.ALL_PARAMS)
                ), lookupProvider));
        generator.addProvider(true, new ModGlobalLootModifierProvider(packOutput, lookupProvider));
    }
}
