package com.kingdol.mymoddemo.item.utils;

import com.kingdol.mymoddemo.MymodDemo;
import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.blobk.iceether.IceEtherBuildings;
import com.kingdol.mymoddemo.item.RegistItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.kingdol.mymoddemo.item.RegistItems.*;

public class Classify {
    public static void addItemToBuilding(FabricItemGroupEntries entries) {
        entries.add(RegistCustomBlocks.ICE_ETHER_BLOCK);
        entries.add(RegistCustomBlocks.CUSTOM_BLOCK_2);
        entries.add(RegistCustomBlocks.RAW_ICE_ETHER_BLOCK);

        entries.add(IceEtherBuildings.ICE_ETHER_BUTTON);
        entries.add(IceEtherBuildings.ICE_ETHER_DOOR);
        entries.add(IceEtherBuildings.ICE_ETHER_FENCE);
        entries.add(IceEtherBuildings.ICE_ETHER_FENCE_GATE);
        entries.add(IceEtherBuildings.ICE_ETHER_STAIR);
        entries.add(IceEtherBuildings.ICE_ETHER_SLAB);
        entries.add(IceEtherBuildings.ICE_ETHER_PRESSURE_PLATE);
        entries.add(IceEtherBuildings.ICE_ETHER_WALL);
        entries.add(IceEtherBuildings.ICE_ETHER_TRAPDOOR);
    }

    public static void addItemToFood(FabricItemGroupEntries entries) {
        entries.add(CUSTOM_FOOD_ITEM);
    }

    public static void addItemToIngredients(FabricItemGroupEntries entries) {
        entries.add(CUSTOM_ITEM);
        entries.add(ICE_ETHER);
        entries.add(RAW_ICE_ETHER);
    }

    public static void addItemToTools(FabricItemGroupEntries entries) {
        entries.add(CUSTOM_ENCHANTED_ITEM);
        entries.add(PROSPECTOR_ITEM);
        entries.add(RegistItems.FIRE_ETHER_PICKAXE);
        entries.add(RegistItems.FIRE_ETHER_AXE);
        entries.add(RegistItems.FIRE_ETHER_SHOVEL);
        entries.add(RegistItems.FIRE_ETHER_HOE);
    }

    public static void addItemToCombat(FabricItemGroupEntries entries) {
        entries.add(FIRE_ETHER_SWORD);
    }

    public static void addItemToNATURAL(FabricItemGroupEntries entries) {
        entries.add(RegistCustomBlocks.ICE_ETHER_BLOCK_ORE);
    }
}
