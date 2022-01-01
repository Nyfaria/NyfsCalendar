package com.nyfaria.nyfscalendar.blocks;

import com.nyfaria.nyfscalendar.NyfDate;
import com.nyfaria.nyfscalendar.Registration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.world.ClientWorld;
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
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;

import javax.annotation.Nullable;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CalendarBlock2 extends Block {

	private static VoxelShape SHAPE = VoxelShapes.empty();
	public CalendarBlock2() {
		super(Properties.of(Material.WOOL)
				.sound(SoundType.WOOL).dynamicShape()
        		);


	}

    @Override
    public void appendHoverText(ItemStack stack, @Nullable IBlockReader reader, List<ITextComponent> list, ITooltipFlag flags) {
    	DateTimeFormatter fm = DateTimeFormatter.ofPattern("EEEE, LLLL dd");
    	LocalDate localDate = LocalDate.of(2012,1,1);
    	if(reader instanceof ClientWorld) {
    		long day = ((ClientWorld)reader).getDayTime() / 24000L % 2147483647L;
            localDate = localDate.plusDays(day);
    	}
    	list.add(new StringTextComponent(fm.format(localDate)));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {

        return new CalendarBlock2Tile();

    }
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
    	int direction = 0;
    	switch(context.getHorizontalDirection()) {
    	case NORTH:
    		break;
    	case SOUTH:
    		direction = 8;
    		break;
    	case WEST:
    		direction = 12;
    		break;
    	case EAST:
    		direction = 4;
    		break;
    	}
    	if(context.getLevel().isClientSide) {
            NyfDate nyfDate = new NyfDate();
            System.out.println("Server Age = " + nyfDate.serverAge());
            System.out.println(nyfDate.getWeekdayDisplayName());
            System.out.println("Starting Date = " + nyfDate.displayDate());
            System.out.println("The first day of the Month = " + nyfDate.getFirstDayOfMonth());
        }
         return defaultBlockState().setValue(BlockStateProperties.FACING, context.getNearestLookingDirection()).setValue(BlockStateProperties.ROTATION_16, direction);
         }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
        builder.add(BlockStateProperties.ROTATION_16);
    }
    @Override
    public int getHarvestLevel(BlockState state) {
      return 1;
    }
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        TileEntity te = reader.getBlockEntity(pos);
        if (te instanceof CalendarBlockTile) {
        }
        if(state.getValue(BlockStateProperties.FACING) == Direction.DOWN) {
        	SHAPE = VoxelShapes.box(0, 0, 0, 1, 0.125, 1);
        }
        if(state.getValue(BlockStateProperties.FACING) == Direction.UP) {
        	SHAPE = VoxelShapes.box(0, 0.875, 0, 1, 1, 1);
        }

        if(state.getValue(BlockStateProperties.FACING) == Direction.EAST) {
        	SHAPE = VoxelShapes.box(0.875, 0, 0, 1, 1, 1);
        }
        if(state.getValue(BlockStateProperties.FACING) == Direction.WEST) {
        	SHAPE = VoxelShapes.box(0, 0, 0, 0.125, 1, 1);
        }
        
        if(state.getValue(BlockStateProperties.FACING) == Direction.NORTH) {
        	SHAPE = VoxelShapes.box(0, 0, 0, 1, 1, 0.125);
        }
        if(state.getValue(BlockStateProperties.FACING) == Direction.SOUTH) {
        	SHAPE = VoxelShapes.box(0, 0, 0.875, 1, 1, 1);
        }
        
        return SHAPE;
    }/*
    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    */
}
