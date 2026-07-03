package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.aquatic.client.render.entity.fish.HAFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.PlunderersHoopEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.PlunderersHoopEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class PlunderersHoopEntityRenderer(context: Context) :
    HAFishEntityRenderer<PlunderersHoopEntity>(context, PlunderersHoopEntityModel(), true, true)