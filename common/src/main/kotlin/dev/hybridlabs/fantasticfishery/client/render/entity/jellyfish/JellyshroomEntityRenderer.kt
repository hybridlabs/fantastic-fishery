package dev.hybridlabs.fantasticfishery.client.render.entity.jellyfish

import dev.hybridlabs.fantasticfishery.client.model.entity.jellyfish.JellyshroomEntityModel
import dev.hybridlabs.fantasticfishery.entity.jellyfish.JellyshroomEntity
import dev.hybridlabs.hapi.client.render.entity.aquatic.BaseJellyfishEntityRenderer
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class JellyshroomEntityRenderer(context: Context) :
    BaseJellyfishEntityRenderer<JellyshroomEntity>(context, JellyshroomEntityModel(), true, false)