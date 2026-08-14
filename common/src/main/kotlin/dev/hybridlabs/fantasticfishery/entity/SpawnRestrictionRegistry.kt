package dev.hybridlabs.fantasticfishery.entity

import dev.hybridlabs.hapi.entity.base.aquatic.BaseCrustaceanEntity
import dev.hybridlabs.hapi.entity.base.aquatic.BaseFishEntity
import dev.hybridlabs.hapi.entity.base.aquatic.BaseJellyfishEntity
import dev.hybridlabs.hapi.entity.base.aquatic.BaseWaterAnimal
import net.minecraft.world.entity.*
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

    private fun <T : BaseWaterAnimal> registerFish(entityType: EntityType<T>) {
        registerFish(entityType, BaseFishEntity::canSpawn)
    }

    private fun <T : BaseWaterAnimal> registerDeepFish(entityType: EntityType<T>) {
        registerDeepFish(entityType, BaseFishEntity::canDeepSpawn)
    }

    private fun <T : BaseJellyfishEntity> registerJellyfish(entityType: EntityType<T>) {
        registerDeepFish(entityType, BaseJellyfishEntity::canSpawn)
    }

    private fun <T : BaseWaterAnimal> registerAquaticCrustacean(entityType: EntityType<T>) {
        registerCrustacean(entityType, BaseCrustaceanEntity::canSpawnInWater)
    }

    private fun <T : WaterAnimal> registerWaterCreature(
        entityType: EntityType<T>,
        predicate: SpawnPlacements.SpawnPredicate<T>,
    ) {
        register(
            entityType,
            SpawnPlacementTypes.IN_WATER,
            predicate
        )
    }

    private fun <T : BaseWaterAnimal> registerFish(
        entityType: EntityType<T>,
        predicate: SpawnPlacements.SpawnPredicate<T>,
    ) {
        register(
            entityType,
            SpawnPlacementTypes.IN_WATER,
            predicate
        )
    }

    private fun <T : BaseWaterAnimal> registerDeepFish(
        entityType: EntityType<T>,
        predicate: SpawnPlacements.SpawnPredicate<T>,
    ) {
        register(
            entityType,
            SpawnPlacementTypes.IN_WATER,
            predicate
        )
    }

    private fun <T : BaseWaterAnimal> registerCrustacean(
        entityType: EntityType<T>,
        predicate: SpawnPlacements.SpawnPredicate<T>,
    ) {
        register(
            entityType,
            SpawnPlacementTypes.NO_RESTRICTIONS,
            predicate
        )
    }

    private fun <T : Mob> register(
        entityType: EntityType<T>,
        location: SpawnPlacementType,
        predicate: SpawnPlacements.SpawnPredicate<T>,
    ) {
        SpawnPlacements.register(entityType, location, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, predicate)
    }
}
