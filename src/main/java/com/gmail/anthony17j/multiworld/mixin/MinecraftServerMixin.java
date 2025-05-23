package com.gmail.anthony17j.multiworld.mixin;

import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.level.ServerWorldProperties;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;

@Mixin(MinecraftServer.class)
public interface MinecraftServerMixin {
    @Accessor
    Map<RegistryKey<World>, ServerWorld> getWorlds();

    @Accessor
    LevelStorage.Session getSession();

    @Invoker("setupSpawn")
    static void invokeSetupSpawn(ServerWorld world, ServerWorldProperties worldProperties, boolean bonusChest, boolean debugWorld) {
        throw new AssertionError();
    }
}
