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
	
	
	
    public static final RegistryObject<CalendarBlock2> CALENDAR_RED = BLOCKS.register("calendar_red", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_RED1 = ITEMS.register("calendar_red", () -> new BlockItem(CALENDAR_RED.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	
	
    public static final RegistryObject<CalendarBlock2> CALENDAR_BLUE = BLOCKS.register("calendar_blue", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_BLUE1 = ITEMS.register("calendar_blue", () -> new BlockItem(CALENDAR_BLUE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_GREEN = BLOCKS.register("calendar_green", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_GREEN1 = ITEMS.register("calendar_green", () -> new BlockItem(CALENDAR_GREEN.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_ORANGE = BLOCKS.register("calendar_orange", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_ORANGE1 = ITEMS.register("calendar_orange", () -> new BlockItem(CALENDAR_ORANGE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_YELLOW = BLOCKS.register("calendar_yellow", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_YELLOW1 = ITEMS.register("calendar_yellow", () -> new BlockItem(CALENDAR_YELLOW.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_PURPLE = BLOCKS.register("calendar_purple", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_PURPLE1 = ITEMS.register("calendar_purple", () -> new BlockItem(CALENDAR_PURPLE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_LIGHT_BLUE = BLOCKS.register("calendar_light_blue", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_LIGHT_BLUE1 = ITEMS.register("calendar_light_blue", () -> new BlockItem(CALENDAR_LIGHT_BLUE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_WHITE = BLOCKS.register("calendar_white", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_WHITE1 = ITEMS.register("calendar_white", () -> new BlockItem(CALENDAR_WHITE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_BLACK = BLOCKS.register("calendar_black", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_BLACK1 = ITEMS.register("calendar_black", () -> new BlockItem(CALENDAR_BLACK.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_GRAY = BLOCKS.register("calendar_gray", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_GRAY1 = ITEMS.register("calendar_gray", () -> new BlockItem(CALENDAR_GRAY.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_LIGHT_GRAY = BLOCKS.register("calendar_light_gray", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_LIGHT_GRAY1 = ITEMS.register("calendar_light_gray", () -> new BlockItem(CALENDAR_LIGHT_GRAY.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_PINK = BLOCKS.register("calendar_pink", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_PINK1 = ITEMS.register("calendar_pink", () -> new BlockItem(CALENDAR_PINK.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_LIME = BLOCKS.register("calendar_lime", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_LIME1 = ITEMS.register("calendar_lime", () -> new BlockItem(CALENDAR_LIME.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<CalendarBlock2> CALENDAR_BROWN = BLOCKS.register("calendar_brown", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_BROWN1 = ITEMS.register("calendar_brown", () -> new BlockItem(CALENDAR_BROWN.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
    
    public static final RegistryObject<CalendarBlock2> CALENDAR_MAGENTA = BLOCKS.register("calendar_magenta", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_MAGENTA1 = ITEMS.register("calendar_magenta", () -> new BlockItem(CALENDAR_MAGENTA.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
    
    public static final RegistryObject<CalendarBlock2> CALENDAR_CYAN = BLOCKS.register("calendar_cyan", CalendarBlock2::new);
    public static final RegistryObject<Item> CALENDAR_CYAN1 = ITEMS.register("calendar_cyan", () -> new BlockItem(CALENDAR_CYAN.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));




	public static final RegistryObject<TileEntityType<CalendarBlock2Tile>> CALENDAR_RED2 = TILES.register("calendar_red", () -> TileEntityType.Builder.of(CalendarBlock2Tile::new,
            CALENDAR_RED.get(),
            CALENDAR_BLUE.get(),
            CALENDAR_BLACK.get(),
            CALENDAR_BROWN.get(),
            CALENDAR_CYAN.get(),
            CALENDAR_PINK.get(),
            CALENDAR_PURPLE.get(),
            CALENDAR_LIGHT_BLUE.get(),
            CALENDAR_LIGHT_GRAY.get(),
            CALENDAR_MAGENTA.get(),
            CALENDAR_GRAY.get(),
            CALENDAR_ORANGE.get(),
            CALENDAR_YELLOW.get(),
            CALENDAR_GREEN.get(),
            CALENDAR_WHITE.get(),
            CALENDAR_GRAY.get()
    ).build(null));


}
