package dev.hybridlabs.fantasticfishery.data.client

import dev.hybridlabs.aquatic.block.HABlocks
import dev.hybridlabs.fantasticfishery.block.FFBlockFamilies
import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.block.ShroompadBlock
import dev.hybridlabs.fantasticfishery.data.FantasticFisheryDataGenerator.filterFantasticFishery
import dev.hybridlabs.fantasticfishery.item.FFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators
import net.minecraft.data.models.model.ModelLocationUtils
import net.minecraft.data.models.model.ModelTemplates
import net.minecraft.data.models.model.TexturedModel


class ModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(generator: BlockModelGenerators) {
        generator.run {
            BuiltInRegistries.BLOCK
                .filterIsInstance<ShroompadBlock>()
                .forEach { block ->
                    skipAutoItemBlock(block)
                }

            BuiltInRegistries.ITEM
                .filter(filterFantasticFishery(BuiltInRegistries.ITEM))
                .filter { item ->
                    item in setOf(
                        FFItems.FUNGILL_SPAWN_EGG.get(),
                        FFItems.JELLYSHROOM_SPAWN_EGG.get(),
                        FFItems.PUFFBALL_PUFFER_SPAWN_EGG.get(),
                        FFItems.PLUNDERERS_HOOP_SPAWN_EGG.get(),
                        FFItems.MORSEL_SPAWN_EGG.get(),
                        FFItems.POROUS_SHELL_SPAWN_EGG.get(),
                        FFItems.BLOOD_EEL_SPAWN_EGG.get(),
                        FFItems.FRIGID_VESSEL_SPAWN_EGG.get(),
                        FFItems.MYCRAB_SPAWN_EGG.get(),
                    )
                }
                .forEach { item ->
                    delegateItemModel(
                        item,
                        ModelLocationUtils.decorateItemModelLocation("template_spawn_egg")
                    )
                }

            createCrossBlock(
                FFBlocks.MYCELIAL_SEAGRASS.get(),
                BlockModelGenerators.TintState.NOT_TINTED,
            )

            createDoublePlant(
                FFBlocks.TALL_MYCELIAL_SEAGRASS.get(),
                BlockModelGenerators.TintState.NOT_TINTED,
            )
            
            createCoral(
                FFBlocks.SPIRAL_CORAL.get(),
                FFBlocks.DEAD_SPIRAL_CORAL.get(),
                FFBlocks.SPIRAL_CORAL_BLOCK.get(),
                FFBlocks.DEAD_SPIRAL_CORAL_BLOCK.get(),
                FFBlocks.SPIRAL_CORAL_FAN.get(),
                FFBlocks.DEAD_SPIRAL_CORAL_FAN.get(),
                FFBlocks.SPIRAL_CORAL_WALL_FAN.get(),
                FFBlocks.DEAD_SPIRAL_CORAL_WALL_FAN.get()
            )

            createCoral(
                FFBlocks.CHICKEN_CORAL.get(),
                FFBlocks.DEAD_CHICKEN_CORAL.get(),
                FFBlocks.CHICKEN_CORAL_BLOCK.get(),
                FFBlocks.DEAD_CHICKEN_CORAL_BLOCK.get(),
                FFBlocks.CHICKEN_CORAL_FAN.get(),
                FFBlocks.DEAD_CHICKEN_CORAL_FAN.get(),
                FFBlocks.CHICKEN_CORAL_WALL_FAN.get(),
                FFBlocks.DEAD_CHICKEN_CORAL_WALL_FAN.get()
            )
            
            createCoral(
                FFBlocks.OYSTER_CORAL.get(),
                FFBlocks.DEAD_OYSTER_CORAL.get(),
                FFBlocks.OYSTER_CORAL_BLOCK.get(),
                FFBlocks.DEAD_OYSTER_CORAL_BLOCK.get(),
                FFBlocks.OYSTER_CORAL_FAN.get(),
                FFBlocks.DEAD_OYSTER_CORAL_FAN.get(),
                FFBlocks.OYSTER_CORAL_WALL_FAN.get(),
                FFBlocks.DEAD_OYSTER_CORAL_WALL_FAN.get()
            )
            
            createCoral(
                FFBlocks.AMETHYST_CORAL.get(),
                FFBlocks.DEAD_AMETHYST_CORAL.get(),
                FFBlocks.AMETHYST_CORAL_BLOCK.get(),
                FFBlocks.DEAD_AMETHYST_CORAL_BLOCK.get(),
                FFBlocks.AMETHYST_CORAL_FAN.get(),
                FFBlocks.DEAD_AMETHYST_CORAL_FAN.get(),
                FFBlocks.AMETHYST_CORAL_WALL_FAN.get(),
                FFBlocks.DEAD_AMETHYST_CORAL_WALL_FAN.get()
            )

            createNonTemplateModelBlock(
                FFBlocks.RED_SHROOMPAD.get(),
                FFBlocks.RED_SHROOMPAD.get()
            )

            createNonTemplateModelBlock(
                FFBlocks.BROWN_SHROOMPAD.get(),
                FFBlocks.BROWN_SHROOMPAD.get()
            )

            createNonTemplateModelBlock(
                FFBlocks.PLUNDERERS_CORE_BLOCK.get(),
                FFBlocks.PLUNDERERS_CORE_BLOCK.get()
            )
            
            setOf(
                FFBlocks.MYCELIAL_SAND.get(),
            ).forEach(generator::createTrivialCube)

            setOf(
                FFBlocks.CHISELED_MYCELIAL_SANDSTONE.get(),
            ).forEach { block ->
                generator.createTrivialBlock(block, TexturedModel.CUBE_TOP_BOTTOM)
            }

            generator.family(FFBlocks.SMOOTH_MYCELIAL_SANDSTONE.get())
                .generateFor(FFBlockFamilies.SMOOTH_MYCELIAL_SANDSTONE)

            val mycelialSandstonePool = family(FFBlocks.MYCELIAL_SANDSTONE.get())
            val cutMycelialSandstonePool = family(FFBlocks.CUT_MYCELIAL_SANDSTONE.get())

            mycelialSandstonePool.stairs(FFBlocks.MYCELIAL_SANDSTONE_STAIRS.get())
            mycelialSandstonePool.slab(FFBlocks.MYCELIAL_SANDSTONE_SLAB.get())
            mycelialSandstonePool.wall(FFBlocks.MYCELIAL_SANDSTONE_WALL.get())

            cutMycelialSandstonePool.slab(FFBlocks.CUT_MYCELIAL_SANDSTONE_SLAB.get())
        }
    }

    override fun generateItemModels(generator: ItemModelGenerators) {
        setOf(
            FFItems.FRIGID_VESSEL.get(),
            FFItems.FUNGILL.get(),
            FFItems.MORSEL.get(),
            FFItems.MORSEL_BAR.get(),
            FFItems.MORSEL_POP.get(),
            FFItems.HALF_MORSEL_POP.get(),
            FFItems.QUARTER_MORSEL_POP.get(),
            FFItems.POROUS_SHELL.get(),
            FFItems.BLOOD_EEL.get(),
            FFItems.PLUNDERERS_HOOP.get(),
            FFItems.PLUNDERERS_CORE.get(),
            FFItems.STAR_DONUT.get(),
        ).forEach { item ->
            generator.generateFlatItem(item, ModelTemplates.FLAT_ITEM)
        }
    }
}
