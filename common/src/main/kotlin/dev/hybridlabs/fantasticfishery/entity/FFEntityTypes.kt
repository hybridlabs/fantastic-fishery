package dev.hybridlabs.fantasticfishery.entity

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.entity.fish.FungillEntity
import dev.hybridlabs.fantasticfishery.platform.Services
import dev.hybridlabs.fantasticfishery.platform.registration.RegistryObject
import net.minecraft.world.entity.EntityDimensions
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.entity.ai.attributes.AttributeSupplier
import java.util.concurrent.Callable

@Suppress("SameParameterValue")
object FFEntityTypes {

    //#region Fish
    val FUNGILL = registerFish(
        "fungill",
        ::FungillEntity,
        EntityDimensions.fixed(0.6f, 0.5f),
        FungillEntity::createMobAttributes
    )
    //#endregion

    //#region Registration Functions
    //#region Fish Registration
    private fun <T : LivingEntity> registerFish(
        id: String,
        entityFactory: EntityType.EntityFactory<T>,
        dimensions: EntityDimensions,
        attributeContainer: Callable<AttributeSupplier.Builder>,
        trackingRange: Int = 6,
    ): RegistryObject<EntityType<T>> {
        return registerCustomSpawnGroup(
            id,
            entityFactory,
            dimensions,
            attributeContainer,
            Services.PLATFORM.getHybridMobCategoryByName("fantastic_fish"),
            trackingRange,
        )
    }
    //#endregion

    /**
     * Registers a living entity to the entity type registry with a Hybrid Aquatic spawn group.
     */
    private fun <T : LivingEntity> registerCustomSpawnGroup(
        id: String,
        entityFactory: EntityType.EntityFactory<T>,
        dimensions: EntityDimensions,
        attributeContainer: Callable<AttributeSupplier.Builder>,
        hybridAquaticSpawnGroup: MobCategory,
        trackingRange: Int = 5,
        updateInterval: Int = 3,
        canSpawnFarFromPlayer: Boolean = false,
    ): RegistryObject<EntityType<T>> {
        return registerLiving(
            id,
            entityFactory,
            dimensions,
            attributeContainer,
            hybridAquaticSpawnGroup,
            trackingRange,
            updateInterval,
            canSpawnFarFromPlayer
        )
    }

    /**
     * Registers a living entity to the entity type registry.
     */
    private fun <T : LivingEntity> registerLiving(
        id: String,
        entityFactory: EntityType.EntityFactory<T>,
        dimensions: EntityDimensions,
        attributeContainer: Callable<AttributeSupplier.Builder>,
        spawnGroup: MobCategory,
        clientTrackingRange: Int = 5,
        updateInterval: Int = 3,
        canSpawnFarFromPlayer: Boolean = false,
    ): RegistryObject<EntityType<T>> {
        val entityType = EntityType.Builder
            .of(entityFactory, spawnGroup)
            .sized(dimensions.width, dimensions.height)
            .clientTrackingRange(clientTrackingRange)
            .updateInterval(updateInterval)

        if (canSpawnFarFromPlayer) {
            entityType.canSpawnFarFromPlayer()
        }

        return register(id, entityType, attributeContainer)
    }

    private fun <T : LivingEntity> register(
        id: String,
        entity: EntityType.Builder<T>,
        attributeContainer: Callable<AttributeSupplier.Builder>,
    ): RegistryObject<EntityType<T>> {
        return FantasticFisheryCommon.ENTITY_TYPES.register(id) {
            val entityType = entity.build(id)
            Services.PLATFORM.registerAttributes(id, entityType, attributeContainer)
            entityType
        }
    }
}
