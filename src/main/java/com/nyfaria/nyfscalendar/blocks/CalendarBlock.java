package com.nyfaria.nyfscalendar.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.extensions.IForgeBlock;
import javax.annotation.Nullable;

import com.nyfaria.nyfscalendar.NCConfig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CalendarBlock extends Block implements IForgeBlock, IWaterLoggable {

	private static VoxelShape SHAPE = VoxelShapes.box(0, 0, 0, 1, 1, 0.125);
	public CalendarBlock() {
		super(Properties.of(Material.WOOL)
				.sound(SoundType.WOOL).dynamicShape()
        		);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.FACING, Direction.NORTH));


	}

    @Override
    public void appendHoverText(ItemStack stack, @Nullable IBlockReader reader, List<ITextComponent> list, ITooltipFlag flags) {
    	DateTimeFormatter fm = DateTimeFormatter.ofPattern("EEEE, LLLL dd");
    	LocalDate boop = LocalDate.of(2012,1,1);
    	if(reader instanceof ClientWorld) {
    		long day = ((ClientWorld)reader).getDayTime() / 24000L % 2147483647L;
    		boop = boop.plusDays(day);
    	}
    	list.add(new StringTextComponent(fm.format(boop)));
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
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
    	int boop;
    	switch(context.getHorizontalDirection()) {
    	case NORTH:
    		boop = 0;
    		break;
    	case SOUTH:
    		boop = 8;
    		break;
    	case WEST:
    		boop = 12;
    		break;
    	case EAST:
    		boop = 4;
    		break;
		default:
			boop = 0;
    	}
         return defaultBlockState().setValue(BlockStateProperties.FACING, context.getNearestLookingDirection()).setValue(BlockStateProperties.ROTATION_16, boop);
         }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
        builder.add(BlockStateProperties.ROTATION_16);
    }
    @Override
    public int getHarvestLevel(BlockState state) {
      return 1; //TODO: RE-Evaluate
    }
    
}
