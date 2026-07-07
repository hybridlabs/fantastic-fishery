package dev.hybridlabs.fantasticfishery.world.gen.feature

import dev.hybridlabs.aquatic.world.gen.feature.BiomeFeatureAddition
import dev.hybridlabs.fantasticfishery.tag.FFBiomeTags
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.TagKey
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraft.world.level.levelgen.placement.PlacedFeature

data class BiomeFeatureAddition(
    val biomeTag: TagKey<Biome>, val step: GenerationStep.Decoration, val placedFeature: ResourceKey<PlacedFeature>,
) {
    companion object {
        val builtIn = buildList {
            //#region Shroompads
            add(
                BiomeFeatureAddition(
                    FFBiomeTags.MUSHROOM_SHORES,
                    GenerationStep.Decoration.VEGETAL_DECORATION,
                    FFPlacedFeatures.RED_SHROOMPADS
                ),
            )
            add(
                BiomeFeatureAddition(
                    FFBiomeTags.MUSHROOM_SHORES,
                    GenerationStep.Decoration.VEGETAL_DECORATION,
                    FFPlacedFeatures.BROWN_SHROOMPADS
                )
            )

            add(
                BiomeFeatureAddition(
                    FFBiomeTags.FUNGAL_SEA,
                    GenerationStep.Decoration.VEGETAL_DECORATION,
                    FFPlacedFeatures.SEASHROOM_PATCH
                ),
            )
        }
    }
}