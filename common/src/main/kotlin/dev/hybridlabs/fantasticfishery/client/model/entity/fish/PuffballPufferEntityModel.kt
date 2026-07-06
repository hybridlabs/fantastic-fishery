package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.aquatic.client.model.entity.fish.HAFishEntityModel
import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.entity.fish.PuffballPufferEntity
import net.minecraft.client.renderer.RenderType
import net.minecraft.resources.ResourceLocation

class PuffballPufferEntityModel : HAFishEntityModel<PuffballPufferEntity>("puffball_puffer") {
    override fun getRenderType(animatable: PuffballPufferEntity, texture: ResourceLocation): RenderType {
        return RenderType.entityTranslucent(texture)
    }

    override fun getTextureResource(animatable: PuffballPufferEntity): ResourceLocation {
        val puffState = animatable.getPuffState()

        val texturePath = when (puffState) {
            0 -> "textures/entity/fish/puffball_puffer/puffball_puffer_small.png"
            1 -> "textures/entity/fish/puffball_puffer/puffball_puffer_medium.png"
            else -> "textures/entity/fish/puffball_puffer/puffball_puffer_large.png"
        }

        return FantasticFisheryCommon.locate(texturePath)
    }

    override fun getModelResource(animatable: PuffballPufferEntity): ResourceLocation {
        val puffState = animatable.getPuffState()

        val texturePath = when (puffState) {
            0 -> "geo/fish/puffball_puffer/puffball_puffer_small.geo.json"
            1 -> "geo/fish/puffball_puffer/puffball_puffer_medium.geo.json"
            else -> "geo/fish/puffball_puffer/puffball_puffer_large.geo.json"
        }

        return FantasticFisheryCommon.locate(texturePath)
    }

    override fun getAnimationResource(animatable: PuffballPufferEntity): ResourceLocation {
        return PUFFBALL_PUFFER_ANIMATION
    }

    companion object {
        private val PUFFBALL_PUFFER_ANIMATION =
            ResourceLocation(
                "fantastic_fishery",
                "animations/entity/fish/puffball_puffer/puffball_puffer.animation.json"
            )
    }
}