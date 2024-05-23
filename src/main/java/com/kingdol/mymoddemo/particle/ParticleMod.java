package com.kingdol.mymoddemo.particle;

import com.kingdol.mymoddemo.MymodDemo;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ParticleMod {

    public static final DefaultParticleType GREEN_FLAME = FabricParticleTypes.simple();
    public static final DefaultParticleType CUSTOM_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticle() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MymodDemo.MOD_ID, "green_flame"), GREEN_FLAME);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MymodDemo.MOD_ID, "custom_particle"), CUSTOM_PARTICLE);
    }

}