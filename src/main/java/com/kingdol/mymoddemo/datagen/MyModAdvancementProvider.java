package com.kingdol.mymoddemo.datagen;

import com.kingdol.mymoddemo.item.RegistItems;
import com.sun.java.accessibility.util.Translator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.TranslatableOption;

import java.util.function.Consumer;

import static net.minecraft.data.server.recipe.RecipeProvider.conditionsFromItem;
import static net.minecraft.data.server.recipe.RecipeProvider.hasItem;

public class MyModAdvancementProvider extends FabricAdvancementProvider {


    public MyModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
//        Advancement root = Advancement.Builder.create()
//                .display(
//                        Items.CRAFTING_TABLE,
//                        Text.translatable("advancements.mymoddemo.recipes.tools.fire_ether_to_sword.title"),
//                        Text.translatable("advancements.mymoddemo.recipes.tools.fire_ether_to_sword.description"),
//                        null,
//                        AdvancementFrame.TASK,
//                        true,
//                        true,
//                        false
//                )
//                .criterion("has_crafting_table", InventoryChangedCriterion.Conditions.items(Items.CRAFTING_TABLE))
//                .criterion(hasItem(RegistItems.FIRE_ETHER), conditionsFromItem(RegistItems.FIRE_ETHER))
//                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
//                .build(consumer, "mymoddemo:recipes/combat/fire_ether_to_sword").value();
//
//        Advancement root2 = Advancement.Builder.create()
//                .display(
//                        Items.CRAFTING_TABLE,
//                        Text.translatable("advancements.mymoddemo.recipes.tools.fire_ether_to_hoe.title"),
//                        Text.translatable("advancements.mymoddemo.recipes.tools.fire_ether_to_hoe.description"),
//                        null,
//                        AdvancementFrame.TASK,
//                        true,
//                        true,
//                        false
//                )
//                .criterion("has_crafting_table", InventoryChangedCriterion.Conditions.items(Items.CRAFTING_TABLE))
//                .criterion(hasItem(RegistItems.FIRE_ETHER), conditionsFromItem(RegistItems.FIRE_ETHER))
//                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
//                .build(consumer, "mymoddemo:recipes/tools/fire_ether_to_hoe").value();
    }
}
