package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.aquatic.client.render.entity.fish.HAFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.FungillEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.FungillEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class FungillEntityRenderer(context: Context) :
    HAFishEntityRenderer<FungillEntity>(context, FungillEntityModel(), true, false)