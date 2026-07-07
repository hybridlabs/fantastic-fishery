package dev.hybridlabs.fantasticfishery.client.render.block

import dev.hybridlabs.fantasticfishery.platform.ClientServices
import dev.hybridlabs.fantasticfishery.block.FFBlocks
import net.minecraft.client.renderer.RenderType

object FFBlockRenderers {
    fun registerRenderShapes() {
        ClientServices.PLATFORM.registerBlockRenderers(
            RenderType.cutout(),
            FFBlocks.CHICKEN_CORAL.get(),
            FFBlocks.CHICKEN_CORAL_FAN.get(),
            FFBlocks.CHICKEN_CORAL_WALL_FAN.get(),
            FFBlocks.DEAD_CHICKEN_CORAL.get(),
            FFBlocks.DEAD_CHICKEN_CORAL_FAN.get(),
            FFBlocks.DEAD_CHICKEN_CORAL_WALL_FAN.get(),

            FFBlocks.SPIRAL_CORAL.get(),
            FFBlocks.SPIRAL_CORAL_FAN.get(),
            FFBlocks.SPIRAL_CORAL_WALL_FAN.get(),
            FFBlocks.DEAD_SPIRAL_CORAL.get(),
            FFBlocks.DEAD_SPIRAL_CORAL_FAN.get(),
            FFBlocks.DEAD_SPIRAL_CORAL_WALL_FAN.get(),

            FFBlocks.OYSTER_CORAL.get(),
            FFBlocks.OYSTER_CORAL_FAN.get(),
            FFBlocks.OYSTER_CORAL_WALL_FAN.get(),
            FFBlocks.DEAD_OYSTER_CORAL.get(),
            FFBlocks.DEAD_OYSTER_CORAL_FAN.get(),
            FFBlocks.DEAD_OYSTER_CORAL_WALL_FAN.get(),

            FFBlocks.AMETHYST_CORAL.get(),
            FFBlocks.AMETHYST_CORAL_FAN.get(),
            FFBlocks.AMETHYST_CORAL_WALL_FAN.get(),
            FFBlocks.DEAD_AMETHYST_CORAL.get(),
            FFBlocks.DEAD_AMETHYST_CORAL_FAN.get(),
            FFBlocks.DEAD_AMETHYST_CORAL_WALL_FAN.get(),

            FFBlocks.SEASHROOM.get(),
            FFBlocks.TALL_SEASHROOM.get(),
        )
    }
}