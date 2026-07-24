package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFConfiguredFeatures
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFFeatures
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.data.worldgen.features.FeatureUtils
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration
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
    companion object {
        fun bootstrapConfiguredFeatures(bootstrap: BootstrapContext<ConfiguredFeature<*, *>>) {

            FeatureUtils.register(
                bootstrap,
                FFConfiguredFeatures.RED_SHROOMPADS,
                Feature.RANDOM_PATCH,
                RandomPatchConfiguration(
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

            FeatureUtils.register(
                bootstrap,
                FFConfiguredFeatures.BROWN_SHROOMPADS,
                Feature.RANDOM_PATCH,
                RandomPatchConfiguration(
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

            FeatureUtils.register(
                bootstrap,
                FFConfiguredFeatures.SEASHROOM_PATCH,
                FFFeatures.SEASHROOM_PATCH.get(),
                ProbabilityFeatureConfiguration(
                    0.33f
                )
            )

            FeatureUtils.register(
                bootstrap,
                FFConfiguredFeatures.FUNGAL_REEF_VEGETATION,
                Feature.SIMPLE_RANDOM_SELECTOR,
                SimpleRandomFeatureConfiguration(
                    HolderSet.direct(
                        PlacementUtils.inlinePlaced(
                            FFFeatures.FUNGAL_REEF_CORAL_TREE.get(),
                            FeatureConfiguration.NONE,
                            *arrayOfNulls<PlacementModifier>(0)
                        ),
                        PlacementUtils.inlinePlaced(
                            FFFeatures.FUNGAL_REEF_CORAL_CLAW.get(),
                            FeatureConfiguration.NONE,
                            *arrayOfNulls<PlacementModifier>(0)
                        ),
                        PlacementUtils.inlinePlaced(
                            FFFeatures.FUNGAL_REEF_CORAL_MUSHROOM.get(),
                            FeatureConfiguration.NONE,
                            *arrayOfNulls<PlacementModifier>(0)
                        ),
                        PlacementUtils.inlinePlaced(
                            FFFeatures.FUNGAL_REEF_CORAL_TABLE.get(),
                            FeatureConfiguration.NONE,
                            *arrayOfNulls<PlacementModifier>(0)
                        ),
                        PlacementUtils.inlinePlaced(
                            FFFeatures.FUNGAL_REEF_CORAL_DISC.get(),
                            FeatureConfiguration.NONE,
                            *arrayOfNulls<PlacementModifier>(0)
                        )
                    )
                )
            )
        }
    }

    override fun configure(registries: HolderLookup.Provider, entries: Entries) {
        val reg = registries.lookup(Registries.CONFIGURED_FEATURE).get()

        entries.add(reg.getOrThrow(FFConfiguredFeatures.RED_SHROOMPADS))
        entries.add(reg.getOrThrow(FFConfiguredFeatures.BROWN_SHROOMPADS))
        entries.add(reg.getOrThrow(FFConfiguredFeatures.SEASHROOM_PATCH))
        entries.add(reg.getOrThrow(FFConfiguredFeatures.FUNGAL_REEF_VEGETATION))
    }

    override fun getName(): String {
        return "Configured Features"
    }
}