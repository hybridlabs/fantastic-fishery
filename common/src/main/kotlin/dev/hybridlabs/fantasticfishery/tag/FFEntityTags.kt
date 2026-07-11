package dev.hybridlabs.fantasticfishery.tag

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.entity.EntityType

object FFEntityTags {

    val ALL_FISH = createHybridAquaticTag("all_fish")
    val SMALL_CREATURES = createHybridAquaticTag("small_creatures")
    val MEDIUM_CREATURES = createHybridAquaticTag("medium_creatures")
    val LARGE_CREATURES = createHybridAquaticTag("large_creatures")
    val ALL_JELLYFISH = createHybridAquaticTag("all_jellyfish")
    val DOLPHIN = createHybridAquaticTag("dolphin")
    val CRAB = createHybridAquaticTag("crab")

    private fun create(id: String): TagKey<EntityType<*>> {
        return TagKey.create(Registries.ENTITY_TYPE, FantasticFisheryCommon.locate(id))
    }

    private fun createHybridAquaticTag(id: String): TagKey<EntityType<*>> {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("hybrid_aquatic", id))
    }
}