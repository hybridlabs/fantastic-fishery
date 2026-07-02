package dev.hybridlabs.fantasticfishery.data.client

import dev.hybridlabs.fantasticfishery.item.FFItemGroups
import dev.hybridlabs.fantasticfishery.item.FFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.core.registries.BuiltInRegistries

class LanguageProvider(output: FabricDataOutput) : FabricLanguageProvider(output) {
    override fun generateTranslations(builder: TranslationBuilder) {
        // item group
        builder.add(
            BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(FFItemGroups.FANTASTIC_FISHERY.get())
                .orElseThrow { IllegalStateException("Item group not registered") }, "Fantastic Fishery"
        )

        // items
        mapOf(
            FFItems.FRIGID_VESSEL.get() to "Frigid Vessel",
            FFItems.FUNGILL.get() to "Fungill",
            FFItems.OMPAX.get() to "Ompax",
            FFItems.BACKWARD_TROUT.get() to "Backward Trout",
            FFItems.CONSTELLATION_FISH.get() to "Constellation Fish",
            FFItems.MORSEL.get() to "Morsel",
            FFItems.PLUNDERERS_HOOP.get() to "Plunderer's Hoop",
            FFItems.ROTTEN_COD.get() to "Rotten Cod",
            FFItems.PLASMAFIN.get() to "Plasmafin",
            FFItems.POROUS_SHELL.get() to "Porous Shell",
            FFItems.BLOOD_EEL.get() to "Blood Eel",
            FFItems.HAWALANZA.get() to "Hawalanza",
            FFItems.CLUBHEAD.get() to "Clubhead",
        ).forEach { (item, translation) ->
            builder.add(item, translation)
        }
    }
}