package dev.hybridlabs.fantasticfishery.client.render.entity

import dev.hybridlabs.fantasticfishery.client.render.entity.fish.BloodEelEntityRenderer
import dev.hybridlabs.fantasticfishery.client.render.entity.fish.FrigidVesselEntityRenderer
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.platform.ClientServices
import dev.hybridlabs.fantasticfishery.client.render.entity.fish.FungillEntityRenderer
import dev.hybridlabs.fantasticfishery.client.render.entity.fish.MorselEntityRenderer
import dev.hybridlabs.fantasticfishery.client.render.entity.fish.PlunderersHoopEntityRenderer
import dev.hybridlabs.fantasticfishery.client.render.entity.fish.PorousShellEntityRenderer

@Suppress("unused")
object FFEntityRenderers {
    //region fish
    val FUNGILL =
        ClientServices.PLATFORM.registerEntityRenderer(
            FFEntityTypes.FUNGILL,
            ::FungillEntityRenderer
        )

    val PLUNDERERS_HOOP =
        ClientServices.PLATFORM.registerEntityRenderer(
            FFEntityTypes.PLUNDERERS_HOOP,
            ::PlunderersHoopEntityRenderer
        )

    val MORSEL =
        ClientServices.PLATFORM.registerEntityRenderer(
            FFEntityTypes.MORSEL,
            ::MorselEntityRenderer
        )

    val POROUS_SHELL =
        ClientServices.PLATFORM.registerEntityRenderer(
            FFEntityTypes.POROUS_SHELL,
            ::PorousShellEntityRenderer
        )

    val BLOOD_EEL =
        ClientServices.PLATFORM.registerEntityRenderer(
            FFEntityTypes.BLOOD_EEL,
            ::BloodEelEntityRenderer
        )

    val FRIGID_VESSEL =
        ClientServices.PLATFORM.registerEntityRenderer(
            FFEntityTypes.FRIGID_VESSEL,
            ::FrigidVesselEntityRenderer
        )
}
