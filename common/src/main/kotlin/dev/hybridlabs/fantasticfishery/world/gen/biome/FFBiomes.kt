package dev.hybridlabs.fantasticfishery.world.gen.biome

import com.terraformersmc.biolith.api.biome.BiomePlacement
import com.terraformersmc.biolith.api.biome.sub.BiomeParameterTargets
import com.terraformersmc.biolith.api.biome.sub.CriterionBuilder
import com.terraformersmc.biolith.api.surface.RuleSourceBootstrapper
import com.terraformersmc.biolith.api.surface.SurfaceGeneration
import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.block.FFBlocks
import net.minecraft.core.HolderGetter
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.Identifier
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.levelgen.SurfaceRules.*

object FFBiomes {
    val FUNGAL_SEA: ResourceKey<Biome> = ResourceKey.create(Registries.BIOME, FantasticFisheryCommon.locate("fungal_sea"))
    val FUNGAL_SEA_SURFACE_RULE: (HolderGetter<Biome>) -> RuleSource = { biomeGetter ->
        ifTrue(
            isBiome(biomeGetter, FUNGAL_SEA),
            sequence(
                ifTrue(ON_FLOOR,
                    state(FFBlocks.MYCELIAL_SAND.get().defaultBlockState())
                ),
                ifTrue(UNDER_FLOOR, state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState())),
                ifTrue(DEEP_UNDER_FLOOR, state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState()))
            )
        )
    }

    val MUSHROOM_FIELDS_SHORE: ResourceKey<Biome> = ResourceKey.create(Registries.BIOME, FantasticFisheryCommon.locate("mushroom_fields_shore"))
    val MUSHROOM_FIELDS_SHORE_SURFACE_RULE: (HolderGetter<Biome>) -> RuleSource = { biomeGetter ->
        ifTrue(
            isBiome(biomeGetter, MUSHROOM_FIELDS_SHORE),
            sequence(
                ifTrue(ON_FLOOR,
                    state(FFBlocks.MYCELIAL_SAND.get().defaultBlockState())
                ),
                ifTrue(UNDER_FLOOR, state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState())),
                ifTrue(DEEP_UNDER_FLOOR, state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState()))
            )
        )
    }

    fun addBiomes() {
        BiomePlacement.addSubOverworld(
            Biomes.DEEP_FROZEN_OCEAN,
            FUNGAL_SEA,
            CriterionBuilder.allOf(
                CriterionBuilder.neighbor(Biomes.MUSHROOM_FIELDS),
                CriterionBuilder.value(
                    BiomeParameterTargets.CONTINENTALNESS,
                    -1.05f,
                    -0.085f,
                )
            )
        )
        BiomePlacement.addSubOverworld(
            Biomes.DEEP_COLD_OCEAN,
            FUNGAL_SEA,
            CriterionBuilder.allOf(
                CriterionBuilder.neighbor(Biomes.MUSHROOM_FIELDS),
                CriterionBuilder.value(
                    BiomeParameterTargets.CONTINENTALNESS,
                    -1.05f,
                    -0.085f,
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.DEEP_OCEAN,
            FUNGAL_SEA,
            CriterionBuilder.allOf(
                CriterionBuilder.neighbor(Biomes.MUSHROOM_FIELDS),
                CriterionBuilder.value(
                    BiomeParameterTargets.CONTINENTALNESS,
                    -1.05f,
                    -0.085f,
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.DEEP_LUKEWARM_OCEAN,
            FUNGAL_SEA,
            CriterionBuilder.allOf(
                CriterionBuilder.neighbor(Biomes.MUSHROOM_FIELDS),
                CriterionBuilder.value(
                    BiomeParameterTargets.CONTINENTALNESS,
                    -1.05f,
                    -0.085f,
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.WARM_OCEAN,
            FUNGAL_SEA,
            CriterionBuilder.allOf(
                CriterionBuilder.neighbor(Biomes.MUSHROOM_FIELDS),
                CriterionBuilder.value(
                    BiomeParameterTargets.CONTINENTALNESS,
                    -1.05f,
                    -0.085f,
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.DEEP_FROZEN_OCEAN,
            FUNGAL_SEA,
            CriterionBuilder.allOf(
                CriterionBuilder.neighbor(MUSHROOM_FIELDS_SHORE),
                CriterionBuilder.value(
                    BiomeParameterTargets.CONTINENTALNESS,
                    -1.05f,
                    -0.085f,
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.DEEP_COLD_OCEAN,
            FUNGAL_SEA,
            CriterionBuilder.allOf(
                CriterionBuilder.neighbor(MUSHROOM_FIELDS_SHORE),
                CriterionBuilder.value(
                    BiomeParameterTargets.CONTINENTALNESS,
                    -1.05f,
                    -0.085f,
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.DEEP_OCEAN,
            FUNGAL_SEA,
            CriterionBuilder.allOf(
                CriterionBuilder.neighbor(MUSHROOM_FIELDS_SHORE),
                CriterionBuilder.value(
                    BiomeParameterTargets.CONTINENTALNESS,
                    -1.05f,
                    -0.085f,
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.DEEP_LUKEWARM_OCEAN,
            FUNGAL_SEA,
            CriterionBuilder.allOf(
                CriterionBuilder.neighbor(MUSHROOM_FIELDS_SHORE),
                CriterionBuilder.value(
                    BiomeParameterTargets.CONTINENTALNESS,
                    -1.05f,
                    -0.085f,
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.WARM_OCEAN,
            FUNGAL_SEA,
            CriterionBuilder.allOf(
                CriterionBuilder.neighbor(MUSHROOM_FIELDS_SHORE),
                CriterionBuilder.value(
                    BiomeParameterTargets.CONTINENTALNESS,
                    -1.05f,
                    -0.085f,
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.MUSHROOM_FIELDS,
            MUSHROOM_FIELDS_SHORE,
            CriterionBuilder.allOf(
                CriterionBuilder.value(
                    BiomeParameterTargets.CONTINENTALNESS,
                    -1.075f,
                    -1.05f,
                )
            )
        )

        //#region Surface Rule Generation
        SurfaceGeneration.addOverworldSurfaceRules(
            Identifier.fromNamespaceAndPath("fantastic_fishery", "rules/overworld"),
            RuleSourceBootstrapper { biomeGetter ->
                ifTrue(
                    abovePreliminarySurface(),
                    sequence(
                        FUNGAL_SEA_SURFACE_RULE(biomeGetter),
                        MUSHROOM_FIELDS_SHORE_SURFACE_RULE(biomeGetter),
                    )
                )
            }
        )
    }
}