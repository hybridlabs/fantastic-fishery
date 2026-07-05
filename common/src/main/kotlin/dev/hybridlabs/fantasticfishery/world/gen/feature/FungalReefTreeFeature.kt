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
        val i = (random.nextInt(8) + 2) * 2

        for (j in 0..<i) {
            if (!this.placeFungusBlock(level, random, mutableBlockPos, state)) {
                return true
            }

            mutableBlockPos.move(Direction.UP)
        }

        val top = mutableBlockPos.immutable()
        placeFungusTip(level, random, top, state, 2)

        val blockpos = mutableBlockPos.immutable()
        val k = random.nextInt(3) + 2
        val list = Direction.Plane.HORIZONTAL.shuffledCopy(random)

        for (direction in list.subList(0, k)) {
            mutableBlockPos.set(blockpos)
            mutableBlockPos.move(direction)
            val l = (random.nextInt(8) + 2) * 2
            var i1 = 0

            var j1 = 0
            while (j1 < l && this.placeFungusBlock(level, random, mutableBlockPos, state)) {
                ++i1
                mutableBlockPos.move(Direction.UP)
                if (j1 == 0 || i1 >= 2 && random.nextFloat() < 0.25f) {
                    mutableBlockPos.move(direction)
                    i1 = 0
                }
                ++j1
            }

            placeFungusTip(level, random, mutableBlockPos.immutable(), state, 2)
        }

        return true
    }

    private fun placeFungusTip(
        level: LevelAccessor,
        random: RandomSource,
        center: BlockPos,
        state: BlockState,
        radius: Int
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
