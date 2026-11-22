package dev.hybridlabs.fantasticfishery.forge

import dev.hybridlabs.fantasticfishery.Constants
import dev.hybridlabs.fantasticfishery.client.render.block.FFBlockRenderers
import dev.hybridlabs.fantasticfishery.client.render.entity.FFEntityRenderers
import dev.hybridlabs.fantasticfishery.entity.SpawnRestrictionRegistry
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import net.neoforged.neoforge.client.event.EntityRenderersEvent
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runForDist

object FantasticFisheryModBusEvents {
    init {
        MOD_BUS.addListener(::registerSpawnPlacements)

        runForDist(
            clientTarget = {
                MOD_BUS.addListener(::registerBlockEntityRenderers)
                FFEntityRenderers
            },
            serverTarget = {
                MOD_BUS.addListener(::onServerSetup)
            })
    }

    private fun registerSpawnPlacements(event: RegisterSpawnPlacementsEvent) {
        SpawnRestrictionRegistry.registerSpawnRestrictions()
    }

    private fun registerBlockEntityRenderers(event: EntityRenderersEvent.RegisterRenderers) {
        FFBlockRenderers.registerRenderShapes()
    }

    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        Constants.LOGGER.info("Server starting...")
    }
}