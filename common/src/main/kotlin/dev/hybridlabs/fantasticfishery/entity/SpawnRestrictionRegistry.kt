package dev.hybridlabs.fantasticfishery.entity

import dev.hybridlabs.aquatic.entity.base.HACrustaceanEntity
import dev.hybridlabs.aquatic.entity.base.HAFishEntity
import dev.hybridlabs.aquatic.entity.base.HAJellyfishEntity
import dev.hybridlabs.aquatic.entity.base.HAWaterAnimal
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.Mob
import net.minecraft.world.entity.SpawnPlacements
import net.minecraft.world.entity.animal.WaterAnimal
import net.minecraft.world.level.levelgen.Heightmap

/**
 * Registers spawn restrictions for all entities when initialised.
 */
object SpawnRestrictionRegistry {
    fun registerSpawnRestrictions() {
        setOf(
            FFEntityTypes.FUNGILL.get(),
            FFEntityTypes.MORSEL.get(),
            FFEntityTypes.FRIGID_VESSEL.get(),
            FFEntityTypes.PUFFBALL_PUFFER.get(),
        ).forEach { registerFish(it) }

        setOf(
            FFEntityTypes.PLUNDERERS_HOOP.get(),
            FFEntityTypes.BLOOD_EEL.get(),
            FFEntityTypes.POROUS_SHELL.get(),
        ).forEach { registerDeepFish(it) }

        setOf(
            FFEntityTypes.JELLYSHROOM.get(),
        ).forEach { registerJellyfish(it) }

        setOf(
            FFEntityTypes.MYCRAB.get(),
        ).forEach { registerAquaticCrustacean(it) }
    }

    private fun <T : HAWaterAnimal> registerFish(entityType: EntityType<T>) {
        registerFish(entityType, HAFishEntity::canSpawn)
    }

    private fun <T : HAWaterAnimal> registerDeepFish(entityType: EntityType<T>) {
        registerDeepFish(entityType, HAFishEntity::canDeepSpawn)
    }

    private fun <T : HAJellyfishEntity> registerJellyfish(entityType: EntityType<T>) {
        registerDeepFish(entityType, HAJellyfishEntity::canSpawn)
    }

    private fun <T : HAWaterAnimal> registerAquaticCrustacean(entityType: EntityType<T>) {
        registerCrustacean(entityType, HACrustaceanEntity::canSpawnInWater)
    }

    private fun <T : WaterAnimal> registerWaterCreature(
        entityType: EntityType<T>,
        predicate: SpawnPlacements.SpawnPredicate<T>,
    ) {
        register(
            entityType,
            SpawnPlacements.Type.IN_WATER,
            predicate
        )
    }

    private fun <T : HAWaterAnimal> registerFish(
        entityType: EntityType<T>,
        predicate: SpawnPlacements.SpawnPredicate<T>,
    ) {
        register(
            entityType,
            SpawnPlacements.Type.IN_WATER,
            predicate
        )
    }

    private fun <T : HAWaterAnimal> registerDeepFish(
        entityType: EntityType<T>,
        predicate: SpawnPlacements.SpawnPredicate<T>,
    ) {
        register(
            entityType,
            SpawnPlacements.Type.IN_WATER,
            predicate
        )
    }

    private fun <T : HAWaterAnimal> registerCrustacean(
        entityType: EntityType<T>,
        predicate: SpawnPlacements.SpawnPredicate<T>,
    ) {
        register(
            entityType,
            SpawnPlacements.Type.NO_RESTRICTIONS,
            predicate
        )
    }

    private fun <T : Mob> register(
        entityType: EntityType<T>,
        location: SpawnPlacements.Type,
        predicate: SpawnPlacements.SpawnPredicate<T>,
    ) {
        SpawnPlacements.register(entityType, location, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, predicate)
    }
}
