package dev.hybridlabs.fantasticfishery.client.model

import com.geckolib.constant.dataticket.DataTicket

/**
 * Model-local render state data. GeckoLib 5 models only receive a render state, so values a model
 * needs for resource selection are captured while the entity is still available.
 */
object FFDataTickets {
    /** The puff state of a puffball puffer. */
    @JvmField
    val PUFF_STATE: DataTicket<Int> = DataTicket.create("puff_state", Int::class.java)

    /** The remaining core timer of a plunderer's hoop. */
    @JvmField
    val CORE_TIMER: DataTicket<Int> = DataTicket.create("core_timer", Int::class.java)
}
