package dev.hybridlabs.fantasticfishery.client.render.entity

import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.platform.ClientServices
import dev.hybridlabs.fantasticfishery.client.render.entity.fish.FungillEntityRenderer

@Suppress("unused")
object FFEntityRenderers {
    //region fish
    val FUNGILL =
        ClientServices.PLATFORM.registerEntityRenderer(
            FFEntityTypes.FUNGILL,
            ::FungillEntityRenderer
        )
}
