package dev.hybridlabs.fantasticfishery.client.model.entity.jellyfish

import dev.hybridlabs.fantasticfishery.entity.jellyfish.JellyshroomEntity
import dev.hybridlabs.hapi.client.model.getVariant
import dev.hybridlabs.hapi.client.model.entity.aquatic.BaseJellyfishEntityModel
import net.minecraft.resources.Identifier
import com.geckolib.renderer.base.GeoRenderState

class JellyshroomEntityModel : BaseJellyfishEntityModel<JellyshroomEntity>("fantastic_fishery", "jellyshroom") {

    override fun getTextureResource(renderState: GeoRenderState): Identifier {
        return when (renderState.getVariant(JellyshroomEntity.Companion.Type.entries)!!) {
            JellyshroomEntity.Companion.Type.RED_JELLYSHROOM -> RED_JELLYSHROOM_TEXTURE
            JellyshroomEntity.Companion.Type.BROWN_JELLYSHROOM -> BROWN_JELLYSHROOM_TEXTURE
        }
    }

    override fun getModelResource(renderState: GeoRenderState): Identifier {
        return when (renderState.getVariant(JellyshroomEntity.Companion.Type.entries)!!) {
            JellyshroomEntity.Companion.Type.RED_JELLYSHROOM -> RED_JELLYSHROOM_MODEL
            JellyshroomEntity.Companion.Type.BROWN_JELLYSHROOM -> BROWN_JELLYSHROOM_MODEL
        }
    }

    override fun getAnimationResource(animatable: JellyshroomEntity): Identifier {
        return JELLYSHROOM_ANIMATION
    }

    companion object {
        private val RED_JELLYSHROOM_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/jellyfish/jellyshroom/red_jellyshroom.png")
        private val BROWN_JELLYSHROOM_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/jellyfish/jellyshroom/brown_jellyshroom.png")

        private val RED_JELLYSHROOM_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "jellyfish/jellyshroom/red_jellyshroom")
        private val BROWN_JELLYSHROOM_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "jellyfish/jellyshroom/brown_jellyshroom")

        private val JELLYSHROOM_ANIMATION =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "entity/jellyfish/jellyshroom/jellyshroom")
    }
}