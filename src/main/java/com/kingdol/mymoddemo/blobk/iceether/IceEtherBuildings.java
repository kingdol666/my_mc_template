package com.kingdol.mymoddemo.blobk.iceether;

import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;

public class IceEtherBuildings {
    public static final Block ICE_ETHER_STAIR = RegistCustomBlocks.registerBlock("ice_ether_stair",
            new StairsBlock(RegistCustomBlocks.ICE_ETHER_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_SLAB = RegistCustomBlocks.registerBlock("ice_ether_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_BUTTON = RegistCustomBlocks.registerBlock("ice_ether_button",
            new ButtonBlock(BlockSetType.STONE,20,FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_PRESSURE_PLATE = RegistCustomBlocks.registerBlock("ice_ether_pressure_plate",
            new PressurePlateBlock(BlockSetType.STONE, FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_FENCE = RegistCustomBlocks.registerBlock("ice_ether_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_FENCE_GATE = RegistCustomBlocks.registerBlock("ice_ether_fence_gate",
            new FenceGateBlock(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_WALL = RegistCustomBlocks.registerBlock("ice_ether_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_DOOR = RegistCustomBlocks.registerBlock("ice_ether_door",
            new DoorBlock(BlockSetType.STONE, FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque()));
    public static final Block ICE_ETHER_TRAPDOOR = RegistCustomBlocks.registerBlock("ice_ether_trapdoor",
            new TrapdoorBlock(BlockSetType.STONE, FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque()));

    public static void ClientInit() {
        BlockRenderLayerMap.INSTANCE.putBlock(IceEtherBuildings.ICE_ETHER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(IceEtherBuildings.ICE_ETHER_TRAPDOOR,RenderLayer.getCutout());
    }
    public static void registerIceEtherBuildings() {

    }
}
