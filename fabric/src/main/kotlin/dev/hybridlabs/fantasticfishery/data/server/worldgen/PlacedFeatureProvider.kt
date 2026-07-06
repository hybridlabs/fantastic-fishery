package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.hybridlabs.fantasticfishery.world.gen.feature.FFConfiguredFeatures
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFPlacedFeatures
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.world.level.levelgen.placement.*
import java.util.concurrent.CompletableFuture

class PlacedFeatureProvider(
    output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>,
) : FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun configure(registries: HolderLookup.Provider, entries: Entries) {

        entries.add(
            FFPlacedFeatures.RED_SHROOMPADS, PlacedFeature(
                entries.ref(FFConfiguredFeatures.RED_SHROOMPADS), listOf(
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    RarityFilter.onAverageOnceEvery(1),
                    BiomeFilter.biome()
                )
            )
        )

        entries.add(
            FFPlacedFeatures.BROWN_SHROOMPADS, PlacedFeature(
                entries.ref(FFConfiguredFeatures.BROWN_SHROOMPADS), listOf(
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    RarityFilter.onAverageOnceEvery(1),
                    BiomeFilter.biome()
                )
            )
        )


        entries.add(
            FFPlacedFeatures.FUNGAL_REEF_VEGETATION, PlacedFeature(
                entries.ref(FFConfiguredFeatures.FUNGAL_REEF_VEGETATION), listOf(
                    NoiseBasedCountPlacement.of(20, 400.0, 0.0),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_TOP_SOLID,
                    BiomeFilter.biome()
                )
            )
        )
    }

    override fun getName(): String {
        return "Placed Features"
    }
}