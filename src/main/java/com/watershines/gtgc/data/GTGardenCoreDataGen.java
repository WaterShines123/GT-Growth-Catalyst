package com.watershines.gtgc.data;

import com.tterrag.registrate.providers.ProviderType;
import com.watershines.gtgc.data.lang.LangHandler;

import static com.watershines.gtgc.GTGrowthCatalyst.REGISTRATE;

public class GTGardenCoreDataGen {

    public static void init() {
        REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}
