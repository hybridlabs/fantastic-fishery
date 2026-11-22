package dev.hybridlabs.fantasticfishery.data.server.worldgen

import dev.hybridlabs.fantasticfishery.world.gen.biome.FFBiomes
import dev.worldgen.lithostitched.api.registry.LithostitchedRegistries
import java.util.concurrent.CompletableFuture
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries

/**
 * Writes the Lithostitched biome injectors and worldgen modifiers, plus the material rule they reference.
 */
class BiomeInjectorProvider(
    output: FabricPackOutput,
    registriesFuture: CompletableFuture<HolderLookup.Provider>,
) : FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun configure(
        registries: HolderLookup.Provider,
        entries: Entries,
    ) {
        entries.add(registries.lookupOrThrow(Registries.MATERIAL_RULE).getOrThrow(FFBiomes.OVERWORLD_MATERIAL_RULE))
        entries.addAll(registries.lookupOrThrow(LithostitchedRegistries.BIOME_INJECTOR))
        entries.addAll(registries.lookupOrThrow(LithostitchedRegistries.WORLDGEN_MODIFIER))
    }

    override fun getName(): String {
        return "Biome Injectors"
    }
}
