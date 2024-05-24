package com.kingdol.mymoddemo.datagen;

import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.blobk.iceether.IceEtherBuildings;
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

    // 注册方块模型
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // 创建材质模型
        BlockStateModelGenerator.BlockTexturePool iceEtherPool = blockStateModelGenerator.registerCubeAllModelTexturePool(RegistCustomBlocks.ICE_ETHER_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(RegistCustomBlocks.ICE_ETHER_BLOCK_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(RegistCustomBlocks.RAW_ICE_ETHER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(RegistCustomBlocks.CUSTOM_BLOCK_2);
        blockStateModelGenerator.registerSimpleCubeAll(RegistCustomBlocks.CUSTOM_BLOCK);

        iceEtherPool.stairs(IceEtherBuildings.ICE_ETHER_STAIR);
        iceEtherPool.slab(IceEtherBuildings.ICE_ETHER_SLAB);
        iceEtherPool.button(IceEtherBuildings.ICE_ETHER_BUTTON);
        iceEtherPool.pressurePlate(IceEtherBuildings.ICE_ETHER_PRESSURE_PLATE);
        iceEtherPool.fence(IceEtherBuildings.ICE_ETHER_FENCE);
        iceEtherPool.fenceGate(IceEtherBuildings.ICE_ETHER_FENCE_GATE);
        iceEtherPool.wall(IceEtherBuildings.ICE_ETHER_WALL);

        blockStateModelGenerator.registerDoor(IceEtherBuildings.ICE_ETHER_DOOR);
        blockStateModelGenerator.registerTrapdoor(IceEtherBuildings.ICE_ETHER_TRAPDOOR);
    }

    // 注册物品模型
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RegistItems.ICE_ETHER, Models.GENERATED);
        itemModelGenerator.register(RegistItems.RAW_ICE_ETHER, Models.GENERATED);
        itemModelGenerator.register(RegistItems.PROSPECTOR_ITEM, Models.GENERATED);
        itemModelGenerator.register(RegistItems.CUSTOM_ITEM, Models.GENERATED);
        itemModelGenerator.register(RegistItems.CUSTOM_ENCHANTED_ITEM, Models.GENERATED);
        itemModelGenerator.register(RegistItems.CUSTOM_FOOD_ITEM, Models.GENERATED);
        itemModelGenerator.register(CustomFuel.FUEL_OIL, Models.GENERATED);
        itemModelGenerator.register(RegistItems.FIRE_ETHER,Models.GENERATED);
        itemModelGenerator.register(RegistItems.CUSTOM_GUI_ITEM,Models.GENERATED);

        itemModelGenerator.register(RegistItems.FIRE_ETHER_PICKAXE,Models.HANDHELD);
        itemModelGenerator.register(RegistItems.FIRE_ETHER_AXE,Models.HANDHELD);
        itemModelGenerator.register(RegistItems.FIRE_ETHER_SHOVEL,Models.HANDHELD);
        itemModelGenerator.register(RegistItems.FIRE_ETHER_HOE,Models.HANDHELD);
        itemModelGenerator.register(RegistItems.FIRE_ETHER_SWORD,Models.HANDHELD);
    }
}
