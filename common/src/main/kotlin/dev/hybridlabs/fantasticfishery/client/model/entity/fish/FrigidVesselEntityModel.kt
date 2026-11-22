package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.fantasticfishery.entity.fish.FrigidVesselEntity
import dev.hybridlabs.hapi.client.model.entity.aquatic.BaseFishEntityModel
import net.minecraft.resources.Identifier
import com.geckolib.renderer.base.GeoRenderState

class FrigidVesselEntityModel : BaseFishEntityModel<FrigidVesselEntity>("fantastic_fishery", "frigid_vessel") {

    override fun getTextureResource(renderState: GeoRenderState): Identifier {
        return FRIGID_VESSEL_TEXTURE
    }

    override fun getModelResource(renderState: GeoRenderState): Identifier {
        return FRIGID_VESSEL_MODEL
    }

    override fun getAnimationResource(animatable: FrigidVesselEntity): Identifier {
        return FRIGID_VESSEL_ANIMATION
    }
    
    companion object {
        private val FRIGID_VESSEL_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/frigid_vessel/frigid_vessel.png")

        private val FRIGID_VESSEL_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "fish/frigid_vessel/frigid_vessel")

        private val FRIGID_VESSEL_ANIMATION =
            Identifier.fromNamespaceAndPath(
                "fantastic_fishery",
                "entity/fish/frigid_vessel/frigid_vessel"
            )
    }
}