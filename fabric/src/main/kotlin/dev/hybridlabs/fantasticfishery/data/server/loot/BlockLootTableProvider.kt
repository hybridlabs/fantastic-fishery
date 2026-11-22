package dev.hybridlabs.fantasticfishery.data.server.loot

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.data.FantasticFisheryDataGenerator.filterFantasticFishery
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.BaseCoralWallFanBlock
import net.minecraft.world.level.block.Block
import java.util.concurrent.CompletableFuture

class BlockLootTableProvider(output: FabricPackOutput, registryLookup: CompletableFuture<HolderLookup.Provider>) :
    FabricBlockLootSubProvider(output, registryLookup) {

    override fun generate() {
        val handled = mutableSetOf<Block>()

        add(FFBlocks.SEASHROOM.get()) { block ->
            createShearsOrSilkTouchOnlyDrop(block)
        }
        handled.add(FFBlocks.SEASHROOM.get())

        add(FFBlocks.TALL_SEASHROOM.get()) { _ ->
            createSingleItemTable(FFBlocks.SEASHROOM.get())
        }
        handled.add(FFBlocks.TALL_SEASHROOM.get())

        for (block in listOf(
            FFBlocks.AMETHYST_CORAL.get(),
            FFBlocks.DEAD_AMETHYST_CORAL.get(),
            FFBlocks.AMETHYST_CORAL_FAN.get(),
            FFBlocks.DEAD_AMETHYST_CORAL_FAN.get(),

            FFBlocks.CHICKEN_CORAL.get(),
            FFBlocks.DEAD_CHICKEN_CORAL.get(),
            FFBlocks.CHICKEN_CORAL_FAN.get(),
            FFBlocks.DEAD_CHICKEN_CORAL_FAN.get(),

            FFBlocks.OYSTER_CORAL.get(),
            FFBlocks.DEAD_OYSTER_CORAL.get(),
            FFBlocks.OYSTER_CORAL_FAN.get(),
            FFBlocks.DEAD_OYSTER_CORAL_FAN.get(),

            FFBlocks.SPIRAL_CORAL.get(),
            FFBlocks.DEAD_SPIRAL_CORAL.get(),
            FFBlocks.SPIRAL_CORAL_FAN.get(),
            FFBlocks.DEAD_SPIRAL_CORAL_FAN.get(),
        )) {
            add(block, createSingleItemTable(block))
            handled.add(block)
        }

        val wallFans = mapOf(
            FFBlocks.AMETHYST_CORAL_WALL_FAN.get() to FFBlocks.AMETHYST_CORAL_FAN.get(),
            FFBlocks.DEAD_AMETHYST_CORAL_WALL_FAN.get() to FFBlocks.DEAD_AMETHYST_CORAL_FAN.get(),
            FFBlocks.OYSTER_CORAL_WALL_FAN.get() to FFBlocks.OYSTER_CORAL_FAN.get(),
            FFBlocks.DEAD_OYSTER_CORAL_WALL_FAN.get() to FFBlocks.DEAD_OYSTER_CORAL_FAN.get(),
            FFBlocks.SPIRAL_CORAL_WALL_FAN.get() to FFBlocks.SPIRAL_CORAL_FAN.get(),
            FFBlocks.DEAD_SPIRAL_CORAL_WALL_FAN.get() to FFBlocks.DEAD_SPIRAL_CORAL_FAN.get(),
            FFBlocks.CHICKEN_CORAL_WALL_FAN.get() to FFBlocks.CHICKEN_CORAL_FAN.get(),
            FFBlocks.DEAD_CHICKEN_CORAL_WALL_FAN.get() to FFBlocks.DEAD_CHICKEN_CORAL_FAN.get(),
        )
        wallFans.forEach { (wallFan, fan) ->
            add(wallFan, createSingleItemTableWithSilkTouch(wallFan, fan))
            handled.add(wallFan)
        }

        BuiltInRegistries.BLOCK
            .filter(filterFantasticFishery(BuiltInRegistries.BLOCK))
            .filter { block ->
                block.asItem() != Items.AIR
                        && block !is BaseCoralWallFanBlock
                        && block !in handled
            }
            .forEach { block ->
                val id = BuiltInRegistries.BLOCK.getKey(block)
                if (id.path.endsWith("slab")) {
                    add(block, createSlabItemTable(block))
                } else {
                    add(block, createSingleItemTable(block))
                }
            }
    }
}
