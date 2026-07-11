package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.aquatic.client.model.entity.fish.HAFishEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.PorousShellEntity
import net.minecraft.resources.ResourceLocation

class PorousShellEntityModel : HAFishEntityModel<PorousShellEntity>("porous_shell") {

    override fun getTextureResource(animatable: PorousShellEntity): ResourceLocation {
        return POROUS_SHELL_TEXTURE
    }

    override fun getModelResource(animatable: PorousShellEntity): ResourceLocation {
        return POROUS_SHELL_MODEL
    }

    override fun getAnimationResource(animatable: PorousShellEntity): ResourceLocation {
        return POROUS_SHELL_ANIMATION
    }
    
    companion object {
        private val POROUS_SHELL_TEXTURE =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "textures/entity/fish/porous_shell/porous_shell.png")

        private val POROUS_SHELL_MODEL =
            ResourceLocation.fromNamespaceAndPath("fantastic_fishery", "geo/fish/porous_shell/porous_shell.geo.json")

        private val POROUS_SHELL_ANIMATION =
            ResourceLocation.fromNamespaceAndPath(
                "fantastic_fishery",
                "animations/entity/fish/porous_shell/porous_shell.animation.json"
            )
    }
}