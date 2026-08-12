package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.hapi.client.render.entity.BaseFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.BloodEelEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.BloodEelEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class BloodEelEntityRenderer(context: Context) :
    BaseFishEntityRenderer<BloodEelEntity>(context, BloodEelEntityModel(), true, false)