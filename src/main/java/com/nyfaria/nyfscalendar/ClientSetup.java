package com.nyfaria.nyfscalendar;


import com.nyfaria.nyfscalendar.blocks.CalendarBlockColor;
import com.nyfaria.nyfscalendar.blocks.CalendarModelLoader;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import com.nyfaria.nyfscalendar.blocks.CalendarBlock2Renderer;;



@Mod.EventBusSubscriber(modid = NyfsCalendar.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {
    	
    	CalendarBlock2Renderer.register();
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(Registration.CALENDARBLOCK.get(), (RenderType) -> true);
            Minecraft.getInstance().getBlockColors().register(new CalendarBlockColor(), Registration.CALENDARBLOCK.get());
        });
    }

    @SubscribeEvent
    public static void onItemColor(ColorHandlerEvent.Item event) {
    }

    @SubscribeEvent
    public static void onModelRegistryEvent(ModelRegistryEvent event) {
        ModelLoaderRegistry.registerLoader(new ResourceLocation(NyfsCalendar.MOD_ID, "calendarloader"), new CalendarModelLoader());
    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (!event.getMap().location().equals(AtlasTexture.LOCATION_BLOCKS)) {
            return;
        }

        event.addSprite(CalendarBlock2Renderer.CALENDARBLOCK2_TEXTURE);
    }

    @SubscribeEvent
    public void onTooltipPre(RenderTooltipEvent.Pre event) {
        Item item = event.getStack().getItem();
        if (item.getRegistryName().getNamespace().equals(NyfsCalendar.MOD_ID)) {
            event.setMaxWidth(200);
        }
    }
    
}
