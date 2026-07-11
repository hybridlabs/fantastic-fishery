package dev.hybridlabs.fantasticfishery.entity.misc

import dev.hybridlabs.fantasticfishery.block.FFBlocks
import net.minecraft.core.particles.ItemParticleOption
import net.minecraft.core.particles.ParticleOptions
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.projectile.ThrowableItemProjectile
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.level.Level
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.EntityHitResult
import net.minecraft.world.phys.HitResult

class PlunderersCoreEntity : ThrowableItemProjectile {
    constructor(entityType: EntityType<out PlunderersCoreEntity>, level: Level) : super(entityType, level)

    constructor(level: Level, shooter: LivingEntity) : super(EntityType.SNOWBALL, shooter, level)

    constructor(level: Level, x: Double, y: Double, z: Double) : super(EntityType.SNOWBALL, x, y, z, level)

    override fun getDefaultItem(): Item = Items.SNOWBALL

    private val particle: ParticleOptions
        get() {
            val itemstack = this.item
            return if (itemstack.isEmpty)
                ParticleTypes.ITEM_SNOWBALL
            else
                ItemParticleOption(ParticleTypes.ITEM, itemstack)
        }

    override fun handleEntityEvent(id: Byte) {
        if (id.toInt() == 3) {
            val particleoptions = particle

            repeat(8) {
                level().addParticle(particleoptions, x, y, z, 0.0, 0.0, 0.0)
            }
        }
    }

    override fun onHitEntity(result: EntityHitResult) {
        super.onHitEntity(result)

        val entity = result.entity
        val damage = 2f

        entity.hurt(damageSources().thrown(this, owner), damage)
        if (entity is LivingEntity) {
            entity.addEffect(MobEffectInstance(MobEffects.GLOWING, 200))
        }
    }

    override fun onHitBlock(result: BlockHitResult) {
        super.onHitBlock(result)

        if (!level().isClientSide) {
            val pos = result.blockPos.relative(result.direction)

            if (level().getBlockState(pos).canBeReplaced()) {
                level().setBlockAndUpdate(pos, FFBlocks.PLUNDERERS_CORE_BLOCK.get().defaultBlockState())
            }

            level().broadcastEntityEvent(this, 3)
            discard()
        }
    }

    override fun onHit(result: HitResult) {
        super.onHit(result)

        if (!level().isClientSide && result.type == HitResult.Type.ENTITY) {
            level().broadcastEntityEvent(this, 3)
            discard()
        }
    }
}