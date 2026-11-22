package dev.hybridlabs.fantasticfishery.data.server.tag

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.tag.FFBlockTags
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider
import net.minecraft.core.HolderLookup
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Block
import java.util.concurrent.CompletableFuture

class BlockTagProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagsProvider.BlockTagsProvider(output, registriesFuture) {
    override fun addTags(arg: HolderLookup.Provider) {

        builder(FFBlockTags.FUNGAL_CORAL_BLOCKS)
            .add(FFBlocks.CHICKEN_CORAL_BLOCK.get().builtInRegistryHolder().key())
            .add(FFBlocks.SPIRAL_CORAL_BLOCK.get().builtInRegistryHolder().key())
            .add(FFBlocks.OYSTER_CORAL_BLOCK.get().builtInRegistryHolder().key())
            .add(FFBlocks.AMETHYST_CORAL_BLOCK.get().builtInRegistryHolder().key())

        builder(FFBlockTags.FUNGAL_CORAL_PLANTS)
            .add(FFBlocks.CHICKEN_CORAL.get().builtInRegistryHolder().key())
            .add(FFBlocks.SPIRAL_CORAL.get().builtInRegistryHolder().key())
            .add(FFBlocks.OYSTER_CORAL.get().builtInRegistryHolder().key())
            .add(FFBlocks.AMETHYST_CORAL.get().builtInRegistryHolder().key())

        builder(FFBlockTags.FUNGAL_CORALS)
            .addTag(FFBlockTags.FUNGAL_CORAL_PLANTS)
            .add(FFBlocks.CHICKEN_CORAL_FAN.get().builtInRegistryHolder().key())
            .add(FFBlocks.SPIRAL_CORAL_FAN.get().builtInRegistryHolder().key())
            .add(FFBlocks.OYSTER_CORAL_FAN.get().builtInRegistryHolder().key())
            .add(FFBlocks.AMETHYST_CORAL_FAN.get().builtInRegistryHolder().key())

        builder(FFBlockTags.FUNGAL_WALL_CORALS)
            .add(FFBlocks.CHICKEN_CORAL_WALL_FAN.get().builtInRegistryHolder().key())
            .add(FFBlocks.SPIRAL_CORAL_WALL_FAN.get().builtInRegistryHolder().key())
            .add(FFBlocks.OYSTER_CORAL_WALL_FAN.get().builtInRegistryHolder().key())
            .add(FFBlocks.AMETHYST_CORAL_WALL_FAN.get().builtInRegistryHolder().key())

        builder(BlockTags.SAND)
            .add(FFBlocks.MYCELIAL_SAND.get().builtInRegistryHolder().key())

        builder(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(FFBlocks.AMETHYST_CORAL_BLOCK.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_AMETHYST_CORAL_BLOCK.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_AMETHYST_CORAL.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_AMETHYST_CORAL_FAN.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_AMETHYST_CORAL_WALL_FAN.get().builtInRegistryHolder().key())
            
            .add(FFBlocks.SPIRAL_CORAL_BLOCK.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_SPIRAL_CORAL_BLOCK.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_SPIRAL_CORAL.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_SPIRAL_CORAL_FAN.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_SPIRAL_CORAL_WALL_FAN.get().builtInRegistryHolder().key())
            
            .add(FFBlocks.CHICKEN_CORAL_BLOCK.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_CHICKEN_CORAL_BLOCK.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_CHICKEN_CORAL.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_CHICKEN_CORAL_FAN.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_CHICKEN_CORAL_WALL_FAN.get().builtInRegistryHolder().key())

            .add(FFBlocks.OYSTER_CORAL_BLOCK.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_OYSTER_CORAL_BLOCK.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_OYSTER_CORAL.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_OYSTER_CORAL_FAN.get().builtInRegistryHolder().key())
            .add(FFBlocks.DEAD_OYSTER_CORAL_WALL_FAN.get().builtInRegistryHolder().key())

            .add(FFBlocks.MYCELIAL_SANDSTONE.get().builtInRegistryHolder().key())
            .add(FFBlocks.MYCELIAL_SANDSTONE_WALL.get().builtInRegistryHolder().key())
            .add(FFBlocks.MYCELIAL_SANDSTONE_SLAB.get().builtInRegistryHolder().key())
            .add(FFBlocks.MYCELIAL_SANDSTONE_STAIRS.get().builtInRegistryHolder().key())
            .add(FFBlocks.CHISELED_MYCELIAL_SANDSTONE.get().builtInRegistryHolder().key())
            .add(FFBlocks.CUT_MYCELIAL_SANDSTONE.get().builtInRegistryHolder().key())
            .add(FFBlocks.CUT_MYCELIAL_SANDSTONE_SLAB.get().builtInRegistryHolder().key())
            .add(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE.get().builtInRegistryHolder().key())
            .add(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_SLAB.get().builtInRegistryHolder().key())
            .add(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_STAIRS.get().builtInRegistryHolder().key())
        
        builder(BlockTags.MINEABLE_WITH_SHOVEL)
            .add(FFBlocks.MYCELIAL_SAND.get().builtInRegistryHolder().key())

        builder(BlockTags.WALLS)
            .add(FFBlocks.MYCELIAL_SANDSTONE_WALL.get().builtInRegistryHolder().key())

        builder(BlockTags.SLABS)
            .add(FFBlocks.MYCELIAL_SANDSTONE_SLAB.get().builtInRegistryHolder().key())
            .add(FFBlocks.CUT_MYCELIAL_SANDSTONE_SLAB.get().builtInRegistryHolder().key())
            .add(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_SLAB.get().builtInRegistryHolder().key())
        
        builder(BlockTags.STAIRS)
            .add(FFBlocks.MYCELIAL_SANDSTONE_STAIRS.get().builtInRegistryHolder().key())
            .add(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_STAIRS.get().builtInRegistryHolder().key())
    }

}
