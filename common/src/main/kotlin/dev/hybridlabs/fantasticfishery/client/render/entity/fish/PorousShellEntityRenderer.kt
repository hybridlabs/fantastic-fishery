package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.hapi.client.render.entity.BaseFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.PorousShellEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.PorousShellEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class PorousShellEntityRenderer(context: Context) :
    BaseFishEntityRenderer<PorousShellEntity>(context, PorousShellEntityModel(), true, false)