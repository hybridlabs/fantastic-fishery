package dev.hybridlabs.fantasticfishery.client.model.entity.fish

import dev.hybridlabs.aquatic.client.model.entity.fish.HAFishEntityModel
import dev.hybridlabs.fantasticfishery.entity.fish.FungillEntity
import net.minecraft.client.renderer.RenderType
import net.minecraft.resources.ResourceLocation

class FungillEntityModel : HAFishEntityModel<FungillEntity>("fungill") {
    override fun getRenderType(animatable: FungillEntity, texture: ResourceLocation): RenderType {
        return RenderType.entityTranslucent(texture)
    }
}