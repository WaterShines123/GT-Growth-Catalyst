package com.watershines.gtgc.api.pattern;

import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.error.PatternStringError;

import com.lowdragmc.lowdraglib.utils.BlockInfo;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import com.watershines.gtgc.api.GTGCAPI;
import com.watershines.gtgc.api.block.ICatalystType;
import com.watershines.gtgc.api.block.IGlassType;
import com.watershines.gtgc.api.block.ISoilType;
import com.watershines.gtgc.api.machine.multiblock.GreenhouseMultiblockMachine;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Supplier;

import static com.watershines.gtgc.api.machine.multiblock.GreenhouseMultiblockMachine.CATALYST_HEADER;

public class GTGCPredicates {

    public static TraceabilityPredicate soilBlocks() {
        return new TraceabilityPredicate(blockWorldState -> {
            var blockState = blockWorldState.getBlockState();
            for (Map.Entry<ISoilType, Supplier<Block>> entry : GTGCAPI.SOIL_BLOCKS.entrySet()) {
                Block candidate = entry.getValue().get();
                if (blockState.is(candidate)) {
                    ISoilType stats = entry.getKey();
                    Object currentSoil = blockWorldState.getMatchContext().getOrPut("SoilType", stats);
                    if (!currentSoil.equals(stats)) {
                        blockWorldState.setError(
                                new PatternStringError("gtceu.multiblock.pattern.error.coils"));
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }, () -> GTGCAPI.SOIL_BLOCKS.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> e.getKey().getTier()))
                .map(e -> BlockInfo.fromBlockState(
                        e.getValue().get().defaultBlockState()))
                .toArray(BlockInfo[]::new))
                .addTooltips(Component.translatable("gtceu.multiblock.pattern.error.coils"));
    }

    public static TraceabilityPredicate glassBlocks() {
        return new TraceabilityPredicate(blockWorldState -> {
            var blockState = blockWorldState.getBlockState();
            for (Map.Entry<IGlassType, Supplier<Block>> entry : GTGCAPI.GLASS_BLOCKS.entrySet()) {
                Block candidate = entry.getValue().get();
                if (blockState.is(candidate)) {
                    IGlassType stats = entry.getKey();
                    Object currentSoil = blockWorldState.getMatchContext().getOrPut("GlassType", stats);
                    if (!currentSoil.equals(stats)) {
                        blockWorldState.setError(
                                new PatternStringError("gtceu.multiblock.pattern.error.coils"));
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }, () -> GTGCAPI.GLASS_BLOCKS.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> e.getKey().getTier()))
                .map(e -> BlockInfo.fromBlockState(
                        e.getValue().get().defaultBlockState()))
                .toArray(BlockInfo[]::new))
                .addTooltips(Component.translatable("gtceu.multiblock.pattern.error.coils"));
    }

    public static TraceabilityPredicate greenhouseCatalysts() {
        return new TraceabilityPredicate(blockWorldState -> {
            BlockState state = blockWorldState.getBlockState();
            for (Map.Entry<ICatalystType, Supplier<Block>> entry : GTGCAPI.CATALYST_BLOCKS.entrySet()) {
                if (state.is(entry.getValue().get())) {
                    ICatalystType catalyst = entry.getKey();
                    // Allow unfilled batteries in the structure, but do not add them to match context.
                    // This lets you use empty batteries as "filler slots" for convenience if desired.
                    if (catalyst.getTier() != -1 && catalyst.getSpeedBoost() != 0) {
                        String key = CATALYST_HEADER + catalyst.getName();
                        GreenhouseMultiblockMachine.CatalystMatchWrapper wrapper = blockWorldState.getMatchContext()
                                .get(key);
                        if (wrapper == null) wrapper = new GreenhouseMultiblockMachine.CatalystMatchWrapper(catalyst);
                        blockWorldState.getMatchContext().set(key, wrapper.increment());
                    }
                    return true;
                }
            }
            return false;
        }, () -> GTGCAPI.CATALYST_BLOCKS.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getKey().getTier()))
                .map(entry -> new BlockInfo(entry.getValue().get().defaultBlockState(), null))
                .toArray(BlockInfo[]::new))
                .addTooltips(Component.translatable("gtcgc.multiblock.pattern.error.catalysts"));
    }
}
