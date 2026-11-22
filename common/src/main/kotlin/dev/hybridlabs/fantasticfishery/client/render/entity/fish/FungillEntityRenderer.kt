package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.hapi.client.render.entity.aquatic.BaseFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.FungillEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.FungillEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState

class FungillEntityRenderer(context: Context) :
    BaseFishEntityRenderer<FungillEntity, LivingEntityRenderState>(context, FungillEntityModel(), true, false)