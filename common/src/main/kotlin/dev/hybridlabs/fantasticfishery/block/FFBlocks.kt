package dev.hybridlabs.fantasticfishery.block

import dev.hybridlabs.aquatic.block.HABlocks
import dev.hybridlabs.aquatic.block.SeaLettuceBlock
import dev.hybridlabs.aquatic.block.TallSeaLettuceBlock
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
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockBehaviour.Properties
import net.minecraft.world.level.material.MapColor
import java.util.function.Supplier

object FFBlocks {

    val RED_SHROOMPAD = register("red_shroompad") {
        ShroompadBlock(
            Properties
            .copy(Blocks.LILY_PAD)
            .instabreak())
    }

    val BROWN_SHROOMPAD = register("brown_shroompad") {
        ShroompadBlock(
        Properties
            .copy(Blocks.LILY_PAD)
            .instabreak())
    }

    val MYCELIAL_SEAGRASS = HABlocks.register("mycelial_seagrass") {
        MycelialSeagrassBlock(
            Properties
                .copy(Blocks.SEAGRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
        )
    }

    val TALL_MYCELIAL_SEAGRASS = HABlocks.register("tall_mycelial_seagrass") {
        TallMycelialSeagrassBlock(
            Properties
                .copy(Blocks.TALL_SEAGRASS)
                .offsetType(BlockBehaviour.OffsetType.NONE)
        )
    }

    val PLUNDERERS_CORE_BLOCK = register("plunderers_core_block") {
        PlunderersCoreBlock(
        Properties
            .copy(Blocks.OCHRE_FROGLIGHT)
            .noOcclusion()
            .noParticlesOnBreak()
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

    val DEAD_SPIRAL_CORAL_BLOCK = 
        register("dead_spiral_coral_block") { Block(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_BLOCK)
            .mapColor(MapColor.COLOR_GRAY)) }
    val SPIRAL_CORAL_BLOCK = 
        register("spiral_coral_block") { CoralBlock(DEAD_SPIRAL_CORAL_BLOCK.get(),
            Properties
                .copy(Blocks.FIRE_CORAL_BLOCK)
                .mapColor(MapColor.TERRACOTTA_MAGENTA)
                .sound(SoundType.CORAL_BLOCK)) }
    val DEAD_SPIRAL_CORAL_FAN =
        register("dead_spiral_coral_fan") { BaseCoralFanBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_FAN)) }
    val SPIRAL_CORAL_FAN =
        register("spiral_coral_fan") { CoralFanBlock(DEAD_SPIRAL_CORAL_FAN.get(),
            Properties
            .copy(Blocks.FIRE_CORAL_FAN)) }
    val DEAD_SPIRAL_CORAL =
        register("dead_spiral_coral") { BaseCoralPlantBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL)) }
    val SPIRAL_CORAL =
        register("spiral_coral") { CoralPlantBlock(DEAD_SPIRAL_CORAL.get(),
            Properties
                .copy(Blocks.FIRE_CORAL)) }
    val DEAD_SPIRAL_CORAL_WALL_FAN =
        register("dead_spiral_coral_wall_fan") { BaseCoralWallFanBlock(
            Properties
                .copy(Blocks.DEAD_FIRE_CORAL_WALL_FAN)) }
    val SPIRAL_CORAL_WALL_FAN =
        register("spiral_coral_wall_fan") { CoralWallFanBlock(DEAD_SPIRAL_CORAL_WALL_FAN.get(), 
            Properties
                .copy(Blocks.FIRE_CORAL_WALL_FAN)) }

    val DEAD_OYSTER_CORAL_BLOCK = 
        register("dead_oyster_coral_block") { Block(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_BLOCK)
            .mapColor(MapColor.COLOR_GRAY)) }
    val OYSTER_CORAL_BLOCK = 
        register("oyster_coral_block") { CoralBlock(DEAD_OYSTER_CORAL_BLOCK.get(),
            Properties
                .copy(Blocks.FIRE_CORAL_BLOCK)
                .mapColor(MapColor.TERRACOTTA_MAGENTA)
                .sound(SoundType.CORAL_BLOCK)) }
    val DEAD_OYSTER_CORAL_FAN =
        register("dead_oyster_coral_fan") { BaseCoralFanBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_FAN)) }
    val OYSTER_CORAL_FAN =
        register("oyster_coral_fan") { CoralFanBlock(DEAD_OYSTER_CORAL_FAN.get(),
            Properties
            .copy(Blocks.FIRE_CORAL_FAN)) }
    val DEAD_OYSTER_CORAL =
        register("dead_oyster_coral") { BaseCoralPlantBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL)) }
    val OYSTER_CORAL =
        register("oyster_coral") { CoralPlantBlock(DEAD_OYSTER_CORAL.get(),
            Properties
                .copy(Blocks.FIRE_CORAL)) }
    val DEAD_OYSTER_CORAL_WALL_FAN =
        register("dead_oyster_coral_wall_fan") { BaseCoralWallFanBlock(
            Properties
                .copy(Blocks.DEAD_FIRE_CORAL_WALL_FAN)) }
    val OYSTER_CORAL_WALL_FAN =
        register("oyster_coral_wall_fan") { CoralWallFanBlock(DEAD_OYSTER_CORAL_WALL_FAN.get(), 
            Properties
                .copy(Blocks.FIRE_CORAL_WALL_FAN)) }

    val DEAD_AMETHYST_CORAL_BLOCK = 
        register("dead_amethyst_coral_block") { Block(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_BLOCK)
            .mapColor(MapColor.COLOR_GRAY)) }
    val AMETHYST_CORAL_BLOCK = 
        register("amethyst_coral_block") { CoralBlock(DEAD_AMETHYST_CORAL_BLOCK.get(),
            Properties
                .copy(Blocks.FIRE_CORAL_BLOCK)
                .mapColor(MapColor.TERRACOTTA_MAGENTA)
                .sound(SoundType.CORAL_BLOCK)) }
    val DEAD_AMETHYST_CORAL_FAN =
        register("dead_amethyst_coral_fan") { BaseCoralFanBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_FAN)) }
    val AMETHYST_CORAL_FAN =
        register("amethyst_coral_fan") { CoralFanBlock(DEAD_AMETHYST_CORAL_FAN.get(),
            Properties
            .copy(Blocks.FIRE_CORAL_FAN)) }
    val DEAD_AMETHYST_CORAL =
        register("dead_amethyst_coral") { BaseCoralPlantBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL)) }
    val AMETHYST_CORAL =
        register("amethyst_coral") { CoralPlantBlock(DEAD_AMETHYST_CORAL.get(),
            Properties
                .copy(Blocks.FIRE_CORAL)) }
    val DEAD_AMETHYST_CORAL_WALL_FAN =
        register("dead_amethyst_coral_wall_fan") { BaseCoralWallFanBlock(
            Properties
                .copy(Blocks.DEAD_FIRE_CORAL_WALL_FAN)) }
    val AMETHYST_CORAL_WALL_FAN =
        register("amethyst_coral_wall_fan") { CoralWallFanBlock(DEAD_AMETHYST_CORAL_WALL_FAN.get(), 
            Properties
                .copy(Blocks.FIRE_CORAL_WALL_FAN)) }

    val DEAD_CHICKEN_CORAL_BLOCK = 
        register("dead_chicken_coral_block") { Block(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_BLOCK)
            .mapColor(MapColor.COLOR_GRAY)) }
    val CHICKEN_CORAL_BLOCK = 
        register("chicken_coral_block") { CoralBlock(DEAD_CHICKEN_CORAL_BLOCK.get(),
            Properties
                .copy(Blocks.FIRE_CORAL_BLOCK)
                .mapColor(MapColor.TERRACOTTA_ORANGE)
                .sound(SoundType.CORAL_BLOCK)) }
    val DEAD_CHICKEN_CORAL_FAN =
        register("dead_chicken_coral_fan") { BaseCoralFanBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL_FAN)) }
    val CHICKEN_CORAL_FAN =
        register("chicken_coral_fan") { CoralFanBlock(DEAD_CHICKEN_CORAL_FAN.get(),
            Properties
            .copy(Blocks.FIRE_CORAL_FAN)) }
    val DEAD_CHICKEN_CORAL =
        register("dead_chicken_coral") { BaseCoralPlantBlock(
            Properties
            .copy(Blocks.DEAD_FIRE_CORAL)) }
    val CHICKEN_CORAL =
        register("chicken_coral") { CoralPlantBlock(DEAD_CHICKEN_CORAL.get(),
            Properties
                .copy(Blocks.FIRE_CORAL)) }
    val DEAD_CHICKEN_CORAL_WALL_FAN =
        register("dead_chicken_coral_wall_fan") { BaseCoralWallFanBlock(
            Properties
                .copy(Blocks.DEAD_FIRE_CORAL_WALL_FAN)) }
    val CHICKEN_CORAL_WALL_FAN =
        register("chicken_coral_wall_fan") { CoralWallFanBlock(DEAD_CHICKEN_CORAL_WALL_FAN.get(), 
            Properties
                .copy(Blocks.FIRE_CORAL_WALL_FAN)) }

    fun <T : Block> register(id: String, block: Supplier<T>): RegistryObject<Block> {
        return FantasticFisheryCommon.BLOCKS.register(id, block)
    }
}