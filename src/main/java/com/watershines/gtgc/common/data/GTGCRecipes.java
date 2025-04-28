package com.watershines.gtgc.common.data;

import com.gregtechceu.gtceu.GTCEu;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import com.blakebr0.mysticalagriculture.MysticalAgriculture;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.watershines.gtgc.common.data.GTGCMaterials.*;
import static com.watershines.gtgc.gtbridge.GTGCRecipeTypes.GREENHOUSE_TEST;

public class GTGCRecipes {

    static Item ironEssence = ForgeRegistries.ITEMS.getValue(
            new ResourceLocation(MysticalAgriculture.MOD_ID, "iron_essence"));
    static Item ironSeeds = ForgeRegistries.ITEMS.getValue(
            new ResourceLocation(MysticalAgriculture.MOD_ID, "iron_seeds"));
    static Item fertilizer = ForgeRegistries.ITEMS.getValue(
            new ResourceLocation(GTCEu.MOD_ID, "fertilizer"));

    public static void init(Consumer<FinishedRecipe> provider) {
        GREENHOUSE_TEST.recipeBuilder("iron_essence_growing")
                .circuitMeta(1)
                .addData("min_soil_tier", 3)
                .notConsumable(new ItemStack(ironSeeds, 1))
                .inputItems(new ItemStack(fertilizer, 4))
                .inputFluids(Water.getFluid(1000))
                .outputItems(new ItemStack(ironEssence, 1))
                .duration(400).EUt(VA[IV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("iron3_sulfate_from_essence")
                .inputItems(new ItemStack(ironEssence, 16))
                .inputFluids(SulfuricAcid.getFluid(3000))
                .outputItems(dust, Iron3Sulfate, 17)
                .outputFluids(Hydrogen.getFluid(6000))
                .duration(16).EUt(VA[IV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("iron3_hydroxide_slurry")
                .inputItems(dust, SodiumHydroxide, 12)
                .inputItems(dust, Iron3Sulfate, 17)
                .outputItems(dust, SodiumSulfate, 14)
                .outputFluids(Iron3HydroxideSlurry.getFluid(2000))
                .duration(16).EUt(VA[IV]).save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("hydrated_iron3_hydroxide")
                .inputFluids(Iron3HydroxideSlurry.getFluid(1000))
                .outputItems(dust, HydratedIron3Hydroxide, 10)
                .outputFluids(EssenceWastewater.getFluid(1000))
                .duration(16).EUt(VA[IV]).save(provider);

        BLAST_RECIPES.recipeBuilder("iron3_oxide")
                .blastFurnaceTemp(5400)
                .inputItems(dust, HydratedIron3Hydroxide, 20)
                .outputItems(dust, Iron3Oxide, 5)
                .outputFluids(Steam.getFluid(3000))
                .duration(16).EUt(VA[IV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("iron3_sulfate_reduction")
                .inputItems(dust, Iron3Oxide, 5)
                .inputFluids(CarbonMonoxide.getFluid(3000))
                .outputItems(dust, Iron, 2)
                .outputFluids(CarbonDioxide.getFluid(3000))
                .duration(16).EUt(VA[IV]).save(provider);
    }
}
