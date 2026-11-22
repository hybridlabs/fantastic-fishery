package dev.hybridlabs.fantasticfishery.data.server

import dev.hybridlabs.fantasticfishery.item.FFItems
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.advancements.triggers.InventoryChangeTrigger
import net.minecraft.advancements.Advancement
import net.minecraft.core.HolderLookup
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.world.item.crafting.Recipe
import net.minecraft.data.recipes.RecipeProvider as VanillaRecipeProvider
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.ShapelessRecipeBuilder
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.CampfireCookingRecipe
import net.minecraft.world.item.crafting.CookingBookCategory
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.item.crafting.SmeltingRecipe
import net.minecraft.world.item.crafting.SmokingRecipe
import java.util.concurrent.CompletableFuture

class RecipeProvider(output: FabricPackOutput, lookupProvider: CompletableFuture<HolderLookup.Provider>) :
    FabricRecipeProvider(output, lookupProvider) {

    override fun createRecipeProvider(
        registries: HolderLookup.Provider,
        recipes: BootstrapContext<Recipe<*>>,
        advancements: BootstrapContext<Advancement>,
    ): VanillaRecipeProvider = GeneratedRecipes(recipes, advancements)

    override fun getName(): String = "Recipes"

    private class GeneratedRecipes(
        recipes: BootstrapContext<Recipe<*>>,
        advancements: BootstrapContext<Advancement>,
    ) : VanillaRecipeProvider(recipes, advancements) {
        private val itemLookup = recipes.lookup(net.minecraft.core.registries.Registries.ITEM)

    override fun buildRecipes() {
        val exporter = this.output
        //#region Sandstone Block Recipes
        stairBuilder(
            FFItems.MYCELIAL_SANDSTONE_STAIRS.get(),
            Ingredient.of(FFItems.MYCELIAL_SANDSTONE.get())
        ).unlockedBy(getHasName(FFItems.MYCELIAL_SANDSTONE.get()), has(FFItems.MYCELIAL_SANDSTONE.get())).save(exporter)

        stairBuilder(
            FFItems.SMOOTH_MYCELIAL_SANDSTONE_STAIRS.get(),
            Ingredient.of(FFItems.SMOOTH_MYCELIAL_SANDSTONE.get())
        ).unlockedBy(getHasName(FFItems.SMOOTH_MYCELIAL_SANDSTONE.get()), has(FFItems.SMOOTH_MYCELIAL_SANDSTONE.get())).save(exporter)

        slab(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        slab(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.CUT_MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.CUT_MYCELIAL_SANDSTONE.get()
        )

        slab(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.SMOOTH_MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.SMOOTH_MYCELIAL_SANDSTONE.get()
        )

        chiseled(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.CHISELED_MYCELIAL_SANDSTONE.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.MYCELIAL_SANDSTONE.get(),
            2
        )

        stonecutterResultFromBase(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.CUT_MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.CUT_MYCELIAL_SANDSTONE.get(),
            2
        )

        stonecutterResultFromBase(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.SMOOTH_MYCELIAL_SANDSTONE_SLAB.get(),
            FFItems.SMOOTH_MYCELIAL_SANDSTONE.get(),
            2
        )

        stonecutterResultFromBase(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.MYCELIAL_SANDSTONE_STAIRS.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.SMOOTH_MYCELIAL_SANDSTONE_STAIRS.get(),
            FFItems.SMOOTH_MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.MYCELIAL_SANDSTONE_WALL.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.CHISELED_MYCELIAL_SANDSTONE.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.SMOOTH_MYCELIAL_SANDSTONE.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        stonecutterResultFromBase(
            RecipeCategory.BUILDING_BLOCKS,
            FFItems.CUT_MYCELIAL_SANDSTONE.get(),
            FFItems.MYCELIAL_SANDSTONE.get()
        )

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(FFItems.MYCELIAL_SAND.get()), RecipeCategory.FOOD, CookingBookCategory.FOOD, Items.GLASS, 0.15f, 200).unlockedBy("has_material", has(FFItems.MYCELIAL_SAND.get())).save(exporter, "glass_from_smelting_mycelial_sand")

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(FFItems.MORSEL.get()), RecipeCategory.FOOD, CookingBookCategory.FOOD, FFItems.MORSEL_BAR.get(), 0.15f, 600).unlockedBy("has_material", has(FFItems.MORSEL.get())).save(exporter, "morsel_bar_from_smelting")

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(FFItems.MORSEL.get()), RecipeCategory.FOOD, FFItems.MORSEL_BAR.get(), 0.15f, 300).unlockedBy("has_material", has(FFItems.MORSEL.get())).save(exporter, "morsel_bar_from_smoking")

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(FFItems.MORSEL.get()), RecipeCategory.FOOD, FFItems.MORSEL_BAR.get(), 0.15f, 600).unlockedBy("has_material", has(FFItems.MORSEL.get())).save(exporter, "morsel_bar_from_campfire_cooking")

        ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, FFItems.STAR_DONUT.get())
            .requires(FFItems.PLUNDERERS_CORE.get())
            .requires(Items.WHEAT)
            .requires(Items.EGG)
            .unlockedBy(
                "has_plunderers_core",
                InventoryChangeTrigger.TriggerInstance.hasItems(FFItems.PLUNDERERS_CORE.get())
            )
            .save(exporter)

        ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.FOOD, FFItems.MORSEL_POP.get())
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

        ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.BUILDING_BLOCKS, FFItems.RED_SHROOMPAD.get(), 4)
            .pattern("RR")
            .define('R', Items.RED_MUSHROOM_BLOCK)
            .unlockedBy("has_red_mushroom_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RED_MUSHROOM_BLOCK))
            .save(exporter)

        ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.BUILDING_BLOCKS, FFItems.BROWN_SHROOMPAD.get(), 4)
            .pattern("BB")
            .define('B', Items.BROWN_MUSHROOM_BLOCK)
            .unlockedBy("has_brown_mushroom_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BROWN_MUSHROOM_BLOCK))
            .save(exporter)
    }
    }
}
