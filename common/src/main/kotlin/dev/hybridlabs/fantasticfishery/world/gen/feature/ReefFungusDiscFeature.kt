package dev.hybridlabs.fantasticfishery.world.gen.feature

import com.mojang.serialization.Codec
import net.minecraft.core.BlockPos
import net.minecraft.util.RandomSource
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration

class ReefFungusDiscFeature(codec: Codec<NoneFeatureConfiguration>) : ReefFungusFeature(codec) {

    override fun placeFeature(
        level: LevelAccessor,
        random: RandomSource,
        pos: BlockPos,
        state: BlockState,
    ): Boolean {

        val radius = random.nextInt(3) + 2
        val spacing = 2

        placeDisc(level, random, pos.offset(-spacing, 0, 0), radius, state)
        placeDisc(level, random, pos, radius, state)
        placeDisc(level, random, pos.offset(spacing, 0, 0), radius, state)

        return true
    }

    private fun placeDisc(
        level: LevelAccessor,
        random: RandomSource,
        center: BlockPos,
        radius: Int,
        state: BlockState
    ) {
        val mutable = BlockPos.MutableBlockPos()

        for (dy in -radius..radius) {
            for (dz in -radius..radius) {
                val distSq = dy * dy + dz * dz

                if (distSq <= radius * radius) {
                    val edge = distSq >= (radius - 1) * (radius - 1)

                    if (!edge || random.nextFloat() < 0.95f) {
                        mutable.set(center.x, center.y + dy, center.z + dz)
                        placeFungusBlock(level, random, mutable, state)
                    }
                }
            }
        }
    }
}