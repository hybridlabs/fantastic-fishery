package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.hapi.client.render.entity.aquatic.BaseFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.PlunderersHoopEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.PlunderersHoopEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class PlunderersHoopEntityRenderer(context: Context) :
    BaseFishEntityRenderer<PlunderersHoopEntity>(context, PlunderersHoopEntityModel(), true, true)