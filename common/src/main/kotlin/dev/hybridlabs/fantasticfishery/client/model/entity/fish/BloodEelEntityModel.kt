package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.aquatic.client.model.entity.fish.HAFishEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.BloodEelEntity
import net.minecraft.resources.ResourceLocation

class BloodEelEntityModel : HAFishEntityModel<BloodEelEntity>("blood_eel") {

    override fun getTextureResource(animatable: BloodEelEntity): ResourceLocation {
        return BLOOD_EEL_TEXTURE
    }

    override fun getModelResource(animatable: BloodEelEntity): ResourceLocation {
        return BLOOD_EEL_MODEL
    }

    override fun getAnimationResource(animatable: BloodEelEntity): ResourceLocation {
        return BLOOD_EEL_ANIMATION
    }
    
    companion object {
        private val BLOOD_EEL_TEXTURE =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/blood_eel/blood_eel.png")

        private val BLOOD_EEL_MODEL =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "geo/fish/blood_eel/blood_eel.geo.json")

        private val BLOOD_EEL_ANIMATION =
            ResourceLocation.fromNamespaceAndPath(
                "fantastic_fishery",
                "animations/entity/fish/blood_eel/blood_eel.animation.json"
            )
    }
}