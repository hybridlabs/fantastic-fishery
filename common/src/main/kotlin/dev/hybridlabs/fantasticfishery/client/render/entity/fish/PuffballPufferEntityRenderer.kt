package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.aquatic.client.render.entity.fish.HAFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.PuffballPufferEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.PuffballPufferEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class PuffballPufferEntityRenderer(context: Context) :
    HAFishEntityRenderer<PuffballPufferEntity>(context, PuffballPufferEntityModel(), true, false)