package com.gmail.anthony17j.multiworld;

import net.minecraft.server.WorldGenerationProgressListener;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.ChunkStatus;
import org.jetbrains.annotations.Nullable;

public class VoidWorldProgressListener implements WorldGenerationProgressListener {
    public static final VoidWorldProgressListener INSTANCE = new VoidWorldProgressListener();

    private VoidWorldProgressListener() {
    }

    @Override
    public void start(ChunkPos spawnPos) {
    }

    @Override
    public void setChunkStatus(ChunkPos pos, @Nullable ChunkStatus status) {
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }
}
