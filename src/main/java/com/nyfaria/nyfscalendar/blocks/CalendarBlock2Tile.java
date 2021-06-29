package com.nyfaria.nyfscalendar.blocks;


import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;

import com.nyfaria.nyfscalendar.Registration;


public class CalendarBlock2Tile extends TileEntity implements ITickableTileEntity {



    public CalendarBlock2Tile() {
        super(Registration.CALENDARBLOCK2_TILE.get());
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(getBlockPos(), getBlockPos().offset(1, 3, 1));
    }

	public static long boop = 0;
	@Override
	public void tick() {
		// TODO Auto-generated method stub

		if(boop % 20 == 0) {

			level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
			setChanged();
		}
		boop++;
		
	}



}