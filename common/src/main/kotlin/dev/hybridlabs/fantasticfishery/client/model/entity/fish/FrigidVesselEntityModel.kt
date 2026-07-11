package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.aquatic.client.model.entity.fish.HAFishEntityModel
import dev.hybridlabs.aquatic.entity.fish.DiscusEntity
import dev.hybridlabs.fantasticfishery.entity.fish.FrigidVesselEntity
import net.minecraft.client.renderer.RenderType
import net.minecraft.resources.ResourceLocation

class FrigidVesselEntityModel : HAFishEntityModel<FrigidVesselEntity>("frigid_vessel") {
    override fun getRenderType(animatable: FrigidVesselEntity, texture: ResourceLocation): RenderType {
        return RenderType.entityTranslucent(texture)
    }

    override fun getTextureResource(animatable: FrigidVesselEntity): ResourceLocation {
        return FRIGID_VESSEL_TEXTURE
    }

    override fun getModelResource(animatable: FrigidVesselEntity): ResourceLocation {
        return FRIGID_VESSEL_MODEL
    }

    override fun getAnimationResource(animatable: FrigidVesselEntity): ResourceLocation {
        return FRIGID_VESSEL_ANIMATION
    }
    
    companion object {
        private val FRIGID_VESSEL_TEXTURE =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/frigid_vessel/frigid_vessel.png")

        private val FRIGID_VESSEL_MODEL =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "geo/fish/frigid_vessel/frigid_vessel.geo.json")

        private val FRIGID_VESSEL_ANIMATION =
            ResourceLocation.fromNamespaceAndPath(
                "fantastic_fishery",
                "animations/entity/fish/frigid_vessel/frigid_vessel.animation.json"
            )
    }
}