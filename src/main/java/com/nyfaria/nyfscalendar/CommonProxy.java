package com.nyfaria.nyfscalendar;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fml.network.NetworkHooks;

public class CommonProxy {

    public void init(){

    }

    public PlayerEntity getClientPlayer(){
        return null; 
    }

	void registerItemModelsProperties() {
		// TODO Auto-generated method stub
		
	}
    
}