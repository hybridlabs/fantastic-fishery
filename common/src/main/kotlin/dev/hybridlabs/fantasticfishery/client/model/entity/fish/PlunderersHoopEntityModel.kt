package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.fantasticfishery.entity.fish.PlunderersHoopEntity
import dev.hybridlabs.fantasticfishery.client.model.FFDataTickets
import dev.hybridlabs.hapi.client.model.getVariant
import dev.hybridlabs.hapi.client.model.entity.aquatic.BaseFishEntityModel
import net.minecraft.resources.Identifier
import software.bernie.geckolib.renderer.base.GeoRenderState

class PlunderersHoopEntityModel : BaseFishEntityModel<PlunderersHoopEntity>("fantastic_fishery", "plunderers_hoop") {

    override fun getTextureResource(renderState: GeoRenderState): Identifier {
        return when (renderState.getVariant(PlunderersHoopEntity.Companion.Type.entries)!!) {
            PlunderersHoopEntity.Companion.Type.NORMAL -> PLUNDERERS_HOOP_TEXTURE
            PlunderersHoopEntity.Companion.Type.SMALL -> SMALL_PLUNDERERS_HOOP_TEXTURE
        }
    }

    override fun getModelResource(renderState: GeoRenderState): Identifier {
        return if ((renderState.getGeckolibData(FFDataTickets.CORE_TIMER) ?: 0) > 0) {
            when (renderState.getVariant(PlunderersHoopEntity.Companion.Type.entries)!!) {
                PlunderersHoopEntity.Companion.Type.NORMAL -> CORELESS_PLUNDERERS_HOOP_MODEL
                PlunderersHoopEntity.Companion.Type.SMALL -> CORELESS_SMALL_PLUNDERERS_HOOP_MODEL
            }
        } else {
            when (renderState.getVariant(PlunderersHoopEntity.Companion.Type.entries)!!) {
                PlunderersHoopEntity.Companion.Type.NORMAL -> PLUNDERERS_HOOP_MODEL
                PlunderersHoopEntity.Companion.Type.SMALL -> SMALL_PLUNDERERS_HOOP_MODEL
            }
        }
    }

    override fun addAdditionalStateData(
        animatable: PlunderersHoopEntity,
        relatedObject: Any?,
        renderState: GeoRenderState,
    ) {
        renderState.addGeckolibData(FFDataTickets.CORE_TIMER, animatable.coreTimer)
    }

    override fun getAnimationResource(animatable: PlunderersHoopEntity): Identifier {
        return when (animatable.variant) {
            PlunderersHoopEntity.Companion.Type.NORMAL -> PLUNDERERS_HOOP_ANIMATION
            PlunderersHoopEntity.Companion.Type.SMALL -> SMALL_PLUNDERERS_HOOP_ANIMATION
        }
    }

    companion object {
        private val PLUNDERERS_HOOP_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/plunderers_hoop/plunderers_hoop.png")
        private val SMALL_PLUNDERERS_HOOP_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/plunderers_hoop/small_plunderers_hoop.png")

        private val PLUNDERERS_HOOP_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "fish/plunderers_hoop/plunderers_hoop")
        private val CORELESS_PLUNDERERS_HOOP_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "fish/plunderers_hoop/coreless_plunderers_hoop")
        private val SMALL_PLUNDERERS_HOOP_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "fish/plunderers_hoop/small_plunderers_hoop")
        private val CORELESS_SMALL_PLUNDERERS_HOOP_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "fish/plunderers_hoop/coreless_small_plunderers_hoop")

        private val PLUNDERERS_HOOP_ANIMATION =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "entity/fish/plunderers_hoop/plunderers_hoop")
        private val SMALL_PLUNDERERS_HOOP_ANIMATION =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "entity/fish/plunderers_hoop/small_plunderers_hoop")
    }
}