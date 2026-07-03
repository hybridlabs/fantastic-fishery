package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.aquatic.client.model.entity.fish.HAFishEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.PlunderersHoopEntity
import net.minecraft.resources.ResourceLocation

class PlunderersHoopEntityModel : HAFishEntityModel<PlunderersHoopEntity>("plunderers_hoop") {

    override fun getTextureResource(animatable: PlunderersHoopEntity): ResourceLocation {
        return PLUNDERERS_HOOP_TEXTURE
    }

    override fun getModelResource(animatable: PlunderersHoopEntity): ResourceLocation {
        return PLUNDERERS_HOOP_MODEL
    }


    override fun getAnimationResource(animatable: PlunderersHoopEntity): ResourceLocation {
        return PLUNDERERS_HOOP_ANIMATION
    }

    companion object {
        private val PLUNDERERS_HOOP_TEXTURE =
            ResourceLocation("fantastic_fishery", "textures/entity/fish/plunderers_hoop/plunderers_hoop.png")

        private val PLUNDERERS_HOOP_MODEL =
            ResourceLocation("fantastic_fishery", "geo/fish/plunderers_hoop/plunderers_hoop.geo.json")

        private val PLUNDERERS_HOOP_ANIMATION =
            ResourceLocation("fantastic_fishery", "animations/entity/fish/plunderers_hoop/plunderers_hoop.animation.json")
    }
}