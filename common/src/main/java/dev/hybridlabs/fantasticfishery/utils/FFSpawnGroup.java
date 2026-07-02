package dev.hybridlabs.fantasticfishery.utils;

import dev.hybridlabs.fantasticfishery.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum FFSpawnGroup {
    FANTASTIC_FISHERY_FISH("fantastic_fish", 10, true, false, 128);
    
    public MobCategory spawnGroup;
    public final ResourceLocation location;
    public final int spawnCap;
    public final boolean peaceful;
    public final boolean rare;
    public final int immediateDespawnRange;

    FFSpawnGroup(String id, int spawnCap, boolean peaceful, boolean rare, int immediateDespawnRange) {
        this.location = new ResourceLocation(Constants.MOD_ID, id);
        this.spawnCap = spawnCap;
        this.peaceful = peaceful;
        this.rare = rare;
        this.immediateDespawnRange = immediateDespawnRange;
    }

    public static final Map<String, MobCategory> BY_NAME = new ConcurrentHashMap<>();

    public static MobCategory byName(String id) {
        ResourceLocation location = new ResourceLocation(Constants.MOD_ID, id);
        return BY_NAME.get(location.toString());
    }
}
