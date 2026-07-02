@file:Suppress("UnstableApiUsage")

package dev.hybridlabs.fantasticfishery.item

import dev.hybridlabs.fantasticfishery.Constants
import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.platform.registration.RegistryObject
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

object FFItemGroups {
    val FANTASTIC_FISHERY = register(
        Constants.MOD_ID, CreativeModeTab.builder(CreativeModeTab.Row.TOP,0)
        .title(Component.translatable("itemGroup.${Constants.MOD_ID}.items"))
        .icon { ItemStack(FFItems.FUNGILL.get()) }
        .displayItems { _, entries ->
            BuiltInRegistries.ITEM.forEach { item ->
                val id = BuiltInRegistries.ITEM.getKey(item)
                if (id.namespace != Constants.MOD_ID) return@forEach

                entries.accept(item)
            }
        }
        .build()
    )

    private fun register(id: String, itemGroup: CreativeModeTab): RegistryObject<CreativeModeTab> {
        return FantasticFisheryCommon.CREATIVE_MODE_TABS.register(id) { itemGroup }
    }
}
