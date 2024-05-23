package com.kingdol.mymoddemo.particle.instance;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;

public class CustomParticle extends SpriteBillboardParticle {
    protected CustomParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.scale = 0.2F;
        this.maxAge = 40;
    }
    @Override
    public void tick() {
        super.tick();

        // 使粒子逐渐消失
        this.alpha = 1.0F - ((float) this.age / (float) this.maxAge);

        if (this.age >= this.maxAge) {
            this.markDead();
        }
    }
    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }
    @Override
    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
        // You can customize how the particle is rendered here
        super.buildGeometry(vertexConsumer, camera, tickDelta);
    }

    public static class CustomParticleFactory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public CustomParticleFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType type, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            CustomParticle particle = new CustomParticle(world, x, y, z, velocityX, velocityY, velocityZ);
            particle.setSprite(this.spriteProvider);
            return particle;
        }
    }
}
