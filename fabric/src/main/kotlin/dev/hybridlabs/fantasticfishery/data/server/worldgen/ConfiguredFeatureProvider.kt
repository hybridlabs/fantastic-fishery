package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.world.gen.feature.*
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature
import net.minecraft.world.level.levelgen.feature.SimpleRandomSelectorFeature
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider
import net.minecraft.world.level.levelgen.placement.PlacementModifier
import java.util.concurrent.CompletableFuture

class ConfiguredFeatureProvider(
    output: FabricPackOutput,
    registriesFuture: CompletableFuture<HolderLookup.Provider>,
) : FabricDynamicRegistryProvider(output, registriesFuture) {
    companion object {
        fun bootstrapConfiguredFeatures(bootstrap: BootstrapContext<Feature>) {
            bootstrap.register(
                FFConfiguredFeatures.RED_SHROOMPADS,
                SimpleBlockFeature(SimpleStateProvider(FFBlocks.RED_SHROOMPAD.get().defaultBlockState()))
            )

            bootstrap.register(
                FFConfiguredFeatures.BROWN_SHROOMPADS,
                SimpleBlockFeature(SimpleStateProvider(FFBlocks.BROWN_SHROOMPAD.get().defaultBlockState()))
            )

            bootstrap.register(
                FFConfiguredFeatures.SEASHROOM_PATCH,
                SeashroomFeature()
            )

            bootstrap.register(
                FFConfiguredFeatures.FUNGAL_REEF_VEGETATION,
                SimpleRandomSelectorFeature(
                    HolderSet.direct(
                        PlacementUtils.inlinePlaced(FungalReefTreeFeature(), *emptyArray<PlacementModifier>()),
                        PlacementUtils.inlinePlaced(FungalReefClawFeature(), *emptyArray<PlacementModifier>()),
                        PlacementUtils.inlinePlaced(FungalReefMushroomFeature(), *emptyArray<PlacementModifier>()),
                        PlacementUtils.inlinePlaced(FungalReefTableFeature(), *emptyArray<PlacementModifier>()),
                        PlacementUtils.inlinePlaced(FungalReefDiscFeature(), *emptyArray<PlacementModifier>()),
                    )
                )
            )
        }
    }

    override fun configure(registries: HolderLookup.Provider, entries: Entries) {
        val reg = registries.lookup(Registries.FEATURE).get()

        entries.add(reg.getOrThrow(FFConfiguredFeatures.RED_SHROOMPADS))
        entries.add(reg.getOrThrow(FFConfiguredFeatures.BROWN_SHROOMPADS))
        entries.add(reg.getOrThrow(FFConfiguredFeatures.SEASHROOM_PATCH))
        entries.add(reg.getOrThrow(FFConfiguredFeatures.FUNGAL_REEF_VEGETATION))
    }

    override fun getName(): String {
        return "Features"
    }
}
