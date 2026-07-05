package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.hybridlabs.aquatic.world.gen.feature.HAConfiguredFeatures
import dev.hybridlabs.aquatic.world.gen.feature.HAPlacedFeatures
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFConfiguredFeatures
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFPlacedFeatures
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.world.level.levelgen.Heightmap
import net.minecraft.world.level.levelgen.placement.BiomeFilter
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement
import net.minecraft.world.level.levelgen.placement.InSquarePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.RarityFilter
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
                    RarityFilter.onAverageOnceEvery(2),
                    BiomeFilter.biome()
                )
            )
        )

        entries.add(
            FFPlacedFeatures.BROWN_SHROOMPADS, PlacedFeature(
                entries.ref(FFConfiguredFeatures.BROWN_SHROOMPADS), listOf(
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    RarityFilter.onAverageOnceEvery(2),
                    BiomeFilter.biome()
                )
            )
        )


        entries.add(
            FFPlacedFeatures.FUNGAL_REEF_VEGETATION, PlacedFeature(
                entries.ref(FFConfiguredFeatures.FUNGAL_REEF_VEGETATION), listOf(
                    CountOnEveryLayerPlacement.of(10),
                    HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                    BiomeFilter.biome()
                )
            )
        )
    }

    override fun getName(): String {
        return "Placed Features"
    }
}