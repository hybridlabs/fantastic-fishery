@file:Suppress("UNUSED_PARAMETER")

package dev.hybridlabs.fantasticfishery

import dev.hybridlabs.fantasticfishery.client.render.entity.FFEntityRenderers
import net.fabricmc.api.ClientModInitializer

@Suppress("UnusedExpression", "DEPRECATION")
object FantasticFisheryClient : ClientModInitializer {
    override fun onInitializeClient() {

        FFEntityRenderers
    }
}
