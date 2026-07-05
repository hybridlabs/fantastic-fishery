package dev.hybridlabs.fantasticfishery.world.gen.feature

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature

object FFConfiguredFeatures {

    val RED_SHROOMPADS = register("red_shroompads")
    val BROWN_SHROOMPADS = register("brown_shroompads")

    fun register(id: String): ResourceKey<ConfiguredFeature<*, *>> {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, FantasticFisheryCommon.locate(id))
    }
}
