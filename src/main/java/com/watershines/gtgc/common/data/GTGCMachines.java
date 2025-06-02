package com.watershines.gtgc.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GCYMBlocks;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;

import com.watershines.gtgc.GTGrowthCatalyst;
import com.watershines.gtgc.api.machine.multiblock.GreenhouseMultiblockMachine;
import com.watershines.gtgc.common.data.recipe.GTGCRecipeModifiers;
import com.watershines.gtgc.gtbridge.GTGCRecipeTypes;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.ITEM_IMPORT_BUS;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerSimpleMachines;
import static com.watershines.gtgc.GTGrowthCatalyst.REGISTRATE;
import static com.watershines.gtgc.api.pattern.GTGCPredicates.*;
import static com.watershines.gtgc.common.data.GTGCBlocks.CASING_STERILE_MACHINE;

public class GTGCMachines {

    public static final MachineDefinition[] BIO_REACTOR = registerSimpleMachines("bio_reactor",
            GTGCRecipeTypes.BIO_REACTOR_RECIPES);

    public static final MachineDefinition[] ENZYME_REACTOR = registerSimpleMachines("enzyme_reactor",
            GTGCRecipeTypes.ENZYME_REACTOR_RECIPES);

    public final static MultiblockMachineDefinition GREENHOUSE_TEST = REGISTRATE
            .multiblock("greenhouse_test", GreenhouseMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTGCRecipeTypes.GREENHOUSE)
            .recipeModifiers(GTGCRecipeModifiers::greenhouseOverclock)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("AAAAA", "AAAAA", "GGGGG", "GGGGG", "GGGGG", "AAAAA")
                    .aisle("ADDDA", "ABBBA", "G   G", "G   G", "G   G", "AGGGA")
                    .aisle("ADDDA", "ABWBA", "G   G", "G   G", "G   G", "AGGGA")
                    .aisle("ADDDA", "ABBBA", "G   G", "G   G", "G   G", "AGGGA")
                    .aisle("AAAAA", "AACAA", "GGGGG", "GGGGG", "GGGGG", "AAAAA")
                    .where(" ", any())
                    .where("C", controller(blocks(definition.getBlock())))
                    .where('G', glassBlocks())
                    .where('D', greenhouseCatalysts())
                    .where('B', soilBlocks())
                    .where('W', blocks(Blocks.WATER))
                    .where('A', blocks(CASING_STEEL_SOLID.get())
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1)
                                    .setMaxGlobalLimited(2))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1)
                                    .setMaxGlobalLimited(2))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(1)
                                    .setMaxGlobalLimited(2))
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMinGlobalLimited(1)
                                    .setMaxGlobalLimited(2))
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1)))
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTGrowthCatalyst.id("block/multiblock/greenhouse"))
            .additionalDisplay((controller, components) -> {
                if (controller instanceof GreenhouseMultiblockMachine greenhouseMachine && controller.isFormed()) {
                    components.add(Component.translatable("gtgc.multiblock.greenhouse_soil_tier",
                            Component
                                    .translatable(
                                            FormattingUtil
                                                    .formatNumbers(greenhouseMachine.getSoilType().getTier()))
                                    .setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
                }
                if (controller instanceof GreenhouseMultiblockMachine greenhouseMachine && controller.isFormed()) {
                    components.add(Component.translatable("gtgc.multiblock.greenhouse_glass_tier",
                            Component
                                    .translatable(
                                            FormattingUtil
                                                    .formatNumbers(greenhouseMachine.getGlassType().getTier()))
                                    .setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
                }
                if (controller instanceof GreenhouseMultiblockMachine greenhouseMachine && controller.isFormed()) {
                    components.add(Component.translatable("gtgc.multiblock.catalyst_speed_boost",
                            Component
                                    .translatable(
                                            FormattingUtil
                                                    .formatNumbers(greenhouseMachine.getAverageSpeedBoost()))
                                    .setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
                }
            })
            .register();

    public final static MultiblockMachineDefinition ALTAR = REGISTRATE
            .multiblock("multiblock_altar", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTGCRecipeTypes.MULTIBLOCK_ALTAR)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT)
            .appearanceBlock(GCYMBlocks.CASING_SHOCK_PROOF)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("############A#A############", "###########################", "###########################",
                            "###########################", "###########################", "############GRG############")
                    .aisle("###########AA#AA###########", "############AAA############", "############AAA############",
                            "############GRG############", "############GRG############", "###########G###G###########")
                    .aisle("###########################", "############AAA############", "############AAA############",
                            "############RAR############", "############RRR############", "###########R###R###########")
                    .aisle("###########AA#AA###########", "############AAA############", "############AAA############",
                            "############GIG############", "############GRG############", "###########G###G###########")
                    .aisle("############A#A############", "###########################", "###########################",
                            "###########################", "###########################", "############GRG############")
                    .aisle("###########################", "###########################", "###########################",
                            "###########################", "###########################", "###########################")
                    .aisle("###########################", "###########################", "###########################",
                            "###########################", "###########################", "###########################")
                    .aisle("###########################", "###########################", "###########################",
                            "###########################", "###########################", "###########################")
                    .aisle("###########################", "###########################", "###########################",
                            "###########################", "###########################", "###########################")
                    .aisle("###########################", "###########################", "###########################",
                            "###########################", "###########################", "###########################")
                    .aisle("##########AGEEEGA##########", "##########AGEEEGA##########", "##########AGEEEGA##########",
                            "###########################", "###########################", "###########ARRRA###########")
                    .aisle("#A#A######GAAAAAG######A#A#", "##########GAAAAAG##########", "##########GGRRRGG##########",
                            "###########################", "###########GRRRG###########", "#GRG######AG###GA######GRG#")
                    .aisle("AA#AA#####RAAAAAR#####AA#AA", "#AAA######RAAAAAR######AAA#", "#AAA######RRRRRRR######AAA#",
                            "#GRG########RRR########GRG#", "#GRG#######R###R#######GRG#", "G###G#####R#####R#####G###G")
                    .aisle("##########RAAAAAR##########", "#AAA######RAAAAAR######AAA#", "#AAA######RRRRRRR######AAA#",
                            "#RAI########RRR########IAR#", "#RRR#######R###R#######RRR#", "R###R#####R#####R#####R###R")
                    .aisle("AA#AA#####RAAAAAR#####AA#AA", "#AAA######RAAAAAR######AAA#", "#AAA######RRRRRRR######AAA#",
                            "#GRG########RRR########GRG#", "#GRG#######R###R#######GRG#", "G###G#####R#####R#####G###G")
                    .aisle("#A#A######GAAAAAG######A#A#", "##########GAAAAAG##########", "##########GGRRRGG##########",
                            "###########################", "###########GRRRG###########", "#GRG######AG###GA######GRG#")
                    .aisle("##########AGRRRGA##########", "##########AGRCRGA##########", "##########AGRRRGA##########",
                            "###########################", "###########################", "###########ARRRA###########")
                    .aisle("###########################", "###########################", "###########################",
                            "###########################", "###########################", "###########################")
                    .aisle("###########################", "###########################", "###########################",
                            "###########################", "###########################", "###########################")
                    .aisle("###########################", "###########################", "###########################",
                            "###########################", "###########################", "###########################")
                    .aisle("###########################", "###########################", "###########################",
                            "###########################", "###########################", "###########################")
                    .aisle("###########################", "###########################", "###########################",
                            "###########################", "###########################", "###########################")
                    .aisle("############A#A############", "###########################", "###########################",
                            "###########################", "###########################", "############GRG############")
                    .aisle("###########AA#AA###########", "############AAA############", "############AAA############",
                            "############GIG############", "############GRG############", "###########G###G###########")
                    .aisle("###########################", "############AAA############", "############AAA############",
                            "############RAR############", "############RRR############", "###########R###R###########")
                    .aisle("###########AA#AA###########", "############AAA############", "############AAA############",
                            "############GRG############", "############GRG############", "###########G###G###########")
                    .aisle("############A#A############", "###########################", "###########################",
                            "###########################", "###########################", "############GRG############")
                    .aisle("###########################", "###########################", "###########################",
                            "###########################", "###########################", "###########################")
                    .where("#", any())
                    .where("C", controller(blocks(definition.getBlock())))
                    .where('R', blocks(GCYMBlocks.CASING_SHOCK_PROOF.get()))
                    .where('G', blocks(GCYMBlocks.CASING_INDUSTRIAL_STEAM.get()))
                    .where('A', blocks(CASING_STEEL_SOLID.get()))
                    .where('E', blocks(GCYMBlocks.CASING_SHOCK_PROOF.get())
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setExactLimit(1)))
                    .where("I", blocks(ITEM_IMPORT_BUS[0].getBlock()))
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/gcym/shock_proof_cutting_casing"),
                    GTGrowthCatalyst.id("block/multiblock/altar"))
            .register();

    public final static MultiblockMachineDefinition NUTRIENT_SYNTHESISER = REGISTRATE
            .multiblock("nutrient_synthesiser", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTGCRecipeTypes.NUTRIENT_SYNTHESIZER_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT)
            .appearanceBlock(CASING_STERILE_MACHINE)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("AAA", "AAA", "AAA")
                    .aisle("LAL", "LPL", "LAL")
                    .aisle("AAA", "ACA", "AAA")
                    .where('L', blocks(LAMPS.get(DyeColor.LIME).get()))
                    .where('A', blocks(CASING_STERILE_MACHINE.get()).setMinGlobalLimited(9)
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMinGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1)))
                    .where('P', blocks(CASING_POLYTETRAFLUOROETHYLENE_PIPE.get()))
                    .where("C", controller(blocks(definition.getBlock())))
                    .build())
            .workableCasingRenderer(GTGrowthCatalyst.id("block/casings/sterile_machine_casing"),
                    GTCEu.id("block/multiblock/generator/large_gas_turbine"))
            .register();

    public static void init() {}
}
