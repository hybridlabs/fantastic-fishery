package dev.hybridlabs.fantasticfishery.world.gen.biome

import com.terraformersmc.biolith.api.biome.BiomePlacement
import com.terraformersmc.biolith.api.biome.SubBiomeMatcher
import com.terraformersmc.biolith.api.surface.SurfaceGeneration
import dev.hybridlabs.aquatic.world.gen.biome.HABiomes
import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.block.FFBlocks
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.levelgen.SurfaceRules.*

object FFBiomes {
    val FUNGAL_SEA: ResourceKey<Biome> = ResourceKey.create(Registries.BIOME, FantasticFisheryCommon.locate("fungal_sea"))
    val FUNGAL_SEA_SURFACE_RULE: RuleSource = ifTrue(
        isBiome(FUNGAL_SEA),
        sequence(
            ifTrue(ON_FLOOR,
                state(FFBlocks.MYCELIAL_SAND.get().defaultBlockState())
            ),
            ifTrue(UNDER_FLOOR, state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState())),
            ifTrue(DEEP_UNDER_FLOOR, state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState()))
        )
    )

    val MUSHROOM_FIELDS_SHORE: ResourceKey<Biome> = ResourceKey.create(Registries.BIOME, FantasticFisheryCommon.locate("mushroom_fields_shore"))
    val MUSHROOM_FIELDS_SHORE_SURFACE_RULE: RuleSource = ifTrue(
        isBiome(MUSHROOM_FIELDS_SHORE),
        sequence(
            ifTrue(ON_FLOOR,
                state(FFBlocks.MYCELIAL_SAND.get().defaultBlockState())
            ),
            ifTrue(UNDER_FLOOR, state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState())),
            ifTrue(DEEP_UNDER_FLOOR, state(FFBlocks.MYCELIAL_SANDSTONE.get().defaultBlockState()))
        )
    )

    fun addBiomes() {
        BiomePlacement.addSubOverworld(
            Biomes.DEEP_OCEAN,
            FUNGAL_SEA,
            SubBiomeMatcher.of(
                SubBiomeMatcher.Criterion.ofBiome(
                    SubBiomeMatcher.CriterionTargets.NEIGHBOR,
                    Biomes.MUSHROOM_FIELDS,
                    false
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.DEEP_LUKEWARM_OCEAN,
            FUNGAL_SEA,
            SubBiomeMatcher.of(
                SubBiomeMatcher.Criterion.ofBiome(
                    SubBiomeMatcher.CriterionTargets.NEIGHBOR,
                    Biomes.MUSHROOM_FIELDS,
                    false
                )
            )
        )

        BiomePlacement.addSubOverworld(
            HABiomes.DEEP_WARM_OCEAN,
            FUNGAL_SEA,
            SubBiomeMatcher.of(
                SubBiomeMatcher.Criterion.ofBiome(
                    SubBiomeMatcher.CriterionTargets.NEIGHBOR,
                    Biomes.MUSHROOM_FIELDS,
                    false
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.WARM_OCEAN,
            FUNGAL_SEA,
            SubBiomeMatcher.of(
                SubBiomeMatcher.Criterion.ofBiome(
                    SubBiomeMatcher.CriterionTargets.NEIGHBOR,
                    Biomes.MUSHROOM_FIELDS,
                    false
                )
            )
        )

        BiomePlacement.addSubOverworld(
            HABiomes.DEEP_CORAL_REEF,
            FUNGAL_SEA,
            SubBiomeMatcher.of(
                SubBiomeMatcher.Criterion.ofBiome(
                    SubBiomeMatcher.CriterionTargets.NEIGHBOR,
                    Biomes.MUSHROOM_FIELDS,
                    false
                )
            )
        )

        BiomePlacement.addSubOverworld(
            HABiomes.TROPICAL_DEEP_CORAL_REEF,
            FUNGAL_SEA,
            SubBiomeMatcher.of(
                SubBiomeMatcher.Criterion.ofBiome(
                    SubBiomeMatcher.CriterionTargets.NEIGHBOR,
                    Biomes.MUSHROOM_FIELDS,
                    false
                )
            )
        )

        BiomePlacement.addSubOverworld(
            Biomes.MUSHROOM_FIELDS,
            MUSHROOM_FIELDS_SHORE,
            SubBiomeMatcher.of(
                SubBiomeMatcher.Criterion.ofRange(
                    SubBiomeMatcher.CriterionTargets.CONTINENTALNESS,
                    SubBiomeMatcher.CriterionTypes.VALUE,
                    -1.075f,
                    -1.05f,
                    false
                )
            )
        )

        //#region Surface Rule Generation
        SurfaceGeneration.addOverworldSurfaceRules(
            ResourceLocation("fantastic_fishery", "rules/overworld"),
            ifTrue(
                abovePreliminarySurface(),
                sequence(
                    FUNGAL_SEA_SURFACE_RULE,
                    MUSHROOM_FIELDS_SHORE_SURFACE_RULE,
                )
            )
        )
    }
}