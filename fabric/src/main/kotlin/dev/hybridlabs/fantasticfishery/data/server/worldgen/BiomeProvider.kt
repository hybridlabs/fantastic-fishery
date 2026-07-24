package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.hybridlabs.fantasticfishery.world.gen.biome.FFBiomes
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFPlacedFeatures
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderGetter
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BiomeDefaultFeatures
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.BiomeGenerationSettings
import net.minecraft.world.level.biome.BiomeSpecialEffects
import net.minecraft.world.level.biome.MobSpawnSettings
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import java.util.concurrent.CompletableFuture

class BiomeProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<HolderLookup.Provider>,
) : FabricDynamicRegistryProvider(output, registriesFuture) {
    companion object {
        fun bootstrapBiomes(bootstrap: BootstrapContext<Biome>) {
            val carversGetter = bootstrap.lookup(Registries.CONFIGURED_CARVER)
            val featuresGetter = bootstrap.lookup(Registries.PLACED_FEATURE)

            bootstrap.register(
                FFBiomes.FUNGAL_SEA,
                createFungalBiome(
                    featuresGetter, carversGetter,
                    temperature = 0.5f,
                    downfall = 0.5f,
                    waterColor = 0x3F76E4,
                    waterFogColor = 0x3F76E4
                ) {
                    addFeature(
                        GenerationStep.Decoration.VEGETAL_DECORATION,
                        featuresGetter.get(FFPlacedFeatures.FUNGAL_REEF_VEGETATION).get()
                    )
                }
            )

            bootstrap.register(
                FFBiomes.MUSHROOM_FIELDS_SHORE,
                createFungalBiome(
                    featuresGetter, carversGetter,
                    temperature = 0.5f,
                    downfall = 0.5f,
                    waterColor = 0x3F76E4,
                    waterFogColor = 0x3F76E4
                )
            )
        }

        fun create(
            features: HolderGetter<PlacedFeature>,
            carvers: HolderGetter<ConfiguredWorldCarver<*>>,
            temperature: Float,
            downfall: Float,
            waterColor: Int,
            waterFogColor: Int,
            extraSpawns: List<Pair<MobCategory, MobSpawnSettings.SpawnerData>> = ArrayList(),
            extraSpawnCosts: List<Triple<EntityType<*>, Double, Double>> = emptyList(),
            extraFeatures: (BiomeGenerationSettings.Builder.() -> Unit)? = null,
        ): Biome {
            val builder = BiomeGenerationSettings.Builder(features, carvers)

            addStandardFeatures(builder)
            BiomeDefaultFeatures.addDefaultOres(builder)
            BiomeDefaultFeatures.addDefaultSoftDisks(builder)

            extraFeatures?.invoke(builder)

            return Biome.BiomeBuilder()
                .generationSettings(makeGenerationSettings(features, carvers))
                .generationSettings(builder.build()).mobSpawnSettings(
                    makeSpawnSettings(extraSpawns, extraSpawnCosts)
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

        fun createFungalBiome(
            features: HolderGetter<PlacedFeature>,
            carvers: HolderGetter<ConfiguredWorldCarver<*>>,
            temperature: Float,
            downfall: Float,
            waterColor: Int,
            waterFogColor: Int,
            extraSpawns: List<Pair<MobCategory, MobSpawnSettings.SpawnerData>> = ArrayList(),
            extraSpawnCosts: List<Triple<EntityType<*>, Double, Double>> = emptyList(),
            extraFeatures: (BiomeGenerationSettings.Builder.() -> Unit)? = null,
        ): Biome {
            val builder = BiomeGenerationSettings.Builder(features, carvers)

            addStandardFeatures(builder)
            BiomeDefaultFeatures.addDefaultOres(builder)
            BiomeDefaultFeatures.addDefaultSoftDisks(builder)

            extraFeatures?.invoke(builder)

            return Biome.BiomeBuilder()
                .generationSettings(makeGenerationSettings(features, carvers))
                .generationSettings(builder.build()).mobSpawnSettings(
                    makeFungalBiomeSpawnSettings(extraSpawns, extraSpawnCosts)
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

        fun makeGenerationSettings(
            features: HolderGetter<PlacedFeature>,
            carvers: HolderGetter<ConfiguredWorldCarver<*>>
        ): BiomeGenerationSettings {
            val builder = BiomeGenerationSettings.Builder(features, carvers)
            addStandardFeatures(builder)
            BiomeDefaultFeatures.addDefaultOres(builder)
            BiomeDefaultFeatures.addDefaultSoftDisks(builder)
            return builder.build()
        }

        fun makeSpawnSettings(
            extraSpawns: List<Pair<MobCategory, MobSpawnSettings.SpawnerData>>,
            extraSpawnCosts: List<Triple<EntityType<*>, Double, Double>>
        ): MobSpawnSettings {
            val builder = makeDefaultFungalBiomeSpawnSettings()

            for ((category, spawner) in extraSpawns) {
                builder.addSpawn(category, spawner)
            }

            for ((entity, charge, budget) in extraSpawnCosts) {
                builder.addMobCharge(entity, charge, budget)
            }

            return builder.build()
        }

        fun makeFungalBiomeSpawnSettings(
            extraSpawns: List<Pair<MobCategory, MobSpawnSettings.SpawnerData>>,
            extraSpawnCosts: List<Triple<EntityType<*>, Double, Double>>
        ): MobSpawnSettings {
            val builder = makeDefaultSpawnSettings()

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

        fun makeDefaultFungalBiomeSpawnSettings(): MobSpawnSettings.Builder {
            val spawnSettings = MobSpawnSettings.Builder()
            addDefaultAmbientSpawns(spawnSettings)
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
    }

    override fun configure(
        registries: HolderLookup.Provider,
        entries: Entries,
    ) {
        val reg = registries.lookup(Registries.BIOME).get()
        entries.add(reg.getOrThrow(FFBiomes.FUNGAL_SEA))
        entries.add(reg.getOrThrow(FFBiomes.MUSHROOM_FIELDS_SHORE))
    }

    override fun getName(): String {
        return "Biomes"
    }
}