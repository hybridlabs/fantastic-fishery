package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.hapi.client.render.entity.aquatic.BaseFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.PorousShellEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.PorousShellEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState

class PorousShellEntityRenderer(context: Context) :
    BaseFishEntityRenderer<PorousShellEntity, LivingEntityRenderState>(context, PorousShellEntityModel(), true, false)