package com.kingdol.mymoddemo.datagen;

import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.item.RegistItems;
import com.kingdol.mymoddemo.item.customitems.CustomFuel;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(RegistCustomBlocks.ICE_ETHER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(RegistCustomBlocks.ICE_ETHER_BLOCK_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(RegistCustomBlocks.RAW_ICE_ETHER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(RegistCustomBlocks.CUSTOM_BLOCK_2);
        blockStateModelGenerator.registerSimpleCubeAll(RegistCustomBlocks.CUSTOM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RegistItems.ICE_ETHER, Models.GENERATED);
        itemModelGenerator.register(RegistItems.RAW_ICE_ETHER, Models.GENERATED);
        itemModelGenerator.register(RegistItems.PROSPECTOR_ITEM, Models.GENERATED);
        itemModelGenerator.register(RegistItems.CUSTOM_ITEM, Models.GENERATED);
        itemModelGenerator.register(RegistItems.CUSTOM_ENCHANTED_ITEM, Models.GENERATED);
        itemModelGenerator.register(RegistItems.CUSTOM_FOOD_ITEM, Models.GENERATED);
        itemModelGenerator.register(CustomFuel.FUEL_OIL, Models.GENERATED);
    }
}
