package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.hybridlabs.aquatic.world.gen.feature.HAPlacedFeatures
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.platform.Services
import dev.hybridlabs.fantasticfishery.world.gen.biome.FFBiomes
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFPlacedFeatures
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.worldgen.BiomeDefaultFeatures
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.BiomeGenerationSettings
import net.minecraft.world.level.biome.BiomeSpecialEffects
import net.minecraft.world.level.biome.MobSpawnSettings
import net.minecraft.world.level.levelgen.GenerationStep
import java.util.concurrent.CompletableFuture

class BiomeProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<HolderLookup.Provider>,
) : FabricDynamicRegistryProvider(output, registriesFuture) {

    fun create(
        entries: Entries,
        temperature: Float,
        downfall: Float,
        waterColor: Int,
        waterFogColor: Int,
        extraSpawns: List<Pair<MobCategory, MobSpawnSettings.SpawnerData>> = ArrayList(),
        extraSpawnCosts: List<Triple<EntityType<*>, Double, Double>> = emptyList(),
        includeMonsters: Boolean = true,
        extraFeatures: (BiomeGenerationSettings.Builder.() -> Unit)? = null,
    ): Biome {
        val builder = BiomeGenerationSettings.Builder(
            entries.placedFeatures(),
            entries.configuredCarvers()
        )

        addStandardFeatures(builder)
        BiomeDefaultFeatures.addDefaultOres(builder)
        BiomeDefaultFeatures.addDefaultSoftDisks(builder)

        extraFeatures?.invoke(builder)

        return Biome.BiomeBuilder()
            .generationSettings(makeGenerationSettings(entries))
            .generationSettings(builder.build())
            .mobSpawnSettings(
                makeSpawnSettings(
                    extraSpawns,
                    extraSpawnCosts,
                    includeMonsters
                )
            )

            .hasPrecipitation(true)
            .temperature(temperature)
            .downfall(downfall)
            .specialEffects(
                createStandardBiomeEffects()
                    .waterColor(waterColor)
                    .waterFogColor(waterFogColor)
                    .build()
            )
            .build()
    }

    fun makeGenerationSettings(entries: Entries): BiomeGenerationSettings {
        val builder = BiomeGenerationSettings.Builder(entries.placedFeatures(), entries.configuredCarvers())
        addStandardFeatures(builder)
        BiomeDefaultFeatures.addDefaultOres(builder)
        BiomeDefaultFeatures.addDefaultSoftDisks(builder)
        return builder.build()
    }

    fun makeSpawnSettings(
        extraSpawns: List<Pair<MobCategory, MobSpawnSettings.SpawnerData>>,
        extraSpawnCosts: List<Triple<EntityType<*>, Double, Double>>,
        includeMonsters: Boolean
    ): MobSpawnSettings {
        val builder = MobSpawnSettings.Builder()

        addDefaultAmbientSpawns(builder)

        if (includeMonsters) {
            addDefaultMonsterSpawns(builder)
        }

        for ((category, spawner) in extraSpawns) {
            builder.addSpawn(category, spawner)
        }

        for ((entity, charge, budget) in extraSpawnCosts) {
            builder.addMobCharge(entity, charge, budget)
        }

        return builder.build()
    }

    fun makeDefaultSpawnSettings(): MobSpawnSettings.Builder {
        val spawnSettings = MobSpawnSettings.Builder()
        addDefaultAmbientSpawns(spawnSettings)
        addDefaultMonsterSpawns(spawnSettings)
        return spawnSettings
    }

    fun addStandardFeatures(builder: BiomeGenerationSettings.Builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder)
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder)
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder)
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder)
        BiomeDefaultFeatures.addDefaultSprings(builder)
        BiomeDefaultFeatures.addSurfaceFreezing(builder)
    }

    fun addDefaultAmbientSpawns(builder: MobSpawnSettings.Builder) {
        builder.addSpawn(MobCategory.AMBIENT, MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8))
        builder.addSpawn(
            MobCategory.UNDERGROUND_WATER_CREATURE,
            MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 5, 2, 5)
        )
    }

    fun addDefaultMonsterSpawns(builder: MobSpawnSettings.Builder) {
        builder.addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4))
        builder.addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4))
        builder.addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
        builder.addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4))
        builder.addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4))
        builder.addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4))
        builder.addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4))
        builder.addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1))
    }

    fun createStandardBiomeEffects(): BiomeSpecialEffects.Builder {
        return BiomeSpecialEffects.Builder()
            .waterColor(0x3f76e4)
            .waterFogColor(0x50533)
            .fogColor(0xC0D8FF)
            .skyColor(0x78A7FF)
    }

    override fun configure(
        registries: HolderLookup.Provider,
        entries: Entries,
    ) {
        entries.add(
            FFBiomes.FUNGAL_REEF,
            create(
                entries,
                temperature = 0.5f,
                downfall = 0.5f,
                waterColor = 0x7f6891,
                waterFogColor = 0x7f6891,
                listOf(
                    Pair(
                        Services.PLATFORM.getHybridMobCategoryByName("fantastic_fish"),
                        MobSpawnSettings.SpawnerData(FFEntityTypes.FUNGILL.get(), 3, 3, 6)
                    )
                ),
                includeMonsters = false
            ) {
                addFeature(
                    GenerationStep.Decoration.VEGETAL_DECORATION,
                    entries.ref(FFPlacedFeatures.FUNGAL_REEF_VEGETATION)
                )
            }
        )
    }

    override fun getName(): String {
        return "Biomes"
    }
}