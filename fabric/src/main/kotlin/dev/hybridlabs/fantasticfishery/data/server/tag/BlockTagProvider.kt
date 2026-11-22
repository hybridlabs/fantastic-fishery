package dev.hybridlabs.fantasticfishery.data.server.tag

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.tag.FFBlockTags
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import java.util.concurrent.CompletableFuture

class BlockTagProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagsProvider.BlockTagsProvider(output, registriesFuture) {
    override fun addTags(arg: HolderLookup.Provider) {

        valueLookupBuilder(FFBlockTags.FUNGAL_CORAL_BLOCKS)
            .add(FFBlocks.CHICKEN_CORAL_BLOCK.get())
            .add(FFBlocks.SPIRAL_CORAL_BLOCK.get())
            .add(FFBlocks.OYSTER_CORAL_BLOCK.get())
            .add(FFBlocks.AMETHYST_CORAL_BLOCK.get())

        valueLookupBuilder(FFBlockTags.FUNGAL_CORAL_PLANTS)
            .add(FFBlocks.CHICKEN_CORAL.get())
            .add(FFBlocks.SPIRAL_CORAL.get())
            .add(FFBlocks.OYSTER_CORAL.get())
            .add(FFBlocks.AMETHYST_CORAL.get())

        valueLookupBuilder(FFBlockTags.FUNGAL_CORALS)
            .forceAddTag(FFBlockTags.FUNGAL_CORAL_PLANTS)
            .add(FFBlocks.CHICKEN_CORAL_FAN.get())
            .add(FFBlocks.SPIRAL_CORAL_FAN.get())
            .add(FFBlocks.OYSTER_CORAL_FAN.get())
            .add(FFBlocks.AMETHYST_CORAL_FAN.get())

        valueLookupBuilder(FFBlockTags.FUNGAL_WALL_CORALS)
            .add(FFBlocks.CHICKEN_CORAL_WALL_FAN.get())
            .add(FFBlocks.SPIRAL_CORAL_WALL_FAN.get())
            .add(FFBlocks.OYSTER_CORAL_WALL_FAN.get())
            .add(FFBlocks.AMETHYST_CORAL_WALL_FAN.get())

        valueLookupBuilder(BlockTags.SAND)
            .add(FFBlocks.MYCELIAL_SAND.get())

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(FFBlocks.AMETHYST_CORAL_BLOCK.get())
            .add(FFBlocks.DEAD_AMETHYST_CORAL_BLOCK.get())
            .add(FFBlocks.DEAD_AMETHYST_CORAL.get())
            .add(FFBlocks.DEAD_AMETHYST_CORAL_FAN.get())
            .add(FFBlocks.DEAD_AMETHYST_CORAL_WALL_FAN.get())
            
            .add(FFBlocks.SPIRAL_CORAL_BLOCK.get())
            .add(FFBlocks.DEAD_SPIRAL_CORAL_BLOCK.get())
            .add(FFBlocks.DEAD_SPIRAL_CORAL.get())
            .add(FFBlocks.DEAD_SPIRAL_CORAL_FAN.get())
            .add(FFBlocks.DEAD_SPIRAL_CORAL_WALL_FAN.get())
            
            .add(FFBlocks.CHICKEN_CORAL_BLOCK.get())
            .add(FFBlocks.DEAD_CHICKEN_CORAL_BLOCK.get())
            .add(FFBlocks.DEAD_CHICKEN_CORAL.get())
            .add(FFBlocks.DEAD_CHICKEN_CORAL_FAN.get())
            .add(FFBlocks.DEAD_CHICKEN_CORAL_WALL_FAN.get())

            .add(FFBlocks.OYSTER_CORAL_BLOCK.get())
            .add(FFBlocks.DEAD_OYSTER_CORAL_BLOCK.get())
            .add(FFBlocks.DEAD_OYSTER_CORAL.get())
            .add(FFBlocks.DEAD_OYSTER_CORAL_FAN.get())
            .add(FFBlocks.DEAD_OYSTER_CORAL_WALL_FAN.get())

            .add(FFBlocks.MYCELIAL_SANDSTONE.get())
            .add(FFBlocks.MYCELIAL_SANDSTONE_WALL.get())
            .add(FFBlocks.MYCELIAL_SANDSTONE_SLAB.get())
            .add(FFBlocks.MYCELIAL_SANDSTONE_STAIRS.get())
            .add(FFBlocks.CHISELED_MYCELIAL_SANDSTONE.get())
            .add(FFBlocks.CUT_MYCELIAL_SANDSTONE.get())
            .add(FFBlocks.CUT_MYCELIAL_SANDSTONE_SLAB.get())
            .add(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE.get())
            .add(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_SLAB.get())
            .add(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_STAIRS.get())
        
        valueLookupBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
            .add(FFBlocks.MYCELIAL_SAND.get())

        valueLookupBuilder(BlockTags.WALLS)
            .add(FFBlocks.MYCELIAL_SANDSTONE_WALL.get())

        valueLookupBuilder(BlockTags.SLABS)
            .add(FFBlocks.MYCELIAL_SANDSTONE_SLAB.get())
            .add(FFBlocks.CUT_MYCELIAL_SANDSTONE_SLAB.get())
            .add(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_SLAB.get())
        
        valueLookupBuilder(BlockTags.STAIRS)
            .add(FFBlocks.MYCELIAL_SANDSTONE_STAIRS.get())
            .add(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_STAIRS.get())
    }
}