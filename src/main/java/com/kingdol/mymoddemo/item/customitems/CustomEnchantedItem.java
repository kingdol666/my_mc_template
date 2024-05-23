package com.kingdol.mymoddemo.item.customitems;

import com.kingdol.mymoddemo.particle.ParticleMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomEnchantedItem extends Item {
    public CustomEnchantedItem(FabricItemSettings settings) {
        super(settings);
    }

    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        super.onItemEntityDestroyed(entity);
    }
    private void spawnParticles(World world, PlayerEntity entity) {
        double x = entity.getX();
        double y = entity.getY() + 1.5;  // 粒子在实体头部上方一点
        double z = entity.getZ();

        for (int i = 0; i < 10; i++) {  // 生成多个粒子
            double offsetX = (world.random.nextDouble() - 0.5) * 0.5;
            double offsetY = (world.random.nextDouble() - 0.5) * 0.5;
            double offsetZ = (world.random.nextDouble() - 0.5) * 0.5;

            double speedX = (world.random.nextDouble() - 0.5) * 0.1;
            double speedY = (world.random.nextDouble() - 0.5) * 0.1;
            double speedZ = (world.random.nextDouble() - 0.5) * 0.1;

            world.addParticle(ParticleMod.CUSTOM_PARTICLE, x + offsetX, y + offsetY, z + offsetZ, speedX, speedY, speedZ);
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        spawnParticles(world, user);
        if (!world.isClient) {
            Random random = new Random();
            // 创建一个包含有益附魔的列表
            List<Enchantment> beneficialEnchantments = new ArrayList<>();
            beneficialEnchantments.add(Enchantments.SHARPNESS);
            beneficialEnchantments.add(Enchantments.EFFICIENCY);
            beneficialEnchantments.add(Enchantments.SMITE);
            beneficialEnchantments.add(Enchantments.UNBREAKING);
            beneficialEnchantments.add(Enchantments.FIRE_ASPECT);
            beneficialEnchantments.add(Enchantments.KNOCKBACK);
            // ... 添加更多的有益附魔
            int geEnchantIndex = random.nextInt(beneficialEnchantments.size());
            // 随机选择一个附魔
            Enchantment newEnchantment = beneficialEnchantments.get(geEnchantIndex);
            // 获取物品的附魔列表
            NbtList enchantments = stack.getEnchantments();

            if (enchantments != null && enchantments.size() == 5) {
                NbtCompound nbt = stack.getNbt();
                if(nbt!=null&&nbt.contains("Enchantments", NbtElement.LIST_TYPE)){
                    NbtList enchantmentList = nbt.getList("Enchantments", NbtElement.COMPOUND_TYPE);
                    Random IndexToRemove = new Random();
                    int i = IndexToRemove.nextInt(enchantmentList.size());
                    NbtCompound compound = enchantmentList.getCompound(i);
                    // 假设附魔ID存储在一个名为"id"的键下，这通常是Minecraft内部对于附魔的标识符
                    String enchantmentId = compound.getString("id");
                    String[] split = enchantmentId.split(":");
                    String enchantmentName = split[1];
                    enchantmentList.remove(i);
                    NbtCompound newNbt = new NbtCompound();
                    newNbt.copyFrom(nbt);
                    newNbt.put("Enchantments", enchantmentList);
                    stack.setNbt(newNbt);
                    user.sendMessage(Text.literal("你失去了"+enchantmentName), false);
                }
            }
            int level = random.nextInt(5) + 1;
            // 添加附魔到物品上，等级为1到5级之间的随机数
            stack.addEnchantment(newEnchantment, level);
            user.sendMessage(Text.literal("你获得了"+getEnchantName(geEnchantIndex)), false);
        }


        if (!(stack.getDamage() < stack.getMaxDamage() - 5)) {
            // 减少物品的耐久度
            // 如果耐久度不足以减少五点，销毁物品
            stack.decrement(1);
            PlayEnchantment(user);
        }

        return TypedActionResult.consume(stack);
    }

    private String getEnchantName(int getEnchantIndex) {
        return switch (getEnchantIndex) {
            case 0 -> "锋利";
            case 1 -> "效率";
            case 2 -> "亡灵杀手";
            case 3 -> "耐久";
            case 4 -> "火焰附加";
            case 5 -> "击退";
            default -> "default";
        };
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType == ClickType.RIGHT) {
            // 示例：添加迅捷药水效果
            StatusEffect speedEffect = StatusEffects.SPEED; // 从StatusEffects获取迅捷效果
            int durationInSeconds = 5 * 20; // 持续时间，每秒20ticks，这里设置为5秒
            int amplifier = 2; // 效果等级，1表示等级1

            // 创建药水效果实例
            StatusEffectInstance effectInstance = new StatusEffectInstance(speedEffect, durationInSeconds, amplifier);
            player.addStatusEffect(effectInstance);
        }

        return super.onClicked(stack, otherStack, slot, clickType, player, cursorStackReference);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("右键可以附魔这个物品!"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    private void PlayEnchantment(PlayerEntity user) {
        // 示例：添加迅捷药水效果
        StatusEffect speedEffect = StatusEffects.DARKNESS; // 从StatusEffects获取迅捷效果
        int durationInSeconds = 5 * 20; // 持续时间，每秒20ticks，这里设置为5秒
        int amplifier = 1; // 效果等级，1表示等级1
        // 创建药水效果实例
        StatusEffectInstance effectInstance = new StatusEffectInstance(speedEffect, durationInSeconds, amplifier);

        // 将药水效果应用到玩家
        user.addStatusEffect(effectInstance);
    }
}
