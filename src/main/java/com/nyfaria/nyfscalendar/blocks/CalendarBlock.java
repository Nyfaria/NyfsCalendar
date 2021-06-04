package com.nyfaria.nyfscalendar.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.Commands;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
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
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.extensions.IForgeBlock;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Random;

public class CalendarBlock extends Block implements IForgeBlock, IWaterLoggable {

    private static final VoxelShape SHAPE = VoxelShapes.box(0, 0, 0, 1, 1, 0.125);
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
    public void setPlacedBy(World world, BlockPos blockPos, BlockState state, LivingEntity player, ItemStack stack) {
    	
    	world.getBlockTicks().scheduleTick(blockPos, this, 10);
    	
    	
     }
    @Override
    public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, worldIn, pos, oldState, isMoving);
        worldIn.getBlockTicks().scheduleTick(pos, this, 10);
        System.out.println("fuck your couch");
    }
    
    private static long dayPlaced = 0;
    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.tick(state, worldIn, pos, random);
        if(worldIn.isClientSide) {
        	long currentDay = worldIn.getDayTime() / 24000L % 2147483647L;
        
        	if(currentDay != dayPlaced) {
        		dayPlaced = currentDay;
        		System.out.println("Meow");
        		worldIn.setBlock(pos, state, Constants.BlockFlags.BLOCK_UPDATE);
        	}
        }
		worldIn.setBlock(pos, state, Constants.BlockFlags.BLOCK_UPDATE);
		System.out.println("Meow");
        worldIn.getBlockTicks().scheduleTick(pos, this, 10);

    }
    
}
