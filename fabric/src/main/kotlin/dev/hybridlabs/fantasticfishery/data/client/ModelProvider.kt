package dev.hybridlabs.fantasticfishery.data.client

import dev.hybridlabs.fantasticfishery.data.FantasticFisheryDataGenerator.filterFantasticFishery
import dev.hybridlabs.fantasticfishery.item.FFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators
import net.minecraft.data.models.model.ModelLocationUtils
import net.minecraft.data.models.model.ModelTemplates

class ModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(generator: BlockModelGenerators) {
        generator.run {

            BuiltInRegistries.ITEM
                .filter(filterFantasticFishery(BuiltInRegistries.ITEM))
                .filter { item ->
                    item in setOf(
                        FFItems.FUNGILL_SPAWN_EGG.get(),
                        FFItems.PLUNDERERS_HOOP_SPAWN_EGG.get(),
                        FFItems.MORSEL_SPAWN_EGG.get(),
                    )
                }
                .forEach { item ->
                    delegateItemModel(
                        item,
                        ModelLocationUtils.decorateItemModelLocation("template_spawn_egg")
                    )
                }
        }
    }

    override fun generateItemModels(generator: ItemModelGenerators) {
        setOf(
            FFItems.FRIGID_VESSEL.get(),
            FFItems.FUNGILL.get(),
            FFItems.OMPAX.get(),
            FFItems.BACKWARD_TROUT.get(),
            FFItems.CONSTELLATION_FISH.get(),
            FFItems.MORSEL.get(),
            FFItems.MORSEL_BAR.get(),
            FFItems.MORSEL_POP.get(),
            FFItems.ROTTEN_COD.get(),
            FFItems.PLASMAFIN.get(),
            FFItems.POROUS_SHELL.get(),
            FFItems.BLOOD_EEL.get(),
            FFItems.HAWALANZA.get(),
            FFItems.CLUBHEAD.get(),
            FFItems.MORSEL_BUCKET.get(),
            FFItems.PLUNDERERS_HOOP.get(),
            FFItems.PLUNDERERS_HOOP_BUCKET.get(),
            FFItems.PLUNDERERS_CORE.get(),
            FFItems.STAR_DONUT.get(),
        ).forEach { item ->
            generator.generateFlatItem(item, ModelTemplates.FLAT_ITEM)
        }
    }
}
