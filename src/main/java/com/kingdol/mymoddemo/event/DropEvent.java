package com.kingdol.mymoddemo.event;

import com.kingdol.mymoddemo.item.RegistItems;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import java.util.Random;

public class DropEvent {
    public static void Init() {
        // 注册方块破坏事件监听器
        PlayerBlockBreakEvents.AFTER.register(DropEvent::onBlockBroken);
    }

    private static void onBlockBroken(World world, PlayerEntity player, net.minecraft.util.math.BlockPos pos, net.minecraft.block.BlockState state, net.minecraft.block.entity.BlockEntity blockEntity) {
        // 检查是否在服务器端
        if (!world.isClient) {
            Random random = new Random();
            // 0到0.1的概率
            if (random.nextFloat() < 0.08) {
                // 创建掉落物
                ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), RegistItems.FIRE_ETHER.getDefaultStack());
                // 将掉落物添加到世界中
                world.spawnEntity(itemEntity);
            }
        }
    }
}
