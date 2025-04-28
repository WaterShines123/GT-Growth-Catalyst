package com.watershines.gtgc.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.level.block.Blocks;

import com.watershines.gtgc.api.machine.multiblock.GreenhouseMultiblockMachine;
import com.watershines.gtgc.common.data.recipe.GTGCRecipeModifiers;
import com.watershines.gtgc.gtbridge.GTGCRecipeTypes;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.watershines.gtgc.GTGardenCore.REGISTRATE;
import static com.watershines.gtgc.api.pattern.GTGCPredicates.glassBlocks;
import static com.watershines.gtgc.api.pattern.GTGCPredicates.soilBlocks;

public class GTGCMachines {

    public final static MultiblockMachineDefinition GREENHOUSE_TEST = REGISTRATE
            .multiblock("greenhouse_test", GreenhouseMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTGCRecipeTypes.GREENHOUSE_TEST)
            .recipeModifier(GTGCRecipeModifiers::greenhouseOverclock)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("AAAAA", "AAAAA", "GGGGG", "GGGGG", "GGGGG", "AAAAA")
                    .aisle("AAAAA", "ABBBA", "G   G", "G   G", "G   G", "AGGGA")
                    .aisle("AAAAA", "ABWBA", "G   G", "G   G", "G   G", "AGGGA")
                    .aisle("AAAAA", "ABBBA", "G   G", "G   G", "G   G", "AGGGA")
                    .aisle("AAAAA", "AACAA", "GGGGG", "GGGGG", "GGGGG", "AAAAA")
                    .where(" ", any())
                    .where("C", controller(blocks(definition.getBlock())))
                    .where('G', glassBlocks())
                    .where('B', soilBlocks())
                    .where('W', blocks(Blocks.WATER))
                    .where('A', blocks(CASING_STEEL_SOLID.get())
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMinGlobalLimited(1)
                                    .setMaxGlobalLimited(2))
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setExactLimit(1)))
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/generator/large_gas_turbine"))
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
            })
            .register();

    public static void init() {}
}
