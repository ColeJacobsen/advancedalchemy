package net.sugaryhydra.advancedalchemy.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;

public class ModItems {
    //Register for all mod items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AdvancedAlchemy.MOD_ID);

    public static final DeferredItem<Item> SHULKERGUTS = ITEMS.registerSimpleItem("shulker_guts");
    public static final DeferredItem<Item> WITHERBONE = ITEMS.registerSimpleItem("wither_bone");
    public static final DeferredItem<Item> ANCIENTCELL = ITEMS.registerSimpleItem("ancient_cell");





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
