package com.kingdol.mymoddemo.item;

import com.kingdol.mymoddemo.MymodDemo;
import com.kingdol.mymoddemo.blobk.ModBlock;
import com.kingdol.mymoddemo.food.CustomFood;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomItem {
    public static final Item CUSTOM_ITEM = registerItem("custom_item", new Item(new Item.Settings()));
    public static final Item CUSTOM_FOOD_ITEM = registerItem("custom_food_item", new Item(new Item.Settings().food(CustomFood.CUSTOM_FOOD).maxCount(16)));
    public static final Item ICE_ETHER = registerItem("ice_ether", new Item(new Item.Settings()));
    public static final Item RAW_ICE_ETHER = registerItem("raw_ice_ether", new Item(new Item.Settings()));
    public static void addItemToIngredients(FabricItemGroupEntries entries){
        entries.add(CUSTOM_ITEM);
        entries.add(ICE_ETHER);
        entries.add(RAW_ICE_ETHER);
    }
    public static void addItemToBuilding(FabricItemGroupEntries entries){
        entries.add(ModBlock.ICE_ETHER_BLOCK);
        entries.add(ModBlock.CUSTOM_BLOCK_2);
    }
    public static void addItemToFood(FabricItemGroupEntries entries){
        entries.add(CUSTOM_FOOD_ITEM);
    }
    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MymodDemo.MOD_ID, name), item);
    }
    public static void registerCustomItem(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(CustomItem::addItemToIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(CustomItem::addItemToFood);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(CustomItem::addItemToBuilding);
    }
}
