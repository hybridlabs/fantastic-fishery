package dev.hybridlabs.fantasticfishery.client.render.entity

import dev.hybridlabs.fantasticfishery.client.render.entity.crustacean.MycrabEntityRenderer
import dev.hybridlabs.fantasticfishery.client.render.entity.fish.*
import dev.hybridlabs.fantasticfishery.client.render.entity.jellyfish.JellyshroomEntityRenderer
import dev.hybridlabs.fantasticfishery.entity.FFEntityTypes
import dev.hybridlabs.fantasticfishery.platform.ClientServices

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

    val PUFFBALL_PUFFER =
        ClientServices.PLATFORM.registerEntityRenderer(
            FFEntityTypes.PUFFBALL_PUFFER,
            ::PuffballPufferEntityRenderer
        )

    val JELLYSHROOM =
        ClientServices.PLATFORM.registerEntityRenderer(
            FFEntityTypes.JELLYSHROOM,
            ::JellyshroomEntityRenderer
        )

    val MYCRAB =
        ClientServices.PLATFORM.registerEntityRenderer(
            FFEntityTypes.MYCRAB,
            ::MycrabEntityRenderer
        )
}
