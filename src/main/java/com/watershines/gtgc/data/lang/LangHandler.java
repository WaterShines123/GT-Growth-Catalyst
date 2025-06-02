package com.watershines.gtgc.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LangHandler extends com.gregtechceu.gtceu.data.lang.LangHandler {

    public static void init(RegistrateLangProvider provider) {
        replace(provider, "material.gtgc.tier1_growth_fluid", "Tier 1 Growth Fluid");
        replace(provider, "material.gtgc.tier2_growth_fluid", "Tier 2 Growth Fluid");
        replace(provider, "material.gtgc.tier3_growth_fluid", "Tier 3 Growth Fluid");
        replace(provider, "material.gtgc.tier4_growth_fluid", "Tier 4 Growth Fluid");
        replace(provider, "material.gtgc.tier5_growth_fluid", "Tier 5 Growth Fluid");
        replace(provider, "material.gtgc.tmt_alloy", "TMT Alloy");

        replace(provider, "item.gtgc.tmt_catalyst", "TMT Catalyst");

        replace(provider, "gtgc.greenhouseSoilTier", "Minimum Soil Tier %d");
        replace(provider, "gtgc.multiblock.greenhouse_soil_tier", "Soil Tier %d");
        replace(provider, "gtgc.multiblock.catalyst_speed_boost", "Running at %dx speed");
        replace(provider, "gtgc.multiblock.greenhouse_glass_tier", "Glass Tier %d");
        replace(provider, "gtgc.recipe.greenhouseSoilTier", "Minimum Soil Tier %d");

        replace(provider, "gtceu.greenhouse", "Greenhouse");
        replace(provider, "gtceu.multiblock_altar", "Multiblock Altar");

        replace(provider, "crop.gtgc.molybdenum", "Molybdenum");
    }
}
