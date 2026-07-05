package dev.hybridlabs.fantasticfishery.item

import dev.hybridlabs.aquatic.item.PlaceableInWaterItem
import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.platform.Services.PLATFORM
import net.minecraft.core.Direction
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.Mob
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.*
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.Fluids
import java.util.function.Supplier

object FFItems {

    val RED_FLOATING_CAP = registerPlaceableInWaterBlockItem("red_shroompad") { FFBlocks.RED_SHROOMPAD.get() }
    val BROWN_FLOATING_CAP = registerPlaceableInWaterBlockItem("brown_shroompad") { FFBlocks.BROWN_SHROOMPAD.get() }
    
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
    
    val AMETHYST_FUNGUS_BLOCK =
        registerBlockItem("amethyst_fungus_block") { FFBlocks.AMETHYST_FUNGUS_BLOCK.get() }
    val DRIED_AMETHYST_FUNGUS_BLOCK =
        registerBlockItem("dried_amethyst_fungus_block") { FFBlocks.DRIED_AMETHYST_FUNGUS_BLOCK.get() }
    val AMETHYST_FUNGUS = registerBlockItem("amethyst_fungus") { FFBlocks.AMETHYST_FUNGUS.get() }
    val DRIED_AMETHYST_FUNGUS = registerBlockItem("dried_amethyst_fungus") { FFBlocks.DRIED_AMETHYST_FUNGUS.get() }
    val AMETHYST_FUNGUS_FAN = registerVerticallyAttachable(
        "amethyst_fungus_fan",
        FFBlocks.AMETHYST_FUNGUS_FAN,
        FFBlocks.AMETHYST_FUNGUS_WALL_FAN
    )
    val DRIED_AMETHYST_FUNGUS_FAN = registerVerticallyAttachable(
        "dried_amethyst_fungus_fan",
        FFBlocks.DRIED_AMETHYST_FUNGUS_FAN,
        FFBlocks.DRIED_AMETHYST_FUNGUS_WALL_FAN
    )
    
    val OYSTER_FUNGUS_BLOCK =
        registerBlockItem("oyster_fungus_block") { FFBlocks.OYSTER_FUNGUS_BLOCK.get() }
    val DRIED_OYSTER_FUNGUS_BLOCK =
        registerBlockItem("dried_oyster_fungus_block") { FFBlocks.DRIED_OYSTER_FUNGUS_BLOCK.get() }
    val OYSTER_FUNGUS = registerBlockItem("oyster_fungus") { FFBlocks.OYSTER_FUNGUS.get() }
    val DRIED_OYSTER_FUNGUS = registerBlockItem("dried_oyster_fungus") { FFBlocks.DRIED_OYSTER_FUNGUS.get() }
    val OYSTER_FUNGUS_FAN = registerVerticallyAttachable(
        "oyster_fungus_fan",
        FFBlocks.OYSTER_FUNGUS_FAN,
        FFBlocks.OYSTER_FUNGUS_WALL_FAN
    )
    val DRIED_OYSTER_FUNGUS_FAN = registerVerticallyAttachable(
        "dried_oyster_fungus_fan",
        FFBlocks.DRIED_OYSTER_FUNGUS_FAN,
        FFBlocks.DRIED_OYSTER_FUNGUS_WALL_FAN
    )
    
    val CHICKEN_FUNGUS_BLOCK =
        registerBlockItem("chicken_fungus_block") { FFBlocks.CHICKEN_FUNGUS_BLOCK.get() }
    val DRIED_CHICKEN_FUNGUS_BLOCK =
        registerBlockItem("dried_chicken_fungus_block") { FFBlocks.DRIED_CHICKEN_FUNGUS_BLOCK.get() }
    val CHICKEN_FUNGUS = registerBlockItem("chicken_fungus") { FFBlocks.CHICKEN_FUNGUS.get() }
    val DRIED_CHICKEN_FUNGUS = registerBlockItem("dried_chicken_fungus") { FFBlocks.DRIED_CHICKEN_FUNGUS.get() }
    val CHICKEN_FUNGUS_FAN = registerVerticallyAttachable(
        "chicken_fungus_fan",
        FFBlocks.CHICKEN_FUNGUS_FAN,
        FFBlocks.CHICKEN_FUNGUS_WALL_FAN
    )
    val DRIED_CHICKEN_FUNGUS_FAN = registerVerticallyAttachable(
        "dried_chicken_fungus_fan",
        FFBlocks.DRIED_CHICKEN_FUNGUS_FAN,
        FFBlocks.DRIED_CHICKEN_FUNGUS_WALL_FAN
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
        Item(
            Item.Properties()
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

    val MORSEL_BUCKET = register(
        "morsel_bucket",
    ) {
        MobBucketItem(
            FFEntityTypes.MORSEL.get(),
            Fluids.WATER,
            SoundEvents.BUCKET_EMPTY_FISH,
            Item.Properties()
                .stacksTo(1)
        )
    }

    val PLUNDERERS_HOOP_BUCKET = register(
        "plunderers_hoop_bucket",
    ) {
        MobBucketItem(
            FFEntityTypes.PLUNDERERS_HOOP.get(),
            Fluids.WATER,
            SoundEvents.BUCKET_EMPTY_FISH,
            Item.Properties()
                .stacksTo(1)
        )
    }

    val FUNGILL_SPAWN_EGG =
        registerSpawnEgg("fungill_spawn_egg", FFEntityTypes.FUNGILL, 0xFFFFFF, 0xFFFFFF)
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
