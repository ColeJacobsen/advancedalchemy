package net.sugaryhydra.advancedalchemy.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sugaryhydra.advancedalchemy.AdvancedAlchemy;

public class ModItems {
    //Register for all mod items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AdvancedAlchemy.MOD_ID);

    public static final DeferredItem<Item> POTIONOFLEVITATION = ITEMS.registerSimpleItem("potion_of_levitation");
    public static final DeferredItem<Item> POTIONOFBLINDFURY= ITEMS.registerSimpleItem("potion_of_blind_fury");
    public static final DeferredItem<Item> SHULKERGUTS = ITEMS.registerSimpleItem("shulker_guts");





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
