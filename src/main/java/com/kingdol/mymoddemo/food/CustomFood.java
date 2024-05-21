package com.kingdol.mymoddemo.food;

import net.minecraft.item.FoodComponent;

public class CustomFood {
    public static final FoodComponent CUSTOM_FOOD = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).build();
}
