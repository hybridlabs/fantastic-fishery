package dev.hybridlabs.fantasticfishery.config

import dev.hybridlabs.aquatic.tag.HABiomeTags
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.platform.Services
import net.minecraft.tags.BiomeTags
import net.minecraft.tags.TagKey
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.Biome

/**
 * Applies biome modifications for entities when initialised.
 */
@Suppress("SameParameterValue")
class EntitySpawnConfigGenerator {
    private val list: MutableList<EntitySpawnConfig> = mutableListOf()

    fun finalizeSpawn() {
        addFish(
            FFEntityTypes.FUNGILL.get(),
            listOf(
                HABiomeTags.TEMPERATE_OCEANS,
                HABiomeTags.LUKEWARM_OCEANS,
                HABiomeTags.WARM_OCEANS),
            10, 1, 3
        )

        addFish(
            FFEntityTypes.PLUNDERERS_HOOP.get(),
            listOf(
                HABiomeTags.ALL_TRENCHES),
            10, 1, 5
        )

        addFish(
            FFEntityTypes.FRIGID_VESSEL.get(),
            listOf(
                HABiomeTags.FROZEN_OCEANS),
            10, 1, 5
        )

        addFish(
            FFEntityTypes.POROUS_SHELL.get(),
            listOf(
                HABiomeTags.SULFURIC_CAVE),
            5, 1, 2
        )

        addFish(
            FFEntityTypes.MORSEL.get(),
            listOf(
                BiomeTags.IS_OCEAN),
            1, 1, 1
        )
    }

    private fun addFish(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        weight: Int,
        minGroup: Int,
        maxGroup: Int,
    ) {
        add(
            entityType,
            spawnTags,
            Services.PLATFORM.getHybridMobCategoryByName("fantastic_fish"),
            weight,
            minGroup,
            maxGroup
        )
    }

    private fun add(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        spawnGroup: MobCategory,
        weight: Int,
        minGroup: Int,
        maxGroup: Int,
    ) {
        spawnTags.forEach { spawnTag ->
            list.add(EntitySpawnConfig(entityType, spawnTag, spawnGroup, weight, minGroup, maxGroup))
        }
    }

    companion object {
        fun generate(): List<EntitySpawnConfig> {
            val generator = EntitySpawnConfigGenerator()
            generator.finalizeSpawn()
            return generator.list
        }
    }
}