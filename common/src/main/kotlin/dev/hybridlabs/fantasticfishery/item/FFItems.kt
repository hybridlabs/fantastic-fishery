package dev.hybridlabs.fantasticfishery.item

import dev.hybridlabs.aquatic.item.PlaceableInWaterItem
import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.platform.Services.PLATFORM
import net.minecraft.core.Direction
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.Mob
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.SpawnEggItem
import net.minecraft.world.item.StandingAndWallBlockItem
import net.minecraft.world.level.block.Block
import java.util.function.Supplier

object FFItems {

    val RED_SHROOMPAD = registerPlaceableInWaterBlockItem("red_shroompad") { FFBlocks.RED_SHROOMPAD.get() }
    val BROWN_SHROOMPAD = registerPlaceableInWaterBlockItem("brown_shroompad") { FFBlocks.BROWN_SHROOMPAD.get() }
    
    val MYCELIAL_SEAGRASS = registerBlockItem("mycelial_seagrass") { FFBlocks.MYCELIAL_SEAGRASS.get() }

    val MYCELIAL_SAND = registerBlockItem("mycelial_sand") { FFBlocks.MYCELIAL_SAND.get() }
    val CHISELED_MYCELIAL_SANDSTONE =
        registerBlockItem("chiseled_mycelial_sandstone") { FFBlocks.CHISELED_MYCELIAL_SANDSTONE.get() }
    val MYCELIAL_SANDSTONE = registerBlockItem("mycelial_sandstone") { FFBlocks.MYCELIAL_SANDSTONE.get() }
    val MYCELIAL_SANDSTONE_STAIRS = register("mycelial_sandstone_stairs") {
        BlockItem(
            FFBlocks.MYCELIAL_SANDSTONE_STAIRS.get(),
            Item.Properties()
        )
    }
    val MYCELIAL_SANDSTONE_SLAB =
        register("mycelial_sandstone_slab") { BlockItem(FFBlocks.MYCELIAL_SANDSTONE_SLAB.get(), Item.Properties()) }
    val MYCELIAL_SANDSTONE_WALL =
        register("mycelial_sandstone_wall") { BlockItem(FFBlocks.MYCELIAL_SANDSTONE_WALL.get(), Item.Properties()) }
    val SMOOTH_MYCELIAL_SANDSTONE =
        registerBlockItem("smooth_mycelial_sandstone") { FFBlocks.SMOOTH_MYCELIAL_SANDSTONE.get() }
    val SMOOTH_MYCELIAL_SANDSTONE_STAIRS = register("smooth_mycelial_sandstone_stairs") {
        BlockItem(
            FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_STAIRS.get(),
            Item.Properties()
        )
    }
    val SMOOTH_MYCELIAL_SANDSTONE_SLAB = register("smooth_mycelial_sandstone_slab") {
        BlockItem(
            FFBlocks.SMOOTH_MYCELIAL_SANDSTONE_SLAB.get(),
            Item.Properties()
        )
    }
    val CUT_MYCELIAL_SANDSTONE = registerBlockItem("cut_mycelial_sandstone") { FFBlocks.CUT_MYCELIAL_SANDSTONE.get() }
    val CUT_MYCELIAL_SANDSTONE_SLAB = register("cut_mycelial_sandstone_slab") {
        BlockItem(
            FFBlocks.CUT_MYCELIAL_SANDSTONE_SLAB.get(),
            Item.Properties()
        )
    }
    
    val SPIRAL_CORAL_BLOCK =
        registerBlockItem("spiral_coral_block") { FFBlocks.SPIRAL_CORAL_BLOCK.get() }
    val DEAD_SPIRAL_CORAL_BLOCK =
        registerBlockItem("dead_spiral_coral_block") { FFBlocks.DEAD_SPIRAL_CORAL_BLOCK.get() }
    val SPIRAL_CORAL = registerBlockItem("spiral_coral") { FFBlocks.SPIRAL_CORAL.get() }
    val DEAD_SPIRAL_CORAL = registerBlockItem("dead_spiral_coral") { FFBlocks.DEAD_SPIRAL_CORAL.get() }
    val SPIRAL_CORAL_FAN = registerVerticallyAttachable(
        "spiral_coral_fan",
        FFBlocks.SPIRAL_CORAL_FAN,
        FFBlocks.SPIRAL_CORAL_WALL_FAN
    )
    val DEAD_SPIRAL_CORAL_FAN = registerVerticallyAttachable(
        "dead_spiral_coral_fan",
        FFBlocks.DEAD_SPIRAL_CORAL_FAN,
        FFBlocks.DEAD_SPIRAL_CORAL_WALL_FAN
    )
    
