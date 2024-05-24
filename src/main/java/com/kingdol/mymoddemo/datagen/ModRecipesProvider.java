package com.kingdol.mymoddemo.datagen;

import com.kingdol.mymoddemo.MymodDemo;
import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.item.RegistItems;
import com.kingdol.mymoddemo.item.customitems.CustomFuel;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;


public class ModRecipesProvider extends FabricRecipeProvider {
    public static final List<ItemConvertible> ICE_ETHER_ITEMS = List.of(RegistItems.RAW_ICE_ETHER);

    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // 九九归一
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, RegistItems.ICE_ETHER,
                RecipeCategory.BUILDING_BLOCKS, RegistCustomBlocks.ICE_ETHER_BLOCK);

        // 熔炉配置
        offerSmelting(exporter, ICE_ETHER_ITEMS, RecipeCategory.MISC, RegistItems.ICE_ETHER, 0.1f, 200, "ice_ether");

        // 高炉配置
        offerBlasting(exporter, ICE_ETHER_ITEMS, RecipeCategory.MISC, RegistItems.ICE_ETHER, 0.1f, 100, "ice_ether");

        // 自定义配方
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR, 1)
                .pattern("###")
                .input('#', Items.BEETROOT)
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter, new Identifier("sugar_from_beetroot"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, CustomFuel.FUEL_OIL, 1)
                .pattern("##A")
                .input('#', RegistItems.FIRE_ETHER)
                .input('A', Items.COAL)
                .criterion(hasItem(RegistItems.FIRE_ETHER), conditionsFromItem(RegistItems.FIRE_ETHER))
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .offerTo(exporter, new Identifier("ether_to_fuel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, RegistItems.FIRE_ETHER_SWORD, 1)
                .pattern("A")
                .pattern("A")
                .pattern("#")
                .input('A', RegistItems.FIRE_ETHER)
                .input('#', Items.STICK)
                .criterion(hasItem(RegistItems.FIRE_ETHER), conditionsFromItem(RegistItems.FIRE_ETHER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier("fire_ether_to_sword"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, RegistItems.FIRE_ETHER_PICKAXE, 1)
                .pattern("AAA")
                .pattern(" # ")
                .pattern(" # ")
                .input('A', RegistItems.FIRE_ETHER)
                .input('#', Items.STICK)
                .criterion(hasItem(RegistItems.FIRE_ETHER), conditionsFromItem(RegistItems.FIRE_ETHER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier("fire_ether_to_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, RegistItems.FIRE_ETHER_AXE, 1)
                .pattern(" AA")
                .pattern(" #A")
                .pattern(" # ")
                .input('A', RegistItems.FIRE_ETHER)
                .input('#', Items.STICK)
                .criterion("has_fire_ether", InventoryChangedCriterion.Conditions.items(RegistItems.FIRE_ETHER))
                .criterion("has_stick", InventoryChangedCriterion.Conditions.items(Items.STICK))
                .offerTo(exporter, new Identifier("fire_ether_to_axe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, RegistItems.FIRE_ETHER_SHOVEL, 1)
                .pattern("A")
                .pattern("#")
                .pattern("#")
                .input('A', RegistItems.FIRE_ETHER)
                .input('#', Items.STICK)
                .criterion("has_fire_ether", InventoryChangedCriterion.Conditions.items(RegistItems.FIRE_ETHER))
                .criterion("has_stick", InventoryChangedCriterion.Conditions.items(Items.STICK))
                .offerTo(exporter, new Identifier("fire_ether_to_shovel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, RegistItems.FIRE_ETHER_HOE, 1)
                .pattern(" AA")
                .pattern(" # ")
                .pattern(" # ")
                .input('A', RegistItems.FIRE_ETHER)
                .input('#', Items.STICK)
                .criterion("has_fire_ether", InventoryChangedCriterion.Conditions.items(RegistItems.FIRE_ETHER))
                .criterion("has_stick", InventoryChangedCriterion.Conditions.items(Items.STICK))
                .offerTo(exporter, new Identifier("fire_ether_to_hoe"));
    }
}
