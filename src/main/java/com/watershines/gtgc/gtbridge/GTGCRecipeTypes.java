package com.watershines.gtgc.gtbridge;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;

import com.watershines.gtgc.common.data.GTGCMachines;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.DISTILLERY_RECIPES;
import static com.lowdragmc.lowdraglib.gui.texture.ProgressTexture.FillDirection.LEFT_TO_RIGHT;

public class GTGCRecipeTypes {

    public static final GTRecipeType GREENHOUSE = GTRecipeTypes
            .register("greenhouse", GTRecipeTypes.MULTIBLOCK)
            .addDataInfo(data -> {
                int greenhouseSoilTier = data.getInt("min_soil_tier");
                return LocalizationUtils.format("gtgc.recipe.greenhouseSoilTier", greenhouseSoilTier);
            })
            .setMaxIOSize(3, 4, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public static final GTRecipeType MULTIBLOCK_ALTAR = GTRecipeTypes
            .register("multiblock_altar", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(4, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT);

    public final static GTRecipeType BIO_REACTOR_RECIPES = GTRecipeTypes
            .register("bio_reactor_recipes", GTRecipeTypes.ELECTRIC)
            .setMaxIOSize(2, 1, 2, 1).setEUIO(IO.IN)
            .setSlotOverlay(false, false, GuiTextures.FURNACE_OVERLAY_1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setIconSupplier(() -> GTGCMachines.BIO_REACTOR[GTValues.LV].asStack())
            .setSound(GTSoundEntries.FURNACE);

    public final static GTRecipeType ENZYME_REACTOR_RECIPES = GTRecipeTypes
            .register("enzyme_reactor_recipes", GTRecipeTypes.ELECTRIC)
            .setMaxIOSize(2, 2, 2, 2).setEUIO(IO.IN)
            .setSlotOverlay(false, false, GuiTextures.FURNACE_OVERLAY_1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setIconSupplier(() -> GTGCMachines.ENZYME_REACTOR[GTValues.LV].asStack())
            .setSound(GTSoundEntries.FURNACE);

    public final static GTRecipeType NUTRIENT_SYNTHESIZER_RECIPES = GTRecipeTypes
            .register("nutrient_synthesizer_recipes", GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(6, 2, 2, 2).setEUIO(IO.IN)
            .setSlotOverlay(false, false, GuiTextures.FURNACE_OVERLAY_1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE);

    public static void init() {
        DISTILLERY_RECIPES.setMaxIOSize(1, 1, 2, 2);
    }
}
