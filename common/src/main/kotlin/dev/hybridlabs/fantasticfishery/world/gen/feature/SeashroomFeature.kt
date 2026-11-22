package dev.hybridlabs.fantasticfishery.world.gen.feature

import com.mojang.serialization.MapCodec
import dev.hybridlabs.fantasticfishery.block.FFBlocks
import net.minecraft.core.BlockPos
import net.minecraft.util.RandomSource
import net.minecraft.world.level.WorldGenLevel
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.TallSeagrassBlock
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf
import net.minecraft.world.level.chunk.ChunkGenerator
import net.minecraft.world.level.levelgen.Heightmap
import net.minecraft.world.level.levelgen.feature.Feature

class SeashroomFeature : Feature {
    override fun codec(): MapCodec<out Feature> = CODEC

    override fun place(
        level: WorldGenLevel,
        chunkGenerator: ChunkGenerator,
        random: RandomSource,
        origin: BlockPos,
    ): Boolean {
        var bl = false
        val i = random.nextInt(8) - random.nextInt(8)
        val j = random.nextInt(8) - random.nextInt(8)
        val k = level.getHeight(Heightmap.Types.OCEAN_FLOOR, origin.x + i, origin.z + j)
        val blockPos2 = BlockPos(origin.x + i, k, origin.z + j)
        if (level.getBlockState(blockPos2).`is`(Blocks.WATER)) {
            val bl2 = random.nextDouble() < 0.33
            val blockState = if (bl2) {
                FFBlocks.TALL_SEASHROOM.get().defaultBlockState()
            } else {
                FFBlocks.SEASHROOM.get().defaultBlockState()
            }
            if (blockState.canSurvive(level, blockPos2)) {
                if (bl2) {
                    val blockState2 = blockState.setValue(TallSeagrassBlock.HALF, DoubleBlockHalf.UPPER)
                    val blockPos3 = blockPos2.above()
                    if (level.getBlockState(blockPos3).`is`(Blocks.WATER)) {
                        level.setBlock(blockPos2, blockState, 2)
                        level.setBlock(blockPos3, blockState2, 2)
                    }
                } else {
                    level.setBlock(blockPos2, blockState, 2)
                }

                bl = true
            }
        }

        return bl
    }

    companion object {
        val CODEC: MapCodec<SeashroomFeature> = MapCodec.unit(SeashroomFeature())
    }
}
