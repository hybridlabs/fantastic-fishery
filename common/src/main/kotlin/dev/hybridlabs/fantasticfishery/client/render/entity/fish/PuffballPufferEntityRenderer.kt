package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.hapi.client.render.entity.aquatic.BaseFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.PuffballPufferEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.PuffballPufferEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState

class PuffballPufferEntityRenderer(context: Context) :
    BaseFishEntityRenderer<PuffballPufferEntity, LivingEntityRenderState>(context, PuffballPufferEntityModel(), true, false)