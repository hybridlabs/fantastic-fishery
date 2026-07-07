package dev.hybridlabs.fantasticfishery.world.gen.feature

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature

object FFConfiguredFeatures {

    val RED_SHROOMPADS = register("red_shroompads")
    val BROWN_SHROOMPADS = register("brown_shroompads")

    val FUNGAL_REEF_VEGETATION = register("fungal_reef_vegetation")

    val SEASHROOM_PATCH = register("seashroom_patch")
    
    fun register(id: String): ResourceKey<ConfiguredFeature<*, *>> {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, FantasticFisheryCommon.locate(id))
    }
}
