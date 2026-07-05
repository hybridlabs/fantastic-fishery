package dev.hybridlabs.fantasticfishery.block

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.platform.registration.RegistryObject
import net.minecraft.world.item.DyeColor
import net.minecraft.world.level.block.BaseCoralFanBlock
import net.minecraft.world.level.block.BaseCoralPlantBlock
import net.minecraft.world.level.block.BaseCoralWallFanBlock
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.CoralBlock
import net.minecraft.world.level.block.CoralFanBlock
import net.minecraft.world.level.block.CoralPlantBlock
import net.minecraft.world.level.block.CoralWallFanBlock
import net.minecraft.world.level.block.SandBlock
import net.minecraft.world.level.block.SlabBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.StairBlock
import net.minecraft.world.level.block.WallBlock
import net.minecraft.world.level.block.state.BlockBehaviour.Properties
import net.minecraft.world.level.material.MapColor
import java.util.function.Supplier

object FFBlocks {

    val RED_SHROOMPAD = register("red_shroompad") {
        FloatingCapBlock(
            Properties
            .copy(Blocks.LILY_PAD)
            .instabreak())
    }

    val BROWN_SHROOMPAD = register("brown_shroompad") {
        FloatingCapBlock(
        Properties
            .copy(Blocks.LILY_PAD)
            .instabreak())
    }
    
    val MYCELIAL_SAND = register("mycelial_sand") { SandBlock(14406560, Properties.copy(Blocks.SAND)) }

    val MYCELIAL_SANDSTONE = register("mycelial_sandstone") {
        Block(
            Properties
                .copy(Blocks.SANDSTONE)
        )
    }
    val MYCELIAL_SANDSTONE_STAIRS = register("mycelial_sandstone_stairs") {
        StairBlock(
            MYCELIAL_SANDSTONE.get().defaultBlockState(), Properties
                .copy(MYCELIAL_SANDSTONE.get())
                .mapColor(DyeColor.MAGENTA)
        )
    }
    val MYCELIAL_SANDSTONE_SLAB = register("mycelial_sandstone_slab") {
        SlabBlock(
            Properties
                .copy(MYCELIAL_SANDSTONE.get())
                .mapColor(DyeColor.MAGENTA)
        )
    }
    val MYCELIAL_SANDSTONE_WALL = register("mycelial_sandstone_wall") {
        WallBlock(
            Properties
                .copy(MYCELIAL_SANDSTONE.get())
        )
    }

    val SMOOTH_MYCELIAL_SANDSTONE = register("smooth_mycelial_sandstone") {
        Block(
            Properties
                .copy(Blocks.SANDSTONE)
        )
    }
    val SMOOTH_MYCELIAL_SANDSTONE_SLAB = register("smooth_mycelial_sandstone_slab") {
        SlabBlock(
            Properties
                .copy(MYCELIAL_SANDSTONE.get())
                .mapColor(DyeColor.MAGENTA)
        )
    }
    val SMOOTH_MYCELIAL_SANDSTONE_STAIRS = register("smooth_mycelial_sandstone_stairs") {
        StairBlock(
            MYCELIAL_SANDSTONE.get().defaultBlockState(), Properties
                .copy(MYCELIAL_SANDSTONE.get())
                .mapColor(DyeColor.MAGENTA)
        )
    }

    val CUT_MYCELIAL_SANDSTONE = register("cut_mycelial_sandstone") {
        Block(
            Properties
                .copy(MYCELIAL_SANDSTONE.get())
                .mapColor(DyeColor.MAGENTA)
        )
    }
    val CUT_MYCELIAL_SANDSTONE_SLAB = register("cut_mycelial_sandstone_slab") {
        SlabBlock(
            Properties
                .copy(MYCELIAL_SANDSTONE.get())
                .mapColor(DyeColor.MAGENTA)
        )
    }

    val CHISELED_MYCELIAL_SANDSTONE = register("chiseled_mycelial_sandstone") {
        SlabBlock(
            Properties
                .copy(MYCELIAL_SANDSTONE.get())
                .mapColor(DyeColor.MAGENTA)
        )
    }

    val DRIED_AMETHYST_FUNGUS_BLOCK = 
        register("dried_amethyst_fungus_block") { Block(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_BLOCK)
            .mapColor(MapColor.COLOR_GRAY)) }
    val AMETHYST_FUNGUS_BLOCK = 
        register("amethyst_fungus_block") { CoralBlock(DRIED_AMETHYST_FUNGUS_BLOCK.get(),
            Properties
                .copy(Blocks.FIRE_CORAL_BLOCK)
                .mapColor(MapColor.TERRACOTTA_MAGENTA)
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
            .mapColor(MapColor.COLOR_GRAY)) }
    val CHICKEN_FUNGUS_BLOCK = 
        register("chicken_fungus_block") { CoralBlock(DRIED_CHICKEN_FUNGUS_BLOCK.get(),
            Properties
                .copy(Blocks.FIRE_CORAL_BLOCK)
                .mapColor(MapColor.TERRACOTTA_ORANGE)
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