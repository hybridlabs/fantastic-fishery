package dev.hybridlabs.fantasticfishery.client.render.entity.crustacean

import dev.hybridlabs.aquatic.client.render.entity.crustacean.HACrustaceanEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.crustacean.MycrabEntityModel
import dev.hybridlabs.fantasticfishery.entity.crustacean.MycrabEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class MycrabEntityRenderer(context: Context) :
    HACrustaceanEntityRenderer<MycrabEntity>(context, MycrabEntityModel(), true, false)