package com.watershines.gtgc;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.api.sound.SoundEntry;
import com.gregtechceu.gtceu.common.data.GTBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.blakebr0.mysticalagriculture.init.ModBlocks;
import com.watershines.gtgc.api.GTGCAPI;
import com.watershines.gtgc.common.block.CatalystBlock;
import com.watershines.gtgc.common.block.GlassBlock;
import com.watershines.gtgc.common.block.SoilBlock;
import com.watershines.gtgc.common.data.GTGCBlocks;
import com.watershines.gtgc.common.data.GTGCItems;
import com.watershines.gtgc.common.data.GTGCMachines;
import com.watershines.gtgc.common.data.GTGCMaterials;
import com.watershines.gtgc.config.ConfigHandler;
import com.watershines.gtgc.data.GTGardenCoreDataGen;
import com.watershines.gtgc.gtbridge.GTGCRecipeTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GTGrowthCatalyst.MOD_ID)
public class GTGrowthCatalyst {

    public static final String MOD_ID = "gtgc";
    public static final Logger LOGGER = LogManager.getLogger();
    public static MaterialRegistry MATERIAL_REGISTRY;
    public static GTRegistrate REGISTRATE;

    public GTGrowthCatalyst() {
        REGISTRATE = GTRegistrate.create(GTGrowthCatalyst.MOD_ID);
        GTGCBlocks.init();
        GTGCItems.init();
        GTGardenCoreDataGen.init();
        ConfigHandler.init();
        REGISTRATE.registerRegistrate();

        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);
        bus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        bus.addGenericListener(MachineDefinition.class, this::registerMachines);
        bus.addGenericListener(SoundEntry.class, this::registerSounds);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Hello from common setup! This is *after* registries are done, so we can do this:");
            LOGGER.info("Look, I found a {}!", Items.DIAMOND);
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Hey, we're on Minecraft version {}!", Minecraft.getInstance().getLaunchedVersion());
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @SubscribeEvent
    public void registerMaterialRegistries(MaterialRegistryEvent event) {
        MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(GTGrowthCatalyst.MOD_ID);;
    }

    @SubscribeEvent
    public void registerMaterials(MaterialEvent event) {
        GTGCMaterials.register();
    }

    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        GTGCRecipeTypes.init();
    }

    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        registerSoilBlocks();
        GTGCMachines.init();
    }

    public void registerSounds(GTCEuAPI.RegisterEvent<ResourceLocation, SoundEntry> event) {
        // CustomSounds.init();
    }

    private static void registerSoilBlocks() {
        GTGCAPI.SOIL_BLOCKS.put(
                SoilBlock.SoilType.FARMLAND,
                () -> Blocks.FARMLAND);
        GTGCAPI.SOIL_BLOCKS.put(
                SoilBlock.SoilType.INFERIUM_FARMLAND,
                ModBlocks.INFERIUM_FARMLAND);
        GTGCAPI.SOIL_BLOCKS.put(
                SoilBlock.SoilType.PRUDENTIUM_FARMLAND,
                ModBlocks.PRUDENTIUM_FARMLAND);
        GTGCAPI.SOIL_BLOCKS.put(
                SoilBlock.SoilType.TERTIUM_FARMLAND,
                ModBlocks.TERTIUM_FARMLAND);
        GTGCAPI.SOIL_BLOCKS.put(
                SoilBlock.SoilType.IMPERIUM_FARMLAND,
                ModBlocks.IMPERIUM_FARMLAND);
        GTGCAPI.SOIL_BLOCKS.put(
                SoilBlock.SoilType.SUPREMIUM_FARMLAND,
                ModBlocks.SUPREMIUM_FARMLAND);
        GTGCAPI.GLASS_BLOCKS.put(
                GlassBlock.GlassType.GLASS,
                () -> Blocks.GLASS);
        GTGCAPI.GLASS_BLOCKS.put(
                GlassBlock.GlassType.TEMPERED_GLASS,
                GTBlocks.CASING_TEMPERED_GLASS);
        GTGCAPI.GLASS_BLOCKS.put(
                GlassBlock.GlassType.LAMINATED_GLASS,
                GTBlocks.CASING_LAMINATED_GLASS);
        GTGCAPI.CATALYST_BLOCKS.put(
                CatalystBlock.CatalystType.TIER_0,
                GTBlocks.CASING_STEEL_SOLID);
        GTGCAPI.CATALYST_BLOCKS.put(
                CatalystBlock.CatalystType.TIER_1,
                ModBlocks.INFERIUM_BLOCK);
        GTGCAPI.CATALYST_BLOCKS.put(
                CatalystBlock.CatalystType.TIER_2,
                ModBlocks.PRUDENTIUM_BLOCK);
        GTGCAPI.CATALYST_BLOCKS.put(
                CatalystBlock.CatalystType.TIER_3,
                ModBlocks.TERTIUM_BLOCK);
        GTGCAPI.CATALYST_BLOCKS.put(
                CatalystBlock.CatalystType.TIER_4,
                ModBlocks.IMPERIUM_BLOCK);
        GTGCAPI.CATALYST_BLOCKS.put(
                CatalystBlock.CatalystType.TIER_5,
                ModBlocks.SUPREMIUM_BLOCK);
    }
}
