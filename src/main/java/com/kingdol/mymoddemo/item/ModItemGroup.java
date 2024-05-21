package com.kingdol.mymoddemo.item;

import com.kingdol.mymoddemo.MymodDemo;
import com.kingdol.mymoddemo.blobk.ModBlock;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CUSTOM_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MymodDemo.MOD_ID, "tutorial_group"), FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.tutorial_group"))
                    .icon(() -> new ItemStack(CustomItem.CUSTOM_ITEM))
                    .entries(((displayContext, entries) -> {
                        entries.add(CustomItem.CUSTOM_ITEM);
                        entries.add(Items.BOOK);
                        entries.add(Blocks.GRASS_BLOCK);
                        entries.add(ModBlock.CUSTOM_BLOCK);
                        entries.add(ModBlock.CUSTOM_BLOCK_2);
                    })).build());

    public static void registeModItemGroup() {

    }
}


