package com.kingdol.mymoddemo.item;

import com.kingdol.mymoddemo.MymodDemo;
import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.food.CustomFood;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegistItems {
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
        entries.add(RegistCustomBlocks.ICE_ETHER_BLOCK);
        entries.add(RegistCustomBlocks.CUSTOM_BLOCK_2);
        entries.add(RegistCustomBlocks.RAW_ICE_ETHER_BLOCK);
    }
    public static void addItemToFood(FabricItemGroupEntries entries){
        entries.add(CUSTOM_FOOD_ITEM);
    }
    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MymodDemo.MOD_ID, name), item);
    }
    public static void registerCustomItem(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(RegistItems::addItemToIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(RegistItems::addItemToFood);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(RegistItems::addItemToBuilding);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(RegistItems::addItemToColoredBlocks);
    }

    private static void addItemToColoredBlocks(FabricItemGroupEntries entries) {
        entries.add(RegistCustomBlocks.ICE_ETHER_BLOCK_ORE);
    }
}
