package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.aquatic.client.model.entity.fish.HAFishEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.FungillEntity
import net.minecraft.resources.ResourceLocation

class FungillEntityModel : HAFishEntityModel<FungillEntity>("fungill") {

    override fun getTextureResource(animatable: FungillEntity): ResourceLocation {
        return when (animatable.variant) {
            FungillEntity.Companion.Type.RED_FUNGILL -> RED_FUNGILL_TEXTURE
            FungillEntity.Companion.Type.BROWN_FUNGILL -> BROWN_FUNGILL_TEXTURE
        }
    }

    override fun getModelResource(animatable: FungillEntity): ResourceLocation {
        return when (animatable.variant) {
            FungillEntity.Companion.Type.RED_FUNGILL -> RED_FUNGILL_MODEL
            FungillEntity.Companion.Type.BROWN_FUNGILL -> BROWN_FUNGILL_MODEL
        }
    }

    override fun getAnimationResource(animatable: FungillEntity): ResourceLocation {
        return FUNGILL_ANIMATION
    }

    companion object {
        private val RED_FUNGILL_TEXTURE =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/fungill/red_fungill.png")
        private val BROWN_FUNGILL_TEXTURE =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/fungill/brown_fungill.png")

        private val RED_FUNGILL_MODEL =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "geo/fish/fungill/red_fungill.geo.json")
        private val BROWN_FUNGILL_MODEL =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "geo/fish/fungill/brown_fungill.geo.json")

        private val FUNGILL_ANIMATION =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "animations/entity/fish/fungill/fungill.animation.json")
    }
}