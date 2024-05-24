package com.kingdol.mymoddemo;

import com.kingdol.mymoddemo.blobk.iceether.IceEtherBuildings;
import com.kingdol.mymoddemo.gui.RegisterScreen;
import com.kingdol.mymoddemo.particle.ParticleMod;
import com.kingdol.mymoddemo.particle.instance.CustomParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FlameParticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.kingdol.mymoddemo.particle.ParticleMod.GREEN_FLAME;

public class MymodDemoClient implements ClientModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("mymoddemo");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Hello "+ MymodDemo.MOD_ID);
        ParticleFactoryRegistry.getInstance().register(GREEN_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ParticleMod.CUSTOM_PARTICLE, CustomParticle.CustomParticleFactory::new);
        RegisterScreen.onInitializeClient();
        IceEtherBuildings.ClientInit();
    }
}