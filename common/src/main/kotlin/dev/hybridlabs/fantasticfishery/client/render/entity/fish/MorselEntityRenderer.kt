package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.hapi.client.render.entity.aquatic.BaseFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.MorselEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.MorselEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState

class MorselEntityRenderer(context: Context) :
    BaseFishEntityRenderer<MorselEntity, LivingEntityRenderState>(context, MorselEntityModel(), true, false)