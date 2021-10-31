package com.frqstbite.ashis_snacks.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;

public class MeatGrinderBlock extends HorizontalDirectionalBlock {
    private static final EnumProperty<MeatGrinderState> STATE = EnumProperty.create("state", MeatGrinderState.class);

    public MeatGrinderBlock() {
        super((BlockBehaviour.Properties.of(Material.HEAVY_METAL))
                .sound(SoundType.ANVIL)
        );

        this.registerDefaultState(this.defaultBlockState()
                .setValue(STATE, MeatGrinderState.EMPTY)
        );
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_51377_) {
        return this.defaultBlockState().setValue(FACING, p_51377_.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HorizontalDirectionalBlock.FACING);
        builder.add(STATE);
    }
}
