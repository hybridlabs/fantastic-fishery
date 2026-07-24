package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.hybridlabs.fantasticfishery.world.gen.feature.FFConfiguredFeatures
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFPlacedFeatures
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.world.level.levelgen.placement.*
import java.util.concurrent.CompletableFuture

class PlacedFeatureProvider(
    output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>,
) : FabricDynamicRegistryProvider(output, registriesFuture) {

    companion object {

        fun seaweedModifier(count: Int): List<PlacementModifier> {
            return listOf(
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                CountPlacement.of(count),
                BiomeFilter.biome()
            )
        }

        fun bootstrapPlacedFeatures(bootstrap: BootstrapContext<PlacedFeature>) {
            val reg = bootstrap.lookup(Registries.CONFIGURED_FEATURE)

            PlacementUtils.register(
                bootstrap,
                FFPlacedFeatures.RED_SHROOMPADS,
                reg.get(FFConfiguredFeatures.RED_SHROOMPADS).get(), listOf(
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    RarityFilter.onAverageOnceEvery(1),
                    BiomeFilter.biome()
                )
            )

            PlacementUtils.register(
                bootstrap,
                FFPlacedFeatures.BROWN_SHROOMPADS,
                reg.get(FFConfiguredFeatures.BROWN_SHROOMPADS).get(), listOf(
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    RarityFilter.onAverageOnceEvery(1),
                    BiomeFilter.biome()
                )
            )

            PlacementUtils.register(
                bootstrap,
                FFPlacedFeatures.SEASHROOM_PATCH,
                reg.get(FFConfiguredFeatures.SEASHROOM_PATCH).get(),
                seaweedModifier(80)
            )


            PlacementUtils.register(
                bootstrap,
                FFPlacedFeatures.FUNGAL_REEF_VEGETATION,
                reg.get(FFConfiguredFeatures.FUNGAL_REEF_VEGETATION).get(), listOf(
                    NoiseBasedCountPlacement.of(20, 400.0, 0.0),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_TOP_SOLID,
                    BiomeFilter.biome()
                )
            )
        }
    }

    override fun configure(registries: HolderLookup.Provider, entries: Entries) {
        val reg = registries.lookup(Registries.PLACED_FEATURE).get()

        entries.add(reg.getOrThrow(FFPlacedFeatures.RED_SHROOMPADS))
        entries.add(reg.getOrThrow(FFPlacedFeatures.BROWN_SHROOMPADS))
        entries.add(reg.getOrThrow(FFPlacedFeatures.SEASHROOM_PATCH))
        entries.add(reg.getOrThrow(FFPlacedFeatures.FUNGAL_REEF_VEGETATION))
    }

    override fun getName(): String {
        return "Placed Features"
    }
}