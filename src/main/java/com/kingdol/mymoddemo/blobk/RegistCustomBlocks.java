package com.kingdol.mymoddemo.blobk;

import com.kingdol.mymoddemo.MymodDemo;
import com.kingdol.mymoddemo.blobk.iceether.IceEtherBuildings;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class RegistCustomBlocks {
    public static final Block CUSTOM_BLOCK = registerBlock("custom_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(4.0f)));
    public static final Block ICE_ETHER_BLOCK = registerBlock("ice_ether_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(5.0f)));

    public static final Block ICE_ETHER_BLOCK_ORE = registerBlock("ice_ether_block_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4),
                    FabricBlockSettings.copyOf(Blocks.IRON_ORE)
                            .strength(5.0f)
                            .sounds(BlockSoundGroup.STONE)));

    public static final Block RAW_ICE_ETHER_BLOCK = registerBlock("raw_ice_ether_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(5.0f)));
    public static final Block CUSTOM_BLOCK_2 = registerBlock("custom_block_2",
            new Block(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).strength(3.0f)));
    public static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MymodDemo.MOD_ID, name), block);
    }
    public static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, new Identifier(MymodDemo.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlock()
    {
        IceEtherBuildings.registerIceEtherBuildings();
    }
}
