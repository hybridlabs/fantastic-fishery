package dev.hybridlabs.fantasticfishery.data.server.tag

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.tag.FFBlockTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import java.util.concurrent.CompletableFuture

class BlockTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.BlockTagProvider(output, registriesFuture) {
    override fun addTags(arg: HolderLookup.Provider) {

        getOrCreateTagBuilder(FFBlockTags.FUNGAL_CORAL_BLOCKS)
            .add(FFBlocks.CHICKEN_CORAL_BLOCK.get())
            .add(FFBlocks.AMETHYST_CORAL_BLOCK.get())
            .add(FFBlocks.OYSTER_CORAL_BLOCK.get())
            .add(FFBlocks.CHANTERELLE_CORAL_BLOCK.get())

        getOrCreateTagBuilder(FFBlockTags.FUNGAL_CORAL_PLANTS)
            .add(FFBlocks.CHICKEN_CORAL.get())
            .add(FFBlocks.AMETHYST_CORAL.get())
            .add(FFBlocks.OYSTER_CORAL.get())
            .add(FFBlocks.CHANTERELLE_CORAL.get())

        getOrCreateTagBuilder(FFBlockTags.FUNGAL_CORALS)
            .forceAddTag(FFBlockTags.FUNGAL_CORAL_PLANTS)
            .add(FFBlocks.CHICKEN_CORAL_FAN.get())
            .add(FFBlocks.AMETHYST_CORAL_FAN.get())
            .add(FFBlocks.OYSTER_CORAL_FAN.get())
            .add(FFBlocks.CHANTERELLE_CORAL_FAN.get())

        getOrCreateTagBuilder(FFBlockTags.FUNGAL_WALL_CORALS)
            .add(FFBlocks.CHICKEN_CORAL_WALL_FAN.get())
            .add(FFBlocks.AMETHYST_CORAL_WALL_FAN.get())
            .add(FFBlocks.OYSTER_CORAL_WALL_FAN.get())
            .add(FFBlocks.CHANTERELLE_CORAL_WALL_FAN.get())
    }
}