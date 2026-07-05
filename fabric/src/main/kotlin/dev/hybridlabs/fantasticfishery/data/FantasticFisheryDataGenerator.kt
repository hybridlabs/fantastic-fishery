package dev.hybridlabs.fantasticfishery.data

import dev.hybridlabs.fantasticfishery.Constants
import dev.hybridlabs.fantasticfishery.data.client.LanguageProvider
import dev.hybridlabs.fantasticfishery.data.client.ModelProvider
import dev.hybridlabs.fantasticfishery.data.server.RecipeProvider
import dev.hybridlabs.fantasticfishery.data.server.tag.ItemTagProvider
import dev.hybridlabs.fantasticfishery.data.server.loot.EntityTypeLootTableProvider
import dev.hybridlabs.fantasticfishery.data.server.tag.BiomeTagProvider
import dev.hybridlabs.fantasticfishery.data.server.tag.BlockTagProvider
import dev.hybridlabs.fantasticfishery.data.server.worldgen.BiomeProvider
import dev.hybridlabs.fantasticfishery.data.server.worldgen.ConfiguredFeatureProvider
import dev.hybridlabs.fantasticfishery.data.server.worldgen.PlacedFeatureProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.core.Registry

object FantasticFisheryDataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(generator: FabricDataGenerator) {
        val pack = generator.createPack()
        pack.addProvider(::LanguageProvider)
        pack.addProvider(::ModelProvider)
        pack.addProvider(::BlockTagProvider)
        pack.addProvider(::ItemTagProvider)
        pack.addProvider(::BiomeTagProvider)
        pack.addProvider(::RecipeProvider)
        pack.addProvider(::EntityTypeLootTableProvider)
        pack.addProvider(::BiomeProvider)
        pack.addProvider(::ConfiguredFeatureProvider)
        pack.addProvider(::PlacedFeatureProvider)
    }

    fun <T> filterFantasticFishery(registry: Registry<T>): (T & Any) -> Boolean {
        return { o ->
            val id = registry.getKey(o)
            id!!.namespace == Constants.MOD_ID
        }
    }
}