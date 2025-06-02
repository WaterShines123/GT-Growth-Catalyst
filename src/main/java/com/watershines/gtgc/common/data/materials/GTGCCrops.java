package com.watershines.gtgc.common.data.materials;

import net.minecraft.resources.ResourceLocation;

import com.blakebr0.mysticalagriculture.api.crop.Crop;
import com.blakebr0.mysticalagriculture.api.crop.CropTextures;
import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import com.blakebr0.mysticalagriculture.api.crop.CropType;
import com.blakebr0.mysticalagriculture.api.lib.LazyIngredient;
import com.blakebr0.mysticalagriculture.api.registry.ICropRegistry;

import static com.blakebr0.mysticalagriculture.lib.ModCrops.*;

public class GTGCCrops {

    public static final Crop MOLYBDENUM;

    public static void onRegisterCrops(ICropRegistry registry) {
        registry.register(MOLYBDENUM);
    }

    static {
        RUBBER.setEnabled(false);
        BRONZE.setEnabled(false);
        BRASS.setEnabled(false);
        GRAPHITE.setEnabled(false);
        REDSTONE_ALLOY.setEnabled(false);
        CONDUCTIVE_ALLOY.setEnabled(false);
        CONSTANTAN.setEnabled(false);
        ELECTRUM.setEnabled(false);
        INVAR.setEnabled(false);
        ROSE_GOLD.setEnabled(false);

        SALTPETER.setTier(CropTier.ONE);

        GLOWSTONE.setTier(CropTier.TWO);
        PRISMARINE.setTier(CropTier.TWO);
        RABBIT.setTier(CropTier.TWO);

        ALUMINUM.setTier(CropTier.THREE);
        SILICON.setTier(CropTier.THREE);
        LAPIS_LAZULI.setTier(CropTier.THREE);
        END.setTier(CropTier.THREE);
        BLAZE.setTier(CropTier.THREE);
        GHAST.setTier(CropTier.THREE);
        ENDERMAN.setTier(CropTier.THREE);
        NICKEL.setTier(CropTier.THREE);
        SAPPHIRE.setTier(CropTier.THREE);
        PERIDOT.setTier(CropTier.THREE);

        SILVER.setTier(CropTier.FOUR);
        DIAMOND.setTier(CropTier.FOUR);
        EMERALD.setTier(CropTier.FOUR);
        WITHER_SKELETON.setTier(CropTier.FOUR);

        TUNGSTEN.setTier(CropTier.FIVE);
        OSMIUM.setTier(CropTier.FIVE);

        MOLYBDENUM = new Crop(new ResourceLocation("gtgc", "molybdenum"),
                CropTier.THREE, CropType.RESOURCE,
                CropTextures.INGOT_CROP_TEXTURES, 11581632, LazyIngredient.tag("forge:ingots/molybdenum"));
    }
}
