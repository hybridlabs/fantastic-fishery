package dev.hybridlabs.fantasticfishery.client.model.entity.crustacean

import dev.hybridlabs.fantasticfishery.entity.crustacean.MycrabEntity
import dev.hybridlabs.hapi.client.model.getVariant
import dev.hybridlabs.hapi.client.model.entity.aquatic.BaseCrustaceanEntityModel
import net.minecraft.resources.Identifier
import com.geckolib.renderer.base.GeoRenderState

class MycrabEntityModel : BaseCrustaceanEntityModel<MycrabEntity>("fantastic_fishery", "mycrab") {

    override fun getTextureResource(renderState: GeoRenderState): Identifier {
        return when (renderState.getVariant(MycrabEntity.Companion.Type.entries)!!) {
            MycrabEntity.Companion.Type.RED_MYCRAB -> RED_MYCRAB_TEXTURE
            MycrabEntity.Companion.Type.BROWN_MYCRAB -> BROWN_MYCRAB_TEXTURE
        }
    }

    override fun getModelResource(renderState: GeoRenderState): Identifier {
        return when (renderState.getVariant(MycrabEntity.Companion.Type.entries)!!) {
            MycrabEntity.Companion.Type.RED_MYCRAB -> RED_MYCRAB_MODEL
            MycrabEntity.Companion.Type.BROWN_MYCRAB -> BROWN_MYCRAB_MODEL
        }
    }

    override fun getAnimationResource(animatable: MycrabEntity): Identifier {
        return MYCRAB_ANIMATION
    }

    companion object {
        private val RED_MYCRAB_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/crustacean/mycrab/red_mycrab.png")
        private val BROWN_MYCRAB_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/crustacean/mycrab/brown_mycrab.png")

        private val RED_MYCRAB_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "crustacean/mycrab/red_mycrab")
        private val BROWN_MYCRAB_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "crustacean/mycrab/brown_mycrab")

        private val MYCRAB_ANIMATION =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "entity/crustacean/mycrab/mycrab")
    }
}