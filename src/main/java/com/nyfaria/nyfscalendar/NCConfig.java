package com.nyfaria.nyfscalendar;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class NCConfig {

    static{
        Pair<NCConfig,ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(NCConfig::new);
        CONFIG_SPEC = pair.getRight();
        INSTANCE = pair.getLeft();
    }

    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final NCConfig INSTANCE;

    public ForgeConfigSpec.IntValue startMonth;
    public ForgeConfigSpec.IntValue startDay;
    public ForgeConfigSpec.IntValue startYear;
    public ForgeConfigSpec.BooleanValue doSS;
    public ForgeConfigSpec.BooleanValue doLY;
    public ForgeConfigSpec.BooleanValue useCustomCalendar;
    public ForgeConfigSpec.ConfigValue<List<? extends String>> customMonthNames;
    public ForgeConfigSpec.ConfigValue<List<? extends String>> customDayNames;
    public ForgeConfigSpec.ConfigValue<List<? extends String>> customDayShorts;
    public ForgeConfigSpec.ConfigValue<List<? extends Integer>> customMonthLengths;
    public ForgeConfigSpec.ConfigValue<List<? extends Integer>> customLeapYears;
    public ForgeConfigSpec.IntValue leapMonth;
    public ForgeConfigSpec.IntValue startWeekday;
    public ForgeConfigSpec.ConfigValue<String> backColor;

    private NCConfig(ForgeConfigSpec.Builder builder){
        this.startMonth = builder.comment("What Month do you want your World to Start in?").defineInRange("startMonth", 1, 1, 9999);
        this.startDay = builder.comment("What day of the Month does your Server Start on?(Make sure it is a Valid day for  your Month)").defineInRange("startDay", 1, 1, 42);
        this.startYear = builder.comment("What Year do you want your World to Start in?").defineInRange("startYear", 2021 , -9999, 9999);
        this.doSS = builder.comment("Does this mod Control Serene Seasons?").define("doSS", true);
        builder.comment("#Everything Below this Line is related to Custom Calendars.");
        this.useCustomCalendar = builder.comment("Use Custom Calendar?").define("useCustomCalendar", false);
        this.customMonthNames = builder.comment("List of Custom Month Names").defineList("customMonthNames", Arrays.asList("January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),o -> true);
        this.customMonthLengths = builder.comment("List of Custom Month Lengths").defineList("customMonthLengths", Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31),o -> true);
        this.customLeapYears = builder.comment("List of Custom Leap Years").defineList("customLeapYears", Arrays.asList(2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 2056, 2060),o -> true);
        this.customDayNames = builder.comment("List of Custom Day Names(Custom week lengths are not supported yet. Must have 7 Days)").defineList("customDayNames", Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"),o -> true);
        this.customDayShorts = builder.comment("List of Custom Day Shorts(At Most 2 Characters)").defineList("customDayShorts", Arrays.asList("S", "M", "T", "W", "T", "F", "S"),o -> true);
        this.doLY = builder.comment("Does your Calendar Have Leap Years?").define("doLY", true);
        this.leapMonth = builder.comment("What Number Month is the Leap day in? (Make sure you have that Month in your Calendar)").defineInRange("leapMonth", 2 , 1, 9999);
        this.startWeekday = builder.comment("What day of the Week (Number) does your start Year Start on?").defineInRange("startWeekday", 1, 1, 7);
        this.backColor = builder.comment("Color of Back (must be one of the 16 wool colors)").define("backColor", "black");
    }

}