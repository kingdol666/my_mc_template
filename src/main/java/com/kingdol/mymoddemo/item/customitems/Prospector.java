package com.kingdol.mymoddemo.item.customitems;

import com.kingdol.mymoddemo.utils.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class Prospector extends Item {
    public Prospector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient()){
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            for (int i = -64;i <= blockPos.getY() +64; i++){
                BlockState state = context.getWorld().getBlockState(blockPos.down(i));
                if (isRightBlock(state)){
                    if (player != null) {
                        outputMessage(blockPos.down(i),player,state.getBlock());
                    }
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock){
                if (player != null) {
                    player.sendMessage(Text.literal("No Ore Found!"));
                }
            }
        }
        context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        return ActionResult.SUCCESS;
    }

    private void outputMessage(BlockPos down, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found" + block.asItem().getName().getString() + "at" +
                "(" + down.getX() + "," + down.getY() + "," +down.getZ() + ")!"),false);
        int ore_y = down.getY();
        int player_y = player.getBlockPos().getY();
        if (ore_y > player_y){
            player.sendMessage(Text.literal("Ore is above you "+(ore_y-player_y)+"!"),false);
        }else if (ore_y < player_y){
            player.sendMessage(Text.literal("Ore is below you "+(player_y-ore_y)+"!"),false);
        }else {
            player.sendMessage(Text.literal("Ore is at the same level as you!"),false);
        }
    }

    private boolean isRightBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.PROSPECT_BLOCK_TAG);
    }
}