package dev.hybridlabs.fantasticfishery.item

import dev.hybridlabs.fantasticfishery.entity.PlunderersCoreEntity
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.stats.Stats
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class PlunderersCoreItem(properties: Properties) : Item(properties) {
    override fun use(level: Level, player: Player, hand: InteractionHand): InteractionResultHolder<ItemStack?> {
        val itemstack = player.getItemInHand(hand)
        level.playSound(
            null as Player?,
            player.x,
            player.y,
            player.z,
            SoundEvents.SNOWBALL_THROW,
            SoundSource.NEUTRAL,
            0.5f,
            0.4f / (level.getRandom().nextFloat() * 0.4f + 0.8f)
        )
        if (!level.isClientSide) {
            val plunderersCore = PlunderersCoreEntity(level, player)
            plunderersCore.item = itemstack
            plunderersCore.shootFromRotation(player, player.xRot, player.yRot, 0.0f, 1.5f, 1.0f)
            level.addFreshEntity(plunderersCore)
        }

        player.cooldowns.addCooldown(this, 10)

        player.awardStat(Stats.ITEM_USED.get(this))
        if (!player.abilities.instabuild) {
            itemstack.shrink(1)
        }

        return InteractionResultHolder.sidedSuccess<ItemStack?>(itemstack, level.isClientSide())
    }
}