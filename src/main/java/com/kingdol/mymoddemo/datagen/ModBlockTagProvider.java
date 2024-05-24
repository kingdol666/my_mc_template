package com.kingdol.mymoddemo.datagen;

import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.blobk.iceether.IceEtherBuildings;
import com.kingdol.mymoddemo.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.PROSPECT_BLOCK_TAG)
                .add(RegistCustomBlocks.ICE_ETHER_BLOCK)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(RegistCustomBlocks.ICE_ETHER_BLOCK)
                .add(RegistCustomBlocks.RAW_ICE_ETHER_BLOCK)
                .add(RegistCustomBlocks.ICE_ETHER_BLOCK_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(RegistCustomBlocks.ICE_ETHER_BLOCK)
                .add(RegistCustomBlocks.ICE_ETHER_BLOCK_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(RegistCustomBlocks.RAW_ICE_ETHER_BLOCK);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(RegistCustomBlocks.CUSTOM_BLOCK_2);
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(IceEtherBuildings.ICE_ETHER_BUTTON);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(IceEtherBuildings.ICE_ETHER_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(IceEtherBuildings.ICE_ETHER_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(IceEtherBuildings.ICE_ETHER_WALL);
    }
}
