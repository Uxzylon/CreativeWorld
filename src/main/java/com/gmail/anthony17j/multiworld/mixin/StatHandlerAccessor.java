package com.gmail.anthony17j.multiworld.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.stat.Stat;
import net.minecraft.stat.StatHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(StatHandler.class)
public interface StatHandlerAccessor {
    @Accessor
    Object2IntMap<Stat<?>> getStatMap();
}
