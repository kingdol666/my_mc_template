package com.kingdol.mymoddemo.item.customitems;


import com.kingdol.mymoddemo.gui.screen.TutorialScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CustomGuiItem extends Item {
    public CustomGuiItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
//        if (!world.isClient) {
//            player.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inv, playerEntity) -> new CustomScreenHandler(syncId, inv), Text.of("My Custom Screen")));
//        }
//        return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
        if (!world.isClient) {
            return TypedActionResult.success(itemStack);
        }
        MinecraftClient.getInstance().setScreen(
                new TutorialScreen()
        );
        return new TypedActionResult<>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }
}
