package com.watershines.gtgc.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;

import com.watershines.gtgc.GTGrowthCatalyst;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.watershines.gtgc.common.data.GTGCMaterials.*;

public class GTGCChemicals {

    public static void init() {
        DilutedBioSlurry = new Material.Builder(GTGrowthCatalyst.id("diluted_bio_slurry"))
                .fluid()
                .color(0x4e5e2f)
                .buildAndRegister();

        RawNutrientFluid = new Material.Builder(GTGrowthCatalyst.id("raw_nutrient_fluid"))
                .fluid()
                .color(0xb2b559)
                .buildAndRegister();

        Tier1GrowthFluid = new Material.Builder(GTGrowthCatalyst.id("tier1_growth_fluid"))
                .fluid()
                .color(0x6f7a3f)
                .buildAndRegister();

        ImpureOrganicResidue = new Material.Builder(GTGrowthCatalyst.id("impure_organic_residue"))
                .dust()
                .color(0x3a3322)
                .iconSet(MaterialIconSet.ROUGH)
                .buildAndRegister();

        Urea = new Material.Builder(GTGrowthCatalyst.id("urea"))
                .dust()
                .color(0xC2C2AA)
                .formula("CO(NH2)2")
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();

        Tier2GrowthFluid = new Material.Builder(GTGrowthCatalyst.id("tier2_growth_fluid"))
                .fluid()
                .color(0x69B452)
                .buildAndRegister();

        MineralSuspension = new Material.Builder(GTGrowthCatalyst.id("mineral_suspension"))
                .fluid()
                .color(0x4A635D)
                .buildAndRegister();

        ChelatedNutrientSolution = new Material.Builder(GTGrowthCatalyst.id("chelated_nutrient_solution"))
                .fluid()
                .color(0x9FBD8F)
                .buildAndRegister();

        FilteredGrowthPrecursor = new Material.Builder(GTGrowthCatalyst.id("filtered_growth_precursor"))
                .fluid()
                .color(0x6B995B)
                .buildAndRegister();

        GlucoseSolution = new Material.Builder(GTGrowthCatalyst.id("glucose_solution"))
                .fluid()
                .color(0xC8E4FF)
                .formula("C6H12O6")
                .buildAndRegister();

        CitricAcidSolution = new Material.Builder(GTGrowthCatalyst.id("citric_acid_solution"))
                .fluid()
                .color(0xFFE599)
                .formula("C6H8O7")
                .buildAndRegister();

        CitricAcid = new Material.Builder(GTGrowthCatalyst.id("citric_acid"))
                .dust()
                .color(0xFFFACD)
                .formula("C6H8O7")
                .iconSet(MaterialIconSet.FINE)
                .buildAndRegister();

        AmmoniumSolution = new Material.Builder(GTGrowthCatalyst.id("ammonium_solution"))
                .fluid()
                .color(0xB2D3F0)
                .formula("NH4+")
                .buildAndRegister();

        NitrogenRichSlurry = new Material.Builder(GTGrowthCatalyst.id("nitrogen_rich_slurry"))
                .fluid()
                .color(0x869B6F)
                .buildAndRegister();

        UreaSolution = new Material.Builder(GTGrowthCatalyst.id("urea_solution"))
                .fluid()
                .color(0xD6E7E4)
                .formula("CO(NH2)2")
                .buildAndRegister();

        MushroomSlurry = new Material.Builder(GTGrowthCatalyst.id("mushroom_slurry"))
                .fluid()
                .color(0x4A3E2E)
                .buildAndRegister();

        ProteinHydrolysate = new Material.Builder(GTGrowthCatalyst.id("protein_hydrolysate"))
                .fluid()
                .color(0x805E4A)
                .buildAndRegister();

        MysticHydrolysate = new Material.Builder(GTGrowthCatalyst.id("mystic_hydrolysate"))
                .fluid()
                .color(0x7E5189)
                .buildAndRegister();

        Tier3GrowthFluid = new Material.Builder(GTGrowthCatalyst.id("tier3_growth_fluid"))
                .fluid()
                .color(0x3CA370)
                .buildAndRegister();

        YttriumOxide = new Material.Builder(GTGrowthCatalyst.id("yttrium_oxide"))
                .dust()
                .color(0xCCCCFF)
                .formula("Y₂O₃")
                .iconSet(MaterialIconSet.FINE)
                .buildAndRegister();

        SterileNutrientBroth = new Material.Builder(GTGrowthCatalyst.id("sterile_nutrient_broth"))
                .fluid()
                .color(0xD6F5C9)
                .buildAndRegister();

        EnzymeSolution = new Material.Builder(GTGrowthCatalyst.id("enzyme_solution"))
                .fluid()
                .color(0xA4D7C6)
                .buildAndRegister();

        BioActiveNutrientSuspension = new Material.Builder(GTGrowthCatalyst.id("bio_active_nutrient_suspension"))
                .fluid()
                .color(0x3D916A)
                .buildAndRegister();

        AmmoniumNitrate = new Material.Builder(GTGrowthCatalyst.id("ammonium_nitrate"))
                .dust()
                .color(0xE8F0E1)
                .formula("NH₄NO₃")
                .iconSet(MaterialIconSet.FINE)
                .buildAndRegister();

        VolatileRheniumGas = new Material.Builder(GTGrowthCatalyst.id("volatile_rhenium_gas"))
                .fluid()
                .color(0xD5BFFF)
                .buildAndRegister();

        PerrhenicAcid = new Material.Builder(GTGrowthCatalyst.id("perrhenic_acid"))
                .fluid()
                .color(0xC9DEFF)
                .formula("HReO₄")
                .buildAndRegister();

        NitrogenTrioxide = new Material.Builder(GTGrowthCatalyst.id("nitrogen_trioxide"))
                .fluid()
                .color(0xC9DEFF)
                .formula("NO3")
                .buildAndRegister();

        MolybdenumTrioxide = new Material.Builder(GTGrowthCatalyst.id("molybdenum_trioxide"))
                .dust()
                .color(0xF1F1DC)
                .formula("MoO₃")
                .iconSet(MaterialIconSet.METALLIC)
                .buildAndRegister();

        Glycine = new Material.Builder(GTGrowthCatalyst.id("glycine"))
                .dust()
                .color(0xD9F1D4)
                .formula("C2H5NO2")
                .iconSet(MaterialIconSet.FINE)
                .buildAndRegister();

        StabilizedBioBase = new Material.Builder(GTGrowthCatalyst.id("stabilized_bio_base"))
                .fluid()
                .color(0x6A9F7F)
                .buildAndRegister();

        RheniumEnrichedSubstrate = new Material.Builder(GTGrowthCatalyst.id("rhenium_enriched_substrate"))
                .fluid()
                .color(0x8CA6A0)
                .buildAndRegister();

        LuminoBioticSolution = new Material.Builder(GTGrowthCatalyst.id("lumino_biotic_solution"))
                .fluid()
                .color(0xB3C7F7)
                .buildAndRegister();

        CatalyzedSerumBase = new Material.Builder(GTGrowthCatalyst.id("catalyzed_serum_base"))
                .fluid()
                .color(0x65C49B)
                .buildAndRegister();

        ImperigenDust = new Material.Builder(GTGrowthCatalyst.id("imperigen_dust"))
                .dust()
                .color(0x7B57AA)
                .iconSet(MaterialIconSet.FINE)
                .buildAndRegister();

        Tier4GrowthFluid = new Material.Builder(GTGrowthCatalyst.id("tier4_growth_fluid"))
                .fluid()
                .color(0x4C8AAE)
                .buildAndRegister();

        PrecursorMatrix = new Material.Builder(GTGrowthCatalyst.id("precursor_matrix"))
                .fluid()
                .color(0x4C997F)
                .buildAndRegister();

        EnrichedAlloySlurry = new Material.Builder(GTGrowthCatalyst.id("enriched_alloy_slurry"))
                .fluid()
                .color(0x797A7C)
                .buildAndRegister();

        AlloyEnrichedNutrients = new Material.Builder(GTGrowthCatalyst.id("alloy_enriched_nutrients"))
                .fluid()
                .color(0x7A9D8D)
                .buildAndRegister();

        PlasmaNutrientSuspension = new Material.Builder(GTGrowthCatalyst.id("plasma_nutrient_suspension"))
                .fluid()
                .color(0x6F9EAB)
                .buildAndRegister();

        CoatedBiofluid = new Material.Builder(GTGrowthCatalyst.id("coated_biofluid"))
                .fluid()
                .color(0x89C4C4)
                .buildAndRegister();

        EnzymeBondedBiofluid = new Material.Builder(GTGrowthCatalyst.id("enzyme_bonded_biofluid"))
                .fluid()
                .color(0x7FD7C6)
                .buildAndRegister();

        TMTAlloy = new Material.Builder(GTGrowthCatalyst.id("tmt_alloy"))
                .ingot().fluid()
                .color(0xA89F91)
                .components(Titanium, 1, Tungsten, 1, Molybdenum, 4)
                .blast(b -> b.temp(4200, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[LuV]))
                .iconSet(MaterialIconSet.METALLIC)
                .buildAndRegister();

        Supregen = new Material.Builder(GTGrowthCatalyst.id("supregen"))
                .dust()
                .color(0xFD5478)
                .iconSet(MaterialIconSet.FINE)
                .buildAndRegister();

        QuantumGrowthShell = new Material.Builder(GTGrowthCatalyst.id("quantum_growth_shell"))
                .ingot()
                .color(0x77BB88)
                .iconSet(MaterialIconSet.SHINY)
                .buildAndRegister();

        Tier5GrowthFluid = new Material.Builder(GTGrowthCatalyst.id("tier5_growth_fluid"))
                .fluid()
                .color(0x3AD68F)
                .buildAndRegister();
    }
}
