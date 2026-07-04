package dev.hybridlabs.fantasticfishery.block

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.platform.registration.RegistryObject
import net.minecraft.world.level.block.BaseCoralFanBlock
import net.minecraft.world.level.block.BaseCoralPlantBlock
import net.minecraft.world.level.block.BaseCoralWallFanBlock
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.CoralBlock
import net.minecraft.world.level.block.CoralFanBlock
import net.minecraft.world.level.block.CoralPlantBlock
import net.minecraft.world.level.block.CoralWallFanBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour.Properties
import net.minecraft.world.level.material.MapColor
import java.util.function.Supplier

object FFBlocks {

    val RED_FLOATING_CAP = register("red_floating_cap") {
        FloatingCapBlock(
            Properties
            .copy(Blocks.LILY_PAD)
            .instabreak())
    }

    val BROWN_FLOATING_CAP = register("brown_floating_cap") { 
        FloatingCapBlock(
        Properties
            .copy(Blocks.LILY_PAD)
            .instabreak())
    }

    val DRIED_AMETHYST_FUNGUS_BLOCK = 
        register("dried_amethyst_fungus_block") { Block(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_BLOCK)
            .mapColor(MapColor.TERRACOTTA_WHITE)) }
    val AMETHYST_FUNGUS_BLOCK = 
        register("amethyst_fungus_block") { CoralBlock(DRIED_AMETHYST_FUNGUS_BLOCK.get(),
            Properties
                .copy(Blocks.FIRE_CORAL_BLOCK)
                .mapColor(MapColor.TERRACOTTA_WHITE)
                .sound(SoundType.CORAL_BLOCK)) }
    val DRIED_AMETHYST_FUNGUS_FAN =
        register("dried_amethyst_fungus_fan") { BaseCoralFanBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_FAN)) }
    val AMETHYST_FUNGUS_FAN =
        register("amethyst_fungus_fan") { CoralFanBlock(DRIED_AMETHYST_FUNGUS_FAN.get(),
            Properties
            .copy(Blocks.FIRE_CORAL_FAN)) }
    val DRIED_AMETHYST_FUNGUS =
        register("dried_amethyst_fungus") { BaseCoralPlantBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL)) }
    val AMETHYST_FUNGUS =
        register("amethyst_fungus") { CoralPlantBlock(DRIED_AMETHYST_FUNGUS.get(),
            Properties
                .copy(Blocks.FIRE_CORAL)) }
    val DRIED_AMETHYST_FUNGUS_WALL_FAN =
        register("dried_amethyst_fungus_wall_fan") { BaseCoralWallFanBlock(
            Properties
                .copy(Blocks.DEAD_FIRE_CORAL_WALL_FAN)) }
    val AMETHYST_FUNGUS_WALL_FAN =
        register("amethyst_fungus_wall_fan") { CoralWallFanBlock(DRIED_AMETHYST_FUNGUS_WALL_FAN.get(), 
            Properties
                .copy(Blocks.FIRE_CORAL_WALL_FAN)) }

    val DRIED_CHICKEN_FUNGUS_BLOCK = 
        register("dried_chicken_fungus_block") { Block(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_BLOCK)
            .mapColor(MapColor.TERRACOTTA_WHITE)) }
    val CHICKEN_FUNGUS_BLOCK = 
        register("chicken_fungus_block") { CoralBlock(DRIED_CHICKEN_FUNGUS_BLOCK.get(),
            Properties
                .copy(Blocks.FIRE_CORAL_BLOCK)
                .mapColor(MapColor.TERRACOTTA_WHITE)
                .sound(SoundType.CORAL_BLOCK)) }
    val DRIED_CHICKEN_FUNGUS_FAN =
        register("dried_chicken_fungus_fan") { BaseCoralFanBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_FAN)) }
    val CHICKEN_FUNGUS_FAN =
        register("chicken_fungus_fan") { CoralFanBlock(DRIED_CHICKEN_FUNGUS_FAN.get(),
            Properties
            .copy(Blocks.FIRE_CORAL_FAN)) }
    val DRIED_CHICKEN_FUNGUS =
        register("dried_chicken_fungus") { BaseCoralPlantBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL)) }
    val CHICKEN_FUNGUS =
        register("chicken_fungus") { CoralPlantBlock(DRIED_CHICKEN_FUNGUS.get(),
            Properties
                .copy(Blocks.FIRE_CORAL)) }
    val DRIED_CHICKEN_FUNGUS_WALL_FAN =
        register("dried_chicken_fungus_wall_fan") { BaseCoralWallFanBlock(
            Properties
                .copy(Blocks.DEAD_FIRE_CORAL_WALL_FAN)) }
    val CHICKEN_FUNGUS_WALL_FAN =
        register("chicken_fungus_wall_fan") { CoralWallFanBlock(DRIED_CHICKEN_FUNGUS_WALL_FAN.get(), 
            Properties
                .copy(Blocks.FIRE_CORAL_WALL_FAN)) }


    fun <T : Block> register(id: String, block: Supplier<T>): RegistryObject<Block> {
        return FantasticFisheryCommon.BLOCKS.register(id, block)
    }
}