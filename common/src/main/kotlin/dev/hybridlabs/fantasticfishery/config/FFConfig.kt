package dev.hybridlabs.fantasticfishery.config

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder

data class FFConfig(
    /**
     * The version of the data stored.
     * Increase when the config needs to be reset, i.e. when new entity spawn configs are added.
     */
    val dataVersion: Int = 1,
    val entitySpawnConfig: List<EntitySpawnConfig> = EntitySpawnConfigGenerator.generate(),
) {
    companion object {
        val CODEC: Codec<FFConfig> = RecordCodecBuilder.create { instance ->
            instance.group(
                Codec.INT.fieldOf("data_version").forGetter(FFConfig::dataVersion),
                EntitySpawnConfig.CODEC.listOf().fieldOf("spawn_configuration").forGetter(FFConfig::entitySpawnConfig),
            ).apply(instance, ::FFConfig)
        }
    }
}