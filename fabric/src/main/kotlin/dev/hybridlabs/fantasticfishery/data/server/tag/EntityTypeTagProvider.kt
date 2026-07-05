package dev.hybridlabs.fantasticfishery.data.server.tag

import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.tag.FFEntityTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import java.util.concurrent.CompletableFuture

class EntityTypeTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :
    FabricTagProvider.EntityTypeTagProvider(output, registriesFuture) {
    override fun addTags(arg: HolderLookup.Provider) {
        getOrCreateTagBuilder(FFEntityTags.SMALL_CREATURES)
            .add(
                FFEntityTypes.MORSEL.get(),
                FFEntityTypes.PLUNDERERS_HOOP.get(),
                FFEntityTypes.FRIGID_VESSEL.get(),
                FFEntityTypes.FUNGILL.get(),
                FFEntityTypes.BLOOD_EEL.get(),
            )

        getOrCreateTagBuilder(FFEntityTags.MEDIUM_CREATURES)
            .add(
                FFEntityTypes.POROUS_SHELL.get(),
            )

        getOrCreateTagBuilder(FFEntityTags.ALL_FISH)
            .add(
                FFEntityTypes.MORSEL.get(),
                FFEntityTypes.PLUNDERERS_HOOP.get(),
                FFEntityTypes.FRIGID_VESSEL.get(),
                FFEntityTypes.FUNGILL.get(),
                FFEntityTypes.BLOOD_EEL.get(),
                FFEntityTypes.POROUS_SHELL.get(),
            )
    }
}