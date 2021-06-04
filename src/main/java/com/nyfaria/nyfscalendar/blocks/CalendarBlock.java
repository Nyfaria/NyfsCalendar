package com.nyfaria.nyfscalendar.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeBlock;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

import java.util.List;

public class CalendarBlock extends Block implements IForgeBlock, IWaterLoggable {

    private static VoxelShape SHAPE = VoxelShapes.box(0, 0, 0, 1, 1, 0.125);
   public CalendarBlock() {
        super(Properties.of(Material.METAL)
                .sound(SoundType.METAL)
                .strength(2.0f).dynamicShape().randomTicks()
                
        );

    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable IBlockReader reader, List<ITextComponent> list, ITooltipFlag flags) {
        list.add(new TranslationTextComponent("message.Calendarblock"));
    }


    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        TileEntity te = world.getBlockEntity(pos);
        if (te instanceof CalendarBlockTile) {

        }
        return super.getLightValue(state, world, pos);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        TileEntity te = reader.getBlockEntity(pos);
        if (te instanceof CalendarBlockTile) {
        }
        if(defaultBlockState().getValue(BlockStateProperties.FACING) == Direction.DOWN) {
        	SHAPE = VoxelShapes.box(0, 0, 0, 1, 0.125, 1);
        }
        
        return SHAPE;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    	
        return new CalendarBlockTile();
    }
    
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.stateDefinition.any().setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
    }

}
