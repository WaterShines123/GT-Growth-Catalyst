package com.watershines.gtgc.lib;

import com.blakebr0.mysticalagriculture.api.IMysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.MysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.lib.PluginConfig;
import com.blakebr0.mysticalagriculture.api.registry.ICropRegistry;
import com.watershines.gtgc.common.data.materials.GTGCCrops;

import static com.watershines.gtgc.GTGrowthCatalyst.MOD_ID;

@MysticalAgriculturePlugin
public final class ModCorePlugin implements IMysticalAgriculturePlugin {

    @Override
    public void configure(PluginConfig config) {
        config.setModId(MOD_ID);
        // config.disableDynamicSeedCraftingRecipes();
        // config.disableDynamicSeedInfusionRecipes();
        // config.disableDynamicSeedReprocessingRecipes();
    }

    @Override
    public void onRegisterCrops(ICropRegistry registry) {
        // ModCropTiers.onRegisterCrops(registry);
        GTGCCrops.onRegisterCrops(registry);
    }

    @Override
    public void onPostRegisterCrops(ICropRegistry registry) {
        // ModCropTiers.onPostRegisterCrops(registry);
        // GTGCCrops.onPostRegisterCrops(registry);
    }
}
