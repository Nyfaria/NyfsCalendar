package com.nyfaria.nyfscalendar;

import java.math.BigInteger;

import com.nyfaria.nyfscalendar.blocks.CalendarBlock;
import com.nyfaria.nyfscalendar.blocks.CalendarBlockTile;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.client.model.ModelDataManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = NyfsCalendar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {


    public static final ItemGroup ITEM_GROUP = new ItemGroup("nyfscalendar") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.CALENDARBLOCK.get());
        }
    };
    public static void init(final FMLCommonSetupEvent event) {

    }

	public static long day = 0;
	@SubscribeEvent
	public static void UpdateBlocks(ClientTickEvent e) {
		long dayNow = Minecraft.getInstance().level != null ? Minecraft.getInstance().level.getDayTime() / 24000L % 2147483647L : 0;
		if(day != dayNow) {
			day = dayNow;
			
			//Do something to update Blocks
			
			
		}
	}
}
