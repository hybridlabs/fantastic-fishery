package dev.hybridlabs.fantasticfishery.world.gen.biome

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.worldgen.lithostitched.api.registry.LithostitchedRegistries
import dev.worldgen.lithostitched.api.util.InjectionType
import dev.worldgen.lithostitched.api.worldgen.biomeinjector.BiomeInjector
import dev.worldgen.lithostitched.api.worldgen.biomeinjector.BiomeInjector.ClimateParameter
import dev.worldgen.lithostitched.api.worldgen.biomeinjector.ParameterBuilder
import dev.worldgen.lithostitched.api.worldgen.modifier.WorldgenModifier
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.Level
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.dimension.LevelStem
import net.minecraft.world.level.levelgen.SurfaceRules.*

object FFBiomes {
    val FUNGAL_SEA: ResourceKey<Biome> = ResourceKey.create(Registries.BIOME, FantasticFisheryCommon.locate("fungal_sea"))
    val MUSHROOM_FIELDS_SHORE: ResourceKey<Biome> = ResourceKey.create(Registries.BIOME, FantasticFisheryCommon.locate("mushroom_fields_shore"))

    val FUNGAL_SEA_INJECTOR: ResourceKey<BiomeInjector> =
        ResourceKey.create(LithostitchedRegistries.BIOME_INJECTOR, FantasticFisheryCommon.locate("fungal_sea"))
    val MUSHROOM_FIELDS_SHORE_INJECTOR: ResourceKey<BiomeInjector> =
        ResourceKey.create(LithostitchedRegistries.BIOME_INJECTOR, FantasticFisheryCommon.locate("mushroom_fields_shore"))

    val OVERWORLD_SURFACE_MODIFIER: ResourceKey<WorldgenModifier> =
        ResourceKey.create(LithostitchedRegistries.WORLDGEN_MODIFIER, FantasticFisheryCommon.locate("overworld_surface"))

    /**
     * Registers the Lithostitched biome injectors that place our biomes.
     *
     * Biome placements used to go through Biolith, whose `neighbor` criterion (Fungal Sea only next to Mushroom
     * Fields) has no Lithostitched equivalent. Lithostitched injectors only sample the climate at the sampled
     * position, so that adjacency is approximated by narrowing Fungal Sea to the deep-ocean continentalness band
     * that borders Mushroom Fields' own band.
     *
     * Vanilla climate bands:
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
                ParameterBuilder.create().climateRange(ClimateParameter.CONTINENTALNESS, -1.075, -1.05),
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
                ParameterBuilder.create().climateRange(ClimateParameter.CONTINENTALNESS, -1.05, -1.0),
            )
        )
    }

    /**
     * Registers the surface rule that gives Fungal Sea and Mushroom Fields Shore their mycelial sand surface.
     */
    fun bootstrapWorldgenModifiers(context: BootstrapContext<WorldgenModifier>) {
        context.register(
            OVERWORLD_SURFACE_MODIFIER,
            WorldgenModifier.builder().addSurfaceRule(
                LevelStem.OVERWORLD,
                InjectionType.PREPEND,
                ifTrue(
                    abovePreliminarySurface(),
                    sequence(
                        surfaceRule(FUNGAL_SEA),
                        surfaceRule(MUSHROOM_FIELDS_SHORE),
                    )
                )
            )
        )
    }

    private fun surfaceRule(biome: ResourceKey<Biome>): RuleSource = ifTrue(
        isBiome(biome),
        sequence(
            ifTrue(ON_FLOOR, state(FFBlocks.MYCELIAL_SAND.get().defaultBlockState())),
            ifTrue(UNDER_FLOOR, state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState())),
            ifTrue(DEEP_UNDER_FLOOR, state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState())),
        )
    )
}
