package dev.hybridlabs.fantasticfishery.block

import dev.hybridlabs.fantasticfishery.FantasticFisheryCommon
import dev.hybridlabs.fantasticfishery.platform.registration.RegistryObject
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour.Properties
import java.util.function.Supplier

object FFBlocks {

    val RED_FLOATING_CAP = register("red_floating_cap") {
        FloatingCapBlock(Properties.copy(Blocks.LILY_PAD)
            .instabreak())
    }

    val BROWN_FLOATING_CAP = register("brown_floating_cap") {
        FloatingCapBlock(Properties.copy(Blocks.LILY_PAD)
            .instabreak())
    }

    fun <T : Block> register(id: String, block: Supplier<T>): RegistryObject<Block> {
        return FantasticFisheryCommon.BLOCKS.register(id, block)
    }
}