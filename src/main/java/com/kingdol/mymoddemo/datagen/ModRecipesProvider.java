package com.kingdol.mymoddemo.datagen;

import com.kingdol.mymoddemo.MymodDemo;
import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.item.RegistItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
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
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, RegistItems.ICE_ETHER,
                RecipeCategory.BUILDING_BLOCKS, RegistCustomBlocks.ICE_ETHER_BLOCK);

        offerSmelting(exporter, ICE_ETHER_ITEMS, RecipeCategory.MISC, RegistItems.ICE_ETHER, 0.1f, 200, "ice_ether");

        offerBlasting(exporter, ICE_ETHER_ITEMS, RecipeCategory.MISC, RegistItems.ICE_ETHER, 0.1f, 100, "ice_ether");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR, 1)
                .pattern("###")
                .input('#', Items.BEETROOT)
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter, new Identifier("sugar_from_beetroot"));
    }
}
