package com.watershines.gtgc.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import com.watershines.gtgc.common.data.materials.GTGCChemicals;

public class GTGCMaterials {

    public static Material Iron3HydroxideSlurry;
    public static Material EssenceWastewater;

    public static Material HydratedIron3Hydroxide;
    public static Material Iron3Oxide;
    public static Material Iron3Sulfate;
    public static Material SodiumSulfate;

    public static void register() {
        GTGCChemicals.init();
    }
}