    val OYSTER_CORAL_BLOCK =
        registerBlockItem("oyster_coral_block") { FFBlocks.OYSTER_CORAL_BLOCK.get() }
    val DEAD_OYSTER_CORAL_BLOCK =
        registerBlockItem("dead_oyster_coral_block") { FFBlocks.DEAD_OYSTER_CORAL_BLOCK.get() }
    val OYSTER_CORAL = registerBlockItem("oyster_coral") { FFBlocks.OYSTER_CORAL.get() }
    val DEAD_OYSTER_CORAL = registerBlockItem("dead_oyster_coral") { FFBlocks.DEAD_OYSTER_CORAL.get() }
    val OYSTER_CORAL_FAN = registerVerticallyAttachable(
        "oyster_coral_fan",
        FFBlocks.OYSTER_CORAL_FAN,
        FFBlocks.OYSTER_CORAL_WALL_FAN
    )
    val DEAD_OYSTER_CORAL_FAN = registerVerticallyAttachable(
        "dead_oyster_coral_fan",
        FFBlocks.DEAD_OYSTER_CORAL_FAN,
        FFBlocks.DEAD_OYSTER_CORAL_WALL_FAN
    )
    
    val AMETHYST_CORAL_BLOCK =
        registerBlockItem("amethyst_coral_block") { FFBlocks.AMETHYST_CORAL_BLOCK.get() }
    val DEAD_AMETHYST_CORAL_BLOCK =
        registerBlockItem("dead_amethyst_coral_block") { FFBlocks.DEAD_AMETHYST_CORAL_BLOCK.get() }
    val AMETHYST_CORAL = registerBlockItem("amethyst_coral") { FFBlocks.AMETHYST_CORAL.get() }
    val DEAD_AMETHYST_CORAL = registerBlockItem("dead_amethyst_coral") { FFBlocks.DEAD_AMETHYST_CORAL.get() }
    val AMETHYST_CORAL_FAN = registerVerticallyAttachable(
        "amethyst_coral_fan",
        FFBlocks.AMETHYST_CORAL_FAN,
        FFBlocks.AMETHYST_CORAL_WALL_FAN
    )
    val DEAD_AMETHYST_CORAL_FAN = registerVerticallyAttachable(
        "dead_amethyst_coral_fan",
        FFBlocks.DEAD_AMETHYST_CORAL_FAN,
        FFBlocks.DEAD_AMETHYST_CORAL_WALL_FAN
    )
    
    val CHICKEN_CORAL_BLOCK =
        registerBlockItem("chicken_coral_block") { FFBlocks.CHICKEN_CORAL_BLOCK.get() }
    val DEAD_CHICKEN_CORAL_BLOCK =
        registerBlockItem("dead_chicken_coral_block") { FFBlocks.DEAD_CHICKEN_CORAL_BLOCK.get() }
    val CHICKEN_CORAL = registerBlockItem("chicken_coral") { FFBlocks.CHICKEN_CORAL.get() }
    val DEAD_CHICKEN_CORAL = registerBlockItem("dead_chicken_coral") { FFBlocks.DEAD_CHICKEN_CORAL.get() }
    val CHICKEN_CORAL_FAN = registerVerticallyAttachable(
        "chicken_coral_fan",
        FFBlocks.CHICKEN_CORAL_FAN,
        FFBlocks.CHICKEN_CORAL_WALL_FAN
    )
    val DEAD_CHICKEN_CORAL_FAN = registerVerticallyAttachable(
        "dead_chicken_coral_fan",
        FFBlocks.DEAD_CHICKEN_CORAL_FAN,
        FFBlocks.DEAD_CHICKEN_CORAL_WALL_FAN
    )
    
    val FRIGID_VESSEL = register(
        "frigid_vessel",
    ) {
        Item(
            Item.Properties()
                .food(
                    FoodProperties.Builder()
                        .nutrition(1)
                        .saturationMod(0.2F)
                        .build()
                )
        )
    }

    val FUNGILL = register(
        "fungill",
    ) {
        Item(
            Item.Properties()
                .food(
                    FoodProperties.Builder()
                        .nutrition(1)
                        .saturationMod(0.2F)
                        .build()
                )
        )
    }

    val MORSEL = register(
        "morsel",
    ) {
        Item(
            Item.Properties()
                .food(
                    FoodProperties.Builder()
                        .nutrition(1)
                        .saturationMod(1.0F)
                        .effect(MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0f)
                        .build()
                )
        )
    }

    val MORSEL_BAR = register(
        "morsel_bar",
    ) {
        Item(
            Item.Properties()
        )
    }

