package dev.hybridlabs.fantasticfishery.block

import net.minecraft.core.BlockPos
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.ScheduledTickAccess
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SimpleWaterloggedBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.block.state.properties.BooleanProperty
import net.minecraft.util.RandomSource
import net.minecraft.world.level.material.FluidState
import net.minecraft.world.level.material.Fluids
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape

class PlunderersCoreBlock(settings: Properties) : Block(settings), SimpleWaterloggedBlock {

    init {
        registerDefaultState(
            stateDefinition.any()
                .setValue(WATERLOGGED, false)
        )
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        builder.add(WATERLOGGED)
    }

    override fun getStateForPlacement(context: BlockPlaceContext): BlockState {
        val fluidState = context.level.getFluidState(context.clickedPos)
        return defaultBlockState().setValue(WATERLOGGED, fluidState.type == Fluids.WATER)
    }

    override fun getFluidState(state: BlockState): FluidState {
        return if (state.getValue(WATERLOGGED))
            Fluids.WATER.getSource(false)
        else
            super.getFluidState(state)
    }

    override fun updateShape(
        state: BlockState,
        level: LevelReader,
        scheduledTickAccess: ScheduledTickAccess,
        currentPos: BlockPos,
        direction: net.minecraft.core.Direction,
        neighborPos: BlockPos,
        neighborState: BlockState,
        random: RandomSource,
    ): BlockState {
        if (state.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level))
        }
        return super.updateShape(state, level, scheduledTickAccess, currentPos, direction, neighborPos, neighborState, random)
    }

    override fun getShape(
        state: BlockState,
        world: BlockGetter,
        pos: BlockPos,
        context: CollisionContext,
    ): VoxelShape = SHAPE

    companion object {
        val WATERLOGGED: BooleanProperty = BlockStateProperties.WATERLOGGED

        private val SHAPE: VoxelShape = box(5.0, 5.0, 5.0, 11.0, 11.0, 11.0)
    }
}