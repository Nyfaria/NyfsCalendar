package com.nyfaria.nyfscalendar.blocks;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.client.model.IModelLoader;

public class CalendarModelLoader implements IModelLoader<CalendarModelGeometry> {

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {

    }

    @Override
    public CalendarModelGeometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
        return new CalendarModelGeometry();
    }
}
