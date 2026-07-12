package dev.hybridlabs.fantasticfishery.data.server.loot

import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.item.FFItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider
import net.minecraft.advancements.critereon.EntityFlagsPredicate
import net.minecraft.advancements.critereon.EntityPredicate
import net.minecraft.core.HolderLookup
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.storage.loot.LootPool
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
import java.util.concurrent.CompletableFuture
import java.util.function.BiConsumer

/**
 * Generates entity loot tables.
 */
class EntityTypeLootTableProvider(exporter: FabricDataOutput, val lookupProvider: CompletableFuture<HolderLookup.Provider>) :
    SimpleFabricLootTableProvider(exporter, lookupProvider, LootContextParamSets.ENTITY) {
    override fun generate(exporter: BiConsumer<ResourceKey<LootTable>, LootTable.Builder>) {
        val lookup = lookupProvider.join()
        export(exporter, FFEntityTypes.MORSEL.get().defaultLootTable) {
            pool(
                LootPool.lootPool()
                    .add(
                        LootItem.lootTableItem(FFItems.MORSEL.get())
                            .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookup,UniformGenerator.between(0.0F, 1.0F)))
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                    ).build()
            )
        }

        export(exporter, FFEntityTypes.PLUNDERERS_HOOP.get().defaultLootTable) {
            pool(
                LootPool.lootPool()
                    .add(
                        LootItem.lootTableItem(FFItems.PLUNDERERS_HOOP.get())
                            .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookup,UniformGenerator.between(0.0F, 1.0F)))
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                    ).build()
            )
        }

        export(exporter, FFEntityTypes.FRIGID_VESSEL.get().defaultLootTable) {
            pool(
                LootPool.lootPool()
                    .add(
                        LootItem.lootTableItem(FFItems.FRIGID_VESSEL.get())
                            .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookup,UniformGenerator.between(0.0F, 1.0F)))
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                    ).build()
            )
        }

        export(exporter, FFEntityTypes.BLOOD_EEL.get().defaultLootTable) {
            pool(
                LootPool.lootPool()
                    .add(
                        LootItem.lootTableItem(FFItems.BLOOD_EEL.get())
                            .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookup,UniformGenerator.between(0.0F, 1.0F)))
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                    ).build()
            )
        }

        export(exporter, FFEntityTypes.POROUS_SHELL.get().defaultLootTable) {
            pool(
                LootPool.lootPool()
                    .add(
                        LootItem.lootTableItem(FFItems.POROUS_SHELL.get())
                            .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookup,UniformGenerator.between(0.0F, 1.0F)))
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                    ).build()
            )
        }

        export(exporter, FFEntityTypes.FUNGILL.get().defaultLootTable) {
            pool(
                LootPool.lootPool()
                    .add(
                        LootItem.lootTableItem(FFItems.FUNGILL.get())
                            .apply(EnchantedCountIncreaseFunction.lootingMultiplier(lookup,UniformGenerator.between(0.0F, 1.0F)))
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                    ).build()
            )
        }
    }

    /**
     * Exports a loot table for [entityType] to [exporter] using its loot table id.
     */
    private fun export(
        exporter: BiConsumer<ResourceKey<LootTable>, LootTable.Builder>,
        entityTable: ResourceKey<LootTable>,
        builder: LootTable.Builder.() -> Unit
    ) {
        exporter.accept(entityTable, LootTable.lootTable().apply(builder))
    }

    companion object {
        private val NEEDS_ENTITY_ON_FIRE: EntityPredicate.Builder =
            EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true))
    }
}
