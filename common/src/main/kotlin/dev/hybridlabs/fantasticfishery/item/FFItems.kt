package dev.hybridlabs.fantasticfishery.item

import dev.hybridlabs.fantasticfishery.platform.Services.PLATFORM
import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.Mob
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import net.minecraft.world.item.SpawnEggItem
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


    val OMPAX = register(
        "ompax",
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


    val BACKWARD_TROUT = register(
        "backward_trout",
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

    val CONSTELLATION_FISH = register(
        "constellation_fish",
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
                        .saturationMod(0.2F)
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

    val ROTTEN_COD = register(
        "rotten_cod",
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

    val PLASMAFIN = register(
        "plasmafin",
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

    val HAWALANZA = register(
        "hawalanza",
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

    val CLUBHEAD = register(
        "clubhead",
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
    val PLUNDERERS_HOOP_SPAWN_EGG =
        registerSpawnEgg("plunderers_hoop_spawn_egg", FFEntityTypes.PLUNDERERS_HOOP, 0xFFFFFF, 0xFFFFFF)


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
