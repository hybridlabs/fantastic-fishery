package dev.hybridlabs.fantasticfishery.client.render.entity.crustacean

import dev.hybridlabs.fantasticfishery.client.model.entity.crustacean.MycrabEntityModel
import dev.hybridlabs.fantasticfishery.entity.crustacean.MycrabEntity
import dev.hybridlabs.hapi.client.render.entity.aquatic.BaseCrustaceanEntityRenderer
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState

class MycrabEntityRenderer(context: Context) :
    BaseCrustaceanEntityRenderer<MycrabEntity, LivingEntityRenderState>(context, MycrabEntityModel(), true, false)