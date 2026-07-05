package dev.hybridlabs.fantasticfishery.world.gen.feature

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.platform.registration.RegistryObject
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration

object FFFeatures {

    val REEF_FUNGUS_CLAW = register("reef_fungus_claw", ReefFungusClawFeature(NoneFeatureConfiguration.CODEC))
    val REEF_FUNGUS_TREE = register("reef_fungus_tree", ReefFungusTreeFeature(NoneFeatureConfiguration.CODEC))
    val REEF_FUNGUS_MUSHROOM = register("reef_fungus_mushroom", ReefFungusMushroomFeature(NoneFeatureConfiguration.CODEC))
    val REEF_FUNGUS_TABLE = register("reef_fungus_table", ReefFungusTableFeature(NoneFeatureConfiguration.CODEC))
    val REEF_FUNGUS_DISC = register("reef_fungus_disc", ReefFungusDiscFeature(NoneFeatureConfiguration.CODEC))

    fun <F : Feature<*>> register(
        id: String,
        feature: F,
    ): RegistryObject<Feature<FeatureConfiguration>> {
        @Suppress("UNCHECKED_CAST")
        return FantasticFisheryCommon.FEATURE.register(id) { feature as Feature<FeatureConfiguration> }
    }
}