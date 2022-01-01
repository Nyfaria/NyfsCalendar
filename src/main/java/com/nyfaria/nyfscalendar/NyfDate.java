package com.nyfaria.nyfscalendar;

import com.nyfaria.nyfscalendar.NCConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.event.GuiOpenEvent;

import java.util.List;

public class NyfDate {

    public static int  DAYSOFYEAR = NCConfig.INSTANCE.customMonthLengths.get().stream().mapToInt(Integer::intValue).sum();
    public static List<? extends Integer> DAYSINMONTHS = NCConfig.INSTANCE.customMonthLengths.get();
    public static List<? extends String> MONTHNAMES = NCConfig.INSTANCE.customMonthNames.get();
    public static List<? extends String> WEEKDAYNAMES = NCConfig.INSTANCE.customDayNames.get();
    public static List<? extends String> WEEKDAYSHORTS = NCConfig.INSTANCE.customDayShorts.get();
    public static int DAYYEARSTARTSON = NCConfig.INSTANCE.startWeekday.get();
    public static boolean DOLEAPYEAR = NCConfig.INSTANCE.doLY.get();
    public static int MONTHOFLEAPYEAR = NCConfig.INSTANCE.leapMonth.get();
    public static int STARTDAY = NCConfig.INSTANCE.startDay.get();
    public static int STARTMONTH = NCConfig.INSTANCE.startMonth.get();
    public static int STARTYEAR = NCConfig.INSTANCE.startYear.get();
    public long STARTINGDAY;

    public NyfDate() {
        DAYSOFYEAR = NCConfig.INSTANCE.customMonthLengths.get().stream().mapToInt(Integer::intValue).sum();
        DAYSINMONTHS = NCConfig.INSTANCE.customMonthLengths.get();
        MONTHNAMES = NCConfig.INSTANCE.customMonthNames.get();
        WEEKDAYNAMES = NCConfig.INSTANCE.customDayNames.get();
        DAYYEARSTARTSON = NCConfig.INSTANCE.startWeekday.get();
        DOLEAPYEAR = NCConfig.INSTANCE.doLY.get();
        MONTHOFLEAPYEAR = NCConfig.INSTANCE.leapMonth.get();
        STARTDAY = NCConfig.INSTANCE.startDay.get();
        STARTMONTH = NCConfig.INSTANCE.startMonth.get();
        STARTYEAR = NCConfig.INSTANCE.startYear.get();
        WEEKDAYSHORTS = NCConfig.INSTANCE.customDayShorts.get();

        int daysSinceStart = 0;
        for(int i = 0; i < DAYSINMONTHS.stream().count(); i++)
        {
            if(i + 1 == STARTMONTH){
                daysSinceStart += STARTDAY;
                break;
            }
            daysSinceStart += DAYSINMONTHS.get(i);
        }
        //System.out.println(daysSinceStart);
        STARTINGDAY = daysSinceStart;
    }



    public long getDay(){

        long currentDay = (STARTINGDAY + serverAge()) % DAYSOFYEAR;
        //int counter = 0;
        for(int k = 0; k < DAYSINMONTHS.stream().count(); k++){
            //counter += DAYSINMONTHS.get(k);
            if(DAYSINMONTHS.get(k) > currentDay){
                return currentDay;
            }
            else
            {
                currentDay -= DAYSINMONTHS.get(k);
            }


        }
        return 0;
    }

    public int getMonth(){

        long currentDay = (STARTINGDAY + serverAge()) % DAYSOFYEAR;
        for(int k = 0; k < DAYSINMONTHS.stream().count(); k++) {
            if (DAYSINMONTHS.get(k) > currentDay) {
                return k + 1;
            } else {
                currentDay -= DAYSINMONTHS.get(k);
            }
        }
        return 1;
    }
    public long getYear(){
        return (long)Math.floor(STARTYEAR + (STARTINGDAY + serverAge()) / DAYSOFYEAR);
    }
    public int getDaysInMonth(int i){
        return DAYSINMONTHS.get(i-1);
    }

    public String getMonthDisplayName() {
        return MONTHNAMES.get(getMonth() - 1);
    }
    public String displayDate(){
        return getMonth() + "/" + getDay() + "/" + getYear();
    }
    public long serverAge(){
        return Minecraft.getInstance().level.getDayTime() / 24000L % 2147483647L;
    }
    public long getDayOfWeek(){
        return  (DAYYEARSTARTSON + STARTDAY + serverAge() + 1) % 7;
    }
    public String getWeekdayDisplayName(){
        return WEEKDAYNAMES.get((int)getDayOfWeek());
    }
    public long getFirstDayOfMonth(){
        return (DAYYEARSTARTSON + STARTDAY + serverAge() + 1 - getDay() + 1) % 7;
    }
    public String getWeekDayShort(int i){
        return WEEKDAYSHORTS.get(i);
    }
}
