package dev.hybridlabs.fantasticfishery.world.gen.feature

import com.mojang.serialization.Codec
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.util.RandomSource
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration

class FungalReefTreeFeature(codec: Codec<NoneFeatureConfiguration>) : FungalReefFeature(codec) {
    override fun placeFeature(
        level: LevelAccessor,
        random: RandomSource,
        pos: BlockPos,
        state: BlockState,
    ): Boolean {
        val mutableBlockPos = pos.mutable()
        val height = (random.nextInt(8) + 2) * 2

        val direction = Direction.Plane.HORIZONTAL.getRandomDirection(random)
        var verticalSteps = 0

        for (j in 0 until height) {
            if (!placeFungusBlock(level, random, mutableBlockPos, state)) {
                return true
            }

            mutableBlockPos.move(Direction.UP)
            verticalSteps++

            if (verticalSteps >= 2 && random.nextFloat() < 0.35f) {
                mutableBlockPos.move(direction)
                verticalSteps = 0
            }
        }

        val top = mutableBlockPos.immutable()

        placeFungusTip(level, random, top, state, 2)

        return true
    }

    private fun placeFungusTip(
        level: LevelAccessor,
        random: RandomSource,
        center: BlockPos,
        state: BlockState,
        radius: Int,
    ) {
        val mutable = BlockPos.MutableBlockPos()

        for (x in -radius..radius) {
            for (y in -radius..radius) {
                for (z in -radius..radius) {
                    val dist = x * x + y * y + z * z
                    if (dist <= radius * radius && random.nextFloat() > 0.2f) {
                        mutable.set(center.offset(x, y, z))
                        placeFungusBlock(level, random, mutable, state)
                    }
                }
            }
        }
    }
}
