package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.fantasticfishery.entity.fish.FungillEntity
import dev.hybridlabs.hapi.client.model.getVariant
import dev.hybridlabs.hapi.client.model.entity.aquatic.BaseFishEntityModel
import net.minecraft.resources.Identifier
import software.bernie.geckolib.renderer.base.GeoRenderState

class FungillEntityModel : BaseFishEntityModel<FungillEntity>("fantastic_fishery", "fungill") {

    override fun getTextureResource(renderState: GeoRenderState): Identifier {
        return when (renderState.getVariant(FungillEntity.Companion.Type.entries)!!) {
            FungillEntity.Companion.Type.RED_FUNGILL -> RED_FUNGILL_TEXTURE
            FungillEntity.Companion.Type.BROWN_FUNGILL -> BROWN_FUNGILL_TEXTURE
        }
    }

    override fun getModelResource(renderState: GeoRenderState): Identifier {
        return when (renderState.getVariant(FungillEntity.Companion.Type.entries)!!) {
            FungillEntity.Companion.Type.RED_FUNGILL -> RED_FUNGILL_MODEL
            FungillEntity.Companion.Type.BROWN_FUNGILL -> BROWN_FUNGILL_MODEL
        }
    }

    override fun getAnimationResource(animatable: FungillEntity): Identifier {
        return FUNGILL_ANIMATION
    }

    companion object {
        private val RED_FUNGILL_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/fungill/red_fungill.png")
        private val BROWN_FUNGILL_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/fungill/brown_fungill.png")

        private val RED_FUNGILL_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "fish/fungill/red_fungill")
        private val BROWN_FUNGILL_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "fish/fungill/brown_fungill")

        private val FUNGILL_ANIMATION =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "entity/fish/fungill/fungill")
    }
}