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
    public ForgeConfigSpec.BooleanValue useCustomCalendar;
    public ForgeConfigSpec.ConfigValue<List<String>> customMonthNames;
    public ForgeConfigSpec.ConfigValue<List<Integer>> customMonthLengths;

    private NCConfig(ForgeConfigSpec.Builder builder){
        this.startMonth = builder.worldRestart().comment("What Month do you want your World to Start in?").defineInRange("startMonth", 1, 1, 12);
        this.startDay = builder.worldRestart().comment("What day of the Mont does your Server Start on?(Make sure it is a Valid day for  your Month)").defineInRange("startDay", 1, 1, 31);
        this.startYear = builder.worldRestart().comment("What Year do you want your World to Start in?").defineInRange("startYear", 2012, 1990, 2021);
        this.doSS = builder.worldRestart().comment("Does this mod Control Serene Seasons?").define("doSS", true);
        
        this.useCustomCalendar = builder.worldRestart().comment("Use Custom Calendar?").define("useCustomCalendar", false);
        this.customMonthNames = builder.worldRestart().comment("List of Custom Months, Separate with a Comma ,").define("customMonthNames", Arrays.asList("January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));
        this.customMonthLengths = builder.worldRestart().comment("List of Custom Months, Separate with a Comma ,").define("customMonthLengths", Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));
    }

}