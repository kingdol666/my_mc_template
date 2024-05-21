package com.kingdol.mymoddemo.item;

import com.kingdol.mymoddemo.MymodDemo;
import com.kingdol.mymoddemo.blobk.ModBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomItem {
    public static final Item CUSTOM_ITEM = registerItem("custom_item", new Item(new Item.Settings()));

    public static void addItem(FabricItemGroupEntries entries){
        entries.add(CUSTOM_ITEM);
        entries.add(ModBlock.CUSTOM_BLOCK_2);
    }
    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MymodDemo.MOD_ID, name), item);
    }
    public static void registerCustomItem(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(CustomItem::addItem);
    }
}
