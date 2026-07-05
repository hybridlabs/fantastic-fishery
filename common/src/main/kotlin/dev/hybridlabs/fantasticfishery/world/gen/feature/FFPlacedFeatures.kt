package dev.hybridlabs.fantasticfishery.world.gen.feature

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.levelgen.placement.PlacedFeature

object FFPlacedFeatures {

    val RED_SHROOMPADS = register("red_shroompads")
    val BROWN_SHROOMPADS = register("brown_shroompads")

    private fun register(id: String): ResourceKey<PlacedFeature> {
        return ResourceKey.create(Registries.PLACED_FEATURE, FantasticFisheryCommon.locate(id))
    }
}