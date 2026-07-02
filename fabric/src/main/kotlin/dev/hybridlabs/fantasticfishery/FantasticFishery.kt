package dev.hybridlabs.fantasticfishery

import dev.hybridlabs.fantasticfishery.item.FFItems
import dev.hybridlabs.fantasticfishery.item.FFItemGroups
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object FantasticFishery : ModInitializer {
	const val MOD_ID: String = "fantastic_fishery"
	const val MOD_NAME: String = "Fantastic Fishery"

	private val logger: Logger = LoggerFactory.getLogger(MOD_NAME)

	val loader: FabricLoader = FabricLoader.getInstance()

	override fun onInitialize() {
		logger.info("Initializing $MOD_NAME")
        FantasticFisheryCommon.init()

        FFItems
        FFItemGroups
	}
}
