package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFConfiguredFeatures
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider
import java.util.concurrent.CompletableFuture

class ConfiguredFeatureProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<HolderLookup.Provider>,
) : FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun configure(registries: HolderLookup.Provider, entries: Entries) {

        entries.add(
            FFConfiguredFeatures.RED_SHROOMPADS,
            ConfiguredFeature(
                Feature.RANDOM_PATCH, RandomPatchConfiguration(
                    10, 5, 5,
                    PlacementUtils.filtered(
                        Feature.SIMPLE_BLOCK,
                        SimpleBlockConfiguration(
                            SimpleStateProvider.simple(FFBlocks.RED_SHROOMPAD.get())
                        ),
                        BlockPredicate.matchesBlocks(Blocks.WATER)
                    )
                )
            )
        )

        entries.add(
            FFConfiguredFeatures.BROWN_SHROOMPADS,
            ConfiguredFeature(
                Feature.RANDOM_PATCH, RandomPatchConfiguration(
                    10, 5, 5,
                    PlacementUtils.filtered(
                        Feature.SIMPLE_BLOCK,
                        SimpleBlockConfiguration(
                            SimpleStateProvider.simple(FFBlocks.BROWN_SHROOMPAD.get())
                        ),
                        BlockPredicate.matchesBlocks(Blocks.WATER)
                    )
                )
            )
        )
    }

    override fun getName(): String {
        return "Configured Features"
    }
}