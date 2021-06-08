package com.nyfaria.nyfscalendar.blocks;


import com.google.common.collect.ImmutableList;
import com.nyfaria.nyfscalendar.NyfsCalendar;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.client.model.data.IDynamicBakedModel;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.pipeline.BakedQuadBuilder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CalendarBakedModel implements IDynamicBakedModel {

	public static World world = Minecraft.getInstance().level;
	public static final LocalDate boop = LocalDate.of(2012,1,1);
	
    public static final ResourceLocation TEXTURE_DOWDIM_1_31 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday1days31");
    public static final ResourceLocation TEXTURE_DOWDIM_2_31 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday2days31");
    public static final ResourceLocation TEXTURE_DOWDIM_3_31 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday3days31");
    public static final ResourceLocation TEXTURE_DOWDIM_4_31 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday4days31");
    public static final ResourceLocation TEXTURE_DOWDIM_5_31 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday5days31");
    public static final ResourceLocation TEXTURE_DOWDIM_6_31 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday6days31");
    public static final ResourceLocation TEXTURE_DOWDIM_7_31 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday7days31");
    public static final ResourceLocation TEXTURE_DOWDIM_1_30 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday1days30");
    public static final ResourceLocation TEXTURE_DOWDIM_2_30 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday2days30");
    public static final ResourceLocation TEXTURE_DOWDIM_3_30 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday3days30");
    public static final ResourceLocation TEXTURE_DOWDIM_4_30 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday4days30");
    public static final ResourceLocation TEXTURE_DOWDIM_5_30 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday5days30");
    public static final ResourceLocation TEXTURE_DOWDIM_6_30 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday6days30");
    public static final ResourceLocation TEXTURE_DOWDIM_7_30 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday7days30");
    public static final ResourceLocation TEXTURE_DOWDIM_1_29 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday1days29");
    public static final ResourceLocation TEXTURE_DOWDIM_2_29 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday2days29");
    public static final ResourceLocation TEXTURE_DOWDIM_3_29 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday3days29");
    public static final ResourceLocation TEXTURE_DOWDIM_4_29 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday4days29");
    public static final ResourceLocation TEXTURE_DOWDIM_5_29 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday5days29");
    public static final ResourceLocation TEXTURE_DOWDIM_6_29 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday6days29");
    public static final ResourceLocation TEXTURE_DOWDIM_7_29 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday7days29");
    public static final ResourceLocation TEXTURE_DOWDIM_1_28 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday1days28");
    public static final ResourceLocation TEXTURE_DOWDIM_2_28 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday2days28");
    public static final ResourceLocation TEXTURE_DOWDIM_3_28 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday3days28");
    public static final ResourceLocation TEXTURE_DOWDIM_4_28 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday4days28");
    public static final ResourceLocation TEXTURE_DOWDIM_5_28 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday5days28");
    public static final ResourceLocation TEXTURE_DOWDIM_6_28 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday6days28");
    public static final ResourceLocation TEXTURE_DOWDIM_7_28 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/weekday7days28");

    public static final ResourceLocation TEXTURE_MONTH_1 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month1");
    public static final ResourceLocation TEXTURE_MONTH_2 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month2");
    public static final ResourceLocation TEXTURE_MONTH_3 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month3");
    public static final ResourceLocation TEXTURE_MONTH_4 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month4");
    public static final ResourceLocation TEXTURE_MONTH_5 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month5");
    public static final ResourceLocation TEXTURE_MONTH_6 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month6");
    public static final ResourceLocation TEXTURE_MONTH_7 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month7");
    public static final ResourceLocation TEXTURE_MONTH_8 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month8");
    public static final ResourceLocation TEXTURE_MONTH_9 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month9");
    public static final ResourceLocation TEXTURE_MONTH_10 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month10");
    public static final ResourceLocation TEXTURE_MONTH_11 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month11");
    public static final ResourceLocation TEXTURE_MONTH_12 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/month12");

    public static final ResourceLocation TEXTURE_SLOT_0 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot0");
    public static final ResourceLocation TEXTURE_SLOT_1 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot1");
    public static final ResourceLocation TEXTURE_SLOT_2 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot2");
    public static final ResourceLocation TEXTURE_SLOT_3 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot3");
    public static final ResourceLocation TEXTURE_SLOT_4 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot4");
    public static final ResourceLocation TEXTURE_SLOT_5 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot5");
    public static final ResourceLocation TEXTURE_SLOT_6 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot6");
    public static final ResourceLocation TEXTURE_SLOT_7 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot7");
    public static final ResourceLocation TEXTURE_SLOT_8 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot8");
    public static final ResourceLocation TEXTURE_SLOT_9 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot9");
    public static final ResourceLocation TEXTURE_SLOT_10 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot10");
    public static final ResourceLocation TEXTURE_SLOT_11 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot11");
    public static final ResourceLocation TEXTURE_SLOT_12 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot12");
    public static final ResourceLocation TEXTURE_SLOT_13 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot13");
    public static final ResourceLocation TEXTURE_SLOT_14 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot14");
    public static final ResourceLocation TEXTURE_SLOT_15 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot15");
    public static final ResourceLocation TEXTURE_SLOT_16 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot16");
    public static final ResourceLocation TEXTURE_SLOT_17 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot17");
    public static final ResourceLocation TEXTURE_SLOT_18 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot18");
    public static final ResourceLocation TEXTURE_SLOT_19 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot19");
    public static final ResourceLocation TEXTURE_SLOT_20 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot20");
    public static final ResourceLocation TEXTURE_SLOT_21 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot21");
    public static final ResourceLocation TEXTURE_SLOT_22 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot22");
    public static final ResourceLocation TEXTURE_SLOT_23 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot23");
    public static final ResourceLocation TEXTURE_SLOT_24 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot24");
    public static final ResourceLocation TEXTURE_SLOT_25 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot25");
    public static final ResourceLocation TEXTURE_SLOT_26 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot26");
    public static final ResourceLocation TEXTURE_SLOT_27 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot27");
    public static final ResourceLocation TEXTURE_SLOT_28 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot28");
    public static final ResourceLocation TEXTURE_SLOT_29 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot29");
    public static final ResourceLocation TEXTURE_SLOT_30 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot30");
    public static final ResourceLocation TEXTURE_SLOT_31 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot31");
    public static final ResourceLocation TEXTURE_SLOT_32 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot32");
    public static final ResourceLocation TEXTURE_SLOT_33 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot33");
    public static final ResourceLocation TEXTURE_SLOT_34 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot34");
    public static final ResourceLocation TEXTURE_SLOT_35 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot35");
    public static final ResourceLocation TEXTURE_SLOT_36 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot36");
    public static final ResourceLocation TEXTURE_SLOT_37 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot37");
    public static final ResourceLocation TEXTURE_SLOT_38 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot38");
    public static final ResourceLocation TEXTURE_SLOT_39 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot39");
    public static final ResourceLocation TEXTURE_SLOT_40 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot40");
    public static final ResourceLocation TEXTURE_SLOT_41 = new ResourceLocation(NyfsCalendar.MOD_ID, "block/slot41");

    private TextureAtlasSprite getDOWDIMTexture(int DOW, int DIM) {
    	switch(DIM){
    		case 31:
    			switch(DOW) {
    			case 1:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_1_31);
    			case 2:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_2_31);
    			case 3:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_3_31);
    			case 4:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_4_31);
    			case 5:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_5_31);
    			case 6:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_6_31);
    			case 7:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_7_31);
    			}
    		case 30:
    			switch(DOW) {
    			case 1:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_1_30);
    			case 2:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_2_30);
    			case 3:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_3_30);
    			case 4:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_4_30);
    			case 5:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_5_30);
    			case 6:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_6_30);
    			case 7:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_7_30);
    			}
    		case 29:
    			switch(DOW) {
    			case 1:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_1_29);
    			case 2:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_2_29);
    			case 3:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_3_29);
    			case 4:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_4_29);
    			case 5:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_5_29);
    			case 6:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_6_29);
    			case 7:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_7_29);
    			}
    		case 28:
    			switch(DOW) {
    			case 1:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_1_28);
    			case 2:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_2_28);
    			case 3:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_3_28);
    			case 4:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_4_28);
    			case 5:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_5_28);
    			case 6:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_6_28);
    			case 7:
        			return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_7_28);
    			}
    	}
    	return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_DOWDIM_7_28);
    }

    private TextureAtlasSprite getMonthTexture(int which) {
    	switch(which) {
    	case 1:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_1);
    	case 2:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_2);
    	case 3:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_3);
    	case 4:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_4);
    	case 5:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_5);
    	case 6:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_6);
    	case 7:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_7);
    	case 8:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_8);
    	case 9:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_9);
    	case 10:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_10);
    	case 11:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_11);
    	case 12:
    		return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_12);
    	}
    	return  Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_MONTH_12);

    }

    private TextureAtlasSprite getSlotTexture(int which) {
    	switch(which) {
    	case 0:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_0);
    	case 1:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_1);
    	case 2:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_2);
    	case 3:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_3);
    	case 4:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_4);
    	case 5:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_5);
    	case 6:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_6);
    	case 7:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_7);
    	case 8:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_8);
    	case 9:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_9);
    	case 10:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_10);
    	case 11:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_11);
    	case 12:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_12);
    	case 13:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_13);
    	case 14:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_14);
    	case 15:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_15);
    	case 16:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_16);
    	case 17:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_17);
    	case 18:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_18);
    	case 19:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_19);
    	case 20:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_20);
    	case 21:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_21);
    	case 22:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_22);
    	case 23:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_23);
    	case 24:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_24);
    	case 25:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_25);
    	case 26:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_26);
    	case 27:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_27);
    	case 28:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_28);
    	case 29:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_29);
    	case 30:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_30);
    	case 31:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_31);
    	case 32:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_32);
    	case 33:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_33);
    	case 34:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_34);
    	case 35:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_35);
    	case 36:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_36);
    	case 37:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_37);
    	case 38:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_38);
    	case 39:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_39);
    	case 40:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_40);
    	case 41:
            return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_41);
    	}
    	return Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(TEXTURE_SLOT_41);
    }

    @Override
    public boolean usesBlockLight(){
        return false;
    }

    private void putVertex(BakedQuadBuilder builder, Vector3d normal,
                           double x, double y, double z, float u, float v, TextureAtlasSprite sprite, float r, float g, float b) {

        ImmutableList<VertexFormatElement> elements = builder.getVertexFormat().getElements().asList();
        for (int j = 0 ; j < elements.size() ; j++) {
            VertexFormatElement e = elements.get(j);
            normal.zRot(90);
            switch (e.getUsage()) {
                case POSITION:
                    builder.put(j, (float) x, (float) y, (float) z, 1.0f);
                    break;
                case COLOR:
                    builder.put(j, r, g, b, 1.0f);
                    break;
                case UV:
                    switch (e.getIndex()) {
                        case 0:
                            float iu = sprite.getU(u);
                            float iv = sprite.getV(v);
                            builder.put(j, iu, iv);
                            break;
                        case 2:
                            builder.put(j, (short) 0, (short) 0);
                            break;
                        default:
                            builder.put(j);
                            break;
                    }
                    break;
                case NORMAL:
                    builder.put(j, (float) normal.x, (float) normal.y, (float) normal.z);
                    break;
                default:
                    builder.put(j);
                    break;
            }
        }
    }

    private BakedQuad createQuad(Vector3d v1, Vector3d v2, Vector3d v3, Vector3d v4, TextureAtlasSprite sprite, int cm) {
        Vector3d normal = v3.subtract(v2).cross(v1.subtract(v2)).normalize();
        int tw = 16;//sprite.getWidth();
        int th = 16;//sprite.getHeight();
        
        BakedQuadBuilder builder = new BakedQuadBuilder(sprite);
        builder.setQuadOrientation(Direction.getNearest(normal.x, normal.y, normal.z));
        putVertex(builder, normal, v1.x, v1.y, v1.z, 0, 0, sprite, 1.0f*cm, 1.0f*cm, 1.0f*cm);
        putVertex(builder, normal, v2.x, v2.y, v2.z, 0, th, sprite, 1.0f*cm, 1.0f*cm, 1.0f*cm);
        putVertex(builder, normal, v3.x, v3.y, v3.z, tw, th, sprite, 1.0f*cm, 1.0f*cm, 1.0f*cm);
        putVertex(builder, normal, v4.x, v4.y, v4.z, tw, 0, sprite, 1.0f*cm, 1.0f*cm, 1.0f*cm);
        return builder.build();
    }

    private static Vector3d v(double x, double y, double z) {
        return new Vector3d(x, y, z);
    }


    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
    	LocalDate currentDate = boop.plusDays(Objects.isNull(Minecraft.getInstance().level) ? 1 : Minecraft.getInstance().level.getDayTime() / 24000L % 2147483647L);
        int DIW = currentDate.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek().getValue() + 1;
        DIW = DIW  > 7 ? 1 : DIW;
    	List<TextureAtlasSprite> texture = new ArrayList<TextureAtlasSprite>();
    	
    	texture.add(getDOWDIMTexture(DIW,currentDate.lengthOfMonth()));
    	texture.add(getMonthTexture(currentDate.getMonthValue()));
    	texture.add(getSlotTexture(currentDate.getDayOfMonth() + DIW - 2));
        List<BakedQuad> quads = new ArrayList<>();

        Direction dirdirdir = Direction.NORTH;
        int dirdir = 1;
        if(state != null) {
        	dirdirdir = state.getValue(BlockStateProperties.FACING);
        	dirdir = state.getValue(BlockStateProperties.ROTATION_16);
        }

        for(TextureAtlasSprite theTexture : texture) {
            if(dirdirdir == Direction.SOUTH) {
            	quads.add(createQuad(v(0, 1, 0.875), v(0, 1, 1), v(1, 1, 1), v(1, 1, 0.875), theTexture,0));
            	quads.add(createQuad(v(0, 0, 0.875), v(1, 0, 0.875), v(1, 0, 1), v(0, 0, 1), theTexture,0));
            	
            	quads.add(createQuad(v(1, 1, 1), v(1, 0, 1), v(1, 0, 0.875), v(1, 1, 0.875), theTexture,0));            	
            	quads.add(createQuad(v(0, 1, 0.875), v(0, 0, 0.875), v(0, 0, 1), v(0, 1, 1), theTexture,0));
            	
            	quads.add(createQuad(v(1, 1, 0.875), v(1, 0, 0.875), v(0, 0, 0.875), v(0, 1, 0.875), theTexture,1));
            	quads.add(createQuad(v(0, 1, 1), v(0, 0, 1), v(1, 0, 1), v(1, 1, 1), theTexture,1));
            }
            else if(dirdirdir == Direction.UP) {
            	switch(dirdir) {
            	case 0:{
            		quads.add(createQuad(v(0, 1, 0), v(0, 1, 1), v(1, 1, 1), v(1, 1, 0), theTexture,1));
                    quads.add(createQuad(v(1, 0.875, 0), v(1, 0.875, 1), v(0, 0.875, 1), v(0, 0.875, 0), theTexture,1));
                    break;
            	}
            	case 12:{
            		quads.add(createQuad(v(0, 1, 1), v(1, 1, 1), v(1, 1, 0), v(0, 1, 0), theTexture,1));
                    quads.add(createQuad(v(0,0.875, 0), v(1,0.875, 0), v(1,0.875, 1), v(0,0.875, 1), theTexture,1));
                    break;
            	}
            	case 8:{
            		quads.add(createQuad(v(1, 1, 1), v(1, 1, 0), v(0, 1, 0), v(0, 1, 1), theTexture,1));
                    quads.add(createQuad(v(0,0.875, 1), v(0,0.875, 0), v(1,0.875, 0), v(1,0.875, 1), theTexture,1));
                    break;
            	}
            	case 4:{
            		quads.add(createQuad(v(1, 1, 0), v(0, 1, 0), v(0, 1, 1), v(1, 1, 1), theTexture,1));
                    quads.add(createQuad(v(1,0.875, 1), v(0,0.875, 1), v(0,0.875, 0), v(1,0.875, 0), theTexture,1));
                    break;
            	}
            	default:{
            		quads.add(createQuad(v(0, 1, 0), v(0, 1, 1), v(1, 1, 1), v(1, 1, 0), theTexture,1));
                    quads.add(createQuad(v(1,0.875, 0), v(1,0.875, 1), v(0,0.875, 1), v(0,0.875, 0), theTexture,1));
                    break;
            	}
            		
            	}
                
                quads.add(createQuad(v(1, 1, 1), v(1, 0.875, 1), v(1, 0.875, 0), v(1, 1, 0), theTexture,0));
                quads.add(createQuad(v(0, 1, 0), v(0, 0.875, 0), v(0, 0.875, 1), v(0, 1, 1), theTexture,0));
                
                quads.add(createQuad(v(1, 1, 0), v(1, 0.875, 0), v(0, 0.875, 0), v(0, 1, 0), theTexture,0));
                quads.add(createQuad(v(0, 1, 1), v(0, 0.875, 1), v(1, 0.875, 1), v(1, 1, 1), theTexture,0));
            }
            else if(dirdirdir == Direction.DOWN) {
	            
            	switch(dirdir) {
            	case 0:{
            		quads.add(createQuad(v(0, 0.125, 0), v(0, 0.125, 1), v(1, 0.125, 1), v(1, 0.125, 0), theTexture,1));
                    quads.add(createQuad(v(1, 0, 0), v(1, 0, 1), v(0, 0, 1), v(0, 0, 0), theTexture,1));
                    break;
            	}
            	case 12:{
            		quads.add(createQuad(v(0, 0.125, 1), v(1, 0.125, 1), v(1, 0.125, 0), v(0, 0.125, 0), theTexture,1));
                    quads.add(createQuad(v(0, 0, 0), v(1, 0, 0), v(1, 0, 1), v(0, 0, 1), theTexture,1));
                    break;
            	}
            	case 8:{
            		quads.add(createQuad(v(1, 0.125, 1), v(1, 0.125, 0), v(0, 0.125, 0), v(0, 0.125, 1), theTexture,1));
                    quads.add(createQuad(v(0, 0, 1), v(0, 0, 0), v(1, 0, 0), v(1, 0, 1), theTexture,1));
                    break;
            	}
            	case 4:{
            		quads.add(createQuad(v(1, 0.125, 0), v(0, 0.125, 0), v(0, 0.125, 1), v(1, 0.125, 1), theTexture,1));
                    quads.add(createQuad(v(1, 0, 1), v(0, 0, 1), v(0, 0, 0), v(1, 0, 0), theTexture,1));
                    break;
            	}
            	default:{
            		quads.add(createQuad(v(0, 0.125, 0), v(0, 0.125, 1), v(1, 0.125, 1), v(1, 0.125, 0), theTexture,1));
                    quads.add(createQuad(v(1, 0, 0), v(1, 0, 1), v(0, 0, 1), v(0, 0, 0), theTexture,1));
                    break;
            	}
            		
            	}
            	
                quads.add(createQuad(v(1, 0.125, 1), v(1, 0, 1), v(1, 0, 0), v(1, 0.125, 0), theTexture,0));
                quads.add(createQuad(v(0, 0.125, 0), v(0, 0, 0), v(0, 0, 1), v(0, 0.125, 1), theTexture,0));
                
                quads.add(createQuad(v(1, 0.125, 0), v(1, 0, 0), v(0, 0, 0), v(0, 0.125, 0), theTexture,0));
                quads.add(createQuad(v(0, 0.125, 1), v(0, 0, 1), v(1, 0, 1), v(1, 0.125, 1), theTexture,0));
                
            }
            else if(dirdirdir == Direction.EAST) {
                quads.add(createQuad(v(0.875, 1, 0), v(0.875, 1, 1), v(1, 1, 1), v(1, 1, 0), theTexture,0));
                quads.add(createQuad(v(0.875, 0, 0), v(1, 0, 0), v(1, 0, 1), v(0.875, 0, 1), theTexture,0));
                quads.add(createQuad(v(1, 1, 1), v(1, 0, 1), v(1, 0, 0), v(1, 1, 0), theTexture,1));
                quads.add(createQuad(v(0.875, 1, 0), v(0.875, 0, 0), v(0.875, 0, 1), v(0.875, 1, 1), theTexture,1));
                quads.add(createQuad(v(1, 1, 0), v(1, 0, 0), v(0.875, 0, 0), v(0.875, 1, 0), theTexture,0));
                quads.add(createQuad(v(0.875, 1, 1), v(0.875, 0, 1), v(1, 0, 1), v(1, 1, 1), theTexture,0));
            }
            else if(dirdirdir == Direction.WEST) {
                quads.add(createQuad(v(0, 1, 0), v(0, 1, 1), v(0.125, 1, 1), v(0.125, 1, 0), theTexture,0));
                quads.add(createQuad(v(0, 0, 0), v(0.125, 0, 0), v(0.125, 0, 1), v(0, 0, 1), theTexture,0));
                quads.add(createQuad(v(0.125, 1, 1), v(0.125, 0, 1), v(0.125, 0, 0), v(0.125, 1, 0), theTexture,1));
                quads.add(createQuad(v(0, 1, 0), v(0, 0, 0), v(0, 0, 1), v(0, 1, 1), theTexture,1));
                quads.add(createQuad(v(0.125, 1, 0), v(0.125, 0, 0), v(0, 0, 0), v(0, 1, 0), theTexture,0));
                quads.add(createQuad(v(0, 1, 1), v(0, 0, 1), v(0.125, 0, 1), v(0.125, 1, 1), theTexture,0));
            }
            else {
            	quads.add(createQuad(v(0, 1, 0), v(0, 1, 0.125), v(1, 1, 0.125), v(1, 1, 0), theTexture,0));
            	quads.add(createQuad(v(0, 0, 0), v(1, 0, 0), v(1, 0, 0.125), v(0, 0, 0.125), theTexture,0));
            	quads.add(createQuad(v(1, 1, 0.125), v(1, 0, 0.125), v(1, 0, 0), v(1, 1, 0), theTexture,0));
            	quads.add(createQuad(v(0, 1, 0), v(0, 0, 0), v(0, 0, 0.125), v(0, 1, 0.125), theTexture,0));
            	quads.add(createQuad(v(1, 1, 0), v(1, 0, 0), v(0, 0, 0), v(0, 1, 0), theTexture,1));
            	quads.add(createQuad(v(0, 1, 0.125), v(0, 0, 0.125), v(1, 0, 0.125), v(1, 1, 0.125), theTexture,1));
            }
        }

        return quads;
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return getDOWDIMTexture(1,31);
    }

    @Override
    public ItemOverrideList getOverrides() {
        return ItemOverrideList.EMPTY;
    }

    @Override
    public ItemCameraTransforms getTransforms() {
        return ItemCameraTransforms.NO_TRANSFORMS;
    }
}


