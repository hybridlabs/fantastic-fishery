package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.fantasticfishery.entity.fish.PorousShellEntity
import dev.hybridlabs.hapi.client.model.entity.aquatic.BaseFishEntityModel
import net.minecraft.resources.Identifier
import software.bernie.geckolib.renderer.base.GeoRenderState

class PorousShellEntityModel : BaseFishEntityModel<PorousShellEntity>("fantastic_fishery", "porous_shell") {

    override fun getTextureResource(renderState: GeoRenderState): Identifier {
        return POROUS_SHELL_TEXTURE
    }

    override fun getModelResource(renderState: GeoRenderState): Identifier {
        return POROUS_SHELL_MODEL
    }

    override fun getAnimationResource(animatable: PorousShellEntity): Identifier {
        return POROUS_SHELL_ANIMATION
    }
    
    companion object {
        private val POROUS_SHELL_TEXTURE =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/porous_shell/porous_shell.png")

        private val POROUS_SHELL_MODEL =
            Identifier.fromNamespaceAndPath("fantastic_fishery", "fish/porous_shell/porous_shell")

        private val POROUS_SHELL_ANIMATION =
            Identifier.fromNamespaceAndPath(
                "fantastic_fishery",
                "entity/fish/porous_shell/porous_shell"
            )
    }
}