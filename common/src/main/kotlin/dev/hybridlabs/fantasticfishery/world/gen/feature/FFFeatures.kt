package dev.hybridlabs.fantasticfishery.world.gen.feature

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.platform.registration.RegistryObject
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration

object FFFeatures {

    val FUNGAL_REEF_CORAL_CLAW = register("fungal_reef_coral_claw", FungalReefClawFeature(NoneFeatureConfiguration.CODEC))
    val FUNGAL_REEF_CORAL_TREE = register("fungal_reef_coral_tree", FungalReefTreeFeature(NoneFeatureConfiguration.CODEC))
    val FUNGAL_REEF_CORAL_MUSHROOM = register("fungal_reef_coral_mushroom", FungalReefMushroomFeature(NoneFeatureConfiguration.CODEC))
    val FUNGAL_REEF_CORAL_TABLE = register("fungal_reef_coral_table", FungalReefTableFeature(NoneFeatureConfiguration.CODEC))
    val FUNGAL_REEF_CORAL_DISC = register("fungal_reef_coral_disc", FungalReefDiscFeature(NoneFeatureConfiguration.CODEC))
    val SEASHROOM_PATCH = register("seashroom_patch", SeashroomFeature(ProbabilityFeatureConfiguration.CODEC))

    fun <F : Feature<*>> register(
        id: String,
        feature: F,
    ): RegistryObject<Feature<FeatureConfiguration>> {
        @Suppress("UNCHECKED_CAST")
        return FantasticFisheryCommon.FEATURE.register(id) { feature as Feature<FeatureConfiguration> }
    }
}