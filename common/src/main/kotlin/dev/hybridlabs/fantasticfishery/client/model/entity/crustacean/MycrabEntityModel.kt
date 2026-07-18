package dev.hybridlabs.fantasticfishery.client.model.entity.crustacean

import dev.hybridlabs.aquatic.client.model.entity.crustacean.HACrustaceanEntityModel
import dev.hybridlabs.fantasticfishery.entity.crustacean.MycrabEntity
import net.minecraft.resources.ResourceLocation

class MycrabEntityModel : HACrustaceanEntityModel<MycrabEntity>("mycrab") {

    override fun getTextureResource(animatable: MycrabEntity): ResourceLocation {
        return when (animatable.variant) {
            MycrabEntity.Companion.Type.RED_MYCRAB -> RED_MYCRAB_TEXTURE
            MycrabEntity.Companion.Type.BROWN_MYCRAB -> BROWN_MYCRAB_TEXTURE
        }
    }

    override fun getModelResource(animatable: MycrabEntity): ResourceLocation {
        return when (animatable.variant) {
            MycrabEntity.Companion.Type.RED_MYCRAB -> RED_MYCRAB_MODEL
            MycrabEntity.Companion.Type.BROWN_MYCRAB -> BROWN_MYCRAB_MODEL
        }
    }

    override fun getAnimationResource(animatable: MycrabEntity): ResourceLocation {
        return MYCRAB_ANIMATION
    }

    companion object {
        private val RED_MYCRAB_TEXTURE =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "textures/entity/crustacean/mycrab/red_mycrab.png")
        private val BROWN_MYCRAB_TEXTURE =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "textures/entity/crustacean/mycrab/brown_mycrab.png")

        private val RED_MYCRAB_MODEL =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "geo/crustacean/mycrab/red_mycrab.geo.json")
        private val BROWN_MYCRAB_MODEL =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "geo/crustacean/mycrab/brown_mycrab.geo.json")

        private val MYCRAB_ANIMATION =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "animations/entity/crustacean/mycrab/mycrab.animation.json")
    }
}