package com.watershines.gtgc.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import com.watershines.gtgc.GTGardenCore;
import com.watershines.gtgc.common.data.GTGCMaterials;

public class GTGCChemicals {

    public static void init() {
        GTGCMaterials.Iron3Sulfate = new Material.Builder(GTGardenCore.id("iron3_sulfate"))
                .dust()
                .color(0xFFFF00).iconSet(MaterialIconSet.DULL)
                .formula("Fe2(SO4)3")
                .components(GTMaterials.Iron, 2, GTMaterials.Sulfur, 3, GTMaterials.Oxygen, 12)
                .buildAndRegister();

        GTGCMaterials.SodiumSulfate = new Material.Builder(GTGardenCore.id("sodium_sulfate"))
                .dust()
                .color(0xFFFFFF).iconSet(MaterialIconSet.DULL)
                .formula("Na2SO4")
                .components(GTMaterials.Sodium, 2, GTMaterials.Sulfur, 1, GTMaterials.Oxygen, 4)
                .buildAndRegister();

        GTGCMaterials.Iron3HydroxideSlurry = new Material.Builder(GTGardenCore.id("iron3_hydroxide_slurry"))
                .fluid()
                .color(0xA0522D)
                .formula("Fe(OH)3")
                .buildAndRegister();

        GTGCMaterials.EssenceWastewater = new Material.Builder(GTGardenCore.id("essence_wastewater"))
                .fluid()
                .color(0x006400)
                .formula("???")
                .buildAndRegister();

        GTGCMaterials.HydratedIron3Hydroxide = new Material.Builder(GTGardenCore.id("hydrated_iron3_hydroxide"))
                .dust()
                .color(0x8B4513).iconSet(MaterialIconSet.DULL)
                .formula("Fe(OH)3·H2O")
                .buildAndRegister();

        GTGCMaterials.Iron3Oxide = new Material.Builder(GTGardenCore.id("iron3_oxide"))
                .dust()
                .color(0xB7410E).iconSet(MaterialIconSet.DULL)
                .formula("Fe2O3")
                .buildAndRegister();

        GTGCMaterials.MoltenGoldEssence = new Material.Builder(GTGardenCore.id("molten_gold_essence"))
                .fluid()
                .color(0xFFD700)
                .buildAndRegister();

        GTGCMaterials.GoldRichSludge = new Material.Builder(GTGardenCore.id("gold_rich_sludge"))
                .fluid()
                .color(0x8B7500)
                .buildAndRegister();

        GTGCMaterials.ImpureOrganicResidue = new Material.Builder(GTGardenCore.id("impure_organic_residue"))
                .dust()
                .color(0x4B3621).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();

        GTGCMaterials.NeutralizedGoldSludge = new Material.Builder(GTGardenCore.id("neutralized_gold_sludge"))
                .fluid()
                .color(0xA67B5B)
                .formula("Au(OH)3")
                .buildAndRegister();

        GTGCMaterials.GoldSolution = new Material.Builder(GTGardenCore.id("gold_solution"))
                .fluid()
                .color(0xFFD700)
                .formula("HAuCl4")
                .buildAndRegister();

        GTGCMaterials.SodiumMetabisulfite = new Material.Builder(GTGardenCore.id("sodium_metabisulfite"))
                .dust()
                .color(0xDCDCDC)
                .iconSet(MaterialIconSet.DULL)
                .formula("Na2S2O5")
                .buildAndRegister();

        GTGCMaterials.SodiumSulfite = new Material.Builder(GTGardenCore.id("sodium_sulfite"))
                .fluid()
                .color(0xFFFFFF)
                .formula("Na2SO3")
                .buildAndRegister();

        GTGCMaterials.SodiumMetabisulfiteSolution = new Material.Builder(
                GTGardenCore.id("sodium_metabisulfite_solution"))
                .fluid()
                .color(0xFFFFCC)
                .formula("Na2S2O5")
                .buildAndRegister();
    }
}
