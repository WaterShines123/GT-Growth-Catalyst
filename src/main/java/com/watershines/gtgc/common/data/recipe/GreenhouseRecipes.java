package com.watershines.gtgc.common.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Water;
import static com.watershines.gtgc.common.data.recipe.GTGCRecipeUtils.*;
import static com.watershines.gtgc.gtbridge.GTGCRecipeTypes.GREENHOUSE;

public class GreenhouseRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        defineCropRecipes(provider);

        GREENHOUSE.recipeBuilder("wheat_growing")
                .addData("min_soil_tier", 0)
                .circuitMeta(1)
                .inputFluids(Water.getFluid(2000))
                .inputItems(new ItemStack(Items.WHEAT_SEEDS, 1))
                .outputItems(new ItemStack(Items.WHEAT, 2))
                .chancedOutput(new ItemStack(Items.WHEAT, 1), 5000, 0)
                .chancedOutput(new ItemStack(Items.WHEAT, 1), 2500, 0)
                .duration(400).EUt(VA[HV]).save(provider);

        GREENHOUSE.recipeBuilder("mushroom_growing")
                .addData("min_soil_tier", 0)
                .circuitMeta(1)
                .inputFluids(Water.getFluid(2000))
                .inputItems(new ItemStack(Items.RED_MUSHROOM, 1))
                .outputItems(new ItemStack(Items.RED_MUSHROOM, 5))
                .chancedOutput(new ItemStack(Items.RED_MUSHROOM, 2), 5000, 0)
                .chancedOutput(new ItemStack(Items.RED_MUSHROOM, 1), 2500, 0)
                .duration(400).EUt(VA[HV]).save(provider);

        GREENHOUSE.recipeBuilder("mushroom_growing")
                .addData("min_soil_tier", 0)
                .circuitMeta(1)
                .inputFluids(Water.getFluid(2000))
                .inputItems(new ItemStack(Items.BROWN_MUSHROOM, 1))
                .outputItems(new ItemStack(Items.BROWN_MUSHROOM, 5))
                .chancedOutput(new ItemStack(Items.BROWN_MUSHROOM, 2), 5000, 0)
                .chancedOutput(new ItemStack(Items.BROWN_MUSHROOM, 1), 2500, 0)
                .duration(400).EUt(VA[HV]).save(provider);
        /*
         * GREENHOUSE.recipeBuilder("iron_essence_growing")
         * .addData("min_tier", 3)
         * .circuitMeta(1)
         * .inputFluids(Tier3GrowthFluid.getFluid(2000))
         * .chancedInput(new ItemStack(ironSeeds, 1), 500, -50)
         * .outputItems(new ItemStack(ironEssence, 2))
         * .chancedOutput(new ItemStack(ironEssence, 1), 5000, 0)
         * .chancedOutput(new ItemStack(ironSeeds, 1), 500, 0)
         * .duration(400).EUt(VA[IV]).save(provider);
         */
    }

    public static void defineCropRecipes(Consumer<FinishedRecipe> provider) {
        for (com.blakebr0.mysticalagriculture.api.crop.Crop crop : Crops) {
            int tier = crop.getTier().getValue();
            Item seed = crop.getSeedsItem();
            Item essence = crop.getEssenceItem();

            for (int i = tier; i <= 5; i++) {
                int output_multiplier = i - tier + 1;
                GREENHOUSE.recipeBuilder(crop.getName() + "_essence_growing_" + i)
                        .addData("min_soil_tier", i)
                        .inputFluids(GrowthMediums[i - 1].getFluid(2000))
                        .chancedInput(new ItemStack(seed, 1), 500, -50)
                        .outputItems(new ItemStack(essence, 2 * output_multiplier))
                        .chancedOutput(new ItemStack(essence, output_multiplier), 5000, 0)
                        .chancedOutput(new ItemStack(seed, output_multiplier), 500, 0)
                        .duration(400).EUt(VA[MV + i]).save(provider);
            }
        }
    }
}
