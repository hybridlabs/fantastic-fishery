package dev.hybridlabs.fantasticfishery.data.server.tag

import dev.hybridlabs.fantasticfishery.tag.FFBiomeTags
import dev.hybridlabs.fantasticfishery.world.gen.biome.FFBiomes
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.Biomes
import java.util.concurrent.CompletableFuture

class BiomeTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider<Biome>(output, Registries.BIOME, registriesFuture) {
    override fun addTags(arg: HolderLookup.Provider) {

        getOrCreateTagBuilder(FFBiomeTags.MUSHROOM_BIOMES)
            .addOptional(FFBiomes.FUNGAL_REEF)
            .addOptional(Biomes.MUSHROOM_FIELDS)
    }
}