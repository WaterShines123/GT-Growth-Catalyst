package com.watershines.gtgc.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import com.watershines.gtgc.common.data.materials.GTGCChemicals;
import com.watershines.gtgc.common.data.materials.GTMaterialAdjustments;

public class GTGCMaterials {

    public static Material DilutedBioSlurry;
    public static Material RawNutrientFluid;
    public static Material Tier1GrowthFluid;
    public static Material Tier2GrowthFluid;
    public static Material MineralSuspension;
    public static Material ChelatedNutrientSolution;
    public static Material FilteredGrowthPrecursor;
    public static Material CitricAcidSolution;
    public static Material GlucoseSolution;
    public static Material AmmoniumSolution;
    public static Material NitrogenRichSlurry;
    public static Material UreaSolution;
    public static Material MushroomSlurry;
    public static Material ProteinHydrolysate;
    public static Material MysticHydrolysate;
    public static Material Tier3GrowthFluid;
    public static Material SterileNutrientBroth;
    public static Material EnzymeSolution;
    public static Material BioActiveNutrientSuspension;
    public static Material VolatileRheniumGas;
    public static Material PerrhenicAcid;
    public static Material NitrogenTrioxide;
    public static Material StabilizedBioBase;
    public static Material RheniumEnrichedSubstrate;
    public static Material LuminoBioticSolution;
    public static Material CatalyzedSerumBase;
    public static Material Tier4GrowthFluid;
    public static Material PrecursorMatrix;
    public static Material EnrichedAlloySlurry;
    public static Material AlloyEnrichedNutrients;
    public static Material PlasmaNutrientSuspension;
    public static Material CoatedBiofluid;
    public static Material EnzymeBondedBiofluid;
    public static Material Tier5GrowthFluid;

    public static Material ImpureOrganicResidue;
    public static Material Urea;
    public static Material CitricAcid;
    public static Material YttriumOxide;
    public static Material AmmoniumNitrate;
    public static Material MolybdenumTrioxide;
    public static Material ImperigenDust;
    public static Material Glycine;
    public static Material QuantumGrowthShell;
    public static Material TMTAlloy;
    public static Material Supregen;

    public static void register() {
        GTMaterialAdjustments.init();
        GTGCChemicals.init();
    }
}
