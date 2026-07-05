package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFConfiguredFeatures
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFFeatures
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.HolderSet
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider
import net.minecraft.world.level.levelgen.placement.PlacementModifier
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

        entries.add(
            FFConfiguredFeatures.FUNGAL_REEF_VEGETATION,
            ConfiguredFeature(
                Feature.SIMPLE_RANDOM_SELECTOR,
                SimpleRandomFeatureConfiguration(
                    HolderSet.direct(
                        PlacementUtils.inlinePlaced(
                            FFFeatures.REEF_FUNGUS_TREE.get(),
                            FeatureConfiguration.NONE,
                            *arrayOfNulls<PlacementModifier>(0)
                        ),
                        PlacementUtils.inlinePlaced(
                            FFFeatures.REEF_FUNGUS_CLAW.get(),
                            FeatureConfiguration.NONE,
                            *arrayOfNulls<PlacementModifier>(0)
                        ),
                        PlacementUtils.inlinePlaced(
                            FFFeatures.REEF_FUNGUS_MUSHROOM.get(),
                            FeatureConfiguration.NONE,
                            *arrayOfNulls<PlacementModifier>(0)
                        ),
                        PlacementUtils.inlinePlaced(
                            FFFeatures.REEF_FUNGUS_TABLE.get(),
                            FeatureConfiguration.NONE,
                            *arrayOfNulls<PlacementModifier>(0)
                        ),
                        PlacementUtils.inlinePlaced(
                            FFFeatures.REEF_FUNGUS_DISC.get(),
                            FeatureConfiguration.NONE,
                            *arrayOfNulls<PlacementModifier>(0)
                        )
                    )
                )
            )
        )
    }

    override fun getName(): String {
        return "Configured Features"
    }
}