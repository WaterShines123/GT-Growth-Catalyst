package com.watershines.gtgc.common.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import com.blakebr0.mysticalagriculture.api.crop.Crop;

import static com.blakebr0.mysticalagriculture.lib.ModCrops.*;
import static com.watershines.gtgc.common.data.GTGCMaterials.*;

public class GTGCRecipeUtils {

    public static Material[] GrowthMediums = new Material[] { Tier1GrowthFluid, Tier2GrowthFluid, Tier3GrowthFluid,
            Tier4GrowthFluid, Tier5GrowthFluid };

    public static Crop[] Crops = new Crop[] { STONE, DIRT, WOOD, ICE, DEEPSLATE, SALTPETER,
            NATURE, DYE, NETHER, COAL, CORAL, HONEY, AMETHYST, PIG, CHICKEN, COW, SHEEP, SQUID, FISH, SLIME, TURTLE,
            BASALT, SULFUR, APATITE,

    };

    public static Item tertiumEssence = ForgeRegistries.ITEMS.getValue(
            new ResourceLocation(MysticalAgriculture.MOD_ID, "tertium_essence"));
    public static Item imperiumEssence = ForgeRegistries.ITEMS.getValue(
            new ResourceLocation(MysticalAgriculture.MOD_ID, "imperium_essence"));
    public static Item supremiumEssence = ForgeRegistries.ITEMS.getValue(
            new ResourceLocation(MysticalAgriculture.MOD_ID, "supremium_essence"));

    public static Item prosperitySeedBase = ForgeRegistries.ITEMS.getValue(
            new ResourceLocation(MysticalAgriculture.MOD_ID, "prosperity_seed_base"));
}
