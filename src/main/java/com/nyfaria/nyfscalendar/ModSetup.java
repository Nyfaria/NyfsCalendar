package com.nyfaria.nyfscalendar;

import java.time.LocalDate;

import net.minecraftforge.event.TickEvent.WorldTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.SeasonHelper;
import sereneseasons.handler.season.SeasonHandler;
import sereneseasons.season.SeasonSavedData;
import sereneseasons.season.SeasonTime;
import sereneseasons.api.SSGameRules;

@Mod.EventBusSubscriber(modid = NyfsCalendar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {


	@SubscribeEvent
	public static void turnOffSeasonProg(FMLServerStartingEvent e)
	{

		if( ModList.get().isLoaded("sereneseasons")) {		
			e.getServer().getGameRules().getRule(SSGameRules.RULE_DOSEASONCYCLE).set(false, e.getServer());
		}
	}
	
	public static LocalDate day = LocalDate.of(2012, 1, 1);
	@SubscribeEvent
	public static void UpdateSeason(WorldTickEvent e) {
		if( ModList.get().isLoaded("sereneseasons")) {			
			if(!e.world.getGameRules().getBoolean(SSGameRules.RULE_DOSEASONCYCLE)){
			LocalDate dayNow = LocalDate.of(2012,1,1).plusDays(e.world.getDayTime() / 24000L % 2147483647L);
	
			
				if(day!=dayNow) {
					day = dayNow;
	
					LocalDate WinterStart = LocalDate.of(dayNow.getYear()-1, 12, 20);
					LocalDate WinterMidStart = LocalDate.of(dayNow.getYear(), 1, 19);
					LocalDate WinterEndStart = LocalDate.of(dayNow.getYear(), 2, 17);
					LocalDate SpringStart = LocalDate.of(dayNow.getYear(), 3, 19);
					LocalDate SpringMidStart = LocalDate.of(dayNow.getYear(), 4, 19);
					LocalDate SpringEndStart = LocalDate.of(dayNow.getYear(), 5, 19);
					LocalDate SummerStart = LocalDate.of(dayNow.getYear(), 6, 19);
					LocalDate SummerMidStart = LocalDate.of(dayNow.getYear(), 7, 20);
					LocalDate SummerEndStart = LocalDate.of(dayNow.getYear(), 8, 21);
					LocalDate FallStart = LocalDate.of(dayNow.getYear(), 9, 21);
					LocalDate FallMidStart = LocalDate.of(dayNow.getYear(), 10, 21);
					LocalDate FallEndStart = LocalDate.of(dayNow.getYear(), 11, 20);
					LocalDate WinterStart2 = LocalDate.of(dayNow.getYear(), 12, 20);
					
					if( ((dayNow.isAfter(WinterStart) && dayNow.isBefore(WinterMidStart.plusDays(1))) || dayNow.isAfter(WinterStart2)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.EARLY_WINTER) {
						
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.EARLY_WINTER.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
					
					if( dayNow.isAfter(WinterMidStart) && dayNow.isBefore(WinterEndStart.plusDays(1)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.MID_WINTER) {
							
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.MID_WINTER.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
					if( dayNow.isAfter(WinterEndStart) && dayNow.isBefore(SpringStart.plusDays(1)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.LATE_WINTER) {
						
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.LATE_WINTER.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
					if( dayNow.isAfter(SpringStart) && dayNow.isBefore(SpringMidStart.plusDays(1)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.EARLY_SPRING) {
						
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.EARLY_SPRING.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
					if( dayNow.isAfter(SpringMidStart) && dayNow.isBefore(SpringEndStart.plusDays(1)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.MID_SPRING) {
						
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.MID_SPRING.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
					if( dayNow.isAfter(SpringEndStart) && dayNow.isBefore(SummerStart.plusDays(1)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.LATE_SPRING) {
						
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.LATE_SPRING.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
					if( dayNow.isAfter(SummerStart) && dayNow.isBefore(SummerMidStart.plusDays(1)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.EARLY_SUMMER) {
						
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.EARLY_SUMMER.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
					if( dayNow.isAfter(SummerMidStart) && dayNow.isBefore(SummerEndStart.plusDays(1)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.MID_SUMMER) {
						
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.MID_SUMMER.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
					if( dayNow.isAfter(SummerEndStart) && dayNow.isBefore(FallStart.plusDays(1)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.LATE_SUMMER) {
						
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.LATE_SUMMER.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
					if( dayNow.isAfter(FallStart) && dayNow.isBefore(FallMidStart.plusDays(1)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.EARLY_AUTUMN) {
						
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.EARLY_AUTUMN.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
					if( dayNow.isAfter(FallMidStart) && dayNow.isBefore(FallEndStart.plusDays(1)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.MID_AUTUMN) {
						
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.MID_AUTUMN.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
					if( dayNow.isAfter(FallEndStart) && dayNow.isBefore(WinterStart2.plusDays(1)) && SeasonHelper.getSeasonState(e.world).getSubSeason() != Season.SubSeason.LATE_AUTUMN) {
						
						SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(e.world);
			            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * Season.SubSeason.LATE_AUTUMN.ordinal();
			            seasonData.setDirty();
			            SeasonHandler.sendSeasonUpdate(e.world);
					}
				}	
			}
		}
	}
}
