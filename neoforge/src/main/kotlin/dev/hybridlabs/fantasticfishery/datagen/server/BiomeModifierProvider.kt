package dev.hybridlabs.fantasticfishery.datagen.server

import com.google.gson.JsonObject
import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.config.ConfigHelper.initializeConfig
import dev.hybridlabs.fantasticfishery.world.gen.feature.BiomeFeatureAddition
import net.minecraft.data.CachedOutput
import net.minecraft.data.DataProvider
import net.minecraft.data.PackOutput
import net.minecraft.util.random.Weighted
import net.minecraft.util.random.WeightedList
import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.level.biome.MobSpawnSettings
import java.util.concurrent.CompletableFuture

/**
 * Generates the NeoForge biome modifiers directly as JSON.
 *
 * The placed features and biome tags they reference are produced by the Fabric datagen and are not
 * present in the NeoForge datagen registry snapshot, so a registry set builder rejects them.
 */
class BiomeModifierProvider(output: PackOutput) : DataProvider {
    private val pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "neoforge/biome_modifier")

    override fun run(cache: CachedOutput): CompletableFuture<*> {
        val futures = mutableListOf<CompletableFuture<*>>()

        for (addition in BiomeFeatureAddition.builtIn) {
            val location = "${addition.placedFeature.identifier().path}_${addition.biomeTag.location.path}"
            val json = JsonObject().apply {
                addProperty("type", "neoforge:add_features")
                addProperty("biomes", "#${addition.biomeTag.location}")
                addProperty("features", addition.placedFeature.identifier().toString())
                addProperty("step", addition.step.getSerializedName())
            }
            futures += DataProvider.saveStable(cache, json, pathProvider.json(FantasticFisheryCommon.locate(location)))
        }

        val config = initializeConfig(FantasticFisheryCommon.CONFIG_FILE).defaultConfig
        for (spawnConfig in config.entitySpawnConfig) {
            val location = "${spawnConfig.type.toShortString()}_${spawnConfig.biomes.location.path}"
            val spawner = Weighted(
                MobSpawnSettings.SpawnerData(
                    spawnConfig.type,
                    UniformInt.of(spawnConfig.minGroupSize, spawnConfig.maxGroupSize)
                ),
                spawnConfig.weight
            )
            val spawners = WeightedList.codec(MobSpawnSettings.SpawnerData.CODEC)
                .encodeStart(com.mojang.serialization.JsonOps.INSTANCE, WeightedList.of(spawner))
                .getOrThrow()

            val json = JsonObject().apply {
                addProperty("type", "neoforge:add_spawns")
                addProperty("biomes", "#${spawnConfig.biomes.location}")
                add("spawners", spawners)
            }
            futures += DataProvider.saveStable(cache, json, pathProvider.json(FantasticFisheryCommon.locate(location)))
        }

        return CompletableFuture.allOf(*futures.toTypedArray())
    }

    override fun getName(): String = "Biome Modifiers"
}
