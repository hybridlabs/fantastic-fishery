package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.aquatic.client.model.entity.fish.HAFishEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.MorselEntity
import dev.hybridlabs.fantasticfishery.entity.fish.PlunderersHoopEntity
import net.minecraft.resources.ResourceLocation

class MorselEntityModel : HAFishEntityModel<MorselEntity>("morsel") {

    override fun getTextureResource(animatable: MorselEntity): ResourceLocation {
        return MORSEL_TEXTURE
    }

    override fun getModelResource(animatable: MorselEntity): ResourceLocation {
        return MORSEL_MODEL
    }

    override fun getAnimationResource(animatable: MorselEntity): ResourceLocation {
        return MORSEL_ANIMATION
    }
    
    companion object {
        private val MORSEL_TEXTURE =
            ResourceLocation("fantastic_fishery", "textures/entity/fish/morsel/morsel.png")

        private val MORSEL_MODEL =
            ResourceLocation("fantastic_fishery", "geo/fish/morsel/morsel.geo.json")

        private val MORSEL_ANIMATION =
            ResourceLocation(
                "fantastic_fishery",
                "animations/entity/fish/morsel/morsel.animation.json"
            )
    }
}