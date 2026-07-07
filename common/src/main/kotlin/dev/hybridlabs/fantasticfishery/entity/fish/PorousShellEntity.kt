package dev.hybridlabs.fantasticfishery.entity.fish

import dev.hybridlabs.aquatic.entity.ai.goal.WaterAnimalDigGoal
import dev.hybridlabs.aquatic.entity.base.HAFishEntity
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.ai.attributes.AttributeSupplier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level

class PorousShellEntity(type: EntityType<out PorousShellEntity>, world: Level) :
    HAFishEntity(type, world) {

    override fun getMaxSpawnClusterSize(): Int {
        return 2
    }

    override fun registerGoals() {
        super.registerGoals()
        targetSelector.addGoal(2, NearestAttackableTargetGoal(this, Player::class.java, true))
    }

    override fun remove(reason: RemovalReason) {
        if (!level().isClientSide && this.isDeadOrDying) {
            val text = this.customName
            val isNoAi = this.isNoAi
            val spawnCount = level().random.nextInt(4) + 1

            for (l in 0 until spawnCount) {
                val offsetX = (level().random.nextFloat() - 0.5f) * 2.0f
                val offsetZ = (level().random.nextFloat() - 0.5f) * 2.0f
                val pearlfishEntity = FFEntityTypes.BLOOD_EEL.get().create(level())

                pearlfishEntity?.let {
                    it.customName = text
                    it.isNoAi = isNoAi
                    it.isInvulnerable = this.isInvulnerable
                    it.moveTo(
                        this.x + offsetX,
                        this.y + 0.5,
                        this.z + offsetZ,
                        level().random.nextFloat() * 360.0f,
                        0.0f
                    )

                    level().addFreshEntity(it)
                }
            }
        }
        super.remove(reason)
    }

    companion object {
        fun createMobAttributes(): AttributeSupplier.Builder {
            return createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 8.0)
                .add(Attributes.MOVEMENT_SPEED, 0.6)
                .add(Attributes.ATTACK_DAMAGE, 4.0)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0)
                .add(Attributes.FOLLOW_RANGE, 24.0)
        }
    }
}