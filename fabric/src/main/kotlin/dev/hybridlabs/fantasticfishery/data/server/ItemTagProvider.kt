package dev.hybridlabs.fantasticfishery.data.server

import dev.hybridlabs.fantasticfishery.item.FFItems
import dev.hybridlabs.fantasticfishery.tag.FFItemTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import java.util.concurrent.CompletableFuture

class ItemTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.ItemTagProvider(output, registriesFuture) {
    override fun addTags(arg: HolderLookup.Provider) {

        setOf(
            FFItems.FUNGILL.get(),
        ).forEach { item ->
            getOrCreateTagBuilder(FFItemTags.FISHES).add(item)
        }
    }
}