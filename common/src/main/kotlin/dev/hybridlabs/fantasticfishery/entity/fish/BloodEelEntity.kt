package dev.hybridlabs.fantasticfishery.entity.fish

import dev.hybridlabs.aquatic.entity.base.HAFishEntity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.ai.attributes.AttributeSupplier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level

class BloodEelEntity(type: EntityType<out BloodEelEntity>, world: Level) :
    HAFishEntity(type, world) {

    override fun getMaxSpawnClusterSize(): Int {
        return 1
    }

    override fun registerGoals() {
        super.registerGoals()
        targetSelector.addGoal(2, NearestAttackableTargetGoal(this, Player::class.java, true))
    }

    companion object {
        fun createMobAttributes(): AttributeSupplier.Builder {
            return createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 3.0)
                .add(Attributes.MOVEMENT_SPEED, 0.7)
                .add(Attributes.ATTACK_DAMAGE, 2.0)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0)
                .add(Attributes.FOLLOW_RANGE, 16.0)
        }
    }
}