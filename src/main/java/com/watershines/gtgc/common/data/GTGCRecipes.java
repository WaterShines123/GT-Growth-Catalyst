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
    static Item goldEssence = ForgeRegistries.ITEMS.getValue(
            new ResourceLocation(MysticalAgriculture.MOD_ID, "gold_essence"));
    static Item goldSeeds = ForgeRegistries.ITEMS.getValue(
            new ResourceLocation(MysticalAgriculture.MOD_ID, "gold_seeds"));
    static Item fertilizer = ForgeRegistries.ITEMS.getValue(
            new ResourceLocation(GTCEu.MOD_ID, "fertilizer"));

    public static void init(Consumer<FinishedRecipe> provider) {
        GREENHOUSE_TEST.recipeBuilder("iron_essence_growing")
                .circuitMeta(1)
                .addData("min_soil_tier", 3)
                .notConsumable(new ItemStack(ironSeeds, 1))
                .inputItems(new ItemStack(fertilizer, 4))
                .inputFluids(Water.getFluid(1000))
                .outputItems(new ItemStack(ironEssence, 4))
                .duration(400).EUt(VA[IV]).save(provider);

        GREENHOUSE_TEST.recipeBuilder("gold_essence_growing")
                .circuitMeta(1)
                .addData("min_soil_tier", 4)
                .notConsumable(new ItemStack(goldSeeds, 1))
                .inputItems(new ItemStack(fertilizer, 4))
                .inputFluids(Water.getFluid(1000))
                .outputItems(new ItemStack(goldEssence, 4))
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

        BLAST_RECIPES.recipeBuilder("molten_gold_essence")
                .blastFurnaceTemp(5400)
                .inputItems(dust, Borax, 1)
                .inputItems(new ItemStack(goldEssence, 16))
                .outputFluids(MoltenGoldEssence.getFluid(1000))
                .duration(16).EUt(VA[IV]).save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("gold_rich_sludge")
                .inputFluids(MoltenGoldEssence.getFluid(1000))
                .outputFluids(GoldRichSludge.getFluid(500))
                .outputItems(dust, ImpureOrganicResidue, 2)
                .outputFluids(EssenceWastewater.getFluid(500))
                .duration(30).EUt(VA[IV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("neutralize_gold_sludge")
                .inputFluids(GoldRichSludge.getFluid(500))
                .inputItems(dust, CalciumCarbonate, 5) // as a neutralizing agent
                .outputFluids(NeutralizedGoldSludge.getFluid(500))
                .outputItems(dust, CalciumChloride, 3)
                .duration(30).EUt(VA[IV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("dissolve_gold_sludge")
                .inputFluids(NeutralizedGoldSludge.getFluid(500))
                .inputFluids(AquaRegia.getFluid(1000))
                .outputFluids(GoldSolution.getFluid(750))
                .outputFluids(NitricOxide.getFluid(250))
                .duration(40).EUt(VA[LuV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("precipitate_gold")
                .inputFluids(GoldSolution.getFluid(750))
                .inputItems(dust, SodiumMetabisulfite, 3)
                .outputItems(dust, Gold, 1)
                .outputItems(dust, SodiumBisulfate, 3)
                .outputFluids(HydrochloricAcid.getFluid(250))
                .duration(40).EUt(VA[LuV]).save(provider);

        BLAST_RECIPES.recipeBuilder("sulfur_to_sulfur_dioxide")
                .blastFurnaceTemp(2400)
                .inputItems(dust, Sulfur, 1)
                .outputFluids(SulfurDioxide.getFluid(1000))
                .duration(20).EUt(VA[HV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("so2_absorption")
                .inputFluids(SulfurDioxide.getFluid(1000))
                .inputItems(dust, SodiumHydroxide, 6)
                .outputFluids(SodiumSulfite.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .duration(30).EUt(VA[HV]).save(provider);

        CHEMICAL_RECIPES.recipeBuilder("sulfite_to_metabisulfite")
                .inputFluids(SodiumSulfite.getFluid(1000))
                .inputFluids(SulfurDioxide.getFluid(500))
                .outputFluids(SodiumMetabisulfiteSolution.getFluid(1000))
                .duration(30).EUt(VA[HV]).save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("metabisulfite_crystallization")
                .inputFluids(SodiumMetabisulfiteSolution.getFluid(1000))
                .outputItems(dust, SodiumMetabisulfite, 1)
                .duration(40).EUt(VA[HV]).save(provider);
    }
}
