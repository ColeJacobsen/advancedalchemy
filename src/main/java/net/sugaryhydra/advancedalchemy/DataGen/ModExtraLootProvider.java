package net.sugaryhydra.advancedalchemy.DataGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;
import net.sugaryhydra.advancedalchemy.item.ModItems;

import java.util.function.BiConsumer;

public class ModExtraLootProvider implements LootTableSubProvider {
    public static final ResourceKey<LootTable> WITHER_BONE = ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(AdvancedAlchemy.MOD_ID, "extra/glm/wither_bone"));
    public static final ResourceKey<LootTable> SHULKER_GUTS = ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(AdvancedAlchemy.MOD_ID, "extra/glm/shulker_guts"));
    public static final ResourceKey<LootTable> ELDER_SPIKE = ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(AdvancedAlchemy.MOD_ID, "extra/glm/elder_spike"));
    public static final ResourceKey<LootTable> HEAD = ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(AdvancedAlchemy.MOD_ID, "extra/glm/head"));


    public ModExtraLootProvider(HolderLookup.Provider provider){

    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {

        biConsumer.accept(WITHER_BONE,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1f)) //table is always rolled
                        .when(LootItemRandomChanceCondition.randomChance(0.25f)) //Occurs 25% of the time
                        .add(LootItem.lootTableItem(ModItems.WITHERBONE.get()))));

        biConsumer.accept(SHULKER_GUTS,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1f)) //table is always rolled//Occurs 100% of the time
                        .add(LootItem.lootTableItem(ModItems.SHULKERGUTS.get()))));

        biConsumer.accept(ELDER_SPIKE,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1f)) //table is always rolled
                        .add(LootItem.lootTableItem(ModItems.ELDERSPIKE.get())) //Occurs 100% of the time as there is no chance
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3f, 5f)))));

       // biConsumer.accept(HEAD,
         //       LootTable.lootTable().withPool(LootPool.lootPool()
           //             .setRolls(ConstantValue.exactly(1f)) //table is always rolled
             //           .add(LootItem.lootTableItem(Items.PLAYER_HEAD))));
    }
}
