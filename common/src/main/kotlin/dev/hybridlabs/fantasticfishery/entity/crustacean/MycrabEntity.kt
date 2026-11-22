package dev.hybridlabs.fantasticfishery.entity.crustacean

import dev.hybridlabs.hapi.entity.ai.goal.aquatic.WaterAnimalDigGoal
import dev.hybridlabs.hapi.entity.base.aquatic.BaseCrustaceanEntity
import net.minecraft.world.level.storage.ValueInput
import net.minecraft.world.level.storage.ValueOutput
import net.minecraft.network.syncher.EntityDataAccessor
import net.minecraft.network.syncher.EntityDataSerializers
import net.minecraft.network.syncher.SynchedEntityData
import net.minecraft.util.ByIdMap
import net.minecraft.util.StringRepresentable
import net.minecraft.world.DifficultyInstance
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.EntitySpawnReason
import net.minecraft.world.entity.SpawnGroupData
import dev.hybridlabs.hapi.entity.base.VariantHolder
import net.minecraft.world.entity.ai.attributes.AttributeSupplier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.level.Level
import net.minecraft.world.level.ServerLevelAccessor
import com.geckolib.constant.DefaultAnimations
import com.geckolib.animatable.manager.AnimatableManager
import com.geckolib.animation.AnimationController
import com.geckolib.animation.state.AnimationTest
import com.geckolib.animation.`object`.PlayState
import java.util.function.IntFunction
import kotlin.random.Random

@Suppress("UNUSED_PARAMETER", "DEPRECATION")
class MycrabEntity(entityType: EntityType<out MycrabEntity>, world: Level) :
    BaseCrustaceanEntity(entityType, world, false),
    VariantHolder<MycrabEntity.Companion.Type> {

    override fun registerGoals() {
        super.registerGoals()
        goalSelector.addGoal(5, WaterAnimalDigGoal(this))
    }

    override fun registerControllers(controllerRegistrar: AnimatableManager.ControllerRegistrar) {
        super.registerControllers(controllerRegistrar)

        controllerRegistrar.add(
            AnimationController(
                "Spawning", 4,
                AnimationController.AnimationStateHandler { state: AnimationTest<BaseCrustaceanEntity> ->
                    if (this.tickCount < 20)
                        return@AnimationStateHandler state.setAndContinue(DefaultAnimations.SPAWN)
                    PlayState.STOP
                }
            )
                .setParticleKeyframeHandler { event ->
                    particleEvents(
                        event as com.geckolib.animation.state.KeyFrameEvent<
                            BaseCrustaceanEntity,
                            com.geckolib.cache.animation.keyframeevent.ParticleKeyframeData
                        >
                    )
                }
        )

        controllerRegistrar.add(
            AnimationController(
                "Digging", 4,
                AnimationController.AnimationStateHandler { state: AnimationTest<BaseCrustaceanEntity> ->
                    if (this.isDigging())
                        return@AnimationStateHandler state.setAndContinue(DIG_ANIMATION)
                    PlayState.STOP
                }
            )
        )
        controllerRegistrar.add(
            DefaultAnimations.genericAttackAnimation<BaseCrustaceanEntity>(DefaultAnimations.ATTACK_SWING))
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

    companion object {
        fun createMobAttributes(): AttributeSupplier.Builder {
            return createLivingAttributes().add(Attributes.TEMPT_RANGE, 10.0)
                .add(Attributes.MAX_HEALTH, 4.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 5.0)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0)
                .add(Attributes.FOLLOW_RANGE, 8.0)
        }

        val TYPE: EntityDataAccessor<Int> =
            SynchedEntityData.defineId(MycrabEntity::class.java, EntityDataSerializers.INT)

        enum class Type(val id: Int, private val key: String) : StringRepresentable {
            RED_MYCRAB(0, "red_mycrab"),
            BROWN_MYCRAB(1, "brown_mycrab");

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
                    return CODEC.byName(name, RED_MYCRAB) as Type
                }

                fun fromId(id: Int): Type {
                    return BY_ID.apply(id) as Type
                }
            }
        }
    }

    override fun defineSynchedData(builder: SynchedEntityData.Builder) {
        builder.define(TYPE, 0)
        super.defineSynchedData(builder)
    }

    override fun addAdditionalSaveData(output: ValueOutput) {
        output.putString("Type", this.variant.serializedName)
        super.addAdditionalSaveData(output)
    }

    override fun readAdditionalSaveData(input: ValueInput) {
        this.variant = Type.byName(input.getStringOr("Type", "red_mycrab"))
        super.readAdditionalSaveData(input)
    }

    override var variant: Type
        get() = Type.fromId((entityData.get(TYPE) as Int))
        set(value) { entityData.set(TYPE, value.id) }

    override fun getMaxSize() : Int {
        return 5
    }

    override fun getMinSize(): Int {
        return -5
    }
}