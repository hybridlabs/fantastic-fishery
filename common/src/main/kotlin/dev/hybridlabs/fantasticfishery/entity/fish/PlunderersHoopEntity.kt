package dev.hybridlabs.fantasticfishery.entity.fish

import dev.hybridlabs.fantasticfishery.item.FFItems
import dev.hybridlabs.hapi.entity.ai.MobTargetConfiguration
import dev.hybridlabs.hapi.entity.ai.goal.aquatic.boids.BoidGoal
import dev.hybridlabs.hapi.entity.base.aquatic.BaseSchoolingFishEntity
import dev.hybridlabs.hapi.tag.HAPIEntityTags
import net.minecraft.world.level.storage.ValueInput
import net.minecraft.world.level.storage.ValueOutput
import net.minecraft.network.syncher.EntityDataAccessor
import net.minecraft.network.syncher.EntityDataSerializers
import net.minecraft.network.syncher.SynchedEntityData
import net.minecraft.sounds.SoundEvents
import net.minecraft.util.ByIdMap
import net.minecraft.util.StringRepresentable
import net.minecraft.world.DifficultyInstance
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.EntitySpawnReason
import net.minecraft.world.entity.SpawnGroupData
import dev.hybridlabs.hapi.entity.base.VariantHolder
import net.minecraft.world.entity.ai.attributes.AttributeSupplier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.Level
import net.minecraft.world.level.ServerLevelAccessor
import net.minecraft.world.level.gameevent.GameEvent
import java.util.function.IntFunction
import kotlin.random.Random

class PlunderersHoopEntity(type: EntityType<out PlunderersHoopEntity>, world: Level) :
    BaseSchoolingFishEntity(type, world),
    VariantHolder<PlunderersHoopEntity.Companion.Type> {

    override fun getTargetConfig() = MobTargetConfiguration.ofPrey(
        HAPIEntityTags.MEDIUM_CREATURES,
        HAPIEntityTags.LARGE_CREATURES,
        HAPIEntityTags.ALL_SHARKS
    )

    override fun registerGoals() {
        super.registerGoals()
        goalSelector.addGoal(5, BoidGoal(this, 0.25f, 0.5f, 8 / 20f, 1 / 20f))
    }

    override fun getMaxSpawnClusterSize(): Int {
        return 5
    }

    override fun finalizeSpawn(
        world: ServerLevelAccessor,
        difficulty: DifficultyInstance,
        spawnReason: EntitySpawnReason,
        entityData: SpawnGroupData?
    ): SpawnGroupData? {
        variant = Type.entries.random(Random)
        return super.finalizeSpawn(world, difficulty, spawnReason, entityData)
    }

    var coreTimer: Int
        get() = entityData.get(CORE_TIMER)
        set(value) = entityData.set(CORE_TIMER, value)

    override fun aiStep() {
        super.aiStep()

        if (!level().isClientSide && coreTimer > 0) {
            coreTimer--
        }
    }

    override fun mobInteract(player: Player, hand: InteractionHand): InteractionResult {
        val itemStack = player.getItemInHand(hand)
        if (!itemStack.isEmpty && itemStack.`is`(Items.SHEARS) && coreTimer == 0) {
            if (!level().isClientSide) {
                this.coreTimer = 3600
                this.playSound(SoundEvents.SHEEP_SHEAR, 1.0f, 1.0f)
                this.gameEvent(GameEvent.SHEAR, player)
                itemStack.hurtAndBreak(1, player, hand)
                spawnAtLocation(level() as ServerLevel, ItemStack(FFItems.PLUNDERERS_CORE.get()))
                return InteractionResult.SUCCESS
            }
            return InteractionResult.CONSUME
        }
        return super.mobInteract(player, hand)
    }

    companion object {
        fun createMobAttributes(): AttributeSupplier.Builder {
            return createLivingAttributes().add(Attributes.TEMPT_RANGE, 10.0)
                .add(Attributes.MAX_HEALTH, 3.0)
                .add(Attributes.MOVEMENT_SPEED, 0.5)
                .add(Attributes.ATTACK_DAMAGE, 1.0)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0)
                .add(Attributes.FOLLOW_RANGE, 4.0)
        }

        val TYPE: EntityDataAccessor<Int> =
            SynchedEntityData.defineId(PlunderersHoopEntity::class.java, EntityDataSerializers.INT)
        val CORE_TIMER: EntityDataAccessor<Int> =
            SynchedEntityData.defineId(PlunderersHoopEntity::class.java, EntityDataSerializers.INT)

        enum class Type(val id: Int, private val key: String) : StringRepresentable {
            NORMAL(0, "normal"),
            SMALL(1, "small");

            override fun getSerializedName(): String {
                return this.key
            }

            companion object {
                val CODEC: StringRepresentable.EnumCodec<Type> =
                    StringRepresentable.fromEnum { Type.entries.toTypedArray() }
                private val BY_ID: IntFunction<Type> = ByIdMap.continuous(
                    { obj: Type -> obj.id },
                    Type.entries.toTypedArray(),
                    ByIdMap.OutOfBoundsStrategy.ZERO
                )

                fun byName(name: String): Type {
                    return CODEC.byName(name, NORMAL) as Type
                }

                fun fromId(id: Int): Type {
                    return BY_ID.apply(id) as Type
                }
            }
        }
    }

    override fun defineSynchedData(builder: SynchedEntityData.Builder) {
        builder.define(TYPE, 0)
        builder.define(CORE_TIMER, 0)
        super.defineSynchedData(builder)
    }

    override fun addAdditionalSaveData(output: ValueOutput) {
        output.putString("Type", this.variant.serializedName)
        output.putInt("coreTimer", coreTimer)
        super.addAdditionalSaveData(output)
    }

    override fun readAdditionalSaveData(input: ValueInput) {
        this.variant = Type.byName(input.getStringOr("Type", "normal"))
        this.coreTimer = input.getIntOr("coreTimer", 0)
        super.readAdditionalSaveData(input)
    }

    override var variant: Type
        get() = Type.fromId((entityData.get(TYPE) as Int))
        set(value) { entityData.set(TYPE, value.id) }
}