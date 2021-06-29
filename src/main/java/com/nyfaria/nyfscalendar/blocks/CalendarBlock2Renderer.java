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
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraft.util.Direction;

import java.time.LocalDate;
import java.util.Random;

public class CalendarBlock2Renderer extends TileEntityRenderer<CalendarBlock2Tile>{

	 public static final ResourceLocation CALENDARBLOCK2_TEXTURE = new ResourceLocation(NyfsCalendar.MOD_ID, "block/calendarblock2");

	    public CalendarBlock2Renderer(TileEntityRendererDispatcher rendererDispatcherIn) {
	        super(rendererDispatcherIn);
	    }

	    private void add(IVertexBuilder renderer, MatrixStack stack, float x, float y, float z, float u, float v) {
	        renderer.vertex(stack.last().pose(), x, y, z)
	                .color(1.0f, 1.0f, 1.0f, 1.0f)
	                .uv(u, v)
	                .uv2(0, 240)
	                .normal(1, 0, 0)
	                .endVertex();
	    }

	    private static float diffFunction(long time, long delta, float scale) {
	        long dt = time % (delta * 2);
	        if (dt > delta) {
	            dt = 2*delta - dt;
	        }
	        return dt * scale;
	    }

	    @Override
	    public void render(CalendarBlock2Tile tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {

	    	Direction boop = tileEntity.getBlockState().getValue(BlockStateProperties.FACING);
	    	LocalDate meow = LocalDate.of(NCConfig.INSTANCE.startYear.get(), NCConfig.INSTANCE.startMonth.get(), NCConfig.INSTANCE.startDay.get()).plusDays(tileEntity.getLevel().getDayTime());
	        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(CALENDARBLOCK2_TEXTURE);
	        IVertexBuilder builder = buffer.getBuffer(RenderType.translucent());
	        float dx1 = 0f;
	        float dx2 = 0f;
	        float dx3 = 0f;
	        float dx4 = 0f;
	        float dy1 = 0f;
	        float dy2 = 0f;
	        float dy3 = 0f;
	        float dy4 = 0f;
/*
	        Random rnd = new Random(tileEntity.getBlockPos().getX() * 337L + tileEntity.getBlockPos().getY() * 37L + tileEntity.getBlockPos().getZ() * 13L);

	        long time = System.currentTimeMillis();
	        float dx1 = diffFunction(time, 900 + rnd.nextInt(800), 0.00001f + rnd.nextFloat() * 0.0001f);
	        float dx2 = diffFunction(time, 900 + rnd.nextInt(800), 0.00001f + rnd.nextFloat() * 0.0001f);
	        float dx3 = diffFunction(time, 900 + rnd.nextInt(800), 0.00001f + rnd.nextFloat() * 0.0001f);
	        float dx4 = diffFunction(time, 900 + rnd.nextInt(800), 0.00001f + rnd.nextFloat() * 0.0001f);
	        float dy1 = diffFunction(time, 900 + rnd.nextInt(800), 0.00001f + rnd.nextFloat() * 0.0001f);
	        float dy2 = diffFunction(time, 900 + rnd.nextInt(800), 0.00001f + rnd.nextFloat() * 0.0001f);
	        float dy3 = diffFunction(time, 900 + rnd.nextInt(800), 0.00001f + rnd.nextFloat() * 0.0001f);
	        float dy4 = diffFunction(time, 900 + rnd.nextInt(800), 0.00001f + rnd.nextFloat() * 0.0001f);

	        double speed = 100;
	        float angle = (time / (int)speed) % 360;
	        Quaternion rotation = Vector3f.YP.rotationDegrees(angle);
	        float scale = 1.0f + diffFunction(time,900 + rnd.nextInt(800), 0.0001f + rnd.nextFloat() * 0.001f);
			*/
	        matrixStack.pushPose();
	        /*matrixStack.translate(.5, .5, .5);
	        matrixStack.mulPose(rotation);
	        matrixStack.scale(scale, scale, scale);
	        matrixStack.translate(-.5, -.5, -.5);*/


	        matrixStack.mulPose(Vector3f.ZP.rotationDegrees(180));
	        if(boop == Direction.SOUTH) {
	        	matrixStack.translate(0f, 0f, 0.9f);
	        }
	        if(boop == Direction.EAST) {
	        	matrixStack.mulPose(Vector3f.YP.rotationDegrees(180));
	        }
	        matrixStack.translate(-1, -1, 0);
	        
	        add(builder, matrixStack, 0 + dx1, 0 + dy1, 0.1f, sprite.getU0(), sprite.getV0());
	        add(builder, matrixStack, 1 - dx2, 0 + dy2, 0.1f, sprite.getU1(), sprite.getV0());
	        add(builder, matrixStack, 1 - dx3, 1 - dy3, 0.1f, sprite.getU1(), sprite.getV1());
	        add(builder, matrixStack, 0 + dx4, 1 - dy4, 0.1f, sprite.getU0(), sprite.getV1());

	        add(builder, matrixStack, 0 + dx4, 1 - dy4, 0f, sprite.getU0(), sprite.getV1());
	        add(builder, matrixStack, 1 - dx3, 1 - dy3, 0f, sprite.getU1(), sprite.getV1());
	        add(builder, matrixStack, 1 - dx2, 0 + dy2, 0f, sprite.getU1(), sprite.getV0());
	        add(builder, matrixStack, 0 + dx1, 0 + dy1, 0f, sprite.getU0(), sprite.getV0());
	        
	        matrixStack.popPose();

	        
	        matrixStack.pushPose();

	        Quaternion rotation = Vector3f.ZP.rotationDegrees(180);
	        matrixStack.mulPose(rotation);
	        matrixStack.translate(-0.9, -0.95, -0.01);
	        matrixStack.scale(0.015f, 0.015f, 1f);
	        FontRenderer fontd = Minecraft.getInstance().font;
	        fontd.draw(matrixStack, meow.getMonth().name(), 0, 0, 0xFF000000);

	        
	        matrixStack.popPose();
	        
	    }

	    public static void register() {
	        ClientRegistry.bindTileEntityRenderer(Registration.CALENDARBLOCK2_TILE.get(), CalendarBlock2Renderer::new);
	    }
}
