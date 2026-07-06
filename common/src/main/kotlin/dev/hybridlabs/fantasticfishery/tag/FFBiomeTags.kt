package dev.hybridlabs.fantasticfishery.tag

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.level.biome.Biome

object FFBiomeTags {

    //#region Cold Ocean Tags
    val MUSHROOM_BIOMES = create("mushroom_biomes")
    val FUNGAL_SEA = create("fungal_sea")
    val MUSHROOM_SHORES = create("mushroom_shores")

    private fun create(id: String): TagKey<Biome> {
        return TagKey.create(Registries.BIOME, FantasticFisheryCommon.locate(id))
    }
}