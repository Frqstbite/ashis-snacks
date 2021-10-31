package com.frqstbite.ashis_snacks.block;

import com.sun.jna.platform.win32.Winspool;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MeatGrinderBlock extends HorizontalDirectionalBlock {
    private static final EnumProperty<MeatGrinderState> STATE = EnumProperty.create("state", MeatGrinderState.class);
    protected static final VoxelShape NORTH_AABB = Block.box(4, 0, 4, 11, 8, 15);
    protected static final VoxelShape EAST_AABB = Block.box(1, 0, 4, 12, 8, 11);
    protected static final VoxelShape SOUTH_AABB = Block.box(5, 0, 1, 12, 8, 12);
    protected static final VoxelShape WEST_AABB = Block.box(5, 0, 5, 15, 8, 12);

    public MeatGrinderBlock() {
        super((BlockBehaviour.Properties.of(Material.HEAVY_METAL))
                .sound(SoundType.ANVIL)
        );

        this.registerDefaultState(this.defaultBlockState()
                .setValue(STATE, MeatGrinderState.EMPTY)
        );
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(STATE);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }
    
    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        switch(blockState.getValue(FACING)) {
            default:
                return NORTH_AABB;
            case EAST:
                return EAST_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
        }
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return levelReader.getBlockState(blockPos.below()).isFaceSturdy(levelReader, blockPos, Direction.UP);
    }
}
