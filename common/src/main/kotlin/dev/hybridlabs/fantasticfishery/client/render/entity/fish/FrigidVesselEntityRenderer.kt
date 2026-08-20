package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.hapi.client.render.entity.aquatic.BaseFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.FrigidVesselEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.FrigidVesselEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class FrigidVesselEntityRenderer(context: Context) :
    BaseFishEntityRenderer<FrigidVesselEntity>(context, FrigidVesselEntityModel(), true, false)