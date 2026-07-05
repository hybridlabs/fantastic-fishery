package dev.hybridlabs.fantasticfishery.data.client

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.data.FantasticFisheryDataGenerator.filterFantasticFishery
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.item.FFItemGroups
import dev.hybridlabs.fantasticfishery.item.FFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.Mob
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.collections.component1
import kotlin.collections.component2

class LanguageProvider(output: FabricDataOutput) : FabricLanguageProvider(output) {
    override fun generateTranslations(builder: TranslationBuilder) {
        // item group
        builder.add(
            BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(FFItemGroups.FANTASTIC_FISHERY.get())
                .orElseThrow { IllegalStateException("Item group not registered") }, "Fantastic Fishery"
        )

        generateEntities(builder)

        // blocks
        mapOf(
            FFBlocks.RED_SHROOMPAD.get() to "Red Shroompad",
            FFBlocks.BROWN_SHROOMPAD.get() to "Brown Shroompad",
            
            FFBlocks.MYCELIAL_SAND.get() to "Mycelial Sand",
            FFBlocks.MYCELIAL_SANDSTONE.get() to "Mycelial Sandstone",
            FFBlocks.MYCELIAL_SANDSTONE_STAIRS.get() to "Mycelial Sandstone Stairs",
            FFBlocks.MYCELIAL_SANDSTONE_SLAB.get() to "Mycelial Sandstone Slab",
            FFBlocks.MYCELIAL_SANDSTONE_WALL.get() to "Mycelial Sandstone Wall",
            FFBlocks.SMOOTH_MYCELIAL_SANDSTONE.get() to "Smooth Mycelial Sandstone",
            FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_SLAB.get() to "Smooth Mycelial Sandstone Slab",
            FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_STAIRS.get() to "Smooth Mycelial Sandstone Stairs",
            FFBlocks.CUT_MYCELIAL_SANDSTONE.get() to "Cut Mycelial Sandstone",
            FFBlocks.CUT_MYCELIAL_SANDSTONE_SLAB.get() to "Cut Mycelial Sandstone Slab",
            FFBlocks.CHISELED_MYCELIAL_SANDSTONE.get() to "Chiseled Mycelial Sandstone",

            FFBlocks.CHICKEN_FUNGUS_BLOCK.get() to "Chicken Fungus Block",
            FFBlocks.DRIED_CHICKEN_FUNGUS_BLOCK.get() to "Dried Chicken Fungus Block",
            FFBlocks.CHICKEN_FUNGUS.get() to "Chicken Fungus",
            FFBlocks.DRIED_CHICKEN_FUNGUS.get() to "Dried Chicken Fungus",
            FFBlocks.CHICKEN_FUNGUS_FAN.get() to "Chicken Fungus Fan",
            FFBlocks.DRIED_CHICKEN_FUNGUS_FAN.get() to "Dried Chicken Fungus Fan",

            FFBlocks.AMETHYST_FUNGUS_BLOCK.get() to "Amethyst Fungus Block",
            FFBlocks.DRIED_AMETHYST_FUNGUS_BLOCK.get() to "Dried Amethyst Fungus Block",
            FFBlocks.AMETHYST_FUNGUS.get() to "Amethyst Fungus",
            FFBlocks.DRIED_AMETHYST_FUNGUS.get() to "Dried Amethyst Fungus",
            FFBlocks.AMETHYST_FUNGUS_FAN.get() to "Amethyst Fungus Fan",
            FFBlocks.DRIED_AMETHYST_FUNGUS_FAN.get() to "Dried Amethyst Fungus Fan",

            ).forEach { (block, translation) ->
            builder.add(block, translation)
        }

        // items
        mapOf(
            FFItems.FRIGID_VESSEL.get() to "Frigid Vessel",
            FFItems.FUNGILL.get() to "Fungill",

            FFItems.MORSEL.get() to "Morsel",
            FFItems.MORSEL_BUCKET.get() to "Bucket Of Morsel",
            FFItems.MORSEL_BAR.get() to "Morsel Bar",
            FFItems.MORSEL_POP.get() to "Morsel Pop",

            FFItems.PLUNDERERS_HOOP.get() to "Plunderer's Hoop",
            FFItems.PLUNDERERS_HOOP_BUCKET.get() to "Bucket Of Plunderer's Hoop",
            FFItems.PLUNDERERS_CORE.get() to "Plunderer's Core",
            FFItems.STAR_DONUT.get() to "Star Donut",

            FFItems.POROUS_SHELL.get() to "Porous Shell",
            FFItems.BLOOD_EEL.get() to "Blood Eel",
        ).forEach { (item, translation) ->
            builder.add(item, translation)
        }
    }

    private fun generateEntities(builder: TranslationBuilder) {
        // create map of entities to their display names
        val entityNameMap = mapOf(
            FFEntityTypes.FUNGILL.get() to "Fungill",
            FFEntityTypes.PLUNDERERS_HOOP.get() to "Plunderers Hoop",
            FFEntityTypes.MORSEL.get() to "Morsel",
            FFEntityTypes.POROUS_SHELL.get() to "Porous Shell",
            FFEntityTypes.BLOOD_EEL.get() to "Blood Eel",
            FFEntityTypes.FRIGID_VESSEL.get() to "Frigid Vessel",
        )

        // verify display name list is valid
        val nonPresentEntityNames = mutableListOf<EntityType<*>>()

        BuiltInRegistries.ENTITY_TYPE
            .filter(filterFantasticFishery(BuiltInRegistries.ENTITY_TYPE))
            .forEach { type ->
                if (type.baseClass.isAssignableFrom(Mob::class.java)) {
                    if (!entityNameMap.containsKey(type)) {
                        nonPresentEntityNames.add(type)
                    }
                }
            }

        if (nonPresentEntityNames.isNotEmpty()) {
            logger.error("Entity to display name map does not contain elements. Please modify ${javaClass.simpleName} accordingly. The following are not present: \n${nonPresentEntityNames.joinToString(separator = "\n")}")
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

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(LanguageProvider::class.java)
    }
}
