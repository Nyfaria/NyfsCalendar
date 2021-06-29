package com.nyfaria.nyfscalendar.blocks;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelConfiguration;
import net.minecraftforge.client.model.geometry.IModelGeometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class CalendarModelGeometry implements IModelGeometry<CalendarModelGeometry> {

    @Override
    public IBakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<RenderMaterial, TextureAtlasSprite> spriteGetter, IModelTransform modelTransform, ItemOverrideList overrides, ResourceLocation modelLocation) {
        return new CalendarBakedModel();
    }

    @Override
    public Collection<RenderMaterial> getTextures(IModelConfiguration owner, Function<ResourceLocation, IUnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
        
    	List<RenderMaterial> list = new ArrayList<RenderMaterial>();
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_1_31));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_2_31));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_3_31));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_4_31));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_5_31));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_6_31));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_7_31));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_1_30));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_2_30));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_3_30));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_4_30));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_5_30));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_6_30));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_7_30));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_1_28));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_2_28));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_3_28));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_4_28));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_5_28));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_6_28));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_7_28));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_1_29));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_2_29));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_3_29));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_4_29));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_5_29));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_6_29));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_DOWDIM_7_29));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_1));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_2));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_3));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_4));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_5));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_6));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_7));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_8));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_9));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_10));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_11));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_MONTH_12));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_0));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_1));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_2));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_3));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_4));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_5));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_6));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_7));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_8));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_9));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_10));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_11));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_12));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_13));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_14));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_15));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_16));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_17));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_18));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_19));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_20));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_21));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_22));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_23));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_24));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_25));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_26));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_27));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_28));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_29));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_30));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_31));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_32));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_33));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_34));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_35));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_36));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_37));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_38));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.TEXTURE_SLOT_39));
    	list.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, CalendarBakedModel.LETTERS_NUMBERS));
    	
    	return Collections.synchronizedList(list);
        }
}