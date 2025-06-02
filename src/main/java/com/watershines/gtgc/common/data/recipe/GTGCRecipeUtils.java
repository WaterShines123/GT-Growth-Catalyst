package com.watershines.gtgc.common.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import com.blakebr0.mysticalagriculture.api.crop.Crop;

import static com.blakebr0.mysticalagriculture.lib.ModCrops.*;
import static com.watershines.gtgc.common.data.GTGCMaterials.*;
import static com.watershines.gtgc.common.data.materials.GTGCCrops.MOLYBDENUM;

public class GTGCRecipeUtils {

    public static Material[] GrowthMediums = new Material[] { Tier1GrowthFluid, Tier2GrowthFluid, Tier3GrowthFluid,
            Tier4GrowthFluid, Tier5GrowthFluid };

    public static Crop[] Crops = new Crop[] {
            STONE, DIRT, WOOD, ICE, DEEPSLATE, SALTPETER, // 1

            NATURE, DYE, NETHER, COAL, CORAL, HONEY, AMETHYST, PIG, CHICKEN, COW, SHEEP, SQUID, FISH, SLIME, TURTLE,
            BASALT, SULFUR, APATITE, PRISMARINE, RABBIT, // 2

            IRON, COPPER, NETHER_QUARTZ, REDSTONE, OBSIDIAN, ZOMBIE, SKELETON, CREEPER, SPIDER, ALUMINUM, SILICON, TIN,
            ZINC, LEAD, BLIZZ, BLITZ, BASALZ, AMETHYST_BRONZE, SLIMESTEEL, PIG_IRON, COPPER_ALLOY, MANASTEEL, STEELEAF,
            IRONWOOD, AQUAMARINE, SKY_STONE, CERTUS_QUARTZ, QUARTZ_ENRICHED_IRON, MOLYBDENUM, LAPIS_LAZULI, BLAZE,
            GHAST, ENDERMAN, NICKEL, SAPPHIRE, // 3

            SILVER, GOLD, EXPERIENCE, STEEL, MITHRIL, TITANIUM, URANIUM, CHROME, PERIDOT, SOULIUM, SIGNALUM, LUMIUM,
            FLUX_INFUSED_INGOT, HOP_GRAPHITE, COBALT, SOULARIUM, DARK_STEEL, PULSATING_ALLOY, ENERGETIC_ALLOY,
            ELEMENTIUM, FLUORITE, REFINED_GLOWSTONE, REFINED_OBSIDIAN, KNIGHTMETAL, FIERY_INGOT, STARMETAL,
            COMPRESSED_IRON, FLUIX, ENERGIZED_STEEL, BLAZING_CRYSTAL, DIAMOND, WITHER_SKELETON, // 4

            TUNGSTEN, OSMIUM, NETHERITE, PLATINUM, IRIDIUM, ENDERIUM, FLUX_INFUSED_GEM, MANYULLYN, QUEENS_SLIME,
            HEPATIZON, VIBRANT_ALLOY, END_STEEL, TERRASTEEL, ROCK_CRYSTAL, DRACONIUM, YELLORIUM, CYANITE,
            NIOTIC_CRYSTAL, SPIRITED_CRYSTAL, URANINITE // 5
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
