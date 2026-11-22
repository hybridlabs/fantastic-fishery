package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.fantasticfishery.entity.fish.BloodEelEntity
import dev.hybridlabs.hapi.client.model.entity.aquatic.BaseFishEntityModel
import net.minecraft.resources.Identifier
import software.bernie.geckolib.renderer.base.GeoRenderState

class BloodEelEntityModel : BaseFishEntityModel<BloodEelEntity>("fantastic_fishery", "blood_eel") {

    override fun getTextureResource(renderState: GeoRenderState): Identifier {
        return BLOOD_EEL_TEXTURE
    }

    override fun getModelResource(renderState: GeoRenderState): Identifier {
        return BLOOD_EEL_MODEL
    }

    override fun getAnimationResource(animatable: BloodEelEntity): Identifier {
        return BLOOD_EEL_ANIMATION
    }
    
    companion object {
        private val BLOOD_EEL_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/blood_eel/blood_eel.png")

        private val BLOOD_EEL_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "fish/blood_eel/blood_eel")

        private val BLOOD_EEL_ANIMATION =
            Identifier.fromNamespaceAndPath(
                "fantastic_fishery",
                "entity/fish/blood_eel/blood_eel"
            )
    }
}