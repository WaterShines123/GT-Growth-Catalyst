package com.watershines.gtgc.config;

import com.gregtechceu.gtceu.config.ConfigHolder;

import com.watershines.gtgc.GTGrowthCatalyst;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = GTGrowthCatalyst.MOD_ID)
public class ConfigHandler {

    public static ConfigHolder INSTANCE;
    private static final Object LOCK = new Object();

    public static void init() {
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = Configuration.registerConfig(ConfigHolder.class, ConfigFormats.yaml()).getConfigInstance();
            }
        }
    }
}
