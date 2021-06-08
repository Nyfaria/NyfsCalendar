package com.nyfaria.nyfscalendar.blocks;


import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import javax.annotation.Nullable;

import static com.nyfaria.nyfscalendar.Registration.CALENDARBLOCK_TILE;

public class CalendarBlockTile extends TileEntity implements ITickableTileEntity {



    public CalendarBlockTile() {
        super(CALENDARBLOCK_TILE.get());
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {

        load(state, tag);
    }
    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(worldPosition, 1, getUpdateTag());
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