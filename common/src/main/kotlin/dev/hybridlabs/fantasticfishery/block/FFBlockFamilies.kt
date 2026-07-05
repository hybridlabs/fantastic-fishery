package dev.hybridlabs.fantasticfishery.block

import net.minecraft.data.BlockFamily
import net.minecraft.data.models.model.ModelTemplates

@Suppress("unused")
object FFBlockFamilies {

    //#region Mycelial Sandstone
    val MYCELIAL_SANDSTONE: BlockFamily by lazy {
        BlockFamily.Builder(FFBlocks.MYCELIAL_SANDSTONE.get())
            .stairs(FFBlocks.MYCELIAL_SANDSTONE_STAIRS.get())
            .slab(FFBlocks.MYCELIAL_SANDSTONE_SLAB.get())
            .wall(FFBlocks.MYCELIAL_SANDSTONE_WALL.get())
            .chiseled(FFBlocks.CHISELED_MYCELIAL_SANDSTONE.get())
            .family
    }

    val SMOOTH_MYCELIAL_SANDSTONE: BlockFamily by lazy {
        BlockFamily.Builder(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE.get())
            .stairs(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_STAIRS.get())
            .slab(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_SLAB.get())
            .family
    }

    val CUT_MYCELIAL_SANDSTONE: BlockFamily by lazy {
        BlockFamily.Builder(FFBlocks.CUT_MYCELIAL_SANDSTONE.get())
            .slab(FFBlocks.CUT_MYCELIAL_SANDSTONE_SLAB.get())
            .family
    }
    //#endregion
}