package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.fantasticfishery.entity.fish.MorselEntity
import dev.hybridlabs.hapi.client.model.entity.aquatic.BaseFishEntityModel
import net.minecraft.resources.Identifier
import software.bernie.geckolib.renderer.base.GeoRenderState

class MorselEntityModel : BaseFishEntityModel<MorselEntity>("fantastic_fishery", "morsel") {

    override fun getTextureResource(renderState: GeoRenderState): Identifier {
        return MORSEL_TEXTURE
    }

    override fun getModelResource(renderState: GeoRenderState): Identifier {
        return MORSEL_MODEL
    }

    override fun getAnimationResource(animatable: MorselEntity): Identifier {
        return MORSEL_ANIMATION
    }
    
    companion object {
        private val MORSEL_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/morsel/morsel.png")

        private val MORSEL_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "fish/morsel/morsel")

        private val MORSEL_ANIMATION =
            Identifier.fromNamespaceAndPath(
                "fantastic_fishery",
                "entity/fish/morsel/morsel"
            )
    }
}