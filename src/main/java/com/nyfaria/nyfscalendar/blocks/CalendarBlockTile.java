package com.nyfaria.nyfscalendar.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.model.ModelDataManager;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelDataMap;
import net.minecraftforge.client.model.data.ModelProperty;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.nyfaria.nyfscalendar.Registration;

import java.util.Objects;

import static com.nyfaria.nyfscalendar.Registration.CALENDARBLOCK_TILE;

public class CalendarBlockTile extends TileEntity implements ITickableTileEntity {

    public static final ModelProperty<BlockState> MIMIC = new ModelProperty<>();


    public CalendarBlockTile() {
        super(CALENDARBLOCK_TILE.get());
    }




    // The getUpdateTag()/handleUpdateTag() pair is called whenever the client receives a new chunk
    // it hasn't seen before. i.e. the chunk is loaded


    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        // This is actually the default but placed here so you
        // know this is the place to potentially have a lighter read() that only
        // considers things needed client-side
        load(state, tag);
    }

    // The getUpdatePacket()/onDataPacket() pair is used when a block update happens on the client
    // (a blockstate change or an explicit notificiation of a block update from the server). It's
    // easiest to implement them based on getUpdateTag()/handleUpdateTag()

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(worldPosition, 1, getUpdateTag());
    }




	@Override
	public void tick() {
		this.level.setBlock(this.worldPosition, this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
	}
	









}