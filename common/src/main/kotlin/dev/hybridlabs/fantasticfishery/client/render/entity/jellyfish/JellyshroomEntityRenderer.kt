package dev.hybridlabs.fantasticfishery.client.render.entity.jellyfish

import dev.hybridlabs.aquatic.client.render.entity.jellyfish.HAJellyfishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.jellyfish.JellyshroomEntityModel
import dev.hybridlabs.fantasticfishery.entity.jellyfish.JellyshroomEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class JellyshroomEntityRenderer(context: Context) :
    HAJellyfishEntityRenderer<JellyshroomEntity>(context, JellyshroomEntityModel(), true, false)