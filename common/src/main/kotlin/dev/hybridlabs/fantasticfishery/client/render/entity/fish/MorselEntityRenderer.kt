package dev.hybridlabs.fantasticfishery.client.render.entity.fish

import dev.hybridlabs.aquatic.client.render.entity.fish.HAFishEntityRenderer
import dev.hybridlabs.fantasticfishery.client.model.entity.fish.MorselEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.MorselEntity
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context

class MorselEntityRenderer(context: Context) :
    HAFishEntityRenderer<MorselEntity>(context, MorselEntityModel(), true, false)