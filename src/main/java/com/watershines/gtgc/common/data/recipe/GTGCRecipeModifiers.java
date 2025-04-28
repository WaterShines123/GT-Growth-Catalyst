package com.watershines.gtgc.common.data.recipe;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;

import com.watershines.gtgc.api.machine.multiblock.GreenhouseMultiblockMachine;
import org.jetbrains.annotations.NotNull;

public class GTGCRecipeModifiers {

    public static @NotNull ModifierFunction greenhouseOverclock(@NotNull MetaMachine machine,
                                                                @NotNull GTRecipe recipe) {
        if (!(machine instanceof GreenhouseMultiblockMachine greenhouseMachine)) {
            return RecipeModifier.nullWrongType(GreenhouseMultiblockMachine.class, machine);
        }
        int greenhouseSoilTier = greenhouseMachine.getSoilTier();

        if (!recipe.data.contains("min_soil_tier") || recipe.data.getInt("min_soil_tier") > greenhouseSoilTier) {
            return ModifierFunction.NULL;
        }
        int tier_difference = greenhouseSoilTier - recipe.data.getInt("min_soil_tier");
        double durationModifier = 1.0 / (1.0 + 0.25 * tier_difference);
        float eutModifier = greenhouseMachine.getGlassType().getEnergyDiscount();

        if (RecipeHelper.getRecipeEUtTier(recipe) > greenhouseMachine.getTier()) {
            return ModifierFunction.NULL;
        }
        return ModifierFunction.builder()
                .durationMultiplier(durationModifier)
                .eutMultiplier(eutModifier)
                .build();
    }
}
