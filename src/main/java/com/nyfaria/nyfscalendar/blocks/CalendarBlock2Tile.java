package com.nyfaria.nyfscalendar.blocks;


import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;

import com.nyfaria.nyfscalendar.Registration;


public class CalendarBlock2Tile extends TileEntity implements ITickableTileEntity {

    public CalendarBlock2Tile() {
        super(Registration.CALENDAR_RED2.get());
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

			//level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
			//setChanged();
		}
		boop++;
		
	}



}