package dev.hybridlabs.fantasticfishery.data.client

import dev.hybridlabs.aquatic.data.HybridAquaticDataGenerator.filterHybridAquatic
import dev.hybridlabs.aquatic.entity.HAEntityTypes
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.item.FFItemGroups
import dev.hybridlabs.fantasticfishery.item.FFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.Mob

class LanguageProvider(output: FabricDataOutput) : FabricLanguageProvider(output) {
    override fun generateTranslations(builder: TranslationBuilder) {
        // item group
        builder.add(
            BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(FFItemGroups.FANTASTIC_FISHERY.get())
                .orElseThrow { IllegalStateException("Item group not registered") }, "Fantastic Fishery"
        )

        generateEntities(builder)

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

    private fun generateEntities(builder: TranslationBuilder) {
        // create map of entities to their display names
        val entityNameMap = mapOf(
            FFEntityTypes.FUNGILL.get() to "Fungill",
        )

        // verify display name list is valid
        val nonPresentEntityNames = mutableListOf<EntityType<*>>()

        BuiltInRegistries.ENTITY_TYPE
            .filter(filterHybridAquatic(BuiltInRegistries.ENTITY_TYPE))
            .forEach { type ->
                if (type.baseClass.isAssignableFrom(Mob::class.java)) {
                    if (!entityNameMap.containsKey(type)) {
                        nonPresentEntityNames.add(type)
                    }
                }
            }

        if (nonPresentEntityNames.isNotEmpty()) {
            throw IllegalStateException("Entity to display name map does not contain ${nonPresentEntityNames.joinToString()}. Please modify ${javaClass.simpleName} accordingly.")
        }

        // generate entity and entity spawn egg translations
        entityNameMap.forEach { (entityType, translation) ->
            val id = BuiltInRegistries.ENTITY_TYPE.getKey(entityType)
            val translationKey = entityType.descriptionId
            val namespace = id.namespace
            val path = id.path
            builder.add(translationKey, translation)
            builder.add("item.$namespace.${path}_spawn_egg", "$translation Spawn Egg")
        }
    }
}