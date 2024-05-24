package com.kingdol.mymoddemo.datagen;

import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.blobk.iceether.IceEtherBuildings;
import com.kingdol.mymoddemo.item.RegistItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    // 战利品生成
    @Override
    public void generate() {
        addDrop(RegistCustomBlocks.RAW_ICE_ETHER_BLOCK);
        addDrop(RegistCustomBlocks.ICE_ETHER_BLOCK);
        addDrop(RegistCustomBlocks.CUSTOM_BLOCK_2);
        addDrop(RegistCustomBlocks.CUSTOM_BLOCK);
        addDrop(RegistCustomBlocks.ICE_ETHER_BLOCK_ORE,copperOreLikeDrops(RegistCustomBlocks.ICE_ETHER_BLOCK_ORE, RegistItems.RAW_ICE_ETHER));

        addDrop(IceEtherBuildings.ICE_ETHER_STAIR);
        addDrop(IceEtherBuildings.ICE_ETHER_FENCE);
        addDrop(IceEtherBuildings.ICE_ETHER_FENCE_GATE);
        addDrop(IceEtherBuildings.ICE_ETHER_BUTTON);
        addDrop(IceEtherBuildings.ICE_ETHER_PRESSURE_PLATE);
        addDrop(IceEtherBuildings.ICE_ETHER_WALL);
        addDrop(IceEtherBuildings.ICE_ETHER_TRAPDOOR);

        addDrop(IceEtherBuildings.ICE_ETHER_DOOR,doorDrops(IceEtherBuildings.ICE_ETHER_DOOR));
        addDrop(IceEtherBuildings.ICE_ETHER_SLAB,slabDrops(IceEtherBuildings.ICE_ETHER_SLAB));
    }
    // 自定义掉落
    // 添加自定义掉落item
    public LootTable.Builder copperOreLikeDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                this.applyExplosionDecay(drop,
                        ((LeafEntry.Builder<?>) ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f))))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
