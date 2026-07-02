@file:Suppress("UnstableApiUsage")

package dev.hybridlabs.fantasticfishery.tag

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item

object FFItemTags {
    val FISHES = create("fishes")

    private fun create(id: String): TagKey<Item> {
        return TagKey.create(Registries.ITEM, FantasticFisheryCommon.locate(id))
    }

    private fun createConventional(id: String): TagKey<Item> {
		return TagKey.create(Registries.ITEM, ResourceLocation("c", id))
    }
}
