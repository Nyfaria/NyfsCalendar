package com.nyfaria.nyfscalendar.data.client;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DynamicCalendarModelBuilder <T extends ModelBuilder<T>> extends CustomLoaderBuilder<T>
{
    public static <T extends ModelBuilder<T>> DynamicCalendarModelBuilder<T> begin(T parent, ExistingFileHelper existingFileHelper)
    {
        return new DynamicCalendarModelBuilder<>(parent, existingFileHelper);
    }

    private ResourceLocation month;
    private ResourceLocation dayofweek;
    private ResourceLocation slot;

    protected DynamicCalendarModelBuilder(T parent, ExistingFileHelper existingFileHelper)
    {
        super(new ResourceLocation("nyfscalendar","nyfs_calendar"), parent, existingFileHelper);
    }

    public DynamicCalendarModelBuilder<T> dayofweek(int dayofweek,int daysinmonth)
    {
        Preconditions.checkNotNull(dayofweek, "dayofweek must not be null");
        this.dayofweek = new ResourceLocation("nyfscalendar","weekday" + month + "days" + daysinmonth);
        return this;
    }

    public DynamicCalendarModelBuilder<T> month(int month)
    {
        Preconditions.checkNotNull(month, "month must not be null");
        this.month = new ResourceLocation("nyfscalendar","month" + month);
        return this;
    }

    public DynamicCalendarModelBuilder<T> slot(int slot)
    {
        Preconditions.checkNotNull(slot, "slot must not be null");
        this.slot = new ResourceLocation("nyfscalendar","slot" + slot);
        return this;
    }

    @Override
    public JsonObject toJson(JsonObject json)
    {
        json = super.toJson(json);

        Preconditions.checkNotNull(month, "month must not be null");
        Preconditions.checkNotNull(slot, "slot must not be null");
        Preconditions.checkNotNull(dayofweek, "dayofweek must not be null");
        
        json.addProperty("layer0", month.toString());
        json.addProperty("layer1", dayofweek.toString());
        json.addProperty("layer2", slot.toString());


        return json;
    }
}
