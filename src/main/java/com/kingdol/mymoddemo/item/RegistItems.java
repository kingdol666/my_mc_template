package com.kingdol.mymoddemo.item;

import com.kingdol.mymoddemo.MymodDemo;
import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.food.CustomFood;
import com.kingdol.mymoddemo.item.customitems.CustomEnchantedItem;
import com.kingdol.mymoddemo.item.customitems.CustomFuel;
import com.kingdol.mymoddemo.item.customitems.Prospector;
import net.fabricmc.fabric.api.item.v1.CustomDamageHandler;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class RegistItems {
    public static final Item CUSTOM_ITEM = registerItem("custom_item", new Item(new Item.Settings()));
    public static final Item CUSTOM_FOOD_ITEM = registerItem("custom_food_item",
            new Item(new Item.Settings().food(CustomFood.CUSTOM_FOOD).maxCount(16)));
    public static final Item ICE_ETHER = registerItem("ice_ether", new Item(new Item.Settings()));
    public static final Item RAW_ICE_ETHER = registerItem("raw_ice_ether", new Item(new Item.Settings()));
    public static final Item CUSTOM_ENCHANTED_ITEM = registerItem("custom_enchanted_item",
            new CustomEnchantedItem(new FabricItemSettings().customDamage(new CustomDamageHandler() {
                @Override
                public int damage(ItemStack stack, int amount, LivingEntity entity, Consumer<LivingEntity> breakCallback) {
                    World world = entity.getWorld();
                    if (!world.isClient) {
                        if (world.random.nextFloat() < 0.5F) {
//                            // 创建一个伤害来源，这里使用了一个简单的伤害来源
//                            DamageSource damageSource = new DamageSource((RegistryEntry<DamageType>) DamageTypes.GENERIC);
//                            // 对实体造成伤害
//                            entity.damage(damageSource, 10.0F); // 造成10点伤害
                            // 设置实体着火
                            // 有50%的几率对目标造成火焰伤害
                            if (entity.getWorld().random.nextFloat() < 0.5F) {
                                entity.setOnFireFor(5); // 火焰效果持续5秒
                            }
                        }
                    }

                    // 返回0表示不消耗物品耐久
                    if (entity.getWorld().random.nextFloat() < 0.5F) {
                        // 不消耗耐久度
                        return 0;
                    } else {
                        // 消耗正常的耐久度
                        return amount;
                    }
                }
            }).maxDamageIfAbsent(30).rarity(Rarity.UNCOMMON)));

        public static void addItemToIngredients(FabricItemGroupEntries entries){
        entries.add(CUSTOM_ITEM);
        entries.add(ICE_ETHER);
        entries.add(RAW_ICE_ETHER);
    }
    public static final Item PROSPECTOR_ITEM = registerItem("prospector_item", new Prospector(new Item.Settings()));
    public static void addItemToBuilding(FabricItemGroupEntries entries){
        entries.add(RegistCustomBlocks.ICE_ETHER_BLOCK);
        entries.add(RegistCustomBlocks.CUSTOM_BLOCK_2);
        entries.add(RegistCustomBlocks.RAW_ICE_ETHER_BLOCK);
    }
    public static void addItemToFood(FabricItemGroupEntries entries){
        entries.add(CUSTOM_FOOD_ITEM);
    }
    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MymodDemo.MOD_ID, name), item);
    }
    public static void registerCustomItem(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(RegistItems::addItemToIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(RegistItems::addItemToFood);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(RegistItems::addItemToBuilding);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(RegistItems::addItemToColoredBlocks);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(RegistItems::addItemToCombat);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(RegistItems::addItemToFunctional);
    }

    private static void addItemToFunctional(FabricItemGroupEntries entries) {
        entries.add(CUSTOM_ENCHANTED_ITEM);
        entries.add(PROSPECTOR_ITEM);
    }

    private static void addItemToCombat(FabricItemGroupEntries entries) {
        entries.add(RegistCustomBlocks.ICE_ETHER_BLOCK_ORE);
    }

    private static void addItemToColoredBlocks(FabricItemGroupEntries entries) {

    }
}
