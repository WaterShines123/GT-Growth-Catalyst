package com.watershines.gtgc.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import com.watershines.gtgc.common.data.materials.GTGCChemicals;

public class GTGCMaterials {

    // Liquids
    public static Material Iron3HydroxideSlurry;
    public static Material EssenceWastewater;
    public static Material MoltenGoldEssence;
    public static Material GoldRichSludge;
    public static Material NeutralizedGoldSludge;
    public static Material GoldSolution;
    public static Material SodiumSulfite;
    public static Material SodiumMetabisulfiteSolution;

    // Dusts
    public static Material HydratedIron3Hydroxide;
    public static Material Iron3Oxide;
    public static Material Iron3Sulfate;
    public static Material SodiumSulfate;
    public static Material ImpureOrganicResidue;
    public static Material SodiumMetabisulfite;

    public static void register() {
        GTGCChemicals.init();
    }
}
