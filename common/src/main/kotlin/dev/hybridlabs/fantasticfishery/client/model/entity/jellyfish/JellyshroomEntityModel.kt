package dev.hybridlabs.fantasticfishery.client.model.entity.jellyfish

import dev.hybridlabs.aquatic.client.model.entity.jellyfish.HAJellyfishEntityModel
import dev.hybridlabs.fantasticfishery.entity.jellyfish.JellyshroomEntity
import net.minecraft.resources.ResourceLocation

class JellyshroomEntityModel : HAJellyfishEntityModel<JellyshroomEntity>("jellyshroom") {

    override fun getTextureResource(animatable: JellyshroomEntity): ResourceLocation {
        return when (animatable.variant) {
            JellyshroomEntity.Companion.Type.RED_JELLYSHROOM -> RED_JELLYSHROOM_TEXTURE
            JellyshroomEntity.Companion.Type.BROWN_JELLYSHROOM -> BROWN_JELLYSHROOM_TEXTURE
        }
    }

    override fun getModelResource(animatable: JellyshroomEntity): ResourceLocation {
        return when (animatable.variant) {
            JellyshroomEntity.Companion.Type.RED_JELLYSHROOM -> RED_JELLYSHROOM_MODEL
            JellyshroomEntity.Companion.Type.BROWN_JELLYSHROOM -> BROWN_JELLYSHROOM_MODEL
        }
    }

    override fun getAnimationResource(animatable: JellyshroomEntity): ResourceLocation {
        return JELLYSHROOM_ANIMATION
    }

    companion object {
        private val RED_JELLYSHROOM_TEXTURE =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "textures/entity/jellyfish/jellyshroom/red_jellyshroom.png")
        private val BROWN_JELLYSHROOM_TEXTURE =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "textures/entity/jellyfish/jellyshroom/brown_jellyshroom.png")

        private val RED_JELLYSHROOM_MODEL =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "geo/jellyfish/jellyshroom/red_jellyshroom.geo.json")
        private val BROWN_JELLYSHROOM_MODEL =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "geo/jellyfish/jellyshroom/brown_jellyshroom.geo.json")

        private val JELLYSHROOM_ANIMATION =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "animations/entity/jellyfish/jellyshroom/jellyshroom.animation.json")
    }
}