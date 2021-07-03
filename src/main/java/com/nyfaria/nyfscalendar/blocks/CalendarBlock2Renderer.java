package com.nyfaria.nyfscalendar.blocks;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.nyfaria.nyfscalendar.NCConfig;
import com.nyfaria.nyfscalendar.NyfsCalendar;
import com.nyfaria.nyfscalendar.Registration;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.SeasonHelper;
import sereneseasons.handler.season.SeasonHandler;
import sereneseasons.season.SeasonSavedData;
import sereneseasons.season.SeasonTime;
import net.minecraft.util.Direction;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class CalendarBlock2Renderer extends TileEntityRenderer<CalendarBlock2Tile>{

	public static final ResourceLocation CALENDARBLOCK2_TEXTURE = new ResourceLocation(NyfsCalendar.MOD_ID, "block/calendarblock2");
	public static final ResourceLocation BLACKWOOL = new ResourceLocation("minecraft","block/black_wool");
	 
	    public CalendarBlock2Renderer(TileEntityRendererDispatcher rendererDispatcherIn) {
	        super(rendererDispatcherIn);
	    }
	    private static Vector3d v(double x, double y, double z) {
	        return new Vector3d(x, y, z);
	    }
	    private void add(IVertexBuilder renderer, MatrixStack stack, Vector3d a, Vector3d b, Vector3d c, Vector3d d, TextureAtlasSprite s) {
	        renderer.vertex(stack.last().pose(), (float)a.x, (float)a.y, (float)a.z)
            .color(1.0f, 1.0f, 1.0f, 1.0f).uv(s.getU0(), s.getU1()).uv2(0, 240).normal(1, 0, 0).endVertex();
	        
	        renderer.vertex(stack.last().pose(), (float)b.x, (float)b.y, (float)b.z)
            .color(1.0f, 1.0f, 1.0f, 1.0f).uv(s.getU0(), s.getU0()).uv2(0, 240).normal(1, 0, 0).endVertex();
	        
	        renderer.vertex(stack.last().pose(), (float)c.x, (float)c.y, (float)c.z)
            .color(1.0f, 1.0f, 1.0f, 1.0f).uv(s.getU1(), s.getU0()).uv2(0, 240).normal(1, 0, 0).endVertex();
	        
	        renderer.vertex(stack.last().pose(), (float)d.x, (float)d.y, (float)d.z)
            .color(1.0f, 1.0f, 1.0f, 1.0f).uv(s.getU1(), s.getU1()).uv2(0, 240).normal(1, 0, 0).endVertex();

	    }



	    @Override
	    public void render(CalendarBlock2Tile tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
	    	Locale.setDefault(new Locale("es","ES"));
	    	BlockState state  = tileEntity.getBlockState();
	    	Direction direction = state.getValue(BlockStateProperties.FACING);
	    	int rot = state.getValue(BlockStateProperties.ROTATION_16);

	    	LocalDate currentDate = LocalDate.of(NCConfig.INSTANCE.startYear.get(), NCConfig.INSTANCE.startMonth.get(), NCConfig.INSTANCE.startDay.get()).plusDays(tileEntity.getLevel().getDayTime() / 24000L % 2147483647L);

	    	TextureAtlasSprite sprite2 = Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(BLACKWOOL);
	        
	        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(CALENDARBLOCK2_TEXTURE);
	        IVertexBuilder builder = buffer.getBuffer(RenderType.translucent());

	        matrixStack.pushPose();
	        matrixStack.clear();
            	//Top
            	add(builder, matrixStack, v(0, 1, 0.875), v(0, 1, 1), v(1, 1, 1), v(1, 1, 0.875), sprite2);
            	//Bottom
		        add(builder, matrixStack, v(0, 0, 0.875),  v(1, 0, 0.875), v(1, 0, 1), v(0, 0, 1), sprite2);
		        //Left
		        add(builder, matrixStack, v(1, 1, 1), v(1, 0, 1), v(1, 0, 0.875), v(1, 1, 0.875), sprite2);    
		        //Right
		        add(builder, matrixStack, v(0, 1, 0.875),  v(0, 0, 0.875), v(0, 0, 1), v(0, 1, 1), sprite2);        
		        //back
		        add(builder, matrixStack, v(0, 1, 1), v(0, 0, 1), v(1, 0, 1), v(1, 1, 1), sprite2);
		        //Front		
		        add(builder, matrixStack, v(0, 0, 0.875), v(0, 1, 0.875), v(1, 1, 0.875), v(1, 0, 0.875), sprite);
		    
	        matrixStack.popPose();
	        FontRenderer fontm = Minecraft.getInstance().font;
            
	        String locale1 = Minecraft.getInstance().getLanguageManager().getSelected().getCode().split("_",2)[0];
	        String locale2 = Minecraft.getInstance().getLanguageManager().getSelected().getCode().split("_",2)[1];
	        Locale locale3 = new Locale(locale1,locale2.toUpperCase());
	        String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, locale3).toUpperCase();
	        int startDay = currentDate.withDayOfMonth(1).getDayOfWeek().getValue();
	        int daysInMonth = currentDate.getMonth().length(currentDate.isLeapYear()) + startDay;
	        /*
	        
	        matrixStack.pushPose();
	        fontm.draw(matrixStack, month, 0, 0, 0xFF000000);
	        matrixStack.popPose();
	        
	        matrixStack.pushPose();

	        matrixStack.translate(-0.855, -0.655, -0.02);
	        matrixStack.scale(0.0075f, 0.0075f, 1f);
	        
	        for(int j = 1; j <= 7; j++) {
	        	int dayNumber = currentDate.plusDays(j).getDayOfWeek().getValue() + 1 == 8 ? 1 : currentDate.plusDays(j).getDayOfWeek().getValue() + 1;
	        	fontm.draw(matrixStack, currentDate.plusDays(j).getDayOfWeek().getDisplayName(TextStyle.NARROW, locale3), (15 * dayNumber) - 15, -15, 0xFF000000);
	        	
	        }
	        for(int i = 0; i < daysInMonth; i++) {
	        	if(i + 1 - startDay <= 0)
	        	{
	        		
	        	}
	        	else {
	        		String textToDraw = String.format(locale3,"%d",i + 1 - startDay);
	        		fontm.draw(matrixStack, textToDraw, (15 * (i % 7)) - (3*(textToDraw.length()-1)), (float)(Math.floor(i / 7)) * 15, 0xFF000000);
	        	}
	        }
	        
	        matrixStack.popPose();*/
	        String yearDraw = String.format(locale3,"%d",currentDate.getYear());
	        matrixStack.pushPose();
	        matrixStack.translate(1, 1, 0.874);
	        matrixStack.scale(0.01f, 0.01f, 1f);
	        matrixStack.mulPose(Vector3f.ZN.rotationDegrees(180));
	        fontm.draw(matrixStack, yearDraw,0,0, 0x80E50000);

	        matrixStack.popPose();
	    }

	    
	    
	    public static void register() {
	        ClientRegistry.bindTileEntityRenderer(Registration.CALENDARBLOCK2_TILE.get(), CalendarBlock2Renderer::new);
	    }

}
