package com.kingdol.mymoddemo;

import com.kingdol.mymoddemo.blobk.RegistCustomBlocks;
import com.kingdol.mymoddemo.event.RegisterEvent;
import com.kingdol.mymoddemo.item.RegistItems;
import com.kingdol.mymoddemo.group.ModItemGroup;
import com.kingdol.mymoddemo.item.customitems.CustomFuel;
import com.kingdol.mymoddemo.particle.ParticleMod;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
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
		RegistItems.registerCustomItem();
		ModItemGroup.registeModItemGroup();
		RegistCustomBlocks.registerModBlock();
		RegisterEvent.registerEvents();
		ParticleMod.registerParticle();
		FuelRegistry.INSTANCE.add(CustomFuel.FUEL_OIL, 200);
		LOGGER.info("Hello Fabric world!");
	}
}