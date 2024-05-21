package com.kingdol.mymoddemo;

import com.kingdol.mymoddemo.blobk.ModBlock;
import com.kingdol.mymoddemo.item.CustomItem;
import com.kingdol.mymoddemo.item.ModItemGroup;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MymodDemo implements ModInitializer {
	public static final String MOD_ID = "mymoddemo";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		CustomItem.registerCustomItem();
		ModItemGroup.registeModItemGroup();
		ModBlock.registerModBlock();
		LOGGER.info("Hello Fabric world!");
	}
}