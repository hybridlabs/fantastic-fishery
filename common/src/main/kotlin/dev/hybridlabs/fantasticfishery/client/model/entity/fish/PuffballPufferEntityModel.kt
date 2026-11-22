package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.entity.fish.PuffballPufferEntity
import dev.hybridlabs.fantasticfishery.client.model.FFDataTickets
import dev.hybridlabs.hapi.client.model.entity.aquatic.BaseFishEntityModel
import net.minecraft.resources.Identifier
import software.bernie.geckolib.renderer.base.GeoRenderState

class PuffballPufferEntityModel : BaseFishEntityModel<PuffballPufferEntity>("fantastic_fishery", "puffball_puffer") {

    override fun getTextureResource(renderState: GeoRenderState): Identifier {
        val puffState = renderState.getGeckolibData(FFDataTickets.PUFF_STATE) ?: 0

        val texturePath = when (puffState) {
            0 -> "textures/entity/fish/puffball_puffer/puffball_puffer_small.png"
            1 -> "textures/entity/fish/puffball_puffer/puffball_puffer_medium.png"
            else -> "textures/entity/fish/puffball_puffer/puffball_puffer_large.png"
        }

        return FantasticFisheryCommon.locate(texturePath)
    }

    override fun getModelResource(renderState: GeoRenderState): Identifier {
        val puffState = renderState.getGeckolibData(FFDataTickets.PUFF_STATE) ?: 0

        val texturePath = when (puffState) {
            0 -> "fish/puffball_puffer/puffball_puffer_small"
            1 -> "fish/puffball_puffer/puffball_puffer_medium"
            else -> "fish/puffball_puffer/puffball_puffer_large"
        }

        return FantasticFisheryCommon.locate(texturePath)
    }

    override fun addAdditionalStateData(
        animatable: PuffballPufferEntity,
        relatedObject: Any?,
        renderState: GeoRenderState,
    ) {
        renderState.addGeckolibData(FFDataTickets.PUFF_STATE, animatable.getPuffState())
    }

    override fun getAnimationResource(animatable: PuffballPufferEntity): Identifier {
        return PUFFBALL_PUFFER_ANIMATION
    }

    companion object {
        private val PUFFBALL_PUFFER_ANIMATION =
            Identifier.fromNamespaceAndPath(
                "fantastic_fishery",
                "entity/fish/puffball_puffer/puffball_puffer"
            )
    }
}