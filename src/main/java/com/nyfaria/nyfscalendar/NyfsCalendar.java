package com.nyfaria.nyfscalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NyfsCalendar.MOD_ID)
public class NyfsCalendar {
	public static final String MOD_ID = "nyfscalendar";
	private static final Logger LOGGER = LogManager.getLogger();

	public NyfsCalendar() {

		Registration.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NCConfig.CONFIG_SPEC);
		if (FMLEnvironment.dist == Dist.CLIENT) {

			FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);

		}
	}

}
