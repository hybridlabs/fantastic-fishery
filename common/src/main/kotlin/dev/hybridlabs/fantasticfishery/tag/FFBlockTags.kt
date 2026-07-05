package dev.hybridlabs.fantasticfishery.tag

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.level.block.Block

object FFBlockTags {

    val FUNGAL_CORALS = create("fungal_corals")
    val FUNGAL_CORAL_BLOCKS = create("fungal_coral_blocks")
    val FUNGAL_CORAL_PLANTS = create("fungal_coral_plants")
    val FUNGAL_WALL_CORALS = create("fungal_wall_corals")

    private fun create(id: String): TagKey<Block> {
        return TagKey.create(Registries.BLOCK, FantasticFisheryCommon.locate(id))
    }
}