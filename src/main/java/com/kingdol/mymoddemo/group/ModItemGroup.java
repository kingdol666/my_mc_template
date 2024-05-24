package com.kingdol.mymoddemo.group;

import com.kingdol.mymoddemo.MymodDemo;
import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.blobk.iceether.IceEtherBuildings;
import com.kingdol.mymoddemo.item.RegistItems;
import com.kingdol.mymoddemo.item.customitems.CustomFuel;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CUSTOM_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MymodDemo.MOD_ID, "tutorial_group"), FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.tutorial_group"))
                    .icon(() -> new ItemStack(RegistItems.CUSTOM_ITEM))
                    .entries(((displayContext, entries) -> {
                        entries.add(RegistItems.CUSTOM_ITEM);
                        entries.add(RegistItems.CUSTOM_FOOD_ITEM);
                        entries.add(RegistItems.ICE_ETHER);
                        entries.add(RegistItems.FIRE_ETHER);
                        entries.add(RegistItems.RAW_ICE_ETHER);
                        entries.add(RegistCustomBlocks.CUSTOM_BLOCK);
                        entries.add(RegistCustomBlocks.CUSTOM_BLOCK_2);
                        entries.add(RegistCustomBlocks.ICE_ETHER_BLOCK);
                        entries.add(RegistCustomBlocks.RAW_ICE_ETHER_BLOCK);
                        entries.add(RegistCustomBlocks.ICE_ETHER_BLOCK_ORE);
                        entries.add(RegistItems.CUSTOM_ENCHANTED_ITEM);
                        entries.add(CustomFuel.FUEL_OIL);
                        entries.add(RegistItems.PROSPECTOR_ITEM);

                        entries.add(IceEtherBuildings.ICE_ETHER_BUTTON);
                        entries.add(IceEtherBuildings.ICE_ETHER_DOOR);
                        entries.add(IceEtherBuildings.ICE_ETHER_FENCE);
                        entries.add(IceEtherBuildings.ICE_ETHER_FENCE_GATE);
                        entries.add(IceEtherBuildings.ICE_ETHER_STAIR);
                        entries.add(IceEtherBuildings.ICE_ETHER_SLAB);
                        entries.add(IceEtherBuildings.ICE_ETHER_PRESSURE_PLATE);
                        entries.add(IceEtherBuildings.ICE_ETHER_WALL);
                        entries.add(IceEtherBuildings.ICE_ETHER_TRAPDOOR);

                        entries.add(RegistItems.FIRE_ETHER_PICKAXE);
                        entries.add(RegistItems.FIRE_ETHER_AXE);
                        entries.add(RegistItems.FIRE_ETHER_SHOVEL);
                        entries.add(RegistItems.FIRE_ETHER_HOE);
                        entries.add(RegistItems.FIRE_ETHER_SWORD);
                    })).build());

    public static void registeModItemGroup() {

    }
}


