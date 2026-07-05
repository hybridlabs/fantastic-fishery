package dev.hybridlabs.fantasticfishery.world.gen.feature

import dev.hybridlabs.aquatic.world.gen.feature.HAPlacedFeatures
import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.levelgen.placement.PlacedFeature

object FFPlacedFeatures {

    val RED_SHROOMPADS = register("red_shroompads")
    val BROWN_SHROOMPADS = register("brown_shroompads")

    val FUNGAL_REEF_VEGETATION = register("fungal_reef_vegetation")

    private fun register(id: String): ResourceKey<PlacedFeature> {
        return ResourceKey.create(Registries.PLACED_FEATURE, FantasticFisheryCommon.locate(id))
    }
}