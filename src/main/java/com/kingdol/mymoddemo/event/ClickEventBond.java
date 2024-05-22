package com.kingdol.mymoddemo.event;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;

import static com.kingdol.mymoddemo.item.RegistItems.CUSTOM_ITEM;


public class ClickEventBond {

    public static void registerEvents() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack itemStack = player.getStackInHand(hand);

            // 检查玩家使用的是不是自定义Item
            if (itemStack.getItem() == CUSTOM_ITEM) {
                // 使用Text.literal方法创建文本对象
                player.sendMessage(Text.literal("你使用了自定义物品"), false);
                return new TypedActionResult<>(ActionResult.CONSUME, itemStack);
            }

            return new TypedActionResult<>(ActionResult.PASS, itemStack);
        });
    }
}
