package dev.hybridlabs.fantasticfishery.data.server.tag

import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.tag.FFEntityTags
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider
import net.minecraft.core.HolderLookup
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.EntityTypeTags
import net.minecraft.world.entity.EntityType
import java.util.concurrent.CompletableFuture

class EntityTypeTagProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagsProvider.EntityTypeTagsProvider(output, registriesFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        builder(FFEntityTags.SMALL_CREATURES)
            .add(
                FFEntityTypes.MORSEL.get().builtInRegistryHolder().key(),
                FFEntityTypes.PLUNDERERS_HOOP.get().builtInRegistryHolder().key(),
                FFEntityTypes.FRIGID_VESSEL.get().builtInRegistryHolder().key(),
                FFEntityTypes.FUNGILL.get().builtInRegistryHolder().key(),
                FFEntityTypes.BLOOD_EEL.get().builtInRegistryHolder().key(),
            )

        builder(FFEntityTags.MEDIUM_CREATURES)
            .add(
                FFEntityTypes.POROUS_SHELL.get().builtInRegistryHolder().key(),
            )

        builder(FFEntityTags.ALL_FISH)
            .add(
                FFEntityTypes.MORSEL.get().builtInRegistryHolder().key(),
                FFEntityTypes.PLUNDERERS_HOOP.get().builtInRegistryHolder().key(),
                FFEntityTypes.FRIGID_VESSEL.get().builtInRegistryHolder().key(),
                FFEntityTypes.FUNGILL.get().builtInRegistryHolder().key(),
                FFEntityTypes.BLOOD_EEL.get().builtInRegistryHolder().key(),
                FFEntityTypes.POROUS_SHELL.get().builtInRegistryHolder().key(),
            )

        builder(EntityTypeTags.CAN_BREATHE_UNDER_WATER)
            .add(
                FFEntityTypes.MORSEL.get().builtInRegistryHolder().key(),
                FFEntityTypes.PLUNDERERS_HOOP.get().builtInRegistryHolder().key(),
                FFEntityTypes.FRIGID_VESSEL.get().builtInRegistryHolder().key(),
                FFEntityTypes.FUNGILL.get().builtInRegistryHolder().key(),
                FFEntityTypes.BLOOD_EEL.get().builtInRegistryHolder().key(),
                FFEntityTypes.POROUS_SHELL.get().builtInRegistryHolder().key(),
            )

        builder(FFEntityTags.ALL_JELLYFISH)
            .add(
                FFEntityTypes.JELLYSHROOM.get().builtInRegistryHolder().key(),
            )
    }

}
