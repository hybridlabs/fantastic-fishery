package dev.hybridlabs.fantasticfishery

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.config.ConfigHelper
import dev.hybridlabs.fantasticfishery.config.FFConfig
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.entity.SpawnRestrictionRegistry
import dev.hybridlabs.fantasticfishery.item.FFItemGroups
import dev.hybridlabs.fantasticfishery.item.FFItems
import dev.hybridlabs.fantasticfishery.tag.FFBiomeTags
import dev.hybridlabs.fantasticfishery.tag.FFItemTags
import dev.hybridlabs.fantasticfishery.world.gen.biome.FFBiomes
import dev.hybridlabs.fantasticfishery.world.gen.feature.FeatureBiomeModifications
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors

object FantasticFishery : ModInitializer {

    private val logger = Constants.LOGGER

    @Suppress("UnusedExpression")
	override fun onInitialize() {
        val configHandler = ConfigHelper.initializeConfig(FantasticFisheryCommon.CONFIG_FILE)
        logger.info("Initializing ${Constants.MOD_NAME}")
        FantasticFisheryCommon.init()

        FFBlocks
        FFEntityTypes
        FFBiomes.addBiomes()
        FFItems
        FFItemGroups
        FFItemTags
        FFBiomeTags

        FeatureBiomeModifications.registerBiomeModifications()
        SpawnRestrictionRegistry.registerSpawnRestrictions()

        registerBiomeModifications(configHandler.config)
	}

    private fun registerBiomeModifications(config: FFConfig) {
        config.entitySpawnConfig.forEach { config ->
            BiomeModifications.addSpawn(
                BiomeSelectors.tag(config.biomes),
                config.group,
                config.type,
                config.weight,
                config.minGroupSize,
                config.maxGroupSize
            )
        }
    }
}
