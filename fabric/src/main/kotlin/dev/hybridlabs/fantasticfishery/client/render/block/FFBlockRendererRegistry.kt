package dev.hybridlabs.fantasticfishery.client.render.block

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.platform.ClientServices
import net.minecraft.client.renderer.RenderType

object FFBlockRendererRegistry {
    init {
        ClientServices.PLATFORM.registerBlockRenderers(
            RenderType.cutout(),
            FFBlocks.CHICKEN_FUNGUS.get(),
            FFBlocks.CHICKEN_FUNGUS_FAN.get(),
            FFBlocks.CHICKEN_FUNGUS_WALL_FAN.get(),
            FFBlocks.DRIED_CHICKEN_FUNGUS.get(),
            FFBlocks.DRIED_CHICKEN_FUNGUS_FAN.get(),
            FFBlocks.DRIED_CHICKEN_FUNGUS_WALL_FAN.get(),
            
            FFBlocks.AMETHYST_FUNGUS.get(),
            FFBlocks.AMETHYST_FUNGUS_FAN.get(),
            FFBlocks.AMETHYST_FUNGUS_WALL_FAN.get(),
            FFBlocks.DRIED_AMETHYST_FUNGUS.get(),
            FFBlocks.DRIED_AMETHYST_FUNGUS_FAN.get(),
            FFBlocks.DRIED_AMETHYST_FUNGUS_WALL_FAN.get(),

            FFBlocks.OYSTER_FUNGUS.get(),
            FFBlocks.OYSTER_FUNGUS_FAN.get(),
            FFBlocks.OYSTER_FUNGUS_WALL_FAN.get(),
            FFBlocks.DRIED_OYSTER_FUNGUS.get(),
            FFBlocks.DRIED_OYSTER_FUNGUS_FAN.get(),
            FFBlocks.DRIED_OYSTER_FUNGUS_WALL_FAN.get(),
        )
    }
}