package dev.hybridlabs.fantasticfishery.world.gen.feature

import dev.hybridlabs.fantasticfishery.tag.FFBlockTags
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.tags.TagKey
import net.minecraft.util.RandomSource
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.WorldGenLevel
import net.minecraft.world.level.block.BaseCoralWallFanBlock
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.chunk.ChunkGenerator
import net.minecraft.world.level.levelgen.feature.Feature

abstract class FungalReefFeature : Feature {
    override fun place(
        level: WorldGenLevel,
        chunkGenerator: ChunkGenerator,
        random: RandomSource,
        origin: BlockPos,
    ): Boolean {
        val block = randomBlock(FFBlockTags.FUNGAL_CORAL_BLOCKS, random) ?: return false
        return this.placeFeature(level, random, origin, block.defaultBlockState())
    }

    protected abstract fun placeFeature(
        level: LevelAccessor,
        random: RandomSource,
        pos: BlockPos,
        state: BlockState,
    ): Boolean

    protected fun placeFungusBlock(
        level: LevelAccessor,
        random: RandomSource,
        pos: BlockPos,
        state: BlockState,
    ): Boolean {
        val blockPos = pos.above()
        val blockState = level.getBlockState(pos)
        if ((blockState.`is`(Blocks.WATER) || blockState.`is`(FFBlockTags.FUNGAL_CORALS)) && level.getBlockState(blockPos).`is`(
                Blocks.WATER
            )
        ) {
            level.setBlock(pos, state, 3)
            if (random.nextFloat() < 0.25f) {
                randomBlock(FFBlockTags.FUNGAL_CORALS, random)?.let {
                    level.setBlock(blockPos, it.defaultBlockState(), 2)
                }
            }

            for (direction in Direction.Plane.HORIZONTAL) {
                if (random.nextFloat() < 0.2f) {
                    val blockPos2 = pos.relative(direction)
                    if (level.getBlockState(blockPos2).`is`(Blocks.WATER)) {
                        randomBlock(FFBlockTags.FUNGAL_WALL_CORALS, random)?.let { block ->
                            var blockState = block.defaultBlockState()
                            if (blockState.hasProperty(BaseCoralWallFanBlock.FACING)) {
                                blockState = blockState.setValue(
                                    BaseCoralWallFanBlock.FACING,
                                    direction
                                )
                            }
                            level.setBlock(blockPos2, blockState, 2)
                        }
                    }
                }
            }

            return true
        } else {
            return false
        }
    }

    private fun randomBlock(tag: TagKey<Block>, random: RandomSource): Block? {
        val blocks = BuiltInRegistries.BLOCK.getTagOrEmpty(tag).toList()
        return if (blocks.isEmpty()) null else blocks[random.nextInt(blocks.size)].value()
    }
}
