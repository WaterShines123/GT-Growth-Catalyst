package com.watershines.gtgc.gtbridge;

import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;

public class GTGCRecipeTypes {

    public static final GTRecipeType GREENHOUSE_TEST = GTRecipeTypes
            .register("greenhouse_test", GTRecipeTypes.MULTIBLOCK)
            .addDataInfo(data -> {
                int greenhouseSoilTier = data.getInt("min_soil_tier");
                return LocalizationUtils.format("gtgc.recipe.greenhouseSoilTier", greenhouseSoilTier);
            })
            .setMaxIOSize(3, 2, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static void init() {}
}
