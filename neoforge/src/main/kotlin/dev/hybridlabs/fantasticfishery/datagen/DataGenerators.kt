package dev.hybridlabs.fantasticfishery.datagen

import dev.hybridlabs.fantasticfishery.Constants
import dev.hybridlabs.fantasticfishery.datagen.server.BiomeModifierProvider
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.data.event.GatherDataEvent

/**
 * Datagen for NeoForge specific data resources like biome modifiers.
 *
 * The rest of the generated resources are imported from the output of the Fabric project's runDatagen task.
 */
@Suppress("Unused")
@EventBusSubscriber(modid = Constants.MOD_ID)
object DataGenerators {

    @SubscribeEvent
    fun gatherData(event: GatherDataEvent.Server) {
        event.addProvider(BiomeModifierProvider(event.generator.packOutput))
    }
}
