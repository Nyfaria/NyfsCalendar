package com.nyfaria.nyfscalendar;

import net.minecraftforge.common.ForgeConfigSpec;
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

    private NCConfig(ForgeConfigSpec.Builder builder){
        this.startMonth = builder.worldRestart().comment("What Month do you want your World to Start in?").defineInRange("startMonth", 1, 1, 12);
        this.startDay = builder.worldRestart().comment("What day of the Mont does your Server Start on?(Make sure it is a Valid day for  your Month)").defineInRange("startDay", 1, 1, 31);
        this.startYear = builder.worldRestart().comment("What Year do you want your World to Start in?").defineInRange("startYear", 2012, 1990, 2021);
        this.doSS = builder.worldRestart().comment("Does this mod Control Serene Seasons?").define("doSS", true);
    }

}