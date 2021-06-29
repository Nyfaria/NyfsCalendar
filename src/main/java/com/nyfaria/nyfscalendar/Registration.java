package com.nyfaria.nyfscalendar;

import com.nyfaria.nyfscalendar.blocks.CalendarBlock;
import com.nyfaria.nyfscalendar.blocks.CalendarBlock2;
import com.nyfaria.nyfscalendar.blocks.CalendarBlock2Tile;
import com.nyfaria.nyfscalendar.blocks.CalendarBlockTile;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {

	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			NyfsCalendar.MOD_ID);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			NyfsCalendar.MOD_ID);
	private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, NyfsCalendar.MOD_ID);

	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static final RegistryObject<CalendarBlock> CALENDARBLOCK = BLOCKS.register("calendarblock",
			CalendarBlock::new);
	public static final RegistryObject<Item> CALENDARBLOCK_ITEM = ITEMS.register("calendarblock",
			() -> new BlockItem(CALENDARBLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	public static final RegistryObject<TileEntityType<CalendarBlockTile>> CALENDARBLOCK_TILE = TILES.register(
			"calendarblock", () -> TileEntityType.Builder.of(CalendarBlockTile::new, CALENDARBLOCK.get()).build(null));
	
	
	
    public static final RegistryObject<CalendarBlock2> CALENDARBLOCK2 = BLOCKS.register("calendarblock2", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDARBLOCK2_ITEM = ITEMS.register("calendarblock2", () -> new BlockItem(CALENDARBLOCK2.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
    public static final RegistryObject<TileEntityType<CalendarBlock2Tile>> CALENDARBLOCK2_TILE = TILES.register("calendarblock2", () -> TileEntityType.Builder.of(CalendarBlock2Tile::new, CALENDARBLOCK2.get()).build(null));


}
