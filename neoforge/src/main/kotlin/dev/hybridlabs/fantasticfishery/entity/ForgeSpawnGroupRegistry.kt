package dev.hybridlabs.fantasticfishery.entity

import dev.hybridlabs.fantasticfishery.utils.FFSpawnGroup
import net.minecraft.world.entity.MobCategory

object ForgeSpawnGroupRegistry {
    fun createFantasticFisherySpawnGroups() {
        // Extend the MobCategory enum with our spawn groups
        for (group in FFSpawnGroup.values()) {
            MobCategory.create(
                group.location.path,
                group.location.toString(),
                group.spawnCap,
                group.peaceful,
                group.rare,
                group.immediateDespawnRange
            )
        }
    }
}