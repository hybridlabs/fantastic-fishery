package dev.hybridlabs.fantasticfishery.item

import net.minecraft.advancements.CriteriaTriggers
import net.minecraft.server.level.ServerPlayer
import net.minecraft.stats.Stats
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.*
import net.minecraft.world.level.Level

class MorselPopItem(properties: Properties) : Item(properties) {

    override fun finishUsingItem(stack: ItemStack, level: Level, entityLiving: LivingEntity): ItemStack {
        super.finishUsingItem(stack, level, entityLiving)

        if (entityLiving is ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(entityLiving, stack)
            entityLiving.awardStat(Stats.ITEM_USED.get(this))
        }

        val result = when {
            stack.`is`(FFItems.MORSEL_POP.get()) ->
                ItemStack(FFItems.PARTIALLY_EATEN_MORSEL_POP.get())

            stack.`is`(FFItems.PARTIALLY_EATEN_MORSEL_POP.get()) ->
                ItemStack(FFItems.MOSTLY_EATEN_MORSEL_POP.get())

            stack.`is`(FFItems.MOSTLY_EATEN_MORSEL_POP.get()) ->
                ItemStack.EMPTY

            else ->
                ItemStack.EMPTY
        }

        if (entityLiving is Player && !entityLiving.abilities.instabuild) {
            stack.shrink(1)
        }

        return result
    }

    override fun getUseDuration(stack: ItemStack, entity: LivingEntity): Int {
        return 32
    }

    override fun getUseAnimation(stack: ItemStack): UseAnim {
        return UseAnim.EAT
    }

    override fun use(level: Level, player: Player, hand: InteractionHand): InteractionResultHolder<ItemStack?> {
        return ItemUtils.startUsingInstantly(level, player, hand)
    }
}