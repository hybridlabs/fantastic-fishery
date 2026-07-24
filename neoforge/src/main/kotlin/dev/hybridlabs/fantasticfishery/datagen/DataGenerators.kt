package dev.hybridlabs.fantasticfishery.datagen

import dev.hybridlabs.fantasticfishery.Constants
import dev.hybridlabs.fantasticfishery.datagen.server.BiomeModifierProvider
import dev.hybridlabs.fantasticfishery.utils.NaughtyRegistrySetBuilder
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.registries.ForgeRegistries.Keys.BIOME_MODIFIERS

/**
 * Datagen for Forge specific data resources like biome modifiers.
 *
 * The rest of the generated resources are imported from the output of the Fabric project's runDatagen task.
 */
@Suppress("Unused")
@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
object DataGenerators {

    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val generator = event.generator
        val packOutput = generator.packOutput

        val builder = NaughtyRegistrySetBuilder()
        val lookupProvider = event.lookupProvider

        builder.add(BIOME_MODIFIERS)
        { context ->
            registerBiomeSpawns(context)
            registerFeatures(context)
        }

        generator.addProvider(event.includeServer(), DatapackBuiltinEntriesProvider(packOutput, lookupProvider, builder,
            setOf(Constants.MOD_ID)
        ))
    }

    /**
     * Create Forge biome modifiers to add placed features.
     */
    private fun registerFeatures(
        context: BootstrapContext<BiomeModifier>,
    ) {
        val biomeRegistry = context.lookup(Registries.BIOME)
        val featureRegistry = context.lookup(Registries.PLACED_FEATURE)
        for (addition in BiomeFeatureAddition.builtIn) {

            val location = "${addition.placedFeature.location().path}_${addition.biomeTag.location.path}"
            val key = ResourceKey.create(
                BIOME_MODIFIERS,
                CommonClass.locate(location)
            )
            context.register(
                key, BiomeModifiers.AddFeaturesBiomeModifier(
                    biomeRegistry.getOrThrow(addition.biomeTag),
                    HolderSet.direct(featureRegistry.getOrThrow(addition.placedFeature)),
                    addition.step
                )
            )
        }
    }

    /**
     * Create Forge biome modifiers to add mob spawns based on the config.
     */
    private fun registerBiomeSpawns(
        context: BootstrapContext<BiomeModifier>,
    ) {
        val configHandler = initializeConfig(CommonClass.CONFIG_FILE)
        val biomeRegistry = context.lookup(Registries.BIOME)
        for (spawnConfig in configHandler.defaultConfig.entitySpawnConfig) {

            val location = "${spawnConfig.type.toShortString()}_${spawnConfig.biomes.location.path}"
            val key = ResourceKey.create(
                BIOME_MODIFIERS, CommonClass.locate(location)
            )

            context.register(
                key, BiomeModifiers.AddSpawnsBiomeModifier(
                    biomeRegistry.get(spawnConfig.biomes).get(),
                    listOf(
                        MobSpawnSettings.SpawnerData(
                            spawnConfig.type,
                            spawnConfig.weight,
                            spawnConfig.minGroupSize,
                            spawnConfig.maxGroupSize
                        )
                    )
                )
            )
        }
    }
}
