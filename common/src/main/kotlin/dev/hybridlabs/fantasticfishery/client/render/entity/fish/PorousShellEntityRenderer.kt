package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.aquatic.client.render.entity.fish.HAFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.PorousShellEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.PorousShellEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class PorousShellEntityRenderer(context: Context) :
    HAFishEntityRenderer<PorousShellEntity>(context, PorousShellEntityModel(), true, false)