package dev.hybridlabs.fantasticfishery.data.server.tag

import dev.hybridlabs.fantasticfishery.item.FFItems
import dev.hybridlabs.fantasticfishery.tag.FFItemTags
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider
import net.minecraft.core.HolderLookup
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.Item
import java.util.concurrent.CompletableFuture

class ItemTagProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagsProvider.ItemTagsProvider(output, registriesFuture) {
    override fun addTags(arg: HolderLookup.Provider) {

        setOf(
            FFItems.FUNGILL.get(),
        ).forEach { item ->
            builder(FFItemTags.FISHES).add(item.builtInRegistryHolder().key())
        }

        setOf(
            FFItems.FUNGILL.get(),
            FFItems.MORSEL.get(),
            FFItems.PLUNDERERS_HOOP.get(),
            FFItems.BLOOD_EEL.get(),
        ).forEach { item ->
            builder(FFItemTags.SMALL_FISH).add(item.builtInRegistryHolder().key())
        }

        setOf(
            FFItems.POROUS_SHELL.get(),
        ).forEach { item ->
            builder(FFItemTags.MEDIUM_FISH).add(item.builtInRegistryHolder().key())
        }
    }

}
