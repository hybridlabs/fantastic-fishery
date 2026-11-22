package dev.hybridlabs.fantasticfishery.item

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.Item

/**
 * Item ids are no longer assigned by the registry, they have to be set on [Item.Properties] before
 * the item is constructed. Registration goes through [FFItems.register], which exposes the id being
 * registered here so item factories can build their properties without threading it through every
 * call site.
 */
object FFItemProperties {
    private val currentId = ThreadLocal<ResourceKey<Item>?>()

    fun <T> withId(id: String, factory: () -> T): T {
        val previous = currentId.get()
        currentId.set(ResourceKey.create(Registries.ITEM, FantasticFisheryCommon.locate(id)))
        try {
            return factory()
        } finally {
            currentId.set(previous)
        }
    }

    fun props(): Item.Properties {
        val id = checkNotNull(currentId.get()) { "Item properties must be created during item registration" }
        return Item.Properties().setId(id)
    }

    fun blockProps(): Item.Properties = props().useBlockDescriptionPrefix()
}
