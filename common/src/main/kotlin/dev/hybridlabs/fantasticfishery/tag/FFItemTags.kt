@file:Suppress("UnstableApiUsage")

package dev.hybridlabs.fantasticfishery.tag

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item

object FFItemTags {
    val FISHES = create("fishes")
    val SMALL_FISH = createHAPITag("small_fish")
    val MEDIUM_FISH = createHAPITag("medium_fish")
    val LARGE_FISH = createHAPITag("large_fish")

    private fun create(id: String): TagKey<Item> {
        return TagKey.create(Registries.ITEM, FantasticFisheryCommon.locate(id))
    }

    private fun createConventional(id: String): TagKey<Item> {
		return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", id))
    }

    private fun createHAPITag(id: String): TagKey<Item> {
		return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("hapi", id))
    }
}
