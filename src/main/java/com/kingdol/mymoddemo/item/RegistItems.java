package com.kingdol.mymoddemo.item;

import com.kingdol.mymoddemo.MymodDemo;
import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.blobk.iceether.IceEtherBuildings;
import com.kingdol.mymoddemo.food.CustomFood;
import com.kingdol.mymoddemo.item.customitems.*;
import com.kingdol.mymoddemo.item.utils.Classify;
import com.kingdol.mymoddemo.item.utils.ModToolMaterial;
import net.fabricmc.fabric.api.item.v1.CustomDamageHandler;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.*;
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
    public static final Item FIRE_ETHER = registerItem("fire_ether", new FireEther(new FabricItemSettings().maxDamage(128)));
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


    public static final Item PROSPECTOR_ITEM = registerItem("prospector_item", new Prospector(new Item.Settings()));

    public static final Item FIRE_ETHER_PICKAXE = registerItem("fire_ether_pickaxe",
            new PickaxeItem(ModToolMaterial.FIRE_ETHER, 2, 2f, new FabricItemSettings()));
    public static final Item FIRE_ETHER_AXE = registerItem("fire_ether_axe",
            new AxeItem(ModToolMaterial.FIRE_ETHER, 3, 1f, new FabricItemSettings()));
    public static final Item FIRE_ETHER_SHOVEL = registerItem("fire_ether_shovel",
            new ShovelItem(ModToolMaterial.FIRE_ETHER, 0, 0f, new FabricItemSettings()));
    public static final Item FIRE_ETHER_SWORD = registerItem("fire_ether_sword",
            new SwordItem(ModToolMaterial.FIRE_ETHER, 5, 3f, new FabricItemSettings()));
    public static final Item FIRE_ETHER_HOE = registerItem("fire_ether_hoe",
            new HoeItem(ModToolMaterial.FIRE_ETHER, 0, 0f, new FabricItemSettings()));

    public static final Item CUSTOM_GUI_ITEM = registerItem("custom_gui_item",
            new CustomGuiItem(new FabricItemSettings().maxCount(1)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MymodDemo.MOD_ID, name), item);
    }


    public static void registerCustomItem() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(Classify::addItemToIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(Classify::addItemToFood);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(Classify::addItemToBuilding);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(Classify::addItemToNATURAL);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(Classify::addItemToCombat);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(Classify::addItemToTools);
    }
}
