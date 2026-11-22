package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.hybridlabs.fantasticfishery.world.gen.biome.FFBiomes
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFPlacedFeatures
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderGetter
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BiomeDefaultFeatures
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.EntityTypes
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.BiomeGenerationSettings
import net.minecraft.world.level.biome.BiomeSpecialEffects
import net.minecraft.world.level.biome.MobSpawnSettings
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraft.world.level.levelgen.carver.WorldCarver
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import java.util.concurrent.CompletableFuture

class BiomeProvider(
    output: FabricPackOutput,
    registriesFuture: CompletableFuture<HolderLookup.Provider>,
) : FabricDynamicRegistryProvider(output, registriesFuture) {
    companion object {
        fun bootstrapBiomes(bootstrap: BootstrapContext<Biome>) {
            val carversGetter = bootstrap.lookup(Registries.CARVER)
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
            carvers: HolderGetter<WorldCarver>,
            temperature: Float,
            downfall: Float,
            waterColor: Int,
            waterFogColor: Int,
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
                    makeSpawnSettings()
                )

                .hasPrecipitation(true)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(
                    createStandardBiomeEffects()
                        .waterColor(waterColor)
                        .build()
                )
                .build()
        }

        fun createFungalBiome(
            features: HolderGetter<PlacedFeature>,
            carvers: HolderGetter<WorldCarver>,
            temperature: Float,
            downfall: Float,
            waterColor: Int,
            waterFogColor: Int,
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
                    makeFungalBiomeSpawnSettings()
                )

                .hasPrecipitation(true)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(
                    createStandardBiomeEffects()
                        .waterColor(waterColor)
                        .build()
                )
                .build()
        }

        fun makeGenerationSettings(
            features: HolderGetter<PlacedFeature>,
            carvers: HolderGetter<WorldCarver>
        ): BiomeGenerationSettings {
            val builder = BiomeGenerationSettings.Builder(features, carvers)
            addStandardFeatures(builder)
            BiomeDefaultFeatures.addDefaultOres(builder)
            BiomeDefaultFeatures.addDefaultSoftDisks(builder)
            return builder.build()
        }

        fun makeSpawnSettings(): MobSpawnSettings {
            val builder = makeDefaultFungalBiomeSpawnSettings()

            return builder.build()
        }

        fun makeFungalBiomeSpawnSettings(): MobSpawnSettings {
            val builder = makeDefaultSpawnSettings()

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
            builder.addSpawn(EntityTypes.BAT, 10, 8, 8)
            builder.addSpawn(EntityTypes.GLOW_SQUID, 5, 2, 5)
        }

        fun addDefaultMonsterSpawns(builder: MobSpawnSettings.Builder) {
            builder.addSpawn(EntityTypes.SPIDER, 100, 4, 4)
            builder.addSpawn(EntityTypes.ZOMBIE, 95, 4, 4)
            builder.addSpawn(EntityTypes.ZOMBIE_VILLAGER, 5, 1, 1)
            builder.addSpawn(EntityTypes.SKELETON, 100, 4, 4)
            builder.addSpawn(EntityTypes.CREEPER, 100, 4, 4)
            builder.addSpawn(EntityTypes.SLIME, 100, 4, 4)
            builder.addSpawn(EntityTypes.ENDERMAN, 10, 1, 4)
            builder.addSpawn(EntityTypes.WITCH, 5, 1, 1)
        }

        fun createStandardBiomeEffects(): BiomeSpecialEffects.Builder {
            return BiomeSpecialEffects.Builder()
                .waterColor(0x3f76e4)
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