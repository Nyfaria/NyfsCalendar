package com.nyfaria.nyfscalendar;

import com.nyfaria.nyfscalendar.blocks.CalendarBlock;
import com.nyfaria.nyfscalendar.blocks.CalendarBlockTile;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class Registration {
	
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NyfsCalendar.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NyfsCalendar.MOD_ID);
    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, NyfsCalendar.MOD_ID);


    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<CalendarBlock> CALENDARBLOCK = BLOCKS.register("calendarblock", CalendarBlock::new);
    public static final RegistryObject<Item> CALENDARBLOCK_ITEM = ITEMS.register("calendarblock", () -> new BlockItem(CALENDARBLOCK.get(), new Item.Properties().tab(ModSetup.ITEM_GROUP)));
    public static final RegistryObject<TileEntityType<CalendarBlockTile>> CALENDARBLOCK_TILE = TILES.register("calendarblock", () -> TileEntityType.Builder.of(CalendarBlockTile::new, CALENDARBLOCK.get()).build(null));

}
