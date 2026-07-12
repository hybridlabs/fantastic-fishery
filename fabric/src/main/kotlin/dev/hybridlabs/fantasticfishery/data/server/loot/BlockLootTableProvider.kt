package dev.hybridlabs.fantasticfishery.data.server.loot

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.data.FantasticFisheryDataGenerator.filterFantasticFishery
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.level.block.BaseCoralWallFanBlock
import net.minecraft.world.level.storage.loot.LootPool
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootItem
import java.util.concurrent.CompletableFuture

class BlockLootTableProvider(output: FabricDataOutput, registryLookup: CompletableFuture<HolderLookup.Provider>) :
    FabricBlockLootTableProvider(output, registryLookup) {

    override fun generate() {

        add(FFBlocks.SEASHROOM.get()) { block ->
            LootTable.lootTable().pool(
                LootPool.lootPool()
                    .add(LootItem.lootTableItem(block))
                    .conditionally(hasShearsOrSilkTouch().build())
                    .build()
            )
        }

        //#region Corals
        add(FFBlocks.AMETHYST_CORAL_BLOCK.get()) { block ->
            LootTable.lootTable().withPool(
                LootPool.lootPool()
                    .add(
                        LootItem.lootTableItem(block)
                            .`when`(hasSilkTouch())
                    )
                    .add(
                        LootItem.lootTableItem(FFBlocks.DEAD_AMETHYST_CORAL_BLOCK.get())
                            .`when`(hasSilkTouch().invert())
                    )
            )
        }

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
            add(block, createSilkTouchOnlyTable(block))
        }

        mapOf(
            FFBlocks.AMETHYST_CORAL_WALL_FAN.get() to FFBlocks.AMETHYST_CORAL_FAN.get(),
            FFBlocks.DEAD_AMETHYST_CORAL_WALL_FAN.get() to FFBlocks.DEAD_AMETHYST_CORAL_FAN.get(),
            FFBlocks.OYSTER_CORAL_WALL_FAN.get() to FFBlocks.OYSTER_CORAL_FAN.get(),
            FFBlocks.DEAD_OYSTER_CORAL_WALL_FAN.get() to FFBlocks.DEAD_OYSTER_CORAL_FAN.get(),
            FFBlocks.SPIRAL_CORAL_WALL_FAN.get() to FFBlocks.SPIRAL_CORAL_FAN.get(),
            FFBlocks.DEAD_SPIRAL_CORAL_WALL_FAN.get() to FFBlocks.DEAD_SPIRAL_CORAL_FAN.get(),
            FFBlocks.CHICKEN_CORAL_WALL_FAN.get() to FFBlocks.CHICKEN_CORAL_FAN.get(),
            FFBlocks.DEAD_CHICKEN_CORAL_WALL_FAN.get() to FFBlocks.DEAD_CHICKEN_CORAL_FAN.get(),
        ).forEach { (wallFan, fan) ->
            add(wallFan, createSilkTouchOnlyTable(fan))
        }

        // generate remaining drops
        BuiltInRegistries.BLOCK
            .filter(filterFantasticFishery(BuiltInRegistries.BLOCK))
            .filter { block ->
                block !is BaseCoralWallFanBlock
                        && block.lootTable !in map
            }
            .forEach { block ->
                val id = BuiltInRegistries.BLOCK.getKey(block)
                if (id.path.endsWith("slab")) {
                    add(block, createSlabItemTable(block))
                } else {
                    dropSelf(block)
                }
            }
    }
}