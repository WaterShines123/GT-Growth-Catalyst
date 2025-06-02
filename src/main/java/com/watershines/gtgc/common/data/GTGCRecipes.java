package com.watershines.gtgc.common.data;

import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import com.watershines.gtgc.common.data.recipe.GreenhouseRecipes;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GCYMRecipeTypes.ALLOY_BLAST_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTItems.BIO_CHAFF;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.watershines.gtgc.common.data.GTGCItems.*;
import static com.watershines.gtgc.common.data.GTGCMaterials.*;
import static com.watershines.gtgc.common.data.recipe.GTGCRecipeUtils.*;
import static com.watershines.gtgc.gtbridge.GTGCRecipeTypes.*;

public class GTGCRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        // SeedRecipes.init(provider);
        GreenhouseRecipes.init(provider);

        FERMENTING_RECIPES.recipeBuilder("diluted_bio_slurry")
                .inputFluids(Biomass.getFluid(1000))
                .inputItems(dust, Sugar, 2)
                .outputFluids(DilutedBioSlurry.getFluid(1000))
                .duration(80).EUt(VA[MV])
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("raw_nutrient_fluid")
                .inputFluids(DilutedBioSlurry.getFluid(1000))
                .outputFluids(RawNutrientFluid.getFluid(1000))
                .outputItems(dust, ImpureOrganicResidue, 5)
                .duration(60).EUt(VA[MV])
                .save(provider);

        MIXER_RECIPES.recipeBuilder("tier1_growth_fluid")
                .inputFluids(RawNutrientFluid.getFluid(1000))
                .inputItems(new ItemStack(Items.BONE_MEAL, 2))
                .inputItems(dust, Saltpeter, 1)
                .outputFluids(Tier1GrowthFluid.getFluid(1000))
                .duration(100).EUt(VA[HV])
                .save(provider);

        MIXER_RECIPES.recipeBuilder("mineral_enrichment")
                .inputFluids(Water.getFluid(1000))
                .inputItems(dust, Flint, 2)
                .inputItems(dust, Stone, 1)
                .outputFluids(MineralSuspension.getFluid(1000))
                .duration(80).EUt(VA[LV])
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("chelation_reaction")
                .inputFluids(MineralSuspension.getFluid(1000))
                .inputItems(dust, CitricAcid, 5)
                .outputFluids(ChelatedNutrientSolution.getFluid(1000))
                .duration(100).EUt(VA[HV])
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("filtration")
                .inputFluids(ChelatedNutrientSolution.getFluid(1000))
                .outputFluids(FilteredGrowthPrecursor.getFluid(1000))
                .outputItems(dust, ImpureOrganicResidue, 1)
                .duration(80).EUt(VA[HV])
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("stabilization")
                .inputFluids(FilteredGrowthPrecursor.getFluid(1000))
                .inputItems(dust, Urea, 2)
                .inputItems(plate, Stone, 1)
                .outputFluids(Tier2GrowthFluid.getFluid(1000))
                .duration(100).EUt(VA[EV])
                .save(provider);

        MIXER_RECIPES.recipeBuilder("glucose_solution")
                .inputItems(dust, Sugar, 2)
                .inputFluids(Water.getFluid(1000))
                .outputFluids(GlucoseSolution.getFluid(1000))
                .duration(80).EUt(VA[HV])
                .save(provider);

        FERMENTING_RECIPES.recipeBuilder("citric_acid_solution")
                .inputFluids(GlucoseSolution.getFluid(3000))
                .outputFluids(CitricAcidSolution.getFluid(2000))
                .outputItems(BIO_CHAFF, 2)
                .duration(120).EUt(VA[HV])
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("citric_acid_extraction")
                .inputFluids(CitricAcidSolution.getFluid(1000))
                .outputItems(dust, CitricAcid, 21)
                .outputFluids(Water.getFluid(500))
                .duration(60).EUt(VA[EV])
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("ammonium_solution")
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(AmmoniumSolution.getFluid(1000))
                .duration(60).EUt(VA[HV])
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder("nitrogen_rich_slurry")
                .inputFluids(Biomass.getFluid(500))
                .inputFluids(CitricAcidSolution.getFluid(500))
                .outputFluids(NitrogenRichSlurry.getFluid(1000))
                .duration(100).EUt(VA[EV])
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("urea_solution")
                .inputFluids(NitrogenRichSlurry.getFluid(1000))
                .inputFluids(AmmoniumSolution.getFluid(1000))
                .outputFluids(UreaSolution.getFluid(1000))
                .duration(120).EUt(VA[EV])
                .save(provider);

        CENTRIFUGE_RECIPES.recipeBuilder("urea_extraction")
                .inputFluids(UreaSolution.getFluid(1000))
                .outputItems(dust, Urea, 2)
                .outputFluids(Water.getFluid(500))
                .duration(80).EUt(VA[EV])
                .save(provider);

        BLAST_RECIPES.recipeBuilder("roast_yttrium")
                .inputItems(dust, Yttrium, 2)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, YttriumOxide, 5)
                .duration(400).EUt(VA[IV])
                .blastFurnaceTemp(5200)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("mushroom_slurry")
                .inputItems(new ItemStack(Items.BROWN_MUSHROOM, 8))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(MushroomSlurry.getFluid(1000))
                .duration(80).EUt(VA[HV])
                .save(provider);

        MIXER_RECIPES.recipeBuilder("mushroom_slurry")
                .inputItems(new ItemStack(Items.RED_MUSHROOM, 8))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(MushroomSlurry.getFluid(1000))
                .duration(80).EUt(VA[HV])
                .save(provider);

        ENZYME_REACTOR_RECIPES.recipeBuilder("protein_hydrolysate")
                .inputFluids(MushroomSlurry.getFluid(1000))
                .inputFluids(EnzymeSolution.getFluid(250))
                .outputFluids(ProteinHydrolysate.getFluid(1000))
                .duration(100).EUt(VA[HV])
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("mystic_hydrolysate")
                .inputFluids(ProteinHydrolysate.getFluid(1000))
                .inputItems(new ItemStack(tertiumEssence, 4))
                .inputItems(dust, YttriumOxide, 1)
                .outputFluids(MysticHydrolysate.getFluid(1000))
                .duration(160).EUt(VA[IV])
                .save(provider);

        AUTOCLAVE_RECIPES.recipeBuilder("sterile_nutrient_broth")
                .inputFluids(MysticHydrolysate.getFluid(1000))
                .outputFluids(SterileNutrientBroth.getFluid(1000))
                .duration(120).EUt(VA[IV])
                .save(provider);

        NUTRIENT_SYNTHESIZER_RECIPES.recipeBuilder("bio_active_nutrient_suspension")
                .inputFluids(SterileNutrientBroth.getFluid(1000))
                .inputItems(dust, CitricAcid, 1)
                .notConsumable(PlatinumMesh.get())
                .outputFluids(BioActiveNutrientSuspension.getFluid(1000))
                .duration(200).EUt(VA[IV])
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("ammonium_nitrate_synthesis")
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(NitricAcid.getFluid(1000))
                .outputItems(dust, AmmoniumNitrate, 9)
                .duration(120).EUt(VA[EV])
                .save(provider);

        MIXER_RECIPES.recipeBuilder("tier3_growth_fluid")
                .inputFluids(BioActiveNutrientSuspension.getFluid(1000))
                .inputItems(dust, Calcite, 2)
                .inputItems(dust, AmmoniumNitrate, 5)
                .outputFluids(Tier3GrowthFluid.getFluid(1000))
                .duration(160).EUt(VA[IV])
                .save(provider);

        BLAST_RECIPES.recipeBuilder("roast_molybdenum")
                .inputItems(dust, Molybdenum)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, MolybdenumTrioxide, 1)
                .outputFluids(VolatileRheniumGas.getFluid(100))
                .duration(400).EUt(VA[IV])
                .blastFurnaceTemp(5800)
                .save(provider);

        DISTILLERY_RECIPES.recipeBuilder("condense_rhenium_gas")
                .inputFluids(VolatileRheniumGas.getFluid(100))
                .inputFluids(Water.getFluid(250))
                .outputFluids(PerrhenicAcid.getFluid(250))
                .duration(100).EUt(VA[IV])
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("rhenium_from_perrhenic_acid")
                .inputFluids(PerrhenicAcid.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(5000))
                .outputItems(dust, Rhenium, 1)
                .outputFluids(Water.getFluid(2000))
                .duration(160).EUt(VA[IV])
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("glycine_synthesis")
                .inputFluids(Formaldehyde.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(CarbonMonoxide.getFluid(1000))
                .outputItems(dust, Glycine, 10)
                .duration(120)
                .EUt(VA[EV])
                .save(provider);

        MIXER_RECIPES.recipeBuilder("stabilized_bio_base")
                .inputFluids(Tier3GrowthFluid.getFluid(1000))
                .inputItems(dust, Rhenium, 1)
                .inputItems(dust, Polybenzimidazole, 2)
                .outputFluids(StabilizedBioBase.getFluid(1000))
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);

        MIXER_RECIPES.recipeBuilder("rhenium_enriched_substrate")
                .inputFluids(StabilizedBioBase.getFluid(1000))
                .inputItems(dust, Rhenium, 1)
                .inputItems(dust, Glycine, 5)
                .outputFluids(RheniumEnrichedSubstrate.getFluid(1000))
                .duration(160)
                .EUt(VA[LuV])
                .save(provider);

        MIXER_RECIPES.recipeBuilder("lumino_biotic_solution")
                .inputFluids(RheniumEnrichedSubstrate.getFluid(1000))
                .inputItems(dust, Europium, 1)
                .inputItems(dust, NitrogenTrioxide, 1)
                .outputFluids(LuminoBioticSolution.getFluid(1000))
                .duration(240)
                .EUt(VA[LuV])
                .save(provider);

        ENZYME_REACTOR_RECIPES.recipeBuilder("catalyzed_serum_base")
                .inputFluids(LuminoBioticSolution.getFluid(1000))
                .inputFluids(EnzymeSolution.getFluid(250))
                .notConsumable(OsmiridiumMesh)
                .outputFluids(CatalyzedSerumBase.getFluid(1000))
                .duration(300)
                .EUt(VA[LuV])
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("imperigen_dust_synthesis")
                .inputItems(new ItemStack(imperiumEssence, 4)) // Replace with your essence reference
                .inputFluids(Formaldehyde.getFluid(500))
                .outputItems(dust, ImperigenDust, 1)
                .outputFluids(Argon.getFluid(100))
                .duration(200)
                .EUt(VA[LuV])
                .save(provider);

        NUTRIENT_SYNTHESIZER_RECIPES.recipeBuilder("tier4_growth_fluid")
                .inputFluids(CatalyzedSerumBase.getFluid(1000))
                .inputItems(dust, ImperigenDust, 1)
                .inputItems(dust, YttriumOxide, 1)
                .notConsumable(OsmiridiumMesh)
                .outputFluids(Tier4GrowthFluid.getFluid(1000))
                .duration(400)
                .EUt(VA[LuV])
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("tzm_catalyst_synthesis")
                .inputItems(dust, TMTAlloy, 1)
                .inputFluids(NitricAcid.getFluid(500))
                .outputItems(TZMCatalyst)
                .duration(160).EUt(VA[ZPM])
                .save(provider);

        CHEMICAL_RECIPES.recipeBuilder("supregen_synthesis")
                .inputItems(supremiumEssence, 4)
                .inputFluids(FluoroantimonicAcid.getFluid(2000))
                .inputFluids(PerrhenicAcid.getFluid(1000))
                .outputItems(dust, Supregen, 4)
                .duration(200).EUt(VA[ZPM])
                .save(provider);

        MIXER_RECIPES.recipeBuilder("precursor_matrix_infusion")
                .inputFluids(Tier4GrowthFluid.getFluid(1000))
                .inputFluids(SterileGrowthMedium.getFluid(1000))
                .inputItems(dust, Naquadah, 1)
                .outputFluids(PrecursorMatrix.getFluid(1000))
                .duration(240).EUt(VA[ZPM])
                .save(provider);

        ALLOY_BLAST_RECIPES.recipeBuilder("tzm_enrichment_slurry")
                .inputItems(ingot, TMTAlloy, 6)
                .inputItems(dust, Platinum, 2)
                .inputFluids(GlucoseSolution.getFluid(1000))
                .outputFluids(EnrichedAlloySlurry.getFluid(2000))
                .blastFurnaceTemp(7000)
                .duration(300).EUt(VA[ZPM])
                .save(provider);

        MIXER_RECIPES.recipeBuilder("alloy_enriched_nutrients")
                .inputFluids(PrecursorMatrix.getFluid(1000))
                .inputFluids(EnrichedAlloySlurry.getFluid(1000))
                .outputFluids(AlloyEnrichedNutrients.getFluid(1000))
                .duration(160).EUt(VA[LuV])
                .save(provider);

        MIXER_RECIPES.recipeBuilder("plasma_nutrient_suspension")
                .inputFluids(AlloyEnrichedNutrients.getFluid(1000))
                .inputFluids(Argon.getFluid(FluidStorageKeys.PLASMA, 1000))
                .outputFluids(PlasmaNutrientSuspension.getFluid(1000))
                .duration(160).EUt(VA[LuV])
                .save(provider);

        AUTOCLAVE_RECIPES.recipeBuilder("cuprate_coating")
                .inputFluids(PlasmaNutrientSuspension.getFluid(1000))
                .inputItems(wireGtSingle, YttriumBariumCuprate, 2)
                .outputFluids(CoatedBiofluid.getFluid(1000))
                .duration(200).EUt(VA[ZPM])
                .save(provider);

        ENZYME_REACTOR_RECIPES.recipeBuilder("enzyme_bonding_phase")
                .inputFluids(CoatedBiofluid.getFluid(1000))
                .inputFluids(ProteinHydrolysate.getFluid(500))
                .inputItems(TZMCatalyst)
                .inputItems(dust, Supregen, 1)
                .outputFluids(EnzymeBondedBiofluid.getFluid(1000))
                .duration(300).EUt(VA[ZPM])
                .save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("quantum_shell_construction")
                .inputItems(rod, Osmiridium, 4)
                .inputItems(wireFine, Europium, 64)
                .inputItems(CustomTags.ZPM_CIRCUITS, 2)
                .inputItems(wireGtDouble, UraniumRhodiumDinaquadide, 16)
                .inputFluids(Helium.getFluid(FluidStorageKeys.LIQUID, 2000))
                .inputFluids(CoatedBiofluid.getFluid(1000))
                .outputItems(ingot, QuantumGrowthShell, 4)
                .duration(280).EUt(VA[ZPM])
                .save(provider);

        NUTRIENT_SYNTHESIZER_RECIPES.recipeBuilder("tier5_growth_fluid_synthesis")
                .inputItems(ingot, QuantumGrowthShell, 1)
                .inputItems(CustomTags.UV_CIRCUITS)
                .inputFluids(EnzymeBondedBiofluid.getFluid(1000))
                .notConsumable(TZMCatalyst)
                .outputFluids(Tier5GrowthFluid.getFluid(4000))
                .duration(400).EUt(VA[ZPM])
                .save(provider);
    }
}
