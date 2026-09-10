package net.sugaryhydra.advancedalchemy.DataGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.skeleton.WitherSkeleton;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {


    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, AdvancedAlchemy.MOD_ID);
    }

    @Override
    protected void start() {
        add("wither_bone_from_wither_skeleton",
                new AddTableLootModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(Identifier.withDefaultNamespace("entities/wither_skeleton")).build()
                },1000, ModExtraLootProvider.WITHER_BONE));

        add("shulker_guts_from_shulker",
                new AddTableLootModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(Identifier.withDefaultNamespace("entities/shulker")).build()
                },1000, ModExtraLootProvider.SHULKER_GUTS));

        add("elder_spike_from_elder_guardian",
                new AddTableLootModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(Identifier.withDefaultNamespace("entities/elder_guardian")).build()
                },1000, ModExtraLootProvider.WITHER_BONE));

    }
}