    val MORSEL_POP = register(
        "morsel_pop",
    ) {
        Item(
            Item.Properties()
                .stacksTo(1)
                .food(
                    FoodProperties.Builder()
                        .nutrition(10)
                        .saturationMod(1.0F)
                        .effect(MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
                        .build()
                )
        )
    }

    val PLUNDERERS_HOOP = register(
        "plunderers_hoop",
    ) {
        Item(
            Item.Properties()
                .food(
                    FoodProperties.Builder()
                        .nutrition(1)
                        .saturationMod(0.2F)
                        .build()
                )
        )
    }

    val STAR_DONUT = register(
        "star_donut",
    ) {
        Item(
            Item.Properties()
                .stacksTo(16)
                .food(
                    FoodProperties.Builder()
                        .nutrition(6)
                        .saturationMod(0.5F)
                        .effect(MobEffectInstance(MobEffects.GLOWING, 400, 0), 1.0f)
                        .build()
                )
        )
    }

    val PLUNDERERS_CORE = register(
        "plunderers_core",
    ) {
        PlunderersCoreItem(
            Item.Properties()
                .stacksTo(16)
        )
    }

    val POROUS_SHELL = register(
        "porous_shell",
    ) {
        Item(
            Item.Properties()
                .food(
                    FoodProperties.Builder()
                        .nutrition(1)
                        .saturationMod(0.2F)
                        .build()
                )
        )
    }

    val BLOOD_EEL = register(
        "blood_eel",
    ) {
        Item(
            Item.Properties()
                .food(
                    FoodProperties.Builder()
                        .nutrition(1)
                        .saturationMod(0.2F)
                        .build()
                )
        )
    }

    val FUNGILL_SPAWN_EGG =
        registerSpawnEgg("fungill_spawn_egg", FFEntityTypes.FUNGILL, 0xFFFFFF, 0xFFFFFF)
    val JELLYSHROOM_SPAWN_EGG =
        registerSpawnEgg("jellyshroom_spawn_egg", FFEntityTypes.JELLYSHROOM, 0xFFFFFF, 0xFFFFFF)
    val PUFFBALL_PUFFER_SPAWN_EGG =
        registerSpawnEgg("puffball_puffer_spawn_egg", FFEntityTypes.PUFFBALL_PUFFER, 0xFFFFFF, 0xFFFFFF)
    val MYCRAB_SPAWN_EGG =
        registerSpawnEgg("mycrab_spawn_egg", FFEntityTypes.MYCRAB, 0xFFFFFF, 0xFFFFFF)
    val PLUNDERERS_HOOP_SPAWN_EGG =
        registerSpawnEgg("plunderers_hoop_spawn_egg", FFEntityTypes.PLUNDERERS_HOOP, 0xFFFFFF, 0xFFFFFF)
    val MORSEL_SPAWN_EGG =
        registerSpawnEgg("morsel_spawn_egg", FFEntityTypes.MORSEL, 0xFFFFFF, 0xFFFFFF)
    val POROUS_SHELL_SPAWN_EGG =
        registerSpawnEgg("porous_shell_spawn_egg", FFEntityTypes.POROUS_SHELL, 0xFFFFFF, 0xFFFFFF)
    val BLOOD_EEL_SPAWN_EGG =
        registerSpawnEgg("blood_eel_spawn_egg", FFEntityTypes.BLOOD_EEL, 0xFFFFFF, 0xFFFFFF)
    val FRIGID_VESSEL_SPAWN_EGG =
        registerSpawnEgg("frigid_vessel_spawn_egg", FFEntityTypes.FRIGID_VESSEL, 0xFFFFFF, 0xFFFFFF)

    private fun register(id: String, item: Supplier<Item>): Supplier<Item> {
        return FantasticFisheryCommon.ITEMS.register(id, item)
    }

    private fun <T : Mob> registerSpawnEgg(
        id: String,
        type: Supplier<EntityType<T>>,
        primaryColor: Int,
        secondaryColor: Int,
    ): Supplier<SpawnEggItem> {
        return PLATFORM.registerSpawnEggItem(id, { type.get() }, primaryColor, secondaryColor)
    }

    fun registerBlockItem(id: String, block: Supplier<Block>): Supplier<Item> {
        return register(id) { BlockItem(block.get(), Item.Properties()) }
    }

    private fun registerPlaceableInWaterBlockItem(id: String, block: Supplier<Block>): Supplier<Item> {
        return register(id) { PlaceableInWaterItem(block.get(), Item.Properties()) }
    }

    private fun registerVerticallyAttachable(
        id: String,
        standingBlock: Supplier<Block>,
        wallBlock: Supplier<Block>,
        direction: Direction = Direction.DOWN,
    ): Supplier<Item> {
        return register(id) {
            StandingAndWallBlockItem(
                standingBlock.get(),
                wallBlock.get(),
                Item.Properties(),
                direction
            )
        }
    }
}
