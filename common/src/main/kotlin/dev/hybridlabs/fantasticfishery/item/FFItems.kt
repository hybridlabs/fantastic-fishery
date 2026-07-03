package dev.hybridlabs.fantasticfishery.item

import dev.hybridlabs.fantasticfishery.platform.Services.PLATFORM
import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.Mob
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import net.minecraft.world.item.MobBucketItem
import net.minecraft.world.item.SpawnEggItem
import net.minecraft.world.level.material.Fluids
import java.util.function.Supplier

object FFItems {

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
}
