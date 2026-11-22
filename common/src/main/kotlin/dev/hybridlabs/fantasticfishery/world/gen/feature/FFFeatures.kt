package dev.hybridlabs.fantasticfishery.world.gen.feature

import com.mojang.serialization.MapCodec
import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.platform.registration.RegistryObject
import net.minecraft.world.level.levelgen.feature.Feature

object FFFeatures {

    val FUNGAL_REEF_CORAL_CLAW = register("fungal_reef_coral_claw", FungalReefClawFeature.CODEC)
    val FUNGAL_REEF_CORAL_TREE = register("fungal_reef_coral_tree", FungalReefTreeFeature.CODEC)
    val FUNGAL_REEF_CORAL_MUSHROOM = register("fungal_reef_coral_mushroom", FungalReefMushroomFeature.CODEC)
    val FUNGAL_REEF_CORAL_TABLE = register("fungal_reef_coral_table", FungalReefTableFeature.CODEC)
    val FUNGAL_REEF_CORAL_DISC = register("fungal_reef_coral_disc", FungalReefDiscFeature.CODEC)
    val SEASHROOM_PATCH = register("seashroom_patch", SeashroomFeature.CODEC)

    fun register(
        id: String,
        codec: MapCodec<out Feature>,
    ): RegistryObject<MapCodec<out Feature>> {
        return FantasticFisheryCommon.FEATURE_TYPE.register(id) { codec }
    }
}
