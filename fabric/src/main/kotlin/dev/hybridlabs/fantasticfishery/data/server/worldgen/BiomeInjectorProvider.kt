package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.worldgen.lithostitched.api.registry.LithostitchedRegistries
import java.util.concurrent.CompletableFuture
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup

/**
 * Writes the Lithostitched biome injectors and worldgen modifiers that place our biomes and give them their surface.
 */
class BiomeInjectorProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<HolderLookup.Provider>,
) : FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun configure(
        registries: HolderLookup.Provider,
        entries: Entries,
    ) {
        entries.addAll(registries.lookupOrThrow(LithostitchedRegistries.BIOME_INJECTOR))
        entries.addAll(registries.lookupOrThrow(LithostitchedRegistries.WORLDGEN_MODIFIER))
    }

    override fun getName(): String {
        return "Biome Injectors"
    }
}
