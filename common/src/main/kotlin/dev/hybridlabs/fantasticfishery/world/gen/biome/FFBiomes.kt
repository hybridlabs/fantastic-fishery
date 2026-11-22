package dev.hybridlabs.fantasticfishery.world.gen.biome

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.worldgen.lithostitched.api.registry.LithostitchedRegistries
import dev.worldgen.lithostitched.api.util.InjectionType
import dev.worldgen.lithostitched.api.worldgen.biomeinjector.BiomeInjector
import dev.worldgen.lithostitched.api.worldgen.biomeinjector.BiomeInjector.ClimateParameter
import dev.worldgen.lithostitched.api.worldgen.biomeinjector.ParameterBuilder
import dev.worldgen.lithostitched.api.worldgen.modifier.WorldgenModifier
import net.minecraft.core.HolderGetter
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.Level
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.levelgen.material.MaterialRules.abovePreliminarySurface
import net.minecraft.world.level.levelgen.material.MaterialRules.ifTrue
import net.minecraft.world.level.levelgen.material.MaterialRules.isBiome
import net.minecraft.world.level.levelgen.material.MaterialRules.sequence
import net.minecraft.world.level.levelgen.material.MaterialRules.state
import net.minecraft.world.level.levelgen.material.MaterialRules.stoneDepthCheck
import net.minecraft.world.level.levelgen.material.rule.MaterialRule
import net.minecraft.world.level.levelgen.placement.CaveSurface

object FFBiomes {
    val FUNGAL_SEA: ResourceKey<Biome> = ResourceKey.create(Registries.BIOME, FantasticFisheryCommon.locate("fungal_sea"))
    val MUSHROOM_FIELDS_SHORE: ResourceKey<Biome> = ResourceKey.create(Registries.BIOME, FantasticFisheryCommon.locate("mushroom_fields_shore"))

    val FUNGAL_SEA_INJECTOR: ResourceKey<BiomeInjector> =
        ResourceKey.create(LithostitchedRegistries.BIOME_INJECTOR, FantasticFisheryCommon.locate("fungal_sea"))
    val MUSHROOM_FIELDS_SHORE_INJECTOR: ResourceKey<BiomeInjector> =
        ResourceKey.create(LithostitchedRegistries.BIOME_INJECTOR, FantasticFisheryCommon.locate("mushroom_fields_shore"))

    val OVERWORLD_MATERIAL_RULE: ResourceKey<MaterialRule> =
        ResourceKey.create(Registries.MATERIAL_RULE, FantasticFisheryCommon.locate("overworld"))
    val OVERWORLD_SURFACE_MODIFIER: ResourceKey<WorldgenModifier> =
        ResourceKey.create(LithostitchedRegistries.WORLDGEN_MODIFIER, FantasticFisheryCommon.locate("overworld_surface"))

    private val VANILLA_OVERWORLD_MATERIAL_RULE: ResourceKey<MaterialRule> =
        ResourceKey.create(Registries.MATERIAL_RULE, Identifier.fromNamespaceAndPath("minecraft", "overworld"))

    /**
     * Registers the Lithostitched biome injectors that place our biomes.
     *
     * Biome placements used to go through Biolith, whose `neighbor` criterion (Fungal Sea only next to Mushroom
     * Fields) has no Lithostitched equivalent. Lithostitched injectors only sample the climate at the sampled
     * position, so that adjacency is approximated by narrowing Fungal Sea to the deep-ocean continentalness band
     * that borders Mushroom Fields' own band.
     *
     * Vanilla climate bands (26.3):
     *  - Mushroom Fields:              continentalness [-1.2, -1.05]
     *  - Mushroom Fields Shore (ours): continentalness [-1.075, -1.05]  (outer edge of the island)
     *  - Fungal Sea (ours):            continentalness [-1.05, -1.0]    (deep ocean just off the island)
     */
    fun bootstrapBiomeInjectors(context: BootstrapContext<BiomeInjector>) {
        val biomes = context.lookup(Registries.BIOME)

        context.register(
            MUSHROOM_FIELDS_SHORE_INJECTOR,
            BiomeInjector.builder(Level.OVERWORLD).replacePartially(
                biomes.getOrThrow(Biomes.MUSHROOM_FIELDS),
                biomes.getOrThrow(MUSHROOM_FIELDS_SHORE),
                ParameterBuilder.create().climateRange(ClimateParameter.CONTINENTALNESS, -1.075f, -1.05f),
            )
        )

        val fungalSeaTargets: HolderSet<Biome> = HolderSet.direct(
            biomes.getOrThrow(Biomes.DEEP_FROZEN_OCEAN),
            biomes.getOrThrow(Biomes.DEEP_COLD_OCEAN),
            biomes.getOrThrow(Biomes.DEEP_OCEAN),
            biomes.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN),
            biomes.getOrThrow(Biomes.WARM_OCEAN),
        )
        context.register(
            FUNGAL_SEA_INJECTOR,
            BiomeInjector.builder(Level.OVERWORLD).replacePartially(
                fungalSeaTargets,
                biomes.getOrThrow(FUNGAL_SEA),
                ParameterBuilder.create().climateRange(ClimateParameter.CONTINENTALNESS, -1.05f, -1.0f),
            )
        )
    }

    /**
     * Registers the material rule that gives Fungal Sea and Mushroom Fields Shore their mycelial sand surface.
     */
    fun bootstrapMaterialRules(context: BootstrapContext<MaterialRule>) {
        val biomes = context.lookup(Registries.BIOME)
        context.register(
            OVERWORLD_MATERIAL_RULE,
            ifTrue(
                abovePreliminarySurface(),
                sequence(
                    fungalSeaSurfaceRule(biomes),
                    mushroomFieldsShoreSurfaceRule(biomes),
                )
            )
        )
    }

    /**
     * Prepends our material rule to the vanilla overworld material rule so it runs before the default surface.
     */
    fun bootstrapWorldgenModifiers(context: BootstrapContext<WorldgenModifier>) {
        val materialRules = context.lookup(Registries.MATERIAL_RULE)
        context.register(
            OVERWORLD_SURFACE_MODIFIER,
            WorldgenModifier.builder().setMaterialRule(
                materialRules.getOrThrow(VANILLA_OVERWORLD_MATERIAL_RULE),
                materialRules.getOrThrow(OVERWORLD_MATERIAL_RULE),
                InjectionType.PREPEND,
            )
        )
    }

    private fun fungalSeaSurfaceRule(biomes: HolderGetter<Biome>): MaterialRule = ifTrue(
        isBiome(biomes, FUNGAL_SEA),
        sequence(
            ifTrue(stoneDepthCheck(0, false, CaveSurface.FLOOR), state(FFBlocks.MYCELIAL_SAND.get().defaultBlockState())),
            ifTrue(stoneDepthCheck(0, true, CaveSurface.FLOOR), state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState())),
            ifTrue(stoneDepthCheck(0, true, 6, CaveSurface.FLOOR), state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState())),
        )
    )

    private fun mushroomFieldsShoreSurfaceRule(biomes: HolderGetter<Biome>): MaterialRule = ifTrue(
        isBiome(biomes, MUSHROOM_FIELDS_SHORE),
        sequence(
            ifTrue(stoneDepthCheck(0, false, CaveSurface.FLOOR), state(FFBlocks.MYCELIAL_SAND.get().defaultBlockState())),
            ifTrue(stoneDepthCheck(0, true, CaveSurface.FLOOR), state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState())),
            ifTrue(stoneDepthCheck(0, true, 6, CaveSurface.FLOOR), state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState())),
        )
    )
}
