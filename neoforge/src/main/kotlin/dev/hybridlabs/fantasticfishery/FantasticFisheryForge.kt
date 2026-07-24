package dev.hybridlabs.fantasticfishery
import dev.hybridlabs.fantasticfishery.block.FFBlocks
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.entity.ForgeSpawnGroupRegistry
import dev.hybridlabs.fantasticfishery.forge.FantasticFisheryModBusEvents
import dev.hybridlabs.fantasticfishery.item.FFItemGroups
import dev.hybridlabs.fantasticfishery.item.FFItems
import dev.hybridlabs.fantasticfishery.tag.FFBiomeTags
import dev.hybridlabs.fantasticfishery.tag.FFBlockTags
import dev.hybridlabs.fantasticfishery.tag.FFEntityTags
import dev.hybridlabs.fantasticfishery.tag.FFItemTags
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFConfiguredFeatures
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFFeatures
import dev.hybridlabs.fantasticfishery.world.gen.feature.FFPlacedFeatures
import net.minecraftforge.fml.common.Mod

/**
 * Main mod class. Should be an `object` declaration annotated with `@Mod`.
 * The modid should be declared in this object and should match the modId entry
 * in mods.toml.
 *
 * An example for blocks is in the `blocks` package of this mod.
 */
@Suppress("UnusedExpression")
@Mod(Constants.MOD_ID)
object FantasticFisheryForge {

    init {
        FantasticFisheryCommon.init()

        ForgeSpawnGroupRegistry.createFantasticFisherySpawnGroups()

        FFBlocks
        FFEntityTypes

        FFItems
        FFItemGroups

        FFBlockTags
        FFEntityTags
        FFItemTags
        FFBiomeTags

        FFFeatures
        FFPlacedFeatures
        FFConfiguredFeatures

        FantasticFisheryModBusEvents
    }
}
