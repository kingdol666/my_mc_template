package com.kingdol.mymoddemo.utils;

import com.kingdol.mymoddemo.MymodDemo;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public class Blocks{
        public static TagKey<Block> CUSTOM_BLOCK_TAG = registBlockTag("custom_block_list");
        public static TagKey<Block> PROSPECT_BLOCK_TAG =  registBlockTag("prospect_list");
        public static TagKey<Block> registBlockTag(String name)
        {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(MymodDemo.MOD_ID, name));
        }
    }
    public class Items{
        public static TagKey<Item> CUSTOM_ITEM_TAG = registBlockTag("custom_item_list");
        public static TagKey<Item> registBlockTag(String name)
        {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(MymodDemo.MOD_ID, name));
        }
    }
}
