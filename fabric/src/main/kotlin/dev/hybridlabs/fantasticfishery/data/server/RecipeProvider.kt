package dev.hybridlabs.fantasticfishery.data.server

import dev.hybridlabs.aquatic.item.HAItems
import dev.hybridlabs.fantasticfishery.item.FFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.advancements.critereon.InventoryChangeTrigger
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.ShapelessRecipeBuilder
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.item.crafting.SmeltingRecipe
import java.util.function.Consumer

class RecipeProvider(output: FabricDataOutput) : FabricRecipeProvider(output) {

    override fun buildRecipes(exporter: Consumer<FinishedRecipe>) {
        //#region Sandstone Block Recipes
        stairBuilder(
            FFItems.MYCELIAL_SANDSTONE_STAIRS.get(),
            Ingredient.of(FFItems.MYCELIAL_SANDSTONE.get())
        )

        stairBuilder(
            FFItems.SMOOTH_MYCELIAL_SANDSTONE_STAIRS.get(),
            Ingredient.of(FFItems.SMOOTH_MYCELIAL_SANDSTONE.get())
        )

        slab(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        slab(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.CUT_MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.CUT_MYCELIAL_SANDSTONE.get()
        )

        slab(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.SMOOTH_MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.SMOOTH_MYCELIAL_SANDSTONE.get()
        )

        chiseled(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.CHISELED_MYCELIAL_SANDSTONE.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.MYCELIAL_SANDSTONE.get(),
            2
        )

        stonecutterResultFromBase(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.CUT_MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.CUT_MYCELIAL_SANDSTONE.get(),
            2
        )

        stonecutterResultFromBase(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.SMOOTH_MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.SMOOTH_MYCELIAL_SANDSTONE.get(),
            2
        )

        stonecutterResultFromBase(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.MYCELIAL_SANDSTONE_STAIRS.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.SMOOTH_MYCELIAL_SANDSTONE_STAIRS.get(),
            FFItems.SMOOTH_MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.MYCELIAL_SANDSTONE_WALL.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.CHISELED_MYCELIAL_SANDSTONE.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.SMOOTH_MYCELIAL_SANDSTONE.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            exporter,
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.CUT_MYCELIAL_SANDSTONE.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        simpleCookingRecipe(
            exporter,
            "smelting_mycelial_sand",
            RecipeSerializer.SMELTING_RECIPE,
            200,
            FFItems.MYCELIAL_SAND.get(),
            Items.GLASS,
            0.15f
        )

        simpleCookingRecipe(
            exporter,
            "smelting",
            RecipeSerializer.SMELTING_RECIPE,
            600,
            FFItems.MORSEL.get(),
            FFItems.MORSEL_BAR.get(),
            0.15f
        )

        simpleCookingRecipe(
            exporter,
            "smoking",
            RecipeSerializer.SMOKING_RECIPE,
            300,
            FFItems.MORSEL.get(),
            FFItems.MORSEL_BAR.get(),
            0.15f
        )

        simpleCookingRecipe(
            exporter,
            "campfire_cooking",
            RecipeSerializer.CAMPFIRE_COOKING_RECIPE,
            600,
            FFItems.MORSEL.get(),
            FFItems.MORSEL_BAR.get(),
            0.15f
        )

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FFItems.STAR_DONUT.get())
            .requires(FFItems.PLUNDERERS_CORE.get())
            .requires(Items.WHEAT)
            .requires(Items.EGG)
            .unlockedBy(
                "has_plunderers_core",
                InventoryChangeTrigger.TriggerInstance.hasItems(FFItems.PLUNDERERS_CORE.get())
            )
            .save(exporter)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FFItems.MORSEL_POP.get())
            .requires(FFItems.MORSEL_BAR.get())
            .requires(Items.STICK)
            .unlockedBy(
                "has_morsel_bar",
                InventoryChangeTrigger.TriggerInstance.hasItems(FFItems.MORSEL_BAR.get())
            )
            .unlockedBy(
                "has_morsel",
                InventoryChangeTrigger.TriggerInstance.hasItems(FFItems.MORSEL.get())
            )
            .save(exporter)

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FFItems.RED_SHROOMPAD.get(), 4)
            .pattern("RR")
            .define('R', Items.RED_MUSHROOM_BLOCK)
            .unlockedBy("has_red_mushroom_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RED_MUSHROOM_BLOCK))
            .save(exporter)

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FFItems.BROWN_SHROOMPAD.get(), 4)
            .pattern("BB")
            .define('B', Items.BROWN_MUSHROOM_BLOCK)
            .unlockedBy("has_brown_mushroom_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BROWN_MUSHROOM_BLOCK))
            .save(exporter)
    }
}